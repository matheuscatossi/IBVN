package com.project.impacta.ibvn;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.cast.CastRemoteDisplayLocalService;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;
import com.project.impacta.ibvn.Utils.Constants;
import com.project.impacta.ibvn.handler.DatabaseHandlerLogin;
import com.project.impacta.ibvn.helper.CarregarEnderecoTask;
import com.project.impacta.ibvn.helper.DatePickerFragment;
import com.project.impacta.ibvn.helper.FormularioManterReuniaoHelper;
import com.project.impacta.ibvn.model.Celula;
import com.project.impacta.ibvn.model.Login;
import com.project.impacta.ibvn.model.Membro;
import com.project.impacta.ibvn.model.Reuniao;
import com.project.impacta.ibvn.service.MyFirebaseMessagingService;
import com.project.impacta.ibvn.webservice.APIClient;
import com.project.impacta.ibvn.webservice.APIInterface;
import com.project.impacta.ibvn.webservice.FirebaseAPI;
import com.project.impacta.ibvn.webservice.NotifyData;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import android.util.Base64;
import android.view.View;
import android.widget.EditText;


public class ManterReuniaoActivity extends AppCompatActivity {

    EditText data;
    private FormularioManterReuniaoHelper helperFormManterReuniao;
    private Celula celula;
    private Reuniao reuniao;
    private Button buscar;
    Toolbar toolbar;

    private Call<Reuniao> callReuniao;
    private DatabaseHandlerLogin dbLogin;
    private ProgressDialog progress;
    private String reuniao_id;
    private APIInterface apiService;

    private String HubEndpoint = null;
    private String HubSasKeyName = null;
    private String HubSasKeyValue = null;


    private void ParseConnectionString(String connectionString) {
        String[] parts = connectionString.split(";");
        if (parts.length != 3)
            throw new RuntimeException("Error parsing connection string: "
                    + connectionString);

        for (int i = 0; i < parts.length; i++) {
            if (parts[i].startsWith("Endpoint")) {
                this.HubEndpoint = "https" + parts[i].substring(11);
            } else if (parts[i].startsWith("SharedAccessKeyName")) {
                this.HubSasKeyName = parts[i].substring(20);
            } else if (parts[i].startsWith("SharedAccessKey")) {
                this.HubSasKeyValue = parts[i].substring(16);
            }
        }
    }


    private String generateSasToken(String uri) {

        String targetUri;
        String token = null;
        try {
            targetUri = URLEncoder
                    .encode(uri.toString().toLowerCase(), "UTF-8")
                    .toLowerCase();

            long expiresOnDate = System.currentTimeMillis();
            int expiresInMins = 60; // 1 hour
            expiresOnDate += expiresInMins * 60 * 1000;
            long expires = expiresOnDate / 1000;
            String toSign = targetUri + "\n" + expires;

            // Get an hmac_sha1 key from the raw key bytes
            byte[] keyBytes = HubSasKeyValue.getBytes("UTF-8");
            SecretKeySpec signingKey = new SecretKeySpec(keyBytes, "HmacSHA256");

            // Get an hmac_sha1 Mac instance and initialize with the signing key
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(signingKey);

            // Compute the hmac on input data bytes
            byte[] rawHmac = mac.doFinal(toSign.getBytes("UTF-8"));

            // Using android.util.Base64 for Android Studio instead of
            // Apache commons codec
            String signature = URLEncoder.encode(
                    Base64.encodeToString(rawHmac, Base64.NO_WRAP).toString(), "UTF-8");

            // Construct authorization string
            token = "SharedAccessSignature sr=" + targetUri + "&sig="
                    + signature + "&se=" + expires + "&skn=" + HubSasKeyName;
        } catch (Exception e) {
            /*if (isVisible) {
                ToastNotify("Exception Generating SaS : " + e.getMessage().toString());
            }*/
        }

        return token;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manter_reuniao);

        //Header
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        helperFormManterReuniao = new FormularioManterReuniaoHelper(this);
        Intent intent = getIntent();

        reuniao_id = intent.getStringExtra("REUNIAO_ID");


        //Editando
        if (reuniao_id != null) {

            getSupportActionBar().setTitle("Editando Reunião");

            progress = new ProgressDialog(this);
            progress.setMessage("Recuperando informações!");
            progress.show();

            apiService = APIClient.getService().create(APIInterface.class);
            callReuniao = apiService.getReunioesByID(reuniao_id);

            callReuniao.enqueue(new Callback<Reuniao>() {
                @Override
                public void onResponse(Call<Reuniao> call, Response<Reuniao> response) {
                    if (response.raw().code() == 200) {

                        helperFormManterReuniao.setReuniaoFromModel(response.body());
                        progress.dismiss();
                    }
                }

                @Override
                public void onFailure(Call<Reuniao> call, Throwable t) {
                    progress.dismiss();
                    Log.e("INFOREUNIAO", t.toString());
                }
            });

        } else { //criando
            getSupportActionBar().setTitle("Adicionando Reunião");
        }


        //Mostra calendário ao ganhar o focus e set o próximo controle que irá receber o focus
        data = (EditText) findViewById(R.id.et_manter_reuniao_data);
        data.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus) {
                    DialogFragment newFragment = new DatePickerFragment(data, helperFormManterReuniao.getCampoCep());
                    newFragment.show(getSupportFragmentManager(), "datePicker");
                }
            }
        });


        //Busca de CEP
        final EditText et_cep = (EditText) findViewById(R.id.et_manter_reuniao_cep);
        buscar = (Button) findViewById(R.id.btn_manter_reuniao_buscar_cep);
        buscar.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {


                                          //Busca dados do endereço a partir do CEP e carrega os campos do formulário
                                          CarregarEnderecoTask task = new CarregarEnderecoTask(
                                                  et_cep.getText().toString(),
                                                  helperFormManterReuniao.getCampoCep(),
                                                  helperFormManterReuniao.getCampoCidade(),
                                                  helperFormManterReuniao.getCampoBairro(),
                                                  helperFormManterReuniao.getCampoLogradouro(),
                                                  helperFormManterReuniao.getCampoUF(),
                                                  helperFormManterReuniao.getCampoNumero(),
                                                  helperFormManterReuniao.getCampoLatitude(),
                                                  helperFormManterReuniao.getCampoLongitude(),
                                                  ManterReuniaoActivity.this
                                          );
                                          task.execute();

                                      }
                                  }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_manter_reuniao, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        dbLogin = new DatabaseHandlerLogin(ManterReuniaoActivity.this);
        Intent i;

        switch (item.getItemId()) {

            case R.id.menu_manter_reuniao_salvar_ok:

                progress = new ProgressDialog(ManterReuniaoActivity.this);
                progress.setMessage("Registrando Reunião");
                progress.show();


                Reuniao reuniao = null;
                try {
                    reuniao = helperFormManterReuniao.getReuniaoFromData();
                } catch (Exception e) {
                    Toast.makeText(ManterReuniaoActivity.this, "Verificar o preenchimento de todos os campos!", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                    progress.dismiss();
                    return false;
                }
                Membro lider = new Membro();

                //recupera dados do usuário logado.
                List<Login> logins = dbLogin.getAllLogins();
                if (logins != null) {
                    for (Login lg : logins) {
                        lider.setId(lg.getId());
                        lider.setFk_celula(Integer.parseInt(lg.getCelula()));
                        reuniao.setFk_celula(Integer.parseInt(lg.getCelula()));
                    }
                }

                apiService = APIClient.getService().create(APIInterface.class);

                if (reuniao.getId() > 0) {
                    callReuniao = apiService.postReunioesUpdate(Long.toString(reuniao.getId()), reuniao);
                } else {
                    callReuniao = apiService.postReunioes(reuniao);
                }

                callReuniao.enqueue(new Callback<Reuniao>() {

                    @Override
                    public void onResponse(Call<Reuniao> call, Response<Reuniao> response) {
                        if (response.raw().code() == 200) {
                            Reuniao t = response.body();
                            Log.e("INFOREUNIAO", "" + response.raw().body().toString());
                            Toast.makeText(ManterReuniaoActivity.this, "Reunião " + t.getTema() + " salva!", Toast.LENGTH_LONG).show();

                            FirebaseMessaging fm = FirebaseMessaging.getInstance();
                            fm.send(new RemoteMessage.Builder("ibvn-gestao-de-eventos@gcm.googleapis.com")
                                    .setMessageId(Long.toString(2))
                                    .addData("my_message", "Hello World")
                                    .addData("my_action", "SAY_HELLO")
                                    .build());
                        }
                    }

                    @Override
                    public void onFailure(Call<Reuniao> call, Throwable t) {
                        Log.e("INFOREUNIAO", t.toString());
                        Toast.makeText(ManterReuniaoActivity.this, "Ocorreram problemas ao tentar registrar a Reunião", Toast.LENGTH_LONG).show();
                    }
                });

                progress.dismiss();

               i = new Intent(ManterReuniaoActivity.this, MainActivity.class);
                startActivity(i);
                finish();

                break;
            case android.R.id.home:
                i = new Intent(ManterReuniaoActivity.this, MainActivity.class);
                startActivity(i);
                finish();
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        Intent i = new Intent(ManterReuniaoActivity.this,MainActivity.class);
        startActivity(i);
        finish();
        super.onBackPressed();
    }




}

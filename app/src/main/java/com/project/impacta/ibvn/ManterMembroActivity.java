package com.project.impacta.ibvn;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.project.impacta.ibvn.Utils.Constants;
import com.project.impacta.ibvn.handler.DatabaseHandlerLogin;
import com.project.impacta.ibvn.helper.CarregarEnderecoTask;
import com.project.impacta.ibvn.helper.DatePickerFragment;
import com.project.impacta.ibvn.helper.FormularioManterMembroHelper;
import com.project.impacta.ibvn.model.Celula;
import com.project.impacta.ibvn.model.Login;
import com.project.impacta.ibvn.model.Membro;
import com.project.impacta.ibvn.service.FirebaseIDService;
import com.project.impacta.ibvn.service.MyFirebaseMessagingService;
import com.project.impacta.ibvn.webservice.APIClient;
import com.project.impacta.ibvn.webservice.APIInterface;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManterMembroActivity extends AppCompatActivity {

    private Button buscar;
    private FormularioManterMembroHelper helperFormManterMembro;
    private EditText data;
    ProgressDialog progress;
    Call<Membro> callMembro;

    private String codigo_membro;
    private APIInterface apiService;
    private Call<Membro> call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manter_membro);

        Intent intent = getIntent();
        codigo_membro = intent.getStringExtra("MEMBRO");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        helperFormManterMembro = new FormularioManterMembroHelper(this);


        //Editando
        if (codigo_membro != null) {

            getSupportActionBar().setTitle("Editando Membro");

            progress = new ProgressDialog(this);
            progress.setMessage("Recuperando informações!");
            progress.show();

            apiService = APIClient.getService().create(APIInterface.class);
            call = apiService.getMembrosByID(codigo_membro);

            call.enqueue(new Callback<Membro>() {
                @Override
                public void onResponse(Call<Membro> call, Response<Membro> response) {
                    if (response.raw().code() == 200) {

                        helperFormManterMembro.setMembroFromModel(response.body());
                        progress.dismiss();
                    }
                }

                @Override
                public void onFailure(Call<Membro> call, Throwable t) {
                    progress.dismiss();
                    Log.e("INFOMEMBRO", t.toString());
                }
            });

        } else { //criando
            getSupportActionBar().setTitle("Adicionando Membro");
        }


        //Mostra calendário ao ganhar o focus e set o próximo controle que irá receber o focus
        data = (EditText) findViewById(R.id.et_manter_membro_data_nascimento);
        data.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    DialogFragment newFragment = new DatePickerFragment(data, helperFormManterMembro.getCampoEmail());
                    newFragment.show(getSupportFragmentManager(), "datePicker");
                }
            }
        });


        final EditText et_cep = (EditText) findViewById(R.id.et_manter_membro_cep);
        buscar = (Button) findViewById(R.id.btn_manter_membro_buscar_cep);


        buscar.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {

                                          //Busca dados do endereço a partir do CEP e carrega os campos do formulário
                                          CarregarEnderecoTask task = new CarregarEnderecoTask(
                                                  et_cep.getText().toString(),
                                                  helperFormManterMembro.getCampoCep(),
                                                  helperFormManterMembro.getCampoCidade(),
                                                  helperFormManterMembro.getCampoBairro(),
                                                  helperFormManterMembro.getCampoLogradouro(),
                                                  helperFormManterMembro.getCampoEstado(),
                                                  helperFormManterMembro.getCampoNumero(),
                                                  helperFormManterMembro.getCampoLatitude(),
                                                  helperFormManterMembro.getCampoLongitude(),
                                                  ManterMembroActivity.this
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

        DatabaseHandlerLogin dbLogin = new DatabaseHandlerLogin(ManterMembroActivity.this);

        switch (item.getItemId()) {
            case R.id.menu_manter_reuniao_salvar_ok:

                Membro membro = helperFormManterMembro.getMembroFromData();
                membro.setTipo("membro");
                membro.setComplemento("Faculdade Impacta");
                membro.setLatitude("0");
                membro.setLongitude("0");
                membro.setEstado_civil("solteiro");

                Membro lider = new Membro();
                Celula cel = new Celula();

                //recupera dados do usuário logado.
                List<Login> logins = dbLogin.getAllLogins();
                if (logins != null) {
                    for (Login lg : logins) {
                        Constants.ID = lg.getId();
                        membro.setFk_celula(Integer.parseInt(lg.getCelula()));
                        lider.setId(lg.getId());
                        cel.setId(Integer.parseInt(lg.getCelula()));
                    }
                }

                membro.setCelula(cel);

                APIInterface apiService = APIClient.getService().create(APIInterface.class);

                if (membro.getId() > 0) {
                    callMembro = apiService.postMembrosUpdate(Integer.toString(membro.getId()), membro);
                } else {
                    callMembro = apiService.postMembros(membro);
                }

                callMembro.enqueue(new Callback<Membro>() {

                    @Override
                    public void onResponse(Call<Membro> call, Response<Membro> response) {
                        if (response.raw().code() == 200) {
                            Membro t = response.body();
                            Log.e("INFOMEMBRO", "" + response.raw().body().toString());
                            Toast.makeText(ManterMembroActivity.this, "Membro " + t.getNome() + " salvo!", Toast.LENGTH_LONG).show();
                            finish();

                        }
                    }

                    @Override
                    public void onFailure(Call<Membro> call, Throwable t) {
                        Log.e("INFOMEMBRO", t.toString());
                        Toast.makeText(ManterMembroActivity.this, "Ocorreram problemas ao tentar registar o membro!", Toast.LENGTH_LONG).show();
                        finish();
                    }

                });

                break;
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}

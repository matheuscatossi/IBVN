package com.project.impacta.ibvn;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.project.impacta.ibvn.model.Membro;
import com.project.impacta.ibvn.model.Mensagem;
import com.project.impacta.ibvn.webservice.APIClient;
import com.project.impacta.ibvn.webservice.APIInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Matheus on 19/02/2017.
 */

public class MensagemActivity extends AppCompatActivity {

    private EditText et_nome;
    private EditText et_telefone;
    private EditText et_email;
    private EditText et_mensagem;
    private Button btn_enviar;
    private Call<Mensagem> callMensagem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagem);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Drawable drawableAux = getResources().getDrawable(R.drawable.back);
        Bitmap bitmap = ((BitmapDrawable) drawableAux).getBitmap();
        Drawable drawable = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, 35, 35, true));
        toolbar.setNavigationIcon(drawable);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        et_nome = (EditText) findViewById(R.id.et_nome);
        et_telefone = (EditText) findViewById(R.id.et_telefone);
        et_email = (EditText) findViewById(R.id.et_email);
        et_mensagem = (EditText) findViewById(R.id.et_mensagem);
        btn_enviar = (Button) findViewById(R.id.btn_enviar);

        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = et_nome.getText().toString();
                String telefone = et_telefone.getText().toString();
                String email = et_email.getText().toString();
                String mensagem = et_mensagem.getText().toString();

                Mensagem mensagemPost = new Mensagem(nome, mensagem, telefone, email);

                APIInterface apiService = APIClient.getService().create(APIInterface.class);
                callMensagem = apiService.postMensagem(mensagemPost);


                callMensagem.enqueue(new Callback<Mensagem>() {

                    @Override
                    public void onResponse(Call<Mensagem> call, Response<Mensagem> response) {
                        if (response.raw().code() == 200) {
                            Mensagem t = response.body();
                            Log.e("MENSAGEM", "" + t.getId());

                            Toast.makeText(MensagemActivity.this.getBaseContext(), "Mensagem enviada com sucesso", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<Mensagem> call, Throwable t) {
                        Log.e("MENSAGEM", t.toString());
                    }

                });

            }
        });

    }

    protected void onResume() {
        super.onResume();
    }


}

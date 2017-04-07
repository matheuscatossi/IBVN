package com.project.impacta.ibvn;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.impacta.ibvn.Utils.Constants;
import com.project.impacta.ibvn.adapter.MembroCustomAdapter;
import com.project.impacta.ibvn.model.MembroModel;
import com.project.impacta.ibvn.webservice.APIClient;
import com.project.impacta.ibvn.webservice.APIInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Matheus on 12/02/2017.
 */

public class InfoMembroActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Call<MembroModel> call;
    APIInterface apiService;

    // Elemtentos View
    TextView tv_nome;
    TextView tv_cpf;
    TextView tv_estado_civil;
    TextView tv_dt_nasc;
    TextView tv_email;
    TextView tv_tipo;
    TextView tv_telefone;
    TextView tv_celular;
    TextView tv_cep;
    TextView tv_logradouro;
    TextView tv_numero;
    TextView tv_complemento;
    TextView tv_bairro;
    TextView tv_cidade;
    TextView tv_estado;
    TextView tv_latitude;
    TextView tv_logitude;
    ImageView img_user;

    ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_membro);

        progress = ProgressDialog.show(this, "Carregando", "Buscando informações", true);
        Intent myIntent     = getIntent();

        String codigoMembro = myIntent.getStringExtra("codigoMembro");

        apiService = APIClient.getService().create(APIInterface.class);
        call = apiService.getMembrosByID(codigoMembro);

        call.enqueue(new Callback<MembroModel>() {
            @Override
            public void onResponse(Call<MembroModel> call, Response<MembroModel> response) {
                if (response.raw().code() == 200) {

                    int id  = response.body().getId();
                    int fk_celula  = response.body().getFk_celula();
                    String nome  = response.body().getNome();
                    String sexo  = response.body().getSexo();
                    String cpf  = response.body().getCpf();
                    String estado_civil  = response.body().getEstado_civil();
                    String dt_nasc  = response.body().getDt_nasc();
                    String email  = response.body().getEmail();
                    String tipo  = response.body().getTipo();
                    String telefone  = response.body().getTelefone();
                    String celular  = response.body().getCelular();
                    String cep  = response.body().getCep();
                    String logradouro  = response.body().getLogradouro();
                    String numero  = response.body().getNumero();
                    String complemento  = response.body().getComplemento();
                    String bairro  = response.body().getBairro();
                    String cidade  = response.body().getCidade();
                    String estado  = response.body().getEstado();
                    String latitude  = response.body().getLatitude();
                    String logitude  = response.body().getLogitude();

                    tv_nome = (TextView) findViewById(R.id.tv_nome);
                    tv_nome.setText("" + nome);

                    tv_cpf = (TextView) findViewById(R.id.tv_cpf);
                    tv_cpf.setText("" + cpf);

                    // tv_estado_civil = (TextView) findViewById(R.id.tv_estado_civil);
                    // tv_estado_civil.setText("" + estado_civil);

                    // tv_dt_nasc = (TextView) findViewById(R.id.tv_data);
                    // tv_dt_nasc.setText("" + dt_nasc);

                    tv_email = (TextView) findViewById(R.id.tv_email);
                    tv_email.setText("" + email);

                    tv_tipo = (TextView) findViewById(R.id.tv_tipo);
                    if (tipo.equals("M")) {
                        tv_tipo.setText("FIEL");
                    } else {
                        tv_tipo.setText("LIDER");
                    }

                    tv_telefone = (TextView) findViewById(R.id.tv_telefone);
                    tv_telefone.setText("" + telefone);

                    tv_celular = (TextView) findViewById(R.id.tv_celular);
                    tv_celular.setText("" + celular);

                    tv_cep = (TextView) findViewById(R.id.tv_cep);
                    tv_cep.setText("" + cep);

                    tv_logradouro = (TextView) findViewById(R.id.tv_logradouro);
                    tv_logradouro.setText("" + logradouro);

                    tv_numero = (TextView) findViewById(R.id.tv_numero);
                    tv_numero.setText("" + numero);

                    tv_complemento = (TextView) findViewById(R.id.tv_complemento);
                    tv_complemento.setText("" + complemento);

                    tv_bairro = (TextView) findViewById(R.id.tv_bairro);
                    tv_bairro.setText("" + bairro);

                    tv_cidade = (TextView) findViewById(R.id.tv_cidade);
                    tv_cidade.setText("" + cidade);

                    //  tv_estado = (TextView) findViewById(R.id.tv_estado);
                    //  tv_estado.setText("" + estado);

                    img_user = (ImageView) findViewById(R.id.img_user);
                    if (sexo.equals("M")) {
                        img_user.setImageResource(R.drawable.user_m);
                    } else {
                        img_user.setImageResource(R.drawable.user_f);
                    }

                    progress.dismiss();
                }
            }

            @Override
            public void onFailure(Call<MembroModel> call, Throwable t) {
                progress.dismiss();
                Log.e("INFOMEMBRO", t.toString());
            }
        });

        FloatingActionButton fabEditar = (FloatingActionButton) findViewById(R.id.fabEditar);
        fabEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Editar membro - Feature em desenvolvimento", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Drawable drawableAux = getResources().getDrawable(R.drawable.back);
        Bitmap bitmap = ((BitmapDrawable) drawableAux).getBitmap();
        Drawable drawable = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, 40, 40, true));
        toolbar.setNavigationIcon(drawable);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        //if (id == R.id.sobre) {
        //  Intent i = new Intent(this, ContatoActivity.class);
        //  startActivity(i);
        //}

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.sugestoes) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

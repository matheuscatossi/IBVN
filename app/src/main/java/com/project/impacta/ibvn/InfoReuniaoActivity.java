package com.project.impacta.ibvn;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.api.client.repackaged.com.google.common.base.Converter;
import com.project.impacta.ibvn.helper.GPSTracker;
import com.project.impacta.ibvn.model.MembroModel;
import com.project.impacta.ibvn.model.ReuniaoModel;
import com.project.impacta.ibvn.webservice.APIClient;
import com.project.impacta.ibvn.webservice.APIInterface;

import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfoReuniaoActivity extends AppCompatActivity {
    private GoogleApiClient mGoogleApiClient;

    GPSTracker gps;
    Call<ReuniaoModel> call;
    APIInterface apiService;
    ProgressDialog progress;
    Double latitudeReuniao, longitudeReuniao;

    TextView tv_info_celula, tv_info_criado_em, tv_info_criado_por, tv_info_data, tv_info_descricao, tv_info_bairro, tv_info_cep, tv_info_cidade, tv_info_lider, tv_info_logradouro, tv_info_tema;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_reuniao);

        getSupportActionBar().setTitle("Dados da reunião");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        progress = ProgressDialog.show(this, "Carregando", "Buscando informações", true);

        setControls();

        Intent myIntent = getIntent();
        String codigo = myIntent.getStringExtra("Id");

        apiService = APIClient.getService().create(APIInterface.class);
        call = apiService.getReunioesByID(codigo);

        call.enqueue(new Callback<ReuniaoModel>() {
            @Override
            public void onResponse(Call<ReuniaoModel> call, Response<ReuniaoModel> response) {
                if (response.raw().code() == 200) {

                    preencherDadosReuniao(response.body());
                    progress.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ReuniaoModel> call, Throwable t) {
                Log.e("INFOMEMBRO", t.toString());
                progress.dismiss();
            }
        });


        ImageView img_reuniao = (ImageView) findViewById(R.id.img_info_reuniao);
        img_reuniao.setImageResource(R.drawable.reuniao_1);

        ImageView iv_map_reuniao = (ImageView) findViewById(R.id.info_reuniao_iv_map);

        iv_map_reuniao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double latitude = 0, longitude = 0;

                try {

                    gps = new GPSTracker(InfoReuniaoActivity.this);

                    if (gps.canGetLocation()) {
                        latitude = gps.getLatitude();
                        longitude = gps.getLongitude();
                    } else {
                        gps.showSettingsAlert();
                    }

                    String uri = String.format(Locale.ROOT, "http://maps.google.com/maps?saddr=%f,%f&daddr=%f,%f", latitude, longitude, latitudeReuniao, longitudeReuniao);
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                    startActivity(intent);

                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        });


        FloatingActionButton fabMembroReuniao = (FloatingActionButton) findViewById(R.id.fabMembroReuniao);

        fabMembroReuniao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), MembroReuniaoActivity.class);
                startActivity(i);
            }
        });

    }


    private void setControls() {

        tv_info_tema = (TextView) findViewById(R.id.tv_info_reuniao_tema);
        tv_info_data = (TextView) findViewById(R.id.tv_info_reuniao_data);
        tv_info_celula = (TextView) findViewById(R.id.tv_info_reuniao_celula);
        tv_info_logradouro = (TextView) findViewById(R.id.tv_info_reuniao_logradouro);
        tv_info_bairro = (TextView) findViewById(R.id.tv_info_reuniao_endereco_bairro);
        tv_info_cidade = (TextView) findViewById(R.id.tv_info_reuniao_endereco_cidade);
        tv_info_cep = (TextView) findViewById(R.id.tv_info_reuniao_endereco_cep);
        tv_info_descricao = (TextView) findViewById(R.id.tv_info_reuniao_descricao);
        tv_info_criado_em = (TextView) findViewById(R.id.tv_info_reuniao_criado_em);
        tv_info_criado_por = (TextView) findViewById(R.id.tv_info_reuniao_criado_por);
        tv_info_lider = (TextView) findViewById(R.id.tv_info_reuniao_lider);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // getMenuInflater().inflate(R.menu.menu_manter_reuniao, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    private void preencherDadosReuniao(ReuniaoModel body) {

        this.tv_info_tema.setText(body.getTema());
        this.tv_info_data.setText(body.getData().substring(8) + "/" + body.getData().substring(5, 7) + "/" + body.getData().substring(0, 4));
        this.tv_info_celula.setText(body.getCelulaReuniao().getDescricao());

        this.tv_info_logradouro.setText(body.getLogradouro() + ", " + body.getNumero());
        this.tv_info_bairro.setText(body.getBairro());
        this.tv_info_cidade.setText(body.getCidade() + " - " + body.getUf());
        this.tv_info_cep.setText(body.getCep());
        this.tv_info_descricao.setText(body.getDescricao());

        latitudeReuniao = Double.parseDouble(body.getLatitude());
        longitudeReuniao = Double.parseDouble(body.getLongitude());
    }


}

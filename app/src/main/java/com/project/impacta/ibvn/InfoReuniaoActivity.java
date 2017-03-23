package com.project.impacta.ibvn;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
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

    TextView tv_info_reuniao, tv_info_criado_em, tv_info_criado_por, tv_info_data, tv_info_descricao, tv_info_bairro, tv_info_cep, tv_info_cidade, tv_info_lider, tv_info_logradouro, tv_info_tema;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_reuniao);
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

                    String cep = response.body().getCep();
                    String logradouro = response.body().getLogradouro();
                    String numero = response.body().getNumero();
                    String complemento = response.body().getComplemento();
                    String bairro = response.body().getBairro();
                    String cidade = response.body().getCidade();
                    String latitude = response.body().getLatitude();
                    progress.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ReuniaoModel> call, Throwable t) {
                Log.e("INFOMEMBRO", t.toString());
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

                    String uri = String.format(Locale.ROOT, "http://maps.google.com/maps?saddr=%f,%f&daddr=%f,%f", latitude, longitude, latitude + 2, longitude + 3);
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
        tv_info_reuniao = (TextView) findViewById(R.id.tv_info_reuniao_celula);
        tv_info_criado_em = (TextView) findViewById(R.id.tv_info_reuniao_criado_em);
        tv_info_criado_por = (TextView) findViewById(R.id.tv_info_reuniao_criado_por);
        tv_info_data = (TextView) findViewById(R.id.tv_info_reuniao_data);
        tv_info_descricao = (TextView) findViewById(R.id.tv_info_reuniao_descricao);
        tv_info_bairro = (TextView) findViewById(R.id.tv_info_reuniao_endereco_bairro);
        tv_info_cep = (TextView) findViewById(R.id.tv_info_reuniao_endereco_cep);
        tv_info_cidade = (TextView) findViewById(R.id.tv_info_reuniao_endereco_cidade);
        tv_info_lider = (TextView) findViewById(R.id.tv_info_reuniao_lider);
        tv_info_logradouro = (TextView) findViewById(R.id.tv_info_reuniao_logradouro);
        tv_info_tema = (TextView) findViewById(R.id.tv_info_reuniao_tema);
    }


}

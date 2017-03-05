package com.project.impacta.ibvn;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Locale;

public class InfoReuniaoActivity extends AppCompatActivity {
    private GoogleApiClient mGoogleApiClient;

    GPSTracker gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_reuniao);

        Intent myIntent = getIntent();

        String codigo = myIntent.getStringExtra("codigo");

        String tema = myIntent.getStringExtra("tema");
        String data = myIntent.getStringExtra("data");
        String lider = myIntent.getStringExtra("lider");
        String endereco = myIntent.getStringExtra("endereco");
        String lider_email = myIntent.getStringExtra("lider_email");
        String agendado_por = myIntent.getStringExtra("agendado_por");

        ImageView img_reuniao = (ImageView) findViewById(R.id.img_reuniao);
        img_reuniao.setImageResource(R.drawable.reuniao_1);

        TextView tv_tema = (TextView) findViewById(R.id.tv_tema);
        tv_tema.setText(tema);

        TextView tv_data = (TextView) findViewById(R.id.tv_data);
        tv_data.setText(data);

        TextView tv_endereco = (TextView) findViewById(R.id.info_reuniao_tv_endereco_rua);
        tv_endereco.setText(endereco);

//        TextView tv_lider = (TextView) findViewById(R.id.tv_lider);
//        tv_lider.setText(lider);
//
//        TextView tv_agendado_por = (TextView) findViewById(R.id.agendado_por);
//        tv_agendado_por.setText(agendado_por);


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


}

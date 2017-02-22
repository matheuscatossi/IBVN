package com.project.impacta.ibvn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoReuniaoActivity extends AppCompatActivity {

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
    }


}

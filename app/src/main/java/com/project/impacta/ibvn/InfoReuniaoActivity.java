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


        Intent myIntent     = getIntent();
        String codigo       = myIntent.getStringExtra("codigo");
        String tema       = myIntent.getStringExtra("tema");
        String data       = myIntent.getStringExtra("data");
/*        String codigoLider  = myIntent.getStringExtra("codigoLider");
        String cpf          = myIntent.getStringExtra("cpf");
        String nome         = myIntent.getStringExtra("nome");
        String endereco     = myIntent.getStringExtra("endereco");
        String email        = myIntent.getStringExtra("email");
        String tipo         = myIntent.getStringExtra("tipo");
        String sexo         = myIntent.getStringExtra("sexo");*/

        ImageView img_reuniao = (ImageView) findViewById(R.id.img_reuniao);

        TextView tv_tema = (TextView) findViewById(R.id.tv_tema);
        tv_tema.setText(tema);

        TextView tv_data = (TextView) findViewById(R.id.tv_data);
        tv_data.setText(data);
/*
        TextView tv_codigo = (TextView) findViewById(R.id.codigo);
        tv_codigo.setText("x"+ codigo);

        TextView tv_celula = (TextView) findViewById(R.id.celula);
        tv_celula.setText(celula);

        TextView tv_codigo_lider = (TextView) findViewById(R.id.codigoLider);
        tv_codigo_lider.setText(codigoLider);*/

/*        TextView tv_cpf = (TextView) findViewById(R.id.cpf);
        tv_cpf.setText(cpf);

        TextView tv_tipo = (TextView) findViewById(R.id.tipo);
        tv_tipo.setText(tipo);

        TextView tv_sexo = (TextView) findViewById(R.id.sexo);
        tv_sexo.setText("x"+sexo+"x");*/
    }
}

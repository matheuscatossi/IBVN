package com.project.impacta.ibvn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InfoMembroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_membro);

        Intent myIntent     = getIntent();
        String codigo       = myIntent.getStringExtra("codigo");
        String celula       = myIntent.getStringExtra("celula");
        String codigoLider  = myIntent.getStringExtra("codigoLider");
        String cpf          = myIntent.getStringExtra("cpf");
        String nome         = myIntent.getStringExtra("nome");
        String endereco     = myIntent.getStringExtra("endereco");
        String email        = myIntent.getStringExtra("email");
        String tipo         = myIntent.getStringExtra("tipo");
        String sexo         = myIntent.getStringExtra("sexo");

        TextView tv_codigo = (TextView) findViewById(R.id.codigo);
        tv_codigo.setText("x"+ codigo);

        TextView tv_celula = (TextView) findViewById(R.id.celula);
        tv_celula.setText(celula);

        TextView tv_codigo_lider = (TextView) findViewById(R.id.codigoLider);
        tv_codigo_lider.setText(codigoLider);

        TextView tv_cpf = (TextView) findViewById(R.id.cpf);
        tv_cpf.setText(cpf);

        TextView tv_nome = (TextView) findViewById(R.id.nome);
        tv_nome.setText(nome);

        TextView tv_endereco = (TextView) findViewById(R.id.endereco);
        tv_endereco.setText(endereco);

        TextView tv_email = (TextView) findViewById(R.id.email);
        tv_email.setText(email);

        TextView tv_tipo = (TextView) findViewById(R.id.tipo);
        tv_tipo.setText(tipo);

        TextView tv_sexo = (TextView) findViewById(R.id.sexo);
        tv_sexo.setText(sexo);


    }
}

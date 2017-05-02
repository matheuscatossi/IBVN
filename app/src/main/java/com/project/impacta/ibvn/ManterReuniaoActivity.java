package com.project.impacta.ibvn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.project.impacta.ibvn.helper.CarregarEnderecoTask;
import com.project.impacta.ibvn.helper.DatePickerFragment;
import com.project.impacta.ibvn.helper.FormularioManterReuniaoHelper;
import com.project.impacta.ibvn.model.Celula;
import com.project.impacta.ibvn.model.Reuniao;

public class ManterReuniaoActivity extends AppCompatActivity {

    EditText data;
    private FormularioManterReuniaoHelper helperFormManterReuniao;
    private Celula celula;
    private Reuniao reuniao;
    private Button buscar;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manter_reuniao);

        //Header
        getSupportActionBar().setTitle("Adicionando Reunião");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        helperFormManterReuniao= new FormularioManterReuniaoHelper(this);
        Intent intent = getIntent();

        celula = (Celula) intent.getSerializableExtra("CELULA");
        reuniao = (Reuniao) intent.getSerializableExtra("REUNIAO");


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

        switch (item.getItemId()) {
            case R.id.menu_manter_reuniao_salvar_ok:

                Reuniao reuniao = helperFormManterReuniao.getReuniaoFromData();
                //AlunoDAO dao = new AlunoDAO(this);

                if (reuniao.getId() != 0) {
                    // dao.altera(aluno);
                } else {
                    // dao.insere(aluno);
                }

                //  dao.close();
                Toast.makeText(ManterReuniaoActivity.this, "Reunião " + reuniao.getTema() + " salva!", Toast.LENGTH_LONG).show();
                finish();
                break;
            case android.R.id.home:

                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}

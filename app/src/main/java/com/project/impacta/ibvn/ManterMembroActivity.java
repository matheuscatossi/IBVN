package com.project.impacta.ibvn;

import android.app.ProgressDialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.project.impacta.ibvn.helper.CarregarEnderecoTask;
import com.project.impacta.ibvn.helper.DatePickerFragment;
import com.project.impacta.ibvn.helper.FormularioManterMembroHelper;
import com.project.impacta.ibvn.model.Membro;

/**
 * Created by Matheus on 19/02/2017.
 */

public class ManterMembroActivity extends AppCompatActivity {

    private Button buscar;
    private FormularioManterMembroHelper helperFormManterMembro;
    private EditText data;
    ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manter_membro);

        getSupportActionBar().setTitle("Adicionando Membro");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        helperFormManterMembro = new FormularioManterMembroHelper(this);

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

        switch (item.getItemId()) {
            case R.id.menu_manter_reuniao_salvar_ok:

                Membro membro = helperFormManterMembro.getMembroFromData();
                Toast.makeText(ManterMembroActivity.this, "Membro " + membro.getNome() + " salvo!", Toast.LENGTH_LONG).show();
                finish();
                break;
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}

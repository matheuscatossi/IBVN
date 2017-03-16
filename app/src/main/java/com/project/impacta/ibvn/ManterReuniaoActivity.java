package com.project.impacta.ibvn;

import android.*;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.project.impacta.ibvn.helper.BuscaCep;
import com.project.impacta.ibvn.helper.DatePickerFragment;
import com.project.impacta.ibvn.helper.FormularioManterMembroHelper;
import com.project.impacta.ibvn.model.CelulaModel;
import com.project.impacta.ibvn.model.ReuniaoModel;

import java.io.IOException;
import java.util.Map;

public class ManterReuniaoActivity extends AppCompatActivity {

    EditText data;
    private FormularioManterMembroHelper helperFormManterReuniao;
    private CelulaModel celula;
    private ReuniaoModel reuniao;
    private Button buscar;
    private Map<String, String> DadosEndereco;
    private static boolean isNetworkEnabled = false;
    private static LocationManager locationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manter_reuniao);

        helperFormManterReuniao = new FormularioManterMembroHelper(this);

        Intent intent = getIntent();
        celula = (CelulaModel) intent.getSerializableExtra("CELULA");
        reuniao = (ReuniaoModel) intent.getSerializableExtra("REUNIAO");


        //Mostra calendário no clique do campo data
        data = (EditText) findViewById(R.id.et_manter_reuniao_data);
        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePickerFragment(data);
                newFragment.show(getSupportFragmentManager(), "datePicker");
            }

        });


        final EditText et_cep = (EditText) findViewById(R.id.et_manter_reuniao_cep);
        buscar = (Button) findViewById(R.id.btn_manter_reuniao_buscar_cep);

        buscar.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {

                                          Thread thread = new Thread(new Runnable() {

                                              @Override
                                              public void run() {
                                                  try {

                                                      if (ContextCompat.checkSelfPermission(ManterReuniaoActivity.this,
                                                              android.Manifest.permission.INTERNET)
                                                              == PackageManager.PERMISSION_GRANTED) {

                                                          DadosEndereco = BuscaCep.getEnderecoFull(et_cep.getText().toString());
                                                          helperFormManterReuniao.preencherDadosEndereco(DadosEndereco);

                                                      }


                                                  } catch (IOException ex) {

                                                      ex.printStackTrace();

                                                  } catch (Exception e) {
                                                      e.printStackTrace();
                                                  }
                                              }
                                          });
                                          thread.start();
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

                ReuniaoModel reuniao = helperFormManterReuniao.getReuniaoFromData();
                //AlunoDAO dao = new AlunoDAO(this);

                if (reuniao.getCodReuniao() != 0) {
                    // dao.altera(aluno);
                } else {
                    // dao.insere(aluno);
                }

                //  dao.close();
                Toast.makeText(ManterReuniaoActivity.this, "Reunião " + reuniao.getTemaReuniao() + " salva!", Toast.LENGTH_LONG).show();
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}

package com.project.impacta.ibvn;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoMembroActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_membro);

        Intent myIntent     = getIntent();

        String codigoMembro = myIntent.getStringExtra("codigoMembro");

        /*
            Exemplo de membro
         */
        int codMembro                    = 1;
        String nomeMembro                = "Matheus Catossi";
        String sexoMembro                = "M";
        String cpfMembro                 = "45084552802";
        String emailMembro               = "matheuscatossi@gmail.com";
        int codCriadoPor                 =  1;
        String criadoPor                 = "Matheus Líder";
        String statusMembro              = "Fiel";
        String telefoneMembro            = "11 2556 5250";
        String celularMembro             = "11 958 524 104";
        String criado                    = "16/02/2017";
        String atualizado                = "16/02/2017";

        String tipoEndereco              = "Rua";
        String logradouroEndereco        = "Fernandez Palero";
        String numeroEndereco            = "225";
        String cepEndereco               =  "08465120";
        String bairroEndereco            = "Guaianazes";
        String cidadeEndereco            = "São Paulo";
        String ufEndereco                = "SP";
        Double latitudeEndereco          = 26.12312321;
        Double longitudeEndereco         = 46.43242344;
        String criadoEmEndereco          = "16/02/2017";

        int codCelula                    = 1;
        int codLider                     = 1;
        String nomeLider                 = "Matheus Líder";
        String criadoEmCelula            = "16/02/2017";

        FloatingActionButton fabEditar = (FloatingActionButton) findViewById(R.id.fabEditar);
        fabEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Editar membro - Feature em desenvolvimento", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }
}

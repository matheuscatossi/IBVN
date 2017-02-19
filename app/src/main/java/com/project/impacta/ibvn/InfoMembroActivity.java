package com.project.impacta.ibvn;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Matheus on 12/02/2017.
 */

public class InfoMembroActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


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

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        //if (id == R.id.sobre) {
        //  Intent i = new Intent(this, ContatoActivity.class);
        //  startActivity(i);
        //}

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

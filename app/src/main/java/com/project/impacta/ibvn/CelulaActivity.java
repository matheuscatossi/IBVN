package com.project.impacta.ibvn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.project.impacta.ibvn.adapter.MembroCustomAdapter;
import com.project.impacta.ibvn.model.Celula;
import com.project.impacta.ibvn.model.Membro;
import com.project.impacta.ibvn.model.Reuniao;
import com.project.impacta.ibvn.webservice.APIClient;
import com.project.impacta.ibvn.webservice.APIInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CelulaActivity extends AppCompatActivity {

    private static Membro membroLider;
    Call<List<Membro>> call;
    APIInterface apiService;
    MembroCustomAdapter membroCustomAdapter;
    ListView listViewMembro;
    static final ScheduledThreadPoolExecutor EXECUTOR = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(2);
    static ScheduledFuture<?> sMembro;
    public ArrayList<Membro> membroList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celula);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listViewMembro = (ListView) findViewById(R.id.listMembro);

        sMembro = EXECUTOR.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                apiService = APIClient.getService().create(APIInterface.class);
                call = apiService.getMembros();
                membroList = new ArrayList<>();

                call.enqueue(new Callback<List<Membro>>() {
                    @Override
                    public void onResponse(Call<List<Membro>> call, Response<List<Membro>> response) {
                        if (response.raw().code() == 200) {

                            List<Membro> l = new ArrayList<Membro>();
                            l.addAll(response.body());

                            for (Membro membro : l) {
                                membroList.add(new Membro((int) membro.getId(), (String) membro.getNome(), (String) membro.getEmail(), (String) membro.getSexo()));
                            }

                            Collections.reverse(membroList);
                            membroCustomAdapter = new MembroCustomAdapter(membroList, CelulaActivity.this.getBaseContext());

                            if (membroCustomAdapter != null) {
                                listViewMembro.setAdapter(membroCustomAdapter);
                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<List<Membro>> call, Throwable t) {
                        Log.e("INFOMEMBRO", t.toString());
                    }
                });
            }
        }, 0, 6000, TimeUnit.SECONDS);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_celula, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.incluir_membro:
                Intent manterMembroIntent = new Intent(CelulaActivity.this, ManterMembroActivity.class);
                membroLider = new Membro(1, "João José", "jj@gmail.com.br", "M");
                manterMembroIntent.putExtra("CELULA", membroLider);
                startActivity(manterMembroIntent);
                break;
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}

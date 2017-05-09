package com.project.impacta.ibvn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;

import com.project.impacta.ibvn.adapter.MembroReuniaoCustomAdapter;
import com.project.impacta.ibvn.adapter.MembroCustomAdapter;
import com.project.impacta.ibvn.model.MembroReuniao;
import com.project.impacta.ibvn.model.Membro;
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

public class MembroReuniaoActivity extends AppCompatActivity {

    private ArrayList<MembroReuniao> membroList;
    private ListView listViewMembroReuniao;
    private MembroReuniaoCustomAdapter membroReuniaoCustomAdapter;
    private ArrayList<MembroReuniao> membroReuniaoList;
    private static final ScheduledThreadPoolExecutor EXECUTOR = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(2);
    private static ScheduledFuture<?> sMembroReuniao;
    private APIInterface apiService;
    private Call<List<MembroReuniao>> callMembroReuniao;
    private String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membro_reuniao);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Intent myIntent = getIntent();
        codigo = myIntent.getStringExtra("id");

        apiService = APIClient.getService().create(APIInterface.class);
        callMembroReuniao = apiService.getMembrosReuniao(codigo);
        membroReuniaoList = new ArrayList<>();

        listViewMembroReuniao = (ListView) findViewById(R.id.listMembroReuniao);

        sMembroReuniao = EXECUTOR.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                callMembroReuniao.enqueue(new Callback<List<MembroReuniao>>() {
                    @Override
                    public void onResponse(Call<List<MembroReuniao>> call, Response<List<MembroReuniao>> response) {
                        if (response.raw().code() == 200) {

                            for (MembroReuniao membroReuniao : response.body()) {
                                membroReuniaoList.add(new MembroReuniao(membroReuniao.getFk_reuniao(), membroReuniao.getFk_membro(), membroReuniao.getPresente(), membroReuniao.getCreated_at(), membroReuniao.getUpdate_at(), membroReuniao.getMembro()));
                            }

                            Collections.reverse(membroReuniaoList);
                            membroReuniaoCustomAdapter = new MembroReuniaoCustomAdapter(membroReuniaoList, MembroReuniaoActivity.this.getBaseContext());

                            if (membroReuniaoCustomAdapter != null) {
                                listViewMembroReuniao.setAdapter(membroReuniaoCustomAdapter);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<List<MembroReuniao>> call, Throwable t) {
                        Log.e("INFOMEMBROREUNIAO", t.toString());
                    }
                });
            }
        }, 0, 6000, TimeUnit.SECONDS);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}

package com.project.impacta.ibvn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.project.impacta.ibvn.adapter.MembroCustomAdapter;
import com.project.impacta.ibvn.model.Membro;

import java.util.ArrayList;
import java.util.Collections;

public class MembroReuniaoActivity extends AppCompatActivity {

    public ArrayList<Membro> membroList;
    ListView listViewMembro;
    MembroCustomAdapter membroCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membro_reuniao);

        listViewMembro = (ListView) findViewById(R.id.listMembro);
        membroList = new ArrayList<>();

        membroList.add(new Membro(1, "João José", "jj@jj.com.br", "M"));
        membroList.add(new Membro(1, "Cesar Astolfo", "castolfo@hotmail.com", "M"));
        membroList.add(new Membro(1, "Carlos Junior", "carlosj@gmail.com", "M"));
        membroList.add(new Membro(1, "Maria de Fatima", "mrfcatossi@terra.com.br", "F"));
        membroList.add(new Membro(1, "Matheus Catossi", "matheuscatossi@gmail.com", "M"));

        Collections.reverse(membroList);
        membroCustomAdapter = new MembroCustomAdapter(membroList, this);
        listViewMembro.setAdapter(membroCustomAdapter);

    }
}

package com.project.impacta.ibvn.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import com.project.impacta.ibvn.model.ReuniaoModel;

public class ReuniaoDao extends SQLiteOpenHelper {

    public ReuniaoDao(Context context) {
        super(context, "IBVN", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE reuniao (id INTEGER PRIMARY KEY, celula_id INT,data DATE, tema TEXT, status TEXT, descricao TEXT,logradouro TEXT,bairro TEXT,cidade TEXT,cep TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS reuniao";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insere(ReuniaoModel reuniao) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = pegaDadosDaReuniao(reuniao);

        db.insert("reuniao", null, dados);
    }

    @NonNull
    private ContentValues pegaDadosDaReuniao(ReuniaoModel reuniao) {

        ContentValues dados = new ContentValues();
        dados.put("tema", reuniao.getTema());
        dados.put("data", reuniao.getData());
        dados.put("status", reuniao.getStatus());
        dados.put("descricao", reuniao.getDescricao());
        dados.put("celula_id", reuniao.getCelulaReuniao().getCodCelula());
        return dados;
    }


}

package com.project.impacta.ibvn.webservice;


import android.icu.text.IDNA;

import com.google.android.gms.nearby.messages.Message;
import com.google.common.collect.ObjectArrays;
import com.project.impacta.ibvn.Utils.Constants;
import com.project.impacta.ibvn.model.MembroModel;
import com.project.impacta.ibvn.model.ReuniaoModel;

import org.json.JSONArray;

import java.lang.reflect.Array;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * Created by Matheus on 16/03/2017.
 */

public interface APIInterface {

    @GET(Constants.GET_MEMBROS)
    Call<List<MembroModel>> getMembros();

    @GET(Constants.GET_MEMBROS_BY_ID)
    Call<MembroModel> getMembrosByID(@Path("id") String id);

    @GET(Constants.GET_REUNIOES)
    Call<List<ReuniaoModel>> getReunioes();

    @GET(Constants.GET_REUNIOES_BY_ID)
    Call<ReuniaoModel> getReunioesByID(@Path("id") String id);

}

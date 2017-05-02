package com.project.impacta.ibvn.webservice;


import com.project.impacta.ibvn.Utils.Constants;
import com.project.impacta.ibvn.model.Evento;
import com.project.impacta.ibvn.model.Membro;
import com.project.impacta.ibvn.model.Reuniao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Matheus on 16/03/2017.
 */

public interface APIInterface {

    @GET(Constants.GET_MEMBROS)
    Call<List<Membro>> getMembros();

    @GET(Constants.GET_MEMBROS_BY_ID)
    Call<Membro> getMembrosByID(@Path("id") String id);

    @GET(Constants.GET_REUNIOES)
    Call<List<Reuniao>> getReunioes();

    @GET(Constants.GET_REUNIOES_BY_ID)
    Call<Reuniao> getReunioesByID(@Path("id") String id);

    @GET(Constants.GET_EVENTOS)
    Call<List<Evento>> getEventos();

}

package com.project.impacta.ibvn.webservice;


import android.provider.SyncStateContract;

import com.project.impacta.ibvn.Utils.Constants;
import com.project.impacta.ibvn.model.Evento;
import com.project.impacta.ibvn.model.Login;
import com.project.impacta.ibvn.model.Membro;
import com.project.impacta.ibvn.model.MembroReuniao;
import com.project.impacta.ibvn.model.Mensagem;
import com.project.impacta.ibvn.model.Reuniao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Matheus on 16/03/2017.
 */

public interface APIInterface {

    @GET(Constants.GET_MEMBROS)
    Call<List<Membro>> getMembros();

    @GET(Constants.GET_MEMBROS_BY_ID)
    Call<Membro> getMembrosByID(@Path("id") String id);

    @POST(Constants.POST_MEMBROS)
    Call<Membro> postMembros(@Body Membro membro);

    @GET(Constants.GET_REUNIOES)
    Call<List<Reuniao>> getReunioes();

    @GET(Constants.GET_REUNIOES_BY_ID)
    Call<Reuniao> getReunioesByID(@Path("id") String id);

    @POST(Constants.POST_REUNIOES)
    Call<Reuniao> postReunioes(@Body Reuniao reuniao);

    @GET(Constants.GET_EVENTOS)
    Call<List<Evento>> getEventos();

    @GET(Constants.GET_MEMBROS_REUNIAO)
    Call<List<MembroReuniao>> getMembrosReuniao(@Path("id") String id);

    @POST(Constants.POST_PRESENCA_MEMBRO_REUNIAO)
    Call<Membro> postPresencaMembroReuniao(@Body MembroReuniao membroReuniao);

    @POST(Constants.POST_MENSAGEM)
    Call<Mensagem> postMensagem(@Body Mensagem mensagem);

    @POST(Constants.POST_LOGIN)
    Call<Membro> postLogin(@Body Login login);

    @GET(Constants.GET_REUNIOES_BY_CELULA)
    Call<List<Reuniao>> getReunioesByCelula(@Path("id") String id);

    @GET(Constants.GET_MEMBROS_BY_CELULA)
    Call<List<Membro>> getMembrosByCelula(@Path("id") String id);



}

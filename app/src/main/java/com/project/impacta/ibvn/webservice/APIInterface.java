package com.project.impacta.ibvn.webservice;


import com.project.impacta.ibvn.Utils.Constants;
import com.project.impacta.ibvn.model.MembroModel;
import com.project.impacta.ibvn.model.ReuniaoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Matheus on 16/03/2017.
 */

public interface APIInterface {

    @GET(Constants.GET_MEMBROS)
    Call<List<MembroModel>> getMembros();

    @GET(Constants.GET_MEMBROS_BY_ID)
    Call<MembroModel> getMembrosByID(@Path("id") String id);

    /*@POST(Constants.POST_MEMBROS)
    Call<MembroModel> postMembros(
              @Path("id") String id
            , @Path("nome") String nome
            , @Path("sexo") String sexo
            , @Path("cpf") String cpf
            , @Path("estado_civil") String estado_civil
            , @Path("dt_nasc") String dt_nasc
            , @Path("email") String email
            , @Path("numero") String numero
            , @Path("complemento") String complemento
            , @Path("bairro") String bairro
            , @Path("cidade") String cidade
            , @Path("estado") String estado
            , @Path("latitude") String latitude
            , @Path("longitude") String longitude
            , @Path("fk_celula") String fk_celula);*/

    @POST(Constants.POST_MEMBROS)
    Call<MembroModel> postMembros(@Body MembroModel membro);
    //Call<MembroModel> postMembros(@Field string membro);

    @GET(Constants.GET_REUNIOES)
    Call<List<ReuniaoModel>> getReunioes();

    @GET(Constants.GET_REUNIOES_BY_ID)
    Call<ReuniaoModel> getReunioesByID(@Path("id") String id);

}

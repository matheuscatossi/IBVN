package com.project.impacta.ibvn.webservice;


import android.icu.text.IDNA;

import com.google.android.gms.nearby.messages.Message;
import com.project.impacta.ibvn.Utils.Constants;
import com.project.impacta.ibvn.model.MembroModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Matheus on 16/03/2017.
 */

public interface APIInterface {

    //    @POST(Constants.SEND_MESSAGE)
    //    Call<Message> sendMessage(@Body String message);
    //
    //    @GET(Constants.INFO)
    //    Call<IDNA.Info> getInfo();

    @GET(Constants.GET_MEMBROS)
    Call<String> getMembros();
}

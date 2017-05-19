package com.project.impacta.ibvn.webservice;

import com.google.android.gms.nearby.messages.Message;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by proje on 18/05/2017.
 */

public interface FirebaseAPI {

    @POST("/fcm/send")
    Call<Message> sendMessage(@Body Message message);

}
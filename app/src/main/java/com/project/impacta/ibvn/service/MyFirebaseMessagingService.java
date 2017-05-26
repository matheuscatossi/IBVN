package com.project.impacta.ibvn.service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.nearby.messages.Message;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.firebase.messaging.RemoteMessage.Notification;
import com.project.impacta.ibvn.MainActivity;
import com.project.impacta.ibvn.ManterMembroActivity;
import com.project.impacta.ibvn.Utils.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Matheus on 23/04/2017.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "FCM Service";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Bundle bundle = new Bundle();

        Log.d(TAG, "From: " + remoteMessage.getFrom());

        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
        }

        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());

            bundle.putString("msgBody", remoteMessage.getNotification().getBody());
            Intent new_intent = new Intent();
            new_intent.setAction("ACTION_STRING_ACTIVITY");
            new_intent.putExtra("msg", bundle);

            sendBroadcast(new_intent);

        }
    }

    public static final String FCM_MESSAGE_URL = "https://fcm.googleapis.com/fcm/send";


    public static void sendNotificationToUser(String userId, final String message){
        FirebaseMessaging messaging = FirebaseMessaging.getInstance();

        Bundle someBundle = new Bundle();
        someBundle.putString("STRING_KEY_HERE", "STRING_VALUE_HERE");
        //I have tried excluding the @gcm as well, no luck.
        String str = "ibvn-gestao-de-eventos@gcm.googleapis.com";

        RemoteMessage.Builder myBuilder = new RemoteMessage.Builder(str);
        Map<String, String> aMap = new HashMap<>();

        aMap.put("DATA_KEY_1", "DATA_VALUE_1");
        myBuilder.setData(aMap);
        myBuilder.addData("ADD_DATA1", "ADD_DATA11");
        myBuilder.setMessageId("SOME_MESSAGE_ID123");
        myBuilder.setTtl(0); //Send immediately
        myBuilder.setMessageType("SOME_MESSAGE_TYPE");
        myBuilder.setCollapseKey("SOME_COLLAPSE_KEY");

        //Can't do this, private access, how do I instantiate this?
        RemoteMessage remoteMessage = myBuilder.build();
        messaging.send(remoteMessage);
    }

}






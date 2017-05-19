package com.project.impacta.ibvn.webservice;

/**
 * Created by proje on 18/05/2017.
 */


public class Message {
    String to;
    NotifyData notification;

    public Message(String to, NotifyData notification) {
        this.to = to;
        this.notification = notification;
    }

}



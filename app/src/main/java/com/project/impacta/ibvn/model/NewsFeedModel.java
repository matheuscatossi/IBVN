package com.project.impacta.ibvn.model;

/**
 * Created by Matheus on 22/03/2017.
 */

public class NewsFeedModel {

    private String id;
    private String descricao;
    private String data;
    private int imgPrincipal;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getImgPrincipal() {
        return imgPrincipal;
    }

    public void setImgPrincipal(int imgPrincipal) {
        this.imgPrincipal = imgPrincipal;
    }

    public NewsFeedModel() {
    }

    public NewsFeedModel(String id, String descricao, String data, int imgPrincipal) {
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.imgPrincipal       = imgPrincipal;
    }
}


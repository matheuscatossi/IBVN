package com.project.impacta.ibvn.model;

/**
 * Created by Matheus on 22/03/2017.
 */

public class NewsFeed {

    private int id;
    private String nome;
    private String descricao;
    private String imgPrincipal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setDescricao(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return descricao;
    }

    public void setData(String descricao) {
        this.descricao = descricao;
    }

    public String getImgPrincipal() {
        return imgPrincipal;
    }

    public void setImgPrincipal(String imgPrincipal) {
        this.imgPrincipal = imgPrincipal;
    }

    public NewsFeed() {
    }

    public NewsFeed(int id, String nome, String descricao, String imgPrincipal) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.imgPrincipal       = imgPrincipal;
    }
}


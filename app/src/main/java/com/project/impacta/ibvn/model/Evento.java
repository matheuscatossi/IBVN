package com.project.impacta.ibvn.model;

/**
 * Created by Matheus on 02/05/2017.
 */

public class Evento {

    int id;
    String data;
    String nome;
    String descricao;
    String tipo;
    String link_imagem;
    String link;
    String created_at;
    String update_at;

    public Evento(){

    }

    public Evento(int id, String data, String nome, String descricao, String tipo, String link_imagem, String link, String created_at, String update_at) {
        this.id = id;
        this.data = data;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.link = link;
        this.created_at = created_at;
        this.update_at = update_at;
        this.link_imagem       = link_imagem;
    }

    public Evento(int id, String nome, String descricao, String link_imagem) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.link_imagem       = link_imagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLink_imagem() {
        return link_imagem;
    }

    public void setLink_imagem(String link_imagem) {
        this.link_imagem = link_imagem;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(String update_at) {
        this.update_at = update_at;
    }
}

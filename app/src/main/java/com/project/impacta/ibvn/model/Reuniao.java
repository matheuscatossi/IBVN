package com.project.impacta.ibvn.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Reuniao implements Serializable {

    @SerializedName("id")
    @Expose
    private long Id;

    @SerializedName("data")
    @Expose
    private String data;

    @SerializedName("tema")
    @Expose
    private String tema;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("descricao")
    @Expose
    private String descricao;

    @SerializedName("logradouro")
    @Expose
    private String logradouro;

    @SerializedName("complemento")
    @Expose
    private String complemento;

    @SerializedName("numero")
    @Expose
    private String numero;

    @SerializedName("cep")
    @Expose
    private String cep;

    @SerializedName("bairro")
    @Expose
    private String bairro;

    @SerializedName("cidade")
    @Expose
    private String cidade;

    @SerializedName("estado")
    @Expose
    private String uf;

    @SerializedName("latitude")
    @Expose
    private double latitude;

    @SerializedName("logitude")
    @Expose
    private double longitude;

    @SerializedName("fk_celula")
    @Expose
    private int fk_celula;

    @SerializedName("created_at")
    @Expose
    private String criadoEm;

    @SerializedName("updated_at")
    @Expose
    private String atualizadoEm;

    //CÉLULA Model
    @SerializedName("celula")
    @Expose
    private Celula celula;

    public Reuniao() {
    }

    /*Contrutor full - todos os valores são passados via parametros*/
    public Reuniao(

            long codReuniao
            , String dataReuniao
            , String temaReuniao
            , String statusReuniao
            , String descricaoReuniao

            , String logradouroReuniao
            , String numeroReuniao
            , String cepReuniao
            , String bairroReuniao
            , String cidadeReuniao
            , String ufReuniao
            , String latitudeReuniao
            , String longitudeReuniao

            , int codCelula
            , String descricaoCelula
            , int codMembroCriador
            , String nomeMembrocriador
            , int codMembroLider
            , String nomeMembroLider

    ) {

        this.celula = new Celula();
        this.celula.setMembroCriador(new Membro());
        this.celula.setMembroLider(new Membro());

        ///REUNIAO
        this.Id = codReuniao;
        this.data = dataReuniao;
        this.tema = temaReuniao;
        this.status = statusReuniao;
        this.descricao = descricaoReuniao;

        //CELULA
        this.celula.setId(codCelula);
        this.celula.setDescricao(descricaoCelula);

        //MEMBRO CRIADOR
        this.celula.getMembroCriador().id = codMembroCriador;
        this.celula.getMembroCriador().nome = nomeMembrocriador;

        //MEMBRO LIDER
        this.celula.getMembroLider().id = codMembroLider;
        this.celula.getMembroLider().nome = nomeMembroLider;

    }


    /*
    * Construtor utilizado para carregadar dados para a lista
    * */
    public Reuniao(
            long cod,
            String data,
            String tema,
            String descricao
    ) {

        this.celula = new Celula();
        this.celula.setMembroCriador(new Membro());
        this.celula.setMembroLider(new Membro());

        //REUNIAO
        this.Id = cod;
        this.data = data;
        this.tema = tema;
        this.data = data;
        this.tema = tema;
        this.descricao = descricao;
    }

    /*
    * Contrutor padrão utilizando model para relacionamento.
    * */
    public Reuniao(
            long cod,
            String data,
            String tema,
            String status,
            String descricao,
            String logradouro,
            String numero,
            String cep,
            String bairro,
            String cidade,
            String longitude,
            String latitude,
            String uf,
            Celula celula) {

        this.Id = cod;
        this.data = data;
        this.tema = tema;
        this.status = status;
        this.descricao = descricao;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.latitude = Double.parseDouble(latitude);
        this.longitude =Double.parseDouble(longitude);
        this.uf = uf;
        this.celula = celula;
    }


    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getFk_celula() {
        return fk_celula;
    }

    public void setFk_celula(int fk_celula) {
        this.fk_celula = fk_celula;
    }

    public String getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(String criadoEm) {
        this.criadoEm = criadoEm;
    }

    public String getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(String atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }

    public Celula getCelula() {
        return celula;
    }

    public void setCelula(Celula celula) {
        this.celula = celula;
    }


}
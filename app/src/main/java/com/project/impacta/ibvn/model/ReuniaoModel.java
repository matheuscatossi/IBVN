package com.project.impacta.ibvn.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class ReuniaoModel implements Serializable {

    @SerializedName("id")
    @Expose
    private long Id;

    @SerializedName("data")
    @Expose
    private String data;

    @SerializedName("tema")
    @Expose
    private String tema;

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
    private String latitude;

    @SerializedName("logitude")
    @Expose
    private String longitude;

    @SerializedName("fk_celula")
    @Expose
    private String fk_celula;


    //CÉLULA Model
    private CelulaModel celula;

    public ReuniaoModel() {
    }

    /*Contrutor full - todos os valores são passados via parametros*/
    public ReuniaoModel(

            long codReuniao
            , String dataReuniao
            , String temaReuniao
            , String statusReuniao
            , String descricaoReuniao

            , String logradouroEnderecoReuniao
            , String numeroEnderecoReuniao
            , String cepEnderecoReuniao
            , String bairroEnderecoReuniao
            , String cidadeEnderecoReuniao
            , String ufEnderecoReuniao
            , String latitudeEnderecoReuniao
            , String longitudeEnderecoReuniao

            , int codCelula
            , String descricaoCelula
            , int codMembroCriador
            , String nomeMembrocriador
            , int codMembroLider
            , String nomeMembroLider


    ) {

        this.celula = new CelulaModel();
        this.celula.setMembroCriador(new MembroModel());
        this.celula.setMembroLider(new MembroModel());
        this.celula.setEnderecoCelula(new EnderecoModel());

        ///REUNIAO
        this.Id = codReuniao;
        this.data = dataReuniao;
        this.tema = temaReuniao;
        this.status = statusReuniao;
        this.descricao = descricaoReuniao;

        //CELULA
        this.celula.setCodCelula(codCelula);
        this.celula.setDescricaoCelula(descricaoCelula);

        //MEMBRO CRIADOR
        this.celula.getMembroCriador().id = codMembroCriador;
        this.celula.getMembroCriador().nome = nomeMembrocriador;

        //MEMBRO LIDER
        this.celula.getMembroLider().id = codMembroLider;
        this.celula.getMembroLider().nome = nomeMembroLider;

        //ENDERECO REUNIÃO
        this.setLogradouro(logradouroEnderecoReuniao);
        this.setNumero(numeroEnderecoReuniao);
        this.setCep(cepEnderecoReuniao);
        this.setBairro(bairroEnderecoReuniao);
        this.setCidade(cidadeEnderecoReuniao);
        this.setUf(ufEnderecoReuniao);
        this.setLatitude(latitudeEnderecoReuniao);
        this.setLongitude(longitudeEnderecoReuniao);

    }


    /*
    * Construtor utilizado para carregadar dados para a lista
    * */
    public ReuniaoModel(
            long cod,
            String data,
            String tema,
            String descricao
//            String statusReuniao,
//            String logradouroReuniao,
//            String numeroReuniao,
//            String cepReuniao,
//            String bairroReuniao,
//            String cidadeReuniao,
//            String longitudeReuniao,
//            String latitudeReuniao,
//            String ufReuniao
    ) {

        this.celula = new CelulaModel();
        this.celula.setMembroCriador(new MembroModel());
        this.celula.setMembroLider(new MembroModel());
        this.celula.setEnderecoCelula(new EnderecoModel());

        //REUNIAO
        this.Id = cod;
        this.data = data;
        this.tema = tema;
        this.data = data;
        this.tema = tema;
        this.descricao = descricao;
//        this.status = statusReuniao;
//        this.logradouro = logradouroReuniao;
//        this.numero = numeroReuniao;
//        this.bairro = bairroReuniao;
//        this.cep = cepReuniao;
//        this.cidade = cidadeReuniao;
//        this.latitude = latitudeReuniao;
//        this.longitude = longitudeReuniao;
//        this.uf = ufReuniao;


/*        //CÉLULA
        this.celulaReuniao.setDescricaoCelula(descricaoCelula);

        //MEMBRO CRIADOR
        this.celulaReuniao.getMembroCriador().nome = nomeMembrocriador;

        //MEMBRO LIDER
        this.celulaReuniao.getMembroLider().nome = nomeMembroLider;*/

    }

    /*
    * Contrutor padrão utilizando model para relacionamento.
    * */
    public ReuniaoModel(
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
            CelulaModel celula) {

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
        this.latitude = latitude;
        this.longitude = longitude;
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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getFk_celula() {
        return fk_celula;
    }

    public void setFk_celula(String fk_celula) {
        this.fk_celula = fk_celula;
    }

    public CelulaModel getCelulaReuniao() {
        return celula;
    }

    public void setCelulaReuniao(CelulaModel celulaReuniao) {
        this.celula = celulaReuniao;
    }


}
package com.project.impacta.ibvn.model;

import java.io.Serializable;

public class Endereco implements Serializable {

    private int codEndereco;
    private String logradouroEndereco;
    private String numeroEndereco;
    private String cepEndereco;
    private String complementoEndereco;
    private String bairroEndereco;
    private String cidadeEndereco;
    private String ufEndereco;
    private String latitudeEndereco;
    private String longitudeEndereco;

    //TIPO DE ENDERECO
    private int codTipoEndereco;
    private String tipoEndereco;


    public Endereco() {
    }

    public Endereco(String cepEndereco, String logradouroEndereco, String numeroEndereco, String bairroEndereco, String cidadeEndereco, String ufEndereco) {
        this.cepEndereco = cepEndereco;
        this.logradouroEndereco = logradouroEndereco;
        this.numeroEndereco = numeroEndereco;
        this.bairroEndereco = bairroEndereco;
        this.cidadeEndereco = cidadeEndereco;
        this.ufEndereco = ufEndereco;
    }

    public Endereco(int codEndereco, String logradouroEndereco, String numeroEndereco, String cepEndereco, String complementoEndereco, String bairroEndereco, String cidadeEndereco, String ufEndereco, int codTipoEndereco, String tipoEndereco, String latitudeEndereco, String longitudeEndereco) {

        this.codEndereco = codEndereco;
        this.logradouroEndereco = logradouroEndereco;
        this.numeroEndereco = numeroEndereco;
        this.cepEndereco = cepEndereco;
        this.complementoEndereco = complementoEndereco;
        this.bairroEndereco = bairroEndereco;
        this.cidadeEndereco = cidadeEndereco;
        this.ufEndereco = ufEndereco;
        this.codTipoEndereco = codTipoEndereco;
        this.tipoEndereco = tipoEndereco;
        this.latitudeEndereco = latitudeEndereco;
        this.longitudeEndereco = longitudeEndereco;

    }


    public int getCodEndereco() {
        return codEndereco;
    }

    public void setCodEndereco(int codEndereco) {
        this.codEndereco = codEndereco;
    }

    public String getLogradouroEndereco() {
        return logradouroEndereco;
    }

    public void setLogradouroEndereco(String logradouroEndereco) {
        this.logradouroEndereco = logradouroEndereco;
    }

    public String getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(String numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getCepEndereco() {
        return cepEndereco;
    }

    public void setCepEndereco(String cepEndereco) {
        this.cepEndereco = cepEndereco;
    }

    public String getComplementoEndereco() {
        return complementoEndereco;
    }

    public void setComplementoEndereco(String complementoEndereco) {
        this.complementoEndereco = complementoEndereco;
    }

    public String getBairroEndereco() {
        return bairroEndereco;
    }

    public void setBairroEndereco(String bairroEndereco) {
        this.bairroEndereco = bairroEndereco;
    }

    public String getCidadeEndereco() {
        return cidadeEndereco;
    }

    public void setCidadeEndereco(String cidadeEndereco) {
        this.cidadeEndereco = cidadeEndereco;
    }

    public String getUfEndereco() {
        return ufEndereco;
    }

    public void setUfEndereco(String ufEndereco) {
        this.ufEndereco = ufEndereco;
    }

    public int getCodTipoEndereco() {
        return codTipoEndereco;
    }

    public void setCodTipoEndereco(int codTipoEndereco) {
        this.codTipoEndereco = codTipoEndereco;
    }

    public String getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(String tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }


    public String getLatitudeEndereco() {
        return latitudeEndereco;
    }

    public void setLatitudeEndereco(String latitudeEndereco) {
        this.latitudeEndereco = latitudeEndereco;
    }

    public String getLongitudeEndereco() {
        return longitudeEndereco;
    }

    public void setLongitudeEndereco(String longitudeEndereco) {
        this.longitudeEndereco = longitudeEndereco;
    }


    @Override
    public String toString() {
        return String.format("%s, Nº %s, CEP: %s", this.logradouroEndereco, this.numeroEndereco, this.cepEndereco);
    }
}

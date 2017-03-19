package com.project.impacta.ibvn.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Matheus on 12/02/2017.
 */

public class MembroModel implements Cloneable,Serializable {

    @SerializedName("id")
    @Expose
    int id;

    @SerializedName("nome")
    @Expose
    String nome;

    @SerializedName("sexo")
    @Expose
    String sexo;

    @SerializedName("cpf")
    @Expose
    String cpf;

    @SerializedName("estado_civil")
    @Expose
    String estado_civil;

    @SerializedName("dt_nas")
    @Expose
    String dt_nasc;

    @SerializedName("email")
    @Expose
    String email;

    @SerializedName("tipo")
    @Expose
    String tipo;

    @SerializedName("telefone")
    @Expose
    String telefone;

    @SerializedName("celular")
    @Expose
    String celular;

    @SerializedName("cep")
    @Expose
    String cep;

    @SerializedName("logradouro")
    @Expose
    String logradouro;

    @SerializedName("numero")
    @Expose
    String numero;

    @SerializedName("complemento")
    @Expose
    String complemento;

    @SerializedName("bairro")
    @Expose
    String bairro;

    @SerializedName("cidade")
    @Expose
    String cidade;

    @SerializedName("estado")
    @Expose
    String estado;

    @SerializedName("latitude")
    @Expose
    String latitude;

    @SerializedName("longitude")
    @Expose
    String logitude;

    @SerializedName("fk_celula")
    @Expose
    int fk_celula;




    public MembroModel() {

    }

    public MembroModel(int id, String nome, String sexo, String cpf, String estado_civil, String dt_nasc, String email, String tipo, String telefone, String celular, String cep, String logradouro, String numero, String complemento, String bairro, String cidade, String estado, String latitude, String logitude, int fk_celula) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.cpf = cpf;
        this.estado_civil = estado_civil;
        this.dt_nasc = dt_nasc;
        this.email = email;
        this.tipo = tipo;
        this.telefone = telefone;
        this.celular = celular;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.latitude = latitude;
        this.logitude = logitude;
        this.fk_celula = fk_celula;
    }

    public MembroModel(int id, String nome, String email, String sexo){
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.email = email;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getDt_nasc() {
        return dt_nasc;
    }

    public void setDt_nasc(String dt_nasc) {
        this.dt_nasc = dt_nasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLogitude() {
        return logitude;
    }

    public void setLogitude(String logitude) {
        this.logitude = logitude;
    }

    public int getFk_celula() {
        return fk_celula;
    }

    public void setFk_celula(int fk_celula) {
        this.fk_celula = fk_celula;
    }
}

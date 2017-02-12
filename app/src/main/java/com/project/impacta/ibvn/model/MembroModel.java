package com.project.impacta.ibvn.model;

/**
 * Created by Matheus on 12/02/2017.
 */

public class MembroModel {

    int codigo;
    int celula;
    int codigoLider;
    String cpf;
    String nome;
    String sexo;
    String endereco;
    String email;
    String tipo;

    public MembroModel(){

    }

    public MembroModel(int codigo, String nome, String sexo, int celula, String endereco, String cpf, String email, String tipo, int codigoLider) {
        this.codigo      = codigo;
        this.celula      = celula;
        this.codigoLider = codigoLider;
        this.cpf         = cpf;
        this.nome        = nome;
        this.sexo        = sexo;
        this.endereco    = endereco;
        this.email       = email;
        this.tipo        = tipo;

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCelula() {
        return celula;
    }

    public void setCelula(int celula) {
        this.celula = celula;
    }

    public int getCodigoLider() {
        return codigoLider;
    }

    public void setCodigoLider(int codigoLider) {
        this.codigoLider = codigoLider;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}

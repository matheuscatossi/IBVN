package com.project.impacta.ibvn.model;

/**
 * Created by matheuscatossi on 5/9/17.
 */

public class Login {

    int id;
    String email;
    String cpf;
    String celula;

    public Login() {

    }

    public Login(String email, String cpf){
        this.email = email;
        this.cpf = cpf;
    }

    public Login(int id, String email, String cpf, String celula) {
        this.id = id;
        this.email = email;
        this.cpf = cpf;
        this.celula = celula;
    }


    public Login(String email, String cpf, String celula) {
        this.email = email;
        this.cpf = cpf;
        this.celula = celula;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCelula() {
        return this.celula;
    }

    public void setCelula(String celula) {
        this.celula = celula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String login) {
        this.email = login;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}

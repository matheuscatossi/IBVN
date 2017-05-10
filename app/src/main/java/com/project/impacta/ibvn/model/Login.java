package com.project.impacta.ibvn.model;

/**
 * Created by matheuscatossi on 5/9/17.
 */

public class Login {

    String email;
    String cpf;

    public Login(String email, String cpf){
        this.email = email;
        this.cpf = cpf;
    }

    public String getLogin() {
        return email;
    }

    public void setLogin(String login) {
        this.email = login;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}

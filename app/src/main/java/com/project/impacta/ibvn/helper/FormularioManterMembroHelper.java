package com.project.impacta.ibvn.helper;

import android.widget.EditText;

import com.project.impacta.ibvn.ManterMembroActivity;
import com.project.impacta.ibvn.R;
import com.project.impacta.ibvn.model.Membro;

import java.util.Map;


public class FormularioManterMembroHelper {

    private EditText campoSexo;
    private EditText campoDataNascimento;
    private EditText campoEmail;
    private EditText campoCpf;
    private EditText campoTelefone;
    private EditText campoCelular;
    private EditText campoNome;
    private EditText campoLogradouro;
    private EditText campoCidade;
    private EditText campoBairro;
    private EditText campoCep;
    private EditText campoEstado;
    private EditText campoNumero;

    private com.project.impacta.ibvn.model.Membro Membro;


    //Contrutor Getters E Setters


    public EditText getCampoSexo() {
        return campoSexo;
    }

    public void setCampoSexo(EditText campoSexo) {
        this.campoSexo = campoSexo;
    }

    public EditText getCampoDataNascimento() {
        return campoDataNascimento;
    }

    public void setCampoDataNascimento(EditText campoDataNascimento) {
        this.campoDataNascimento = campoDataNascimento;
    }

    public EditText getCampoEmail() {
        return campoEmail;
    }

    public void setCampoEmail(EditText campoEmail) {
        this.campoEmail = campoEmail;
    }

    public EditText getCampoCpf() {
        return campoCpf;
    }

    public void setCampoCpf(EditText campoCpf) {
        this.campoCpf = campoCpf;
    }

    public EditText getCampoTelefone() {
        return campoTelefone;
    }

    public void setCampoTelefone(EditText campoTelefone) {
        this.campoTelefone = campoTelefone;
    }

    public EditText getCampoCelular() {
        return campoCelular;
    }

    public void setCampoCelular(EditText campoCelular) {
        this.campoCelular = campoCelular;
    }

    public EditText getCampoNome() {
        return campoNome;
    }

    public void setCampoNome(EditText campoNome) {
        this.campoNome = campoNome;
    }

    public EditText getCampoLogradouro() {
        return campoLogradouro;
    }

    public void setCampoLogradouro(EditText campoLogradouro) {
        this.campoLogradouro = campoLogradouro;
    }

    public EditText getCampoCidade() {
        return campoCidade;
    }

    public void setCampoCidade(EditText campoCidade) {
        this.campoCidade = campoCidade;
    }

    public EditText getCampoBairro() {
        return campoBairro;
    }

    public void setCampoBairro(EditText campoBairro) {
        this.campoBairro = campoBairro;
    }

    public EditText getCampoCep() {
        return campoCep;
    }

    public void setCampoCep(EditText campoCep) {
        this.campoCep = campoCep;
    }

    public EditText getCampoEstado() {
        return campoEstado;
    }

    public void setCampoEstado(EditText campoEstado) {
        this.campoEstado = campoEstado;
    }

    public EditText getCampoNumero() {
        return campoNumero;
    }

    public void setCampoNumero(EditText campoNumero) {
        this.campoNumero = campoNumero;
    }

    public com.project.impacta.ibvn.model.Membro getMembro() {
        return Membro;
    }

    public void setMembro(com.project.impacta.ibvn.model.Membro membro) {
        Membro = membro;
    }

    public FormularioManterMembroHelper(ManterMembroActivity activity) {

        campoNome = (EditText) activity.findViewById(R.id.et_manter_membro_nome);
        campoEmail = (EditText) activity.findViewById(R.id.et_manter_membro_email);
        campoCpf = (EditText) activity.findViewById(R.id.et_manter_membro_cpf);

        campoSexo = (EditText) activity.findViewById(R.id.et_manter_membro_sexo);
        campoDataNascimento = (EditText) activity.findViewById(R.id.et_manter_membro_data_nascimento);

        campoTelefone = (EditText) activity.findViewById(R.id.et_manter_membro_fixo);
        campoCelular = (EditText) activity.findViewById(R.id.et_manter_membro_celular);

        campoLogradouro = (EditText) activity.findViewById(R.id.et_manter_membro_logradouro);
        campoCidade = (EditText) activity.findViewById(R.id.et_manter_membro_cidade);
        campoBairro = (EditText) activity.findViewById(R.id.et_manter_membro_bairro);
        campoCep = (EditText) activity.findViewById(R.id.et_manter_membro_cep);
        campoEstado = (EditText) activity.findViewById(R.id.et_manter_membro_uf);
        campoNumero = (EditText) activity.findViewById(R.id.et_manter_membro_numero);

        Membro = new Membro();
    }


    public com.project.impacta.ibvn.model.Membro getMembroFromData() {
        this.Membro.setNome(campoNome.getText().toString());
        this.Membro.setCpf(campoCpf.getText().toString());
        this.Membro.setEmail(campoEmail.getText().toString());
        this.Membro.setDt_nasc(campoDataNascimento.getText().toString());
        this.Membro.setSexo(campoSexo.getText().toString());
        this.Membro.setTelefone(campoTelefone.getText().toString());
        this.Membro.setCelular(campoCelular.getText().toString());
        this.Membro.setCep(campoCep.getText().toString());
        this.Membro.setLogradouro(campoLogradouro.getText().toString());
        this.Membro.setNumero(campoNumero.getText().toString());
        this.Membro.setBairro(campoBairro.getText().toString());
        this.Membro.setCidade(campoCidade.getText().toString());
        this.Membro.setEstado(campoEstado.getText().toString());
        this.Membro.setNumero(campoNumero.getText().toString());
        return this.Membro;
    }

    public void preencherDadosEndereco(Map<String, String> dados) {
        this.campoCep.setText(dados.get("cep").toString());
        this.campoCidade.setText(dados.get("cidade").toString());
        this.campoBairro.setText(dados.get("bairro").toString());
        this.campoLogradouro.setText(dados.get("logradouro").toString());
        this.campoBairro.setText(dados.get("uf").toString());
    }
}

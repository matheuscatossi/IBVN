package com.project.impacta.ibvn.helper;

import android.widget.EditText;
import android.widget.TextView;

import com.project.impacta.ibvn.ManterMembroActivity;
import com.project.impacta.ibvn.ManterReuniaoActivity;
import com.project.impacta.ibvn.R;
import com.project.impacta.ibvn.model.ReuniaoModel;

import java.util.Map;

/**
 * Created by proje on 12/03/2017.
 */

public class FormularioManterMembroHelper {

    private EditText campoTema;
    private EditText campoData;
    private EditText campoLogradouro;
    private EditText campoCidade;
    private EditText campoBairro;
    private EditText campoCep;
    private EditText campoUF;
    private EditText campoNumero;
    private EditText campoDescricao;
    private ReuniaoModel Reuniao;
    private TextView campoHeader;

    //Contrutor Getters E Setters


    public FormularioManterMembroHelper(ManterReuniaoActivity activity) {

        campoHeader = (TextView) activity.findViewById(R.id.tv_manter_reuniao_nova);
        campoTema = (EditText) activity.findViewById(R.id.et_manter_reuniao_tema);
        campoData = (EditText) activity.findViewById(R.id.et_manter_reuniao_data);
        campoLogradouro = (EditText) activity.findViewById(R.id.et_manter_reuniao_logradouro);
        campoCidade = (EditText) activity.findViewById(R.id.et_manter_reuniao_cidade);
        campoBairro = (EditText) activity.findViewById(R.id.et_manter_reuniao_bairro);
        campoCep = (EditText) activity.findViewById(R.id.et_manter_reuniao_cep);
        campoUF = (EditText) activity.findViewById(R.id.et_manter_reuniao_uf);
        campoNumero = (EditText) activity.findViewById(R.id.et_manter_reuniao_numero);
        campoDescricao = (EditText) activity.findViewById(R.id.et_manter_reuniao_descricao);
        Reuniao = new ReuniaoModel();
    }

    public EditText getCampoNome() {
        return campoTema;
    }

    public void setCampoNome(EditText campoNome) {
        this.campoTema = campoNome;
    }

    public EditText getCampoData() {
        return campoData;
    }

    public void setCampoData(EditText campoData) {
        this.campoData = campoData;
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

    public EditText getCampoDescricao() {
        return campoDescricao;
    }

    public void setCampoDescricao(EditText campoDescricao) {
        this.campoDescricao = campoDescricao;
    }

    public TextView getCampoHeader() {
        return campoHeader;
    }

    public void setCampoHeader(TextView campoHeader) {
        this.campoHeader = campoHeader;
    }

    public EditText getCampoTema() {
        return campoTema;
    }

    public void setCampoTema(EditText campoTema) {
        this.campoTema = campoTema;
    }

    public EditText getCampoUF() {
        return campoUF;
    }

    public void setCampoUF(EditText campoUF) {
        this.campoUF = campoUF;
    }

    public ReuniaoModel getReuniao() {
        return Reuniao;
    }

    public void setReuniao(ReuniaoModel reuniao) {
        Reuniao = reuniao;
    }

    public EditText getCampoNumero() {
        return campoNumero;
    }

    public void setCampoNumero(EditText campoNumero) {
        this.campoNumero = campoNumero;
    }

    public ReuniaoModel getReuniaoFromData() {
        this.Reuniao.setDataReuniao(campoData.getText().toString());
        this.Reuniao.setDescricaoReuniao(campoDescricao.getText().toString());
        this.Reuniao.setStatusReuniao("Nova");
        this.Reuniao.setTemaReuniao(campoTema.getText().toString());
        return this.Reuniao;
    }

    public void preencherDadosEndereco(Map<String, String> dados) {
        this.campoCep.setText(dados.get("cep").toString());
        this.campoCidade.setText(dados.get("cidade").toString());
        this.campoBairro.setText(dados.get("bairro").toString());
        this.campoLogradouro.setText(dados.get("logradouro").toString());
        this.campoBairro.setText(dados.get("uf").toString());
    }
}

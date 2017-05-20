package com.project.impacta.ibvn.helper;

import android.widget.EditText;
import android.widget.TextView;

import com.project.impacta.ibvn.ManterReuniaoActivity;
import com.project.impacta.ibvn.R;
import com.project.impacta.ibvn.model.Reuniao;

import java.util.Map;

/**
 * Created by proje on 12/03/2017.
 */

public class FormularioManterReuniaoHelper {
    private EditText campoId;
    private EditText campoLongitude;
    private EditText campoLatitude;
    private EditText campoTema;
    private EditText campoData;
    private EditText campoLogradouro;
    private EditText campoComplemento;
    private EditText campoCidade;
    private EditText campoBairro;
    private EditText campoCep;
    private EditText campoUF;
    private EditText campoNumero;
    private EditText campoDescricao;
    private Reuniao Reuniao;
    private TextView campoHeader;

    public FormularioManterReuniaoHelper(ManterReuniaoActivity activity) {

        campoTema = (EditText) activity.findViewById(R.id.et_manter_reuniao_tema);
        campoData = (EditText) activity.findViewById(R.id.et_manter_reuniao_data);
        campoLogradouro = (EditText) activity.findViewById(R.id.et_manter_reuniao_logradouro);
        campoComplemento = (EditText) activity.findViewById(R.id.et_manter_reuniao_complemento);
        campoCidade = (EditText) activity.findViewById(R.id.et_manter_reuniao_cidade);
        campoBairro = (EditText) activity.findViewById(R.id.et_manter_reuniao_bairro);
        campoCep = (EditText) activity.findViewById(R.id.et_manter_reuniao_cep);
        campoUF = (EditText) activity.findViewById(R.id.et_manter_reuniao_uf);
        campoNumero = (EditText) activity.findViewById(R.id.et_manter_reuniao_numero);
        campoDescricao = (EditText) activity.findViewById(R.id.et_manter_reuniao_descricao);
        campoLatitude = (EditText) activity.findViewById(R.id.et_manter_reuniao_latitude);
        campoLongitude = (EditText) activity.findViewById(R.id.et_manter_reuniao_longitude);
        campoId = (EditText) activity.findViewById(R.id.et_manter_reuniao_id);
        Reuniao = new Reuniao();
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

    public com.project.impacta.ibvn.model.Reuniao getReuniao() {
        return Reuniao;
    }

    public void setReuniao(com.project.impacta.ibvn.model.Reuniao reuniao) {
        Reuniao = reuniao;
    }

    public EditText getCampoNumero() {
        return campoNumero;
    }

    public void setCampoNumero(EditText campoNumero) {
        this.campoNumero = campoNumero;
    }

    public EditText getCampoComplemento() {
        return campoComplemento;
    }

    public void setCampoComplemento(EditText campoComplemento) {
        this.campoComplemento = campoComplemento;
    }

    public EditText getCampoLongitude() {
        return campoLongitude;
    }

    public void setCampoLongitude(EditText campoLongitude) {
        this.campoLongitude = campoLongitude;
    }

    public EditText getCampoLatitude() {
        return campoLatitude;
    }

    public void setCampoLatitude(EditText campoLatitude) {
        this.campoLatitude = campoLatitude;
    }

    public EditText getCampoId() {
        return campoId;
    }

    public void setCampoId(EditText campoId) {
        this.campoId = campoId;
    }


    public Reuniao getReuniaoFromData() {

        String[] strData = campoData.getText().toString().split("/");
        this.Reuniao.setData(strData[2] + "-" + strData[1] + "-" + strData[0]);

        this.Reuniao.setDescricao(campoDescricao.getText().toString());
        this.Reuniao.setStatus("Nova");
        this.Reuniao.setTema(campoTema.getText().toString());
        this.Reuniao.setCep(campoCep.getText().toString());
        this.Reuniao.setLogradouro(campoLogradouro.getText().toString());
        this.Reuniao.setComplemento(campoComplemento.getText().toString());
        this.Reuniao.setNumero(campoNumero.getText().toString());
        this.Reuniao.setBairro(campoBairro.getText().toString());
        this.Reuniao.setCidade(campoCidade.getText().toString());
        this.Reuniao.setUf(campoUF.getText().toString());
        this.Reuniao.setNumero(campoNumero.getText().toString());
        this.Reuniao.setLatitude(Double.parseDouble(campoLatitude.getText().toString()));
        this.Reuniao.setLongitude(Double.parseDouble(campoLongitude.getText().toString()));
        this.Reuniao.setId(Integer.parseInt((campoId.getText().toString())));
        return this.Reuniao;
    }

    public void setReuniaoFromModel(Reuniao reuniao) {

        String[] data = reuniao.getData().split("-");

        campoData.setText(data[2] + "/" + data[1] + "/" + data[0]);
        campoDescricao.setText(reuniao.getDescricao());
        campoTema.setText(reuniao.getTema().toString());
        campoCep.setText(reuniao.getCep().toString());
        campoLogradouro.setText(reuniao.getLogradouro().toString());
        campoComplemento.setText(reuniao.getComplemento().toString());
        campoNumero.setText(reuniao.getNumero().toString());
        campoBairro.setText(reuniao.getBairro().toString());
        campoCidade.setText(reuniao.getCidade().toString());
        campoUF.setText(reuniao.getUf().toString());
        campoNumero.setText(reuniao.getNumero().toString());
        campoLatitude.setText(Double.toString(reuniao.getLatitude()));
        campoLongitude.setText(Double.toString(reuniao.getLongitude()));
        campoId.setText(Long.toString((reuniao.getId())));
    }


    public void preencherDadosEndereco(Map<String, String> dados) {
        this.campoCep.setText(dados.get("cep").toString());
        this.campoCidade.setText(dados.get("cidade").toString());
        this.campoBairro.setText(dados.get("bairro").toString());
        this.campoLogradouro.setText(dados.get("logradouro").toString());
        this.campoBairro.setText(dados.get("uf").toString());
        this.campoLatitude.setText(dados.get("latitude").toString());
        this.campoLongitude.setText(dados.get("longitude").toString());

    }
}

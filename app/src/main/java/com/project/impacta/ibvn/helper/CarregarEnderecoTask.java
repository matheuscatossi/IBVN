package com.project.impacta.ibvn.helper;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.project.impacta.ibvn.ManterReuniaoActivity;

import java.io.IOException;
import java.util.Map;

public class CarregarEnderecoTask extends AsyncTask<Void, Void, Map<String, String>> {

    private Context context;
    private ProgressDialog progress;
    private EditText campoNumero;
    private EditText campoCep;
    private EditText campoCidade;
    private EditText campoBairro;
    private EditText campoLogradouro;
    private EditText campoUf;
    private EditText campoLatitude;
    private EditText campoLongitude;
    private String CEP;

    public CarregarEnderecoTask(String cep,
                                EditText campoCep,
                                EditText campoCidade,
                                EditText campoBairro,
                                EditText campoLogradouro,
                                EditText campoUf,
                                EditText campoNumero,
                                Context context) {

        this.CEP = cep;
        this.campoCep = campoCep;
        this.campoCidade = campoCidade;
        this.campoBairro = campoBairro;
        this.campoLogradouro = campoLogradouro;
        this.campoUf = campoUf;
        this.campoNumero = campoNumero;

        this.campoLatitude = new EditText(context);
        this.campoLongitude = new EditText(context);

        this.context = context;
        this.progress = new ProgressDialog(this.context);
    }

    public CarregarEnderecoTask(String cep,
                                EditText campoCep,
                                EditText campoCidade,
                                EditText campoBairro,
                                EditText campoLogradouro,
                                EditText campoUf,
                                EditText campoNumero,
                                EditText campoLatitude,
                                EditText campoLongitude,
                                Context context) {

        this.CEP = cep;
        this.campoCep = campoCep;
        this.campoCidade = campoCidade;
        this.campoBairro = campoBairro;
        this.campoLogradouro = campoLogradouro;
        this.campoUf = campoUf;
        this.campoNumero = campoNumero;
        this.campoLatitude = campoLatitude;
        this.campoLongitude = campoLongitude;
        this.context = context;
        this.progress = new ProgressDialog(this.context);
    }


    @Override
    protected Map<String, String> doInBackground(Void... params) {

        Map<String, String> dadosEndereco = null;
        try {

            if (this.CEP.equals("")) {
                return dadosEndereco;
            }

            dadosEndereco = BuscaCep.getEnderecoFull(this.CEP);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return dadosEndereco;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progress.setMessage("Buscando informações!");
        progress.setIndeterminate(false);
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setCancelable(false);
        progress.show();
    }

    @Override
    protected void onPostExecute(Map<String, String> stringStringMap) {
        super.onPostExecute(stringStringMap);

        clearFields();

        if (stringStringMap == null) {
            Toast.makeText(context, "O Campo Cep deve ser preenchido!", Toast.LENGTH_LONG).show();
            progress.dismiss();
            return;
        }

        if (stringStringMap.size() == 0) {
            Toast.makeText(context, "CEP inválido", Toast.LENGTH_LONG).show();
            progress.dismiss();
            return;
        }


        this.campoCep.setText(String.format("%s-%s", stringStringMap.get("cep").substring(0, 5), stringStringMap.get("cep").substring(5)));
        this.campoCidade.setText(stringStringMap.get("cidade").toString());
        this.campoBairro.setText(stringStringMap.get("bairro").toString());
        this.campoLogradouro.setText(stringStringMap.get("logradouro").toString());
        this.campoUf.setText(stringStringMap.get("uf").toString());
        this.campoLatitude.setText(stringStringMap.get("latitude").toString());
        this.campoLongitude.setText(stringStringMap.get("longitude").toString());
        this.campoNumero.requestFocus();

        progress.dismiss();

    }


    private void clearFields() {
        this.campoCep.setText("");
        this.campoCidade.setText("");
        this.campoBairro.setText("");
        this.campoLogradouro.setText("");
        this.campoUf.setText("");
        this.campoNumero.setText("");
        this.campoLatitude.setText("");
        this.campoLongitude.setText("");
    }
}

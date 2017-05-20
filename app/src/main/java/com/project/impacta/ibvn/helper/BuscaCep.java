package com.project.impacta.ibvn.helper;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;


public class BuscaCep {

    public static String getLatLong(String CEP) throws IOException {

        Document doc;
        StringBuilder cepHif;

        try {

            if (!CEP.contains("-")) {
                cepHif = new StringBuilder(CEP);
                cepHif.insert(CEP.length() - 3, '-');
            } else {
                cepHif = new StringBuilder(CEP);
            }

            doc = Jsoup
                    .connect(
                            "http://maps.googleapis.com/maps/api/geocode/xml?address="
                                    + cepHif + "&language=pt-BR&sensor=true")
                    .timeout(120000).get();

            Elements lat = doc.select("geometry").select("location")
                    .select("lat");
            Elements lng = doc.select("geometry").select("location")
                    .select("lng");

            for (Element Latitude : lat) {
                for (Element Longitude : lng) {
                    return Latitude.text() + "," + Longitude.text();
                }
            }


        } catch (SocketTimeoutException e) {

        } catch (HttpStatusException w) {

        }
        return CEP;
    }

    public static Map<String, String> getEnderecoFull(String CEP) throws IOException {

        Map dados = new HashMap();

        try {

            Document doc = Jsoup
                    .connect("http://api.postmon.com.br/v1/cep/" + CEP + "?format=xml")
                    .timeout(120000).get();

            if (doc != null) {
                dados.put("bairro", doc.select("result").select("bairro").html().trim());
                dados.put("cidade", doc.select("result").select("cidade").html().trim());
                dados.put("cep", doc.select("result").select("cep").html().trim());
                dados.put("logradouro", doc.select("result").select("logradouro").html().trim());
                dados.put("estado_nome", doc.select("result").select("estado_info").select("nome").html().trim());
                dados.put("uf", doc.select("result").select("estado").html().trim());
                dados.put("codigo_ibge", doc.select("result").select("cidade_info").select("codigo_ibge").html().trim());
            }

            String latLong = getLatLong(CEP);

            if (!CEP.equals(latLong)) {

                String[] arrDados = latLong.split(",");
                dados.put("latitude", arrDados[0]);
                dados.put("longitude", arrDados[1]);
            }


        } catch (SocketTimeoutException e) {
            e.printStackTrace();
        } catch (HttpStatusException w) {
            w.printStackTrace();
        }finally {
            return dados;
        }

    }
}

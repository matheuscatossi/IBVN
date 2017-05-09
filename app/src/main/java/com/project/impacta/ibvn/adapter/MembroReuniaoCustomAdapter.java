package com.project.impacta.ibvn.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project.impacta.ibvn.R;
import com.project.impacta.ibvn.model.Membro;
import com.project.impacta.ibvn.model.MembroReuniao;
import com.project.impacta.ibvn.model.MembroReuniao;
import com.project.impacta.ibvn.webservice.APIClient;
import com.project.impacta.ibvn.webservice.APIInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by matheuscatossi on 5/8/17.
 */

public class MembroReuniaoCustomAdapter extends ArrayAdapter<MembroReuniao> implements View.OnClickListener {


    private Call<Membro> callMembroReuniao;
    private ArrayList<MembroReuniao> dataSet;
    private Context mContext;

    private static class ViewHolder {
        ImageView img_user;
        ImageView img_about;
        TextView tv_nome;
        TextView tv_email;
        CheckBox checkbox_presenca;
        LinearLayout ll_linha;
    }

    public MembroReuniaoCustomAdapter(ArrayList<MembroReuniao> data, Context context) {
        super(context, R.layout.row_item_membro_reuniao, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        MembroReuniao membroReuniao = (MembroReuniao) object;

    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final MembroReuniao membroReuniao = getItem(position);
        ViewHolder viewHolder;


        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item_membro_reuniao, parent, false);

            viewHolder.img_user = (ImageView) convertView.findViewById(R.id.img_user);
            viewHolder.img_about = (ImageView) convertView.findViewById(R.id.img_about);

            viewHolder.tv_email = (TextView) convertView.findViewById(R.id.tv_email);
            viewHolder.tv_nome = (TextView) convertView.findViewById(R.id.tv_nome);

            viewHolder.ll_linha = (LinearLayout) convertView.findViewById(R.id.ll_linha);

            viewHolder.checkbox_presenca = (CheckBox) convertView.findViewById(R.id.checkbox_presenca);
            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        lastPosition = position;

        if(membroReuniao.getPresente() == 0) {
            viewHolder.checkbox_presenca.setChecked(false);
        } else {
            viewHolder.checkbox_presenca.setChecked(true);
        }

        if (membroReuniao.getMembro().getSexo() != null) {
            if (membroReuniao.getMembro().getSexo().equals("M")) {
                viewHolder.img_user.setImageResource(R.drawable.user_m);
            } else {
                viewHolder.img_user.setImageResource(R.drawable.user_f);
            }
        }

        viewHolder.tv_nome.setText(membroReuniao.getMembro().getNome());
        viewHolder.tv_nome.setTypeface(null, Typeface.BOLD);

        viewHolder.tv_email.setText(membroReuniao.getMembro().getEmail());

        viewHolder.ll_linha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        viewHolder.checkbox_presenca.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.e("checado", "" + membroReuniao.getMembro().getId() + " - " + isChecked);

                MembroReuniao membroReuniaoPost;
                membroReuniaoPost = new MembroReuniao(membroReuniao.getFk_reuniao(),  membroReuniao.getMembro().getId(), Boolean.compare(isChecked, false));


                APIInterface apiService = APIClient.getService().create(APIInterface.class);
                callMembroReuniao = apiService.postPresencaMembroReuniao(membroReuniaoPost);


                callMembroReuniao.enqueue(new Callback<Membro>() {

                    @Override
                    public void onResponse(Call<Membro> call, Response<Membro> response) {
                        if (response.raw().code() == 200) {
                            Membro t = response.body();
                            Log.e("MEMBROREUNIAOPRESENCA", "" + response.raw().body().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<Membro> call, Throwable t) {
                        Log.e("MEMBROREUNIAOPRESENCA", t.toString());
                    }

                });

            }
        });

        return convertView;
    }
}
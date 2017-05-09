package com.project.impacta.ibvn.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project.impacta.ibvn.R;
import com.project.impacta.ibvn.model.MembroReuniao;
import com.project.impacta.ibvn.model.MembroReuniao;

import java.util.ArrayList;

/**
 * Created by matheuscatossi on 5/8/17.
 */

public class MembroReuniaoCustomAdapter extends ArrayAdapter<MembroReuniao> implements View.OnClickListener {

    private ArrayList<MembroReuniao> dataSet;
    Context mContext;

    private static class ViewHolder {
        ImageView img_user;
        ImageView img_about;
        TextView tv_nome;
        TextView tv_email;
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

            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        lastPosition = position;


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

        return convertView;
    }
}
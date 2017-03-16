package com.project.impacta.ibvn.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project.impacta.ibvn.InfoMembroActivity;
import com.project.impacta.ibvn.R;
import com.project.impacta.ibvn.model.MembroModel;

import java.util.ArrayList;

/**
 * Created by Matheus on 12/02/2017.
 */

public class MembroCustomAdapter extends ArrayAdapter<MembroModel> implements View.OnClickListener {

    private ArrayList<MembroModel> dataSet;
    Context mContext;

    private static class ViewHolder {
        ImageView img_user;
        ImageView img_about;
        TextView tv_nome;
        TextView tv_email;
        LinearLayout ll_linha;
    }

    public MembroCustomAdapter(ArrayList<MembroModel> data, Context context) {
        super(context, R.layout.row_item_membro, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        MembroModel membroModel = (MembroModel) object;

    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final MembroModel membroModel = getItem(position);
        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item_membro, parent, false);

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

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;


        if (membroModel.getSexoMembro().equals("M")) {
            viewHolder.img_user.setImageResource(R.drawable.user_m);
        } else {
            viewHolder.img_user.setImageResource(R.drawable.user_f);
        }

        viewHolder.tv_nome.setText(membroModel.getNomeMembro());
        viewHolder.tv_nome.setTypeface(null, Typeface.BOLD);

        viewHolder.tv_email.setText(membroModel.getEmailMembro());

        viewHolder.ll_linha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, InfoMembroActivity.class);

                i.putExtra("codigoMembro", String.valueOf(membroModel.getCodMembro()));

                mContext.startActivity(i);
            }
        });

        return convertView;
    }
}


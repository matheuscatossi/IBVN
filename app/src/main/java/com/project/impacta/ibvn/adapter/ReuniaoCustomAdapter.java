package com.project.impacta.ibvn.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project.impacta.ibvn.InfoReuniaoActivity;
import com.project.impacta.ibvn.R;
import com.project.impacta.ibvn.model.Reuniao;

import java.util.ArrayList;

public class ReuniaoCustomAdapter extends ArrayAdapter<Reuniao> implements View.OnClickListener {

    private ArrayList<Reuniao> dataSet;
    private Context mContext;

    private static class ViewHolder {
        ImageView img_reuniao;
        TextView tv_tema;
        TextView tv_data;
        LinearLayout ll_linha;
    }

    public ReuniaoCustomAdapter(ArrayList<Reuniao> data, Context context) {
        super(context, R.layout.row_item_reuniao, data);

        this.dataSet = data;
        this.mContext = context;
    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        Reuniao reuniao = (Reuniao) object;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {


        final Reuniao reuniao = getItem(position);
        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item_reuniao, parent, false);

            viewHolder.img_reuniao = (ImageView) convertView.findViewById(R.id.img_reuniao);
            viewHolder.tv_tema = (TextView) convertView.findViewById(R.id.tv_tema_reuniao);
            viewHolder.tv_data = (TextView) convertView.findViewById(R.id.tv_data_reuniao);
            viewHolder.ll_linha = (LinearLayout) convertView.findViewById(R.id.ll_linha);

            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.img_reuniao.setImageResource(R.drawable.reuniao_1);

        try {

            assert reuniao != null;
            viewHolder.tv_tema.setText(reuniao.getTema());
            viewHolder.tv_tema.setTypeface(null, Typeface.BOLD);

            viewHolder.tv_data.setText(reuniao.getData().substring(8) + "/"+ reuniao.getData().substring(5,7) + "/" + reuniao.getData().substring(0,4));
            viewHolder.tv_data.setTypeface(null, Typeface.BOLD);

            viewHolder.ll_linha.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(mContext, InfoReuniaoActivity.class);

                    i.putExtra("id", String.valueOf(reuniao.getId()));

                    mContext.startActivity(i);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        return convertView;
    }
}

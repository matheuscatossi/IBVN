package com.project.impacta.ibvn.adapter;

import android.content.Context;
import android.content.Intent;
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
import com.project.impacta.ibvn.InfoReuniaoActivity;
import com.project.impacta.ibvn.R;
import com.project.impacta.ibvn.model.EnderecoModel;
import com.project.impacta.ibvn.model.MembroModel;
import com.project.impacta.ibvn.model.ReuniaoModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by proje on 12/02/2017.
 */

public class ReuniaoCustomAdapter extends ArrayAdapter<ReuniaoModel> implements View.OnClickListener {

    private ArrayList<ReuniaoModel> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        ImageView img_reuniao;
        TextView tv_tema;
        TextView tv_data;
        LinearLayout ll_linha;
    }

    public ReuniaoCustomAdapter(ArrayList<ReuniaoModel> data, Context context) {
        super(context, R.layout.row_item_reuniao, data);

        this.dataSet = data;
        this.mContext = context;
    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        ReuniaoModel reuniaoModel = (ReuniaoModel) object;

        switch (v.getId()) {
            /*case R.id.item_info:
                Snackbar.make(v, "Release date " +extratoListModel.getFeature(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
                break;*/
        }
    }


    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final ReuniaoModel reuniaoModel = getItem(position);
        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item_reuniao, parent, false);

            viewHolder.img_reuniao = (ImageView) convertView.findViewById(R.id.img_reuniao);
            // viewHolder.img_about = (ImageView) convertView.findViewById(R.id.img_about);

            viewHolder.tv_tema = (TextView) convertView.findViewById(R.id.tv_tema);
            viewHolder.tv_data = (TextView) convertView.findViewById(R.id.tv_data);

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

        viewHolder.img_reuniao.setImageResource(R.drawable.reuniao_1);
/*

        viewHolder.tv_tema.setText(reuniaoModel.getTema());
        viewHolder.tv_tema.setTypeface(null, Typeface.BOLD);

        Calendar dataReuniao = reuniaoModel.getData();
        Date data = dataReuniao.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        viewHolder.tv_data.setText(sdf.format(data));

        viewHolder.ll_linha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar dataReuniao = reuniaoModel.getData();
                Date data = dataReuniao.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                Intent i = new Intent(mContext, InfoReuniaoActivity.class);

                i.putExtra("codigo", String.valueOf(reuniaoModel.getCodigo()));
                i.putExtra("tema", String.valueOf(reuniaoModel.getTema()));
                i.putExtra("data", String.valueOf(sdf.format(data)));
                i.putExtra("endereco", String.valueOf(reuniaoModel.getCelula().getEndereco().toString()));
                i.putExtra("lider", String.valueOf(reuniaoModel.getCelula().getLider().getNomeMembro()));
                i.putExtra("lider_email", String.valueOf(reuniaoModel.getCelula().getLider().getEmailMembro()));
                i.putExtra("agendado_por", String.valueOf(reuniaoModel.getCelula().getCriado_por().getNomeMembro()));

                mContext.startActivity(i);
            }
        });
*/


        //viewHolder.img_about.setImageResource(R.drawable.about);

        return convertView;
    }
}

package com.project.impacta.ibvn.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.project.impacta.ibvn.InfoNewsfeedActivity;
import com.project.impacta.ibvn.R;
import com.project.impacta.ibvn.model.NewsFeedModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matheus on 22/03/2017.
 */


public class NewsFeedCustomAdapter extends RecyclerView.Adapter<NewsFeedCustomAdapter.MyViewHolder> {

    private Context mContext;
    private List<NewsFeedModel> newsfeedList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail, overflow;
        public LinearLayout ll_card_newsfeed;
        public MyViewHolder(View view) {
            super(view);
            title         = (TextView) view.findViewById(R.id.title);
            count         = (TextView) view.findViewById(R.id.count);
            thumbnail     = (ImageView) view.findViewById(R.id.thumbnail);
            overflow      = (ImageView) view.findViewById(R.id.overflow);
            ll_card_newsfeed = (LinearLayout) view.findViewById(R.id.newsfeeds_card);
        }
    }


    public NewsFeedCustomAdapter(Context mContext, List<NewsFeedModel> newsfeedList) {
        this.mContext = mContext;
        this.newsfeedList = newsfeedList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.newsfeed_card, parent, false);

        return new MyViewHolder(itemView);
    }
    NewsFeedModel newsfeed;
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        newsfeed =  newsfeedList.get(position);
        holder.title.setText(newsfeed.getNome());
        holder.count.setText("Info : "  + newsfeed.getNome());
        //holder.overflow.setImageResource(R.drawable.three_dots);
        holder.ll_card_newsfeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, InfoNewsfeedActivity.class);
                i.putExtra("id",newsfeed.getId());
//                i.putExtra("dataCriacao",newsfeed.getDataCriacao());
//                i.putExtra("descricao",newsfeed.getDescricao());
//                i.putExtra("previsao",newsfeed.getPrevisao());
//                i.putExtra("valor",newsfeed.getValor());
//                i.putExtra("valorInvestido",newsfeed.getValorInvestido());
//                i.putExtra("imgnewsfeed",newsfeed.getImgnewsfeed());
                mContext.startActivity(i);
            }
        });

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, InfoNewsfeedActivity.class);
                i.putExtra("id",newsfeed.getId());
//                i.putExtra("dataCriacao",newsfeed.getDataCriacao());
//                i.putExtra("descricao",newsfeed.getDescricao());
//                i.putExtra("previsao",newsfeed.getPrevisao());
//                i.putExtra("valor",newsfeed.getValor());
//                i.putExtra("valorInvestido",newsfeed.getValorInvestido());
//                i.putExtra("imgnewsfeed",""+newsfeed.getImgnewsfeed());
                mContext.startActivity(i);
            }
        });


        Glide.with(mContext).load(newsfeed.getImgPrincipal()).into(holder.thumbnail);

    }



    @Override
    public int getItemCount() {
        return newsfeedList.size();
    }
}



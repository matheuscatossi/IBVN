package com.project.impacta.ibvn.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.project.impacta.ibvn.InfoNewsfeedActivity;
import com.project.impacta.ibvn.R;
import com.project.impacta.ibvn.Utils.Constants;
import com.project.impacta.ibvn.model.Evento;
import com.project.impacta.ibvn.model.NewsFeed;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Matheus on 22/03/2017.
 */

public class NewsFeedCustomAdapter extends RecyclerView.Adapter<NewsFeedCustomAdapter.MyViewHolder> {

    private Context mContext;
    private List<Evento> eventoList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail, overflow;
        public LinearLayout ll_card_evento;

        public MyViewHolder(View view) {
            super(view);
            title         = (TextView) view.findViewById(R.id.title);
            count         = (TextView) view.findViewById(R.id.count);
            thumbnail     = (ImageView) view.findViewById(R.id.thumbnail);
            overflow      = (ImageView) view.findViewById(R.id.overflow);
            ll_card_evento = (LinearLayout) view.findViewById(R.id.newsfeeds_card);


        }
    }

    public NewsFeedCustomAdapter(Context mContext, List<Evento> eventoList) {
        this.mContext = mContext;
        this.eventoList = eventoList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.newsfeed_card, parent, false);

        return new MyViewHolder(itemView);
    }
    Evento evento;
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        evento =  eventoList.get(position);
        holder.title.setText(evento.getNome());
        holder.count.setText("Info : "  + evento.getNome());

        new DownloadImageTask(holder.thumbnail).execute(Constants.URL + evento.getLink_imagem());

        holder.ll_card_evento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, InfoNewsfeedActivity.class);
                i.putExtra("id",String.valueOf(evento.getId()));

                Log.e("IDIDIIDID", String.valueOf(evento.getId()));

                mContext.startActivity(i);
            }
        });

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, InfoNewsfeedActivity.class);
                i.putExtra("id",evento.getId());
                i.putExtra("id",evento.getData());
                i.putExtra("id",evento.getNome());
                //i.putExtra("id",evento.getDescricao());
                i.putExtra("id",evento.getId());
                i.putExtra("id",evento.getId());
                i.putExtra("id",evento.getId());



                mContext.startActivity(i);
            }
        });

        Glide.with(mContext).load(evento.getLink_imagem()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return eventoList.size();
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}





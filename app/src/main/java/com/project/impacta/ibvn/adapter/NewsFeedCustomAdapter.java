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
import com.project.impacta.ibvn.model.NewsFeed;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Matheus on 22/03/2017.
 */

public class NewsFeedCustomAdapter extends RecyclerView.Adapter<NewsFeedCustomAdapter.MyViewHolder> {

    private Context mContext;
    private List<NewsFeed> newsfeedList;

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

    public NewsFeedCustomAdapter(Context mContext, List<NewsFeed> newsfeedList) {
        this.mContext = mContext;
        this.newsfeedList = newsfeedList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.newsfeed_card, parent, false);

        return new MyViewHolder(itemView);
    }
    NewsFeed newsfeed;
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        newsfeed =  newsfeedList.get(position);
        holder.title.setText(newsfeed.getNome());
        holder.count.setText("Info : "  + newsfeed.getNome());

        new DownloadImageTask(holder.thumbnail).execute(Constants.URL + newsfeed.getImgPrincipal());

        holder.ll_card_newsfeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, InfoNewsfeedActivity.class);
                i.putExtra("id",String.valueOf(newsfeed.getId()));

                Log.e("IDIDIIDID", String.valueOf(newsfeed.getId()));

                mContext.startActivity(i);
            }
        });

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, InfoNewsfeedActivity.class);
                i.putExtra("id",newsfeed.getId());

                mContext.startActivity(i);
            }
        });

        Glide.with(mContext).load(newsfeed.getImgPrincipal()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return newsfeedList.size();
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





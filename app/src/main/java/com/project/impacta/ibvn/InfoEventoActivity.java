package com.project.impacta.ibvn;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.project.impacta.ibvn.R;
import com.project.impacta.ibvn.SugestoesActivity;
import com.project.impacta.ibvn.Utils.Constants;
import com.project.impacta.ibvn.adapter.EventoCustomAdapter;
import com.project.impacta.ibvn.helper.DownloadImageTask;

/**
 * Created by Matheus on 23/03/2017.
 */

public class InfoEventoActivity extends AppCompatActivity {

    ImageView img_evento;
    TextView tv_nome_evento;
    TextView tv_descricao_evento;
    TextView tv_data_evento;
    TextView tv_data_criacao;
    TextView tv_link_video;
    LinearLayout ll_link_video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_newsfeed);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Drawable drawableAux = getResources().getDrawable(R.drawable.back);
        Bitmap bitmap = ((BitmapDrawable) drawableAux).getBitmap();
        Drawable drawable = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, 40, 40, true));
        toolbar.setNavigationIcon(drawable);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent myIntent = getIntent();
        String id = myIntent.getStringExtra("cod");
        String data = myIntent.getStringExtra("data");
        String nome = myIntent.getStringExtra("nome");
        String descricao = myIntent.getStringExtra("descricao");
        String tipo = myIntent.getStringExtra("tipo");
        String imagem = myIntent.getStringExtra("imagem");
        final String link = myIntent.getStringExtra("link");
        String create_at = myIntent.getStringExtra("create_at");
        String update_at = myIntent.getStringExtra("update_at");

        img_evento = (ImageView) findViewById(R.id.img_evento);
        tv_nome_evento = (TextView) findViewById(R.id.tv_nome_evento);
        tv_descricao_evento = (TextView) findViewById(R.id.tv_descricao_evento);
        tv_data_evento = (TextView) findViewById(R.id.tv_data_evento);
        tv_data_criacao = (TextView) findViewById(R.id.tv_data_criacao);
        tv_link_video = (TextView) findViewById(R.id.tv_link_video);
        ll_link_video = (LinearLayout) findViewById(R.id.ll_link_video);

        if(tipo.equals("imagem")) {
            new DownloadImageTask(img_evento).execute(Constants.URL + imagem);

            LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(300,300);
            img_evento.setLayoutParams(parms);
        } else {
            img_evento.setVisibility(View.INVISIBLE);
        }

        Log.e("tipo", ""+ tipo);
        Log.e("nome", ""+ nome);

        tv_nome_evento.setText(nome);
        tv_descricao_evento.setText(descricao);
        tv_data_evento.setText(data);
        tv_data_criacao.setText(create_at);
        tv_link_video.setText(link);

        if(tipo.equals("imagem")) {
            ll_link_video.setVisibility(View.INVISIBLE);
        } else {
            tv_link_video.setPaintFlags(tv_link_video.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        }

        tv_link_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(link)));
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.sugestoes) {
            Intent i = new Intent(this, SugestoesActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
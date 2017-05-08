package com.project.impacta.ibvn;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.project.impacta.ibvn.adapter.MembroCustomAdapter;
import com.project.impacta.ibvn.adapter.EventoCustomAdapter;
import com.project.impacta.ibvn.adapter.ReuniaoCustomAdapter;
import com.project.impacta.ibvn.helper.GPlus;
import com.project.impacta.ibvn.helper.ImageLoadTask;
import com.project.impacta.ibvn.model.Celula;
import com.project.impacta.ibvn.model.Evento;
import com.project.impacta.ibvn.model.Membro;
import com.project.impacta.ibvn.model.Reuniao;
import com.project.impacta.ibvn.webservice.APIClient;
import com.project.impacta.ibvn.webservice.APIInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import pub.devrel.easypermissions.EasyPermissions;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, EasyPermissions.PermissionCallbacks {

    //Properties
    private GoogleSignInOptions gso;
    private GPlus GPlusData;
    private GoogleApiClient mGoogleApiClient;
    private ViewPager mViewPager;
    private FloatingActionButton fabReuniao;
    private FloatingActionButton fabUser;
    static SectionsPagerAdapter mSectionsPagerAdapter;
    static int selectedTab;
    DrawerLayout drawer;


    //Dados do membro Logado
    private static Membro membroLider;
    private static Membro membroCriador;
    private static Celula celula;
    private ImageView headerUserImage;
    private TextView headerUserName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //GET control
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        fabUser = (FloatingActionButton) findViewById(R.id.fabUser);
        fabReuniao = (FloatingActionButton) findViewById(R.id.fabReuniao);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        //seta o herder do menu lateral
        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        View navHeaderView = navView.inflateHeaderView(R.layout.nav_header_main);
        headerUserName = (TextView) navHeaderView.findViewById(R.id.nav_header_main_tv_nome);
        headerUserImage = (ImageView) navHeaderView.findViewById(R.id.nav_header_main_iv_logo);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


        //Dados de login com conta google

        GPlusData = (GPlus) getIntent().getSerializableExtra("GPLUSDATA");

        if (GPlusData != null) {
            gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestEmail()
                    .build();

            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .enableAutoManage(this, null)
                    .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                    .build();


            ImageLoadTask imgTask = new ImageLoadTask(GPlusData.getPhotoUrl(),headerUserImage);
            imgTask.execute();

            headerUserName.setText(GPlusData.getGivenName());
            Toast.makeText(MainActivity.this, "Bem vindo \n" + GPlusData.getDisplaName(), Toast.LENGTH_LONG).show();

        }else{
            headerUserName.setText("Líder");
        }
        //FIM Dados de login  com conta google.



        try {
            membroLider = new Membro(1, "João José", "jj@gmail.com.br", "M");
            membroCriador = (Membro) membroLider.clone();
            celula = new Celula(1, "Célula Irmão Dones", "25/12/2017", "25/12/2017", membroCriador, membroLider);

        } catch (CloneNotSupportedException ex) {
            membroCriador = membroLider;
            celula = new Celula(1, "Célula Irmão Dones", "25/12/2017", "25/12/2017", membroCriador, membroLider);
        }

        try {

            fabUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedTab = 1;
                    Intent manterMembroIntent = new Intent(MainActivity.this, ManterMembroActivity.class);
                    manterMembroIntent.putExtra("CELULA", membroLider);
                    startActivity(manterMembroIntent);
                }
            });


            fabReuniao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedTab = 2;
                    Intent manterReuniaoIntent = new Intent(MainActivity.this, ManterReuniaoActivity.class);
                    manterReuniaoIntent.putExtra("CELULA", celula);
                    startActivity(manterReuniaoIntent);
                }
            });

            tabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager) {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    super.onTabSelected(tab);

                    fabUser = (FloatingActionButton) findViewById(R.id.fabUser);
                    fabReuniao = (FloatingActionButton) findViewById(R.id.fabReuniao);

                    if (tab.getPosition() == 3) {
                        fabReuniao.setVisibility(View.INVISIBLE);
                        fabUser.setVisibility(View.INVISIBLE);
                    } else {
                        fabReuniao.setVisibility(View.VISIBLE);
                        fabUser.setVisibility(View.VISIBLE);
                    }
                }
            });

            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.setDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);


        } catch (Exception ex) {
            throw ex;
        }
    }

    //    protected void onResume() {
    //        super.onResume();
    //        mViewPager.setCurrentItem((selectedTab != 1) ? selectedTab : 1);
    //    }

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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.configuracoes) {
            Intent i = new Intent(this, ConfiguracoesActivity.class);
            startActivity(i);
        } else if (id == R.id.contato) {
            Intent i = new Intent(this, ContatoActivity.class);
            startActivity(i);
        } else if (id == R.id.mensagem) {
            Intent i = new Intent(this, MensagemActivity.class);
            startActivity(i);
        } else if (id == R.id.celula) {
            Intent i = new Intent(this, CelulaActivity.class);
            startActivity(i);
        } else if (id == R.id.logout) {

            if (GPlusData != null) {

                Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
                        new ResultCallback<Status>() {
                            @Override
                            public void onResult(Status status) {
                                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                                startActivity(i);
                                finish();
                            }
                        });
            } else {
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
            ;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {

    }

    public static class PlaceholderFragment extends Fragment {
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public ArrayList<Membro> membroList;
        public ArrayList<Reuniao> reuniaoList;
        public ArrayList<Evento> eventoList;

        ListView listViewMembro;
        ListView listViewReuniao;
        ListView listViewEvento;
        RecyclerView recyclerView;

        MembroCustomAdapter membroCustomAdapter;
        ReuniaoCustomAdapter reuniaoCustomAdapter;
        EventoCustomAdapter eventoCustomAdapter;


        // Chat
        public WebView mWebView;

        // Membro
        Call<List<Membro>> call;
        Call<List<Reuniao>> callReuniao;
        Call<List<Evento>> callEventos;

        APIInterface apiService;

        @Override
        public void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
        }

        @Override
        public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
            super.onViewStateRestored(savedInstanceState);
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView;

            switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
                case 1:
                    rootView = inflater.inflate(R.layout.fragment_newsfeed, container, false);

                    recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);

                    RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
                    recyclerView.setLayoutManager(mLayoutManager);

                    apiService = APIClient.getService().create(APIInterface.class);
                    callEventos = apiService.getEventos();
                    eventoList = new ArrayList<>();

                    callEventos.enqueue(new Callback<List<Evento>>() {
                        @Override
                        public void onResponse(Call<List<Evento>> call, Response<List<Evento>> response) {
                            if (response.raw().code() == 200) {

                                for (Evento evento : response.body()) {
                                    eventoList.add(new Evento(evento.getId(), evento.getData(), evento.getNome().toString(), evento.getDescricao(), evento.getTipo(), evento.getLink_imagem(), evento.getLink(), evento.getCreated_at(), evento.getUpdate_at()));
                                }

                                Collections.reverse(eventoList);
                                eventoCustomAdapter = new EventoCustomAdapter(getContext(), eventoList);

                                recyclerView.setAdapter(eventoCustomAdapter);

                            }
                        }

                        @Override
                        public void onFailure(Call<List<Evento>> call, Throwable t) {
                            Log.e("INFOEVENTOS", t.toString());
                        }
                    });
                    break;
                case 2:
                    rootView = inflater.inflate(R.layout.fragment_membro, container, false);
                    listViewMembro = (ListView) rootView.findViewById(R.id.listMembro);

                    new Timer().scheduleAtFixedRate(new TimerTask() {
                        @Override
                        public void run() {
                            apiService = APIClient.getService().create(APIInterface.class);
                            call = apiService.getMembros();
                            membroList = new ArrayList<>();

                            call.enqueue(new Callback<List<Membro>>() {
                                @Override
                                public void onResponse(Call<List<Membro>> call, Response<List<Membro>> response) {
                                    if (response.raw().code() == 200) {

                                        List<Membro> l = new ArrayList<Membro>();
                                        l.addAll(response.body());

                                        for (Membro membro : l) {
                                            membroList.add(new Membro((int) membro.getId(), (String) membro.getNome(), (String) membro.getEmail(), (String) membro.getSexo()));
                                        }

                                        Collections.reverse(membroList);
                                        membroCustomAdapter = new MembroCustomAdapter(membroList, getContext());
                                        listViewMembro.setAdapter(membroCustomAdapter);

                                    }
                                }

                                @Override
                                public void onFailure(Call<List<Membro>> call, Throwable t) {
                                    Log.e("INFOMEMBRO", t.toString());
                                }
                            });
                        }
                    }, 0, 3000);

                    break;
                case 3:

                    selectedTab = 2;
                    rootView = inflater.inflate(R.layout.fragment_reuniao, container, false);
                    listViewReuniao = (ListView) rootView.findViewById(R.id.listReuniao);

                    new Timer().scheduleAtFixedRate(new TimerTask() {
                        @Override
                        public void run() {
                            apiService = APIClient.getService().create(APIInterface.class);
                            callReuniao = apiService.getReunioes();
                            reuniaoList = new ArrayList<>();

                            callReuniao.enqueue(new Callback<List<Reuniao>>() {
                                @Override
                                public void onResponse(Call<List<Reuniao>> call, Response<List<Reuniao>> response) {
                                    if (response.raw().code() == 200) {

                                        List<Reuniao> l = new ArrayList<Reuniao>();
                                        l.addAll(response.body());

                                        for (Reuniao reuniao : l) {
                                            reuniaoList.add(
                                                    new Reuniao(
                                                            (int) reuniao.getId(),
                                                            (String) reuniao.getData(),
                                                            (String) reuniao.getTema(),
                                                            (String) reuniao.getDescricao())
                                            );
                                        }

                                        Collections.reverse(reuniaoList);
                                        reuniaoCustomAdapter = new ReuniaoCustomAdapter(reuniaoList, getContext());
                                        listViewReuniao.setAdapter(reuniaoCustomAdapter);
                                    }
                                }

                                @Override
                                public void onFailure(Call<List<Reuniao>> call, Throwable t) {
                                    Log.e("INFOMEMBRO", t.toString());
                                }
                            });
                        }
                    }, 0, 60000);

                    break;

                case 4:
                    rootView = inflater.inflate(R.layout.fragment_chat, container, false);

                    mWebView = (WebView) rootView.findViewById(R.id.webView);
                    mWebView.getSettings().setJavaScriptEnabled(true);
                    mWebView.getSettings().setDomStorageEnabled(true);
                    mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                    mWebView.loadUrl("http://bankbox.net.br/ibvn/watson/index.htm");
                    break;
                default:
                    rootView = inflater.inflate(R.layout.fragment_newsfeed, container, false);
                    break;
            }
            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {

            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "NEWSFEED";
                case 1:
                    return "MEMBROS";
                case 2:
                    return "REUNIÕES";
                case 3:
                    return "CHAT";
            }
            return null;
        }
    }

}

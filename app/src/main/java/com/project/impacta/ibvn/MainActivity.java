package com.project.impacta.ibvn;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import android.webkit.WebView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.services.calendar.CalendarScopes;
import com.project.impacta.ibvn.adapter.MembroCustomAdapter;
import com.project.impacta.ibvn.adapter.ReuniaoCustomAdapter;
import com.project.impacta.ibvn.model.CelulaModel;
import com.project.impacta.ibvn.model.EnderecoModel;
import com.project.impacta.ibvn.model.MembroModel;
import com.project.impacta.ibvn.model.ReuniaoModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by Matheus on 12/02/2017.
 */

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,EasyPermissions.PermissionCallbacks {

    GoogleAccountCredential mCredential;
    private TextView mOutputText;
    private Button mCallApiButton;
    ProgressDialog mProgress;

    static final int REQUEST_ACCOUNT_PICKER = 1000;
    static final int REQUEST_AUTHORIZATION = 1001;
    static final int REQUEST_GOOGLE_PLAY_SERVICES = 1002;
    static final int REQUEST_PERMISSION_GET_ACCOUNTS = 1003;

    private static final String BUTTON_TEXT = "Call Google Calendar API";
    private static final String PREF_ACCOUNT_NAME = "accountName";
    private static final String[] SCOPES = { CalendarScopes.CALENDAR_READONLY };



    private static SectionsPagerAdapter mSectionsPagerAdapter;
    private static ViewPager mViewPager;
    public static FloatingActionButton fabReuniao;
    public static FloatingActionButton fabUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());


        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


        fabUser = (FloatingActionButton) findViewById(R.id.fabUser);
        fabUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Adicionar Usuário - Feature em desenvolvimento", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        fabReuniao = (FloatingActionButton) findViewById(R.id.fabReuniao);
        fabReuniao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Adicionar Reuniao - Feature em desenvolvimento", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        tabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager) {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                super.onTabSelected(tab);

                if (tab.getPosition() == 3) {
                    MainActivity.fabReuniao.setVisibility(View.INVISIBLE);
                    MainActivity.fabUser.setVisibility(View.INVISIBLE);
                } else {
                    MainActivity.fabReuniao.setVisibility(View.VISIBLE);
                    MainActivity.fabUser.setVisibility(View.VISIBLE);
                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    protected void onResume() {
        super.onResume();
        mViewPager.setCurrentItem(1);
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
            finish();
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

        public ArrayList<MembroModel> membroList;
        public ArrayList<ReuniaoModel> reuniaoList;
        ListView listViewMembro;
        ListView listViewReuniao;
        MembroCustomAdapter membroCustomAdapter;
        ReuniaoCustomAdapter reuniaoCustomAdapter;

        // Chat
        public WebView mWebView;

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
                    rootView = inflater.inflate(R.layout.fragment_evento, container, false);
                    break;
                case 2:
                    rootView = inflater.inflate(R.layout.fragment_membro, container, false);
                    listViewMembro = (ListView) rootView.findViewById(R.id.listMembro);
                    membroList = new ArrayList<>();

                    membroList.add(new MembroModel(1, "João José", "jj@jj.com.br", "M"));
                    membroList.add(new MembroModel(1, "Cesar Astolfo", "castolfo@hotmail.com", "M"));
                    membroList.add(new MembroModel(1, "Carlos Junior", "carlosj@gmail.com", "M"));
                    membroList.add(new MembroModel(1, "Maria de Fatima", "mrfcatossi@terra.com.br", "F"));
                    membroList.add(new MembroModel(1, "Matheus Catossi", "matheuscatossi@gmail.com", "M"));
                    membroList.add(new MembroModel(1, "João José", "jj@jj.com.br", "M"));
                    membroList.add(new MembroModel(1, "Cesar Astolfo", "castolfo@hotmail.com", "M"));
                    membroList.add(new MembroModel(1, "Carlos Junior", "carlosj@gmail.com", "M"));
                    membroList.add(new MembroModel(1, "Maria de Fatima", "mrfcatossi@terra.com.br", "F"));
                    membroList.add(new MembroModel(1, "Matheus Catossi", "matheuscatossi@gmail.com", "M"));

                    Collections.reverse(membroList);
                    membroCustomAdapter = new MembroCustomAdapter(membroList, getContext());
                    listViewMembro.setAdapter(membroCustomAdapter);

                    break;
                case 3:

                    rootView = inflater.inflate(R.layout.fragment_reuniao, container, false);

                    listViewReuniao = (ListView) rootView.findViewById(R.id.listReuniao);
                    reuniaoList = new ArrayList<>();

                    MembroModel membroLider = new MembroModel(1, "João José", "jj@gmail.com.br", "M");
                    MembroModel membroCriador = new MembroModel(1, "Edinaldo Santos", "ed@gmail.com.br", "M");
                    EnderecoModel endereco = new EnderecoModel("06246090", "R:Morrinhos", "2", "Munhooz Junior", "Osasco", "SP");
                    CelulaModel celula = new CelulaModel(1, "Célula Irmão Dones", "25/12/2017", "25/12/2017", membroCriador, membroLider, endereco);

                    reuniaoList.add(
                            new ReuniaoModel(1, "30/02/2017", "Todos Por Uma OPE", "Nova", "Reunião para orar pelo fim do semestre e todos passarem"
                                    , new CelulaModel(1, "Célula Irmão Dones", "25/12/2017", "25/12/2017", membroCriador, membroLider, endereco)
                            )
                    );

                    reuniaoList.add(
                            new ReuniaoModel(2, "25/03/2017", "Vida em Cristo", "Nova", "Entender como a vida pode ser bem vivida quando estamos com deus."
                                    , new CelulaModel(1, "Célula Irmão Tiago", "25/12/2017", "25/12/2017", membroCriador, membroLider, endereco)
                            )
                    );

                    reuniaoList.add(
                            new ReuniaoModel(3, "21/04/2017", "Todos Por Uma OPE", "Nova", "Reunião para orar pelo fim do semestre e todos passarem"
                                    , new CelulaModel(1, "Célula Irmão Dones", "25/12/2017", "25/12/2017", membroCriador, membroLider, endereco)
                            )
                    );

                    reuniaoList.add(
                            new ReuniaoModel(4, "30/02/2017", "Todos Por Uma OPE", "Nova", "Reunião para orar pelo fim do semestre e todos passarem"
                                    , new CelulaModel(1, "Célula Irmão Dones", "25/12/2017", "25/12/2017", membroCriador, membroLider, endereco)
                            )
                    );


                    Collections.reverse(reuniaoList);
                    reuniaoCustomAdapter = new ReuniaoCustomAdapter(reuniaoList, getContext());
                    listViewReuniao.setAdapter(reuniaoCustomAdapter);
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
                    rootView = inflater.inflate(R.layout.fragment_evento, container, false);
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
            // Show 3 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "EVENTOS";
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

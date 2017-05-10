package com.project.impacta.ibvn;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.project.impacta.ibvn.Utils.Constants;
import com.project.impacta.ibvn.helper.GPlus;
import com.project.impacta.ibvn.model.Login;
import com.project.impacta.ibvn.model.Membro;
import com.project.impacta.ibvn.model.Mensagem;
import com.project.impacta.ibvn.webservice.APIClient;
import com.project.impacta.ibvn.webservice.APIInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Matheus on 19/02/2017.
 */

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int RC_SIGN_IN = 007;

    private GoogleApiClient mGoogleApiClient;
    private ProgressDialog mProgressDialog;
    private SignInButton btn_login_google;
    private Button btn_acessar;
    private Button btnSignOut, btnRevokeAccess;

    private EditText et_login;
    private EditText et_cpf;
    private ProgressDialog progress;

    private Call<Membro> callLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, null)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso).build();

        btn_acessar = (Button) findViewById(R.id.btn_acessar);
        btn_login_google = (SignInButton) findViewById(R.id.sign_in_button);

        // Customizing G+ button
        btn_login_google.setSize(SignInButton.SIZE_STANDARD);
        btn_login_google.setScopes(gso.getScopeArray());

        et_cpf = (EditText) findViewById(R.id.et_cpf);
        et_login = (EditText) findViewById(R.id.et_login);


        try {
            btn_acessar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //signInGoogle();

                    String email = et_login.getText().toString();
                    String cpf = et_cpf.getText().toString();

                    Login loginPost = new Login(email, cpf);

                    if (email.length() == 0) {
                        Toast.makeText(getApplicationContext(),
                                "Digite o login!", Toast.LENGTH_LONG).show();
                        return;
                    }

                    if (cpf.length() == 0) {
                        Toast.makeText(getApplicationContext(),
                                "Digite sua senha", Toast.LENGTH_LONG).show();
                        return;
                    }

                    APIInterface apiService = APIClient.getService().create(APIInterface.class);
                    callLogin = apiService.postLogin(loginPost);


                    progress = ProgressDialog.show(LoginActivity.this, "Carregando", "Enviando informações", true);

                    Log.e("request", ""+ callLogin.request());
                    Log.e("request", ""+ callLogin.toString());

                    callLogin.enqueue(new Callback<Membro>() {
                        @Override
                        public void onResponse(Call<Membro> call, Response<Membro> response) {
                            if (response.raw().code() == 200) {
                                if (response.body().getFk_celula() != 0) {
                                    Membro t = response.body();
                                    Constants.CELULA = "" + t.getFk_celula();

                                    progress.dismiss();

                                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(i);
                                    finish();
                                } else {
                                    progress.dismiss();
                                    Toast.makeText(LoginActivity.this.getBaseContext(), "Login incorreto!", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                progress.dismiss();
                                Toast.makeText(LoginActivity.this.getBaseContext(), "Login incorreto!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Membro> call, Throwable t) {
                            progress.dismiss();

                            Toast.makeText(LoginActivity.this.getBaseContext(), "Erro no servidor, tentar novamente!", Toast.LENGTH_SHORT).show();

                        }

                    });


                }
            });

            btn_login_google.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (v.getId()) {
                        case R.id.sign_in_button:
                            signInGoogle();
                            break;
                    }
                }
            });

        } catch (Throwable ex) {
            throw ex;
        }
    }

    private void signInGoogle() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private void revokeAccess() {
        Auth.GoogleSignInApi.revokeAccess(mGoogleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        updateUI(false, null);
                    }
                });
    }

    private void handleSignInResult(GoogleSignInResult result) {
        //Log.d(TAG, "handleSignInResult:" + result.isSuccess());
        if (result.isSuccess()) {
            updateUI(true, result);
        } else {
            updateUI(false, result);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        try {

            OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(mGoogleApiClient);

            if (opr.isDone()) {

                GoogleSignInResult result = opr.get();
                handleSignInResult(result);

            }
        } catch (Throwable ex) {
            throw ex;
        }
    }

    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d(TAG, "onConnectionFailed:" + connectionResult);
    }

    private void showProgressDialog() {

        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage(getString(R.string.str_loading));
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    private void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.hide();
        }
    }


    private void updateUI(boolean isSignedIn, GoogleSignInResult result) {
        try {

            if (isSignedIn) {

                btn_login_google.setVisibility(View.GONE);

                //Get dados from ggole account
                GoogleSignInAccount acct = result.getSignInAccount();
                GPlus GPlusData = new GPlus(acct);

                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                i.putExtra("GPLUSDATA", GPlusData);
                startActivity(i);

                finish();

            } else {
                btn_login_google.setVisibility(View.VISIBLE);
            }

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            throw e;
        }
    }


}

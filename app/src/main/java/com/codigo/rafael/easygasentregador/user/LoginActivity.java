package com.codigo.rafael.easygasentregador.user;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.codigo.rafael.easygasentregador.MainActivity;
import com.codigo.rafael.easygasentregador.R;


import org.json.JSONException;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;
    private static final String chaveFacebook = "+F7e0vDnxU8H4co9SGbWQVmkNKY=";
    private static final String hashFacebook = "Hni6PDUXmVmo09glvl3+iicOtNo=";
    private static final String shaGoogle = "4A:E2:9D:23:C1:66:F0:C5:E2:B2:F0:60:D0:E8:87:EF:43:9F:F9:12";
    private static final String clientIDGoogle = "313647538384-aqaid1nb1b12ujhl17ibaltbqu6gg2v5.apps.googleusercontent.com ";
    private static final String chaveGoogle = "GS18lbMtmrDtk_evc01RNLtO ";
    private static final int RC_SIGN_IN = 0;
    @Bind(R.id.et_email_login_activity)
    EditText _emailText;
    @Bind(R.id.et_senha_login_activity)
    EditText _passwordText;
    @Bind(R.id.btn_login)
    Button _loginButton;
    @Bind(R.id.link_signup)
    TextView _signupLink;
    @Bind(R.id.link_esqueci_senha)
    TextView esqueciSenha;

    private SharedPreferences preferences;

    private String email;
    private Bundle parametr;
    private Button btGoogle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);


        parametr = new Bundle();

        preferences = getSharedPreferences("pref", Context.MODE_PRIVATE);
        String login = preferences.getString("login", null);
        String senha = preferences.getString("senha", null);


        if (login != null && senha != null) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
//            finish();
        }

        SpannableString spanString2 = new SpannableString(esqueciSenha.getText().toString());
        spanString2.setSpan(new UnderlineSpan(), 0, spanString2.length(), 0);
        spanString2.setSpan(new StyleSpan(Typeface.ITALIC), 0, spanString2.length(), 0);
        esqueciSenha.setText(spanString2);

        SpannableString spanString = new SpannableString(_signupLink.getText().toString());
        spanString.setSpan(new UnderlineSpan(), 0, spanString.length(), 0);
        spanString.setSpan(new StyleSpan(Typeface.ITALIC), 0, spanString.length(), 0);
        _signupLink.setText(spanString);


        _loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });

        esqueciSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mensagem();
            }
        });

        _passwordText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (keyEvent != null && KeyEvent.KEYCODE_ENTER == keyEvent.getKeyCode() || actionId == EditorInfo.IME_ACTION_DONE) {
                    login();

                }

                return false;
            }

        });
    }


    public void login() {
        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        _loginButton.setEnabled(false);

//        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
//                R.style.Theme_MyTheme);
//        progressDialog.setIndeterminate(true);
//        progressDialog.setMessage("Autenticando...");
//        progressDialog.show();

        final MaterialDialog dialog = new MaterialDialog.Builder(this)
                .title("")
                .content("Autenticando" + "\nPor favor, aguarde...")
                .icon(getResources().getDrawable(R.mipmap.ic_truck))
                .canceledOnTouchOutside(false)
                .contentColorRes(R.color.colorAccent)
                .progress(true, 0)
                .show();


        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        // TODO: Implement your own authentication logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginSuccess();
                        // onLoginFailed();
//                        progressDialog.dismiss();
                        dialog.dismiss();
                    }
                }, 2000);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    public void onLoginSuccess() {
        _loginButton.setEnabled(true);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login falhou", Toast.LENGTH_LONG).show();

        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("Insira um email válido");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 1 || password.length() > 15) {
            _passwordText.setError("A senha deve ter entre 4 e 10 caracteres");
            valid = true;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }

    private void mensagem() {
        EditText campo = new EditText(this);
        campo.setTextColor(Color.WHITE);
        AlertDialog.Builder dialog = new AlertDialog.Builder(this, R.style.AppTheme);
        dialog.setTitle("Insira seu email")
                .setMessage("Email: ")
                .setView(campo)
                .setPositiveButton("Enviar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(LoginActivity.this, "Email de recuperação de senha enviado com sucesso!", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    }

}

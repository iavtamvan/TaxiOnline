package id.can.web.taxionline;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import id.can.web.taxionline.Activity.HomeActivity;
import id.can.web.taxionline.Helper.Config;
import id.can.web.taxionline.Rest.Server.ApiServiceServer;
import id.can.web.taxionline.Rest.Server.ClientServer;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText edtUsername;
    private EditText edtPassword;
    private Button btnLogin;
    private TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiServiceServer apiServiceServer = ClientServer.getInstanceRetrofit();
                apiServiceServer.postLogin(edtUsername.getText().toString().trim(),
                        edtPassword.getText().toString().trim())
                        .enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                try {
                                    JSONObject jsonObject = new JSONObject(response.body().string());
                                    String error = jsonObject.optString("error");
                                    String login_token = jsonObject.optString("login_token");
                                    String user_id = jsonObject.optString("user_id");
                                    String nama_user = jsonObject.optString("nama_user");
                                    String email = jsonObject.optString("email");
                                    String telpon = jsonObject.optString("telpon");
                                    String rule = jsonObject.optString("rule");
                                    String device_id = jsonObject.optString("device_id");
                                    String login_waktu = jsonObject.optString("login_waktu");
                                    String login_fb = jsonObject.optString("login_fb");
                                    String login_google = jsonObject.optString("login_google");
                                    String avatar_path = jsonObject.optString("avatar_path");

                                    SharedPreferences sharedPreferences = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();

                                    editor.putString(Config.SHARED_PREF_TOKEN, login_token);
                                    editor.putString(Config.SHARED_USERNAME, user_id);
                                    editor.putString(Config.SHARED_NAMALENGKAP, nama_user);
                                    editor.putString(Config.SHARED_EMAIL, email);
                                    editor.putString(Config.SHARED_TELEPON, telpon);
                                    editor.putString(Config.SHARED_RULE, rule);
                                    editor.putString(Config.SHARED_HWID, device_id);
                                    editor.putString(Config.SHARED_LOGIN_WAKTU, login_waktu);
                                    editor.putString(Config.SHARED_LOGIN_FB, login_fb);
                                    editor.putString(Config.SHARED_LOGIN_GOOGLE, login_google);
                                    editor.putString(Config.SHARED_FOTO, avatar_path);

                                    editor.commit();

                                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                Toast.makeText(LoginActivity.this, "" + Config.ERROR_NETWORK, Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

    private void initView() {
        edtUsername = (EditText) findViewById(R.id.edt_username);
        edtPassword = (EditText) findViewById(R.id.edt_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        tvRegister = (TextView) findViewById(R.id.tv_register);
    }
}

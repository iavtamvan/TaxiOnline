package id.can.web.taxionline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

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
                                    String ID = jsonObject.optString("ID");
                                    String U_NAME = jsonObject.optString("U_NAME");
                                    String U_FULLNAME = jsonObject.optString("U_FULLNAME");
                                    String U_EMAIL = jsonObject.optString("U_EMAIL");
                                    String U_NOMOR = jsonObject.optString("U_NOMOR");
                                    String U_JK = jsonObject.optString("U_JK");
                                    String U_AVATAR = jsonObject.optString("U_AVATAR");

                                    Toast.makeText(LoginActivity.this, "" + error, Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                btnLogin.performClick();
                                Toast.makeText(LoginActivity.this, ""+ Config.ERROR_NETWORK, Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

    private void initView() {
        edtUsername = (EditText) findViewById(R.id.edt_username);
        edtPassword = (EditText) findViewById(R.id.edt_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
    }
}
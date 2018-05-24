package id.can.web.taxionline;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import id.can.web.taxionline.Helper.Config;
import id.can.web.taxionline.Rest.Server.ApiServiceServer;
import id.can.web.taxionline.Rest.Server.ClientServer;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    private String jenisKelamin;
    private EditText edtNamaLengkap;
    private EditText edtNohp;
    private EditText edtEmail;
    private EditText edtUsername;
    private EditText edtPassword;
    private RadioButton rbLakilaki;
    private RadioButton rbPerempuan;
    private Button btnRegister;
    private String deviceID;
    private long time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();

        deviceID = Settings.Secure.getString(getContentResolver(),
                Settings.Secure.ANDROID_ID);

        time= System.currentTimeMillis();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postRegister();
            }
        });
    }

    private void postRegister() {
        if (edtNamaLengkap.getText().toString().isEmpty() && edtEmail.getText().toString().isEmpty() && edtNohp.getText().toString().isEmpty() && edtPassword.getText().toString().isEmpty() && edtUsername.getText().toString().isEmpty()){
            Toast.makeText(this, "" + Config.ERROR_FORM_REGISTER, Toast.LENGTH_SHORT).show();
        } else {
            ApiServiceServer apiServiceServer  = ClientServer.getInstanceRetrofit();
            apiServiceServer.postRegister(edtUsername.getText().toString().trim(), edtNamaLengkap.getText().toString().trim(),
                    edtEmail.getText().toString().trim(),edtNohp.getText().toString().trim(),
                    edtPassword.getText().toString().trim(),jenisKelamin, deviceID)
                    .enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response.body().string());
                                String result = jsonObject.optString("msg");
                                Toast.makeText(RegisterActivity.this, "" + result, Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                                finish();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Toast.makeText(RegisterActivity.this, "" + Config.ERROR_NETWORK, Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }


    public void onClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.rb_lakilaki:
                if (checked) {
                    jenisKelamin = "1";
                }
                break;
            case R.id.rb_perempuan:
                if (checked) {
                    jenisKelamin = "0";
                }
                break;
        }
    }

    private void initView() {
        edtNamaLengkap = (EditText) findViewById(R.id.edt_namaLengkap);
        edtNohp = (EditText) findViewById(R.id.edt_nohp);
        edtEmail = (EditText) findViewById(R.id.edt_email);
        edtUsername = (EditText) findViewById(R.id.edt_username);
        edtPassword = (EditText) findViewById(R.id.edt_password);
        rbLakilaki = (RadioButton) findViewById(R.id.rb_lakilaki);
        rbPerempuan = (RadioButton) findViewById(R.id.rb_perempuan);
        btnRegister = (Button) findViewById(R.id.btn_register);
    }
}

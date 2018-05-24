package id.can.web.taxionline.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import id.can.web.taxionline.Helper.Config;
import id.can.web.taxionline.Model.CallCenterModel;
import id.can.web.taxionline.R;
import id.can.web.taxionline.Rest.Server.ApiServiceServer;
import id.can.web.taxionline.Rest.Server.ClientServer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CallCenterActivity extends AppCompatActivity {

    private ArrayList<CallCenterModel> callCenterModels;
    private TextView tvTelpon;
    private TextView tvFb;
    private TextView tvIg;
    private TextView tvAlamatKantor;
    private TextView tvWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_center);
        initView();
        callCenterModels = new ArrayList<>();

        getCallCenter();

    }

    private void getCallCenter() {
        ApiServiceServer apiServiceServer = ClientServer.getInstanceRetrofit();
        apiServiceServer.getCallCenter(Config.SHARED_PREF_USERID, Config.SHARED_PREF_TOKEN)
                .enqueue(new Callback<ArrayList<CallCenterModel>>() {
                    @Override
                    public void onResponse(Call<ArrayList<CallCenterModel>> call, Response<ArrayList<CallCenterModel>> response) {
                        callCenterModels = response.body();
                        for (int i = 0; i < callCenterModels.size(); i++) {
                            String msg = callCenterModels.get(i).getMsg();
                            String telpon = callCenterModels.get(i).getTelpon();
                            String facebook = callCenterModels.get(i).getFacebook();
                            String instagram = callCenterModels.get(i).getInstagram();
                            String alamat_office = callCenterModels.get(i).getAlamatOffice();
                            String website = callCenterModels.get(i).getWebsite();

                            tvTelpon.setText(telpon);
                            tvFb.setText(facebook);
                            tvIg.setText(instagram);
                            tvAlamatKantor.setText(alamat_office);
                            tvWebsite.setText(website);

                            // TODO Silahkan SETTEXT
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<CallCenterModel>> call, Throwable t) {
                        Toast.makeText(CallCenterActivity.this, "" + Config.ERROR_NETWORK, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void initView() {
        tvTelpon = (TextView) findViewById(R.id.tv_telpon);
        tvFb = (TextView) findViewById(R.id.tv_fb);
        tvIg = (TextView) findViewById(R.id.tv_ig);
        tvAlamatKantor = (TextView) findViewById(R.id.tv_alamat_kantor);
        tvWebsite = (TextView) findViewById(R.id.tv_website);
    }
}

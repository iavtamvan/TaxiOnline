package id.can.web.taxionline.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import id.can.web.taxionline.Helper.Config;
import id.can.web.taxionline.Model.KotaAwalModel;
import id.can.web.taxionline.Model.KotaTujuanModel;
import id.can.web.taxionline.R;
import id.can.web.taxionline.Rest.Server.ApiServiceServer;
import id.can.web.taxionline.Rest.Server.ClientServer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchKotaActivity extends AppCompatActivity {

    private LinearLayout div;
    private String bundleKota;


    private ArrayList<KotaAwalModel> kotaAwalModels;
    private ArrayList<KotaTujuanModel> kotaTujuanModels;
    private String username,tokenId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_kota);
        initView();
        kotaAwalModels = new ArrayList<>();
        kotaTujuanModels = new ArrayList<>();
        SharedPreferences sharedPreferences = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        username = sharedPreferences.getString(Config.SHARED_USERNAME, "");
        tokenId = sharedPreferences.getString(Config.SHARED_PREF_TOKEN, "");
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        bundleKota = bundle.getString(Config.BUNDLE_PILIHAN);


        if (bundleKota.equalsIgnoreCase("asal")){
            getDataKotaAsal();
        }else {
            getDataKotaTujuan();
        }


    }

    private void getDataKotaTujuan() {
        ApiServiceServer  apiServiceServer  = ClientServer.getInstanceRetrofit();
        apiServiceServer.getKotaTujuan(username, tokenId)
                .enqueue(new Callback<ArrayList<KotaTujuanModel>>() {
                    @Override
                    public void onResponse(Call<ArrayList<KotaTujuanModel>> call, Response<ArrayList<KotaTujuanModel>> response) {
                        kotaTujuanModels = response.body();
                        for (int i = 0; i < kotaTujuanModels.size(); i++) {

                            String bigID= kotaTujuanModels.get(i).getBigId();
                            final String kotaAwalID = kotaTujuanModels.get(i).getKotaTujuanId();
                            final String kotaAwalNama = kotaTujuanModels.get(i).getKotaTujuanNama();


                            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                            View addView = layoutInflater.inflate(R.layout.row_kota, null);

                            final LinearLayout divKlik = addView.findViewById(R.id.divKlik);
                            divKlik.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
//                                    Bundle bundle = new Bundle();
//                                    bundle.putString(Config.BUNDLE_KOTA_SINGKATAN, kotaAwalID);
//                                    bundle.putString(Config.BUNDLE_KOTA_NAMA, kotaAwalNama);
//                                    Intent intent = new Intent(getApplicationContext(), CariTaksiActivity.class);
//                                    intent.putExtras(bundle);
//                                    startActivity(intent);

//                                    Intent returnIntent = new Intent();
//                                    returnIntent.putExtra(Config.BUNDLE_KOTA_SINGKATAN,kotaAwalID);
//                                    returnIntent.putExtra(Config.BUNDLE_KOTA_TUJUAN,kotaAwalNama);
//                                    setResult(Activity.RESULT_OK,returnIntent);
//                                    finish();
                                    SharedPreferences sharedPreferences = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();


                                    editor.putString(Config.SHARED_KOTA_TUJUAN_LENGKAP, kotaAwalNama);
                                    editor.putString(Config.SHARED_KOTA_TUJUAN_SINGKATAN, kotaAwalID);

                                    editor.commit();

                                    startActivity(new Intent(getApplicationContext(), CariTaksiActivity.class));

                                }
                            });

                            final TextView tvNamaKota = addView.findViewById(R.id.row_tv_nama_kota);
                            tvNamaKota.setText(kotaAwalNama);
                            final TextView tvNamaKotaSingkatan = addView.findViewById(R.id.row_tv_nama_kota_singkatan);
                            tvNamaKotaSingkatan.setText("(" + kotaAwalID +")");

                            div.addView(addView);
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<KotaTujuanModel>> call, Throwable t) {
                        getDataKotaTujuan();
                        Toast.makeText(SearchKotaActivity.this, "" + Config.ERROR_NETWORK, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void getDataKotaAsal() {
        ApiServiceServer  apiServiceServer  = ClientServer.getInstanceRetrofit();
        apiServiceServer.getKotaAwal(username, tokenId)
                .enqueue(new Callback<ArrayList<KotaAwalModel>>() {
                    @Override
                    public void onResponse(Call<ArrayList<KotaAwalModel>> call, Response<ArrayList<KotaAwalModel>> response) {
                        kotaAwalModels = response.body();
                        for (int i = 0; i < kotaAwalModels.size(); i++) {
                            String bigID= kotaAwalModels.get(i).getBigId();
                            final String kotaAwalID = kotaAwalModels.get(i).getKotaAwalId();
                            final String kotaAwalNama = kotaAwalModels.get(i).getKotaAwalNama();


                            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                            View addView = layoutInflater.inflate(R.layout.row_kota, null);

                            final LinearLayout divKlik = addView.findViewById(R.id.divKlik);
                            divKlik.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
//                                    Bundle bundle = new Bundle();
//                                    bundle.putString(Config.BUNDLE_KOTA_SINGKATAN, kotaAwalID);
//                                    bundle.putString(Config.BUNDLE_KOTA_NAMA, kotaAwalNama);
//                                    Intent intent = new Intent(getApplicationContext(), CariTaksiActivity.class);
//                                    intent.putExtras(bundle);
//                                    startActivity(intent);
//                                    Intent returnIntent = new Intent();
//                                    returnIntent.putExtra(Config.BUNDLE_KOTA_SINGKATAN,kotaAwalID);
//                                    returnIntent.putExtra(Config.BUNDLE_KOTA_ASAL,kotaAwalNama);
//                                    setResult(Activity.RESULT_OK,returnIntent);
//                                    finish();
                                    SharedPreferences sharedPreferences = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();

                                    editor.putString(Config.SHARED_KOTA_AWAL_LENGKAP, kotaAwalNama);
                                    editor.putString(Config.SHARED_KOTA_AWAL_SINGKATAN, kotaAwalID);

                                    editor.commit();
                                    startActivity(new Intent(getApplicationContext(), CariTaksiActivity.class));


                                }
                            });

                            final TextView tvNamaKota = addView.findViewById(R.id.row_tv_nama_kota);
                            tvNamaKota.setText(kotaAwalNama);
                            final TextView tvNamaKotaSingkatan = addView.findViewById(R.id.row_tv_nama_kota_singkatan);
                            tvNamaKotaSingkatan.setText("(" + kotaAwalID +")");

                            div.addView(addView);


                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<KotaAwalModel>> call, Throwable t) {
                        getDataKotaAsal();
                        Toast.makeText(SearchKotaActivity.this, "" + Config.ERROR_NETWORK, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void initView() {
        div = (LinearLayout) findViewById(R.id.div);
    }
}

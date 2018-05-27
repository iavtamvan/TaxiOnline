package id.can.web.taxionline.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import id.can.web.taxionline.Adapter.OperatorTaxiAdapter;
import id.can.web.taxionline.Helper.Config;
import id.can.web.taxionline.Model.CariJadwalModel;
import id.can.web.taxionline.Model.OperatorTaxiModel;
import id.can.web.taxionline.R;
import id.can.web.taxionline.Rest.Server.ApiServiceServer;
import id.can.web.taxionline.Rest.Server.ClientServer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PilihOperatorTaxiActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    OperatorTaxiAdapter adapter;
    private ArrayList<OperatorTaxiModel> dataList;
    private ArrayList<CariJadwalModel> cariJadwalModels;
    private String postKursi;
    private String postTanggal;
    private String postKotaTujuan;
    private String postKotaAsal;
    private String username;
    private String tokenId;
    private RecyclerView rvOperatorTaxi;
    private LinearLayout div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_operator_taxi);
        cariJadwalModels = new ArrayList<>();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        SharedPreferences sharedPreferences = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        username = sharedPreferences.getString(Config.SHARED_USERNAME, "");
        tokenId = sharedPreferences.getString(Config.SHARED_PREF_TOKEN, "");
        postKotaAsal = bundle.getString(Config.BUNDLE_POST_KOTA_ASAL, "");
        postKotaTujuan = bundle.getString(Config.BUNDLE_POST_KOTA_TUJUAN, "");
        postTanggal = bundle.getString(Config.BUNDLE_POST_TANGGAL, "");
        postKursi = bundle.getString(Config.BUNDLE_POST_KURSI, "");

        postDataSearch();

//        addData();
//
//        recyclerView = findViewById(R.id.rv_operator_taxi);
//
//        adapter = new OperatorTaxiAdapter(dataList, PilihOperatorTaxiActivity.this);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(PilihOperatorTaxiActivity.this);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);
        initView();
    }

    private void postDataSearch() {
        ApiServiceServer apiServiceServer = ClientServer.getInstanceRetrofit();
        apiServiceServer.postCariJadwal(username, tokenId, postTanggal, postKursi, postKotaAsal, postKotaTujuan)
                .enqueue(new Callback<ArrayList<CariJadwalModel>>() {

                    @Override
                    public void onResponse(Call<ArrayList<CariJadwalModel>> call, Response<ArrayList<CariJadwalModel>> response) {
                        cariJadwalModels = response.body();
                        for (int i = 0; i < cariJadwalModels.size(); i++) {
//                                    String error = cariJadwalModels.get(i).get
                            final String perjalanan_tanggal = cariJadwalModels.get(i).getPerjalananTanggal();
                            final String perusahaan_id = cariJadwalModels.get(i).getPerusahaanId();
                            final String perusahaan_nama = cariJadwalModels.get(i).getPerusahaanNama();
                            final String kota_awal_id = cariJadwalModels.get(i).getKotaAwalId();
                            final String kota_awal = cariJadwalModels.get(i).getKotaAwal();
                            final String kota_tujuan_id = cariJadwalModels.get(i).getKotaTujuanId();
                            final String kota_tujuan = cariJadwalModels.get(i).getKotaTujuan();
                            final String rute = cariJadwalModels.get(i).getRute();
                            final String jam_berangkat_awal = cariJadwalModels.get(i).getJamBerangkatAwal();
                            final String jam_berangkat_akhir = cariJadwalModels.get(i).getJamBerangkatAkhir();
                            final String total_jam_perjalan = cariJadwalModels.get(i).getTotalJamPerjalan();
                            final String harga_awal = cariJadwalModels.get(i).getHargaAwal();
                            final String tarif_infane = String.valueOf(cariJadwalModels.get(i).getTarifInfane());
                            final String jumlah_pesan = cariJadwalModels.get(i).getJumlahPesan();
                            final String jumlah_bayar = cariJadwalModels.get(i).getJumlahBayar();


                            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                            View addView = layoutInflater.inflate(R.layout.row_operator_taxi, null);

                            final CardView cvOperatorTaxi = (CardView) addView.findViewById(R.id.cv_operator_taxi);
                            cvOperatorTaxi.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    SharedPreferences sharedPreferences  = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();

                                    editor.putString(Config.PERJALANAN_TANGGAL, perjalanan_tanggal);
                                    editor.putString(Config.PERUSAHAAN_ID, perusahaan_id);
                                    editor.putString(Config.PERUSAHAAN_NAMA, perusahaan_nama);
                                    editor.putString(Config.KOTA_AWAL_ID, kota_awal_id);
                                    editor.putString(Config.KOTA_AWAL, kota_awal);
                                    editor.putString(Config.KOTA_TUJUAN_ID, kota_tujuan_id);
                                    editor.putString(Config.KOTA_TUJUAN, kota_tujuan);
                                    editor.putString(Config.RUTE, rute);
                                    editor.putString(Config.JAM_BERANGKAT_AWAL, jam_berangkat_awal);
                                    editor.putString(Config.JAM_BERANGKAT_AKHIR, jam_berangkat_akhir);
                                    editor.putString(Config.TOTAL_JAM_PERJALAN, total_jam_perjalan);
                                    editor.putString(Config.HARGA_AWAL, harga_awal);
                                    editor.putString(Config.TARIF_INFANE, tarif_infane);
                                    editor.putString(Config.JUMLAH_PESAN, jumlah_pesan);
                                    editor.putString(Config.JUMLAH_BAYAR, jumlah_bayar);

                                    editor.commit();
                                    startActivity(new Intent(getApplicationContext(), IsiDataTaxiActivity.class));
                                }
                            });
                            final TextView tvNamaOperatorTaxi = (TextView) addView.findViewById(R.id.tv_nama_operator_taxi);
                            tvNamaOperatorTaxi.setText(perusahaan_nama);
                            final TextView tvJamOperatorTaxi = (TextView) addView.findViewById(R.id.tv_jam_operator_taxi);
                            tvJamOperatorTaxi.setText(jam_berangkat_awal + " - " + jam_berangkat_akhir);
                            final TextView tvEstimasiOperatorTaxi = (TextView) addView.findViewById(R.id.tv_estimasi_operator_taxi);
                            tvEstimasiOperatorTaxi.setText(total_jam_perjalan);
                            final LinearLayout linearHarga = (LinearLayout) addView.findViewById(R.id.linear_harga);
                            final TextView tvHargaOperatorTaxi = (TextView) addView.findViewById(R.id.tv_harga_operator_taxi);
                            tvHargaOperatorTaxi.setText(harga_awal);
                            final ImageView ivDetailTaxi = (ImageView) addView.findViewById(R.id.iv_detail_taxi);
                            ivDetailTaxi.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    startActivity(new Intent(getApplicationContext(), DetailTaxiActivity.class));
                                }
                            });


                            div.addView(addView);

                        }

                    }

                    @Override
                    public void onFailure(Call<ArrayList<CariJadwalModel>> call, Throwable t) {
                        Toast.makeText(PilihOperatorTaxiActivity.this, "" + Config.ERROR_NETWORK, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void addData() {

        dataList = new ArrayList<>();
        dataList.add(new OperatorTaxiModel("Baraya Travel", "08.00-12-00", "4 jam", "Rp 92000"));
        dataList.add(new OperatorTaxiModel("Day Trans", "06.00-10-00", "4 jam", "Rp 95000"));
        dataList.add(new OperatorTaxiModel("Xtrans", "19.00-23-00", "4 jam", "Rp 90000"));
        dataList.add(new OperatorTaxiModel("Cipaganti", "16.00-20-00", "4 jam", "Rp 96000"));
        dataList.add(new OperatorTaxiModel("Bimo Trans", "07.30-11-30", "4 jam", "Rp 100000"));
    }

    private void initView() {
        rvOperatorTaxi = (RecyclerView) findViewById(R.id.rv_operator_taxi);
        div = (LinearLayout) findViewById(R.id.div);
    }
}

package id.can.web.taxionline.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import id.can.web.taxionline.Helper.Config;
import id.can.web.taxionline.Model.BankModel;
import id.can.web.taxionline.R;
import id.can.web.taxionline.Rest.Server.ApiServiceServer;
import id.can.web.taxionline.Rest.Server.ClientServer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BankActivity extends AppCompatActivity {

    private LinearLayout div;

    private String perjalanan_tanggal;
    private String perusahaan_id;
    private String perusahaan_nama;
    private String kota_awal_id;
    private String kota_awal;
    private String kota_tujuan_id;
    private String kota_tujuan;
    private String rute;
    private String jam_berangkat_awal;
    private String jam_berangkat_akhir;
    private String total_jam_perjalan;
    private String harga_awal;
    private String tarif_infane;
    private String jumlah_pesan;
    private String jumlah_bayar;
    private String login_token;
    private String user_id;
    private String nama_user;
    private String email;
    private String telpon;
    private String rule;
    private String device_id;
    private String login_waktu;
    private String login_fb;
    private String login_google;
    private String avatar_path;


    private ArrayList<BankModel> bankModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);
        initView();

        bankModels = new ArrayList<>();
        SharedPreferences sharedPreferences = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        perjalanan_tanggal = sharedPreferences.getString(Config.PERJALANAN_TANGGAL, "");
        perusahaan_id = sharedPreferences.getString(Config.PERUSAHAAN_ID, "");
        perusahaan_nama = sharedPreferences.getString(Config.PERUSAHAAN_NAMA, "");
        kota_awal_id = sharedPreferences.getString(Config.KOTA_AWAL_ID, "");
        kota_awal = sharedPreferences.getString(Config.KOTA_AWAL, "");
        kota_tujuan_id = sharedPreferences.getString(Config.KOTA_TUJUAN_ID, "");
        kota_tujuan = sharedPreferences.getString(Config.KOTA_TUJUAN, "");
        rute = sharedPreferences.getString(Config.RUTE, "");
        jam_berangkat_awal = sharedPreferences.getString(Config.JAM_BERANGKAT_AWAL, "");
        jam_berangkat_akhir = sharedPreferences.getString(Config.JAM_BERANGKAT_AKHIR, "");
        total_jam_perjalan = sharedPreferences.getString(Config.TOTAL_JAM_PERJALAN, "");
        harga_awal = sharedPreferences.getString(Config.HARGA_AWAL, "");
        tarif_infane = sharedPreferences.getString(Config.TARIF_INFANE, "");
        jumlah_pesan = sharedPreferences.getString(Config.JUMLAH_PESAN, "");
        jumlah_bayar = sharedPreferences.getString(Config.JUMLAH_BAYAR, "");
        login_token = sharedPreferences.getString(Config.SHARED_PREF_TOKEN, "");
        user_id = sharedPreferences.getString(Config.SHARED_USERNAME, "");
        nama_user = sharedPreferences.getString(Config.SHARED_NAMALENGKAP, "");
        email = sharedPreferences.getString(Config.SHARED_EMAIL, "");
        telpon = sharedPreferences.getString(Config.SHARED_TELEPON, "");
        rule = sharedPreferences.getString(Config.SHARED_RULE, "");
        device_id = sharedPreferences.getString(Config.SHARED_HWID, "");
        login_waktu = sharedPreferences.getString(Config.SHARED_LOGIN_WAKTU, "");
        login_fb = sharedPreferences.getString(Config.SHARED_LOGIN_FB, "");
        login_google = sharedPreferences.getString(Config.SHARED_LOGIN_GOOGLE, "");
        avatar_path = sharedPreferences.getString(Config.SHARED_FOTO, "");


        getDataBank();
    }

    private void getDataBank() {
        final ProgressDialog loading = ProgressDialog.show(BankActivity.this, "Loading", "Mengambil data...", false, false);
        ApiServiceServer apiServiceServer = ClientServer.getInstanceRetrofit();
        apiServiceServer.getBank(user_id, login_token)
                .enqueue(new Callback<ArrayList<BankModel>>() {

                    @Override
                    public void onResponse(Call<ArrayList<BankModel>> call, Response<ArrayList<BankModel>> response) {
                        bankModels = response.body();
                        for (int i = 0; i < bankModels.size(); i++) {

                            final String TB_BIGID = bankModels.get(i).getTBBIGID();
                            final String TB_BANK_ID = bankModels.get(i).getTBBANKID();
                            final String TB_BANK_NAMA = bankModels.get(i).getTBBANKNAMA();
                            final String TB_REKENING_NAMA = bankModels.get(i).getTBREKENINGNAMA();
                            final String TB_REKENING_NOMOR = bankModels.get(i).getTBREKENINGNOMOR();
                            final String TB_BANK_STATUS = bankModels.get(i).getTBBANKSTATUS();
                            final String TB_BANK_AVATAR = bankModels.get(i).getTBBANKAVATAR();

                            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                            View addView = layoutInflater.inflate(R.layout.row_bank, null);


                            final TextView tvBankStatus = (TextView) addView.findViewById(R.id.tv_bank_status);
                            final TextView tvBankNomorRekening = (TextView) addView.findViewById(R.id.tv_bank_nomor_rekening);
                            final TextView tvBankNamaRekening = (TextView) addView.findViewById(R.id.tv_bank_nama_rekening);
                            final TextView tvBankNama = (TextView) addView.findViewById(R.id.tv_bank_nama);
                            final ImageView ivRowBank = (ImageView) addView.findViewById(R.id.iv_row_bank);

                            tvBankStatus.setText(TB_BANK_STATUS);
                            tvBankNomorRekening.setText(TB_REKENING_NOMOR);
                            tvBankNamaRekening.setText(TB_REKENING_NAMA);
                            tvBankNama.setText(TB_BANK_NAMA);
                            Glide.with(BankActivity.this).load(TB_BANK_AVATAR).into(ivRowBank);

                            loading.dismiss();
                            div.addView(addView);

                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<BankModel>> call, Throwable t) {
                        loading.dismiss();
                        Toast.makeText(BankActivity.this, "" + Config.ERROR_NETWORK, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void initView() {
        div = (LinearLayout) findViewById(R.id.div);
    }
}

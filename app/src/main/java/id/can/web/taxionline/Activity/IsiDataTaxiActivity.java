package id.can.web.taxionline.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import id.can.web.taxionline.Helper.Config;
import id.can.web.taxionline.R;

public class IsiDataTaxiActivity extends AppCompatActivity {


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


    private TextView tvPesanKotaAsal;
    private TextView tvPesanKotaTujuan;
    private TextView tvPesanTanggalBerangkat;
    private TextView tvPesanDetail;
    private TextView tvPesanArmada;
    private TextView tvPesanDetailKotaAsal;
    private TextView tvPesanDetailJamBerangkat;
    private TextView tvPesanDetailDurasiPerjalanan;
    private TextView tvPesanDetailKotaTujuan;
    private TextView tvPesanDetailJamSampai;
    private TextView tvPesanUsername;
    private TextView tvPesanEditUsername;
    private TextView tvPesanNomorTelpon;
    private TextView tvPesanEmail;
    private RelativeLayout relativePesanPilihKursi;
    private TextView tvPesanNomorKursi;
    private TextView tvPesanTotalBiaya;
    private LinearLayout linearPesanLanjutkan;
    private TextView tvPesanNamaDetailPenumpang;
    private TextView tvPesanKursi;
    private TextView tvPesanNomorKursiKlik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_data_taxi);
        initView();

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
        login_token = sharedPreferences.getString(Config.SHARED_PREF_TOKEN,"");
        user_id = sharedPreferences.getString(Config.SHARED_USERNAME,"");
        nama_user = sharedPreferences.getString(Config.SHARED_NAMALENGKAP,"");
        email = sharedPreferences.getString(Config.SHARED_EMAIL,"");
        telpon = sharedPreferences.getString(Config.SHARED_TELEPON,"");
        rule = sharedPreferences.getString(Config.SHARED_RULE,"");
        device_id = sharedPreferences.getString(Config.SHARED_HWID,"");
        login_waktu = sharedPreferences.getString(Config.SHARED_LOGIN_WAKTU,"");
        login_fb = sharedPreferences.getString(Config.SHARED_LOGIN_FB,"");
        login_google = sharedPreferences.getString(Config.SHARED_LOGIN_GOOGLE,"");
        avatar_path = sharedPreferences.getString(Config.SHARED_FOTO,"");

        tvPesanKotaAsal.setText(kota_awal);
        tvPesanKotaTujuan.setText(kota_tujuan);
        tvPesanTanggalBerangkat.setText(perjalanan_tanggal);
        tvPesanArmada.setText(perusahaan_nama);

        tvPesanDetailKotaAsal.setText(kota_awal);
        tvPesanDetailJamBerangkat.setText(jam_berangkat_awal);
        tvPesanDetailDurasiPerjalanan.setText(total_jam_perjalan);
        tvPesanDetailKotaTujuan.setText(kota_tujuan);
        tvPesanDetailJamSampai.setText(jam_berangkat_akhir);
        tvPesanUsername.setText(user_id);
        tvPesanNomorTelpon.setText(telpon);
        tvPesanEmail.setText(email);
        tvPesanTotalBiaya.setText(jumlah_bayar);
        tvPesanNamaDetailPenumpang.setText(nama_user);
        tvPesanKursi.setText(jumlah_pesan + " Kursi");



        linearPesanLanjutkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), BankActivity.class));
            }
        });


        tvPesanEditUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), DataPemesanTaxiActivity.class));
            }
        });

        tvPesanDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), DetailTaxiActivity.class));
            }
        });


    }

    private void initView() {
        tvPesanKotaAsal = findViewById(R.id.tv_pesan_kota_asal);
        tvPesanKotaTujuan = findViewById(R.id.tv_pesan_kota_tujuan);
        tvPesanTanggalBerangkat = findViewById(R.id.tv_pesan_tanggal_berangkat);
        tvPesanDetail = findViewById(R.id.tv_pesan_detail);
        tvPesanArmada = findViewById(R.id.tv_pesan_armada);
        tvPesanDetailKotaAsal = findViewById(R.id.tv_pesan_detail_kota_asal);
        tvPesanDetailJamBerangkat = findViewById(R.id.tv_pesan_detail_jam_berangkat);
        tvPesanDetailDurasiPerjalanan = findViewById(R.id.tv_pesan_detail_durasi_perjalanan);
        tvPesanDetailKotaTujuan = findViewById(R.id.tv_pesan_detail_kota_tujuan);
        tvPesanDetailJamSampai = findViewById(R.id.tv_pesan_detail_jam_sampai);
        tvPesanUsername = findViewById(R.id.tv_pesan_username);
        tvPesanEditUsername = findViewById(R.id.tv_pesan_edit_username);
        tvPesanNomorTelpon = findViewById(R.id.tv_pesan_nomor_telpon);
        tvPesanEmail = findViewById(R.id.tv_pesan_email);
        relativePesanPilihKursi = findViewById(R.id.relative_pesan_pilih_kursi);
        tvPesanTotalBiaya = findViewById(R.id.tv_pesan_total_biaya);
        linearPesanLanjutkan = findViewById(R.id.linear_pesan_lanjutkan);
        tvPesanNamaDetailPenumpang = (TextView) findViewById(R.id.tv_pesan_nama_detail_penumpang);
        tvPesanKursi = (TextView) findViewById(R.id.tv_pesan_kursi);
        tvPesanNomorKursiKlik = (TextView) findViewById(R.id.tv_pesan_nomor_kursi_klik);
    }
}

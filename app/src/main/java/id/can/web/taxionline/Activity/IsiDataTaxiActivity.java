package id.can.web.taxionline.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import id.can.web.taxionline.R;

public class IsiDataTaxiActivity extends AppCompatActivity {


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_data_taxi);

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

        initView();
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
        tvPesanNomorKursi = findViewById(R.id.tv_pesan_nomor_kursi);
        tvPesanTotalBiaya = findViewById(R.id.tv_pesan_total_biaya);
        linearPesanLanjutkan = findViewById(R.id.linear_pesan_lanjutkan);
    }
}

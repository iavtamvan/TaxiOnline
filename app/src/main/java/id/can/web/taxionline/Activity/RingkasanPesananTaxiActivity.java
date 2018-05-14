package id.can.web.taxionline.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import id.can.web.taxionline.R;

public class RingkasanPesananTaxiActivity extends AppCompatActivity {

    private TextView tvKotaAsalRingkasanTaxi;
    private TextView tvKotaTujuanRingkasanTaxi;
    private TextView tvTanggalBerangkatRingkasanTaxi;
    private TextView tvDetailRingkasanTaxi;
    private TextView tvArmadaRingkasanTaxi;
    private TextView tvJamBerangkatRingkasanTaxi;
    private TextView tvJamSampaiRingkasanTaxi;
    private TextView tvJumlahJamRingkasanTaxi;
    private TextView tvJumlahPenumpangRingkasanTaxi;
    private TextView tvHargaRingkasanTaxi;
    private LinearLayout linearPilihRingkasanTaxi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ringkasan_pesanan_taxi);
        initView();

        linearPilihRingkasanTaxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), IsiDataTaxiActivity.class));
            }
        });

        tvDetailRingkasanTaxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), DetailTaxiActivity.class));
            }
        });


    }

    private void initView() {
        tvKotaAsalRingkasanTaxi = findViewById(R.id.tv_kota_asal_ringkasan_taxi);
        tvKotaTujuanRingkasanTaxi = findViewById(R.id.tv_kota_tujuan_ringkasan_taxi);
        tvTanggalBerangkatRingkasanTaxi = findViewById(R.id.tv_tanggal_berangkat_ringkasan_taxi);
        tvDetailRingkasanTaxi = findViewById(R.id.tv_detail_ringkasan_taxi);
        tvArmadaRingkasanTaxi = findViewById(R.id.tv_armada_ringkasan_taxi);
        tvJamBerangkatRingkasanTaxi = findViewById(R.id.tv_jam_berangkat_ringkasan_taxi);
        tvJamSampaiRingkasanTaxi = findViewById(R.id.tv_jam_sampai_ringkasan_taxi);
        tvJumlahJamRingkasanTaxi = findViewById(R.id.tv_jumlah_jam_ringkasan_taxi);
        tvJumlahPenumpangRingkasanTaxi = findViewById(R.id.tv_jumlah_penumpang_ringkasan_taxi);
        tvHargaRingkasanTaxi = findViewById(R.id.tv_harga_ringkasan_taxi);
        linearPilihRingkasanTaxi = findViewById(R.id.linear_pilih_ringkasan_taxi);
    }
}

package id.can.web.taxionline.Activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import id.can.web.taxionline.Helper.Config;
import id.can.web.taxionline.Model.KotaAwalModel;
import id.can.web.taxionline.Model.KotaTujuanModel;
import id.can.web.taxionline.R;

public class CariTaksiActivity extends AppCompatActivity {
    Calendar myCalendar;
    private LinearLayout linearTaxiKotaAsal;
    private LinearLayout divKotaAsal;
    private TextView tvTaxiKotaAsal;
    private LinearLayout divKotaTujuan;
    private TextView tvTaxiKotaTujuan;
    private LinearLayout divTanggalPemesanan;
    private TextView tvTaxiTglBerangkat;
    private LinearLayout divJumlaPesanKursi;
    private TextView tvTaxiJumlahKursi;
    private CardView cvCariTaxi;
    private String username;
    private String tokenId;

    private ArrayList<KotaAwalModel> kotaAwalModels;
    private ArrayList<KotaTujuanModel> kotaTujuanModels;
    private String bundleKota;

    private String namaAsalKota, namaAsalSingkatanKota;
    private String namaTujuanKota, namaTujuabSingkatanKota;
    private String kursiID;
    private LinearLayout linearTaxiTglBerangkat;
    private TextView tvTaxiJumlahKursiHide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_taksi);
        initView();
        kotaAwalModels = new ArrayList<>();
        kotaTujuanModels = new ArrayList<>();


        SharedPreferences sharedPreferences = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        username = sharedPreferences.getString(Config.SHARED_USERNAME, "");
        tokenId = sharedPreferences.getString(Config.SHARED_PREF_TOKEN, "");

        namaAsalKota = sharedPreferences.getString(Config.SHARED_KOTA_AWAL_LENGKAP, "");
        namaAsalSingkatanKota = sharedPreferences.getString(Config.SHARED_KOTA_AWAL_SINGKATAN, "");

        if (namaAsalKota.isEmpty()) {
            tvTaxiKotaAsal.setText("Pilih kota asal");
        } else {
            tvTaxiKotaAsal.setText(namaAsalKota);
        }


        namaTujuanKota = sharedPreferences.getString(Config.SHARED_KOTA_TUJUAN_LENGKAP, "");
        namaTujuabSingkatanKota = sharedPreferences.getString(Config.SHARED_KOTA_TUJUAN_SINGKATAN, "");

        if (namaTujuanKota.isEmpty()) {
            tvTaxiKotaTujuan.setText("Pilih kota tujuan");
        } else {
            tvTaxiKotaTujuan.setText(namaTujuanKota);
        }


//        Intent intent = getIntent();
//        Bundle bundle = intent.getExtras();
//        tvTaxiKotaAsal.setText(bundle.getString(Config.BUNDLE_KOTA_SINGKATAN));
//        tvTaxiKotaTujuan.setText(bundle.getString(Config.BUNDLE_KOTA_NAMA));
//        bundleKota = bundle.getString(Config.BUNDLE_PILIHAN);


        cvCariTaxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString(Config.BUNDLE_POST_KOTA_ASAL, namaAsalSingkatanKota);
                bundle.putString(Config.BUNDLE_POST_KOTA_TUJUAN, namaTujuabSingkatanKota);
                bundle.putString(Config.BUNDLE_POST_TANGGAL, tvTaxiTglBerangkat.getText().toString().trim());
                bundle.putString(Config.BUNDLE_POST_KURSI, tvTaxiJumlahKursiHide.getText().toString().trim());
                Intent intent = new Intent(getApplicationContext(), PilihOperatorTaxiActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);

//                startActivity(new Intent(getApplicationContext(), PilihOperatorTaxiActivity.class));
            }
        });

        myCalendar = Calendar.getInstance();
        divTanggalPemesanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(CariTaksiActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        myCalendar.set(Calendar.YEAR, i);
                        myCalendar.set(Calendar.MONTH, i1);
                        myCalendar.set(Calendar.DAY_OF_MONTH, i2);

                        String fromTanggal = "dd-MMMM-yyyy";
                        SimpleDateFormat dateFormat = new SimpleDateFormat(fromTanggal);
                        tvTaxiTglBerangkat.setText(dateFormat.format(myCalendar.getTime()));
                    }
                },
                        myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        divJumlaPesanKursi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertKursi();
            }
        });

        divKotaAsal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString(Config.BUNDLE_PILIHAN, "asal");
                Intent intent = new Intent(getApplicationContext(), SearchKotaActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        divKotaTujuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString(Config.BUNDLE_PILIHAN, "tujuan");
                Intent intent = new Intent(getApplicationContext(), SearchKotaActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }


    private void alertKursi() {

        final CharSequence[] itemKursi = {"Pilih kursi","1", "2", "3", "4", "5", "6", "7", "8"};

        AlertDialog.Builder builder = new AlertDialog.Builder(CariTaksiActivity.this);
        builder.setTitle("Untuk Usia Diatas 2 Tahun");
        builder.setItems(itemKursi, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tvTaxiJumlahKursi.setText(itemKursi[i] + " Kursi");
                tvTaxiJumlahKursiHide.setText(itemKursi[i]);

            }
        }).show();

    }

    private void initView() {
        linearTaxiKotaAsal = (LinearLayout) findViewById(R.id.linear_taxi_kota_asal);
        divKotaAsal = (LinearLayout) findViewById(R.id.div_kota_asal);
        tvTaxiKotaAsal = (TextView) findViewById(R.id.tv_taxi_kota_asal);
        divKotaTujuan = (LinearLayout) findViewById(R.id.div_kota_tujuan);
        tvTaxiKotaTujuan = (TextView) findViewById(R.id.tv_taxi_kota_tujuan);
        divTanggalPemesanan = (LinearLayout) findViewById(R.id.div_tanggal_pemesanan);
        tvTaxiTglBerangkat = (TextView) findViewById(R.id.tv_taxi_tgl_berangkat);
        divJumlaPesanKursi = (LinearLayout) findViewById(R.id.div_jumla_pesan_kursi);
        tvTaxiJumlahKursi = (TextView) findViewById(R.id.tv_taxi_jumlah_kursi);
        cvCariTaxi = (CardView) findViewById(R.id.cv_cari_taxi);
        linearTaxiTglBerangkat = (LinearLayout) findViewById(R.id.linear_taxi_tgl_berangkat);
        tvTaxiJumlahKursiHide = (TextView) findViewById(R.id.tv_taxi_jumlah_kursi_hide);
    }
}

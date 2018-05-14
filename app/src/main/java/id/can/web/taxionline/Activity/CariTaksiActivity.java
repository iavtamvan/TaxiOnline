package id.can.web.taxionline.Activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import id.can.web.taxionline.R;

public class CariTaksiActivity extends AppCompatActivity {

    private LinearLayout linearTaxiKotaAsal;
    private TextView tvTaxiKotaAsal;
    private LinearLayout linearTaxiKotaTujuan;
    private TextView tvTaxiKotaTujuan;
    private LinearLayout linearTaxiTglBerangkat;
    private TextView tvTaxiTglBerangkat;
    private LinearLayout linearTaxiJumlahKursi;
    private TextView tvTaxiJumlahKursi;
    private CardView cvCariTaxi;
    Calendar myCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_taksi);
        initView();

        cvCariTaxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), PilihOperatorTaxiActivity.class));
            }
        });

        myCalendar = Calendar.getInstance();
        linearTaxiTglBerangkat.setOnClickListener(new View.OnClickListener() {
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

        linearTaxiJumlahKursi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertKursi();
            }
        });

    }

    private void alertKursi() {

        final CharSequence[] itemKursi = {"1 Kursi", "2 Kursi", "3 Kursi", "4 Kursi"};

        AlertDialog.Builder builder = new AlertDialog.Builder(CariTaksiActivity.this);
        builder.setTitle("Untuk Usia Diatas 2 Tahun");
        builder.setItems(itemKursi, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tvTaxiJumlahKursi.setText(itemKursi[i]);
            }
        }).show();

    }

    private void initView() {
        linearTaxiKotaAsal = findViewById(R.id.linear_taxi_kota_asal);
        tvTaxiKotaAsal = findViewById(R.id.tv_taxi_kota_asal);
        linearTaxiKotaTujuan = findViewById(R.id.linear_taxi_kota_tujuan);
        tvTaxiKotaTujuan = findViewById(R.id.tv_taxi_kota_tujuan);
        linearTaxiTglBerangkat = findViewById(R.id.linear_taxi_tgl_berangkat);
        tvTaxiTglBerangkat = findViewById(R.id.tv_taxi_tgl_berangkat);
        linearTaxiJumlahKursi = findViewById(R.id.linear_taxi_jumlah_kursi);
        tvTaxiJumlahKursi = findViewById(R.id.tv_taxi_jumlah_kursi);
        cvCariTaxi = findViewById(R.id.cv_cari_taxi);
    }
}

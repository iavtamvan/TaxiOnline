package id.can.web.taxionline.Fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import id.can.web.taxionline.Helper.Config;
import id.can.web.taxionline.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailTaxiFragment extends Fragment {


    private TextView tvDetailNamaTravel;
    private TextView tvDetailPerjalananTanggal;
    private TextView tvDetailKotaAsal;
    private TextView tvDetailPerjalananWaktuBerangkat;
    private TextView tvDetailWaktuDurasi;
    private TextView tvDetailKotaTujuan;
    private TextView tvDetailWaktuTiba;
    private TextView tvDetailRutePerjalanan;

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

    public DetailTaxiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_taxi, container, false);
        initView(view);
        SharedPreferences sharedPreferences  = getActivity().getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        perjalanan_tanggal = sharedPreferences.getString(Config.PERJALANAN_TANGGAL,"");
        perusahaan_id = sharedPreferences.getString(Config.PERUSAHAAN_ID,"");
        perusahaan_nama = sharedPreferences.getString(Config.PERUSAHAAN_NAMA,"");
        kota_awal_id = sharedPreferences.getString(Config.KOTA_AWAL_ID,"");
        kota_awal = sharedPreferences.getString(Config.KOTA_AWAL,"");
        kota_tujuan_id = sharedPreferences.getString(Config.KOTA_TUJUAN_ID,"");
        kota_tujuan = sharedPreferences.getString(Config.KOTA_TUJUAN,"");
        rute = sharedPreferences.getString(Config.RUTE,"");
        jam_berangkat_awal = sharedPreferences.getString(Config.JAM_BERANGKAT_AWAL,"");
        jam_berangkat_akhir = sharedPreferences.getString(Config.JAM_BERANGKAT_AKHIR,"");
        total_jam_perjalan = sharedPreferences.getString(Config.TOTAL_JAM_PERJALAN,"");
        harga_awal = sharedPreferences.getString(Config.HARGA_AWAL,"");
        tarif_infane = sharedPreferences.getString(Config.TARIF_INFANE,"");
        jumlah_pesan = sharedPreferences.getString(Config.JUMLAH_PESAN,"");
        jumlah_bayar = sharedPreferences.getString(Config.JUMLAH_BAYAR,"");


        tvDetailNamaTravel.setText(perusahaan_nama);
        tvDetailPerjalananTanggal.setText(perjalanan_tanggal);
        tvDetailKotaAsal.setText(kota_awal);
        tvDetailPerjalananWaktuBerangkat.setText(jam_berangkat_awal);
        tvDetailWaktuDurasi.setText(total_jam_perjalan);
        tvDetailKotaTujuan.setText(kota_tujuan);
        tvDetailWaktuTiba.setText(jam_berangkat_akhir);
        tvDetailRutePerjalanan.setText(rute);

        return view;
    }

    private void initView(View view) {
        tvDetailNamaTravel = (TextView) view.findViewById(R.id.tv_detail_nama_travel);
        tvDetailPerjalananTanggal = (TextView) view.findViewById(R.id.tv_detail_perjalanan_tanggal);
        tvDetailKotaAsal = (TextView) view.findViewById(R.id.tv_detail_kota_asal);
        tvDetailPerjalananWaktuBerangkat = (TextView) view.findViewById(R.id.tv_detail_perjalanan_waktu_berangkat);
        tvDetailWaktuDurasi = (TextView) view.findViewById(R.id.tv_detail_waktu_durasi);
        tvDetailKotaTujuan = (TextView) view.findViewById(R.id.tv_detail_kota_tujuan);
        tvDetailWaktuTiba = (TextView) view.findViewById(R.id.tv_detail_waktu_tiba);
        tvDetailRutePerjalanan = (TextView) view.findViewById(R.id.tv_detail_rute_perjalanan);
    }
}

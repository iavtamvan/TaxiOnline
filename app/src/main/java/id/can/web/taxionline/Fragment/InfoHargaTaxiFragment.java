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
public class InfoHargaTaxiFragment extends Fragment {


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
    private TextView tvInfoHargaNamaTravel;
    private TextView tvInfoHargaKotaAsal;
    private TextView tvInfoHargaKotaTujuan;
    private TextView tvPenumpangInfoHargaTaxi;
    private TextView tvInfoHargaHargaAsal;
    private TextView tvInfoHargaTotalBayar;

    public InfoHargaTaxiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info_harga_taxi, container, false);
        initView(view);


        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
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


        tvInfoHargaNamaTravel.setText(perusahaan_nama);
        tvInfoHargaKotaAsal.setText(kota_awal);
        tvInfoHargaKotaTujuan.setText(kota_tujuan);
        tvInfoHargaHargaAsal.setText(harga_awal);
        tvInfoHargaTotalBayar.setText(jumlah_bayar);
        tvPenumpangInfoHargaTaxi.setText("X" + jumlah_pesan);


        return view;
    }

    private void initView(View view) {
        tvInfoHargaNamaTravel = (TextView) view.findViewById(R.id.tv_info_harga_nama_travel);
        tvInfoHargaKotaAsal = (TextView) view.findViewById(R.id.tv_info_harga_kota_asal);
        tvInfoHargaKotaTujuan = (TextView) view.findViewById(R.id.tv_info_harga_kota_tujuan);
        tvPenumpangInfoHargaTaxi = (TextView) view.findViewById(R.id.tv_penumpang_info_harga_taxi);
        tvInfoHargaHargaAsal = (TextView) view.findViewById(R.id.tv_info_harga_harga_asal);
        tvInfoHargaTotalBayar = (TextView) view.findViewById(R.id.tv_info_harga_total_bayar);
    }
}

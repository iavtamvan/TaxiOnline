package id.can.web.taxionline.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import id.can.web.taxionline.Fragment.DetailTaxiFragment;
import id.can.web.taxionline.Fragment.InfoHargaTaxiFragment;
import id.can.web.taxionline.Helper.Config;
import id.can.web.taxionline.R;

public class DetailTaxiActivity extends AppCompatActivity {

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

    private TabLayout tabLayout;
    private ViewPager viewpager;
    private TextView tvDetailJumlahMembayar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_taxi);
        initView();

        setupViewPager(viewpager);
        tabLayout.setupWithViewPager(viewpager);
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


        tvDetailJumlahMembayar.setText(jumlah_bayar);


    }

    private void setupViewPager(ViewPager viewpager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new DetailTaxiFragment(), "Taxi");
        adapter.addFragment(new InfoHargaTaxiFragment(), "Info Harga");
        viewpager.setAdapter(adapter);
    }

    private void initView() {
        tabLayout = findViewById(R.id.tabs);
        viewpager = findViewById(R.id.viewpager);
        tvDetailJumlahMembayar = (TextView) findViewById(R.id.tv_detail_jumlah_membayar);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
//            return null;
        }
    }
}

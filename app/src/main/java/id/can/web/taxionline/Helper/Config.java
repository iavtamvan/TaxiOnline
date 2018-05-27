package id.can.web.taxionline.Helper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import id.can.web.taxionline.LoginActivity;

public final class Config {

    public static final String ERROR_NETWORK = "Periksa kembali jaringan anda";
    public static final String ERROR_FORM_REGISTER = "Periksa kembali form anda";
    public static final String ERROR_FORM_LOGOUT = "Logout sukses";
    public static final String ERROR_FORM_LOGOUT_GAGAL = "Logout gagal";
    public static final String ERROR_FORM_LOGIN = "Periksa kembali akun anda";
    public static final String ERROR_FORM_LOGIN_KURANG = "Cek akun anda";
    public static final String ERROR_NULL_DATA = "Data tidak ada";
    public static final String ERROR_ERROR_APPS_NOT_ACTIVED = "Akun Belum Aktif atau digunakan di perangkat lain";

    public static final int ZOOM_TO_LEVEL = 15;

//    bundle mulai

    public static final String BUNDLE_KOTA_SINGKATAN = "KOTA_SINGKATAN";
    public static final String BUNDLE_KOTA_NAMA = "KOTA";
    public static final String BUNDLE_PILIHAN= "PILIHAN_TUJUAN_ASAL";
    public static final String BUNDLE_KOTA_ASAL= "KOTA_ASAL";
    public static final String BUNDLE_KOTA_TUJUAN= "KOTA_TUJUAN";


    public static final String BUNDLE_POST_KOTA_ASAL = "POST_KOTA_ASAL";
    public static final String BUNDLE_POST_KOTA_TUJUAN = "POST_KOTA_TUJUAN";
    public static final String BUNDLE_POST_TANGGAL = "POST_TANGGAL";
    public static final String BUNDLE_POST_KURSI = "POST_KURSI";



    public static final String BUNDLE_NEWS_DETAIL_GAMBAR = "GAMBAR_NEWS";
    public static final String BUNDLE_NEWS_DETAIL_JUDUL = "JUDUL_NEWS";
    public static final String BUNDLE_NEWS_DETAIL_CREATEDBY = "CREATEDBY_NEWS";
    public static final String BUNDLE_NEWS_DETAIL_TANGGAL = "TANGGAL_NEWS";
    public static final String BUNDLE_NEWS_DETAIL_ARTIKEL = "ARTIKEL_NEWS";
//    bundle selesai

    // alarm mulai
    public static final String NOTIFICATION_ID = "NOTIFICATION_ID";
    public static final String NOTIFICATION = "NOTIFICATION";
    // alarm selesai


    //    shared mulai
    public static final String SHARED_PREF_NAME = "TAXI";
    public static final String SHARED_PREF_USERID = "USERID";
    public static final String SHARED_PREF_TOKEN = "TOKEN";
    public static final String LOGGEDIN_SHARED_PREF = "logedin";
    public static final String SHARED_NAMALENGKAP = "NAMALENGKAP";
    public static final String SHARED_AGAMA = "AGAMA";
    public static final String SHARED_RULE = "RULE";
    public static final String SHARED_TGLLAHIR = "TGLLAHIR";
    public static final String SHARED_ALAMAT = "ALAMAT";
    public static final String SHARED_NIK = "NIK";
    public static final String SHARED_PASSWORD = "PASSWORD";
    public static final String SHARED_TEMPATLAHIR = "TEMPATLAHIR";
    public static final String SHARED_FOTO = "FOTO";
    public static final String SHARED_WAKTU = "WAKTU";
    public static final String SHARED_TELEPON = "NOHP";
    public static final String SHARED_JENISKELAMIN = "JENISKELAMIN";
    public static final String SHARED_EMAIL = "EMAIL";
    public static final String SHARED_USERNAME = "USERNAME";
    public static final String SHARED_WILAYAH = "WILAYAH";
    public static final String SHARED_STATUSUSER = "STATUSUSER";
    public static final String SHARED_PETUGAS = "PETUGAS";

    public static final String SHARED_LOGIN_WAKTU = "LOGINWAKTU";
    public static final String SHARED_LOGIN_FB = "LOGINFB";
    public static final String SHARED_LOGIN_GOOGLE = "LOGINFB";

    public static final String SHARED_KOTA_AWAL_LENGKAP = "SHARED_AWAL_LENGKAP";
    public static final String SHARED_KOTA_AWAL_SINGKATAN = "SHARED_AWAL_SINGKATAN";
    public static final String SHARED_KOTA_TUJUAN_LENGKAP = "SHARED_TUJUAN_LENGKAP";
    public static final String SHARED_KOTA_TUJUAN_SINGKATAN = "SHARED_TUJUAN_SINGKATAN";


    public static final String PERJALANAN_TANGGAL = "PERJALANAN_TANGGAL";
    public static final String PERUSAHAAN_ID = "PERUSAHAAN_ID";
    public static final String PERUSAHAAN_NAMA = "PERUSAHAAN_NAMA";
    public static final String KOTA_AWAL_ID = "KOTA_AWAL_ID";
    public static final String KOTA_AWAL = "KOTA_AWAL";
    public static final String KOTA_TUJUAN_ID = "KOTA_TUJUAN_ID";
    public static final String KOTA_TUJUAN = "KOTA_TUJUAN";
    public static final String RUTE = "RUTE";
    public static final String JAM_BERANGKAT_AWAL = "JAM_BERANGKAT_AWAL";
    public static final String JAM_BERANGKAT_AKHIR = "JAM_BERANGKAT_AKHIR";
    public static final String TOTAL_JAM_PERJALAN = "TOTAL_JAM_PERJALAN";
    public static final String HARGA_AWAL = "HARGA_AWAL";
    public static final String TARIF_INFANE = "TARIF_INFANE";
    public static final String JUMLAH_PESAN = "JUMLAH_PESAN";
    public static final String JUMLAH_BAYAR = "JUMLAH_BAYAR";










    //    saving Vote
    public static final String SHARED_VOTESAVING = "VOTESAVING";
    public static final String SHARED_VOTELOGIN_SAVING = "VOTELOGINSAVING";
    public static final String SHARED_STATUSVOTE_SAVING = "STATUSVOTE";
//    selesai sacing Vote

    public static final String SHARED_HWID = "HWID";
    public static final String SHARED_DIGITAL_SIGNATURE = "DIGITALSIGNATURE";
    public static final String SHARED_FOTO_FRONT = "FOTOFRONT";
    public static final String SHARED_STATUS_VOTE = "STATUSVOTELAPORAN";
    public static final String SHARED_STATUS_APLIKASI = "STATUSAPPS";
//    shared selesai

    public static final String GET_LAT = "lat";
    public static final String GET_LONG = "long";
    public static final String GET_ALAMAT = "alamat";


    public static String formatDMY(int year, int month, int date) {
        String formattedDate = "";

        if (date < 10) {
            formattedDate += Integer.toString(year);
        } else {
            formattedDate += Integer.toString(year);
        }
        formattedDate += "-";

        if (month < 10) {
            formattedDate += "0" + Integer.toString(month);
        } else {
            formattedDate += Integer.toString(month);
        }
        formattedDate += "-";

        formattedDate += Integer.toString(date);

        return formattedDate;
    }


    public static void forceLogout(Context context) {
        //Getting out shared preferences
        SharedPreferences preferences = context.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        //Getting editor
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(Config.SHARED_NAMALENGKAP, "");
        editor.putString(Config.SHARED_AGAMA, "");
        editor.putString(Config.SHARED_RULE, "");
        editor.putString(Config.SHARED_TGLLAHIR, "");
        editor.putString(Config.SHARED_ALAMAT, "");
        editor.putString(Config.SHARED_NIK, "");
        editor.putString(Config.SHARED_PASSWORD, "");
        editor.putString(Config.SHARED_TEMPATLAHIR, "");
        editor.putString(Config.SHARED_FOTO, "");
        editor.putString(Config.SHARED_WAKTU, "");
        editor.putString(Config.SHARED_TELEPON, "");
        editor.putString(Config.SHARED_JENISKELAMIN, "");
        editor.putString(Config.SHARED_EMAIL, "");
        editor.putString(Config.SHARED_USERNAME, "");
        editor.putString(Config.SHARED_WILAYAH, "");
        editor.putString(Config.SHARED_STATUSUSER, "");
        editor.putString(Config.SHARED_VOTESAVING, "");
        editor.putString(Config.SHARED_VOTELOGIN_SAVING, "");
        editor.putString(Config.SHARED_HWID, "");
        editor.putString(Config.SHARED_DIGITAL_SIGNATURE, "");
        editor.putString(Config.SHARED_STATUS_APLIKASI, "");
        editor.putString(Config.SHARED_STATUS_VOTE, "");
        editor.putString(Config.SHARED_FOTO_FRONT, "");
        editor.putString(Config.SHARED_LOGIN_WAKTU, "");
        editor.putString(Config.SHARED_LOGIN_FB, "");
        editor.putString(Config.SHARED_LOGIN_GOOGLE, "");
        editor.putString(Config.SHARED_PREF_TOKEN, "");
        //Saving the sharedpreferences
        editor.commit();

        //Starting login activity
        Intent intent = new Intent(context.getApplicationContext(), LoginActivity.class);
        context.startActivity(intent);

    }


}

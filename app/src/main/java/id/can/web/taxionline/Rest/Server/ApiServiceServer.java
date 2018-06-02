package id.can.web.taxionline.Rest.Server;

import java.util.ArrayList;

import id.can.web.taxionline.Model.BankModel;
import id.can.web.taxionline.Model.CallCenterModel;
import id.can.web.taxionline.Model.CariJadwalModel;
import id.can.web.taxionline.Model.HistoryOrderModel;
import id.can.web.taxionline.Model.KotaAwalModel;
import id.can.web.taxionline.Model.KotaTujuanModel;
import id.can.web.taxionline.Model.HistoryPoinModel;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ApiServiceServer {
//    http://taxi.can.co.id/travel_api/apilist/get_callcenter.php?userId=el&loginToken=e8b685652b62a2effce190c37fd12c
    @GET("getLatLong.php")
    Call<ResponseBody> getTps();
    @GET("get_callcenter.php")
    Call<CallCenterModel> getCallCenter(
            @Query("userId") String userid,
            @Query("loginToken") String token);

    @GET("saldo_user_api.php")
    Call<ArrayList<CallCenterModel>> getSaldoUser(
            @Query("userId") String userid,
            @Query("loginToken") String token);
    @GET("slider.php")
    Call<ArrayList<CallCenterModel>> getSlider(
            @Query("userId") String userid,
            @Query("loginToken") String token);
    @GET("faq_api.php")
    Call<ArrayList<CallCenterModel>> getFaq(
            @Query("userId") String userid,
            @Query("loginToken") String token);


    @GET("get_kota_awal.php")
    Call<ArrayList<KotaAwalModel>> getKotaAwal(
            @Query("userId") String userid,
            @Query("loginToken") String token);


    @GET("get_kota_tujuan.php")
    Call<ArrayList<KotaTujuanModel>> getKotaTujuan(
            @Query("userId") String userid,
            @Query("loginToken") String token);

    @GET("get_bank.php")
    Call<ArrayList<BankModel>> getBank(
            @Query("userId") String userid,
            @Query("loginToken") String token);

    @GET("get_history_order.php")
    Call<ArrayList<HistoryOrderModel>> getHistoryOrder(
            @Query("userId") String userid,
            @Query("loginToken") String token
    );

    @GET("get_history_poin.php")
    Call<ArrayList<HistoryPoinModel>> getHistoryPoin(
            @Query("userId") String userid,
            @Query("loginToken") String token
    );


    @FormUrlEncoded
    @POST("get_serch_byKota.php")
    Call<ArrayList<CariJadwalModel>> postCariJadwal(
            @Query("userId") String userid,
            @Query("loginToken") String token,
            @Field("tanggal") String tanggal,
            @Field("pesan") String pesan,
            @Field("kotaAwal") String kotaAwal,
            @Field("kotaTujuan") String kotaTujuan);



    @FormUrlEncoded
    @POST("register_api.php")
    Call<ResponseBody> postRegister(@Field("userId") String userId,
                                               @Field("fullname") String fullname,
                                               @Field("email") String email,
                                               @Field("telpon") String telpon,
                                               @Field("password") String password,
                                               @Field("gender") String gender,
                                               @Field("deviceid") String deviceid);

    @FormUrlEncoded
    @POST("login_api.php")
    Call<ResponseBody> postLogin(@Field("mobileEmail") String U_NAME,
                                               @Field("mobilePassword") String U_PASSWORD);

    @FormUrlEncoded
    @POST("logout_api.php")
    Call<ResponseBody> postLogout(@Field("user_id") String user_id);

    @FormUrlEncoded
    @POST("forgot_password.php")
    Call<ResponseBody> postForgotPassword(@Field("username") String username);










//    @Multipart
//    @POST("upload.php")
//    Call<Result> postIMmage(@Part MultipartBody.Part image);


}

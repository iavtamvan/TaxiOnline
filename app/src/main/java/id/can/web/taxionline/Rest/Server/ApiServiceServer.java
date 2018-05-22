package id.can.web.taxionline.Rest.Server;

import java.util.ArrayList;

import id.can.web.taxionline.Model.CallCenterModel;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ApiServiceServer {
    @GET("AKfycbzSX0VVb_KNsORvGBc3q6dPrelDQAFGpc4JyvR-79tuKuKppYEK/exec?action=read&sheetName=news")
    Call<ResponseBody> getNews();
    @GET("getLatLong.php")
    Call<ResponseBody> getTps();
    @GET("get_callcenter.php?")
    Call<ArrayList<CallCenterModel>> getCallCenter(
            @Query("userId") String userid,
            @Query("loginToken") String token);

    @GET("saldo_user_api.php?")
    Call<ArrayList<CallCenterModel>> getSaldoUser(
            @Query("userId") String userid,
            @Query("loginToken") String token);
    @GET("slider.php?")
    Call<ArrayList<CallCenterModel>> getSlider(
            @Query("userId") String userid,
            @Query("loginToken") String token);
    @GET("faq_api.php?")
    Call<ArrayList<CallCenterModel>> getFaq(
            @Query("userId") String userid,
            @Query("loginToken") String token);

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










//    @Multipart
//    @POST("upload.php")
//    Call<Result> postIMmage(@Part MultipartBody.Part image);


}

package id.can.web.taxionline.Rest.Server;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface ApiServiceServer {
    @GET("AKfycbzSX0VVb_KNsORvGBc3q6dPrelDQAFGpc4JyvR-79tuKuKppYEK/exec?action=read&sheetName=news")
    Call<ResponseBody> getNews();
    @GET("getLatLong.php")
    Call<ResponseBody> getTps();
    @FormUrlEncoded
    @POST("taxi_register.php")
    Call<ResponseBody> postRegister(@Field("U_NAME") String U_NAME,
                                               @Field("U_PASSWORD") String U_PASSWORD,
                                               @Field("U_FULLNAME") String U_FULLNAME,
                                               @Field("U_NOMOR") String U_NOMOR,
                                               @Field("U_ROLE") String U_ROLE,
                                               @Field("U_EMAIL") String U_EMAIL,
                                               @Field("U_JK") String U_JK,
                                               @Field("U_STATUS") String U_STATUS);
    @FormUrlEncoded
    @POST("taxi_login.php")
    Call<ResponseBody> postLogin(@Field("U_NAME") String U_NAME,
                                               @Field("U_PASSWORD") String U_PASSWORD);










//    @Multipart
//    @POST("upload.php")
//    Call<Result> postIMmage(@Part MultipartBody.Part image);


}

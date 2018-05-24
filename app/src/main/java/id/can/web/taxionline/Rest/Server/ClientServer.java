package id.can.web.taxionline.Rest.Server;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientServer {
//    http://taxi.can.co.id/travel_api/apilist/get_callcenter.php?userId=el&loginToken=e8b685652b62a2effce190c37fd12c
    private static String BASE_URL = "http://taxi.can.co.id/travel_api/apilist/";

    private static Retrofit getClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }

    public static ApiServiceServer getInstanceRetrofit() {
        return getClient().create(ApiServiceServer.class);
    }


}

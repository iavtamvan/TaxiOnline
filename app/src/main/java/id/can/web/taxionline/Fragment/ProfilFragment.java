package id.can.web.taxionline.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import id.can.web.taxionline.Helper.Config;
import id.can.web.taxionline.R;
import id.can.web.taxionline.Rest.Server.ApiServiceServer;
import id.can.web.taxionline.Rest.Server.ClientServer;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilFragment extends Fragment {
    private TextView tv_logout;


    public ProfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_profil, container, false);
        initView(rootView);
        tv_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiServiceServer apiServiceServer= ClientServer.getInstanceRetrofit();
                apiServiceServer.postLogout(Config.SHARED_PREF_USERID)
                        .enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                if (response.isSuccessful()){
                                    Toast.makeText(getActivity(), "" + Config.ERROR_FORM_LOGOUT, Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getActivity(), "" + Config.ERROR_FORM_LOGOUT_GAGAL, Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                Toast.makeText(getActivity(), "" + Config.ERROR_NETWORK, Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        return rootView;
    }

    private void initView(View rootView) {
        tv_logout = rootView.findViewById(R.id.tv_logout);
    }

}

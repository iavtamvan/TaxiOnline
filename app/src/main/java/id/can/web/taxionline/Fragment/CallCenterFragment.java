package id.can.web.taxionline.Fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import id.can.web.taxionline.Helper.Config;
import id.can.web.taxionline.Model.CallCenterModel;
import id.can.web.taxionline.R;
import id.can.web.taxionline.Rest.Server.ApiServiceServer;
import id.can.web.taxionline.Rest.Server.ClientServer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class CallCenterFragment extends Fragment {

    private CallCenterModel callCenterModels;
    private TextView tvTelpon;
    private TextView tvFb;
    private TextView tvIg;
    private TextView tvAlamatKantor;
    private TextView tvWebsite;
    private String username, tokenId;

    public CallCenterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_call_center, container, false);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        username = sharedPreferences.getString(Config.SHARED_USERNAME, "");
        tokenId = sharedPreferences.getString(Config.SHARED_PREF_TOKEN, "");
        callCenterModels = new CallCenterModel();
        getCallCenter();
        initView(view);
        return view;

    }


    private void getCallCenter() {
        ApiServiceServer apiServiceServer = ClientServer.getInstanceRetrofit();
        Call<CallCenterModel> call = apiServiceServer.getCallCenter(username, tokenId);
        call.enqueue(new Callback<CallCenterModel>() {
            @Override
            public void onResponse(Call<CallCenterModel> call, Response<CallCenterModel> response) {
                callCenterModels = response.body();
                String msg = response.body().getMsg();
                String telpon = response.body().getTelpon();
                String facebook = response.body().getFacebook();
                String instagram = response.body().getInstagram();
                String alamat_office = response.body().getAlamatOffice();
                String website = response.body().getWebsite();

                Toast.makeText(getActivity(), "web " + website, Toast.LENGTH_SHORT).show();


                tvTelpon.setText(telpon);
                tvFb.setText(facebook);
                tvIg.setText(instagram);
                tvAlamatKantor.setText(alamat_office);
                tvWebsite.setText(website);

                // TODO Silahkan SETTEXT
            }

            @Override
            public void onFailure(Call<CallCenterModel> call, Throwable t) {
                getCallCenter();
                Toast.makeText(getActivity(), "" + Config.ERROR_NETWORK, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView(View view) {
        tvTelpon = (TextView) view.findViewById(R.id.tv_telpon);
        tvFb = (TextView) view.findViewById(R.id.tv_fb);
        tvIg = (TextView) view.findViewById(R.id.tv_ig);
        tvAlamatKantor = (TextView) view.findViewById(R.id.tv_alamat_kantor);
        tvWebsite = (TextView) view.findViewById(R.id.tv_website);
    }

}


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

import java.util.ArrayList;

import id.can.web.taxionline.Activity.CallCenterActivity;
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

    private ArrayList<CallCenterModel> callCenterModels;
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
        SharedPreferences sharedPreferences  = getActivity().getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        username = sharedPreferences.getString(Config.SHARED_USERNAME,"");
        tokenId = sharedPreferences.getString(Config.SHARED_PREF_TOKEN,"");
        Toast.makeText(getActivity(), "" + username + tokenId, Toast.LENGTH_SHORT).show();
        Toast.makeText(getActivity(), "" + username + tokenId, Toast.LENGTH_SHORT).show();
        callCenterModels = new ArrayList<>();
        getCallCenter();
        initView(view);
        return view;

    }


    private void getCallCenter() {
        ApiServiceServer apiServiceServer = ClientServer.getInstanceRetrofit();
        Call<ArrayList<CallCenterModel>> call = apiServiceServer.getCallCenter(username, tokenId);
        call.enqueue(new Callback<ArrayList<CallCenterModel>>() {
                    @Override
                    public void onResponse(Call<ArrayList<CallCenterModel>> call, Response<ArrayList<CallCenterModel>> response) {
                        callCenterModels = response.body();
                        for (int i = 0; i < callCenterModels.size(); i++) {
                            String msg = callCenterModels.get(i).getMsg();
                            String telpon = callCenterModels.get(i).getTelpon();
                            String facebook = callCenterModels.get(i).getFacebook();
                            String instagram = callCenterModels.get(i).getInstagram();
                            String alamat_office = callCenterModels.get(i).getAlamatOffice();
                            String website = callCenterModels.get(i).getWebsite();

                            tvTelpon.setText(telpon);
                            tvFb.setText(facebook);
                            tvIg.setText(instagram);
                            tvAlamatKantor.setText(alamat_office);
                            tvWebsite.setText(website);

                            // TODO Silahkan SETTEXT
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<CallCenterModel>> call, Throwable t) {
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


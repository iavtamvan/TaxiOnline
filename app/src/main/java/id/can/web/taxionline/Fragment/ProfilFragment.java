package id.can.web.taxionline.Fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;
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
    private Toolbar fastool;
    private ImageView backEditprofile;
    private CircleImageView ivAvatarProfil;
    private TextView tvUsernameProfil;
    private TextView tvLogout;
    private String linkAvatar;


    public ProfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_profil, container, false);
        initView(rootView);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        linkAvatar = sharedPreferences.getString(Config.SHARED_FOTO, "");
        tvUsernameProfil.setText(sharedPreferences.getString(Config.SHARED_NAMALENGKAP,""));

        Glide.with(getActivity()).load(linkAvatar).into(ivAvatarProfil);


        tv_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutService();
            }
        });

        return rootView;
    }

    private void logoutService() {
        ApiServiceServer apiServiceServer = ClientServer.getInstanceRetrofit();
        apiServiceServer.postLogout(Config.SHARED_PREF_USERID)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(getActivity(), "" + Config.ERROR_FORM_LOGOUT, Toast.LENGTH_SHORT).show();
                            Config.forceLogout(getActivity());
                        } else {
                            Toast.makeText(getActivity(), "" + Config.ERROR_FORM_LOGOUT_GAGAL, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        tv_logout.performClick();
                        Toast.makeText(getActivity(), "" + Config.ERROR_NETWORK, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void initView(View rootView) {
        tv_logout = rootView.findViewById(R.id.tv_logout);
        fastool = (Toolbar) rootView.findViewById(R.id.fastool);
        backEditprofile = (ImageView) rootView.findViewById(R.id.back_editprofile);
        ivAvatarProfil = (CircleImageView) rootView.findViewById(R.id.iv_avatar_profil);
        tvUsernameProfil = (TextView) rootView.findViewById(R.id.tv_username_profil);
        tvLogout = (TextView) rootView.findViewById(R.id.tv_logout);
    }

}

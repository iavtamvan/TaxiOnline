package id.can.web.taxionline.Fragment;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import id.can.web.taxionline.Adapter.HistoryPoinAdapter;
import id.can.web.taxionline.Helper.Config;
import id.can.web.taxionline.Model.HistoryPoinModel;
import id.can.web.taxionline.R;
import id.can.web.taxionline.Rest.Server.ApiServiceServer;
import id.can.web.taxionline.Rest.Server.ClientServer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryPoinFragment extends Fragment {


    private TextView statusMessage;
    private ProgressBar progressHistoryPoin;
    private RecyclerView rcListHistoryPoin;

    public HistoryPoinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_history_poin, container, false);
        initView(view);

        getHistoryPoin();

        return view;
    }

    private void getHistoryPoin() {
        progressHistoryPoin.setVisibility(View.VISIBLE);
        SharedPreferences sp = getActivity().getSharedPreferences(Config.SHARED_PREF_NAME, 0);

        ApiServiceServer apiServiceServer = ClientServer.getInstanceRetrofit();
        apiServiceServer.getHistoryPoin(sp.getString(Config.SHARED_USERNAME, ""), sp.getString(Config.SHARED_PREF_TOKEN,""))
                .enqueue(new Callback<ArrayList<HistoryPoinModel>>() {
                    @Override
                    public void onResponse(Call<ArrayList<HistoryPoinModel>> call, Response<ArrayList<HistoryPoinModel>> response) {
                        if (response.isSuccessful()){
                            progressHistoryPoin.setVisibility(View.GONE);
                            ArrayList<HistoryPoinModel> model = new ArrayList<>();
                            model = response.body();
                            HistoryPoinAdapter adapter = new HistoryPoinAdapter(model, getActivity());
                            LinearLayoutManager lm = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                            rcListHistoryPoin.setLayoutManager(lm);
                            rcListHistoryPoin.setAdapter(adapter);
                        }
                    }
                    @Override
                    public void onFailure(Call<ArrayList<HistoryPoinModel>> call, Throwable t) {
                        progressHistoryPoin.setVisibility(View.GONE);
                        statusMessage.setVisibility(View.VISIBLE);
                        statusMessage.setText("Gagal mendapatan data,Periksa kembali internet anda");
                    }
                });
    }

    private void initView(View view) {
        statusMessage = (TextView) view.findViewById(R.id.status_message);
        progressHistoryPoin = (ProgressBar) view.findViewById(R.id.progress_history_poin);
        rcListHistoryPoin = (RecyclerView) view.findViewById(R.id.rc_list_history_poin);
    }
}

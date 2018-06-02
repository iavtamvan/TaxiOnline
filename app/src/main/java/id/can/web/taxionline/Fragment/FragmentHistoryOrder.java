package id.can.web.taxionline.Fragment;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import id.can.web.taxionline.Adapter.HistoryOrderAdapter;
import id.can.web.taxionline.Helper.Config;
import id.can.web.taxionline.Model.HistoryOrderModel;
import id.can.web.taxionline.R;
import id.can.web.taxionline.Rest.Server.ApiServiceServer;
import id.can.web.taxionline.Rest.Server.ClientServer;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.constraint.Constraints.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHistoryOrder extends Fragment {


    private ProgressBar progressHistoryOrder;
    private TextView statusHistoryOrder;
    private RecyclerView rec;
    public FragmentHistoryOrder() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View iv = inflater.inflate(R.layout.fragment_fragment_history_order, container, false);
        initView(iv);

        getHistory();

        return iv;
    }

    private void getHistory() {
        SharedPreferences sp = getActivity().getSharedPreferences(Config.SHARED_PREF_NAME, 0);

        ApiServiceServer apiServiceServer = ClientServer.getInstanceRetrofit();
        apiServiceServer.getHistoryOrder(sp.getString(Config.SHARED_USERNAME, ""), sp.getString(Config.SHARED_PREF_TOKEN,"")).enqueue(new Callback<ArrayList<HistoryOrderModel>>() {
            @Override
            public void onResponse(Call<ArrayList<HistoryOrderModel>> call, Response<ArrayList<HistoryOrderModel>> response) {
                if (response.isSuccessful()) {
                    progressHistoryOrder.setVisibility(View.GONE);
                    try {
                        ArrayList<HistoryOrderModel> arrayList = new ArrayList<>();
                        arrayList  = response.body();
                            LinearLayoutManager lm = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL , false);
                            rec.setLayoutManager(lm);
                            HistoryOrderAdapter adapter = new HistoryOrderAdapter(arrayList , getActivity());
                            rec.setAdapter(adapter);
                    }catch (Exception e) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.body().toString());
                            if (jsonObject.getString("error").equals("false")) {
                                statusHistoryOrder.setText(jsonObject.getString("msg"));
                            }

                        } catch (JSONException e1) {
                            e1.printStackTrace();
                        }

                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<HistoryOrderModel>> call, Throwable t) {
                progressHistoryOrder.setVisibility(View.GONE);
                statusHistoryOrder.setVisibility(View.VISIBLE);
                statusHistoryOrder.setText("Tidak ada riwayat order");

            }
        });
    }

    private void initView(View view) {
        rec = view.findViewById(R.id.rc_list_list_history);
        progressHistoryOrder = (ProgressBar) view.findViewById(R.id.progress_history_order);
        statusHistoryOrder = (TextView) view.findViewById(R.id.status_history_order);
    }
}

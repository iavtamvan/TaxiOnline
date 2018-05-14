package id.can.web.taxionline.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.can.web.taxionline.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoHargaTaxiFragment extends Fragment {


    public InfoHargaTaxiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info_harga_taxi, container, false);
    }

}

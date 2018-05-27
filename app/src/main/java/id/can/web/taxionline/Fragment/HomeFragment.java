package id.can.web.taxionline.Fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

import id.can.web.taxionline.Helper.Config;
import id.can.web.taxionline.R;
import id.can.web.taxionline.Activity.CariTaksiActivity;
import id.can.web.taxionline.Activity.SaldoActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements ViewPagerEx.OnPageChangeListener {


    private SliderLayout sliderSlider;
    private LinearLayout linearHomeTaxi;
    private TextView tvSaldoUser;
    private LinearLayout linearHomeRide;
    private LinearLayout linearHomeCar;
    private LinearLayout linearHomeResto;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);

        linearHomeTaxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Bundle bundle = new Bundle();
//                bundle.putString(Config.BUNDLE_KOTA_SINGKATAN, "Pilih kota asal");
//                bundle.putString(Config.BUNDLE_KOTA_NAMA, "Pilih kota tujuan");
//                Intent intent = new Intent(getActivity(), CariTaksiActivity.class);
//                intent.putExtras(bundle);
//                startActivity(intent);

                //Getting out shared preferences
                SharedPreferences preferences = getActivity().getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
                //Getting editor
                SharedPreferences.Editor editor = preferences.edit();


                editor.putString(Config.SHARED_KOTA_AWAL_LENGKAP, "");
                editor.putString(Config.SHARED_KOTA_TUJUAN_LENGKAP, "");

                editor.commit();
                startActivity(new Intent(getActivity(), CariTaksiActivity.class));
            }
        });

        tvSaldoUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), SaldoActivity.class));
            }
        });

        setupslider();

        return view;
    }

    private void setupslider() {
        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Promo 1", R.drawable.promo1);
        file_maps.put("Promo 2", R.drawable.promo2);

        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(getActivity());

            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);

            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);

            sliderSlider.addSlider(textSliderView);

        }

        sliderSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderSlider.setCustomAnimation(new DescriptionAnimation());
        sliderSlider.setDuration(4000);
        sliderSlider.addOnPageChangeListener(this);

    }

    private void initView(View view) {
        sliderSlider = view.findViewById(R.id.sliderSlider);
        linearHomeTaxi = view.findViewById(R.id.linear_home_taxi);
        linearHomeRide = view.findViewById(R.id.linear_home_ride);
        linearHomeCar = view.findViewById(R.id.linear_home_car);
        linearHomeResto = view.findViewById(R.id.linear_home_resto);
        tvSaldoUser = view.findViewById(R.id.tv_home_saldo);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

package id.can.web.taxionline.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import id.can.web.taxionline.Fragment.FragmentHistoryOrder;
import id.can.web.taxionline.Fragment.HistoryPoinFragment;

/**
 * Created by CAN Creative on 29/05/2018.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                FragmentHistoryOrder tab1 = new FragmentHistoryOrder();
                return tab1;
            case 1:
                HistoryPoinFragment tab2 = new HistoryPoinFragment();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }}

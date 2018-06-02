package id.can.web.taxionline.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import id.can.web.taxionline.Model.HistoryPoinModel;
import id.can.web.taxionline.R;

/**
 * Created by CAN Creative on 29/05/2018.
 */

public class HistoryPoinAdapter extends RecyclerView.Adapter<HistoryPoinAdapter.KotaHolder> {
    Context context;
    private ArrayList<HistoryPoinModel> data;

    public HistoryPoinAdapter(ArrayList<HistoryPoinModel> kotaAwal, Context context) {
        this.data = kotaAwal;
        this.context = context;
    }

    @Override
    public KotaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_history_poin, parent, false);
        return new KotaHolder(view);
    }

    @Override
    public void onBindViewHolder(KotaHolder holder, final int position) {
        holder.txt_tanggal.setText(data.get(position).getTPSYSUPDATEDAT());
        holder.txt_id.setText(data.get(position).getHPORDERID());
        holder.txt_poin.setText(data.get(position).getHPITEMPOIN()+data.get(position).getHPPOINUSER());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class KotaHolder extends RecyclerView.ViewHolder {
        public LinearLayout divKlik;
        public TextView txt_id, txt_tanggal, txt_poin;
        public KotaHolder(View itemView) {
            super(itemView);
            txt_id= itemView.findViewById(R.id.txt_id_poin);
            txt_tanggal= itemView.findViewById(R.id.txt_tanggal);
            txt_poin= itemView.findViewById(R.id.nilai_point);
            divKlik = itemView.findViewById(R.id.divKlik);


        }
    }
}

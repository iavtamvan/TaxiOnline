package id.can.web.taxionline.Adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import id.can.web.taxionline.Activity.CariTaksiActivity;
import id.can.web.taxionline.Helper.Config;
import id.can.web.taxionline.Model.HistoryOrderModel;
import id.can.web.taxionline.Model.KotaAwalModel;
import id.can.web.taxionline.R;

/**
 * Created by CAN Creative on 29/05/2018.
 */

public class HistoryOrderAdapter extends RecyclerView.Adapter<HistoryOrderAdapter.KotaHolder> {
    Context context;
    private ArrayList<HistoryOrderModel> data;

    public HistoryOrderAdapter(ArrayList<HistoryOrderModel> kotaAwal, Context context) {
        this.data = kotaAwal;
        this.context = context;
    }

    @Override
    public KotaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_history_order, parent, false);
        return new KotaHolder(view);
    }

    @Override
    public void onBindViewHolder(KotaHolder holder, final int position) {
        holder.status.setText(data.get(position).getTOSTATUS());
        holder.id_.setText(data.get(position).getTOORDERID());
        holder.no_verif.setText(data.get(position).getTONOVERIFTIKET());
        holder.tanggal.setText(data.get(position).getTOBOOKINGTGL());
        holder.perjalanan.setText(data.get(position).getTOKANAMA()+ " - "+ data.get(position).getTOKTNAMA());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class KotaHolder extends RecyclerView.ViewHolder {
        public TextView id_, no_verif, status, perjalanan, tanggal;
        public LinearLayout divKlik;
        public KotaHolder(View itemView) {
            super(itemView);
            id_ = (TextView) itemView.findViewById(R.id.id_);
            no_verif = (TextView) itemView.findViewById(R.id.no_verif);
            perjalanan = (TextView) itemView.findViewById(R.id.perjalanan);
            status = (TextView) itemView.findViewById(R.id.status_);
            tanggal = (TextView) itemView.findViewById(R.id.tgl_booking);
            divKlik = itemView.findViewById(R.id.divKlik);


        }
    }
}

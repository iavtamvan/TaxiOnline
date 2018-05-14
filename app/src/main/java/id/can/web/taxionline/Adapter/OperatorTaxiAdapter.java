package id.can.web.taxionline.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.can.web.taxionline.Model.OperatorTaxiModel;
import id.can.web.taxionline.R;
import id.can.web.taxionline.Activity.DetailTaxiActivity;
import id.can.web.taxionline.Activity.IsiDataTaxiActivity;
import id.can.web.taxionline.Activity.PilihOperatorTaxiActivity;

/**
 * Created by canc on 4/16/2018.
 */

public class OperatorTaxiAdapter extends RecyclerView.Adapter<OperatorTaxiAdapter.TaxiViewHolder> {

    private ArrayList<OperatorTaxiModel> dataList;
    Activity context;

    public OperatorTaxiAdapter(ArrayList<OperatorTaxiModel> dataList, PilihOperatorTaxiActivity pilihOperatorTaxiActivity) {
        this.dataList = dataList;
        this.context = pilihOperatorTaxiActivity;
    }

    @Override
    public TaxiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_operator_taxi, parent, false);
        return new TaxiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TaxiViewHolder holder, int position) {
        holder.namaOperator.setText(dataList.get(position).getNamaOperator());
        holder.jamBerangkat.setText(dataList.get(position).getJamBerangkat());
        holder.estimasi.setText(dataList.get(position).getEstimasiPerjalanan());
        holder.hargaTiket.setText(dataList.get(position).getHargaTiket());

        holder.ivDetailTaxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, DetailTaxiActivity.class));
            }
        });

        holder.cvOperator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, IsiDataTaxiActivity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class TaxiViewHolder extends RecyclerView.ViewHolder {

        TextView namaOperator, jamBerangkat, estimasi, hargaTiket;
        ImageView ivDetailTaxi;
        CardView cvOperator;

        public TaxiViewHolder(View itemView) {
            super(itemView);
            namaOperator = itemView.findViewById(R.id.tv_nama_operator_taxi);
            jamBerangkat = itemView.findViewById(R.id.tv_jam_operator_taxi);
            estimasi = itemView.findViewById(R.id.tv_estimasi_operator_taxi);
            hargaTiket = itemView.findViewById(R.id.tv_harga_operator_taxi);
            ivDetailTaxi = itemView.findViewById(R.id.iv_detail_taxi);
            cvOperator = itemView.findViewById(R.id.cv_operator_taxi);
        }
    }
}

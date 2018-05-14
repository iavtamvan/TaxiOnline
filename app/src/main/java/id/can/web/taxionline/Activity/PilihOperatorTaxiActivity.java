package id.can.web.taxionline.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import id.can.web.taxionline.Model.OperatorTaxiModel;
import id.can.web.taxionline.R;
import id.can.web.taxionline.Adapter.OperatorTaxiAdapter;

public class PilihOperatorTaxiActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    OperatorTaxiAdapter adapter;
    private ArrayList<OperatorTaxiModel> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_operator_taxi);

        addData();

        recyclerView = findViewById(R.id.rv_operator_taxi);

        adapter = new OperatorTaxiAdapter(dataList, PilihOperatorTaxiActivity.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(PilihOperatorTaxiActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void addData() {

        dataList = new ArrayList<>();
        dataList.add(new OperatorTaxiModel("Baraya Travel","08.00-12-00","4 jam","Rp 92000"));
        dataList.add(new OperatorTaxiModel("Day Trans","06.00-10-00","4 jam","Rp 95000"));
        dataList.add(new OperatorTaxiModel("Xtrans","19.00-23-00","4 jam","Rp 90000"));
        dataList.add(new OperatorTaxiModel("Cipaganti","16.00-20-00","4 jam","Rp 96000"));
        dataList.add(new OperatorTaxiModel("Bimo Trans","07.30-11-30","4 jam","Rp 100000"));
    }
}

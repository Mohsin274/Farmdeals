package com.example.farmdeals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class qtySelection extends AppCompatActivity {
    int qtyVal = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qty_selection);
        TextView textView = (TextView)findViewById(R.id.textView1);
        textView.setText("1kg");
    }

    public void addQty(View v)  {
        if (qtyVal == 5) {
            qtyVal = 5;
        } else {
            qtyVal = qtyVal + 1;
        }
        display(qtyVal);
    }

    public void subQty(View v)  {
        if (qtyVal == 1) {
            qtyVal = 1;
        } else {
            qtyVal = qtyVal - 1;
        }
        display(qtyVal);
    }

    private void display(int num) {
        TextView showQtyVal = (TextView)findViewById(R.id.textView1);
        showQtyVal.setText(num + "kg");
    }
}
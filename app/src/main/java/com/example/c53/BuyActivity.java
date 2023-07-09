package com.example.c53;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;

public class BuyActivity extends AppCompatActivity {

    ImageView ivItem;
    TextView tvName;
    EditText edtQty, edtAddress;
    MaterialButton btnBuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        ivItem = findViewById(R.id.iv_data);
        tvName = findViewById(R.id.tv_name);
        edtQty = findViewById(R.id.edt_quantity);
        edtAddress = findViewById(R.id.edt_address);
        btnBuy = findViewById(R.id.btn_buy);

        DBHelper db = new DBHelper(this);

        String itemName = getIntent().getStringExtra("name");
        int image = getIntent().getIntExtra("image", 0);

        tvName.setText(itemName);
        Glide.with(this)
                .load(image)
                .into(ivItem);

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String address = edtAddress.getText().toString();
                String quantityString = edtQty.getText().toString();

                if(address.isEmpty()) {
                    edtAddress.setError("Please fill your address");
                }

                if(quantityString.isEmpty()) {
                    edtQty.setError("Please input quantity");
                }

                if(!address.isEmpty() && !quantityString.isEmpty()) {
                    HistoryItem historyItem = new HistoryItem(
                            0,
                            itemName,
                            image,
                            address,
                            Integer.parseInt(quantityString)
                    );

                    long result = db.addHistory(historyItem);
                    if(result != -1) {
                        Toast.makeText(getApplicationContext(), "Order Success", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Order Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}

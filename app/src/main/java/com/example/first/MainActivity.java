package com.example.first;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.first.R.id;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(id.caltralai); // nut tinh tra lai
        Button btnx = (Button) findViewById(id.btnf); //nut ket thuc
        final TextView tientt = (TextView) findViewById(R.id.tientt); // tien can thanh toan
        final EditText tienmuah = (EditText) findViewById(id.tienmuahang);  //Tien mua hang
        Bundle extras = getIntent().getExtras();
        final Integer tien = extras.getInt("tienthanhtoan");
        // format nghin VND
        Locale loc = new Locale("vi","VN");
        final DecimalFormat money = (DecimalFormat) DecimalFormat.getCurrencyInstance(loc);
        final DecimalFormatSymbols currentformat =  new DecimalFormatSymbols();
        currentformat.setCurrencySymbol("nghìn VNĐ");
        money.setDecimalFormatSymbols(currentformat);
        //money end format
        String tienthanhtoan = money.format(tien);
        tientt.setText(tienthanhtoan);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    Integer tienmuahang = Integer.parseInt(tienmuah.getText().toString());
                    final Integer tientralai =  tienmuahang-tien;
                    if(tien>tienmuahang) {
                        Toast.makeText(MainActivity.this, "Bạn đưa thiếu tiền !", Toast.LENGTH_SHORT).show();
                        tienmuah.setText("");
                    }
                    else if(tien==tienmuahang)
                        Toast.makeText(MainActivity.this, "Không nhận lại tiền !", Toast.LENGTH_SHORT).show();
                    else if(tienmuah.getText().toString()!=null)
                    {
                        TextView tientl = (TextView) findViewById(id.tientralai);
                        tientl.setText(money.format(tientralai));
                    }
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Chưa nhập tiền mua", Toast.LENGTH_SHORT).show();
                }
              //  finish();
            }
        });
        btnx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Giữ để quay lại !!!", Toast.LENGTH_SHORT).show();
            }
        });
        btnx.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                try {
                    Integer tienmuahang = Integer.parseInt(tienmuah.getText().toString());
                    if (tien > tienmuahang) {
                        Toast.makeText(MainActivity.this, "Bạn đưa thiếu tiền !", Toast.LENGTH_SHORT).show();
                        tienmuah.setText("");
                    } else {

                        Toast.makeText(MainActivity.this, "Đã nhận lại " + money.format(tienmuahang - tien), Toast.LENGTH_LONG).show();
                        finish();
                    }
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Đã thanh toán " + money.format(tien), Toast.LENGTH_SHORT).show();
                    finish();
                }
                return false;
            }
        });
    }
}


package com.example.first;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
public class Laucher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laucher);
        Button btnback = (Button) findViewById(R.id.btnback);
        final EditText thit = (EditText) findViewById(R.id.edtThit);
        final EditText rau = (EditText) findViewById(R.id.edtRau);
        final EditText Hoaqua = (EditText) findViewById(R.id.edtHoaqua);


        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Integer a = Integer.parseInt(thit.getText().toString());
                    Integer b = Integer.parseInt(rau.getText().toString());
                    Integer c = Integer.parseInt(Hoaqua.getText().toString());
                    Integer tien=0;
                    tien = a + b + c;
                    Intent i = new Intent(Laucher.this,MainActivity.class);
                    i.putExtra("tienthanhtoan", tien);
                    startActivity(i);
                }
                catch(Exception e) {
                    Toast.makeText(Laucher.this, "Nhập lại số tiền !!!", Toast.LENGTH_SHORT).show();
                }

                // OPEN a url in web browser
//                Intent internet = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));
//                startActivity(internet);
            }
        });
    }
}
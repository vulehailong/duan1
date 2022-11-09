package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = findViewById(R.id.selectday);
        Button btn = findViewById(R.id.btn);
        Button btnplus = findViewById(R.id.btnplus);
        Button btnminus = findViewById(R.id.btnminus);
        TextView txtsl = findViewById(R.id.txtsl);
        calendar = Calendar.getInstance();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                int nam = year;
                                int thang = month + 1;
                                int ngay = dayOfMonth;
                                tv.setText(ngay + "/" + thang + "/" + nam);
                            }
                        },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                );
                datePickerDialog.show();
            }
        });


        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sl = txtsl.getText().toString();
                int slve = Integer.parseInt(sl) + 1;
                if(slve <= 10) {
                    txtsl.setText(slve + "");
                    checkgia(slve);
                }
            }
        });
        btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sl = txtsl.getText().toString();
                int slve = Integer.parseInt(sl) - 1;
                if(slve < 1){
                    txtsl.setText( 1 + "");
                }else {
                    txtsl.setText(slve + "");
                    checkgia(slve);
                }
            }
        });
    }
    public void checkgia(int slve){
        TextView txtgia = findViewById(R.id.txtgia);
        txtgia.setText(45 * slve + ".000 VNĐ");

    }
}
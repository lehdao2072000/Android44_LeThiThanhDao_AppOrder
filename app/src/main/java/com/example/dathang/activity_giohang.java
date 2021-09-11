package com.example.dathang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class activity_giohang extends AppCompatActivity {
    ImageView imgQuayLaiCode;
    AdapterFood adapterFood;
    ListView lvFoodCode;
    TextView tvTongTienCode;
    List<Food> foodList = new ArrayList<>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giohang);

        lvFoodCode = findViewById(R.id.lvFoods);
        tvTongTienCode = findViewById(R.id.tvTongTien);

        Intent mh = getIntent();

        ArrayList<String> tenMon = mh.getStringArrayListExtra("tenMon");
        ArrayList<Integer> soLuong = mh.getIntegerArrayListExtra("soLuong");
        ArrayList<String> giaTien = mh.getStringArrayListExtra("giaTien");

        lvFoodCode = findViewById(R.id.lvFoods);
        tvTongTienCode = findViewById(R.id.tvTongTien);

        int dem=0;
        double tong=0;
        for (int i=0; i<=foodList.size();i++){
            int soLuongs = soLuong.get(i);
            if(soLuongs>0){
                Double giaTiens = Double.parseDouble(giaTien.get(i));
                foodList.add(new Food(tenMon.get(i)+"("+soLuongs+")",giaTiens,soLuongs));
                tong+=soLuongs * giaTiens;
                dem++;
            }
        }
        adapterFood = new AdapterFood(foodList);
        lvFoodCode.setAdapter(adapterFood);
        if(dem !=0){
            tvTongTienCode.setText(Double.toString(tong));
        }
        //nuuts quay lại

        imgQuayLaiCode = findViewById(R.id.imgQuayLai);
        imgQuayLaiCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),activity_manhinhchinh.class);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }
}
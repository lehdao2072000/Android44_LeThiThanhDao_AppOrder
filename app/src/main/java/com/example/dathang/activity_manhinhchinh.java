package com.example.dathang;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class activity_manhinhchinh extends AppCompatActivity {

    ListView lvFoodCode;
    static List<Food> foods = new ArrayList<>();;
    Food food1, food2, food3, food4, food5, food6;
    AdapterFood adapterFood;
    Button btnOrderCode;
    RelativeLayout btnGioHangCode;
    TextView tvSoLuongCode, tvTongTienCode, tvThankCode, tvTenKHCode;
    int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinhchinh);

        tvSoLuongCode= findViewById(R.id.tvSoLuong);
        tvTongTienCode = findViewById(R.id.tvTongTien);
        tvTenKHCode = findViewById(R.id.tvTenKh);
        lvFoodCode = findViewById(R.id.lvFood);

        Intent intent = getIntent();
        String name= intent.getStringExtra("username");
        tvTenKHCode.setText("WellCome "+name);

        food1 = new Food("Pizza Panda", 10, 0);
        food2 = new Food("KFC Super",10, 0);
        food3 = new Food("Bread Eggs",10, 0);
        food4 = new Food("Coca Cola", 10, 0);
        food5 = new Food("Chicken super", 10, 0);
        food6 = new Food("Cup Cake", 10, 0);

        foods.add(food1);
        foods.add(food2);
        foods.add(food3);
        foods.add(food4);
        foods.add(food5);
        foods.add(food6);

        adapterFood = new AdapterFood(foods);
        lvFoodCode.setAdapter(adapterFood);

        lvFoodCode.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // đếm số lượng
                int dem=Integer.parseInt(tvSoLuongCode.getText().toString());
                dem++;
                tvSoLuongCode.setText(Integer.toString(dem));

                // tính total
                number =i;
                Food food=foods.get(i);
                food.setSoLuong(food.getSoLuong()+1);
                double tong = Double.parseDouble(tvTongTienCode.getText().toString());
                tong+=food.getDonGia();
                tvTongTienCode.setText(Double.toString(tong));

                tvThankCode.setVisibility(View.GONE);
            }
        });

        //nút order
        tvThankCode = findViewById(R.id.tvThank);
        tvThankCode.setVisibility(View.GONE);
        btnOrderCode = findViewById(R.id.btnOrder);
        btnOrderCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvSoLuongCode.setText("0");
                tvTongTienCode.setText("0");
                tvThankCode.setVisibility(View.VISIBLE);
            }
        });

        //Nút giỏ hàng
        btnGioHangCode = findViewById(R.id.btnGiohang);
        btnGioHangCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mhGioHang=new Intent(getBaseContext(),activity_giohang.class);

                ArrayList<String> tenMon = new ArrayList<>();
                ArrayList<Integer> soluong = new ArrayList<>();
                ArrayList<String> giaTien = new ArrayList<>();

                    for (Food food: foods) {
                        tenMon.add(food.getTenMon());
                        soluong.add(food.getSoLuong());
                        giaTien.add(food.getDonGia()+"");
                    }
                    mhGioHang.putExtra("tenMon", tenMon);
                    mhGioHang.putExtra("soLuong", soluong);
                    mhGioHang.putExtra("giaTien",giaTien);
                startActivity(mhGioHang);
            }
        });

    }
}
package com.example.bt_dialog;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.bt_dialog.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private int lastHouser = -1;
    private int lastMunite = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        // hiển thị Tune:
        binding.btntune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnfile.setVisibility(View.VISIBLE);
                binding.btndefault.setVisibility(View.VISIBLE);
            }
        });
        binding.btndefault.setOnClickListener(new View.OnClickListener() {
            String luu;
            @Override
            public void onClick(View view) {
                String[] strings ={"Nexus Tune","Winphone tune","Peep tune","Nokia Tune","Etc"};
                luu = strings[0];
                android.app.AlertDialog alertDialog= new android.app.AlertDialog.Builder(getBaseContext()).setTitle("")
                        .setSingleChoiceItems(strings, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                luu = strings[i];
                                Toast.makeText(getBaseContext(),luu,Toast.LENGTH_LONG).show();
                            }
                        }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getBaseContext(),"cick chọn " +luu,Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getBaseContext(),"Click Cancel",Toast.LENGTH_LONG).show();
                            }
                        }).create();
                alertDialog.show();
            }
        });
        //hiển thị weeks:
        binding.tvweek.setOnClickListener(new View.OnClickListener() {
            String mang ="";
            @Override
            public void onClick(View view) {
                String[] choose= {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday","Saturday","Sunday"};
                boolean[] itemChoose = {true, false, false, false,false,false,false};

                android.app.AlertDialog alertDialog= new android.app.AlertDialog.Builder(getBaseContext()).setTitle("Choose tags:")
                        .setMultiChoiceItems(choose, itemChoose, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                                if(b)
                                    itemChoose[i] = true;
                                else itemChoose[i] = false;
                            }
                        }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                for(int t=0; i<itemChoose.length;t++){
                                    if(itemChoose[t] == true){
                                        mang +=choose[t]+",";
                                    }
                                }
                                binding.tvweek.setText(mang);
//                                Toast.makeText(getContext(),choose,Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getBaseContext(),"Click Cancel",Toast.LENGTH_LONG).show();
                            }
                        }).create();
                alertDialog.show();
            }
        });
        // hiển thị tags:
        binding.tvtags.setOnClickListener(new View.OnClickListener() {
            String mang="";
            @Override
            public void onClick(View view) {
                String[] choose= {"Family", "Game", "Android", "VTC", "Friend"};
                boolean[] itemChoose = {true, false, false, false,false};

                android.app.AlertDialog alertDialog= new android.app.AlertDialog.Builder(getBaseContext()).setTitle("Choose tags:")
                        .setMultiChoiceItems(choose, itemChoose, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                                if(b)
                                    itemChoose[i] = true;
                                else itemChoose[i] = false;
                            }
                        }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                for(int t=0; i<itemChoose.length;t++){
                                    if(itemChoose[t] == true){
                                        mang +=choose[i]+",";
                                    }
                                }

                                binding.tvtags.setText(mang);
//                                Toast.makeText(getContext(),choose,Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getBaseContext(),"Click Cancel",Toast.LENGTH_LONG).show();
                            }
                        }).create();
                alertDialog.show();
            }
        });
        //hiển thị Type:
        binding.tvMuiTen.setOnClickListener(new View.OnClickListener() {
            private String luu="";
            @Override
            public void onClick(View view) {
                String[] item = {"Work", "Family","Friend"};
                luu = item[0];
                AlertDialog alertDialog = new AlertDialog.Builder(getBaseContext())
                        .setSingleChoiceItems(item, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                luu = item[i];
                                binding.tvTen.setText(luu);
                            }
                        }).create();
                alertDialog.show();
            }
        });
        //hiển thị ngày
        binding.tvNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnNgay();
            }
        });
        // hiển thị giờ
        binding.tvgio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnGio();
            }
        });
    }
        // khởi tạo menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_ds, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.cancels:
                Toast.makeText(this, "Cancel",Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private void btnNgay() {

        //lấy ra ngày hiện tại
        Calendar calendar = Calendar.getInstance();
        int lastYear = calendar.get(Calendar.YEAR);
        int lastMonth = calendar.get(Calendar.MONTH);
        int lastDay = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                binding.tvNgay.setText(i2+"/"+(i1+1)+"/"+i);
            }
        };
        DatePickerDialog datePickerDialog = null;
        datePickerDialog = new DatePickerDialog(this, dateSetListener,lastYear,lastMonth,lastDay);
    //hiển thị ngày
        datePickerDialog.show();
    }
    private void btnGio() {
        if(this.lastHouser ==-1) {
            //hiển thị thời gian hiện tại
            final Calendar calendar = Calendar.getInstance();
            this.lastHouser= calendar.get(Calendar.HOUR_OF_DAY);
            this.lastMunite = calendar.get(Calendar.MINUTE);
        }
//        int lastHouser = 10;
//        int lastMunite = 20;
        boolean ischeck24h = true;
        //
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                binding.tvgio.setText(i+":"+i1);
                lastHouser= i;
                lastMunite =i1;
            }
        };
        //
        TimePickerDialog timePickerDialog= null;
        timePickerDialog = new TimePickerDialog(this, timeSetListener, lastHouser,lastMunite,ischeck24h);

        //hiển thị
        timePickerDialog.show();
    }

}
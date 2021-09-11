package com.example.dathang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText etUserNameCode, etPassWordCode;
    Button btnClickCode;
    TextView tvThongBaoCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUserNameCode = findViewById(R.id.etUserName);
        etPassWordCode = findViewById(R.id.etPassWord);
        btnClickCode = findViewById(R.id.btnCick);
        tvThongBaoCode = findViewById(R.id.tvThongBao);

        btnClickCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mk = etPassWordCode.getText().toString();
                String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{4,}$";
                Pattern p = Pattern.compile(regex);
                if(p.matcher(mk).matches()==true){
                    Toast.makeText(getBaseContext(),"đăng nhập thành công", Toast.LENGTH_LONG).show();
                    Intent mh2 = new Intent(MainActivity.this,activity_manhinhchinh.class);
                    mh2.putExtra("username",etUserNameCode.getText().toString());
                    startActivity(mh2);
                }else{
                    tvThongBaoCode.setText("Mật khẩu ít nhất 4 ký tự, viết hoa, thường và số");
                    Toast.makeText(getBaseContext(),"vui lòng nhập lại mật khẩu đúng định dạng",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
package com.yxy.ipcall;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SaveIpActivity extends AppCompatActivity {

    private EditText et_ipNum;
    private Button btn_saveIp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_ip);
        et_ipNum = (EditText) findViewById(R.id.et_ipNum);

        btn_saveIp = (Button) findViewById(R.id.btn_save);
        btn_saveIp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = et_ipNum.getText().toString().trim();
                //使用sp保存起来
                SharedPreferences sp = getSharedPreferences("config",0);
                sp.edit().putString("ipNum",number).commit();
                Toast.makeText(getApplication(),"保存成功",Toast.LENGTH_LONG).show();

            }
        });

    }
}

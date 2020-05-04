package com.yo.registrousuariosandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnRegister, btnShow, btnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnRegister = findViewById(R.id.btnRegister);
        this.btnShow = findViewById(R.id.btnShow);
        this.btnList = findViewById(R.id.btnList);

        init();
    }

    private void init(){
        this.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RegisterUserActivity.class);
                startActivity(i);
                finish();
            }
        });

        this.btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ShowUserActivity.class);
                startActivity(i);
                finish();
            }
        });
    };
}

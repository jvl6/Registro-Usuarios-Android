package com.yo.registrousuariosandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.yo.registrousuariosandroid.bdStatic.BdStatic;
import com.yo.registrousuariosandroid.model.User;

public class RegisterUserActivity extends AppCompatActivity {
    private Button btnBack;
    private Button btnRegister;
    private EditText txtName, txtSurname, txtRut, txtAge;
    private Switch swGender;
    private Spinner spnDrink;
    private TextView lblUserCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        this.btnBack = findViewById(R.id.btnBack);
        this.btnRegister = findViewById(R.id.btnRegister);
        this.txtName = findViewById(R.id.txtName);
        this.txtSurname = findViewById(R.id.txtSurname);
        this.txtRut = findViewById(R.id.txtRut);
        this.txtAge = findViewById(R.id.txtAge);
        this.swGender = findViewById(R.id.swGender);
        this.spnDrink = findViewById(R.id.spnDrink);
        this.lblUserCount = findViewById(R.id.lblUserCount);

        lblUserCount.setText(String.valueOf(BdStatic.userList.size()));

        init();
    }

    private void init(){

        this.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        this.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User u = new User(
                        txtName.getText().toString(),
                        txtSurname.getText().toString(),
                        txtRut.getText().toString(),
                        spnDrink.getSelectedItem().toString(),
                        Integer.parseInt(txtAge.getText().toString()),
                        spnDrink.isActivated());

                BdStatic.userList.add(u);

                lblUserCount.setText(String.valueOf(BdStatic.userList.size()));
            }
        });
    };
}

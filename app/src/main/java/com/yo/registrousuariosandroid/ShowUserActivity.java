package com.yo.registrousuariosandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yo.registrousuariosandroid.bdStatic.BdStatic;
import com.yo.registrousuariosandroid.model.User;

public class ShowUserActivity extends AppCompatActivity {
    private Button btnNext, btnPrevious, btnBack;
    private TextView lblPreviousUser,
            lblCurrentUser,
            lblNextUser,
            lblName,
            lblSurname,
            lblRut,
            lblAge,
            lblGender,
            lblDrink;
    private int listIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_user);

        this.btnNext = findViewById(R.id.btnNext);
        this.btnBack = findViewById(R.id.btnBack);
        this.btnPrevious = findViewById(R.id.btnPrevious);
        this.lblPreviousUser = findViewById(R.id.lblPreviousUser);
        this.lblCurrentUser = findViewById(R.id.lblCurrentUser);
        this.lblNextUser = findViewById(R.id.lblNextUser);
        this.lblName = findViewById(R.id.lblName);
        this.lblSurname = findViewById(R.id.lblSurname);
        this.lblRut = findViewById(R.id.lblRut);
        this.lblAge = findViewById(R.id.lblAge);
        this.lblGender = findViewById(R.id.lblGender);
        this.lblDrink = findViewById(R.id.lblDrink);

        init();
    }

    private void init() {
        if (BdStatic.userList.size() != 0) {
            this.lblCurrentUser.setText("1");
            this.lblPreviousUser.setText("1");
            this.lblNextUser.setText(String.valueOf(BdStatic.userList.size()));

            setUser(listIndex);

            this.btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (BdStatic.userList.size() >= Integer.valueOf(lblCurrentUser.getText().toString()) + 1){
                        lblCurrentUser.setText(String.valueOf(Integer.parseInt(lblCurrentUser.getText().toString()) + 1));
                        listIndex++;
                        setUser(listIndex);
                        lblPreviousUser.setText(String.valueOf(listIndex));
                    }
                }
            });

            this.btnPrevious.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!lblCurrentUser.getText().toString().equals("1")) {
                        lblCurrentUser.setText(String.valueOf(Integer.parseInt(lblCurrentUser.getText().toString()) - 1));
                        listIndex--;
                        setUser(listIndex);
                    }
                }
            });
        }

        this.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void setUser(int currentUser) {
        try {
            User u = BdStatic.userList.get(currentUser);

            this.lblName.setText(u.getName());
            this.lblSurname.setText(u.getSurname());
            this.lblRut.setText(u.getRut());
            this.lblAge.setText(String.valueOf(u.getAge()));

            if (u.isF()) {
                this.lblGender.setText("Femenino");
            } else {
                this.lblGender.setText("Masculino");
            }

            this.lblDrink.setText(u.getFavoriteDrink());
        } catch (Exception e) {
            Context context = getApplicationContext();
            CharSequence text = "Oof!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}

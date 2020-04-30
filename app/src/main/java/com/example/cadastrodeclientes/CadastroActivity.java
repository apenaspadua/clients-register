package com.example.cadastrodeclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.cadastrodeclientes.utils.Utils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CadastroActivity extends AppCompatActivity implements BaseCreate {

    private EditText name, username, password, email, phone;
    private ImageView back;
    private FloatingActionButton register, clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        initComponents();

        register.setOnClickListener(buttonClickRegister);
        clear.setOnClickListener(buttonClickClear);
        back.setOnClickListener(backClick);
    }

    private View.OnClickListener backClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            onBackPressed();
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        finish();
    }

    private View.OnClickListener buttonClickRegister = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           // insertClient();
        }
    };

    private View.OnClickListener buttonClickClear = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           cleanFields();
        }
    };

    private void cleanFields(){
        name.setText("");
        username.setText("");
        password.setText("");
        email.setText("");
        phone.setText("");
    }

    @Override
    public void initInstance() {
        return;
    }

    @Override
    public void initComponents() {
        try {
            name = findViewById(R.id.nameClient);
            username = findViewById(R.id.userName);
            password = findViewById(R.id.password);
            email = findViewById(R.id.email);
            phone = findViewById(R.id.phone);
            register = findViewById(R.id.register);
            clear = findViewById(R.id.clean);
            back = findViewById(R.id.back);
            Utils.setPushDownAnimation(back);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

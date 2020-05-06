package com.example.cadastrodeclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.cadastrodeclientes.application.MyApplication;
import com.example.cadastrodeclientes.model.Cliente;
import com.example.cadastrodeclientes.utils.Utils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CadastroActivity extends AppCompatActivity implements BaseCreate {

    private EditText name, username, password, email, phone;
    private TextInputLayout tilName, tilUsername, tilPhone;
    private ImageView back;
    private Cliente cliente;
    private FloatingActionButton register, clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        initInstance();
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
            insertClient();
        }
    };

    private View.OnClickListener buttonClickClear = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           cleanFields();
        }
    };

    private void insertClient (){
        if (validateForm()) {
            cliente.setNome(name.getText().toString());
            cliente.setNomeUsuario(username.getText().toString());
            cliente.setSenha(password.getText().toString());
            cliente.setEmail(email.getText().toString());
            cliente.setTelefone(phone.getText().toString());

            if(((MyApplication) getApplication()).insertClient(cliente)){
                showMessage(getString(R.string.text_form_save));
                cleanFields();
            } else {
                showMessage(getString(R.string.text_form_failed));
            }
        }
    }

    private boolean validateForm(){
        if(name.getText().toString().isEmpty()){
            tilName.setError(getString(R.string.text_form_empty));
            return false;
        }
        else if(username.getText().toString().isEmpty()){
            tilUsername.setError(getString(R.string.text_form_empty));
            return false;
        }
        else if(phone.getText().toString().isEmpty()){
            tilPhone.setError(getString(R.string.text_form_empty));
            return false;
        }

        return true;
    }

    private void showMessage(String message){
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).show();
    }

    private void cleanFields(){
        name.setText("");
        username.setText("");
        password.setText("");
        email.setText("");
        phone.setText("");
    }

    @Override
    public void initInstance() {
        cliente = Cliente.getInstance();
    }

    @Override
    public void initComponents() {
        try {
            name = findViewById(R.id.nameClient);
            username = findViewById(R.id.userName);
            password = findViewById(R.id.password);
            email = findViewById(R.id.email);
            phone = findViewById(R.id.phone);
            tilName = findViewById(R.id.tilName);
            tilUsername = findViewById(R.id.tilUserName);
            tilPhone = findViewById(R.id.tilPhone);
            register = findViewById(R.id.register);
            clear = findViewById(R.id.clean);
            back = findViewById(R.id.back);
            Utils.setPushDownAnimation(back);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

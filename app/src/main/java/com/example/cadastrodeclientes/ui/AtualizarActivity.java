package com.example.cadastrodeclientes.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.cadastrodeclientes.R;
import com.example.cadastrodeclientes.application.MyApplication;
import com.example.cadastrodeclientes.BaseCreate;
import com.example.cadastrodeclientes.model.Cliente;
import com.example.cadastrodeclientes.utils.Utils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class AtualizarActivity extends AppCompatActivity implements BaseCreate {

    private EditText name, username, password, email, phone;
    private TextInputLayout tilName, tilUsername, tilPhone;
    private ImageView back;
    private Cliente cliente, getCliente;
    private FloatingActionButton update, clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar);

        initInstance();
        initComponents();
        getDataClient();

        update.setOnClickListener(buttonClickUpdate);
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
        finish();
    }

    private View.OnClickListener buttonClickUpdate = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            updateClient();
        }
    };

    private View.OnClickListener buttonClickClear = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            cleanFields();
        }
    };

    private void getDataClient() {
        Intent intent = getIntent();
        getCliente = (Cliente) intent.getSerializableExtra("cliente");

        name.setText(getCliente.getNome());
        username.setText(getCliente.getNomeUsuario());
        password.setText(getCliente.getSenha());
        email.setText(getCliente.getEmail());
        phone.setText(getCliente.getTelefone());
    }

    private void updateClient (){
        if (validateForm()) {
            cliente.setNome(name.getText().toString());
            cliente.setNomeUsuario(username.getText().toString());
            cliente.setSenha(password.getText().toString());
            cliente.setEmail(email.getText().toString());
            cliente.setTelefone(phone.getText().toString());

            if(((MyApplication) AtualizarActivity.this.getApplication()).updateClient(cliente)){
                showMessage(getString(R.string.text_form_update));
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
            name = findViewById(R.id.updateNameClient);
            username = findViewById(R.id.updateUserName);
            password = findViewById(R.id.updatePassword);
            email = findViewById(R.id.updateEmail);
            phone = findViewById(R.id.updatePhone);
            tilName = findViewById(R.id.tilUpdateName);
            tilUsername = findViewById(R.id.tilUpdateUserName);
            tilPhone = findViewById(R.id.tilUpdatePhone);
            update = findViewById(R.id.update);
            clear = findViewById(R.id.cleanUpdate);
            back = findViewById(R.id.back);
            Utils.setPushDownAnimation(back);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

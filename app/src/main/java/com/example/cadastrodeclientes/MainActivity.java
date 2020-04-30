package com.example.cadastrodeclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.cadastrodeclientes.utils.Utils;

public class MainActivity extends AppCompatActivity implements BaseCreate{

    private RelativeLayout buttonCadastro, buttonLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        buttonCadastro.setOnClickListener(buttonClickCadastro);
        buttonLista.setOnClickListener(buttonClickLista);
    }

    private View.OnClickListener buttonClickCadastro = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this, CadastroActivity.class));
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
    };

    private View.OnClickListener buttonClickLista = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this, ListaActivity.class));
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
    };

    @Override
    public void initInstance() {
        return;
    }

    @Override
    public void initComponents() {
        try {
            buttonCadastro = findViewById(R.id.btn_register);
            buttonLista = findViewById(R.id.btn_list);
            Utils.setPushDownAnimation(buttonCadastro);
            Utils.setPushDownAnimation(buttonLista);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

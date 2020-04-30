package com.example.cadastrodeclientes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.cadastrodeclientes.R;

public class ListaActivity extends AppCompatActivity implements BaseCreate {

    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        initComponents();

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
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        finish();
    }


    @Override
    public void initInstance() {
        return;
    }

    @Override
    public void initComponents() {
        try{
            back = findViewById(R.id.back);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

package com.example.cadastrodeclientes.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.cadastrodeclientes.R;
import com.example.cadastrodeclientes.adapter.ListAdapter;
import com.example.cadastrodeclientes.database.Database;
import com.example.cadastrodeclientes.BaseCreate;
import com.example.cadastrodeclientes.model.Cliente;
import com.example.cadastrodeclientes.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity implements BaseCreate {

    private ImageView back;
    private List<Cliente> clienteList;
    private ListAdapter adapter;
    private RecyclerView recyclerView;
    private Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        initInstance();
        initComponents();
        back.setOnClickListener(backClick);
    }

    private View.OnClickListener backClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            onBackPressed();
        }
    };

    private void setupList() {
        clienteList = new ArrayList<>();
        clienteList.addAll(db.clientDao().getAllClients());
        adapter = new ListAdapter(this, clienteList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        finish();
    }


    @Override
    public void initInstance() {
        db = Database.getInstance(this);
    }

    @Override
    public void initComponents() {
        try{
            back = findViewById(R.id.back);
            recyclerView = findViewById(R.id.recyclerClients);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            Utils.setPushDownAnimation(back);
            setupList();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

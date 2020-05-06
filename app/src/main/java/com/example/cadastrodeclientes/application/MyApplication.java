package com.example.cadastrodeclientes.application;

import android.app.Application;

import com.example.cadastrodeclientes.database.Database;
import com.example.cadastrodeclientes.model.Cliente;

import java.util.List;


public class MyApplication extends Application {
    private Database db;

    @Override
    public void onCreate() {
        super.onCreate();

        db = Database.getInstance(getApplicationContext());
    }

    public MyApplication(){}

    public List<Cliente> getAllClients(){

        return db.clientDao().getAllClients();
    }

    public boolean insertClient(final Cliente cliente){
        try {
            db.clientDao().insertClients(cliente);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteClient(final Cliente cliente){
        try {
            db.clientDao().deleteClients(cliente);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

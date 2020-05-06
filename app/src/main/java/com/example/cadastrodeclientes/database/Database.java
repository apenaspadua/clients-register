package com.example.cadastrodeclientes.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.cadastrodeclientes.database.dao.ClienteDAO;
import com.example.cadastrodeclientes.model.Cliente;

import java.util.List;

import io.reactivex.Flowable;


@androidx.room.Database(entities = {Cliente.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase implements DatabaseContract {

    private static Database mInstance;
    private DatabaseContract mLocalDatabase;

    public abstract ClienteDAO clientDao();

    public static Database getInstance(Context context){
        if(mInstance == null)
            mInstance = Room.databaseBuilder(context, Database.class,
                    "clientDB").allowMainThreadQueries().build();

        return mInstance;
    }

    @Override
    public Flowable<List<Cliente>> getAllClients() {
        return mLocalDatabase.getAllClients();
    }

    @Override
    public void insertClients(Cliente... clientes) {
        mLocalDatabase.insertClients();
    }

    @Override
    public void deleteClients(Cliente... clientes) {
        mLocalDatabase.deleteClients();
    }
}
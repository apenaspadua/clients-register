package com.example.cadastrodeclientes.database;

import com.example.cadastrodeclientes.model.Cliente;

import java.util.List;

import io.reactivex.Flowable;

public interface DatabaseContract {

    Flowable<List<Cliente>> getAllClients();
    void deleteClients(Cliente... clientes);
    void insertClients(Cliente... clientes);
}

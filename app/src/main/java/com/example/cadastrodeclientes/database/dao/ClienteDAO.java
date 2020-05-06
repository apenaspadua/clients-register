package com.example.cadastrodeclientes.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.cadastrodeclientes.model.Cliente;

import java.util.List;
@Dao
public interface ClienteDAO {

    @Query("SELECT * FROM Cliente")
    List<Cliente> getAllClients();

    @Insert
    void insertClients(Cliente... clientes);

    @Delete
    void deleteClients(Cliente... clientes);
}

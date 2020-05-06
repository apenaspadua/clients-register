package com.example.cadastrodeclientes.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Cliente implements Serializable {
    private static Cliente mInstance;

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "name")
    public String nome;

    @ColumnInfo(name = "nomeUsuario")
    public String nomeUsuario;

    @ColumnInfo(name = "senha")
    public String senha;

    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "telefone")
    public String telefone;

    public Cliente() { }

    public static synchronized Cliente getInstance(){
        if(mInstance == null) mInstance = new Cliente();

        return mInstance;
    }

    @Ignore
    public Cliente(String nome, String nomeUsuario, String senha, String email, String telefone){
        this.nome = nome;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.email = email;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @NonNull
    @Override
    public  String toString(){return  super.toString();}
}

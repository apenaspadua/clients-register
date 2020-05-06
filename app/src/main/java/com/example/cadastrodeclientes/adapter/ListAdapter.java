package com.example.cadastrodeclientes.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cadastrodeclientes.R;
import com.example.cadastrodeclientes.model.Cliente;

import java.util.List;

@SuppressLint("NewApi")
@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{
    private Context context;
    private List<Cliente> clientes;
    private static ListAdapter adapter;

    public static synchronized ListAdapter getInstance(){
        if (adapter == null) adapter = new ListAdapter();

        return adapter;
    }

    public ListAdapter() { }

    public ListAdapter(Context context, List<Cliente> clientesList) {
        this.context = context;
        this.clientes = clientesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_cliente, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Cliente book = clientes.get(position);

        holder.name.setText(book.getNome());
        holder.username.setText(book.getNomeUsuario());
        holder.telefone.setText(book.getEmail());
    }

    @Override
    public int getItemCount() {
        return clientes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, username, telefone;

        public ViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.nameList);
            username = itemView.findViewById(R.id.usernameList);
            telefone = itemView.findViewById(R.id.phoneList);
        }
    }

}

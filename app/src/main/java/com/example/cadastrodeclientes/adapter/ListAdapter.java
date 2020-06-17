package com.example.cadastrodeclientes.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cadastrodeclientes.R;
import com.example.cadastrodeclientes.database.Database;
import com.example.cadastrodeclientes.model.Cliente;
import com.example.cadastrodeclientes.ui.AtualizarActivity;
import com.example.cadastrodeclientes.utils.Utils;

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
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Database database = Database.getInstance(context);
        final Cliente cliente = clientes.get(position);

        Utils.setPushDownAnimation(holder.editButton);
        Utils.setPushDownAnimation(holder.deleteButton);

        holder.name.setText(cliente.getNome());
        holder.username.setText(cliente.getNomeUsuario());
        holder.telefone.setText(cliente.getEmail());

        holder.editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AtualizarActivity.class);
                intent.putExtra("cliente", cliente);
                context.startActivity(intent);
            }
        });

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.clientDao().deleteClients(cliente);
                clientes.remove(cliente);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, clientes.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return clientes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, username, telefone;
        RelativeLayout editButton, deleteButton;

        public ViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.nameList);
            username = itemView.findViewById(R.id.usernameList);
            telefone = itemView.findViewById(R.id.phoneList);
            editButton = itemView.findViewById(R.id.edit);
            deleteButton = itemView.findViewById(R.id.delete);
        }
    }

}

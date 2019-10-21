package com.example.sqlitecrud2019.Controller;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlitecrud2019.Model.Users;
import com.example.sqlitecrud2019.R;

import java.util.List;

public class ViewL extends RecyclerView.Adapter<ViewL.Holder> {
    List<Users> listUsers;
public Integer idf;
    public ViewL(List<Users> listUsers) {
        this.listUsers = listUsers;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_muser,parent,false);
        ViewL.Holder holder = new ViewL.Holder(v);

        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.fin.setText(listUsers.get(position).getFirstname());
        holder.lan.setText(listUsers.get(position).getLastname());
        holder.Email3.setText(listUsers.get(position).getUsername());
        idf = listUsers.get(position).getId();
    }

    @Override
    public int getItemCount() {
        return listUsers.size();
    }

    public class Holder  extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{
        private TextView fin,lan, Email3;
        CardView cardView;
        public Holder(@NonNull android.view.View itemView) {
            super(itemView);

            fin = (TextView) itemView.findViewById(R.id.fin);
            lan =(TextView) itemView.findViewById(R.id.lan);
            Email3 = (TextView) itemView.findViewById(R.id.email3);
            cardView =(CardView) itemView.findViewById(R.id.cardview1);
            cardView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {

            contextMenu.add(this.getAdapterPosition(),121,0,"Delete User" );
            contextMenu.add(this.getAdapterPosition(),122,1,"Update User");

        }
    }

}

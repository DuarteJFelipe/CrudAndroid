package com.example.myaccounts.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myaccounts.R;
import com.example.myaccounts.entities.Accounts;

import java.util.ArrayList;

public class ListAccountsAdapter extends RecyclerView.Adapter<ListAccountsAdapter.AccountViewHolder> {

    ArrayList<Accounts> listAccounts;

    public ListAccountsAdapter(ArrayList<Accounts> listAccounts){
        this.listAccounts = listAccounts;
    }

    @NonNull
    @Override
    public AccountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_account,null,false);
        return new AccountViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AccountViewHolder holder, int position) {
        holder.tvPlatform.setText(listAccounts.get(position).getPlatform());
        holder.tvName.setText(listAccounts.get(position).getName());
        holder.tvPassword.setText(listAccounts.get(position).getPassword());
    }

    @Override
    public int getItemCount() {
        return listAccounts.size();
    }

    public class AccountViewHolder extends RecyclerView.ViewHolder {

        TextView tvPlatform, tvName, tvPassword;

        public AccountViewHolder(@NonNull View itemView) {
            super(itemView);

            tvPlatform = itemView.findViewById(R.id.tvName);
            tvName = itemView.findViewById(R.id.tvName);
            tvPassword = itemView.findViewById(R.id.tvPassword);

        }
    }
}

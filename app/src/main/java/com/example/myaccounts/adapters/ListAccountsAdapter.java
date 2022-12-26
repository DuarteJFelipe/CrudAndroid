package com.example.myaccounts.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myaccounts.R;
import com.example.myaccounts.entities.Account;

import java.util.ArrayList;

public class ListAccountsAdapter extends RecyclerView.Adapter<ListAccountsAdapter.AccountViewHolder> {

    ArrayList<Account> listAccounts;

    public ListAccountsAdapter(ArrayList<Account> listAccounts){
        this.listAccounts = listAccounts;
    }

    @NonNull
    @Override
    public AccountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_account, parent,false);
        return new AccountViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AccountViewHolder holder, int position) {
        holder.bind(listAccounts.get(position));
    }

    @Override
    public int getItemCount() {
        return listAccounts.size();
    }

    public static class AccountViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvPlatform;
        private final TextView tvName;
        private final TextView tvPassword;

        public AccountViewHolder(@NonNull View itemView) {
            super(itemView);

            tvPlatform = itemView.findViewById(R.id.tvPlatform);
            tvName = itemView.findViewById(R.id.tvName);
            tvPassword = itemView.findViewById(R.id.tvPassword);
        }

        public void bind(Account account){
            tvPlatform.setText(account.getPlatform());
            tvName.setText(account.getName());
            tvPassword.setText(account.getPassword());
        }
    }

}

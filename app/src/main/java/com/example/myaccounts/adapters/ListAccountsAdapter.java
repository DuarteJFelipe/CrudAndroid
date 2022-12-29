package com.example.myaccounts.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myaccounts.R;
import com.example.myaccounts.ReadActivity;
import com.example.myaccounts.entities.Account;

import java.util.ArrayList;

public class ListAccountsAdapter extends RecyclerView.Adapter<ListAccountsAdapter.AccountViewHolder> {

    static ArrayList<Account> listAccounts;

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

        TextView tvPlatform, tvName,  tvPassword;

        public AccountViewHolder(@NonNull View itemView) {
            super(itemView);

            tvPlatform = itemView.findViewById(R.id.tvPlatform);
            tvName = itemView.findViewById(R.id.tvName);
            tvPassword = itemView.findViewById(R.id.tvPassword);

            itemView.setOnClickListener(v -> {
                Context context = v.getContext();
                Intent intent = new Intent(context, ReadActivity.class);
                intent.putExtra("ID", listAccounts.get(getAdapterPosition()).getId());
                context.startActivity(intent);
            });
        }

        public void bind(Account account){
            tvPlatform.setText(account.getPlatform());
            tvName.setText(account.getName());
            tvPassword.setText(account.getPassword());
        }
    }

}

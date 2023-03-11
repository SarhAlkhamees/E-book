package com.example.assignment2_sarh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<Book> list;

    public MyAdapter(Context context, ArrayList<Book> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.books,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Book book = list.get(position);
        holder.authorname.setText(book.getAuthor_name());
        holder.booktitle.setText(book.getBook_title());
        holder.bookcate.setText(book.getBook_cate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView authorname, booktitle, bookcate;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            authorname = itemView.findViewById(R.id.textauthorname);
            booktitle = itemView.findViewById(R.id.textbooktitle);
            bookcate = itemView.findViewById(R.id.textbookcate);
        }
    }
}

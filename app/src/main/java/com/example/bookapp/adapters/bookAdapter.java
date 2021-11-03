package com.example.bookapp.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.bookapp.LoadImgFromURL;
import com.example.bookapp.R;
import com.example.bookapp.SessionManager;
import com.example.bookapp.models.Book;
import com.example.bookapp.seller.addBookActivity;
import com.example.bookapp.seller.booksList;
import com.example.bookapp.seller.copiesList;

import java.util.List;

public class bookAdapter extends RecyclerView.Adapter<bookAdapter.MyViewHolder> {

    List<Book> list;
    Activity context;
    SessionManager session;
    public bookAdapter(List<Book> list, Activity context) {
        this.list = list;
        this.context = context;
        session = new SessionManager(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.seller_single_view_book, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name.setText(list.get(position).getBookName());

        String imgURL = list.get(position).getImage();
        new LoadImgFromURL(holder.image, 0 , 0).execute(imgURL);
         holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book i = list.get(position);/*
                Intent intent = new Intent(context, BookDetailsActivity.class);
                intent.putExtra("Book",  i);
                context.startActivity(intent);
                */

            }
        });
         holder.viewBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 Book i = list.get(position);
                 Intent intent = new Intent(context, copiesList.class);
                 intent.putExtra("book",  i);
                 context.startActivity(intent);
             }
         });

         holder.editBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Book i = list.get(position);
                 Intent intent = new Intent(context, addBookActivity.class);
                 intent.putExtra("book",  i);
                 context.startActivity(intent);

             }
         });

         holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Book i = list.get(position);
                 booksList b = (booksList) context;
                 b.delete(i);
             }
         });

    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        Button viewBtn ;
        Button editBtn ;
        Button deleteBtn ;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);

            viewBtn = itemView.findViewById(R.id.viewBtn);
            editBtn = itemView.findViewById(R.id.editBtn);
            deleteBtn = itemView.findViewById(R.id.deleteBtn);

        }
    }
}

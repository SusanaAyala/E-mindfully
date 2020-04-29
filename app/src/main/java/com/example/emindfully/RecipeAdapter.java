package com.example.emindfully;

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

import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> implements View.OnClickListener{

    ArrayList<Recipes> recipe;
    Context context;
    private View.OnClickListener listener;

    public RecipeAdapter (ArrayList<Recipes>recipe) { this.recipe = recipe;}

    @NonNull
    @Override
    public RecipeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, null, false);
        RecyclerView.LayoutParams layParams = new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layParams);

        view.setOnClickListener(this);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewholder, int position) {
        viewholder.txtName.setText(recipe.get(position).getName());
        viewholder.txtDescription.setText(recipe.get(position).getDes());
        viewholder.food.setImageResource(recipe.get(position).getImageId());


    }

    @Override
    public int getItemCount() {
        return recipe.size();
    }

    public void setOnClickListener(View.OnClickListener listener) { this.listener=listener;}

    public void onClick (View view) {
        if (listener!=null) {
            listener.onClick(view);
        }
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtName, txtDescription;
        ImageView food;
        Button shareButton;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.idName);
            txtDescription = itemView.findViewById(R.id.idDes);
            food = itemView.findViewById(R.id.imageView2);

            shareButton = itemView.findViewById(R.id.shareButton);
            shareButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent myIntent = new Intent(context, RecipeAdapter.class);
                    context.startActivity(Intent.createChooser(myIntent, "Share Using"));
                }
            });
        }
    }}







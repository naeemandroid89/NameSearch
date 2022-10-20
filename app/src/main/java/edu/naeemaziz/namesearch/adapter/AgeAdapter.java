package edu.naeemaziz.namesearch.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.naeemaziz.namesearch.R;
import edu.naeemaziz.namesearch.model.Age;


public class AgeAdapter extends RecyclerView.Adapter<AgeAdapter.ViewHolder> {

    Context context;
    List<Age> ageResponse;

    public AgeAdapter(Context ctx, List<Age> age) {
        context = ctx;
        ageResponse = age;
    }

    @NonNull
    @Override
    public AgeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.age_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AgeAdapter.ViewHolder holder, int position) {
        Age ageItem = ageResponse.get(position);
        holder.name.setText("Name: " + ageItem.getName());
        if (ageItem.getAge() == 0) {
            holder.age.setText("No age found!");
            holder.count.setText("No count found!" + ageItem.getCount());
        } else {
            holder.age.setText("Age: " + ageItem.getAge());
            holder.count.setText("Count: " + ageItem.getCount());
        }
    }

    @Override
    public int getItemCount() {
        return ageResponse.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        AppCompatTextView name, age, count;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            age = itemView.findViewById(R.id.age);
            count = itemView.findViewById(R.id.count);
        }
    }
}

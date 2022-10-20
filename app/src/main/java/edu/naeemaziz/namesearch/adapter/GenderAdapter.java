package edu.naeemaziz.namesearch.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.naeemaziz.namesearch.R;
import edu.naeemaziz.namesearch.model.Gender;


public class GenderAdapter extends RecyclerView.Adapter<GenderAdapter.ViewHolder> {

    Context context;
    List<Gender> genderResponse;

    public GenderAdapter(Context ctx, List<Gender> gender) {
        context = ctx;
        genderResponse = gender;
    }

    @NonNull
    @Override
    public GenderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gender_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GenderAdapter.ViewHolder holder, int position) {
        Gender genderItem = genderResponse.get(position);
        holder.name.setText("Name: " + genderItem.getName());
        if (genderItem.getGender() == null) {
            holder.gender.setText("No gender found!");
            holder.genderImage.setVisibility(View.GONE);
            holder.itemBackground.setBackground(context.getResources().getDrawable(R.drawable.btn_background));
        } else {
            holder.gender.setText("Gender: " + genderItem.getGender());
            holder.probability.setText("Probabilty: " + genderItem.getProbability());
            if (genderItem.getGender().equals("male")) {
                holder.genderImage.setImageDrawable(context.getResources().getDrawable(R.drawable.male));
                holder.itemBackground.setBackground(context.getResources().getDrawable(R.drawable.male_itembackg));
            } else if (genderItem.getGender().equals("female")) {
                holder.genderImage.setImageDrawable(context.getResources().getDrawable(R.drawable.female));
                holder.itemBackground.setBackground(context.getResources().getDrawable(R.drawable.female_itembackg));

            }
        }
    }

    @Override
    public int getItemCount() {
        return genderResponse.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView genderImage;
        RelativeLayout itemBackground;
        AppCompatTextView name, gender, probability;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            genderImage = itemView.findViewById(R.id.genderimage);
            itemBackground = itemView.findViewById(R.id.item_background);
            name = itemView.findViewById(R.id.name);
            gender = itemView.findViewById(R.id.gender);
            probability = itemView.findViewById(R.id.prob);
        }
    }
}

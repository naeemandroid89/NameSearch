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
import edu.naeemaziz.namesearch.model.Country;


public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

    Context context;
    List<Country> countryResponse;

    public CountryAdapter(Context ctx, List<Country> country) {
        context = ctx;
        countryResponse = country;
    }

    @NonNull
    @Override
    public CountryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryAdapter.ViewHolder holder, int position) {
        Country countryItem = countryResponse.get(position);
        holder.name.setText("Name: " + countryItem.getName());
        if (countryItem.country.size() == 0) {
            holder.country.setText("No country found!");
            holder.prob.setText("Probabilty: 0");
        } else {
            holder.country.setText("Country: " + countryItem.getCountryList().get(0).getID());
            holder.prob.setText("Probabilty: " + countryItem.getCountryList().get(0).getProbability());
        }
    }

    @Override
    public int getItemCount() {
        return countryResponse.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        AppCompatTextView name, country, prob;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            country = itemView.findViewById(R.id.country);
            prob = itemView.findViewById(R.id.prob);
        }
    }
}

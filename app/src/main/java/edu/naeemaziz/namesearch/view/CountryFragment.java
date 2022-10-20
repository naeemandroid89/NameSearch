package edu.naeemaziz.namesearch.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.naeemaziz.namesearch.R;
import edu.naeemaziz.namesearch.adapter.CountryAdapter;
import edu.naeemaziz.namesearch.model.Country;
import edu.naeemaziz.namesearch.viewmodel.NameSearchViewModel;

public class CountryFragment extends Fragment {

    private static final String QUERY = "query";
    private String queryData;
    RecyclerView recyclerView;
    AppCompatImageView backBtn;
    AppCompatTextView title;
    ProgressBar progressBar;
    List<Country> countryList = new ArrayList<>();
    CountryAdapter countryAdapter;
    NameSearchViewModel nameSearchViewModel;

    public CountryFragment() {
    }

    public static CountryFragment newInstance(String param1) {
        CountryFragment fragment = new CountryFragment();
        Bundle args = new Bundle();
        args.putString(QUERY, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            queryData = getArguments().getString(QUERY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_common, container, false);
        initView(view);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        nameSearchViewModel = new ViewModelProvider(getActivity()).get(NameSearchViewModel.class);
        nameSearchViewModel.getCountryResponse(queryData).observe(getActivity(), countryResponse -> {

            if (countryResponse != null && countryResponse != null && !countryResponse.getCountryResponse().isEmpty()) {
                progressBar.setVisibility(View.GONE);
                countryList.addAll(countryResponse.getCountryResponse());
                countryAdapter.notifyDataSetChanged();
            }
        });
    }

    public void initView(View view) {
        recyclerView = view.findViewById(R.id.recyler_view);
        progressBar = view.findViewById(R.id.progress_bar);
        backBtn = view.findViewById(R.id.backbtn);
        title = view.findViewById(R.id.title);
        title.setText("Country Predictor");
        LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutmanager);
        countryAdapter = new CountryAdapter(getActivity(), countryList);
        recyclerView.setAdapter(countryAdapter);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getViewModelStore().clear();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new MainFragment())
                        .commit();
            }
        });
    }

}
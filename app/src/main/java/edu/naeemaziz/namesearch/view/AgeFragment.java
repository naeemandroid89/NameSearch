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
import edu.naeemaziz.namesearch.adapter.AgeAdapter;
import edu.naeemaziz.namesearch.model.Age;
import edu.naeemaziz.namesearch.viewmodel.NameSearchViewModel;

public class AgeFragment extends Fragment {

    private static final String QUERY = "query";
    private String queryData;
    RecyclerView recyclerView;
    AppCompatImageView backBtn;
    AppCompatTextView title;
    ProgressBar progressBar;
    List<Age> ageList = new ArrayList<>();
    AgeAdapter ageAdapter;
    NameSearchViewModel nameSearchViewModel;

    public AgeFragment() {
    }

    public static AgeFragment newInstance(String param1) {
        AgeFragment fragment = new AgeFragment();
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
        nameSearchViewModel.getAgeResponse(queryData).observe(getActivity(), ageResponse -> {

            if (ageResponse != null && ageResponse != null && !ageResponse.getAgeResponse().isEmpty()) {
                progressBar.setVisibility(View.GONE);
                ageList.addAll(ageResponse.getAgeResponse());
                ageAdapter.notifyDataSetChanged();
            }
        });
    }

    public void initView(View view) {
        recyclerView = view.findViewById(R.id.recyler_view);
        progressBar = view.findViewById(R.id.progress_bar);
        backBtn = view.findViewById(R.id.backbtn);
        title = view.findViewById(R.id.title);
        title.setText("Age Predictor");
        LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutmanager);
        ageAdapter = new AgeAdapter(getActivity(), ageList);
        recyclerView.setAdapter(ageAdapter);

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
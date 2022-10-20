package edu.naeemaziz.namesearch.view;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import edu.naeemaziz.namesearch.R;


public class MainFragment extends Fragment  implements View.OnClickListener {

    CardView ageView, genderView, countryView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        initView(view);
        return view;
    }

    public void initView(View view){
        ageView = view.findViewById(R.id.ageview);
        genderView = view.findViewById(R.id.genderview);
        countryView = view.findViewById(R.id.countryview);
        ageView.setOnClickListener(this);
        countryView.setOnClickListener(this);
        genderView.setOnClickListener(this);
    }

    public void fragmentNav(String id, String title){
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, PerdictorFragment.newInstance(id ,title))
                .commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ageview:
                fragmentNav("ageView","Age Perdictor");
                break;
            case R.id.genderview:
                fragmentNav("genderView","Gender Perdictor");
                break;
            case R.id.countryview:
                fragmentNav("countryView","Country Perdictor");
                break;
        }
    }
}
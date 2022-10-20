package edu.naeemaziz.namesearch.view;

import android.os.Bundle;


import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import edu.naeemaziz.namesearch.R;
import edu.naeemaziz.namesearch.utilty.Utilty;

public class PerdictorFragment extends Fragment {

    private static final String SELECTION_ID = "selectionId";
    private static final String TITLE = "title";
    private String title;
    private String selectedview;
    private AppCompatTextView screenTitle;
    AppCompatImageView backBtn;
    AppCompatButton submitBtn;
    private EditText name1, name2, name3;

    public PerdictorFragment() {
        // Required empty public constructor
    }

    public static PerdictorFragment newInstance(String id, String title) {
        PerdictorFragment fragment = new PerdictorFragment();
        Bundle args = new Bundle();
        args.putString(SELECTION_ID, id);
        args.putString(TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(TITLE);
            selectedview = getArguments().getString(SELECTION_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perdictor, container, false);
        initView(view);
        return view;
    }

    public void initView(View view){
        screenTitle = view.findViewById(R.id.title);
        name1 = view.findViewById(R.id.name1);
        name2 = view.findViewById(R.id.name2);
        name3 = view.findViewById(R.id.name3);
        backBtn = view.findViewById(R.id.backbtn);
        submitBtn = view.findViewById(R.id.submit);
        screenTitle.setText(title);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Utilty.isNetwork(getActivity())){
                    if(name1.getText().toString().isEmpty() && name2.getText().toString().isEmpty() && name3.getText().toString().isEmpty()){
                        Toast.makeText(getActivity(), "Please enter atleast one field to process!",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        String query = Utilty.generateQuery(name1.getText().toString(), name2.getText().toString(), name3.getText().toString());

                        if(selectedview.equals("ageView")){
                            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,  AgeFragment.newInstance(query))
                                    .commit();
                        }
                        else if(selectedview.equals("genderView")){
                            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,  GenderFragment.newInstance(query))
                                    .commit();
                        }
                        else if(selectedview.equals("countryView")){
                            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,  CountryFragment.newInstance(query))
                                    .commit();
                        }

                    }
                }
                else {
                    Utilty.showNetworkErrorDialogue(getActivity());
                }

            }

        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new MainFragment())
                        .commit();
            }
        });
    }

}
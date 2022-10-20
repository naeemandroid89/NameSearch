package edu.naeemaziz.namesearch.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.naeemaziz.namesearch.R;
import edu.naeemaziz.namesearch.utilty.Utilty;
import edu.naeemaziz.namesearch.view.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new MainFragment())
                .commit();
    }

    @Override
    public void onBackPressed() {
        Utilty.showExitDialogue(this);
    }
}
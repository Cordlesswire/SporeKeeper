package com.udacity.android.sporekeeper;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int score_A = 0;
    private int score_B = 0;
    private TextView scoreTeamAText;
    private TextView scoreTeamBText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreTeamAText = (TextView) findViewById(R.id.team_a_score);
        scoreTeamBText = (TextView) findViewById(R.id.team_b_score);

        Toolbar toolTitle = (Toolbar) findViewById(R.id.toolbar);
        setupTitle(toolTitle);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        setupReset(fab);

        setupPointsButton();
    }


    private void setupPointsButton() {
        Button addThreeForTeamA = (Button) findViewById(R.id.addThreeForTeamA);
        addThreeForTeamA.setOnClickListener(this);
        Button addThreeForTeamB = (Button) findViewById(R.id.addThreeForTeamB);
        addThreeForTeamB.setOnClickListener(this);

        Button addTwoForTeamA = (Button) findViewById(R.id.addTwoForTeamA);
        addTwoForTeamA.setOnClickListener(this);
        Button addTwoForTeamB = (Button) findViewById(R.id.addTwoForTeamB);
        addTwoForTeamB.setOnClickListener(this);

        Button addOneForTeamA = (Button) findViewById(R.id.addOneForTeamA);
        addOneForTeamA.setOnClickListener(this);
        Button addOneForTeamB = (Button) findViewById(R.id.addOneForTeamB);
        addOneForTeamB.setOnClickListener(this);
    }


    private void setupTitle(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        toolbar.setSubtitle("Basketball");
        toolbar.setLogo(R.mipmap.ic_launcher);
    }


    private void setupReset(FloatingActionButton fab) {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score_A = 0;
                score_B = 0;
                displayForTeam(scoreTeamAText, score_A);
                displayForTeam(scoreTeamBText, score_B);
                Snackbar.make(view, "Reset score", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
            }
        });
    }


    public void displayForTeam(TextView scoreView, int score) {
        scoreView.setText(String.valueOf(score));
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.addThreeForTeamA:
                score_A += 3;
                displayForTeam(scoreTeamAText, score_A);
                break;
            case R.id.addTwoForTeamA:
                score_A += 2;
                displayForTeam(scoreTeamAText, score_A);
                break;
            case R.id.addOneForTeamA:
                score_A += 1;
                displayForTeam(scoreTeamAText, score_A);
                break;
            case R.id.addThreeForTeamB:
                score_B += 3;
                displayForTeam(scoreTeamBText, score_B);
                break;
            case R.id.addTwoForTeamB:
                score_B += 2;
                displayForTeam(scoreTeamBText, score_B);
                break;
            case R.id.addOneForTeamB:
                score_B += 1;
                displayForTeam(scoreTeamBText, score_B);
                break;
        }
    }

}

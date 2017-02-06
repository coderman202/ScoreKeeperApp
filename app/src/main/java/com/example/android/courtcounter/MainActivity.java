package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Initialise ints to track team scores and TextViews to display them.
    int scoreA = 0;
    int scoreB = 0;
    TextView scoreViewA, scoreViewB;
    TextView teamA, teamB;

    //States for recalling scores on restore
    static final String STATE_SCORE_A = "ScoreTeamA";
    static final String STATE_SCORE_B = "ScoreTeamB";

    //Initialise an array of NBA teams.
    String teams[] = {
            "Atlanta Hawks", "Boston Celtics", "Brooklyn Nets", "Charlotte Hornets",
            "Chicago Bulls", "Cleveland Cavaliers", "Dallas Mavericks", "Denver Nuggets",
            "Detroit Pistons", "Golden State Warriors", "Houston Rockets", "Indiana Pacers",
            "LA Clippers", "LA Lakers", "Memphis Grizzlies", "Miami Heat", "Milwaukee Bucks",
            "Minnesota Timberwolves", "New Orleans Pelicans", "New York Knicks",
            "Oklahoma City Thunder", "Orlando Magic", "Philadelphia 76ers", "Phoenix Suns",
            "Portland Trail Blazers", "Sacramento Kings", "San Antonio Spurs", "Toronto Raptors",
            "Utah Jazz", "Washington Wizards"
    };

    //Initialise the gridviews to display all the logos for selection.
    GridView gridA, gridB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState != null){
            scoreA = savedInstanceState.getInt(STATE_SCORE_A);
            scoreB = savedInstanceState.getInt(STATE_SCORE_B);
        }
        setContentView(R.layout.activity_main);

        scoreViewA = (TextView) findViewById(R.id.score_a);
        scoreViewB = (TextView) findViewById(R.id.score_b);

        teamA = (TextView) findViewById(R.id.team_a);
        teamB = (TextView) findViewById(R.id.team_b);

        teamA.setText(teams[0]);
        teamB.setText(teams[0]);

        displayScore(scoreA, scoreViewA);
        displayScore(scoreB, scoreViewB);

        gridA = (GridView) findViewById(R.id.selector_a);
        gridB = (GridView) findViewById(R.id.selector_b);

        gridA.setAdapter(new ImageAdapter(this));
        gridB.setAdapter(new ImageAdapter(this));

    }

    //Save state instance here
    @Override
    public void onSaveInstanceState(Bundle saveState) {
        saveState.putInt(STATE_SCORE_A, scoreA);
        saveState.putInt(STATE_SCORE_B, scoreB);
        super.onSaveInstanceState(saveState);
    }

    //Restore instance here
    public void onRestoreInstanceState(Bundle restoreState) {
        super.onRestoreInstanceState(restoreState);
        scoreA = restoreState.getInt(STATE_SCORE_A);
        scoreB = restoreState.getInt(STATE_SCORE_B);
        displayScore(scoreA, scoreViewA);
        displayScore(scoreB, scoreViewB);
    }

    //The following two methods update the scores for each team.
    public void updateScoreA(View btn){
        scoreA+=Integer.parseInt(btn.getTag().toString());
        displayScore(scoreA, scoreViewA);

    }

    public void updateScoreB(View btn){
        scoreB+=Integer.parseInt(btn.getTag().toString());
        displayScore(scoreB, scoreViewB);

    }

    //Displays the given score for a given team.
    private void displayScore(int score, TextView scoreView) {
        scoreView.setText(String.valueOf(score));
    }

    //Reset the scores to 0
    public void resetScores(View resetBtn){
        scoreA = 0;
        scoreB = 0;
        displayScore(scoreA, scoreViewA);
        displayScore(scoreB, scoreViewB);
    }

    //Method for creating random numbers to select basketball teams
    private static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}

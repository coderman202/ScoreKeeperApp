package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Initialise ints to track team scores and TextViews to display them.
    private int scoreA = 0;
    private int scoreB = 0;
    private TextView scoreViewA, scoreViewB;

    /***
     * Lawler's Law tracker. Lawler's Law is a term first introduced by Los Angeles Clippers
     * broadcaster Ralph Lawler.
     * @see <a href="http://lawlerslawtracker.com/">Lawler's Law Tracker Website</a>
     */
    private boolean lawlersLaw = false;


    //Initialise ImageViews to display selected team's logo
    private ImageView logoA, logoB;

    //States for recalling scores on restore
    private static final String STATE_SCORE_A = "ScoreTeamA";
    private static final String STATE_SCORE_B = "ScoreTeamB";
    private static final String STATE_LAWLER = "LawlersLaw";

    //Initialise an array of NBA teams.
    private final String teams[] = {
            "Atlanta Hawks", "Boston Celtics", "Brooklyn Nets", "Charlotte Hornets",
            "Chicago Bulls", "Cleveland Cavaliers", "Dallas Mavericks", "Denver Nuggets",
            "Detroit Pistons", "Golden State Warriors", "Houston Rockets", "Indiana Pacers",
            "LA Clippers", "LA Lakers", "Memphis Grizzlies", "Miami Heat", "Milwaukee Bucks",
            "Minnesota Timberwolves", "New Orleans Pelicans", "New York Knicks",
            "Oklahoma City Thunder", "Orlando Magic", "Philadelphia 76ers", "Phoenix Suns",
            "Portland Trail Blazers", "Sacramento Kings", "San Antonio Spurs", "Toronto Raptors",
            "Utah Jazz", "Washington Wizards"
    };

    //Initialise the Spinners to display all the teams for selection.
    private Spinner spinnerA, spinnerB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            scoreA = savedInstanceState.getInt(STATE_SCORE_A);
            scoreB = savedInstanceState.getInt(STATE_SCORE_B);
            lawlersLaw = savedInstanceState.getBoolean(STATE_LAWLER);

        }
        setContentView(R.layout.activity_main);

        scoreViewA = (TextView) findViewById(R.id.score_a);
        scoreViewB = (TextView) findViewById(R.id.score_b);

        logoA = (ImageView) findViewById(R.id.logo_a);
        logoB = (ImageView) findViewById(R.id.logo_b);

        displayScore(scoreA, scoreViewA);
        displayScore(scoreB, scoreViewB);

        spinnerA = (Spinner) findViewById(R.id.selector_a);
        spinnerB = (Spinner) findViewById(R.id.selector_b);

        addToSpinner(spinnerA, teams);
        addToSpinner(spinnerB, teams);

        addListenerOnSpinnerItemSelection(spinnerA);
        addListenerOnSpinnerItemSelection(spinnerB);

    }

    //Save state instance here
    @Override
    public void onSaveInstanceState(Bundle saveState) {
        saveState.putInt(STATE_SCORE_A, scoreA);
        saveState.putInt(STATE_SCORE_B, scoreB);
        saveState.putBoolean(STATE_LAWLER, lawlersLaw);
        super.onSaveInstanceState(saveState);
    }

    //Restore instance here
    public void onRestoreInstanceState(Bundle restoreState) {
        super.onRestoreInstanceState(restoreState);
        scoreA = restoreState.getInt(STATE_SCORE_A);
        scoreB = restoreState.getInt(STATE_SCORE_B);
        lawlersLaw = restoreState.getBoolean(STATE_LAWLER);
        displayScore(scoreA, scoreViewA);
        displayScore(scoreB, scoreViewB);
    }

    //The following two methods update the scores for each team.
    public void updateScoreA(View btn) {
        scoreA += Integer.parseInt(btn.getTag().toString());
        displayScore(scoreA, scoreViewA);
        checkScoreForLawlersLaw();
    }

    public void updateScoreB(View btn) {
        scoreB += Integer.parseInt(btn.getTag().toString());
        displayScore(scoreB, scoreViewB);
        checkScoreForLawlersLaw();

    }

    //Displays the given score for a given team.
    private void displayScore(int score, TextView scoreView) {
        scoreView.setText(String.valueOf(score));
    }

    //Reset the scores to 0
    public void resetScores(View resetBtn) {
        scoreA = 0;
        scoreB = 0;
        lawlersLaw = false;
        displayScore(scoreA, scoreViewA);
        displayScore(scoreB, scoreViewB);
    }

    //A quick method to check if Lawler's Law has been met, displaying it to the user if it has.
    private void checkScoreForLawlersLaw() {
        if ((scoreA >= 100 || scoreB >= 100) && !lawlersLaw) {
            Toast.makeText(MainActivity.this, getString(R.string.lawlers_law), Toast.LENGTH_SHORT).show();
            lawlersLaw = true;
        }
    }

    //Add teams to spinners
    private void addToSpinner(Spinner spin, String[] list) {

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(dataAdapter);
    }

    //Get the selected dropdown list value
    private void addListenerOnSpinnerItemSelection(Spinner spin) {
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setTeamLogos();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Nothing necessary here.
            }
        });
    }

    //Set the logo based on the selected item in the dropdown menu
    private void setTeamLogos() {
        logoA.setImageResource(teamLogos[spinnerA.getSelectedItemPosition()]);
        logoB.setImageResource(teamLogos[spinnerB.getSelectedItemPosition()]);
    }

    //Array of references to drawable team logos
    private final Integer[] teamLogos = {
            R.drawable.logo1, R.drawable.logo2, R.drawable.logo3, R.drawable.logo4,
            R.drawable.logo5, R.drawable.logo6, R.drawable.logo7, R.drawable.logo8,
            R.drawable.logo9, R.drawable.logo10, R.drawable.logo11, R.drawable.logo12,
            R.drawable.logo13, R.drawable.logo14, R.drawable.logo15, R.drawable.logo16,
            R.drawable.logo17, R.drawable.logo18, R.drawable.logo19, R.drawable.logo20,
            R.drawable.logo21, R.drawable.logo22, R.drawable.logo23, R.drawable.logo24,
            R.drawable.logo25, R.drawable.logo26, R.drawable.logo27, R.drawable.logo28,
            R.drawable.logo29, R.drawable.logo30
    };
}



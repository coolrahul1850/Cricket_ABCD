//Author Rahul
package com.example.cricket_abcd;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class Team_Select extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team__select);

        // Retriving team information 
        Intent i = getIntent();
        TextView yourTeam= (TextView) findViewById(R.id.yourTeam) ;
        yourTeam.setText(i.getStringExtra("yourteam"));
        TextView opponentTeam = (TextView) findViewById(R.id.opponentTeam);
        opponentTeam.setText(i.getStringExtra("opponentteam"));
        
        
        // If both teams are valid making sure toss button is available
        if (i.getIntExtra("flag", 0) == 1)
        {
        	View toss = findViewById (R.id.toss);
        	toss.setVisibility(View.VISIBLE);
        	
        }
          
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_team__select, menu);
        return true;
    }

    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void listTeam (View view)
    {
    	//Button clicks starts new intent
    	Intent intent = new Intent (this, ListofTeams.class);
    	startActivity(intent);
    }

	
	  public void tossresult (View view)
	    {
		  	//Toss results starts new activity
	    	Intent intent = new Intent (this, Batting.class);
	    	startActivity(intent);
	    }

}

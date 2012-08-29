//Author Rahul
package com.example.cricket_abcd;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class Team_Select extends Activity {
	
	static public int whichPlayer = 0;
	static public int selectedOvers =0;
    static public int wickets =0;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // Retriving team information 
    	   super.onCreate(savedInstanceState);
    	   setContentView(R.layout.activity_team__select);
    	  	  
    	   
        if (whichPlayer ==1 || whichPlayer == 2)
         	RetrieveTeamInfo();
        
		        
     }

    private void RetrieveTeamInfo() {
		// TODO Auto-generated method stub
    	  Intent i = getIntent();
    	 
          
    	  if (whichPlayer == 1)
    	  {
    		  TextView yourTeam= (TextView) findViewById(R.id.yourTeam) ;
    		  yourTeam.setText(i.getStringExtra("yourteam"));
    	  }
    	
    	  	    	  
          if (whichPlayer == 2)
          {
        	  TextView opponentTeam = (TextView) findViewById(R.id.opponentTeam);
        	  opponentTeam.setText(i.getStringExtra("opponentteam"));
          }
        
          
         
          // If both teams are valid making sure toss button is available
      
          	if (whichPlayer == 2 || whichPlayer == 1)
          {
          	View toss = findViewById (R.id.toss);
          	toss.setVisibility(View.VISIBLE);
          	 //Checking whether the hongkong was selected or not
     	           	
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
     	Intent intent = new Intent (this, ListofTeams.class);
     	//Button clicks starts new intent
    	if (view.getId() == R.id.yourTeam)
    		whichPlayer = 1;
    	else if (view.getId() == R.id.opponentTeam)
    		whichPlayer = 2;
    		
    	startActivity(intent);
       	
    }

	
	  public void tossresult (View view)
	    {
		  	//Toss results starts new activity
		  	final CharSequence[] overs = {"1 i.e 6 balls","3 i.e 18 balls","5 i.e 30 balls"};
		  	AlertDialog.Builder alert = new AlertDialog.Builder(Team_Select.this);
		  	alert.setTitle("Select Number of Overs");
		  	alert.setSingleChoiceItems(overs, -1, new DialogInterface.OnClickListener()
		    {
		        public void onClick(DialogInterface dialog, int which) 
		        {
		        
					if(overs[which]=="1 i.e 6 balls")
					{
		                selectedOvers =6;
		                wickets = 3;
		            }
		            else if (overs[which]=="3 i.e 18 balls")
		            {
		                selectedOvers =18;
		                wickets = 5;
		            }
		            else if (overs[which]=="5 i.e 30 balls")
		            {
		            	selectedOvers= 30;
		            	wickets = 7;
		         
		            }
		        }
		    });
		  	alert.setPositiveButton("Play", new DialogInterface.OnClickListener() {
				
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
					Intent intent = new Intent (Team_Select.this,Batting.class);
					intent.putExtra("selectedOvers", selectedOvers);
					intent.putExtra("wickets", wickets);
					startActivity(intent);
					
				
				}
			});
		  			
		  	alert.show();
		  	
	 
	    }

}

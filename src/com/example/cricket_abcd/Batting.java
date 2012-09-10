package com.example.cricket_abcd;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class Batting extends Activity {

	static public int ballsRemaining = 0;
	static public int score = 0;
	static public int numOvers = 0;
	static public int wickets = 0;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batting);
        Intent i = getIntent();
        ballsRemaining  = i.getIntExtra("selectedOvers", 0);
        numOvers = ballsRemaining;
        
        wickets = i.getIntExtra("wickets", 0);
        
        //Defining the table and grid here        
        GridView gridview = (GridView) findViewById(R.id.gridview);
        final TextView remainingballs = (TextView) findViewById(R.id.remainingballs);
        remainingballs.setText(String.valueOf(ballsRemaining));
    
        final TextView Score = (TextView) findViewById(R.id.score);
        Score.setText(String.valueOf(score));
      
        final TextView Wickets = (TextView) findViewById(R.id.wickets);
        Wickets.setText(String.valueOf(wickets));
        
        final TextView CurrentBowl = (TextView) findViewById(R.id.oppBowl);
        gridview.setAdapter(new ImageAdapter(this));
        gridview.setOnItemClickListener(new OnItemClickListener() {
      
        	
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
       //        Toast.makeText(Batting.this, "" + position, Toast.LENGTH_SHORT).show();
            
            	if (MainMenu.hongKong == 1)
            	{
                	String Currentbowl;
            		int currentBowl =0;
                	Random r = new Random();
                	currentBowl = r.nextInt(2);
                	Currentbowl = getBowl(currentBowl);
                	CurrentBowl.setText(Currentbowl);
                	int i=0;
                	ballsRemaining = ballsRemaining - 1;
                	if (ballsRemaining > 0)
                	{
                		remainingballs.setText(String.valueOf(ballsRemaining));
                		i = Math.abs(currentBowl - position);
                		if (currentBowl == position)
                		{
                			wickets = wickets - 1;
                			Wickets.setText(String.valueOf(wickets));
                			if (wickets ==0)
                			{
                				AlertDialog.Builder adb = new AlertDialog.Builder(Batting.this);
                        		adb.setTitle("Batting over");
                        		adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            					
            					public void onClick(DialogInterface dialog, int which) {
            						// TODO Auto-generated method stub
            						Intent intent = new Intent (Batting.this, Bowling.class);
            						intent.putExtra("scoreToBeat", score);
            						intent.putExtra("numOvers", numOvers);
            					   	startActivity(intent);
            					}
            				});
              					
              				adb.show(); 
                			}
                			AlertDialog.Builder adb = new AlertDialog.Builder(Batting.this);
                			adb.setTitle("You are OUT!!!");
                			adb.setPositiveButton("Ok", null);
                			adb.show();
                		}
                		
                		if (i==1)
                			i=6;
                		
                	 score = score + i;
                	 Score.setText(String.valueOf(score));
                  }
                	else 
                	{
                		AlertDialog.Builder adb = new AlertDialog.Builder(Batting.this);
                		adb.setTitle("Batting over");
                		adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
    					
    					public void onClick(DialogInterface dialog, int which) {
    						// TODO Auto-generated method stub
    						Intent intent = new Intent (Batting.this, Bowling.class);
    						intent.putExtra("scoreToBeat", score);
    						intent.putExtra("numOvers", numOvers);
    					   	startActivity(intent);
    					}
    				});
      					
      				adb.show(); 
      			
                  }
                  
            	}
            	else if (MainMenu.hongKong == 0)
            	{
                	int currentBowl =0;
                	String Currentbowl =null;
                	Random r = new Random();
                	currentBowl = r.nextInt(7);
                	Currentbowl = getBowl(currentBowl);
                	CurrentBowl.setText(Currentbowl);
                	int i=0;
                	ballsRemaining = ballsRemaining - 1;
                	if (ballsRemaining > 0)
                	{
                		remainingballs.setText(String.valueOf(ballsRemaining));
                		i = Math.abs(currentBowl - position);
                		if (currentBowl == position)
                		{
                			wickets = wickets - 1;
                			Wickets.setText(String.valueOf(wickets));
                			if (wickets ==0)
                			{
                				AlertDialog.Builder adb = new AlertDialog.Builder(Batting.this);
                        		adb.setTitle("Batting over");
                        		adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            					
            					public void onClick(DialogInterface dialog, int which) {
            						// TODO Auto-generated method stub
            						Intent intent = new Intent (Batting.this, Bowling.class);
            						intent.putExtra("scoreToBeat", score);
            						intent.putExtra("numOvers", numOvers);
            					   	startActivity(intent);
            					}
            				});
              					
              				adb.show(); 
                			}
                			
                			
                			AlertDialog.Builder adb = new AlertDialog.Builder(Batting.this);
                			adb.setTitle("You are OUT!!!");
                			adb.setPositiveButton("Ok", null);
                			adb.show();
                		}
                		
                	 score = score + i;
                	 Score.setText(String.valueOf(score));
                  }
                	else 
                	{
                		AlertDialog.Builder adb = new AlertDialog.Builder(Batting.this);
                		adb.setTitle("Batting over");
                		adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
    					
    					public void onClick(DialogInterface dialog, int which) {
    						// TODO Auto-generated method stub
    						Intent intent = new Intent (Batting.this, Bowling.class);
    						intent.putExtra("scoreToBeat", score);
    						intent.putExtra("numOvers", numOvers);
    					   	startActivity(intent);
    					}
    				});
      					
      				adb.show(); 
      			
                  }
                  
            	}

          }

			private String getBowl(int currentBowl) {
				// TODO Auto-generated method stub
				String bowl = null;
				switch (currentBowl)
				{
				case 0:
					bowl = "A";
					break;
				case 1:
					bowl = "B";
					break;
				case 2:
					bowl = "C";
					break;
				case 3:
					bowl = "D";
					break;
				case 4:
					bowl = "E";
					break;
				case 5:
					bowl = "F";
					break;
				case 6:
					bowl = "G";
					break;
				}
				return bowl;
			}
        });
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_batting, menu);
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

	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return null;
	}

}

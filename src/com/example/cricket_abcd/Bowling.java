package com.example.cricket_abcd;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

public class Bowling extends Activity {

	static public int ballsRemaining = 0;
	static public int score =0;
	static public int i1 =0;
	static public int wickets = 0;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batting);
        Intent i = getIntent();
        ballsRemaining = i.getIntExtra("numOvers", 0);
        if (ballsRemaining ==6)
        	wickets = 3;
        if (ballsRemaining == 18)
        	wickets = 5;
        if (ballsRemaining == 30)
        	wickets = 7;
        
        
        
        //Defining the table and grid here        
        GridView gridview = (GridView) findViewById(R.id.gridview);
        final TextView remainingballs = (TextView) findViewById(R.id.remainingballs);
        remainingballs.setText(String.valueOf(ballsRemaining));
        
        final TextView Wickets = (TextView) findViewById(R.id.wickets);
        Wickets.setText(String.valueOf(wickets));
        
        final TextView Score = (TextView) findViewById(R.id.score);
        score = i.getIntExtra("scoreToBeat", 0);
        Score.setText(String.valueOf(score));
        
        
        final TextView CurrentBowl = (TextView) findViewById(R.id.oppBowl);
        gridview.setAdapter(new ImageAdapter(this));
        
        gridview.setOnItemClickListener(new OnItemClickListener() {
      
        	
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
       //        Toast.makeText(Batting.this, "" + position, Toast.LENGTH_SHORT).show();
            
            	if (MainMenu.hongKong == 1)
            	{
                 	int currentBowl =0;
                	Random r = new Random();
                	currentBowl = r.nextInt(2);
                	CurrentBowl.setText(String.valueOf(currentBowl));
                	int i=0;
                	ballsRemaining = ballsRemaining - 1;
                	if (ballsRemaining > 0)
                	{
                		remainingballs.setText(String.valueOf(ballsRemaining));
                		i = Math.abs(currentBowl - position);
                		if (i ==1)
                			i = 6;
                		if (currentBowl == position)
                		{
                			wickets = wickets - 1;
                			if (wickets == 0)
                			{
                				AlertDialog.Builder adb = new AlertDialog.Builder(Bowling.this);
                         		adb.setTitle("Nice job! Bowled out opposition. YOU WIN!!!");
                         		adb.show();
                			}
                			AlertDialog.Builder adb = new AlertDialog.Builder(Bowling.this);
                			Wickets.setText(String.valueOf(wickets));
                			adb.setTitle("Good Ball, you got one wicket");
                			adb.setPositiveButton("Ok", null);
                			adb.show();
                		}
                		
                	 score = score - i;
                	 if (score <= 0)
                	 {
                		 //add win method
                		AlertDialog.Builder adb = new AlertDialog.Builder(Bowling.this);
                 		adb.setTitle("You Lost");
                 		adb.show();
                	 }
                	 Score.setText(String.valueOf(score));
                  }
                	else 
                	{
                		AlertDialog.Builder adb = new AlertDialog.Builder(Bowling.this);
                		adb.setTitle("You win");
                		adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
    					
    					public void onClick(DialogInterface dialog, int which) {
    						// TODO Auto-generated method stub
    		//				Intent intent = new Intent (Batting.this, Bowling.class);
    		//				intent.putExtra("scoreToBeat", score);
      		//		    	startActivity(intent);
    					}
    				});
      					
      				adb.show(); 
      			
                  }
            	}
       
              	if (MainMenu.hongKong == 0)
            	{
                 	int currentBowl =0;
                	Random r = new Random();
                	currentBowl = r.nextInt(6);
                	CurrentBowl.setText(String.valueOf(currentBowl));
                	int i=0;
                	ballsRemaining = ballsRemaining - 1;
                	if (ballsRemaining > 0)
                	{
                		remainingballs.setText(String.valueOf(ballsRemaining));
                		i = Math.abs(currentBowl - position);
                		if (currentBowl == position)
                		{
                			wickets = wickets - 1;
                			if (wickets == 0)
                			{
                				AlertDialog.Builder adb = new AlertDialog.Builder(Bowling.this);
                         		adb.setTitle("Nice job! Bowled out opposition. YOU WIN!!!");
                         		adb.show();
                			}
                			AlertDialog.Builder adb = new AlertDialog.Builder(Bowling.this);
                			Wickets.setText(String.valueOf(wickets));
                			adb.setTitle("Good Ball, you got one wicket");
                			adb.setPositiveButton("Ok", null);
                			adb.show();
                		}
                		
                	 score = score - i;
                	 if (score <= 0)
                	 {
                		 //add win method
                		AlertDialog.Builder adb = new AlertDialog.Builder(Bowling.this);
                 		adb.setTitle("You Lost");
                 		adb.show();
                	 }
                	 Score.setText(String.valueOf(score));
                  }
                	else 
                	{
                		AlertDialog.Builder adb = new AlertDialog.Builder(Bowling.this);
                		adb.setTitle("You win");
                		adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
    					
    					public void onClick(DialogInterface dialog, int which) {
    						// TODO Auto-generated method stub
    		//				Intent intent = new Intent (Batting.this, Bowling.class);
    		//				intent.putExtra("scoreToBeat", score);
      		//		    	startActivity(intent);
    					}
    				});
      					
      				adb.show(); 
      			
                  }
            	}
          }
        });
        
        
        
    }
    
}

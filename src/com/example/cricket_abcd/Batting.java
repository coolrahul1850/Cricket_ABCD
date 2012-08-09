package com.example.cricket_abcd;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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

	static public int ballsRemaining = 6;
	static public int score = 0;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batting);
        GridView gridview = (GridView) findViewById(R.id.gridview);
        final TextView remainingballs = (TextView) findViewById(R.id.remainingballs);
        remainingballs.setText(String.valueOf(ballsRemaining));
    
        final TextView Score = (TextView) findViewById(R.id.score);
        Score.setText(String.valueOf(score));
 
        gridview.setAdapter(new ImageAdapter(this));
        
        gridview.setOnItemClickListener(new OnItemClickListener() {
        
        	
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
               Toast.makeText(Batting.this, "" + position, Toast.LENGTH_SHORT).show();
            
              int currentBowl =0;
              Random r = new Random();
              currentBowl = r.nextInt(6);
              int i=0;
            	
              ballsRemaining = ballsRemaining - 1;
              if (ballsRemaining > 0)
              {
            	  remainingballs.setText(String.valueOf(ballsRemaining));
            	  i = Math.abs(currentBowl - position);
            	 if ((currentBowl-position) == 0)
            	  {
                  	AlertDialog.Builder adb = new AlertDialog.Builder(Batting.this);
      				adb.setTitle("You are OUT!!!");
      				adb.setPositiveButton("Ok", null);
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
  				    	startActivity(intent);
					}
				});
  					
  						adb.show(); 
  			
              }
              
            
                
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

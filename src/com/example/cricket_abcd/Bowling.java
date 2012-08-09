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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bowling);
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));
        Intent i = getIntent();
        TextView beat = (TextView) findViewById(R.id.tobeat);
        int i1 = 0;
        i1 = i.getIntExtra("scoreToBeat", 0);
        beat.setText(String.valueOf(i1));
       
        
        gridview.setOnItemClickListener(new OnItemClickListener() {
        
        	
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
          //      Toast.makeText(Batting.this, "" + position, Toast.LENGTH_SHORT).show();
            
      /*        int currentBowl =0;
              Random r = new Random();
              currentBowl = r.nextInt(6);
              int i=0;
            	
              ballsRemaining = ballsRemaining - 1;
              if (ballsRemaining > 0)
              {
            	  edittext.setText(String.valueOf(ballsRemaining));
            	  i = Math.abs(currentBowl - position);
            	  if (i== 0)
            	  {
                  	AlertDialog.Builder adb = new AlertDialog.Builder(Batting.this);
      				adb.setTitle("You are OUT!!!");
      				adb.setPositiveButton("Ok", null);
            	  }
            		
            	  score = score + i;
            	  edittext1.setText(String.valueOf(score));
            	 
            	  
              }
              else 
              {
            	AlertDialog.Builder adb = new AlertDialog.Builder(Batting.this);
  				adb.setTitle("Batting over");
  				adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Intent intent = new Intent (Batting.this, Bowling.class);
  				    	startActivity(intent);
					}
				});
  					
  						adb.show(); 
  			
              }
              
            /*/
                
            }
        });
        
        
        
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_bowling, menu);
        return true;
    }
}

// Author Rahul

package com.example.cricket_abcd;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;

public class MainMenu extends Activity {

public static int hongKong = 0;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        
        //gridview for images
        GridView gridview = (GridView) findViewById(R.id.gridview1);
       gridview.setAdapter(new ImageAdapter(this));
     
           gridview.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				// TODO Auto-generated method stub
				if (position ==0)
					MainMenu.this.startActivity(new Intent(MainMenu.this,Team_Select.class));
				else if (position==1)
				{
					hongKong = 1;
					Intent intent = new Intent(MainMenu.this, Team_Select.class);
					intent.putExtra("hongKong", hongKong );
					MainMenu.this.startActivity(intent);
				}
					
				else if (position == 2)
					MainMenu.this.startActivity(new Intent(MainMenu.this, HelpRules.class));
			}
        	
        });
        
      
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_menu, menu);
        return true;
    }
    
    
    public void teamSelect (View view)
    {
    	// Starts the new activity Team Select
    	Intent intent = new Intent (this, Team_Select.class);
    	startActivity(intent);
    }
    
}

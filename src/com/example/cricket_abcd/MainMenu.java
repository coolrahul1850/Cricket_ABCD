// Author Rahul

package com.example.cricket_abcd;




import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainMenu extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
      
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

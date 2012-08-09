//Author Rahul
package com.example.cricket_abcd;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v4.app.NavUtils;

public class ListofTeams extends ListActivity {

	static final String [] Teams = new String [] 
			{
				"Australia ", "Bangladesh" , "England", "India", "New Zeland", "Pakistan","South Africa","Sri Lanka","West Indies","Zimbabwe"
			};
	
    @Override
   public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      
        
        //setting up the list
        ArrayAdapter<String> a1 = new ArrayAdapter<String>(this, R.layout.activity_listof_teams, Teams);
        setListAdapter(a1);
        final ListView list = getListView();
        list.setTextFilterEnabled(true);
        list.setOnItemClickListener(new OnItemClickListener(){

			public void onItemClick(AdapterView<?> a1, View myView, int myItemint,
					long mylng) {
				// TODO Auto-generated method stub
		/*		AlertDialog.Builder adb = new AlertDialog.Builder(ListofTeams.this);
				adb.setTitle("ListView OnClick");
				adb.setMessage("Selected Item is = "+ list.getItemAtPosition(myItemint));
						adb.setPositiveButton("Ok", null);
						adb.show(); */
				
				
				//Selecting a team routes back to team select screen with your choice
				Intent intent = new Intent (ListofTeams.this, Team_Select.class);
				String team1 = list.getItemAtPosition(myItemint).toString();
				int flag = 1;
				
				intent.putExtra("yourteam", team1);
				intent.putExtra("opponentteam", team1);
				intent.putExtra("flag", flag);
				startActivity(intent);
			}
        	
        });
        
    }



	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_listof_teams, menu);
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

}

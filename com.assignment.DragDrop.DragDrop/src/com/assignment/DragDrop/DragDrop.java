package com.assignment.DragDrop;



//import com.assignment.ekey2.DrawView;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class  DragDrop extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // draw the view
        setContentView(new DrawView(this));
        
    }
    
    //jl added below from original eKeyAndroid project. also added menu\activity_main.xml and view.menu import
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	super.onCreateOptionsMenu(menu);
    	
    	MenuItem item = menu.add("Add");
    	item = menu.add("Edit");
    	getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
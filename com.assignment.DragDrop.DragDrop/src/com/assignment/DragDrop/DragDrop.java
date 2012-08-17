package com.assignment.DragDrop;



//import com.assignment.ekey2.DrawView;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public class  DragDrop extends Activity {
    private static final CharSequence Options = null;

	private MenuItem item;

    private final int ID_MENU_SETTING = 1;
    
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
    	//menu.add("Options");
    
    	//item = menu.add("Setting");
    	//item = menu.add("Edit");
    	getMenuInflater().inflate(R.menu.activity_main, menu);
    	
    	
    	//Get a submenu reference
    	SubMenu sm = menu.addSubMenu("Options");
    	sm.add("Add");
    	sm.add("Remove");
    	sm.add("Save");
    	sm.add("Load");
    	
    	MenuItem item = menu.add(Menu.NONE, ID_MENU_SETTING,Menu.NONE,Options);
    	menu.add("Restart");
    	
    	return true;
    }

	}
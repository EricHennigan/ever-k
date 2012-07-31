package com.assignment.DragDrop;

import android.app.Activity;
import android.os.Bundle;

public class  DragDrop extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // draw the view
        setContentView(new DrawView(this));
        
        
    }
    
}
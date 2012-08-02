package com.assignment.DragDrop;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;

public class DrawView extends View {
   private ColorBall[] colorballs = new ColorBall[8]; // array that holds the balls
   private int balID = 0; // variable to know what ball is being dragged
    
    public DrawView(Context context) {
        super(context);
        setFocusable(true); //necessary for getting the touch events
        
        // setting the start point for the balls
        Point point1 = new Point();
        point1.x = 550;
        point1.y = 580;
        Point point2 = new Point();
        point2.x = 500;
        point2.y = 580;
        Point point3 = new Point();
        point3.x = 320;
        point3.y = 500;
        Point point4 = new Point();
        point4.x = 120;
        point4.y = 200;
        Point point5 = new Point();
        point5.x = 220;
        point5.y = 220;
        Point point6 = new Point();
        point6.x = 320;
        point6.y = 200;
        Point point7 = new Point();
        point7.x = 420;
        point7.y = 220;
        Point point8 = new Point();
        point8.x = 570;
        point8.y = 200;
        
        //jl overlapping objects stack based on this order             
        // declare each ball with the ColorBall class
        colorballs[0] = new ColorBall(context,R.drawable.bol_groen, point1, 25);
        colorballs[1] = new ColorBall(context,R.drawable.bol_groen, point2, 25);
        colorballs[2] = new ColorBall(context,R.drawable.eric_face, point3, 100);
        colorballs[3] = new ColorBall(context,R.drawable.letter_e, point4, 60);
        colorballs[4] = new ColorBall(context,R.drawable.letter_v, point5, 60);
        colorballs[5] = new ColorBall(context,R.drawable.letter_e, point6, 60);
        colorballs[6] = new ColorBall(context,R.drawable.letter_r, point7, 60);
        colorballs[7] = new ColorBall(context,R.drawable.letter_k, point8, 60);
        //colorballs[1] = new ColorBall(context,R.drawable.bol_rood, point2);
        //colorballs[2] = new ColorBall(context,R.drawable.bol_blauw, point3);
        
        
    }
    
    // the method that draws the balls
    @Override protected void onDraw(Canvas canvas) {
        //canvas.drawColor(0xFFCCCCCC);     //if you want another background color       
        
    	//draw the balls on the canvas
    	
//    	for (ColorBall ball : colorballs) {
//            canvas.drawBitmap(ball.getBitmap(), ball.getX(), ball.getY(), null);
//          }
    	//jl transverse in reverse so objects on top move first when multiple objects are overlapping
    	for (int i=7; i>=0; i--) {
    		
    		  canvas.drawBitmap(colorballs[i].getBitmap(), colorballs[i].getX(), colorballs[i].getY(), null);
    		}

    }
    
    // events when touching the screen
    public boolean onTouchEvent(MotionEvent event) {
        int eventaction = event.getAction(); 
        
        int X = (int)event.getX(); 
        int Y = (int)event.getY(); 

        switch (eventaction ) { 

        case MotionEvent.ACTION_DOWN: // touch down so check if the finger is on a ball
        	balID = 0;
        	for (ColorBall ball : colorballs) {
        		// check if inside the bounds of the ball (circle)
        		// get the center for the ball
        		int centerX = ball.getX() + ball.getRadius();
        		int centerY = ball.getY() + ball.getRadius();
        		
        		// calculate the radius from the touch to the center of the ball
        		double radCircle  = Math.sqrt( (double) (((centerX-X)*(centerX-X)) + (centerY-Y)*(centerY-Y)));
        		
        		// if the radius is smaller then 23 (radius of a ball is 22), then it must be on the ball
        		if (radCircle < ball.getRadius()){
        			balID = ball.getID();
                    break;
        		}

        		// check all the bounds of the ball (square)
        		//if (X > ball.getX() && X < ball.getX()+50 && Y > ball.getY() && Y < ball.getY()+50){
                //	balID = ball.getID();
                //	break;
                //}
              }
             
             break; 


        case MotionEvent.ACTION_MOVE:   // touch drag with the ball
        	// move the balls the same as the finger
            if (balID > 0) {
            	colorballs[balID-1].setX(X-colorballs[balID-1].getRadius());
            	colorballs[balID-1].setY(Y-colorballs[balID-1].getRadius());
            }
        	
            break; 

        case MotionEvent.ACTION_UP: 
       		// touch drop - just do things here after dropping

             break; 
        } 
        // redraw the canvas
        invalidate(); 
        return true; 
	
    }
}

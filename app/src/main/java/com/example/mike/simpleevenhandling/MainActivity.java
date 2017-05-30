package com.example.mike.simpleevenhandling;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//there is a listener that activates when the button is clicked
//and there is a callback method which tells the interface to change something (textview)

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    //This is a button for the button in the app
    private Button myButton = null;
    //this textView changes when gestures happen
    private TextView mytextView = null;
    //this is the detector that detects the gestures made by the user
    private GestureDetectorCompat gestureDetector = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connects the button and textView to xml
        myButton = (Button)findViewById(R.id.clickable_button);
        mytextView = (TextView)findViewById(R.id.display);
        //This sets the detector to this
        this.gestureDetector = new GestureDetectorCompat(this, this);
        //sets the listener to listen specifically to this
        gestureDetector.setOnDoubleTapListener(this);

        //sets up the listener          //sets up the callback
        myButton.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                mytextView.setText("good job hoss");
            }
        });

        //finger is on button for longer than a second(holding it down)
        myButton.setOnLongClickListener(new Button.OnLongClickListener(){
            public boolean onLongClick(View v){
                mytextView.setText("holy carp that was a long one");
                //needs return to tell androdi to tell android the click was handled
                //if event is not seen as handled it would pass it along
                //for example could be passed to the onclick listener
                return true;
                //if false is returned the event only happens while you are holding
                //down the button
            }
        });
    }

    //These methods react to the gestures and put the text of what is happening on screen
    /////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        mytextView.setText("onFling");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        mytextView.setText("onLongPress");
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        mytextView.setText("onScroll");
        return true;
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        mytextView.setText("onSingleTapUp");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        mytextView.setText("onShowPress");
    }

    @Override
    public boolean onDown(MotionEvent e) {
        mytextView.setText("onDown");
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        mytextView.setText("onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        mytextView.setText("onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        mytextView.setText("onDoubleTapEvent");
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    //End of these methods
    ///////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
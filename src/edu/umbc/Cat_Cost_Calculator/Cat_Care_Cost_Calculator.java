package edu.umbc.Cat_Cost_Calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Cat_Care_Cost_Calculator extends Activity {

    private int splashTime = 5000; // five seconds

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cat_splash);

        // create a new rotate animation for the image
        Animation anim = AnimationUtils.loadAnimation(this.getBaseContext(), R.anim.rotate_picture);

        // get the text view for splash page
        final TextView splash = (TextView) findViewById(R.id.txtTitle);
        // start the animation
        splash.startAnimation(anim);

        // create timertask for redirecting to home page
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                finish(); // end current activity
                startActivity(new Intent(Cat_Care_Cost_Calculator.this, MainMenu.class)); // go to the homepage
            }
        };

        // create timer
        Timer opening = new Timer();
        // schedule task
        opening.schedule(task, splashTime);
    }

}
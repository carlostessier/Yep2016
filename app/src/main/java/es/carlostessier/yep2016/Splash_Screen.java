package es.carlostessier.yep2016;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;

import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/**
 * Created by ernesto on 29/01/16.
 * @version 0.1
 */

public class Splash_Screen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        TextView myTitle = (TextView)findViewById(R.id.textView3);
        TextView mySubtitle = (TextView)findViewById(R.id.textView4);
        Typeface myFont = Typeface.createFromAsset(getAssets(), "fonts/SensaBrush-FillDemo.otf");
        myTitle.setTypeface(myFont);
        mySubtitle.setTypeface(myFont);


        Animation shake = AnimationUtils.loadAnimation(this, R.anim.grow_disappear_animation);

        mySubtitle.startAnimation(shake);
        openApp(true);
    }


    private void openApp(boolean locationPermission) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash_Screen
                        .this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }

}

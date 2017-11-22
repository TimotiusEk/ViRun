package com.example.timotiusek.runcompanionvr.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.timotiusek.runcompanionvr.R;

public class EventListActivity extends AppCompatActivity {
private ImageView octfestImg;
    private ImageView christmasImg;
    private ImageView halloweenImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);
        octfestImg = (ImageView) findViewById(R.id.oktfest_pic);
//        animateOnTouch(octfestImg, R.drawable.octfest_unclicked, R.drawable.octfest_clicked);

        christmasImg = (ImageView) findViewById(R.id.christmas_pic);
//        animateOnTouch(christmasImg, R.drawable.christmas_unclicked_2, R.drawable.christmas_clicked_2);

        halloweenImg = (ImageView) findViewById(R.id.halloween_pic);
        final Intent i = new Intent(EventListActivity.this, EventDetailActivity.class);
        octfestImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("whichEvent", "octfest");
                startActivity(i);
            }
        });

        christmasImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("whichEvent", "christmas");
                startActivity(i);
            }
        });

        halloweenImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("whichEvent", "halloween");
                startActivity(i);
            }
        });
        getSupportActionBar().setTitle("Event List");
    }

    public void animateOnTouch(final ImageView imageToAnimate, final int drawableUnclicked, final int drawableClicked){
        imageToAnimate.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    imageToAnimate.setImageResource(drawableClicked);
                } else if(event.getAction() == MotionEvent.ACTION_UP){
                    imageToAnimate.setImageResource(drawableUnclicked);
                }
                return true;
            }
        });
    }
}

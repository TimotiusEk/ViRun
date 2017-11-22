package com.example.timotiusek.runcompanionvr.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.timotiusek.runcompanionvr.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventDetailActivity extends AppCompatActivity {

    @BindView(R.id.event_layout)
    LinearLayout eventLayout;

    @BindView(R.id.event)
    TextView event;

    @BindView(R.id.event_organizer)
    TextView eventOrganizer;

    @BindView(R.id.event_date)
    TextView eventDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
        ButterKnife.bind(this);

        String dateString = "22/11/2017 12:00";

        String whichEvent = getIntent().getStringExtra("whichEvent");
        if(whichEvent.equals("christmas")){
            eventLayout.setBackground(getResources().getDrawable(R.drawable.christmas_bg));
            event.setText("Christmas");
            eventOrganizer.setText("Mall Alam Sutera");
            eventDate.setText("Date: 21 December 2017");
            dateString = "21/12/2017";
        } else if(whichEvent.equals("halloween")){
            eventLayout.setBackground(getResources().getDrawable(R.drawable.halloween_bg));
            event.setText("Halloween");
            eventOrganizer.setText("Mall Alam Sutera");
            eventDate.setText("Date: 20 Oktober 2017");
            dateString = "20/10/2017";
        } else{
            eventLayout.setBackground(getResources().getDrawable(R.drawable.octfest_bg));
            event.setText("Oktoberfest");
            eventOrganizer.setText("SGU");
            eventDate.setText("Date: 25 Oktober 2017");
            dateString = "25/10/2017";
        }
        eventLayout.getBackground().setAlpha(180);

        if(isEventStarted(dateString)){
            finish();
            startActivity(new Intent(this, ARActivity.class));
        }
    }

    public boolean isEventStarted(String dateString){
        Calendar c = Calendar.getInstance();

        Date currentDate = c.getTime();

        String startDateString = dateString + " 08:00";
        String finishDateString = dateString + " 23:00";

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        try {
            Date startDate = df.parse(startDateString);
            Date finishDate = df.parse(finishDateString);
            if(startDate.compareTo(currentDate) < 0 && finishDate.compareTo(currentDate) > 0){
                return true;
            } else{
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
}

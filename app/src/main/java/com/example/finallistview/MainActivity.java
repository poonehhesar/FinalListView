package com.example.finallistview;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity<protect> extends AppCompatActivity {
    Button b;
    static MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ExpandableListView expandableListView = findViewById(R.id.expandableListView);

        HashMap<String, List<String>> item = new HashMap<>();

        ArrayList<String> greenGroups = new ArrayList<>();
        greenGroups.add("Apple");
        greenGroups.add("Pear");
        greenGroups.add("Kiwi");

        item.put("Green", greenGroups);

        ArrayList<String> redGroups = new ArrayList<>();
        redGroups.add("Strawberries");
        redGroups.add("Pomegranate");
        redGroups.add("Cherries");
        redGroups.add("Raspberries");

        item.put("Red", redGroups);

        ArrayList<String> yellowGroups = new ArrayList<>();
        yellowGroups.add("Banana");
        yellowGroups.add("Pineapple");
        yellowGroups.add("Mango");

        item.put("Yellow", yellowGroups);

        ArrayList<String> blueGroups = new ArrayList<>();
        blueGroups.add("Blueberries");
        blueGroups.add("Blackberries");
        blueGroups.add("Plum");

        item.put("Blue", blueGroups);

        ListAdapter adapter = new ListAdapter(item);
        expandableListView.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.blip);
        b = (Button)findViewById(R.id.button);
        b.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                startActivity(new Intent(MainActivity.this, Main2Activity.class));

            }
        }));
    }

}

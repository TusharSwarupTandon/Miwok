package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        //Find number textView
//        TextView numbers = findViewById(R.id.numbers);
//
//        // Set a click listener on that View
//        numbers.setOnClickListener(new View.OnClickListener() {
//            // The code in this method will be executed when the numbers category is clicked on.
//            @Override
//            public void onClick(View view)
//            {
//                // Create a new intent to open the {@link NumbersActivity}
//                Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);
//
//                // Start the new activity
//                startActivity(numbersIntent);
//            }
//        });
//
//        //Find Family Members view
//        TextView family = findViewById(R.id.family);
//
//        //set a clickListener on family view
//        family.setOnClickListener(view -> {
//            Intent i = new Intent(MainActivity.this, FamilyActivity.class);
//            startActivity(i);
//        });
//
//        //Find colors textView
//        TextView colors = findViewById(R.id.colors);
//
//        //Set a clickListener on that colors view
//        colors.setOnClickListener(view -> {
//            Intent i = new Intent(MainActivity.this, ColorsActivity.class);
//            startActivity(i);
//        });
//
//        //Find phrases textView
//        TextView phrases = findViewById(R.id.phrases);
//
//        //Set a clickListener on that phrases view
//        phrases.setOnClickListener(view -> {
//            Intent i = new Intent(MainActivity.this, PhrasesActivity.class);
//            startActivity(i);
//        });
//    }
      @Override
      protected void onCreate(Bundle savedInstanceState)
      {
          super.onCreate(savedInstanceState);

          // Set the content of the activity to use the activity_main.xml layout file
          setContentView(R.layout.activity_main);

          // Find the view pager that will allow the user to swipe between fragments
          ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

          // Create an adapter that knows which fragment should be shown on each page
          SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(this, getSupportFragmentManager());

          // Set the adapter onto the view pager
          viewPager.setAdapter(adapter);

          // Give the TabLayout the ViewPager
          TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
          tabLayout.setupWithViewPager(viewPager);
      }
}
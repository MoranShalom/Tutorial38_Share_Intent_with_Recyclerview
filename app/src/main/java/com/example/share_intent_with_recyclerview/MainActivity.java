package com.example.share_intent_with_recyclerview;
/**
 * In this tutorial we will learn how to use Android share intent to share
 * content from the app to other apps. You will build an Android app that
 * uses Recyclerview & Cardview to show a list of beach pictures, with 2 buttons
 * that will allow you to share content and open a URL in a browser.
 *
 * You will be using Android Recyclerview and Cardview, so you have to add these libraries inside the file.
 * For start Open up build.gradle (Module:app) file and add the following code.
 * 1. implementation 'com.android.support:recyclerview-v7:26.1.0'
 * 2. implementation 'com.android.support:cardview-v7:26.1.0'
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;


//Inside MainActivity you need to define Android Toolbar,
// Recyclerview and the real data that will appear later inside Recyclerview.
public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = findViewById(R.id.toolbar);
        //toolbar.setTitle(getResources().getString(R.string.app_name));
        toolbar.setTitle("Israel");
        recyclerView = findViewById(R.id.recyclerView);


        //define the images array, image names array and urls array.
        int[] images = new int[]{R.drawable.telaviv, R.drawable.eilat,
                R.drawable.deadsea, R.drawable.haifa, R.drawable.negev};

        String[] placeNames = new String[]{"TelAviv City", "Eilat city", "DeadSea",
                "haifa city", "Negev"};

        String[] placeGuide = new String[]{

                "https://www.tripadvisor.com/Attractions-g293984-Activities-Tel_Aviv_Tel_Aviv_District.html",
                "https://www.tripadvisor.com.my/Attraction_Review-g477968-d637885-Reviews-Anse_Source_D_Argent" +
                        "-La_Digue_Island.html",
                "https://www.tripadvisor.com.my/Attraction_Review-g609028-d1547522-Reviews-As_Catedrais_Beach-Ribadeo_" +
                        "Province_of_Lugo_Galicia.html",
                "https://www.tripadvisor.com.my/Attraction_Review-g187457-d675885-Reviews-La_Concha_Beach-San_Sebastian" +
                        "_Donostia_Province_of_Guipuzcoa_Basque_Country.html",
                "https://www.tripadvisor.com.my/Attraction_Review-g255060-d257354-Reviews-Bondi_Beach-Sydney_" +
                        "New_South_Wales.html"};

        //Now define LinearLayoutManager and MyAdapter and finally set this adapter to Recyclerview.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        MyAdapter myAdapter = new MyAdapter(MainActivity.this, images, placeNames, placeGuide);
        recyclerView.setAdapter(myAdapter);


    }
}

package com.example.share_intent_with_recyclerview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter <PlaceViewHolder> {

    private Context context;
    private int[] images;   //array to hold the images
    private String[] placeNames; //an array for the name of the images
    private String[] placeGuide;  // array for web urls

    MyAdapter(Context context, int[] images, String[] placeNames, String[] placeGuide) {
        this.context = context;
        this.images = images;
        this.placeNames = placeNames;
        this.placeGuide = placeGuide;
    }


    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // inflate recyclerview_item_row.xml layout inside onCreateViewHolder.
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item_row, parent, false);
        return new PlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PlaceViewHolder holder, int position) {

        // place and placeName inside onBindViewHolder
        holder.placeName.setText(placeNames[position]);
        holder.place.setImageResource(images[position]);


        //inside onBindViewHolder method you need to make the Share button clickable by using Android SetOnClickListener. Once you tap on the button it will allow you to share the name of the beach and a URL
        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Here you first define the type of Android Intent, then you use PutExtra method to pass some data that you want to share, after that you set the share type which is plain text and finally you start the activity with Intent.createChooser.
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, "Let's go for a trip to "
                        + placeNames[holder.getAdapterPosition()] +
                        "\nHere is the link to the full review: " + placeGuide[holder.
                        getAdapterPosition()]);
                intent.setType("text/plain");
                context.startActivity(Intent.createChooser(intent, "Send To"));

            }
        });

        //Visit button. You will use Android SetOnClickListener to make the button clickable, then inside Android OnClick method is where you will write the code for Android open URL intent.
        holder.visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Here you first start with Android Intent by passing the type of intent, then you will need to use Intent.setData to specify the destination by using Uri.parse and getting the correct link from placeGuide array by passing the item position inside Android Recyclerview, and finally you would start the activity.
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(placeGuide[holder.getAdapterPosition()]));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        // Change the return value of (getItemCount()) to
        // the actual size of the images instead of null value.
        return images.length;
    }
}

class PlaceViewHolder extends RecyclerView.ViewHolder {

    ImageView place;
    TextView placeName;
    Button share;
    Button visit;

    PlaceViewHolder(View itemView) {
        super(itemView);


        //define the views which you have created them inside
        // recyclerview_item_row.xml file inside PlaceViewHolder
        place = itemView.findViewById(R.id.ivPlace);
        placeName = itemView.findViewById(R.id.tvPlaceName);
        share = itemView.findViewById(R.id.btnShare);
        visit = itemView.findViewById(R.id.btnVisit);
    }
}
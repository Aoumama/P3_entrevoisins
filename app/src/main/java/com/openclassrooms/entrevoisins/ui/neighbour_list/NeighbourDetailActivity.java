package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;

public class NeighbourDetailActivity extends AppCompatActivity {

    private ImageView returnListNeighbour;

    private String name;
    private TextView nameNeighbourImage;
    private TextView nameNeighbour;

    private String avatarUrl;
    private ImageView profilPicture;

    private String address;
    private TextView addressNeighbour;

    private String number;
    private TextView numberNeighbour;

    private String facebook;
    private TextView facebookNeighbour;

    private String about;
    private TextView aboutNeighbour;


    private FloatingActionButton favorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neighbour_detail);

        returnListNeighbour = findViewById(R.id.activity_neighbour_detail_return);

        returnListNeighbour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NeighbourDetailActivity.this.finish();
            }
        });

        name = getIntent().getStringExtra("name");

        nameNeighbourImage = findViewById(R.id.activity_neighbour_detail_name_image);
        nameNeighbourImage.setText(name);
        nameNeighbour = findViewById(R.id.activity_neighbour_detail_name);
        nameNeighbour.setText(name);

        avatarUrl = getIntent().getStringExtra("avatarUrl");
        profilPicture = findViewById(R.id.activity_neighbour_detail_profil);
        Glide.with(this)
                .load(avatarUrl)
                .into(profilPicture);

        address = getIntent().getStringExtra("address");
        addressNeighbour = findViewById(R.id.activity_neighbour_detail_address);
        addressNeighbour.setText(address);

        number = getIntent().getStringExtra("number");
        numberNeighbour = findViewById(R.id.activity_neighbour_detail_number);
        numberNeighbour.setText(number);

        facebook = getIntent().getStringExtra("facebook");
        facebookNeighbour = findViewById(R.id.activity_neighbour_detail_facebook);
        facebookNeighbour.setText(facebook);

        about = getIntent().getStringExtra("about");
        aboutNeighbour = findViewById(R.id.activity_neighbour_detail_about);
        aboutNeighbour.setText(about);


        favorite = findViewById(R.id.activity_neighbour_detail_favorites);



        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int colorYellow = Color.argb(255, 255,255,0);
                //int colorBlack = Color.argb(0, 0,0,0);

                favorite.setColorFilter(colorYellow);

                Toast.makeText(v.getContext(), name, Toast.LENGTH_SHORT).show();



            }
        });










    }



}

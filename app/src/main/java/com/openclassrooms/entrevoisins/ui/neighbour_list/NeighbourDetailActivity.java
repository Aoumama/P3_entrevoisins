package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.mbms.StreamingServiceInfo;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.service.DummyNeighbourApiService;
import com.openclassrooms.entrevoisins.utils.SharedPreferencesUtils;

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

    private String idNeighbour;

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

        idNeighbour = getIntent().getStringExtra("id");

        favorite = findViewById(R.id.activity_neighbour_detail_favorites);

        if (SharedPreferencesUtils.getBooleanPreference(this, idNeighbour)) {
            favorite.setColorFilter(ContextCompat.getColor(this, R.color.colorYellow));
            favorite.setSelected(true);
        } else {
            favorite.setColorFilter(ContextCompat.getColor(this, R.color.colorBlack));
            favorite.setSelected(false);
        }

        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!favorite.isSelected()) { // si l'étoile pas séléctionné
                    favorite.setColorFilter(ContextCompat.getColor(v.getContext(), R.color.colorYellow)); // colorie jaune
                    favorite.setSelected(true); // et passe a vrai
                    // donc on ajout la clef des preferences
                    SharedPreferencesUtils.setBooleanPreference(v.getContext(), idNeighbour, true);
                } else {
                    favorite.setColorFilter(ContextCompat.getColor(v.getContext(), R.color.colorBlack));
                    favorite.setSelected(false);
                    // supprimer la clef des preferences
                    SharedPreferencesUtils.deletePreference(v.getContext(), idNeighbour);



                }
            }
        });

    }


}

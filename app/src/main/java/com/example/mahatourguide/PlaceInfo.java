package com.example.mahatourguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaceInfo extends AppCompatActivity {

    TextView title,description;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_info);

        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        imageView = findViewById(R.id.img);

        Intent intent = getIntent();

        title.setText(intent.getStringExtra(getString(R.string.placename)));
        description.setText(intent.getStringExtra(getString(R.string.placedes)));
        imageView.setImageResource(intent.getIntExtra("image", 0));

    }
}

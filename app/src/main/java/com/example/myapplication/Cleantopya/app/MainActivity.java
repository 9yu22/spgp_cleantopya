package com.example.myapplication.Cleantopya.app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button_start);

        VideoView videoview1 = findViewById(R.id.startVideo);

        String uriPath2 = "android.resource://com.example.myapplication/"+R.raw.countdown;
        Uri uri2 = Uri.parse(uriPath2);
        videoview1.setVideoURI(uri2);
        videoview1.requestFocus();
        videoview1.start();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CleantopyaActivity.class);
                startActivity(intent);
            }
        });
    }

    public void backbutton(View view) {
        new AlertDialog.Builder(this)
                .setTitle(R.string.x)
                .setMessage(R.string.are_you_sure_you_want_to_exit)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finishAffinity();
                        System.exit(0);
                    }
                })
                .setNegativeButton(R.string.no, null)
                .show();
    }
}
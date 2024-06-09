package com.example.myapplication.Cleantopya.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class ScoreActivity extends AppCompatActivity {
    TextView stage1scoreTextView;
    TextView stage2scoreTextView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_activity);

        stage1scoreTextView = findViewById(R.id.stage1score);
        stage2scoreTextView = findViewById(R.id.stage2score);

        Intent intent = getIntent();
        if (intent != null) {
            int stage1score = intent.getIntExtra("STAGE_1_SCORE", 0);
            stage1scoreTextView.setText(String.valueOf(stage1score));
            int stage2score = intent.getIntExtra("STAGE_2_SCORE", 0);
            stage2scoreTextView.setText(String.valueOf(stage2score));
        }

        Button exitButton = findViewById(R.id.button_exit);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScoreActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}

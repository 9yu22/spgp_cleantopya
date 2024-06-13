package com.example.myapplication.Cleantopya.app;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ScoreActivityBinding;
import com.example.myapplication.framework.res.Sound;

public class ScoreActivity extends AppCompatActivity {
    private ScoreActivityBinding binding;
    private MediaPlayer mediaPlayer;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        binding = ScoreActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mediaPlayer = MediaPlayer.create(this, R.raw.goodvibes);
        mediaPlayer.start();

        Intent intent = getIntent();
        if (intent != null) {
            int stage1score = intent.getIntExtra("STAGE_1_SCORE", 0);
            binding.stage1score.setText(String.valueOf(stage1score));
            int stage2score = intent.getIntExtra("STAGE_2_SCORE", 0);
            binding.stage2score.setText(String.valueOf(stage2score));
            binding.addAllScore.setText(String.valueOf(stage1score+stage2score));
            int add12score = stage1score+stage2score;
            if(add12score<=10)        binding.resultscore.setText("SS");
            else if(add12score>=11 && add12score<=20) binding.resultscore.setText("S");
            else if(add12score>=21 && add12score<=30) binding.resultscore.setText("A");
            else if(add12score>=31 && add12score<=40) binding.resultscore.setText("B");
            else if(add12score>=41 && add12score<=50) binding.resultscore.setText("C");
            else if(add12score>=51 && add12score<=60) binding.resultscore.setText("D");
            else binding.resultscore.setText("F");
        }




        Button exitButton = findViewById(R.id.button_exit);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause(); // 음악 재생 일시 중지
                mediaPlayer.seekTo(0); // 재생 위치 초기화
                mediaPlayer.release(); // MediaPlayer 자원 해제
                mediaPlayer = null;

                Intent intent = new Intent(ScoreActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

}

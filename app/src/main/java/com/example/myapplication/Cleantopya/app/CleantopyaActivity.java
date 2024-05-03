package com.example.myapplication.Cleantopya.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Cleantopya.GameView;
import com.example.myapplication.Cleantopya.GameView2;
import com.example.myapplication.R;

public class CleantopyaActivity extends AppCompatActivity {

    public static CleantopyaActivity activity;
    private GameView gameView;
    private GameView2 gameView2;
    private boolean isGameView1Active = true; // 현재 활성화된 GameView가 1인지 여부를 추적
    Button button;
    private BroadcastReceiver customReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // GameView를 숨김
            gameView.setVisibility(View.GONE);
            // GameView2를 보임
            gameView2.setVisibility(View.VISIBLE);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        setContentView(R.layout.activity_game);

        // BroadcastReceiver 등록
        IntentFilter filter = new IntentFilter(GameView.CUSTOM_ACTION);
        registerReceiver(customReceiver, filter);

        gameView = findViewById(R.id.gameView);
        gameView2 = findViewById(R.id.gameView2);

        button = findViewById(R.id.button_test);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CleantopyaActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        // BroadcastReceiver 해제
        unregisterReceiver(customReceiver);
    }
}

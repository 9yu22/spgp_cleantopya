package com.example.myapplication.Cleantopya.app;

import android.os.Bundle;

import com.example.myapplication.BuildConfig;
import com.example.myapplication.Cleantopya.game.StartVideo;
import com.example.myapplication.Cleantopya.game.stage1Scene;
import com.example.myapplication.framework.activity.GameActivity;
import com.example.myapplication.framework.view.Metrics;
import com.example.myapplication.framework.scene.Scene;

public class CleantopyaActivity extends GameActivity {

/*  public static CleantopyaActivity activity;
    private GameView1 gameView;
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
        IntentFilter filter = new IntentFilter(GameView1.CUSTOM_ACTION);
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
    }*/
    protected void onCreate(Bundle savedInstanceState) {
        Scene.drawsDebugInfo = BuildConfig.DEBUG;
        Metrics.setGameSize(9, 16);
        super.onCreate(savedInstanceState);
        // Scene.drawsDebugInfo 변경 시점에 주의한다.
        // new GameView() 가 호출되는 super.onCreate() 보다 이전에 해야 한다.
        StartVideo video = new StartVideo(this);
        video.start();
        new stage1Scene().push();
    }

}

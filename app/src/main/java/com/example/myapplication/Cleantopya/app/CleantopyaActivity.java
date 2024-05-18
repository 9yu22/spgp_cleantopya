package com.example.myapplication.Cleantopya.app;

import android.os.Bundle;

import com.example.myapplication.BuildConfig;
import com.example.myapplication.Cleantopya.game.StartVideo;
import com.example.myapplication.Cleantopya.game.stage1Scene;
import com.example.myapplication.framework.activity.GameActivity;
import com.example.myapplication.framework.view.Metrics;
import com.example.myapplication.framework.scene.Scene;

public class CleantopyaActivity extends GameActivity {
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

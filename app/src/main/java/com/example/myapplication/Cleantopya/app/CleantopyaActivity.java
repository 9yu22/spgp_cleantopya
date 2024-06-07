package com.example.myapplication.Cleantopya.app;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;

import com.example.myapplication.BuildConfig;
import com.example.myapplication.Cleantopya.game.ObjectGenerator;
import com.example.myapplication.Cleantopya.game.StartVideo;
import com.example.myapplication.Cleantopya.game.stage1Scene;
import com.example.myapplication.framework.activity.GameActivity;
import com.example.myapplication.framework.view.Metrics;
import com.example.myapplication.framework.scene.Scene;

public class CleantopyaActivity extends GameActivity {
    public static Context getContext(){ return activity.getApplicationContext();}

    protected void onCreate(Bundle savedInstanceState) {
        Scene.drawsDebugInfo = BuildConfig.DEBUG;

        super.onCreate(savedInstanceState);
        new stage1Scene().push();
    }


}

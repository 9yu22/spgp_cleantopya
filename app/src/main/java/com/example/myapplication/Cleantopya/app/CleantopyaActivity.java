package com.example.myapplication.Cleantopya.app;

import android.content.Context;
import android.os.Bundle;

import com.example.myapplication.BuildConfig;
import com.example.myapplication.framework.activity.GameActivity;
import com.example.myapplication.framework.scene.Scene;
import com.example.myapplication.Cleantopya.game.stage1Scene;

public class CleantopyaActivity extends GameActivity {
    public static Context getContext(){ return activity.getApplicationContext();}

    protected void onCreate(Bundle savedInstanceState) {
        Scene.drawsDebugInfo = BuildConfig.DEBUG;

        super.onCreate(savedInstanceState);
        new stage1Scene().push();
    }


}

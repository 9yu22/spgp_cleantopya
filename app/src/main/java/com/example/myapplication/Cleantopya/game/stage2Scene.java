package com.example.myapplication.Cleantopya.game;

import android.util.Log;

import com.example.myapplication.R;
import com.example.myapplication.framework.interfaces.IGameObject;
import com.example.myapplication.framework.objects.Score;
import com.example.myapplication.framework.objects.VertScrollBackground;
import com.example.myapplication.framework.scene.Scene;
import com.example.myapplication.framework.view.Metrics;

import java.util.ArrayList;
import java.util.Random;

public class stage2Scene extends Scene {
    TouchButton redButton;
    TouchButton yellowButton;
    TouchButton blueButton;
    Score score;
    float totalElapsedTime;
    public enum Layer {
        bg, enemy, icon, ui, controller, COUNT
    }
    public stage2Scene(){
        initLayers(stage2Scene.Layer.COUNT);
        add(stage2Scene.Layer.bg, new VertScrollBackground(R.mipmap.background2, 0));

        this.redButton = new TouchButton(R.mipmap.red, 0, 14);
        float yellowX = 3.5f;
        this.yellowButton = new TouchButton(R.mipmap.yellow, yellowX, 14);
        this.blueButton = new TouchButton(R.mipmap.blue, 7, 14);

        add(stage2Scene.Layer.icon, redButton);
        add(stage2Scene.Layer.icon, blueButton);
        add(stage2Scene.Layer.icon, yellowButton);

        this.score = new Score(R.mipmap.number_24x32, Metrics.width - 0.5f, 0.5f, 0.6f);
        score.setScore(0);
        add(stage1Scene.Layer.ui, score);

        add(stage2Scene.Layer.controller, new ObjectGenerator());
    }
    public void addScore(int amount) {
        score.add(amount);
    }
    @Override
    public void update(float elapsedSeconds) {
        super.update(elapsedSeconds);
        totalElapsedTime += elapsedSeconds;
        if(totalElapsedTime>=1) {
            addScore(1);
            totalElapsedTime--;
        }
    }

}

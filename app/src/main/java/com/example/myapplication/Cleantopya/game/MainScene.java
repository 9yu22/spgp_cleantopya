package com.example.myapplication.Cleantopya.game;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.example.myapplication.R;
import com.example.myapplication.framework.objects.Score;
import com.example.myapplication.framework.objects.VertScrollBackground;
import com.example.myapplication.framework.scene.Scene;
import com.example.myapplication.framework.view.Metrics;

public class MainScene extends Scene {
    private static final String TAG = MainScene.class.getSimpleName();
    Score score; // package private
    TouchButton redButton;
    TouchButton yellowButton;
    TouchButton blueButton;
    public int getScore() {
        return score.getScore();
    }

    public enum Layer {
        bg, enemy, bullet, player, ui, controller, COUNT
    }
    public MainScene() {
        //Metrics.setGameSize(16, 16);
        initLayers(Layer.COUNT);

        add(Layer.bg, new VertScrollBackground(R.mipmap.background, 0));

        this.redButton = new TouchButton(R.mipmap.redbutton, 0, 14);
        float yellowX = 3.5f;
        this.yellowButton = new TouchButton(R.mipmap.yellowbutton, yellowX, 14);
        this.blueButton = new TouchButton(R.mipmap.bluebutton, 7, 14);

        add(Layer.enemy, redButton);
        add(Layer.enemy, yellowButton);
        add(Layer.enemy, blueButton);

        this.score = new Score(R.mipmap.number_24x32, Metrics.width - 0.5f, 0.5f, 0.6f);
        score.setScore(0);
        add(Layer.ui, score);
    }

    public void addScore(int amount) {
        score.add(amount);
    }

    @Override
    public void update(float elapsedSeconds) {
        super.update(elapsedSeconds);
    }

    //@Override
    //public boolean onTouch(MotionEvent event) { return fighter.onTouch(event);}
}

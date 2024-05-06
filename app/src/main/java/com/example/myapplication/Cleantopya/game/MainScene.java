package com.example.myapplication.Cleantopya.game;

import android.content.Intent;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;

import com.example.myapplication.R;
import com.example.myapplication.framework.objects.Score;
import com.example.myapplication.framework.objects.VertScrollBackground;
import com.example.myapplication.framework.scene.Scene;
import com.example.myapplication.framework.view.Metrics;

public class MainScene extends Scene {
    private static final String TAG = MainScene.class.getSimpleName();
    Score score; // package private

    int count;
    int randomGoalCount = (int)(Math.random()*10)+10;
    boolean yellowVisible = false;

    TouchButton redButton;
    TouchButton yellowButton;
    TouchButton blueButton;
    public int getScore() {
        return score.getScore();
    }

    public enum Layer {
        bg, icon, bullet, player, ui, controller, COUNT
    }
    public MainScene() {
        //Metrics.setGameSize(16, 16);
        initLayers(Layer.COUNT);

        add(Layer.bg, new VertScrollBackground(R.mipmap.background, 0));

        this.redButton = new TouchButton(R.mipmap.red, 0, 14);
        float yellowX = 3.5f;
        this.yellowButton = new TouchButton(R.mipmap.yellow, yellowX, 14);
        this.blueButton = new TouchButton(R.mipmap.blue, 7, 14);

        add(Layer.icon, redButton);
        add(Layer.icon, blueButton);

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

    @Override
    public boolean onTouch(MotionEvent event) {
        float touchx = event.getX()/80;
        float touchy = event.getY()/80;

        if(event.getAction() == MotionEvent.ACTION_DOWN){
            if(count<randomGoalCount) {
                if (redButton.isClicked(touchx, touchy)) {
                    count++;
                }
                if (blueButton.isClicked(touchx, touchy)) {
                    count++;
                }
                Log.d("onTouchEvent", "count"+count);
            }
            else {
                Log.d("onTouchEvent", "count is End" + count);
                yellowVisible = true;
                addYellowButton();
            }
        }
        return true;
    }

    private void addYellowButton() {
        if (yellowVisible) {
            add(Layer.icon, yellowButton);
        }
    }

    private void removeYellowButton() {
        if (!yellowVisible) {
            remove(Layer.icon, yellowButton);
        }
    }

}

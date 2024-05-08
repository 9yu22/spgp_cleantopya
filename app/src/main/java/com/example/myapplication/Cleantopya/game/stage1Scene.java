package com.example.myapplication.Cleantopya.game;

import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.framework.interfaces.IGameObject;
import com.example.myapplication.framework.objects.Score;
import com.example.myapplication.framework.objects.Sprite;
import com.example.myapplication.framework.objects.VertScrollBackground;
import com.example.myapplication.framework.scene.Scene;
import com.example.myapplication.framework.view.Metrics;

import java.util.ArrayList;

public class stage1Scene extends Scene {
    private static final String TAG = stage1Scene.class.getSimpleName();

    int count;
    int randomGoalCount = (int)(Math.random()*10)+10;
    boolean yellowVisible = false;
    TouchButton redButton;
    TouchButton yellowButton;
    TouchButton blueButton;
    Score score; // package private
    float previousTime;
    float totalElapsedTime;
    Dust dust1;
    Dust dust2;
    Dust dust3;
    Dust dust4;
    Dust dust5;

    Sprite cushion;

    public int getScore() {
        return score.getScore();
    }

    public enum Layer {
        bg, icon, object, player, ui, controller, COUNT
    }
    public stage1Scene() {
        //Metrics.setGameSize(16, 16);
        initLayers(Layer.COUNT);

        add(Layer.bg, new VertScrollBackground(R.mipmap.background, 0));

        this.redButton = new TouchButton(R.mipmap.red, 0, 14);
        float yellowX = 3.5f;
        this.yellowButton = new TouchButton(R.mipmap.yellow, yellowX, 14);
        this.blueButton = new TouchButton(R.mipmap.blue, 7, 14);

        add(Layer.icon, redButton);
        add(Layer.icon, blueButton);

        this.cushion = new Sprite(R.mipmap.cushion);
        cushion.setPosition(4.5f, 7.f, 4.5f);
        add(Layer.player, cushion);

        this.score = new Score(R.mipmap.number_24x32, Metrics.width - 0.5f, 0.5f, 0.6f);
        score.setScore(0);
        add(Layer.ui, score);

        this.dust1 = new Dust(2.5f, 5.f, 0.2f, 0.1f);
        this.dust2 = new Dust(3.f, 5.f, 0.8f, 0.7f);
        this.dust3 = new Dust(5.f, 5.f, 0.6f, 0.5f);
        this.dust4 = new Dust(7.f, 5.f, 0.4f, 0.3f);
        this.dust5 = new Dust(7.5f, 5.f, 1.0f, 0.9f);

        add(Layer.object, dust1);
        add(Layer.object, dust2);
        add(Layer.object, dust3);
        add(Layer.object, dust4);
        add(Layer.object, dust5);
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
            if(yellowButton.isClicked(touchx, touchy)){
                new stage2Scene().push();
            }
        }
        return true;
    }

    private void addYellowButton() {
        if (yellowVisible) {
            add(Layer.icon, yellowButton);
        }
    }

}

package com.example.myapplication.Cleantopya.game;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.Log;
import android.view.MotionEvent;

import com.example.myapplication.R;
import com.example.myapplication.framework.interfaces.IGameObject;
import com.example.myapplication.framework.objects.Score;
import com.example.myapplication.framework.objects.VertScrollBackground;
import com.example.myapplication.framework.res.Sound;
import com.example.myapplication.framework.scene.Scene;
import com.example.myapplication.framework.view.Metrics;

import java.util.ArrayList;
import java.util.Random;

public class stage2Scene extends Scene {
    public static final float SHAKE_TIMER = 1.f;
    TouchButton redButton;
    TouchButton yellowButton;
    TouchButton blueButton;
    Score score;
    ObjectGenerator generateManager;

    boolean wrongTouch = false;
    float totalElapsedTime;
    private float shakeTimer;
    private boolean flag = false;
    private int Flag = 0;

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

        this.generateManager = new ObjectGenerator();
        add(stage2Scene.Layer.controller, generateManager);
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
        if(wrongTouch){
            shakeTimer -= elapsedSeconds;
            if(shakeTimer<=0) {
                wrongTouch = false;
            }
        }
        
    }

    public boolean onTouch(MotionEvent event) {

        float touchx = event.getX()/80;
        float touchy = event.getY()/80;

        if(event.getAction() == MotionEvent.ACTION_DOWN && !wrongTouch){
            if (redButton.isClicked(touchx, touchy)) {
                Sound.playEffect(redButton.getSoundResId());
                if(!generateManager.lineRemove(0)){
                    wrongTouch = true;
                    shakeTimer = SHAKE_TIMER;
                    return false;
                }
            }
            if(yellowButton.isClicked(touchx, touchy)){
                Sound.playEffect(yellowButton.getSoundResId());
                if(!generateManager.lineRemove(1)){
                    wrongTouch = true;
                    shakeTimer = SHAKE_TIMER;
                    return false;
                }
            }
            if (blueButton.isClicked(touchx, touchy)) {
                Sound.playEffect(blueButton.getSoundResId());
                if(!generateManager.lineRemove(2)){
                    wrongTouch = true;
                    shakeTimer = SHAKE_TIMER;
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void draw(Canvas canvas){
        if (wrongTouch) {
            Matrix transformMatrix = new Matrix();
            if(Flag<5) {
                transformMatrix.setTranslate(0.2f, 0.1f);
            }
            else {
                transformMatrix.setTranslate(-0.2f, -0.1f);
            }
            Flag=(Flag+1)%10;
            canvas.concat(transformMatrix);
        }
        super.draw(canvas);
    }
}

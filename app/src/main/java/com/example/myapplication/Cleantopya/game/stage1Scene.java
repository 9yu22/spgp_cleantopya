package com.example.myapplication.Cleantopya.game;

import android.util.Log;
import android.view.MotionEvent;

import com.example.myapplication.R;
import com.example.myapplication.framework.objects.Score;
import com.example.myapplication.framework.objects.Sprite;
import com.example.myapplication.framework.objects.VertBackground;
import com.example.myapplication.framework.res.Sound;
import com.example.myapplication.framework.scene.Scene;
import com.example.myapplication.framework.view.Metrics;

public class stage1Scene extends Scene {
    private static final String TAG = stage1Scene.class.getSimpleName();

    int count;
    int randomGoalCount = (int)(Math.random()*10)+90; //[90,100)
    boolean yellowVisible = false;
    TouchButton redButton;
    TouchButton yellowButton;
    TouchButton blueButton;
    Score score;
    float totalElapsedTime;
    Dust dust1;
    Dust dust2;
    Dust dust3;
    Dust dust4;
    Dust dust5;
    Dust dust6;
    Dust dust7;
    Dust dust8;
    Dust dust9;
    Dust dust10;

    Sprite cushion;

    private static stage1Scene instance;

    public static stage1Scene getInstance() {
        return instance;
    }

    public int getStage1score() {
        return score.getScore();
    }

    public enum Layer {
        bg, icon, object, player, ui, controller, COUNT
    }

    public stage1Scene() {
        instance = this;
        Metrics.setGameSize(9, 16);
        initLayers(Layer.COUNT);

        add(Layer.bg, new VertBackground(R.mipmap.background));

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

        this.dust1 = new Dust(2.5f, 8.f);
        this.dust2 = new Dust(3.f, 8.f);
        this.dust3 = new Dust(5.f, 8.f);
        this.dust4 = new Dust(7.f, 8.f);
        this.dust5 = new Dust(7.5f, 8.f);

        this.dust6 = new Dust(4.f, 8.f);
        this.dust7 = new Dust(6.f, 8.f);
        this.dust8 = new Dust(2.5f, 8.f);
        this.dust9 = new Dust(2.f, 8.f);
        this.dust10 = new Dust(7.5f, 8.f);

        add(Layer.object, dust1);
        add(Layer.object, dust2);
        add(Layer.object, dust3);
        add(Layer.object, dust4);
        add(Layer.object, dust5);
        add(Layer.object, dust6);
        add(Layer.object, dust7);
        add(Layer.object, dust8);
        add(Layer.object, dust9);
        add(Layer.object, dust10);
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
        dustMove();
    }

    @Override
    public boolean onTouch(MotionEvent event) {

        float[] pts = Metrics.fromScreen(event.getX(), event.getY());
        float touchx = pts[0];
        float touchy = pts[1];

        if(event.getAction() == MotionEvent.ACTION_DOWN){

            if(count<randomGoalCount) {
                if (redButton.isClicked(touchx, touchy)) {
                    count++;
                    Sound.playEffect(redButton.getSoundResId());
                }
                if (blueButton.isClicked(touchx, touchy)) {
                    count++;
                    Sound.playEffect(blueButton.getSoundResId());
                }
                //Log.d("onTouchEvent", "count" + count);
            }
            else {
                //Log.d("onTouchEvent", "count is End" + count);
                yellowVisible = true;
                addYellowButton();
            }
            if(yellowVisible && yellowButton.isClicked(touchx, touchy)){
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

    public void dustMove() {
        if(count>15){
            dust1.move(5.f);
            dust6.move(4.f);
        }
        if(count>30){
            dust2.move(3.f);
            dust10.move(5.5f);
        }
        if(count>45){
            dust3.move(5.f);
            dust7.move(6.f);
        }
        if(count>60){
            dust4.move(3.f);
            dust9.move(4.f);
        }
        if(count>75){
            dust5.move(5.f);
        }
        if(count>90){
            dust8.move(6.5f);
        }
    }

    @Override
    protected void onStart() {
        Sound.playMusic(R.raw.main);
    }
    @Override
    protected void onPause() {
        Sound.pauseMusic();
    }
    @Override
    protected void onResume() {
        Sound.resumeMusic();
    }
    @Override
    protected void onEnd() {
        Sound.stopMusic();
    }
}

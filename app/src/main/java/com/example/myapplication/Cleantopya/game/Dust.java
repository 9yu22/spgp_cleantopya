package com.example.myapplication.Cleantopya.game;

import android.graphics.RectF;

import com.example.myapplication.R;
import com.example.myapplication.framework.objects.Sprite;
import com.example.myapplication.framework.scene.Scene;

public class Dust extends Sprite{
    private static final float dust_WIDTH = 0.68f;
    private static final float dust_HEIGHT = dust_WIDTH * 40 / 28;
    private static final float SPEED = 1.0f;
    private int power;

    public Dust(float x, float y) {
        super(R.mipmap.dust);
        setPosition(x, y, dust_WIDTH, dust_HEIGHT);
    }

    @Override
    public void update(float elapsedSeconds) {
        super.update(elapsedSeconds);
    }

    public void move(float speed){
        dy = +speed;
    }
}

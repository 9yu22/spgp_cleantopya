package com.example.myapplication.Cleantopya.game;

import android.graphics.RectF;

import com.example.myapplication.R;
import com.example.myapplication.framework.objects.Sprite;
import com.example.myapplication.framework.scene.Scene;

public class Dust extends Sprite{
    private static final float BULLET_WIDTH = 0.68f;
    private static final float BULLET_HEIGHT = BULLET_WIDTH * 40 / 28;
    private static final float SPEED = 20.0f;
    private int power;

    public Dust(float x, float y) {
        super(R.mipmap.dust);
        setPosition(x, y, BULLET_WIDTH, BULLET_HEIGHT);
        dy = -SPEED;
    }

    @Override
    public void update(float elapsedSeconds) {
        super.update(elapsedSeconds);
/*        if (dstRect.bottom < 0) {
            Scene.top().remove(stage1Scene.Layer.bullet, this);
        }*/
    }

}

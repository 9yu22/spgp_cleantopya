package com.example.myapplication.Cleantopya.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import com.example.myapplication.R;
import com.example.myapplication.framework.interfaces.IBoxCollidable;
import com.example.myapplication.framework.interfaces.IRecyclable;
import com.example.myapplication.framework.objects.AnimSprite;
import com.example.myapplication.framework.objects.Sprite;
import com.example.myapplication.framework.scene.RecycleBin;
import com.example.myapplication.framework.scene.Scene;
import com.example.myapplication.framework.view.Metrics;

import java.util.ArrayList;

public class HomeObject extends AnimSprite implements IBoxCollidable, IRecyclable {
    private static final float SPEED = 15.0f;
    private static final float RADIUS = 1.0f;
    private static final int[] resIds = {
            R.mipmap.clock, R.mipmap.fan, R.mipmap.snuggle
     };
    public static final float ANIM_FPS = 10.0f;
    protected RectF collisionRect = new RectF();
    private int level;
    private int life;

    private HomeObject(int level, int index) {
        super(0, 0);
        init(level, index);
        dy = SPEED;
    }

    private void init(int level, int index) {
        this.level = level;
        this.life = 1;
        setAnimationResource(resIds[level], ANIM_FPS);
        setPosition(Metrics.width / 10 * (4 * index + 1), -RADIUS, RADIUS);
    }

    public static HomeObject get(int level, int index) {
        HomeObject furnitureAsset = (HomeObject) RecycleBin.get(HomeObject.class);
        if (furnitureAsset != null) {
            furnitureAsset.init(level, index);
            return furnitureAsset;
        }
        return new HomeObject(level, index);
    }
    @Override
    public void update(float elapsedSeconds) {
        super.update(elapsedSeconds);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.save();

        float width = dstRect.width() * 0.7f;
        canvas.translate(x - width / 2, dstRect.bottom);
        canvas.scale(width, width);
        canvas.restore();

        /*Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(0.1f);
        canvas.drawRect(dstRect, paint);*/
    }

    @Override
    public void onRecycle() {

    }

    public int getScore() {
        return (level + 1) * 100;
    }

    @Override
    public RectF getCollisionRect() {
        return collisionRect;
    }
}

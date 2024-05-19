package com.example.myapplication.Cleantopya.game;

import android.graphics.Canvas;
import android.graphics.RectF;

import com.example.myapplication.R;
import com.example.myapplication.framework.interfaces.IBoxCollidable;
import com.example.myapplication.framework.interfaces.IRecyclable;
import com.example.myapplication.framework.objects.AnimSprite;
import com.example.myapplication.framework.objects.Sprite;
import com.example.myapplication.framework.scene.RecycleBin;
import com.example.myapplication.framework.scene.Scene;
import com.example.myapplication.framework.util.Gauge;
import com.example.myapplication.framework.view.Metrics;

public class HomeObject extends AnimSprite implements IBoxCollidable, IRecyclable {
    private static final float SPEED = 3.0f;
    private static final float RADIUS = 0.9f;
    private static final int[] resIds = {
            R.mipmap.clock, R.mipmap.fan, R.mipmap.snuggle
     };
    public static final int MAX_LEVEL = resIds.length - 1;
    public static final float ANIM_FPS = 10.0f;
    protected RectF collisionRect = new RectF();
    private int level;
    private int life, maxLife;
    protected static Gauge gauge = new Gauge(0.1f, R.color.enemy_gauge_fg, R.color.enemy_gauge_bg);

    private HomeObject(int level, int index) {
        super(0, 0);
        init(level, index);
        dy = SPEED;
    }

    private void init(int level, int index) {
        this.level = level;
        this.life = this.maxLife = (level + 1) * 10;
        setAnimationResource(resIds[level], ANIM_FPS);
        setPosition(Metrics.width / 10 * (2 * index + 1), -RADIUS, RADIUS);
    }

    public static HomeObject get(int level, int index) {
        HomeObject enemy = (HomeObject) RecycleBin.get(HomeObject.class);
        if (enemy != null) {
            enemy.init(level, index);
            return enemy;
        }
        return new HomeObject(level, index);
    }
    @Override
    public void update(float elapsedSeconds) {
        super.update(elapsedSeconds);
        if (dstRect.top > Metrics.height) {
            Scene.top().remove(stage2Scene.Layer.enemy, this);
        }
        collisionRect.set(dstRect);
        collisionRect.inset(0.11f, 0.11f);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.save();

        float width = dstRect.width() * 0.7f;
        canvas.translate(x - width / 2, dstRect.bottom);
        canvas.scale(width, width);
        gauge.draw(canvas, (float)life / maxLife);
        canvas.restore();
    }

    @Override
    public RectF getCollisionRect() {
        return collisionRect;
    }

    @Override
    public void onRecycle() {

    }

    public int getScore() {
        return (level + 1) * 100;
    }

    public boolean decreaseLife(int power) {
        life -= power;
        return life <= 0;
    }
}

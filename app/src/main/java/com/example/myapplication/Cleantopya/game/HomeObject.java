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

import java.util.ArrayList;

public class HomeObject extends AnimSprite implements IBoxCollidable, IRecyclable {
    private static final float SPEED = 5.0f;
    private static final float RADIUS = 0.9f;
    private static final int[] resIds = {
            R.mipmap.clock, R.mipmap.fan, R.mipmap.snuggle
     };
    public static final int MAX_LEVEL = resIds.length - 1;
    public static final float ANIM_FPS = 10.0f;
    protected RectF collisionRect = new RectF();
    private int level;
    private int life, maxLife;

    // Static list to keep track of stopped HomeObjects
    private static ArrayList<HomeObject> stoppedObjects = new ArrayList<>();

    private HomeObject(int level, int index) {
        super(0, 0);
        init(level, index);
        dy = SPEED;
    }

    private void init(int level, int index) {
        this.level = level;
        this.life = this.maxLife = (level + 1) * 10;
        setAnimationResource(resIds[level], ANIM_FPS);
        setPosition(Metrics.width / 10 * (4 * index + 1), -RADIUS, RADIUS);
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

        // Check if the object has reached the bottom or needs to be stacked
        if (dstRect.top >= Metrics.height - RADIUS - 2 || shouldStopAndStack()) {
            dy = 0;

            // Update the y position to stack on top of the previous stopped object
            if (!stoppedObjects.contains(this)) {
                float topY = Metrics.height - RADIUS;
                for (HomeObject obj : stoppedObjects) {
                    topY -= obj.dstRect.height();
                }
                dy = topY - RADIUS;
                stoppedObjects.add(this);
            }
        }

        collisionRect.set(dstRect);
        collisionRect.inset(0.11f, 0.11f);
    }

    private boolean shouldStopAndStack() {
        for (HomeObject obj : stoppedObjects) {
            if (RectF.intersects(this.dstRect, obj.dstRect)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.save();

        float width = dstRect.width() * 0.7f;
        canvas.translate(x - width / 2, dstRect.bottom);
        canvas.scale(width, width);
        canvas.restore();
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

    @Override
    public RectF getCollisionRect() {
        return collisionRect;
    }
}

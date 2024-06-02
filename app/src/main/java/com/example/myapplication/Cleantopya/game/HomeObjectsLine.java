package com.example.myapplication.Cleantopya.game;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.example.myapplication.Cleantopya.game.HomeObject;
import com.example.myapplication.framework.interfaces.IGameObject;
import com.example.myapplication.framework.interfaces.IRecyclable;
import com.example.myapplication.framework.scene.RecycleBin;
import com.example.myapplication.framework.scene.Scene;
import com.example.myapplication.framework.view.Metrics;

public class HomeObjectsLine implements IGameObject, IRecyclable {
    private HomeObject[] row = new HomeObject[3];
    private final Random random = new Random();
    private static final float RADIUS = 1.0f;
    private RectF dstRect = new RectF();
    protected float y, dy;
    protected float rectRightBottom = 0.3f;
    private float SPEED = 3.0f;
    private static ArrayList<HomeObjectsLine> stoppedObjects = new ArrayList<>();

    public static HomeObjectsLine get() {
        HomeObjectsLine line = (HomeObjectsLine) RecycleBin.get(HomeObjectsLine.class);
        if (line != null) {
            line.init();
            return line;
        }
        return new HomeObjectsLine();
    }
    public HomeObjectsLine() {
        init();
    }
    private void init() {
        int fixIndex = random.nextInt(3);
        for (int i = 0; i < 3; i++){
            if(i!= fixIndex) {
                if (!random.nextBoolean()) {
                    continue;
                }
            }
            int level = random.nextInt(3);
            row[i] = HomeObject.get(level, i);
        }
        dstRect.set(0,-2,9,rectRightBottom);
        dy = SPEED;
    }

    @Override
    public void update(float elapsedSeconds) {
        float timedDy = dy * elapsedSeconds;
        y += timedDy;
        dstRect.offset(0, timedDy);

        if (dstRect.top >= Metrics.height - RADIUS - 4 || shouldStopAndStack()) {
            dy = 0;

            if (!stoppedObjects.contains(this)) {
                float topY = Metrics.height - RADIUS;
                for (HomeObjectsLine obj : stoppedObjects) {
                    topY -= obj.dstRect.height();
                }
                dy = topY - RADIUS;
                stoppedObjects.add(this);
            }
        }
        else{
            dy = SPEED;
            stoppedObjects.remove(this);
        }

        for(int i = 0; i < 3; i++){
            if(row[i] == null)
                continue;
            row[i].updateY(timedDy);
        }
    }
    private boolean shouldStopAndStack() {
        for (HomeObjectsLine obj : stoppedObjects) {
            if (RectF.intersects(this.dstRect, obj.dstRect)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public void draw(Canvas canvas) {
        for(int i=0;i<3;i++){
            if(row[i]!=null){
                row[i].draw(canvas);

            }
        }
        //Paint paint = new Paint();
        //canvas.drawRect(dstRect, paint);
    }

    @Override
    public void onRecycle() {
        stoppedObjects.remove(this);
    }

    public void Remove(int index){
        if(row[index] != null){
            //RecycleBin.collect((IRecyclable) row[index]);
            row[index] = null;
        }
    }

    public boolean isEmptyLine(){
        for(int i = 0 ; i < 3; i++){
            if(row[i] != null)
                return false;
        }
        return true;
    }
}
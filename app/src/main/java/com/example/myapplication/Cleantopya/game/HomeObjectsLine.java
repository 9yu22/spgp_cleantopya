package com.example.myapplication.Cleantopya.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;

import java.util.Random;

import com.example.myapplication.Cleantopya.game.HomeObject;
import com.example.myapplication.framework.interfaces.IGameObject;
import com.example.myapplication.framework.interfaces.IRecyclable;
import com.example.myapplication.framework.scene.RecycleBin;
import com.example.myapplication.framework.scene.Scene;
import com.example.myapplication.framework.view.Metrics;

public class HomeObjectsLine implements IGameObject, IRecyclable {
    private HomeObject[] row ;
    private final Random random = new Random();
    private static final float RADIUS = 1.0f;
    private RectF dstRect = new RectF();
    protected float y, dy;
    protected float rectRightBottom = 0.3f;
    private float SPEED = 3.0f;
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
        row = new HomeObject[3];

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
        y=-2;
    }
    @Override
    public void update(float elapsedSeconds){

    }

    static final float MIN_Y[] = {
        11, 8.7f, 6.4f, 4.1f, 1.8f, -0.5f
    };
    public void update(float elapsedSeconds, int index) {
        float minY = MIN_Y[index];
        if(minY <= y) {
            y = minY;
            return;
        }

        float timedDy = dy * elapsedSeconds * 3;
        y += timedDy;
        dstRect.offset(0, timedDy);

        for(int i = 0; i < 3; i++){
            if(row[i] == null)
                continue;
            row[i].updateY(timedDy);
        }
    }
    @Override
    public void draw(Canvas canvas) {
        for(int i=0;i<3;i++){
            if(row[i]!=null){
                row[i].draw(canvas);
            }
        }

        /*Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(0.1f);
        canvas.drawRect(dstRect, paint);*/
    }

    @Override
    public void onRecycle() {
    }

    public boolean Remove(int index){
        if(row[index] != null){
            RecycleBin.collect((IRecyclable) row[index]);
            row[index] = null;
            return true;
        }
        else return false;
    }

    public boolean isEmptyLine(){
        for(int i = 0 ; i < 3; i++){
            if(row[i] != null)
                return false;
        }
        return true;
    }
}
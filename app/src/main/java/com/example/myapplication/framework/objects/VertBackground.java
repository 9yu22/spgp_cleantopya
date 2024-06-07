package com.example.myapplication.framework.objects;

import android.graphics.Canvas;

import com.example.myapplication.framework.view.Metrics;

public class VertScrollBackground extends Sprite {

    //private final float height;
    public VertScrollBackground(int bitmapResId) {
        super(bitmapResId);
        //this.height = bitmap.getHeight() * Metrics.width / bitmap.getWidth();
        //setPosition(Metrics.width / 2, Metrics.height / 2, Metrics.width, height);
        setPosition(0,0, Metrics.width, Metrics.height);
    }
    @Override
    public void update(float elapsedSeconds) {
    }

    @Override
    public void draw(Canvas canvas) {
        //super.draw(canvas);
        float curr = y % height;
        if (curr > 0) curr -= height;
        while (curr < Metrics.height) {
            dstRect.set(0, 0, Metrics.width, height);
            canvas.drawBitmap(bitmap, null, dstRect, null);
            curr += height;
        }
    }
}

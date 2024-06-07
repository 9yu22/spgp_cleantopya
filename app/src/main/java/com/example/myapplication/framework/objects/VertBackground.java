package com.example.myapplication.framework.objects;

import android.graphics.Canvas;

import com.example.myapplication.framework.view.Metrics;

public class VertBackground extends Sprite {

    //private final float height;
    public VertBackground(int bitmapResId) {
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
        dstRect.set(0, 0, Metrics.width, Metrics.height);
        canvas.drawBitmap(bitmap, null, dstRect, null);

    }
}

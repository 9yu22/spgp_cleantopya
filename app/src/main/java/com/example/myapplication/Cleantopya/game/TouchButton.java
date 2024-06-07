package com.example.myapplication.Cleantopya.game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.Log;

import com.example.myapplication.R;
import com.example.myapplication.framework.interfaces.IGameObject;
import com.example.myapplication.framework.objects.Sprite;
import com.example.myapplication.framework.res.BitmapPool;
import com.example.myapplication.framework.view.Metrics;

public class TouchButton extends Sprite {

    float buttonx;
    float buttony;
    private RectF buttonRect = new RectF();

    //생성자
    public TouchButton(int bitmapResId, float x, float y){
        super(bitmapResId);
        buttonx = x;
        buttony = y;
    }
    @Override
    public void update(float elapsedSeconds) {

    }
    @Override
    public void draw(Canvas canvas){
        buttonRect.set(buttonx, buttony, buttonx+2, buttony+2);
        canvas.drawBitmap(bitmap, null, buttonRect, null);

    }

    public boolean isClicked(float touchX, float touchY) {
        //Log.d("isClicked", "touchX:"+touchX + "touchY:"+touchY);
        //Log.d("isClicked", "x:"+ buttonx + "y:"+ buttony);
        if (touchX < buttonx+2 && touchX > buttonx) {
            if (touchY < buttony+2 && touchY > buttony) {
                return true;
            }
            else return false;
        }
        return false;
    }

    public int getSoundResId() {
        return R.raw.jelly;
    }
}

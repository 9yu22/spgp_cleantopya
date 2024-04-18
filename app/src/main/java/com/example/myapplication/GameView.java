package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.nfc.Tag;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * TODO: document your custom view class.
 */
public class GameView extends View {
  TouchButton redButton;
  TouchButton yellowButton;
  TouchButton blueButton;
  int count;

    public GameView(Context context) {
        super(context);
        init(null, 0);
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public GameView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        float yellowX = 4.5f;
        redButton = new TouchButton(1, 14, 1);
        yellowButton = new TouchButton(yellowX, 14, 2);
        blueButton = new TouchButton(8, 14, 3);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        float view_ratio = (float)w / (float)h;
        float game_ratio = SCREEN_WIDTH / SCREEN_HEIGHT;

        if (view_ratio > game_ratio) {
            transformOffset.set((w - h * game_ratio) / 2, 0);
            transformScale = h / SCREEN_HEIGHT;
        } else {
            transformOffset.set(0, (h - w / game_ratio) / 2);
            transformScale = w / SCREEN_WIDTH;
        }
    }
    private static final float SCREEN_WIDTH = 9.0f;
    private static final float SCREEN_HEIGHT = 16.0f;
    private final PointF transformOffset = new PointF();
    private float transformScale;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(transformOffset.x, transformOffset.y);
        canvas.scale(transformScale, transformScale);

        redButton.Draw(canvas);
        yellowButton.Draw(canvas);
        blueButton.Draw(canvas);

        canvas.restore();
    }

    public boolean onTouchEvent(MotionEvent event) { //view에서 touch를 처리하는 방법
        float redX = event.getX()/60;
        float redY = event.getY()/66;
        float blueX = event.getX()/82;
        float blueY = event.getY()/64;
        //이 변수들을 실제 휴대폰 좌표로 전환해주어야함.
        if(event.getAction() == MotionEvent.ACTION_DOWN){ //손가락이 닿았을때
                if(redButton.isClicked(redX, redY)) {
                    count++;
                }
                if(blueButton.isClicked(blueX, blueY)){
                    count++;
                };

                Log.d("onTouchEvent", "count"+count);
        }

        return true; //뭐하지
    }

}

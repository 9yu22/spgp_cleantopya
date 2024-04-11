package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * TODO: document your custom view class.
 */
public class GameView extends View {
    private TextPaint mTextPaint;
    private Paint BrownPaint;
    private Paint YellowPaint;
    private Paint RedPaint;
    private Paint BlackPaint;

    private Paint WhitePaint;

    private Paint getBrown() {
        if (BrownPaint == null) {
            BrownPaint = new Paint();
            BrownPaint.setColor(Color.parseColor("#BF4C00"));
            BrownPaint.setStyle(Paint.Style.FILL);
        }
        return BrownPaint;
    }
    private Paint getYellow() {
        if (YellowPaint == null) {
            YellowPaint = new Paint();
            YellowPaint.setColor(Color.parseColor("#F4D797"));
            YellowPaint.setStyle(Paint.Style.FILL);
        }
        return YellowPaint;
    }

    private Paint getRed() {
        if (RedPaint == null) {
            RedPaint = new Paint();
            RedPaint.setColor(Color.parseColor("#C91F16"));
            RedPaint.setStyle(Paint.Style.FILL);
        }
        return RedPaint;
    }
    private Paint getBlack() {
        if (BlackPaint == null) {
            BlackPaint = new Paint();
            BlackPaint.setColor(Color.BLACK);
        }
        return BlackPaint;
    }

    private Paint getWhite(){
        if (WhitePaint == null) {
            WhitePaint = new Paint();
            WhitePaint.setColor(Color.WHITE);
        }
        return WhitePaint;
    }

    private Rect bread;
    private RectF mouse;

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
        mouse = new RectF();
        bread = new Rect();
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


        //식빵
        canvas.drawCircle(2.f, 4.f, 0.5f, getBrown());
        canvas.drawCircle(3.f, 4.f, 0.5f, getBrown());
        canvas.drawCircle(4.f,4.f, 0.5f, getBrown());
        bread.set(2, 4, 4, 6);
        canvas.drawRect(bread, getBrown());


        //호빵맨 얼굴
        canvas.drawCircle(6.f, 12.f, 2.5f, getYellow());

        //호빵맨 볼
        canvas.drawCircle(5.2f, 12.f, 0.5f, getRed());
        canvas.drawCircle(6.f, 12.f, 0.5f, getRed());
        canvas.drawCircle(6.8f, 12.f, 0.5f, getRed());

        //호빵맨 볼터치
        canvas.drawRect(4.9f, 11.7f, 5.0f, 11.8f, getWhite());
        canvas.drawRect(5.8f, 11.7f, 5.9f, 11.8f, getWhite());
        canvas.drawRect(6.65f, 11.7f, 6.75f, 11.8f, getWhite());

        //호빵맨 눈
        canvas.drawOval(5.3f, 11.f, 5.7f, 11.8f, getBlack());
        canvas.drawOval(6.3f, 11.f, 6.7f, 11.8f, getBlack());

        //호빵맨 눈썹
        BlackPaint.setStyle(Paint.Style.STROKE);
        BlackPaint.setStrokeWidth(0.1f);
        canvas.drawArc(5.0f, 10.5f, 5.9f, 11.5f, 180, 180, false, getBlack());
        canvas.drawArc(6.1f, 10.5f, 7.0f, 11.5f, 180, 180, false, getBlack());
        BlackPaint.setStyle(Paint.Style.FILL);

        //호빵맨 입
        mouse.set(5.2f, 11.2f, 6.8f, 14.2f);
        canvas.drawArc(mouse, 0, 180, true, getRed());

        canvas.restore();
    }

}

package com.example.myapplication.Cleantopya;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.myapplication.Cleantopya.game.TouchButton;
import com.example.myapplication.R;

/**
 * TODO: document your custom view class.
 */
public class GameView2 extends View {

    TouchButton redButton;
    TouchButton yellowButton;
    TouchButton blueButton;
    private Bitmap backgroundImage;

    Rect srcRect = new Rect();
    RectF dstRect = new RectF();


    public GameView2(Context context) {
        super(context);
        init(null, 0);
    }

    public GameView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public GameView2(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        backgroundImage = BitmapFactory.decodeResource(getResources(), R.mipmap.background2);
        float yellowX = 4.5f;
        //redButton = new TouchButton(1, 14, 1);
        //yellowButton = new TouchButton(yellowX, 14, 2);
        //blueButton = new TouchButton(8, 14, 3);
    }
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
        if (backgroundImage != null) {
            srcRect.set(0, 0, backgroundImage.getWidth(), backgroundImage.getHeight());
            dstRect.set(0, 0, getWidth(), getHeight());
            canvas.drawBitmap(backgroundImage, srcRect, dstRect, null);
        }
        canvas.save();
        canvas.translate(transformOffset.x, transformOffset.y);
        canvas.scale(transformScale, transformScale);

        redButton.draw(canvas);
        yellowButton.draw(canvas);
        blueButton.draw(canvas);

        canvas.restore();
    }


}
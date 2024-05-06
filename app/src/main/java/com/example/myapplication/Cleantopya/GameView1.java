package com.example.myapplication.Cleantopya;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.myapplication.Cleantopya.game.TouchButton;
import com.example.myapplication.R;

/**
 * TODO: document your custom view class.
 */
public class GameView1 extends View {
  public static final String CUSTOM_ACTION = "com.example.myapplication.CUSTOM_ACTION";
  TouchButton redButton;
  TouchButton yellowButton;
  TouchButton blueButton;
  private Bitmap backgroundImage;
  private Bitmap cushionImage;

  Rect srcRect = new Rect();
  RectF dstRect = new RectF();

  int count;
  int randomGoalCount = (int)(Math.random()*10)+10;

    public GameView1(Context context) {
        super(context);
        init(null, 0);
    }

    public GameView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public GameView1(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        backgroundImage = BitmapFactory.decodeResource(getResources(), R.mipmap.background);
        cushionImage = BitmapFactory.decodeResource(getResources(), R.mipmap.cushion);
        float yellowX = 4.5f;
        //redButton = new TouchButton(1, 14);
        //yellowButton = new TouchButton(yellowX, 14);
        //blueButton = new TouchButton(8, 14);
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

    RectF tempRect = new RectF(1.f, 4.f, 8.f, 11.f);

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

        if(cushionImage != null){
            canvas.drawBitmap(cushionImage, null, tempRect, null);
        }

        redButton.draw(canvas);
        yellowButton.draw(canvas);
        blueButton.draw(canvas);

       canvas.restore();
    }

    public boolean onTouchEvent(MotionEvent event) { //view에서 touch를 처리하는 방법
        float redX = event.getX()/60;
        float redY = event.getY()/66;
        float blueX = event.getX()/82;
        float blueY = event.getY()/64;
        float yellowX = event.getX()/87;
        float yellowY = event.getY()/65;
        //이 변수들을 실제 휴대폰 좌표로 전환해주어야함.
        if(event.getAction() == MotionEvent.ACTION_DOWN){ //손가락이 닿았을때
            if(count<randomGoalCount) {
                if (redButton.isClicked(redX, redY)) {
                    count++;
                }
                if (blueButton.isClicked(blueX, blueY)) {
                    count++;
                }
                Log.d("onTouchEvent", "count"+count);
            }
            else {
                Log.d("onTouchEvent", "count is End" + count);
                if(yellowButton.isClicked(yellowX, yellowY)){
                    getContext().sendBroadcast(new Intent(CUSTOM_ACTION));
                }
            }
        }
        return true; //뭐하지
    }



}
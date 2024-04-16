package com.example.myapplication;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;

public class TouchButton {
    //touch 영역
    float x;
    float y;
    Paint paint;
    int count=0;

    //생성자
    public TouchButton(float x, float y, int color){

        paint = new Paint();
        if(color==1) {
            paint.setColor(Color.parseColor("#F91D00"));
        }
        else if(color==2){
            paint.setColor(Color.parseColor("#FFD800"));
        }
        else if(color==3){
            paint.setColor(Color.parseColor("#0070E8"));
        }
        paint.setStyle(Paint.Style.FILL);
        this.x = x;
        this.y = y;
    }

    public void Draw(Canvas canvas){
        canvas.drawCircle(x, y, 1.5f, paint);
    }

    public boolean isClicked(float touchX, float touchY) {
        //Log.d("isClicked", "touchX:"+touchX + "touchY:"+touchY);
        //Log.d("isClicked", "x:"+this.x + "y:"+y);
        if (touchX < this.x + 1.5f && touchX > this.x - 1.5f) {
            if (touchY < this.y + 1.5f && touchY > this.y - 1.5f) {
                return true;
            }
            else return false;
        }
        return false;
    }

    public void Clicked(){
        //버튼이 눌렸을때
        count+=1;
    }

    public int getCount() {
        return count;
    }
}

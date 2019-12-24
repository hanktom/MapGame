package com.fju.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class GameView extends View {
    private float posX, posY = 400;

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("Game", "onDraw: " + getWidth() + "," + getHeight());
        Paint paint = new Paint();
        Paint paint0 = new Paint();
        paint0.setColor(0);
        canvas.drawLine(400,0, 0,600, paint);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.monkey);
        canvas.drawBitmap(bitmap, posX, posY, paint);
//        for (int i=0; i<getHeight()-bitmap.getHeight(); i+=50) {
//            canvas.drawBitmap(bitmap, 400, 300+i, paint);
//        }
    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        if (posX > 0 && posX < getWidth()-100) {
            this.posX = posX;
        }
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }
}

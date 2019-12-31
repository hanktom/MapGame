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
    Monkey monkey;
    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (monkey == null) {
            monkey = new Monkey(this);
        }
        Log.d("Game", "onDraw: " + getWidth() + "," + getHeight());
        Paint paint = new Paint();
        Paint paint0 = new Paint();
        paint0.setColor(0);
//        canvas.drawLine(400,0, 0,600, paint);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.monkey);
        canvas.drawBitmap(bitmap, monkey.getX(), monkey.getY(), paint);
//        for (int i=0; i<getHeight()-bitmap.getHeight(); i+=50) {
//            canvas.drawBitmap(bitmap, 400, 300+i, paint);
//        }
    }
    public void moveDown() {
        if (monkey.getY() < getHeight()-150) {
            monkey.setDirection(Monkey.DIRECTION_DOWN);
            invalidate();
        }
    }
    public void moveUp() {
        if (monkey.getY() > 50) {
            monkey.setDirection(Monkey.DIRECTION_UP);
            invalidate();
        }
    }
    public void moveRight() {
        if (monkey.getX() < getWidth()-150) {
            monkey.setDirection(Monkey.DIRECTION_RIGHT);
            invalidate();
        }
    }

    public void moveLeft() {
        if (monkey.getX() > 50) {
            monkey.setDirection(Monkey.DIRECTION_LEFT);
            invalidate();
        }
    }

}

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
    private Monkey monkey;
    private Bitmap bitmapMonkey;
    private Bitmap bitmapMonekyNG;
    private Paint paint = new Paint();

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (monkey == null) {
            monkey = new Monkey(this);
            bitmapMonkey = BitmapFactory.decodeResource(getResources(), R.drawable.monkey);
            bitmapMonekyNG = BitmapFactory.decodeResource(getResources(), R.drawable.monkey_ng);
        }
        Log.d("Game", "onDraw: " + getWidth() + "," + getHeight());
        if (monkey.getDirection() == Monkey.DIRECTION_NG) {
            bitmapMonkey = bitmapMonekyNG;
        }
        canvas.drawBitmap(bitmapMonkey, monkey.getX(), monkey.getY(), paint);
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

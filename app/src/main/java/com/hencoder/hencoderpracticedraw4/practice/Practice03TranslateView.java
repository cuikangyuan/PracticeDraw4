package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice03TranslateView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);

    public Practice03TranslateView(Context context) {
        super(context);
    }

    public Practice03TranslateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice03TranslateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(100, 100);//画布原点位置移动
        //canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.drawBitmap(bitmap, 0, 0, paint);
        canvas.restore();

        canvas.save();
        //canvas.translate(100, 100);
        //canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();

        Matrix matrix1 = new Matrix();
        Log.d("Matrix", "操作前 " + matrix1.toShortString());

        matrix1.preTranslate(100, 100);
        matrix1.preRotate(45);
        Log.d("Matrix", "pre操作 " + matrix1.toShortString());

        Matrix matrix2 = new Matrix();
        matrix2.postRotate(45);
        matrix2.postTranslate(100, 100);
        Log.d("Matrix", "post操作 " + matrix2.toShortString());

        /*
        设原始矩阵为 M，平移为 T ，旋转为 R ，单位矩阵为 I ，最终结果为 M’

        矩阵乘法不满足交换律，即 A*B ≠ B*A
        矩阵乘法满足结合律，即 (A*B)*C = A*(B*C)
        矩阵与单位矩阵相乘结果不变，即 A * I = A

        不要去管什么先后论，顺序论，就按照最基本的矩阵乘法理解。
        pre  : 右乘， M‘ = M*A
        post : 左乘， M’ = A*M

         */


    }
}
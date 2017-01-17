package com.example.lmy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by limengying on 2017/1/14.
 */

public class ShaderTextView extends TextView {
    int mViewWidth = 0;
    float mTranslate = 0;
    Paint mPaint;
    LinearGradient mLinearGradient;
    Matrix mGradientMatrix;

    public ShaderTextView(Context context) {
        super(context);
    }

    public ShaderTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ShaderTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    public ShaderTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if(mViewWidth == 0) {
            mViewWidth = getMeasuredWidth();
            if(mViewWidth >0){
                mPaint = getPaint();
                mLinearGradient = new LinearGradient(0,0,mViewWidth,0,new int[]{Color.BLUE,0xffffff,Color.BLUE},null, Shader.TileMode.CLAMP);
                mPaint.setShader(mLinearGradient);
                mGradientMatrix = new Matrix();
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(mGradientMatrix !=null) {
            mTranslate += mViewWidth/5;
            if(mTranslate>2*mViewWidth) {
                mTranslate-=mViewWidth;
            }
            mGradientMatrix.setTranslate(mTranslate,0);
            mLinearGradient.setLocalMatrix(mGradientMatrix);
            postInvalidateDelayed(100);
        }
    }
}

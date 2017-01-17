package com.example.lmy.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.example.lmy.view.AudioBarView;
import com.example.lmy.view.BackgroundTextView;
import com.example.lmy.view.ExpandArcView;
import com.example.lmy.view.ExpandScrollView;
import com.example.lmy.view.ShaderTextView;

import butterknife.BindDrawable;

/**
 * Created by limengying on 2017/1/17.
 */

public class TestViewActivity extends Activity {
    private String mViewTag = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!isIntentAvailable(getIntent())) {
            finish();
        } else {
            showView();
        }

    }

    public boolean isIntentAvailable(Intent intent) {
        if (intent == null) {
            return false;
        }
        String viewTag = intent.getStringExtra(Constants.VIEW_TAG);
        if (TextUtils.isEmpty(viewTag)) {
            return false;
        }
        mViewTag = viewTag;
        return true;
    }

    public void showView() {
        setTitle(mViewTag);
        setContentView(R.layout.test_view);
        LinearLayout ll = (LinearLayout) findViewById(R.id.view_object);
        ll.removeAllViews();
        if (AudioBarView.class.getSimpleName().equals(mViewTag)) {
            AudioBarView audioBar = new AudioBarView(this);
            ll.addView(audioBar);
        } else if (BackgroundTextView.class.getSimpleName().equals(mViewTag)) {
            BackgroundTextView backgroundTextView = new BackgroundTextView(this);
            backgroundTextView.setTextSize(36);
            backgroundTextView.setText("hello!");
            backgroundTextView.setTextColor(Color.BLUE);
            ll.addView(backgroundTextView);
        } else if (ExpandArcView.class.getSimpleName().equals(mViewTag)) {
            ExpandArcView expandArcView = new ExpandArcView(this);
            ll.addView(expandArcView);
        } else if (ExpandScrollView.class.getSimpleName().equals(mViewTag)) {
            ExpandScrollView expandScrollView = new ExpandScrollView(this);
            ImageView imageView1 = new ImageView(this);
            imageView1.setImageDrawable(getDrawable(R.drawable.test1));
            ImageView imageView2 = new ImageView(this);
            imageView2.setImageDrawable(getDrawable(R.drawable.test2));
            ImageView imageView3 = new ImageView(this);
            imageView3.setImageDrawable(getDrawable(R.drawable.test3));
            ImageView imageView4 = new ImageView(this);
            imageView4.setImageDrawable(getDrawable(R.drawable.test4));
            expandScrollView.addView(imageView1);
            expandScrollView.addView(imageView2);
            expandScrollView.addView(imageView3);
            expandScrollView.addView(imageView4);
            ll.addView(expandScrollView);
        } else if(ShaderTextView.class.getSimpleName().equals(mViewTag)) {
            ShaderTextView shaderTextView = new ShaderTextView(this);
            shaderTextView.setText("Hello World!");
            shaderTextView.setTextSize(36);
            ll.addView(shaderTextView);
        }
    }
}

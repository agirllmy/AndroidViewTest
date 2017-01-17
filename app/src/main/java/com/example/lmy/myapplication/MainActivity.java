package com.example.lmy.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.lmy.view.AudioBarView;
import com.example.lmy.view.BackgroundTextView;
import com.example.lmy.view.ExpandArcView;
import com.example.lmy.view.ExpandScrollView;
import com.example.lmy.view.ShaderTextView;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class MainActivity extends Activity {
    private Unbinder unBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unBinder = ButterKnife.bind(this);
    }

    @OnClick(R.id.recycler_view)
    public void onClickRecyclerView() {
        Intent intent = new Intent(this, RecyclerViewTestActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.audio_bar_view)
    public void onClickAudioBarView() {
        Intent intent = new Intent();
        intent.putExtra(Constants.VIEW_TAG, AudioBarView.class.getSimpleName());
        intent.setClass(this, TestViewActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.backgrount_text_view)
    public void onClickBackgroundTextView() {
        Intent intent = new Intent();
        intent.putExtra(Constants.VIEW_TAG, BackgroundTextView.class.getSimpleName());
        intent.setClass(this, TestViewActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.expand_ard_view)
    public void onClickExpandAcrView() {
        Intent intent = new Intent();
        intent.putExtra(Constants.VIEW_TAG, ExpandArcView.class.getSimpleName());
        intent.setClass(this, TestViewActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.exprandScrollView)
    public void onClickExprandScrollView() {
        Intent intent = new Intent();
        intent.putExtra(Constants.VIEW_TAG, ExpandScrollView.class.getSimpleName());
        intent.setClass(this, TestViewActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.shader_text_view)
    public void onClickShaderTextView() {
        Log.e("wlaimm", "onClcikAudioBarView");
        Intent intent = new Intent();
        intent.putExtra(Constants.VIEW_TAG, ShaderTextView.class.getSimpleName());
        intent.setClass(this, TestViewActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unBinder.unbind();
    }
}

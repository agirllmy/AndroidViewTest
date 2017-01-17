package com.example.lmy.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by limengying on 2017/1/17.
 */

public class RecyclerViewTestActivity extends Activity{RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this)); // 类似ListView
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2)); // 类似GridView
//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, OrientationHelper.VERTICAL)); // 类似于瀑布流
        mRecyclerView.setAdapter(new NormalRecyclerViewAdapter(this));
    }

    public class NormalRecyclerViewAdapter extends RecyclerView.Adapter<NormalRecyclerViewAdapter.NormalTextViewHolder> {
        private final LayoutInflater mLayoutInflater;
        private final Context mContext;
        private String[] mTitles;

        public NormalRecyclerViewAdapter(Context context) {
            mTitles = context.getResources().getStringArray(R.array.CodingLanguage);
            mContext = context;
            mLayoutInflater = LayoutInflater.from(context);
        }


        @Override
        public RecyclerViewTestActivity.NormalRecyclerViewAdapter.NormalTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new NormalRecyclerViewAdapter.NormalTextViewHolder(mLayoutInflater.inflate(R.layout.recycler_view_item, parent, false));
        }

        @Override
        public void onBindViewHolder(NormalRecyclerViewAdapter.NormalTextViewHolder holder, int position) {
            holder.mTextView.setText(mTitles[position]);
        }

        @Override
        public int getItemCount() {
            return mTitles == null ? 0 : mTitles.length;
        }
        public class NormalTextViewHolder extends RecyclerView.ViewHolder {
            TextView mTextView;

            public NormalTextViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(itemView);
                mTextView = (TextView) itemView.findViewById(R.id.text_view);
            }
        }
    }
}

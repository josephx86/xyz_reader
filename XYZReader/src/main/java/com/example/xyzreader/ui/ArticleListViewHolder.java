package com.example.xyzreader.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.xyzreader.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticleListViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.thumbnail)
    DynamicHeightNetworkImageView thumbnailView;

    @BindView(R.id.article_title)
    TextView titleView;

    @BindView(R.id.article_subtitle)
    TextView subtitleView;

    ArticleListViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
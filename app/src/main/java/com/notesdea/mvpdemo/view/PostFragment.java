package com.notesdea.mvpdemo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.notesdea.mvpdemo.R;
import com.notesdea.mvpdemo.presenter.PostPresenter;


public class PostFragment extends Fragment implements IPostView {

    private static final String TAG = PostFragment.class.getSimpleName();

    private static String ARG_POST_ID = "arg_post_id";
    //标题文本
    private TextView mTextTitle;
    //内容文本
    private TextView mTextContent;

    private PostPresenter mPresenter;
    private int mId;

    public PostFragment() {
    }


    public static PostFragment newInstance(int id) {
        PostFragment fragment = new PostFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POST_ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_post, container, false);
        mTextTitle = (TextView) root.findViewById(R.id.text_title);
        mTextContent = (TextView) root.findViewById(R.id.text_content);
        mPresenter = new PostPresenter(this);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //获取博客id,开始View的操作
        mId = getArguments().getInt(ARG_POST_ID);
        mPresenter.start(mId);

    }

    @Override
    public void showLoading() {
        Log.d(TAG, "showLoading");
    }

    @Override
    public void hideLoading() {
        Log.d(TAG, "hideLoading");
    }

    @Override
    public void showTitle(String title) {
        mTextTitle.setText(title);
    }

    @Override
    public void showContent(String content) {
        mTextContent.setText(content);
    }
}

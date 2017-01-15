package com.notesdea.mvpdemo.presenter;

import android.os.Handler;

import com.notesdea.mvpdemo.data.Mock;
import com.notesdea.mvpdemo.model.Post;
import com.notesdea.mvpdemo.view.IPostView;

/**
 * Created by notesdea on 1/14/17.
 */

public class PostPresenter implements IPostPresenter {

    private IPostView mPostView;
    private Post mPost;
    private Mock mMock;

    public PostPresenter(IPostView view) {
        mPostView = view;
    }

    public void start(int id) {
        mPostView.showLoading();
        //todo 需要修改成网络请求
        mMock = new Mock();
        mPost = new Post();
        mPost.setTitle(mMock.getTitle());
        mPost.setContent(mMock.getContent());
        mPostView.hideLoading();
        showPost();
    }

    @Override
    public void showPost() {
        if (mPost != null) {
            mPostView.showTitle(mPost.getTitle());
            mPostView.showContent(mPost.getContent());
        }
    }
}

package com.notesdea.mvpdemo.presenter;

import android.os.Handler;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.notesdea.mvpdemo.data.HttpCallback;
import com.notesdea.mvpdemo.data.Mock;
import com.notesdea.mvpdemo.data.NotesdeaClient;
import com.notesdea.mvpdemo.model.Post;
import com.notesdea.mvpdemo.view.IPostView;

/**
 * Created by notesdea on 1/14/17.
 */

public class PostPresenter implements IPostPresenter {

    private IPostView mPostView;
    private Post mPost;

    public PostPresenter(IPostView view) {
        mPostView = view;
    }

    public void start(int id) {
        mPostView.showLoading();
        NotesdeaClient.get("/api/get_posts/?page=" + id, new HttpCallback() {
            @Override
            public void mock(Mock mock) {
                if (mock != null) {
                    mPost = new Post();
                    mPost.setTitle(mock.getTitle());
                    mPost.setContent(mock.getContent());

                    showPost();
                    mPostView.hideLoading();
                }
            }
        });
    }

    @Override
    public void showPost() {
        if (mPost != null) {
            mPostView.showTitle(mPost.getTitle());
            mPostView.showContent(mPost.getContent());
        }
    }
}

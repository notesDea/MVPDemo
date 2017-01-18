package com.notesdea.mvpdemo.presenter;

import android.util.Log;

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

    private static final String TAG = PostPresenter.class.getSimpleName();

    private IPostView mPostView;
    private Post mPost;

    public PostPresenter(IPostView view) {
        mPostView = view;
    }

    public void start(int id) {
        mPostView.showLoading();
        HttpCallback callback = new HttpCallback() {
            @Override
            public void ok(String response) {
                super.ok(response);
                Log.d(TAG, "ok: " + response);
            }

            @Override
            public void mock(String mock) {
                Log.d(TAG, "mock called");
                if (mock != null) {
                    mPost = new Gson().fromJson(mock, Post.class);//todo 写好这个，再检查Post类是否正确
                    showPost();
                    mPostView.hideLoading();
                }
            }
        };
        callback.setMock(new Mock().toString());
        NotesdeaClient.get("/api/get_posts/?page=1", callback);
    }

    @Override
    public void showPost() {
        if (mPost != null) {
            mPostView.showTitle(mPost.getTitle());
            mPostView.showContent(mPost.getContent());
        }
    }
}

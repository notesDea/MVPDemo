package com.notesdea.mvpdemo.view;

/**
 * Created by notesdea on 1/14/17.
 */

public class PostPresenter implements IPostPresenter {

    private IPostView mView;

    public PostPresenter(IPostView view) {
        mView = view;
        //todo add start() method and etc...
    }

    @Override
    public void showPost() {

    }
}

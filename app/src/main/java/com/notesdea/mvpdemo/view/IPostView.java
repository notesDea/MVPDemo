package com.notesdea.mvpdemo.view;

/**
 * Created by notesdea on 1/14/17.
 */

public interface IPostView {

    //显示进度条
    void showLoading();

    //隐藏进度条
    void hideLoading();

    //显示标题
    void showTitle(String title);

    //显示内容
    void showContent(String content);
}

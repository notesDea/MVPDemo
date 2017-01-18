package com.notesdea.mvpdemo.view;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.notesdea.mvpdemo.R;

public class PostActivity extends AppCompatActivity {

    public final static String EXTRA_POST_ID = "post_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        int postId = getIntent().getIntExtra(EXTRA_POST_ID, 0);
        PostFragment fragment = PostFragment.newInstance(postId);
        transaction.add(R.id.layout_main_fragment_container, fragment).
                commit();
    }
}

package com.notesdea.mvpdemo.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.notesdea.mvpdemo.R;

public class MainActivity extends AppCompatActivity {

    private final static String POST_ID = "post_id";
    private Button btnPostAty;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        initView();
        initListener();
    }

    private void initView() {
        btnPostAty = (Button) findViewById(R.id.btn_post_activity);
    }

    private void initListener() {
        btnPostAty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PostActivity.class);
                intent.putExtra(PostActivity.EXTRA_POST_ID, 1);
                startActivity(intent);
            }
        });
    }

}

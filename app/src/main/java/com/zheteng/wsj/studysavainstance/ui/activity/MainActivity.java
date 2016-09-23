package com.zheteng.wsj.studysavainstance.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.zheteng.wsj.studysavainstance.R;
import com.zheteng.wsj.studysavainstance.ui.fragment.LeftFragment;
import com.zheteng.wsj.studysavainstance.ui.fragment.RightFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    private static final String LEFT_FRGMENT = "left_frgment";
    private static final String RIGHT_FRGMENT = "right_frgment";

    @Bind(R.id.left_frame)
    FrameLayout mLeftFrame;
    @Bind(R.id.right_frame)
    FrameLayout mRightFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initFragment();

    }

    private void initFragment() {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.right_frame,new RightFragment(),RIGHT_FRGMENT);
        transaction.replace(R.id.left_frame,new LeftFragment(),LEFT_FRGMENT);
        transaction.commit();
    }
}

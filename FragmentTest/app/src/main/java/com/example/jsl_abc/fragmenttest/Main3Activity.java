package com.example.jsl_abc.fragmenttest;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static com.example.jsl_abc.fragmenttest.R.id.btn4;

public class Main3Activity extends FragmentActivity  implements LeftFragment.showPro, View.OnClickListener{

    private ContentFragment mContentFragment ;

    private LocalReceiver mReceiver;

    @Override
    public void showProByName(String name) {
        System.out.print(name);
        Toast.makeText(getApplicationContext(), name, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.w_linearlayout);

        Button button = (Button) findViewById(btn4);
        button.setOnClickListener(this);

//        FragmentManager fm = getSupportFragmentManager();
//        mContentFragment = (ContentFragment) fm.findFragmentById(R.id.id_fragment_title);
//
//        if(mContentFragment == null )
//        {
//            mContentFragment = new ContentFragment();
//            fm.beginTransaction().add(R.id.id_fragment_title,mContentFragment).commit();
//        }

        //接收广播
        try {
            IntentFilter filter = new IntentFilter();
            filter.addAction("fragment_home_left");
            mReceiver = new LocalReceiver();
            BroadCastManager.getInstance().registerReceiver(this,
                    mReceiver, filter);//注册广播接收者
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    class LocalReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            //收到广播后的处理
            String orderid = intent.getStringExtra("order");
            loadData(orderid);
        }
    }

    //实例方法，内部调用的方法
    private void loadData(String orderid){
        System.out.print(orderid);
        Toast.makeText(getApplicationContext(),orderid,Toast.LENGTH_LONG).show();
    }

    /**
     * Destroy all fragments and loaders.
     */
    @Override
    protected void onDestroy() {
        BroadCastManager.getInstance().unregisterReceiver(this,mReceiver);
        super.onDestroy();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case btn4:
                AnotherRightFragment fragment = new AnotherRightFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = fragmentManager. beginTransaction();
                transaction.replace(R.id.right_layout, fragment);
                //模拟返回栈
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            default:
                break;
        }
    }
}

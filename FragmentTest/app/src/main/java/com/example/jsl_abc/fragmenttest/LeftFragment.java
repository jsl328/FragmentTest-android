package com.example.jsl_abc.fragmenttest;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by JSL_ABC on 2017/11/16.
 */

public  class LeftFragment extends Fragment {

    //定义一个接口，实现与activity的数据共享
    public  interface showPro {
        public void showProByName(String name);
    }

    private showPro mCallback;
    private static  final  int a =1001;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.left_fragment, container, false);
        return view;
    }


    private static final String TAG = "LeftFragment";
    @Override
    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        Log.i (TAG, "==onInflate()执行了");
        super.onInflate(activity, attrs, savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        Log.i (TAG, "==onAttach()执行了");
        super.onAttach(activity);

        // 这是为了保证Activity容器实现了用以回调的接口。如果没有，它会抛出一个异常。
        try {
            // 实例化接口
            mCallback = (showPro) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement showPro");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i (TAG, "==onCreate()执行了");
        super.onCreate(savedInstanceState);
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
//        Log.i (TAG, "==onCreateView()执行了");
//        // inflater.inflate(resource, null);
//        return inflater.inflate(R.layout.fragment_left, container, false);
//    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Log.i (TAG, "==onViewCreated()执行了");
        super.onViewCreated(view, savedInstanceState);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.i (TAG, "==onActivityCreated()执行了");
        super.onActivityCreated(savedInstanceState);

        final Button button = (Button) getActivity().findViewById(R.id.btn4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn4 = (Button) getActivity().findViewById(R.id.btn2);
//                if (mCallback!=null){
//                    mCallback.showProByName("从fregment 到Activity的接口方式");
//                }else {
//                    Toast.makeText(getActivity(), btn4.getText(), Toast.LENGTH_LONG).show();
//                }

                //使用广播方式实现两个fragment 之间的通信
                //发送广播
                Intent intent = new Intent();
                intent.putExtra("order", btn4.getText());
                intent.setAction("fragment_home_left");
                BroadCastManager.getInstance().sendBroadCast(getActivity(), intent);
            }
        });
    }

    @Override
    public void onStart() {
        Log.i (TAG, "==onStart()执行了");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.i (TAG, "==onResume()执行了");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i (TAG, "==onPause()执行了");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i (TAG, "==onStop()执行了");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.i (TAG, "==onDestroyView()执行了");
        super.onDestroyView();
    }
    @Override
    public void onDestroy() {
        Log.i (TAG, "==onDestroy()执行了");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.i (TAG, "==onDetach()执行了");
        super.onDetach();
    }

}

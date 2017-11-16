package com.example.jsl_abc.fragmenttest;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by JSL_ABC on 2017/11/16.
 */

public class ContentFragment extends Fragment {
    private String mArgument;
    public static final String ARGUMENT = "argument";

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // mArgument = getActivity().getIntent().getStringExtra(ARGUMENT);
        Bundle bundle = getArguments();
        if (bundle != null)
            mArgument = bundle.getString(ARGUMENT);
    }

    /**
     * 传入需要的参数，设置给arguments
     * @param argument
     * @return
     */
    public static ContentFragment newInstance(String argument)
    {
        Bundle bundle = new Bundle();
        bundle.putString(ARGUMENT, argument);
        ContentFragment contentFragment = new ContentFragment();
        contentFragment.setArguments(bundle);
        return contentFragment;
    }

    public void doSomething(String param) {
        // do something in fragment
        System.out.print(param);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        System.out.print("hello");
        return inflater.inflate(R.layout.contentlayout, container, false);
    }
}

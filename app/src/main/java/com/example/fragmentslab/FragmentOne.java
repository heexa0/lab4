package com.example.fragmentslab;

import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class FragmentOne extends Fragment {

    private TextView tv;
    private Button btnHello;

    public FragmentOne() {
        super(R.layout.fragment_one);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        tv = view.findViewById(R.id.textOne);
        btnHello = view.findViewById(R.id.btnHello);

        btnHello.setOnClickListener(v ->
                tv.setText("Bonjour depuis Fragment 1 !"));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        tv = null;
        btnHello = null;
    }
}
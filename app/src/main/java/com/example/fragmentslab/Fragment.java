package com.example.fragmentslab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class Fragment extends AppCompatActivity {

    private Button btn1, btn2;

    private static final String TAG_F1 = "FRAGMENT_1";
    private static final String TAG_F2 = "FRAGMENT_2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btnFragment1);
        btn2 = findViewById(R.id.btnFragment2);

        // Chargement initial
        if (savedInstanceState == null) {
            loadFragment(new FragmentOne(), TAG_F1, false);
        }

        btn1.setOnClickListener(v -> loadFragment(new FragmentOne(), TAG_F1, true));
        btn2.setOnClickListener(v -> loadFragment(new FragmentTwo(), TAG_F2, true));
    }

    private void loadFragment(androidx.fragment.app.Fragment fragment, String tag, boolean addToBackStack) {

        // Vérifier si le fragment est déjà affiché
        androidx.fragment.app.Fragment current = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (current != null && current.getClass().equals(fragment.getClass())) {
            return; // éviter reload inutile
        }

        var transaction = getSupportFragmentManager()
                .beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragment_container, fragment, tag);

        if (addToBackStack) {
            transaction.addToBackStack(tag);
        }

        transaction.commit();
    }
}
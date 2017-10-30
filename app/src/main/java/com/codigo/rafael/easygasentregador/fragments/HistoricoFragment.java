package com.codigo.rafael.easygasentregador.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.codigo.rafael.easygasentregador.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoricoFragment extends Fragment {


    public HistoricoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_historico, container, false);


        BottomNavigationView navigation = view.findViewById(R.id.navigation_main);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        return view;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {


            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Toast.makeText(getContext(), "Andamento", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.navigation_dashboard:
                    Toast.makeText(getContext(), "Concluídos", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.navigation_notifications:
                    Toast.makeText(getContext(), "Cancelados", Toast.LENGTH_SHORT).show();
                    return true;

            }
            return false;
        }

    };


}

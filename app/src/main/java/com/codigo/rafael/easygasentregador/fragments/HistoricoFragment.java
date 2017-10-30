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

    private Fragment frag;

    public HistoricoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_historico, container, false);

        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();

        BottomNavigationView navigation = view.findViewById(R.id.navigation_main);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        frag = getParentFragment();
        if (frag == null) {

            frag = new PedidoPendenteFragment();
            ft.replace(R.id.rl_container_fragment_historico, frag);
            ft.addToBackStack(null);
            ft.commit();
        }

        return view;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();

            switch (item.getItemId()) {
                case R.id.navigation_andamento:
                    frag = new PedidoPendenteFragment();
                    ft.replace(R.id.rl_container_fragment_historico, frag);
                    ft.addToBackStack(null);
                    ft.commit();
                    Toast.makeText(getContext(), "Andamento", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.navigation_concluido:
                    frag = new PedidoConcluidoFragment();
                    ft.replace(R.id.rl_container_fragment_historico, frag);
                    ft.addToBackStack(null);
                    ft.commit();
                    Toast.makeText(getContext(), "Concluídos", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.navigation_cancelado:
                    frag = new PedidoCanceladoFragment();
                    ft.replace(R.id.rl_container_fragment_historico, frag);
                    ft.addToBackStack(null);
                    ft.commit();
                    Toast.makeText(getContext(), "Cancelados", Toast.LENGTH_SHORT).show();
                    return true;

            }
            return false;
        }

    };


}

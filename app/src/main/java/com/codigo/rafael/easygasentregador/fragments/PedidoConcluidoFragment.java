package com.codigo.rafael.easygasentregador.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codigo.rafael.easygasentregador.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PedidoConcluidoFragment extends Fragment {


    public PedidoConcluidoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pedido_concluido, container, false);
    }

}

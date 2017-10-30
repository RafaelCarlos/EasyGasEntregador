package com.codigo.rafael.easygasentregador.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


import com.codigo.rafael.easygasentregador.R;
import com.codigo.rafael.easygasentregador.adapters.MenuAdapter;
import com.codigo.rafael.easygasentregador.entities.Menu;

import java.io.Serializable;
import java.util.ArrayList;


public class MenuFragment extends Fragment {
    public MenuFragment() {
        // Required empty public constructor
    }

    private ListView mListView;
    int posicaoAtual = 0;
    private TextView tvTitulo, tvValor, tvDistancia, tvBairro;
    private ImageView ivCar, ivShoppingCar;
    private RatingBar rBarAvaliacao;
    private ArrayList<Menu> listaMenu;
    private Button btCar;
    private Menu menu;
    private Bundle bundle;
    private Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        intent = new Intent();
        mListView = view.findViewById(R.id.lv_menu_fragment);
        listaMenu = new ArrayList<>();

        listaMenu.add(new Menu("Rafael Carlos", "405 Norte - Plano Diretor Norte", 3.5, R.mipmap.ic_car, "Valor do Pedido: R$ 85,00"));
        listaMenu.add(new Menu("Joãzinho Silva", "101 Sul - Plano Diretor Sul", 1.2, R.mipmap.ic_car, "Valor do Pedido: R$ 82,00"));

        listaMenu.add(new Menu("Mateus Pereira", "305 Norte - Plano Diretor Norte", 6.5, R.mipmap.ic_car, "Valor do Pedido: R$ 80,00"));

        MenuAdapter menuAdapter = new MenuAdapter(getActivity(), listaMenu);

//        mListView.setDivider(getResources().getDrawable(R.color.colorAccent));
        mListView.setAdapter(menuAdapter);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                bundle = new Bundle();
//                menu = (Menu) mListView.getItemAtPosition(i);
//                intent = new Intent(getActivity(), DistribuidorActivity.class);
//                bundle.putSerializable("menu", (Serializable) menu);
//                intent.putExtras(bundle);
//
//                startActivity(intent);

                Toast.makeText(getActivity(), "Você escolheu a distribuidora: " + listaMenu.get(i).getTitulo(), Toast.LENGTH_LONG).show();
//                if (i == 0) {
//
////                    listaMenu.get(i);
//                } else if (i == 1) {
//                    Toast.makeText(getActivity(), "Você escolhe a distribuidora: " + listaMenu.get(i).getTitulo(), Toast.LENGTH_LONG).show();
//                } else {
//                    Toast.makeText(getActivity(), "Você escolhe a distribuidora: " + listaMenu.get(i).getTitulo(), Toast.LENGTH_LONG).show();
//                }
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}

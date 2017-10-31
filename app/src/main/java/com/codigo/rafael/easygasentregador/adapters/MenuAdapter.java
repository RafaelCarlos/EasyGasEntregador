package com.codigo.rafael.easygasentregador.adapters;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codigo.rafael.easygasentregador.R;
import com.codigo.rafael.easygasentregador.entities.Menu;

import java.util.List;

/**
 * Created by Rafael Carlos Oliveira on 02/10/2017.
 */

public class MenuAdapter extends ArrayAdapter<Menu> {
    private Context context;
    private List<Menu> lista;
    private LayoutInflater inflater;
    private float scale;
    private float width;
    private float height;

    public MenuAdapter(Context context, List<Menu> lista) {
        super(context, 0, lista);
        this.context = context;
        this.lista = lista;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        scale = context.getResources().getDisplayMetrics().density;
        width = context.getResources().getDisplayMetrics().widthPixels - (int) (14 * scale + 0.5f);
        height = (width / 16) * 9;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_menu_fragment, null);
        }


        TextView tvTitulo = convertView.findViewById(R.id.tv_titulo_nome_cliente_activity);
        tvTitulo.setText(lista.get(position).getTitulo());

        TextView tvBairro = convertView.findViewById(R.id.tv_bairro_cliente_menu_fragment);
        tvBairro.setText(lista.get(position).getBairro());

        TextView tvDistancia = convertView.findViewById(R.id.tv_distancia_cliente_menu_fragment);
        tvDistancia.setText(String.valueOf(lista.get(position).getDistancia()) + " km");


        ImageView vrImageView = convertView.findViewById(R.id.iv_ic_car_cliente_menu_fragment);
        vrImageView.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), lista.get(position).getFoto()));


//        btCar.setText(lista.get(position).getBtCar());

        TextView tvValor = convertView.findViewById(R.id.tv_valor_cliente_menu_fragment);
        tvValor.setText(lista.get(position).getValor());





        return convertView;
    }
}

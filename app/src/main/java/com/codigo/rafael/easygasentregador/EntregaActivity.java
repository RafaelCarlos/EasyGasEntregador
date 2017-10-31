package com.codigo.rafael.easygasentregador;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.codigo.rafael.easygasentregador.entities.Menu;

public class EntregaActivity extends AppCompatActivity {

    private Menu menu;
    private TextView tvNomeCliente, tvEndereco, tvBairro, tvDistancia, tvTempo, tvValorPedido;
    private Toolbar tbEntrega;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrega);

        tvBairro = findViewById(R.id.tv_bairro_cliente_entrega_activity);
        tvNomeCliente = findViewById(R.id.tv_nome_cliente_entrega_activity);
        tvEndereco = findViewById(R.id.tv_endereco_cliente_entrega_activity);
        tvDistancia = findViewById(R.id.tv_distancia_cliente_entrega_activity);
        tvTempo = findViewById(R.id.tv_tempo_cliente_entrega_activity);
        tvValorPedido = findViewById(R.id.tv_valor_pedido_cliente_entrega_activity);
        tbEntrega = findViewById(R.id.tb_entrega_activity);
        setSupportActionBar(tbEntrega);


        tbEntrega.setTitle("Entrega");
        tbEntrega.setTitleTextColor(Color.WHITE);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        menu = (Menu) getIntent().getSerializableExtra("menu");


        tvNomeCliente.setText("Cliente: " + menu.getTitulo());
        tvEndereco.setText("Endereço: " + menu.getBairro());
        tvValorPedido.setText(menu.getValor());
        tvDistancia.setText("Distância: " + menu.getDistancia() + "km");

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}

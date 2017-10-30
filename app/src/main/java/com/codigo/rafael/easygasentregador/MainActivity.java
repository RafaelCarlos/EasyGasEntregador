package com.codigo.rafael.easygasentregador;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.codigo.rafael.easygasentregador.fragments.HistoricoFragment;
import com.codigo.rafael.easygasentregador.fragments.MenuFragment;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class MainActivity extends AppCompatActivity {

    private Drawer drawerMenu;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.tb_main_activity);

        setSupportActionBar(toolbar);

        toolbar.setTitle("Entregas");
        toolbar.setTitleTextColor(Color.WHITE);
        ProfileDrawerItem person = new ProfileDrawerItem();

        person.withName("Entregador1")
                .withIcon(getResources().getDrawable(R.mipmap.ic_user));

        Fragment frag = frag = getSupportFragmentManager().findFragmentByTag("mainFrag");

        if (frag == null) {
            frag = new MenuFragment();
            toolbar.setTitle("Distribuidoras");
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.rl_fragment_container, frag, "mainFrag");
            ft.commit();
        }


        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.color.colorTema)
                .addProfiles(
                        person
//                        new ProfileDrawerItem().withName(nome).withEmail(email)
//                                .withIcon(getDrawable(R.mipmap.ic_user))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();
        drawerMenu = new DrawerBuilder()
                .withActivity(this)
                .withDrawerGravity(Gravity.LEFT)
                .withSelectedItem(0)
                .withSavedInstance(savedInstanceState)
//                .withSliderBackgroundColor(getResources().getColor(R.color.colorFAB))
                .withToolbar(toolbar)
                .withActionBarDrawerToggle(true)
                .withActionBarDrawerToggleAnimated(true)
                .withAccountHeader(headerResult)
//                .addDrawerItems(item1, new DividerDrawerItem())
                .withFooterDivider(true)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        Fragment frag = null;

                        if (position == 1) {
                            frag = new MenuFragment();
                            Toast.makeText(getApplicationContext(), "Posicao: " + position, Toast.LENGTH_SHORT).show();
                            toolbar.setTitle("Entregas");
                            toolbar.setTitleTextColor(Color.WHITE);
                        } else if (position == 2) {
                            frag = new HistoricoFragment();
                            Toast.makeText(getApplicationContext(), "Posicao: " + position, Toast.LENGTH_SHORT).show();
                            toolbar.setTitle("Histórico");
                            toolbar.setTitleTextColor(Color.WHITE);
                        } else {
                            frag = new MenuFragment();
                        }

                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.rl_fragment_container, frag);
                        ft.addToBackStack(null);
                        ft.commit();


                        return false;
                    }
                })
                .build();

        drawerMenu.addItem(new PrimaryDrawerItem().withName("Entregas").withIcon(getResources().getDrawable(R.mipmap.ic_truck)));
        drawerMenu.addItem(new PrimaryDrawerItem().withName("Histórico").withIcon(getResources().getDrawable(R.mipmap.ic_historico)));

        drawerMenu.addStickyFooterItem(new PrimaryDrawerItem().withName("EasyGás desenvolvido por Rafael Oliveira"));

    }
}

package com.example.a53478.daynightdemo;


import android.content.ClipData;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity implements  Toolbar.OnMenuItemClickListener {
    private Toolbar toolBar;
    public static int model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolBar = findViewById(R.id.toolBar);
        initToolBar();
    }
    private void initToolBar() {
        toolBar.inflateMenu(R.menu.menu_main);
        toolBar.setTitle("首页");
        toolBar.setOverflowIcon(ContextCompat.getDrawable(this, R.drawable.ic_actionbar_menu_overflow));
        toolBar.setOnMenuItemClickListener(this);
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_switch_model:
                int mode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
                if (mode == Configuration.UI_MODE_NIGHT_YES) {
                    model = 0;
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                } else {
                    model = 1;
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                recreate();
                break;
            case R.id.action_config:
                Intent intent = new Intent();
                intent.setClass(this,WebviewActivity.class);
                this.startActivity(intent);
                break;
            default:
                break;

        }
        return false;
    }
}

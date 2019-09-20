package com.example.utsandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toolbar;

public class detailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        final TextView tvNamaDepan = (TextView) findViewById(R.id.tv_namadepan);
        final TextView tvNamaBelakang = (TextView) findViewById(R.id.tv_namabelakang);

        Intent i = getIntent();
        tvNamaDepan.setText(((Intent) i).getStringExtra("i_namaDepan"));
        tvNamaBelakang.setText(((Intent) i).getStringExtra("i_namaBelakang"));

        getSupportActionBar().setTitle("UTS ANDROID");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}

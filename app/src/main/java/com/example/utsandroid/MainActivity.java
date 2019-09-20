package com.example.utsandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    EditText etNamaDepan, etNamaBelakang, etAlamat, etTelepon;
    RadioGroup rgPilihan;
    RadioButton rbSMP, rbSMP1, rbMTS;
    Spinner spJenisKelamin;
    CheckBox cbDwidaya, cbDbs, cbMerah, cbSutarmadja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNamaDepan = (EditText) findViewById(R.id.et_namaDepan);
        etNamaBelakang = (EditText) findViewById(R.id.et_namaBelakang);
        etAlamat = (EditText) findViewById(R.id.et_alamat);
        etTelepon = (EditText) findViewById(R.id.et_telepon);
        rgPilihan = (RadioGroup) findViewById(R.id.rg_pilihan);
        rbSMP = (RadioButton) findViewById(R.id.rb_smp);
        rbSMP1 = (RadioButton) findViewById(R.id.rb_smp1);
        rbMTS = (RadioButton) findViewById(R.id.rb_mts);
        spJenisKelamin = (Spinner) findViewById(R.id.sp_jenisKelamin);
        cbDwidaya = (CheckBox) findViewById(R.id.cb_dwidaya);
        cbDbs = (CheckBox) findViewById(R.id.cb_dbs);
        cbMerah = (CheckBox) findViewById(R.id.cb_merahputih);
        cbSutarmadja = (CheckBox) findViewById(R.id.cb_sutarmadja);

        final RadioButton rbSMP = (RadioButton) findViewById(R.id.rb_smp);
        rbSMP.setChecked(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mn_simpan:
                String nama_depan, nama_belakang, alamat, telepon, pilihan, jenis_kelamin, sekolah;
                boolean dwidaya, dbs, merah, sutarmadja;

                nama_depan = etNamaDepan.getText().toString();
                nama_belakang = etNamaBelakang.getText().toString();
                alamat = etAlamat.getText().toString();
                telepon = etTelepon.getText().toString();

                int selectedid = rgPilihan.getCheckedRadioButtonId();
                final RadioButton rbSMP = (RadioButton) findViewById(selectedid);
                final RadioButton rbSMP1 = (RadioButton) findViewById(selectedid);
                final RadioButton rbMTS = (RadioButton) findViewById(selectedid);

                jenis_kelamin = spJenisKelamin.getSelectedItem().toString();

                dwidaya = cbDwidaya.isChecked();
                dbs = cbDbs.isChecked();
                merah = cbMerah.isChecked();
                sutarmadja = cbSutarmadja.isChecked();

                if(nama_depan.length() == 0 || nama_belakang.length() == 0){
                    Toast.makeText(getApplicationContext(), "Mohon Lengkapi Nama Anda", Toast.LENGTH_SHORT).show();
                    return false;
                }

                Intent i = new Intent(MainActivity.this, detailActivity.class);
                i.putExtra("i_namaDepan",nama_depan);
                i.putExtra("i_namaBelakang",nama_belakang);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(i);


                return true;


            case R.id.mn_kosong:
                etNamaDepan.setText("");
                etNamaBelakang.setText("");
                etTelepon.setText("");
                etAlamat.setText("");

                spJenisKelamin.setSelection(0);

                if(cbDwidaya.isChecked()){
                    cbDwidaya.toggle();
                }

                if(cbDbs.isChecked()){
                    cbDbs.toggle();
                }

                if(cbMerah.isChecked()){
                    cbMerah.toggle();
                }

                if(cbSutarmadja.isChecked()){
                    cbSutarmadja.toggle();
                }

                rgPilihan.check(R.id.rb_smp);

                return true;

            case R.id.mn_biodata:
                View v = findViewById(R.id.main_layout);
                String pesan = "Created by : Yoel Abraham";
                int durasi = Snackbar.LENGTH_SHORT;
                Snackbar.make(v,pesan,durasi).show();

                return true;

                default:
                    return super.onOptionsItemSelected(item);

        }
    }

}

package com.team.apparrahman.data;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.team.apparrahman.R;

public class AddDataActivity extends AppCompatActivity {

    Spinner spAmanah, spDivisi;
    String amanah, posDivisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        spAmanah = findViewById(R.id.spinner_amanah);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.amanah, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spAmanah.setAdapter(adapter);
        amanah = spAmanah.getSelectedItem().toString();

        spDivisi = findViewById(R.id.spinner_divisi);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.pos_divisi, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDivisi.setAdapter(arrayAdapter);
        posDivisi = spDivisi.getSelectedItem().toString();
    }
}
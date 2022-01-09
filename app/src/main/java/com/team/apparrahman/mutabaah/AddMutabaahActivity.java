package com.team.apparrahman.mutabaah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.team.apparrahman.R;

public class AddMutabaahActivity extends AppCompatActivity {

    RadioButton rbAlarm, rbNotif;
    CardView btnAlarm, btnNotif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mutabaah);

        rbAlarm = findViewById(R.id.rb_alarm);
        btnAlarm = findViewById(R.id.btn_alarm);
        rbNotif = findViewById(R.id.rb_notif);
        btnNotif = findViewById(R.id.btn_notifikasi);

        checkModePengingat();
    }

    private void checkModePengingat() {
        if (rbAlarm.isChecked()){
            btnNotif.setVisibility(View.INVISIBLE);
        }

        if (rbNotif.isChecked()){
            btnAlarm.setVisibility(View.INVISIBLE);
        }
    }
}
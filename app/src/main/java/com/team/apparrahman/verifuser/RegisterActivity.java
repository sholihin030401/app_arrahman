package com.team.apparrahman.verifuser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.team.apparrahman.MainActivity;
import com.team.apparrahman.R;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText namalengkap, npm, jurusan, nohp, email, pw, kodeadmin;
    FloatingActionButton fabSignin;
    Spinner spUser;
    String tipeUser;

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser user = mAuth.getCurrentUser();

        if (user != null){
            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        namalengkap = findViewById(R.id.reg_name);
        npm = findViewById(R.id.reg_npm);
        jurusan = findViewById(R.id.reg_jurusan);
        nohp = findViewById(R.id.reg_nohp);
        email = findViewById(R.id.reg_email);
        pw = findViewById(R.id.reg_pw);
        kodeadmin = findViewById(R.id.reg_admin);

        spUser = findViewById(R.id.spinner_user);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.tipe_user, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spUser.setAdapter(arrayAdapter);
        tipeUser = spUser.getSelectedItem().toString();

        fabSignin = findViewById(R.id.fab_signin);
        fabSignin.setOnClickListener(v -> registerUser());

    }

    private void registerUser() {
        String name, nim, prodi, nowa, mail, pass, referral;

        name = namalengkap.getText().toString();
        nim = npm.getText().toString();
        prodi = jurusan.getText().toString();
        nowa = nohp.getText().toString();
        mail = email.getText().toString();
        pass = pw.getText().toString();
        referral = kodeadmin.getText().toString();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(nim)
                || TextUtils.isEmpty(prodi) || TextUtils.isEmpty(nowa)
                || TextUtils.isEmpty(mail) || TextUtils.isEmpty(pass)){
            Toast.makeText(getApplicationContext(), "Tidak boleh ada yang kosong!", Toast.LENGTH_SHORT).show();
        }

        if (tipeUser.equals("Admin")){
            kodeadmin.setVisibility(View.VISIBLE);
        }

        mAuth.createUserWithEmailAndPassword(mail, pass).addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                Toast.makeText(getApplicationContext(), "Register Berhasil", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Gagal membuat akun", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
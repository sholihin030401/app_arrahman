package com.team.apparrahman.verifuser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.team.apparrahman.MainActivity;
import com.team.apparrahman.R;

public class LoginActivity extends AppCompatActivity {

    EditText logMail, logPass;
    TextView txregist;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener authStateListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logMail = findViewById(R.id.mail_login);
        logPass = findViewById(R.id.pw_login);

        mAuth = FirebaseAuth.getInstance();

        authStateListener = firebaseAuth -> {
            FirebaseUser mUser = firebaseAuth.getCurrentUser();

            if (mUser != null){
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            }
        };

        FloatingActionButton fabLogin = findViewById(R.id.fab_login);
        fabLogin.setOnClickListener(v -> {
            String txmail, txpass;

            txmail = logMail.getText().toString();
            txpass = logPass.getText().toString();

            if (TextUtils.isEmpty(txmail) || TextUtils.isEmpty(txpass)){
                Toast.makeText(getApplicationContext(), "Tidak boleh ada yang kosong!", Toast.LENGTH_SHORT).show();
            }

            mAuth.signInWithEmailAndPassword(txmail, txpass).addOnCompleteListener(task -> {
               if (task.isSuccessful()){
                   startActivity(new Intent(LoginActivity.this, MainActivity.class));
               } else {
                   Toast.makeText(LoginActivity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
               }
            });
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(authStateListener);
    }
}
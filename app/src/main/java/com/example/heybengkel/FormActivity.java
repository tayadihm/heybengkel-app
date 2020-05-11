package com.example.heybengkel;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {

    Spinner j_bengkel;
    CheckBox cb_service1, cb_service2, cb_service3, cb_service4;
    Button cari_Btnbengkel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        j_bengkel = (Spinner) findViewById(R.id.j_bengkel);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_jbengkel, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        j_bengkel.setAdapter(adapter);

        cb_service1 = findViewById(R.id.cb_service1);
        cb_service2 = findViewById(R.id.cb_service2);
        cb_service3 = findViewById(R.id.cb_service3);
        cb_service4 = findViewById(R.id.cb_service4);

        cari_Btnbengkel = findViewById(R.id.cariBtn_bengkel);
        cari_Btnbengkel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FormActivity.this, "Dalam masa pengembangan", Toast.LENGTH_LONG).show();
            }

//                final Dialog mBuilder = new Dialog(FormActivity.this);
//                final View mView = (View) getLayoutInflater().inflate(R.layout.activity_bengkel, null);
//                mBuilder.setContentView(mView);
//                mBuilder.show();
//                Thread thread = new Thread(){
//                    @Override
//                    public void run() {
//                        try{
//                            sleep(5000);
//                        }catch (InterruptedException e){
//                            e.printStackTrace();
//                        }finally {
//                            startActivity(new Intent(FormActivity.this, BengkelActivity.class));
//                            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
//                            finish();
//                        }
//                    }
//                };
//                thread.start();
//            }
        });

    }

}

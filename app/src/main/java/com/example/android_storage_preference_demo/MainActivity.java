package com.example.android_storage_preference_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView data;
    Button storeInfo, showInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        data = (TextView) findViewById(R.id.txtData);
        storeInfo = (Button) findViewById(R.id.btnStore);
        showInfo = (Button) findViewById(R.id.btnShow);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {

                    case R.id.btnStore:
                        Intent storeInfo = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(storeInfo);
                        break;


                    case R.id.btnShow:
                        displayInfo();
                        break;


                    default:
                        break;
                }
            }
        };
        storeInfo.setOnClickListener(listener);
        showInfo.setOnClickListener(listener);
    }


    private void displayInfo(){
        SharedPreferences userInfo = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        String username = userInfo.getString("username", "Default username");
        String password = userInfo.getString("password", "default password");
        boolean checkbox = userInfo.getBoolean("checkbox", false);
        String optionInformation = userInfo.getString("Listpref", "Default option");

        StringBuilder builder = new StringBuilder();
        builder.append("Username" +username+ "\n");
        builder.append("Password" +password+ "\n");
        builder.append("Keep me logged in :" +String.valueOf(checkbox)+ "\n");
        builder.append("Course Option"+ optionInformation);

        data.setText(builder.toString());
    }
}
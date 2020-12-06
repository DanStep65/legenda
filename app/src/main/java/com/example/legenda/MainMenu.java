package com.example.legenda;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity {
    private long backInterval;
    private Toast backToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }
    public void MoveSettings(View view){ //MoveLayout to Settings page
        Intent intent = new Intent(MainMenu.this, SettingsScreen.class);
        startActivity(intent);
    }

    public void MoveCredits(View view){ //MoveLayout to Credits page
        Intent intent = new Intent(MainMenu.this, CreditsScreen.class);
        startActivity(intent);
    }
    public void PlayGame(View view){ //MoveLayout to GameScreenBegin page
        Intent intent = new Intent(MainMenu.this, GameScreenBegin.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if(backInterval + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            Intent a = new Intent(Intent.ACTION_MAIN);
            a.addCategory(Intent.CATEGORY_HOME);
            a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(a);
            return;
        }
        else{
            backToast = Toast.makeText(getBaseContext(),"Tekan Back lagi untuk keluar dari game",Toast.LENGTH_SHORT);
            backToast.show();
        }
        backInterval = System.currentTimeMillis();

    }
}
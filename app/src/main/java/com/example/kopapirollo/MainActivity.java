package com.example.kopapirollo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView playerValasztas, computerValasztas, gepElet1, gepElet2, gepElet3, jatekosElet1, jatekosElet2, jatekosElet3;
    private ImageButton buttonKo, buttonPapir, buttonOllo;
    private TextView textViewDontetlen;
    private int player, computer, dontetlen;
    private AlertDialog.Builder jatekVege;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        buttonKo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerValasztas.setImageResource(R.drawable.rock);
                int computerValaszt = computerValaszt();
                switch (computerValaszt){
                    case 0:
                        Toast.makeText(MainActivity.this, "Döntetlen", Toast.LENGTH_SHORT).show();
                        dontetlenPont();
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, "A gép nyert pontot", Toast.LENGTH_SHORT).show();
                        gepPont();
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "A játékos nyert pontot", Toast.LENGTH_SHORT).show();
                        jatekosPont();
                        break;
                }
            }
        });
        buttonPapir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerValasztas.setImageResource(R.drawable.paper);
                int computerValaszt = computerValaszt();
                switch (computerValaszt){
                    case 0:
                        Toast.makeText(MainActivity.this, "A játékos nyert pontot", Toast.LENGTH_SHORT).show();
                        jatekosPont();
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, "Döntetlen", Toast.LENGTH_SHORT).show();
                        dontetlenPont();
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "A gép nyert pontot", Toast.LENGTH_SHORT).show();
                        gepPont();
                        break;
                }
            }
        });
        buttonOllo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerValasztas.setImageResource(R.drawable.scissors);
                int computerValaszt = computerValaszt();
                switch (computerValaszt){
                    case 0:
                        Toast.makeText(MainActivity.this, "A gép nyert pontot", Toast.LENGTH_SHORT).show();
                        gepPont();
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, "A játékos nyert pontot", Toast.LENGTH_SHORT).show();
                        jatekosPont();
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "Döntetlen", Toast.LENGTH_SHORT).show();
                        dontetlenPont();
                        break;
                }
            }
        });
    }

    private void gepPont() {
        computer += 1;
        switch (computer){
            case 1:
                jatekosElet3.setImageResource(R.drawable.heart1);
                break;
            case 2:
                jatekosElet2.setImageResource(R.drawable.heart1);
                break;
            case 3:
                jatekosElet1.setImageResource(R.drawable.heart1);
                break;
        }
        if (computer == 3){
            jatekVege.setTitle("Vereség").create().show();
        }
    }

    private void jatekosPont() {
        player += 1;
        switch (player){
            case 1:
                gepElet1.setImageResource(R.drawable.heart1);
                break;
            case 2:
                gepElet2.setImageResource(R.drawable.heart1);
                break;
            case 3:
                gepElet3.setImageResource(R.drawable.heart1);
                break;
        }
        if (player == 3){
            jatekVege.setTitle("Győzelem").create().show();
        }
    }

    private void dontetlenPont() {
        dontetlen += 1;
        textViewDontetlen.setText("Döntetlenek száma: " + dontetlen);
    }

    private void init(){
        playerValasztas = findViewById(R.id.playerValasztas);
        computerValasztas = findViewById(R.id.computerValasztas);
        buttonKo = findViewById(R.id.buttonKo);
        buttonPapir = findViewById(R.id.buttonPapir);
        buttonOllo = findViewById(R.id.buttonOllo);
        textViewDontetlen = findViewById(R.id.textViewDontetlen);
        gepElet1 = findViewById(R.id.imageViewGepElet1);
        gepElet2 = findViewById(R.id.imageViewGepElet2);
        gepElet3 = findViewById(R.id.imageViewGepElet3);
        jatekosElet1 = findViewById(R.id.imageViewJatekosElet1);
        jatekosElet2 = findViewById(R.id.imageViewJatekosElet2);
        jatekosElet3 = findViewById(R.id.imageViewJatekosElet3);
        jatekVege = new AlertDialog.Builder(MainActivity.this);
        jatekVege.setCancelable(false)
                .setTitle("Győzelem / Vereség")
                .setMessage("Szeretne új játékot játszani?")
                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ujJatek();
                    }
                })
                .create();
    }

    private void ujJatek(){
        player = 0;
        computer = 0;
        textViewDontetlen.setText("Döntetlenek száma: 0");
        dontetlen = 0;
        gepElet1.setImageResource(R.drawable.heart2);
        gepElet2.setImageResource(R.drawable.heart2);
        gepElet3.setImageResource(R.drawable.heart2);
        jatekosElet1.setImageResource(R.drawable.heart2);
        jatekosElet2.setImageResource(R.drawable.heart2);
        jatekosElet3.setImageResource(R.drawable.heart2);
    }

    private int computerValaszt(){
        Random random = new Random();
        int computerValaszt = random.nextInt(3);
        switch (computerValaszt){
            case 0:
                computerValasztas.setImageResource(R.drawable.rock);
                break;
            case 1:
                computerValasztas.setImageResource(R.drawable.paper);
                break;
            case 2:
                computerValasztas.setImageResource(R.drawable.scissors);
                break;
        }
        return computerValaszt;
    }
}
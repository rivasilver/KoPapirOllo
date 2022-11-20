package com.example.kopapirollo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView playerValasztas, computerValasztas;
    private Button buttonKo, buttonPapir, buttonOllo;
    private TextView textViewEmber, textViewComputer;
    private int player, computer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        //ujJatek();
        buttonKo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerValasztas.setImageResource(R.drawable.rock);
                int computerValaszt = computerValaszt();
                switch (computerValaszt){
                    case 0:
                        Toast.makeText(MainActivity.this, "Döntetlen", Toast.LENGTH_SHORT).show();
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
                        break;
                }
            }
        });
    }

    private void gepPont() {
        computer += 1;
        textViewComputer.setText("Computer: " + computer);
    }

    private void jatekosPont() {
        player += 1;
        textViewEmber.setText("Ember: " + player);
    }

    private void init(){
        playerValasztas = findViewById(R.id.playerValasztas);
        computerValasztas = findViewById(R.id.computerValasztas);
        buttonKo = findViewById(R.id.buttonKo);
        buttonPapir = findViewById(R.id.buttonPapir);
        buttonOllo = findViewById(R.id.buttonOllo);
        textViewEmber = findViewById(R.id.textViewEmber);
        textViewComputer = findViewById(R.id.textViewComputer);
    }

    private void ujJatek(){
        int player = 1;
        int computer = 1;
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
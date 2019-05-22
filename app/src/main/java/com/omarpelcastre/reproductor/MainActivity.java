package com.omarpelcastre.reproductor;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int[] Sounds = {R.raw.sound1, R.raw.sound2, R.raw.sound3, R.raw.sound4, R.raw.sound5, R.raw.sound6};
    int[] Images = {R.drawable.imagen1, R.drawable.imagen2, R.drawable.imagen3, R.drawable.imagen4,R.drawable.imagen5,
            R.drawable.imagen6};
    String[] Artistas = {"Hayden James", "Ricardo Macias", "Michael Jackson", "Metallica" , "Jack Back", "Aerosmith"};
    String[] Songs = {"Something About You", "Le Fanky", "Thriller", "Wiskey in the jar" , "Grenade", "I don't wanna miss a thing"};
    static MediaPlayer miReproductor = null;
    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final Button btnPlay = findViewById(R.id.btnPlay);
        final Button btnStop = findViewById(R.id.btnStop);
        final Button btnBack = findViewById(R.id.btnBack);
        final Button btnNext = findViewById(R.id.btnNext);
        final Button btnPausa = findViewById(R.id.btnPause);
        final ImageView imageView = findViewById(R.id.imageView);
        final TextView textArtista = findViewById(R.id.textArtista);
        final TextView textSong = findViewById(R.id.textSong);








        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (miReproductor == null) {
                    miReproductor = MediaPlayer.create(MainActivity.this, Sounds[contador]);
                    miReproductor.start();
                    textArtista.setText(Artistas[contador]);
                    textSong.setText(Songs[contador]);
                    imageView.setImageResource(Images[contador]);
                }else{
                    if (!miReproductor.isPlaying()){
                        miReproductor.start();
                    }
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                miReproductor.stop();
                if (contador < 5) {
                    contador++;
                    miReproductor = MediaPlayer.create(MainActivity.this, Sounds[contador]);
                    miReproductor.start();
                    textArtista.setText(Artistas[contador]);
                    textSong.setText(Songs[contador]);
                    imageView.setImageResource(Images[contador]);
                }

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miReproductor.stop();
                if (contador > 0)
                contador--;
                miReproductor = MediaPlayer.create(MainActivity.this, Sounds[contador]);
                miReproductor.start();
                textArtista.setText(Artistas[contador]);
                textSong.setText(Songs[contador]);
                imageView.setImageResource(Images[contador]);
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (miReproductor != null && miReproductor.isPlaying()){
                    miReproductor.stop();
                }
            }
        });

        btnPausa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (miReproductor != null && miReproductor.isPlaying()){
                    miReproductor.pause();
                }
            }
        });




    }
}

package com.example.guessme;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.guessme.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Create a variable
    private int m_secret;
    private EditText m_et_guess;
    private ImageView m_img_card;
    private Button m_btnSubmit;
    private Button m_btnPlayAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random r = new Random();
        m_secret = r.nextInt(3) + 1;

        m_et_guess = findViewById(R.id.et_guess);
        m_img_card = findViewById(R.id.img_card);
        m_btnSubmit = findViewById(R.id.btnSubmit);

    }

    public void btnSubmit_click(View view) {
        int guess = Integer.parseInt(m_et_guess.getText().toString());

        Animation animation = new AlphaAnimation(0f,1.0f);
        animation.setDuration(2000);
        m_img_card.setAnimation(animation);

        if (guess == m_secret) {
            Toast.makeText(this, "Congratulation! You got it!", Toast.LENGTH_SHORT).show();
            switch(m_secret) {
                case 1:m_img_card.setImageResource(R.drawable.one); break;
                case 2:m_img_card.setImageResource(R.drawable.two); break;
                case 3:m_img_card.setImageResource(R.drawable.three);
            }
        }
        else {
            Toast.makeText(this, "Incorrect Answer.", Toast.LENGTH_SHORT).show();
        }

        m_btnSubmit.setEnabled(false);
    }

    public void btnPlayAgain_click(View view) {
        m_btnPlayAgain = findViewById(R.id.btnPlayAgain);

        m_btnPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                m_secret = r.nextInt(3) + 1;

                m_img_card.setImageResource(R.drawable.cover);
                m_btnSubmit.setEnabled(true);
            }
        });
    }
}
package com.example.tp02matchpic;
import androidx.appcompat.app.AppCompatActivity;

import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int[] anis=new int[]{
            R.drawable.a_ele,R.drawable.a_frog,
            R.drawable.a_lion,R.drawable.a_monkey, R.drawable.a_pig
    };
    int[] ques=new int[]{
            R.drawable.b_ele, R.drawable.b_frog,
            R.drawable.b_lion,R.drawable.b_monkey, R.drawable.b_pig
    };
    int num;
    int[] a=new int[5];
    ImageButton btn;
    ImageView i1,i2,i3,i4,i5,imgQ,imgResult;

    SoundPool sp;
    int sdAgain,sdGood,sdSelect,sdStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //random
        Random rnd = new Random();

        sp=new SoundPool.Builder().setMaxStreams(10).build();
        sdAgain=sp.load(this,R.raw.s_again,0);
        sdGood=sp.load(this,R.raw.s_goodjob,0);
        sdSelect=sp.load(this,R.raw.s_select,0);
        sdStart=sp.load(this,R.raw.s_start,0);

        btn = findViewById(R.id.start);
        i1 = findViewById(R.id.img1);
        i2 = findViewById(R.id.img2);
        i3 = findViewById(R.id.img3);
        i4 = findViewById(R.id.img4);
        i5 = findViewById(R.id.img5);
        imgQ = findViewById(R.id.img_q);
        imgResult=findViewById(R.id.result);

        i1.setOnClickListener(listener);
        i2.setOnClickListener(listener);
        i3.setOnClickListener(listener);
        i4.setOnClickListener(listener);
        i5.setOnClickListener(listener);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp.play(sdStart,0.8f,0.8f,3,0,1.0f);
                imgResult.setVisibility(View.GONE);
                num = rnd.nextInt(ques.length);
                imgQ.setImageResource(ques[num]);
                int i;
                for(i=0;i<5;i++){
                    a[i]=rnd.nextInt(5);
                    for(int j=0;j<i;j++){
                        if(a[i]==a[j]) i--;
                    }
                }
                i--;
                i1.setImageResource(anis[a[i]]);
                i2.setImageResource(anis[a[i-1]]);
                i3.setImageResource(anis[a[i-2]]);
                i4.setImageResource(anis[a[i-3]]);
                i5.setImageResource(anis[a[i-4]]);
            }
        });
    }
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp.play(sdSelect,0.8f,0.8f,1,0,1.0f);
                int id = view.getId();
                imgResult.setVisibility(View.VISIBLE);
                switch (id) {
                    case R.id.img1:
                        if (num == a[4]) {
                            imgResult.setImageResource(R.drawable.result_good);
                            sp.play(sdGood,0.8f,0.8f,2,0,1.0f);
                        }
                        else {
                            imgResult.setImageResource(R.drawable.result_bad);
                            sp.play(sdAgain,0.8f,0.8f,2,0,1.0f);
                        }
                        break;
                    case R.id.img2:
                        if (num == a[3]) {
                            imgResult.setImageResource(R.drawable.result_good);
                            sp.play(sdGood,0.8f,0.8f,2,0,1.0f);
                        }
                        else {
                            imgResult.setImageResource(R.drawable.result_bad);
                            sp.play(sdAgain,0.8f,0.8f,2,0,1.0f);
                        }
                        break;
                    case R.id.img3:
                        if (num == a[2]) {
                            imgResult.setImageResource(R.drawable.result_good);
                            sp.play(sdGood,0.8f,0.8f,2,0,1.0f);
                        }
                        else {
                            imgResult.setImageResource(R.drawable.result_bad);
                            sp.play(sdAgain,0.8f,0.8f,2,0,1.0f);
                        }
                        break;
                    case R.id.img4:
                        if (num == a[1]) {
                            imgResult.setImageResource(R.drawable.result_good);
                            sp.play(sdGood,0.8f,0.8f,2,0,1.0f);
                        }
                        else {
                            imgResult.setImageResource(R.drawable.result_bad);
                            sp.play(sdAgain,0.8f,0.8f,2,0,1.0f);
                        }
                        break;
                    case R.id.img5:
                        if (num == a[0]) {
                            imgResult.setImageResource(R.drawable.result_good);
                            sp.play(sdGood,0.8f,0.8f,2,0,1.0f);
                        }
                        else {
                            imgResult.setImageResource(R.drawable.result_bad);
                            sp.play(sdAgain,0.8f,0.8f,2,0,1.0f);
                        }
                        break;
                }
            }
        };
}
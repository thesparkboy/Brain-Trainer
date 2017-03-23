package com.example.first.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView timerTextView;
    TextView scr;
    TextView eqn;
    Button go;
    Button option1;
    Button option2;
    Button option3;
    Button option4;
    boolean isActive = true;
    int score;
    int total = 0;
    int qno = 0;
    int answer = 0;
    CountDownTimer countDownTimer;
    int seconds;

    public void updatetextview(){
        seconds--;
        if(seconds>9){
            timerTextView.setText("00:"+seconds);
        }else{
            timerTextView.setText("00:0"+seconds);
        }
    }

    public void reset(){
        countDownTimer = new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                updatetextview();
            }
            @Override
            public void onFinish() {
                timerTextView.setText("00:00");
                isActive = true;
                eqn.setText("");
                Toast.makeText(getApplicationContext(),"Your score was " + score ,Toast.LENGTH_SHORT).show();
                score = 0;
                total=0;
                go.setVisibility(go.VISIBLE);
                View a = findViewById(R.id.button2);
                option1.setVisibility(a.INVISIBLE);
                View b = findViewById(R.id.button3);
                option2.setVisibility(b.INVISIBLE);
                View c = findViewById(R.id.button4);
                option3.setVisibility(c.INVISIBLE);
                View d = findViewById(R.id.button5);
                option4.setVisibility(d.INVISIBLE);
            }
        };
        countDownTimer.start();
    }

    public void Start(View view){
        seconds = 30;
        scr.setText("0/0");
        timerTextView.setText("00:"+seconds);
        final View x = view;
        reset();
        go.setVisibility(go.INVISIBLE);
        View a = findViewById(R.id.button2);
        option1.setVisibility(a.VISIBLE);
        View b = findViewById(R.id.button3);
        option2.setVisibility(b.VISIBLE);
        View c = findViewById(R.id.button4);
        option3.setVisibility(c.VISIBLE);
        View d = findViewById(R.id.button5);
        option4.setVisibility(d.VISIBLE);
        answer = Question();
    }

    public void Clicked(View view){
        if(isActive) {
            total++;
            String x = view.getTag().toString();
            int tag = Integer.parseInt(x);
            if(answer == tag) {
                score++;
            }
            String scre = score+"/"+total;
            scr.setText(scre);
            answer = Question();

        }

    }

    public int Question(){
        Random random = new Random();
        int x = random.nextInt(100);
        int y = random.nextInt(100);
        int temp = random.nextInt(100);
        int a = x-y;
        if(a < 0){
            int grbg = x;
            x = y;
            y = grbg;
            a = Math.abs(x-y);
        }
        int b = x+y;
        int g = random.nextInt(10)+5;
        int h = random.nextInt(10)+7;
        int c = g * h;
        int tag = temp%4+1;
        int operator = temp%3 + 1;
        int an;
        int op1=0,op2=0,op3=0,op4=0;
        if(operator == 1){
            String text = x + " - " + y;
            eqn.setText(text);
            an = a;
            int high = an+15;
            int q = an-15;
            int flag =0;
            if(q<=0){
                op1 = (random.nextInt(20));
                while(op1==an){
                    op1 = (random.nextInt(20));
                }
                op2 = (random.nextInt(20));
                while(op2==an || op2==op1){
                    op2 = (random.nextInt(20));
                }
                op3 = (random.nextInt(20));
                while(op3==an || op3==op1 || op3 == op2){
                    op3 = (random.nextInt(20));
                }
                op4 = (random.nextInt(20));
                while(op4==an || op4==op1 || op4==op2 || op4==op3){
                    op4 = (random.nextInt(20));
                }
                flag = 1;
            }
            if(flag == 0){
            op1 = (random.nextInt(high-q)+q);
            while(op1==an){
                op1 = (random.nextInt(high-q)+q);
            }
            op2 = (random.nextInt(high-q)+q);
            while(op2==an || op2==op1){
                op2 = (random.nextInt(high-q)+q);
            }
            op3 = (random.nextInt(high-q)+q);
            while(op3==an || op3==op1 || op3 == op2){
                op3 = (random.nextInt(high-q)+q);
            }
            op4 = (random.nextInt(high-q)+q);
            while(op4==an || op4==op1 || op4==op2 || op4==op3){
                op4 = (random.nextInt(high-q)+q);
            }
            }
            String ans = Integer.toString(an);
            for(int i = 1;i <= 4;i++){
                String s = i+"";
                if(i != tag){
                    if(Integer.parseInt(option1.getTag().toString()) == i){
                        option1.setText(""+op1);
                    }
                    if(Integer.parseInt(option2.getTag().toString()) == i){
                        option2.setText(""+op2);
                    }
                    if(Integer.parseInt(option3.getTag().toString()) == i){
                        option3.setText(""+op3);
                    }
                    if(Integer.parseInt(option4.getTag().toString()) == i){
                        option4.setText(""+op4);
                    }
                }else{
                    if(Integer.parseInt(option1.getTag().toString()) == i){
                        option1.setText(ans);
                    }
                    if(Integer.parseInt(option2.getTag().toString()) == i){
                        option2.setText(ans);
                    }
                    if(Integer.parseInt(option3.getTag().toString()) == i){
                        option3.setText(ans);
                    }
                    if(Integer.parseInt(option4.getTag().toString()) == i){
                        option4.setText(ans);
                    }
                }
            }
        }else if(operator == 2){
            String text = x + " + " + y;
            eqn.setText(text);
            an = b;
            int q = an-15;
            int high = an+15;
            int flag =0;
            if(q<=0){
                op1 = (random.nextInt(20));
                while(op1==an){
                    op1 = (random.nextInt(20));
                }
                op2 = (random.nextInt(20));
                while(op2==an || op2==op1){
                    op2 = (random.nextInt(20));
                }
                op3 = (random.nextInt(20));
                while(op3==an || op3==op1 || op3 == op2){
                    op3 = (random.nextInt(20));
                }
                op4 = (random.nextInt(20));
                while(op4==an || op4==op1 || op4==op2 || op4==op3){
                    op4 = (random.nextInt(20));
                }
                flag = 1;
            }

            if(flag == 0){
                op1 = (random.nextInt(high-q)+q);
                while(op1==an){
                    op1 = (random.nextInt(high-q)+q);
                }
                op2 = (random.nextInt(high-q)+q);
                while(op2==an || op2==op1){
                    op2 = (random.nextInt(high-q)+q);
                }
                op3 = (random.nextInt(high-q)+q);
                while(op3==an || op3==op1 || op3 == op2){
                    op3 = (random.nextInt(high-q)+q);
                }
                op4 = (random.nextInt(high-q)+q);
                while(op4==an || op4==op1 || op4==op2 || op4==op3){
                    op4 = (random.nextInt(high-q)+q);
                }
            }
            String ans = Integer.toString(an);
            for(int i = 1;i <= 4;i++){
                String s = i+"";
                if(i != tag){
                    if(Integer.parseInt(option1.getTag().toString()) == i){
                        option1.setText(""+op1);
                    }
                    if(Integer.parseInt(option2.getTag().toString()) == i){
                        option2.setText(""+op2);
                    }
                    if(Integer.parseInt(option3.getTag().toString()) == i){
                        option3.setText(""+op3);
                    }
                    if(Integer.parseInt(option4.getTag().toString()) == i){
                        option4.setText(""+op4);
                    }
                }else{
                    if(Integer.parseInt(option1.getTag().toString()) == i){
                        option1.setText(ans);
                    }
                    if(Integer.parseInt(option2.getTag().toString()) == i){
                        option2.setText(ans);
                    }
                    if(Integer.parseInt(option3.getTag().toString()) == i){
                        option3.setText(ans);
                    }
                    if(Integer.parseInt(option4.getTag().toString()) == i){
                        option4.setText(ans);
                    }
                }
            }
        }else{
            String text = g + " * " + h;
            eqn.setText(text);
            an = c;
            int q = an-15;
            int high = an+15;
            int flag =0;
            if(q<=0){
                op1 = (random.nextInt(20));
                while(op1==an){
                    op1 = (random.nextInt(20));
                }
                op2 = (random.nextInt(20));
                while(op2==an || op2==op1){
                    op2 = (random.nextInt(20));
                }
                op3 = (random.nextInt(20));
                while(op3==an || op3==op1 || op3 == op2){
                    op3 = (random.nextInt(20));
                }
                op4 = (random.nextInt(20));
                while(op4==an || op4==op1 || op4==op2 || op4==op3){
                    op4 = (random.nextInt(20));
                }
                flag = 1;
            }
            if(flag == 0){
                op1 = (random.nextInt(high-q)+q);
                while(op1==an){
                    op1 = (random.nextInt(high-q)+q);
                }
                op2 = (random.nextInt(high-q)+q);
                while(op2==an || op2==op1){
                    op2 = (random.nextInt(high-q)+q);
                }
                op3 = (random.nextInt(high-q)+q);
                while(op3==an || op3==op1 || op3 == op2){
                    op3 = (random.nextInt(high-q)+q);
                }
                op4 = (random.nextInt(high-q)+q);
                while(op4==an || op4==op1 || op4==op2 || op4==op3){
                    op4 = (random.nextInt(high-q)+q);
                }
            }
            String ans = Integer.toString(an);
            for(int i = 1;i <= 4;i++){
                String s = i+"";
                if(i != tag){

                    if(Integer.parseInt(option1.getTag().toString()) == i){
                        option1.setText(""+op1);
                    }
                    if(Integer.parseInt(option2.getTag().toString()) == i){
                        option2.setText(""+op2);
                    }
                    if(Integer.parseInt(option3.getTag().toString()) == i){
                        option3.setText(""+op3);
                    }
                    if(Integer.parseInt(option4.getTag().toString()) == i){
                        option4.setText(""+op4);
                    }
                }else{
                    if(Integer.parseInt(option1.getTag().toString()) == i){
                        option1.setText(ans);
                    }
                    if(Integer.parseInt(option2.getTag().toString()) == i){
                        option2.setText(ans);
                    }
                    if(Integer.parseInt(option3.getTag().toString()) == i){
                        option3.setText(ans);
                    }
                    if(Integer.parseInt(option4.getTag().toString()) == i){
                        option4.setText(ans);
                    }
                }
            }
        }
        return tag;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        go = (Button)findViewById(R.id.go);
        timerTextView = (TextView)findViewById(R.id.Timer);
        timerTextView.setText("00:30");
        scr = (TextView)findViewById(R.id.score);
        eqn = (TextView)findViewById(R.id.equation);
        option1 = (Button)findViewById(R.id.button2);
        option2 = (Button)findViewById(R.id.button3);
        option3 = (Button)findViewById(R.id.button4);
        option4 = (Button)findViewById(R.id.button5);
        option1.setTag(1);
        option2.setTag(2);
        option3.setTag(3);
        option4.setTag(4);
        View a = findViewById(R.id.button2);
        a.setVisibility(View.INVISIBLE);
        View b = findViewById(R.id.button3);
        b.setVisibility(View.INVISIBLE);
        View c = findViewById(R.id.button4);
        c.setVisibility(View.INVISIBLE);
        View d = findViewById(R.id.button5);
        d.setVisibility(View.INVISIBLE);

    }
}

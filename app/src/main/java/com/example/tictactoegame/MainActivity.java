package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Handler mHandler =new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buClick(View view) {
        Button Selected=(Button)view;
        Selected.setBackgroundColor(Color.RED);
        int CellId=0;
        switch(Selected.getId())
        {
            case R.id.Button1:
                CellId=1;
                break;
            case R.id.Button2:
                CellId=2;
                break;
            case R.id.Button3:
                CellId=3;
                break;
            case R.id.Button4:
                CellId=4;
                break;
            case R.id.Button5:
                CellId=5;
                break;
            case R.id.Button6:
                CellId=6;
                break;
            case R.id.Button7:
                CellId=7;
                break;
            case R.id.Button8:
                CellId=8;
                break;
            case R.id.Button9:
                CellId=9;
                break;
        }
        PlayGame(CellId,Selected);
    }
    int chances=0;
    int ActivePlayer=1;//1-For player 1,2- For player 2
    ArrayList<Integer> Player1=new ArrayList<Integer>();
    ArrayList<Integer> Player2=new ArrayList<Integer>();
    ArrayList<Integer>Empty=new ArrayList<Integer>();

    private Runnable mRunnable =new Runnable() {
        @Override
        public void run() {
            whenDone();
        }
    };

    void PlayGame(int Id,Button selected)
    {
        if(ActivePlayer==1)
        {
            selected.setBackgroundColor(Color.GREEN);
            selected.setText("X");
            Player1.add(Id);
            ActivePlayer=2;
            chances=chances+1;
            if(chances==9)
            {
                Toast.makeText(this,"Match Draw",Toast.LENGTH_LONG).show();
                ActivePlayer=1;
                mHandler.postDelayed(mRunnable,3000);

            }
            else if(chances>0)
            {
                CheckWinner();
            }
        }
        else if(ActivePlayer==2)
        {
            selected.setBackgroundColor(Color.CYAN);
            selected.setText("0");
            Player2.add(Id);
            ActivePlayer=1;
            chances=chances+1;
            if(chances==9)
            {
                Toast.makeText(this,"Match Draw",Toast.LENGTH_LONG).show();
                ActivePlayer=1;
                mHandler.postDelayed(mRunnable,3000);

            }
            else if(chances>0)
                CheckWinner();
        }
        selected.setEnabled(false);//To insure,Once button is selected, again it sould not be selected

    }

    void CheckWinner()
    {

        int Win=0;
        //For rows
        if(Player1.contains(1)&&Player1.contains(2)&&Player1.contains(3))
        {
            Win=1;
        }
        if(Player2.contains(1)&&Player2.contains(2)&&Player2.contains(3))
        {
            Win=2;
        }
        if(Player1.contains(4)&&Player1.contains(5)&&Player1.contains(6))
        {
            Win=1;
        }
        if(Player2.contains(4)&&Player2.contains(5)&&Player2.contains(6))
        {
            Win=2;
        }
        if(Player1.contains(7)&&Player1.contains(8)&&Player1.contains(9))
        {
            Win=1;
        }
        if(Player2.contains(7)&&Player2.contains(8)&&Player2.contains(9))
        {
            Win=2;
        }
        //For Columns
        if(Player1.contains(1)&&Player1.contains(4)&&Player1.contains(7))
        {
            Win=1;
        }
        if(Player2.contains(1)&&Player2.contains(4)&&Player2.contains(7))
        {
            Win=2;
        }
        if(Player1.contains(2)&&Player1.contains(5)&&Player1.contains(8))
        {
        Win=1;
        }
        if(Player2.contains(2)&&Player2.contains(5)&&Player2.contains(8))
        {
            Win=2;
        }
        if(Player1.contains(3)&&Player1.contains(6)&&Player1.contains(9))
        {
        Win=1;
        }
        if(Player2.contains(3)&&Player2.contains(6)&&Player2.contains(9))
        {
            Win=2;
        }

        if(Win!=0)
        {
            if(Win==1)
            {
                Toast.makeText(this,"Player1 is Winner",Toast.LENGTH_LONG).show();
                ActivePlayer=1;
                mHandler.postDelayed(mRunnable,3000);
            }
            else
            {
                Toast.makeText(this,"Player2 is Winner",Toast.LENGTH_LONG).show();
                ActivePlayer=1;
                mHandler.postDelayed(mRunnable,3000);
            }
        }
        if(ActivePlayer==2)
            AutoPlay();
    }

    void whenDone()
    {
        chances=0;
        for(int i=1;i<=9;i++) {
            switch (i) {
                case 1:
                    Button SelectedButton1 = (Button) findViewById(R.id.Button1);
                    SelectedButton1.setBackgroundColor(Color.WHITE);
                    SelectedButton1.setEnabled(true);
                    SelectedButton1.setText("1");
                    break;
                case 2:
                    Button SelectedButton2 = (Button) findViewById(R.id.Button2);
                    SelectedButton2.setBackgroundColor(Color.WHITE);
                    SelectedButton2.setEnabled(true);
                    SelectedButton2.setText("2");
                    break;
                case 3:
                    Button SelectedButton3 = (Button) findViewById(R.id.Button3);
                    SelectedButton3.setBackgroundColor(Color.WHITE);
                    SelectedButton3.setEnabled(true);
                    SelectedButton3.setText("3");
                    break;
                case 4:
                    Button SelectedButton4 = (Button) findViewById(R.id.Button4);
                    SelectedButton4.setBackgroundColor(Color.WHITE);
                    SelectedButton4.setEnabled(true);
                    SelectedButton4.setText("4");
                    break;
                case 5:
                    Button SelectedButton5 = (Button) findViewById(R.id.Button5);
                    SelectedButton5.setBackgroundColor(Color.WHITE);
                    SelectedButton5.setEnabled(true);
                    SelectedButton5.setText("5");
                    break;
                case 6:
                    Button SelectedButton6 = (Button) findViewById(R.id.Button6);
                    SelectedButton6.setBackgroundColor(Color.WHITE);
                    SelectedButton6.setEnabled(true);
                    SelectedButton6.setText("6");
                    break;
                case 7:
                    Button SelectedButton7 = (Button) findViewById(R.id.Button7);
                    SelectedButton7.setBackgroundColor(Color.WHITE);
                    SelectedButton7.setEnabled(true);
                    SelectedButton7.setText("7");
                    break;
                case 8:
                    Button SelectedButton8 = (Button) findViewById(R.id.Button8);
                    SelectedButton8.setBackgroundColor(Color.WHITE);
                    SelectedButton8.setEnabled(true);
                    SelectedButton8.setText("8");
                    break;
                case 9:
                    Button SelectedButton9 = (Button) findViewById(R.id.Button9);
                    SelectedButton9.setBackgroundColor(Color.WHITE);
                    SelectedButton9.setEnabled(true);
                    SelectedButton9.setText("9");
                    break;
                default:
                    Button SelectedButton10 = (Button) findViewById(R.id.Button3);
                    SelectedButton10.setBackgroundColor(Color.WHITE);
                    break;
            }
        }
        Player1.clear();
        Player2.clear();
        Empty.clear();
    }


    void AutoPlay()
    {
        //ArrayList<Integer>Empty=new ArrayList<Integer>();
        Empty.clear();
        for(int i=1;i<=9;i++)
        {
            if(!(Player1.contains(i)||Player2.contains(i)))
            {
                Empty.add(i);
            }
        }

        Random r=new Random();
        int RandIndex=r.nextInt(Empty.size()-0)+0;//if Size=3 select(0,1,2)
        int CellId=Empty.get(RandIndex);
        Button SelectedButton;
        switch(CellId)
        {
            case 1:
                SelectedButton=(Button)findViewById(R.id.Button1);
                break;
            case 2:
                SelectedButton=(Button)findViewById(R.id.Button2);
                break;
            case 3:
                SelectedButton=(Button)findViewById(R.id.Button3);
                break;
            case 4:
                SelectedButton=(Button)findViewById(R.id.Button4);
                break;
            case 5:
                SelectedButton=(Button)findViewById(R.id.Button5);
                break;
            case 6:
                SelectedButton=(Button)findViewById(R.id.Button6);
                break;
            case 7:
                SelectedButton=(Button)findViewById(R.id.Button7);
                break;
            case 8:
                SelectedButton=(Button)findViewById(R.id.Button8);
                break;
            case 9:
                SelectedButton=(Button)findViewById(R.id.Button9);
                break;
            default:
                SelectedButton=(Button)findViewById(R.id.Button1);
                break;
        }
        PlayGame(CellId,SelectedButton);
    }
}


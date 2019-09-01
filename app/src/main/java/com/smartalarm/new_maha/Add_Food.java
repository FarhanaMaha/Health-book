package com.smartalarm.new_maha;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Add_Food extends AppCompatActivity {
    public TextView btn1,btn2,btn3,btn4;
    public TextView add_edt1,add_edt2,add_edt3,add_edt4;
    public TextView daily_totalcalories,alarmText;

    SharedPreferences sharedPreferences,sharedPreferences2,sharedPreferences3,sharedPreferences4,sharedPref;
    public  int a,b,c,d;
    public  int extra_caloriesgain,extra_caloriesmaintain,extra_caloriesmainloss,total;
    int types,types2,types3,types4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__food);
        add_edt1=(TextView) findViewById(R.id.add_edt1);
        add_edt2=(TextView) findViewById(R.id.add_edt2);
        add_edt3=(TextView) findViewById(R.id.add_edt3);
        add_edt4=(TextView) findViewById(R.id.add_edt4);
        daily_totalcalories=(TextView) findViewById(R.id.daily_totalcaloreis);
        btn1=(TextView) findViewById(R.id.btn1);
        btn2=(TextView) findViewById(R.id.btn2);
        btn3=(TextView) findViewById(R.id.btn3);
        btn4=(TextView) findViewById(R.id.btn4);
        alarmText=(TextView) findViewById(R.id.alarmText);
        extra_caloriesgain=1521;
        extra_caloriesmaintain=999;
        extra_caloriesmainloss=1520;



        sharedPreferences=getSharedPreferences("puzzle", Context.MODE_PRIVATE);

        types=sharedPreferences.getInt("type",0);
        a=types;
        add_edt1.setText(String.valueOf(a+"calories"));

        sharedPreferences2=getSharedPreferences("lunch", Context.MODE_PRIVATE);
         types2=sharedPreferences2.getInt("lunchtype",0);
        b=types2;
        add_edt2.setText(String.valueOf(b+"calories"));

        sharedPreferences3=getSharedPreferences("dinner", Context.MODE_PRIVATE);
         types3=sharedPreferences3.getInt("dinnertype",0);
        c=types3;
        add_edt3.setText(String.valueOf(c+"calories"));

        sharedPreferences4=getSharedPreferences("snacks", Context.MODE_PRIVATE);
         types4=sharedPreferences4.getInt("snackstype",0);
        d=types4;
        add_edt4.setText(String.valueOf(d+"calories"));

        int total_sum=a+b+c+d;

        daily_totalcalories.setText(String.valueOf(total_sum+"calories"));


        //   int id=getIntent().getIntExtra("value",0);
        //  add_edt1.setText(id);
        sharedPref = getSharedPreferences("type", Context.MODE_PRIVATE);
        String typ=sharedPref.getString("types","");

        switch (typ){
            case "gain":
                if (a!=0&&b!=0&&c!=0&&d!=0){
                 total=total_sum-extra_caloriesgain;
                    if (total_sum>extra_caloriesgain){
                        alarmText.setText(String.valueOf("You need some calories loss:"+total+"calories"));

                    }
                    else {
                        alarmText.setText(String.valueOf("You need some calories growth:"+total+"calories"));
                    }
                }
                break;
            case "maintain":
                if (a!=0&&b!=0&&c!=0&&d!=0) {
                    total = total_sum - extra_caloriesmaintain;
                    if (total_sum>extra_caloriesgain){
                        alarmText.setText(String.valueOf("Some calories loss :"+total+"calories"));

                    }
                    else {
                        alarmText.setText(String.valueOf(" Some calories growth :"+total+"calories"));
                    }
                }
                break;
            case "loss":
                if (a!=0&&b!=0&&c!=0&&d!=0) {
                    total = total_sum - extra_caloriesmainloss;
                    if (total_sum>extra_caloriesgain){
                        alarmText.setText(String.valueOf("You need some calories loss:"+total+"calories"));

                    }
                    else {
                        alarmText.setText(String.valueOf("You need some calories growth:"+total+"calories"));
                    }
                }
                break;
            default:
                alarmText.setText("00 calories");
        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(Add_Food.this,Search_Food.class);
                startActivity(intent1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(Add_Food.this,Search_Lunch.class);
                startActivity(intent2);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3=new Intent(Add_Food.this,Search_Dinner.class);
                startActivity(intent3);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4=new Intent(Add_Food.this,Search_Snacks.class);
                startActivity(intent4);
            }
        });



    }
}


package com.smartalarm.new_maha;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Search_Food extends AppCompatActivity {
    public EditText search_food,add_searchText;
    private TextView add_calories;
    public Button button,add_data;
    String[] items;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    ArrayList<HashMap<String,String>> itemlist;
    ArrayAdapter<String> arrayAdapter,arrayAdapter2;
    ListView listView,list_add;
    ArrayList<String> listitem2;
    int a,i, sum  = 0;
    String shift = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search__food);
        // add_searchText=(EditText) findViewById(R.id.add_searchText);

        button=(Button) findViewById(R.id.send_data);
        add_data=(Button) findViewById(R.id.add_data);
        sharedPref=getSharedPreferences("puzzle", Context.MODE_PRIVATE);
        editor=sharedPref.edit();
        // shift = getIntent().getStringExtra("shift");
        editor.remove("type");
        editor.commit();
        add_calories=(TextView) findViewById(R.id.add_calories);
//       recyclerView=(RecyclerView) findViewById(R.id.recycal_view);
//      recyclerView.setHasFixedSize(true);
//
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final String Food_list[]={"bread(one piece)","Ruti(1 piece)","Tea(one cup)","Powder Milk(100gm)","Sugar (100gm)",
                "Tea and coffee(with out milk and sugar)","Banana","an Apple","egg(one)","Yellow split peas 100gm","Wheat 100gm",
                "Tuna fish 100gm","Trout 100gm","Taki fish 100gm","Shrimp 100gm",
                "Sola fish 100gm","Tilapia fish 100gm","Coconut oil 100gm","Rohu carp 100gm",
                "Red lentil 100gm","Puffed rice 100gm","Red Spinach 100gm",
                "Pudding fish  100gm","Pomfret 100gm", "Pears 100gm", "Peanut butter 100gm",
                "Parched rice 100gm", "Palanpur  100gm", "Olive oil(1 table spoon)", "Oats 100gm","Mung beans 100gm",
                "Corn  100gm","Jackfruit 100gm","Hilsha  100gm", "Hilsha  100gm", "Grass pea 100gm", "Ghee  100gm",
                "Duck meat 100gm","Mango(100gm)","Malta (100gm)","Grapes(100gm)","Litchi(100gm)","Lime(100gm)",
                "Orange(100gm)","Papaya(100gm)","Pineapple(100gm)","Strawverry(100gm)",
                "Water-melon(100gm)","Puffed rich(100gm)","Cashew nuts(100gm)","Chira(100gm)","Cucumber(100gm)","Sour yogurt(100gm)",
                "Shrimp (100gm)","Rubbing(100gm)","Sola fish(100gm)","Taki mach(100gm)","Tilapia fish(100gm)","Trout (100gm)",
                "Tuna fish (100gm)",
                "Wheat (100gm)","almonds(100gm)","bean(100gm)","beef(100gm)","blackcurrant(100gm)","mushroom(100g)","mutton(100gm)",
                "onion(100gm)",
                "peanust(100g)","pistachios(100gm)","potatoes(100gm)","quail egg(one piece)","radish(100gm)","red capsicum(100gm)",
                "red flour (100gm )","silver carp(100gm)","potato(100gm)","melon(100gm)","white flour (100gm)","Rice"};
        listView=(ListView) findViewById(R.id.list_view);
        search_food=(EditText) findViewById(R.id.search_food);
        arrayAdapter=new ArrayAdapter<String>(this,R.layout.searchlistitem,R.id.textsearch_food,Food_list);
        listView.setAdapter(arrayAdapter);

        search_food.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int i, int i1, int i2) {
                Search_Food.this.arrayAdapter.getFilter().filter(cs);

            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String listviewaValue = Food_list[i].toString();
                search_food.setText(arrayAdapter.getItem(i).toString());

            }

        });


        list_add=(ListView) findViewById(R.id.list_add);
        String[] addlistitem={};
        listitem2=new ArrayList<>(Arrays.asList(addlistitem));
        arrayAdapter2=new ArrayAdapter<String>(this,R.layout.add_searchlist,R.id.addsearchlist_food,listitem2);
        list_add.setAdapter(arrayAdapter2);

        add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a=0;
                String newItem=search_food.getText().toString();
                search_food.setText("");
                if (Food_list[0].equals(newItem)) {
                    a=a+80;
                } else if (Food_list[1].equals(newItem)) {
                    a=a+80;
                } else if (Food_list[2].equals(newItem)) {
                    a=a+25;
                } else if (Food_list[3].equals(newItem)) {
                    a=a+496;
                } else if (Food_list[4].equals(newItem)) {
                    a=a+398 ;
                } else if (Food_list[5].equals(newItem)) {
                    a=a+1;
                } else if (Food_list[6].equals(newItem)) {
                    a=a+98;
                } else if (Food_list[7].equals(newItem)) {
                    a=a+86;
                } else if (Food_list[8].equals(newItem)) {
                    a=a+146;
                } else if (Food_list[9].equals(newItem)) {
                    a=a+327;
                } else if (Food_list[10].equals(newItem)) {
                    a=a+344;
                } else if (Food_list[11].equals(newItem)) {
                    a=a+102;
                } else if (Food_list[12].equals(newItem)) {
                    a=a+80;
                } else if (Food_list[13].equals(newItem)) {
                    a=a+91;
                } else if (Food_list[14].equals(newItem)) {
                    a=a+100;
                } else if (Food_list[15].equals(newItem)) {
                    a=a+101;
                } else if (Food_list[16].equals(newItem)) {
                    a=a+93;
                } else if (Food_list[17].equals(newItem)) {
                    a=a+38;
                } else if (Food_list[18].equals(newItem)) {
                    a=a+177;
                } else if (Food_list[19].equals(newItem)) {
                    a=a+88;
                } else if (Food_list[20].equals(newItem)) {
                    a=a+356;
                } else if (Food_list[21].equals(newItem)) {
                    a=a+23;
                } else if (Food_list[22].equals(newItem)) {
                    a=a+95;
                } else if (Food_list[23].equals(newItem)) {
                    a=a+80;
                } else if (Food_list[24].equals(newItem)) {
                    a=a+108;
                } else if (Food_list[25].equals(newItem)) {
                    a=a+97;
                } else if (Food_list[26].equals(newItem)) {
                    a=a+588;
                } else if (Food_list[27].equals(newItem)) {
                    a=a+361;
                } else if (Food_list[28].equals(newItem)) {
                    a=a+135;
                } else if (Food_list[29].equals(newItem)) {
                    a=a+344;
                } else if (Food_list[30].equals(newItem)) {
                    a=a+351;
                } else if (Food_list[31].equals(newItem)) {
                    a=a+344;
                } else if (Food_list[32].equals(newItem)) {
                    a=a+95;
                } else if (Food_list[33].equals(newItem)) {
                    a=a+273;
                } else if (Food_list[34].equals(newItem)) {
                    a=a+273;
                } else if (Food_list[35].equals(newItem)) {
                    a=a+352;
                } else if (Food_list[36].equals(newItem)) {
                    a=a+900;
                } else if (Food_list[37].equals(newItem)) {
                    a=a+404;
                } else if (Food_list[38].equals(newItem)) {
                    a=a+60;
                } else if (Food_list[39].equals(newItem)) {
                    a=a+53;
                } else if (Food_list[40].equals(newItem)) {
                    a=a+67;
                } else if (Food_list[41].equals(newItem)) {
                    a=a+66;
                } else if (Food_list[42].equals(newItem)) {
                    a=a+29;
                } else if (Food_list[43].equals(newItem)) {
                    a=a+47;
                } else if (Food_list[44].equals(newItem)) {
                    a=a+42;
                } else if (Food_list[45].equals(newItem)) {
                    a=a+50;
                } else if (Food_list[46].equals(newItem)) {
                    a=a+36;
                } else if (Food_list[47].equals(newItem)) {
                    a=a+30;
                } else if (Food_list[48].equals(newItem)) {
                    a=a+356;
                } else if (Food_list[49].equals(newItem)) {
                    a=a+553;
                } else if (Food_list[50].equals(newItem)) {
                    a=a+356;
                } else if (Food_list[51].equals(newItem)) {
                    a=a+18;
                } else if (Food_list[52].equals(newItem)) {
                    a=a+100;
                } else if (Food_list[53].equals(newItem)) {
                    a=a+100;
                }
                else if (Food_list[54].equals(newItem)) {
                    a=a+101;
                }
                else if (Food_list[55].equals(newItem)) {
                    a=a+101;
                }
                else if (Food_list[56].equals(newItem)) {
                    a=a+91;
                }
                else if (Food_list[57].equals(newItem)) {
                    a=a+93;
                }
                else if (Food_list[58].equals(newItem)) {
                    a=a+101;
                }
                else if (Food_list[59].equals(newItem)) {
                    a=a+80;
                }
                else if (Food_list[60].equals(newItem)) {
                    a=a+344;
                }
                else if (Food_list[61].equals(newItem)) {
                    a=a+619;
                }
                else if (Food_list[62].equals(newItem)) {
                    a=a+33;
                }
                else if (Food_list[63].equals(newItem)) {
                    a=a+239;
                }
                else if (Food_list[64].equals(newItem)) {
                    a=a+57;
                }
                else if (Food_list[65].equals(newItem)) {
                    a=a+28;
                }
                else if (Food_list[66].equals(newItem)) {
                    a=a+105;
                }
                else if (Food_list[67].equals(newItem)) {
                    a=a+44;
                }
                else if (Food_list[68].equals(newItem)) {
                    a=a+626;
                }
                else if (Food_list[69].equals(newItem)) {
                    a=a+562;
                }
                else if (Food_list[70].equals(newItem)) {
                    a=a+78;
                }
                else if (Food_list[71].equals(newItem)) {
                    a=a+15;
                }
                else if (Food_list[72].equals(newItem)) {
                    a=a+18;
                }
                else if (Food_list[73].equals(newItem)) {
                    a=a+32;
                } else if (Food_list[74].equals(newItem)) {
                    a=a+24;
                }
                else if (Food_list[75].equals(newItem)) {
                    a=a+123;
                } else if (Food_list[76].equals(newItem)) {
                    a=a+78;
                } else if (Food_list[77].equals(newItem)) {
                    a=a+34;
                } else if (Food_list[78].equals(newItem)) {
                    a=a+347;
                }
                else if (Food_list[79].equals(newItem)) {
                    a=a+200;
                }
                else {
                    Toast.makeText(Search_Food.this,"data is not found",Toast.LENGTH_LONG).show();
                }
                sum += a;
               // listitem2.add(newItem);
                Toast.makeText(Search_Food.this,"Add food :"+newItem,Toast.LENGTH_LONG).show();

                arrayAdapter2.notifyDataSetChanged();
//                int n=Integer.parseInt(listitem2.toString());
//                for (i=0;i<=n;i++){
//                   a=a+i;
//                }
              //  add_calories.setText(String.valueOf(sum));
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Search_Food.this,Add_Food.class);
                editor.putInt("type",sum);
                editor.commit();
//                intent.putExtra("sum", Integer.toString(sum));
//                intent.putExtra("shift", shift);
                startActivity(intent);

            }
        });





    }


}
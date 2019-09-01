package com.smartalarm.new_maha;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    public TextView extra_calories,edit,edit1,edit2,range,kg_pound;
    public Button btn1,btn2,btn3;
    public EditText edt1,edt2,edt3,edt4,edt7;
    public DrawerLayout dl;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    public FirebaseAuth firebaseAuth;
    public FirebaseDatabase firebaseDatabase;
    public FirebaseUser user;
    public Double result,result_second,a,c,height,age,weight,b,inch;
    public  Double pc,subtraction;
    public Double h;
    public String s1="Female";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();

        dl = (DrawerLayout) findViewById(R.id.dl);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);

        dl.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        View view = getLayoutInflater().inflate(R.layout.activity_total__calories, null);
        edt1 = (EditText) view.findViewById(R.id.edt1);
        edt2 = (EditText) view.findViewById(R.id.edt2);
        edt3 = (EditText) view.findViewById(R.id.edt3);
        edt4 = (EditText) view.findViewById(R.id.edt4);
        edt7 = (EditText) view.findViewById(R.id.edt7);

        extra_calories = (TextView) findViewById(R.id.extra_calories);
//           btn1=(Button) findViewById(R.id.btn1);
//            btn2=(Button) findViewById(R.id.btn2);
//            btn3=(Button) findViewById(R.id.btn3);
        edit = (TextView) findViewById(R.id.edit);
        edit1 = (TextView) findViewById(R.id.edit1);
        edit2 = (TextView) findViewById(R.id.edit2);
        range=(TextView) findViewById(R.id.range);
        kg_pound=(TextView) findViewById(R.id.kg_pound);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase= FirebaseDatabase.getInstance();
        user=firebaseAuth.getCurrentUser();
        if (user!=null){
            DatabaseReference myRef = firebaseDatabase.getReference(user.getUid());
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Profile profile=dataSnapshot.getValue(Profile.class);

                    edt1.setText(profile.getHeight());
                    edt2.setText(profile.getWeidth());
                    edt3.setText(profile.getGender());
                    edt4.setText(profile.getAge());
                    edt7.setText(profile.getInch());
                    String s2=edt3.getText().toString();
                    height=Double.parseDouble(edt1.getText().toString());
                    weight=Double.parseDouble(edt2.getText().toString());
                    age=Double.parseDouble(edt4.getText().toString());
                    inch=Double.parseDouble(edt7.getText().toString());
                    if(s1.equals(s2)){

                        a=weight*2.2;
                        b=height*12;
                        c=4.7*age;
                        result=655+4.35*a+4.7*(b+inch)-c;
                        edit.setText(result+" Calories");

                    }
                    else {
                        a=weight*2.2;
                        b=height*12;
                        c=6.8*age;
                        result=66+6.23*a+12.7*(b+inch)-c;
                        edit.setText(result+" Calories");

                    }



                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(MainActivity.this,databaseError.getCode(),Toast.LENGTH_LONG).show();
                }
            });

        }
  kg_pound.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          PopupMenu popupMenu=new PopupMenu(MainActivity.this,kg_pound);
          popupMenu.getMenuInflater().inflate(R.menu.kg_pound,popupMenu.getMenu());
          popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
              @Override
              public boolean onMenuItemClick(MenuItem menuItem) {
                 int ID=menuItem.getItemId();
                  if (ID==R.id.pound){
                      PoundWeightShow();
                      kg_pound.setText("Pound");
                  }
                  else {
                      heightshow();
                      kg_pound.setText("Kg");
                  }
                  return true;
              }
          });
          popupMenu.show();
      }
  });


        perfechcalorishow();
        extraCaloriShow();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_bar);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                if (id == R.id.profile) {
                    Intent intent1 = new Intent(MainActivity.this, User_Profile.class);
                    startActivity(intent1);
                } else if (id == R.id.food_add) {
                    Intent intent = new Intent(MainActivity.this, Add_Food.class);
                    startActivity(intent);
                } else if (id == R.id.diet) {
                    Intent intent2 = new Intent(MainActivity.this, Diet_Page.class);
                    startActivity(intent2);
                } else if (id == R.id.help) {
                    Intent intent3 = new Intent(MainActivity.this, Hepl.class);
                    startActivity(intent3);
                } else if (id == R.id.sing_out) {
                    firebaseAuth.signOut();
                    finish();
                    startActivity(new Intent(MainActivity.this, Login_P.class));
                } else if (id == R.id.exercise) {

                    showExercise();
                }
                return true;
            }
        });

    }

    private void showExercise() {
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase= FirebaseDatabase.getInstance();
        user=firebaseAuth.getCurrentUser();

        DatabaseReference myR = firebaseDatabase.getReference(user.getUid());
        myR.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Profile pf=dataSnapshot.getValue(Profile.class);

                edt3.setText(pf.getGender());
                String s3=edt3.getText().toString();
                if(s1.equals(s3)){
                    Intent in1=new Intent(MainActivity.this,Exercise_Second.class);
                    startActivity(in1);

                }
                else {
                    Intent in=new Intent(MainActivity.this,Exercise.class);
                    startActivity(in);
                }



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(MainActivity.this,databaseError.getCode(),Toast.LENGTH_LONG).show();
            }
        });
    }


    private void perfechcalorishow() {

        firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase= FirebaseDatabase.getInstance();
        user=firebaseAuth.getCurrentUser();
        if (user!=null){
            DatabaseReference myRef3 = firebaseDatabase.getReference(user.getUid());
            myRef3.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Profile profile3=dataSnapshot.getValue(Profile.class);

                    edt1.setText(profile3.getHeight());
                    edt2.setText(profile3.getWeidth());
                    edt3.setText(profile3.getGender());
                    edt4.setText(profile3.getAge());
                    edt7.setText(profile3.getInch());
                    String s4=edt3.getText().toString();
                    height=Double.parseDouble(edt1.getText().toString());
                    weight=Double.parseDouble(edt2.getText().toString());
                    age=Double.parseDouble(edt4.getText().toString());
                    inch=Double.parseDouble(edt7.getText().toString());
                    pc=(height*12)+inch;
                    if(s1.equals(s4)){
                        if(pc==54){
                            a=45*2.2;
                            c=4.7*age;
                            result_second=655+4.35*a+4.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        }
                        else if (pc==55){
                            a=46*2.2;
                            c=4.7*age;
                            result_second=655+4.35*a+4.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        }

                        else if (pc==56){
                            a=47*2.2;
                            c=4.7*age;
                            result_second=655+4.35*a+4.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        }
                        else if (pc==57){
                            a=49*2.2;
                            c=4.7*age;
                            result_second=655+4.35*a+4.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        }
                        else if (pc==58){
                            a=50*2.2;
                            c=4.7*age;
                            result_second=655+4.35*a+4.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        }
                        else if (pc==59){
                            a=51*2.2;
                            c=4.7*age;
                            result_second=655+4.35*a+4.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        }
                        else if (pc==60){
                            a=53*2.2;
                            c=4.7*age;
                            result_second=655+4.35*a+4.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        }
                        else if (pc==61){
                            a=54*2.2;
                            c=4.7*age;
                            result_second=655+4.35*a+4.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        }
                        else if (pc==62){
                            a=55*2.2;
                            c=4.7*age;
                            result_second=655+4.35*a+4.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        }
                        else if (pc==63){
                            a=57*2.2;
                            c=4.7*age;
                            result_second=655+4.35*a+4.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        }
                        else if (pc==64){
                            a=58*2.2;
                            c=4.7*age;
                            result_second=655+4.35*a+4.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        }
                        else if (pc==65){
                            a=60*2.2;
                            c=4.7*age;
                            result_second=655+4.35*a+4.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        }
                        else if (pc==66){
                            a=61*2.2;
                            c=4.7*age;
                            result_second=655+4.35*a+4.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        } else if (pc==67){
                            a=62*2.2;
                            c=4.7*age;
                            result_second=655+4.35*a+4.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        } else if (pc==68){
                            a=64*2.2;
                            c=4.7*age;
                            result_second=655+4.35*a+4.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        } else if (pc==69){
                            a=65*2.2;
                            c=4.7*age;
                            result_second=655+4.35*a+4.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        } else if (pc==70){
                            a=67*2.2;
                            c=4.7*age;
                            result_second=655+4.35*a+4.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        } else if (pc==71){
                            a=68*2.2;
                            c=4.7*age;
                            result_second=655+4.35*a+4.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        } else if (pc==72){
                            a=69*2.2;
                            c=4.7*age;
                            result_second=655+4.35*a+4.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        }
                        else if (pc==73){
                            a=71*2.2;
                            c=4.7*age;
                            result_second=655+4.35*a+4.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        }
                        else if (pc==74){
                            a=72*2.2;
                            c=4.7*age;
                            result_second=655+4.35*a+4.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        }
                        else {
                            edit1.setText(" error");
                        }

                    }
                    else {
                        if (pc==54){
                            a=45*2.2;
                            c=6.8*age;
                            result_second=66+6.23*a+12.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        }
                        else if (pc==55){
                            a=46*2.2;
                            c=6.8*age;
                            result_second=66+6.23*a+12.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        }
                        else if (pc==56){
                            a=47*2.2;
                            c=6.8*age;
                            result_second=66+6.23*a+12.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        }
                        else if (pc==57){
                            a=49*2.2;
                            c=6.8*age;
                            result_second=66+6.23*a+12.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        }
                        else if (pc==58){
                            a=50*2.2;
                            c=6.8*age;
                            result_second=66+6.23*a+12.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        }
                        else if (pc==59){
                            a=51*2.2;
                            c=6.8*age;
                            result_second=66+6.23*a+12.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        }else if (pc==60){
                            a=53*2.2;
                            c=6.8*age;
                            result_second=66+6.23*a+12.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        }else if (pc==61){
                            a=54*2.2;
                            c=6.8*age;
                            result_second=66+6.23*a+12.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        }
                        else if (pc==62){
                            a=55*2.2;
                            c=6.8*age;
                            result_second=66+6.23*a+12.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        }
                        else if (pc==63){
                            a=57*2.2;
                            c=6.8*age;
                            result_second=66+6.23*a+12.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        }
                        else if (pc==64){
                            a=58*2.2;
                            c=6.8*age;
                            result_second=66+6.23*a+12.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        }
                        else if (pc==65){
                            a=60*2.2;
                            c=6.8*age;
                            result_second=66+6.23*a+12.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        }
                        else if (pc==66){
                            a=61*2.2;
                            c=6.8*age;
                            result_second=66+6.23*a+12.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        }
                        else if (pc==67){
                            a=62*2.2;
                            c=6.8*age;
                            result_second=66+6.23*a+12.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        }
                        else if (pc==68){
                            a=64*2.2;
                            c=6.8*age;
                            result_second=66+6.23*a+12.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        }else if (pc==69){
                            a=65*2.2;
                            c=6.8*age;
                            result_second=66+6.23*a+12.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        }
                        else if (pc==70){
                            a=67*2.2;
                            c=6.8*age;
                            result_second=66+6.23*a+12.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        }
                        else if (pc==71){
                            a=68*2.2;
                            c=6.8*age;
                            result_second=66+6.23*a+12.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        }
                        else if (pc==72){
                            a=69*2.2;
                            c=6.8*age;
                            result_second=66+6.23*a+12.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        }
                        else if (pc==73){
                            a=71*2.2;
                            c=6.8*age;
                            result_second=66+6.23*a+12.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        }
                        else if (pc==74){
                            a=72*2.2;
                            c=6.8*age;
                            result_second=66+6.23*a+12.7*pc-c;
                            edit1.setText(result_second+" Calories");

                        }
                        else {
                            edit1.setText(" error");
                        }


                    }


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(MainActivity.this,databaseError.getCode(),Toast.LENGTH_LONG).show();
                }
            });

        }

    }
    private void extraCaloriShow() {
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase= FirebaseDatabase.getInstance();
        user=firebaseAuth.getCurrentUser();
        DatabaseReference myRef3 = firebaseDatabase.getReference(user.getUid());
        myRef3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Profile profile3=dataSnapshot.getValue(Profile.class);

                subtraction=result_second-result;
                if (subtraction>0){
                    extra_calories.setText("You need some calories growth="+subtraction);
                }
                else {
                    extra_calories.setText("You need some calories loss="+subtraction);
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(MainActivity.this,databaseError.getCode(),Toast.LENGTH_LONG).show();
            }
        });
    }

    private void PoundWeightShow() {
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        user = firebaseAuth.getCurrentUser();
        if (user!=null){
            DatabaseReference myRef2 = firebaseDatabase.getReference(user.getUid());
            myRef2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Profile profile2 = dataSnapshot.getValue(Profile.class);

                    edt1.setText(profile2.getHeight());
                    edt7.setText(profile2.getInch());
                    height = Double.parseDouble(edt1.getText().toString());
                    inch = Double.parseDouble(edt7.getText().toString());
                    int a=Integer.parseInt(edt1.getText().toString());
                    int inc=Integer.parseInt(edt7.getText().toString());

                    h = (height * 12) + inc;

                    if (h == 54) {
                        edit2.setText("99.02pound");
                        range.setText("Min :77 - Max :103.4 pound");
                    } else if (h == 55) {
                        edit2.setText("102pound");
                        range.setText("Min :61.4 - Max :105.6 pound");
                    } else if (h == 56) {
                        edit2.setText("103.4pound");
                        range.setText("Min :83.6 - Max :110 pound");
                    } else if (h == 57) {
                        edit2.setText("107.8pound");
                        range.setText("Min :85.8 - Max :114.4 pound");
                    } else if (h == 58) {
                        edit2.setText("110pound");
                        range.setText("Min :90.2 - Max :118.8 poun");
                    } else if (h == 59) {
                        edit2.setText("112.2pound");
                        range.setText("Min :92.4 - Max :123.2 pound");
                    } else if (h == 60) {
                        edit2.setText("116.6pound");
                        range.setText("Min :94.6 - Max :127.6 pound");
                    } else if (h == 61) {
                        edit2.setText("54kg");
                        range.setText("Min :99 - Max :132 pound");
                    } else if (h == 62) {
                        edit2.setText("118.8");
                        range.setText("Min :101.2 - Max :134.2 pound");
                    } else if (h == 63) {
                        edit2.setText("125.4pound");
                        range.setText("Min :105.6 - Max :140.8 pound");
                    } else if (h == 64) {
                        edit2.setText("127.6pound");
                        range.setText("Min :107.8 - Max :145.2 pound");
                    } else if (h == 65) {
                        edit2.setText("132pound");
                        range.setText("Min :112.2 - Max :149.6 pound");
                    } else if (h == 66) {
                        edit2.setText("134.2pound");
                        range.setText("Min :114.4 - Max :154 pound");
                    } else if (h == 67) {
                        edit2.setText("136.2pound");
                        range.setText("Min :118.8 - Max :158.4 pound");
                    } else if (h == 68) {
                        edit2.setText("140.8pound");
                        range.setText("Min :123.2 - Max :162.8 pound");
                    } else if (h == 69) {
                        edit2.setText("143pound");
                        range.setText("Min :125.4 - Max :167.2 pound");
                    } else if (h == 70) {
                        edit2.setText("147.4pound");
                        range.setText("Min :129.8 - Max :173.8 pound");
                    } else if (h == 71) {
                        edit2.setText("149.6pound");
                        range.setText("Min :61 - Max :81 kg");
                    } else if (h == 72) {
                        edit2.setText("151.8pound");
                        range.setText("Min :134.2 - Max :184.8 pound");
                    } else if (h == 73) {
                        edit2.setText("156.2pound");
                        range.setText("Min :140.8 - Max :187 pound");
                    } else if (h == 74) {
                        edit2.setText("158.4pound");
                        range.setText("Min :145.2 - Max :193.6 pound");
                    } else {
                        edit2.setText("error");
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(MainActivity.this, databaseError.getCode(), Toast.LENGTH_LONG).show();
                }
            });
        }

 }
    private void heightshow() {
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        user = firebaseAuth.getCurrentUser();
        if (user!=null){
            DatabaseReference myRef2 = firebaseDatabase.getReference(user.getUid());
            myRef2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Profile profile2 = dataSnapshot.getValue(Profile.class);

                    edt1.setText(profile2.getHeight());
                    edt7.setText(profile2.getInch());
                    height = Double.parseDouble(edt1.getText().toString());
                    inch = Double.parseDouble(edt7.getText().toString());
                    int a=Integer.parseInt(edt1.getText().toString());
                    int inc=Integer.parseInt(edt7.getText().toString());

                    h = (height * 12) + inc;

                    if (h == 54) {
                        edit2.setText("47 kg");
                        range.setText("Min :35 - Max :47 kg");
                    } else if (h == 55) {
                        edit2.setText("46 kg");
                        range.setText("Min :37 - Max :48 kg");
                    } else if (h == 56) {
                        edit2.setText("47 kg");
                        range.setText("Min :38 - Max :50 kg");
                    } else if (h == 57) {
                        edit2.setText("49 kg");
                        range.setText("Min :39 - Max :52 kg");
                    } else if (h == 58) {
                        edit2.setText("50 kg");
                        range.setText("Min :41 - Max :54 kg");
                    } else if (h == 59) {
                        edit2.setText("51kg");
                        range.setText("Min :42 - Max :56 kg");
                    } else if (h == 60) {
                        edit2.setText("53kg");
                        range.setText("Min :43 - Max :58 kg");
                    } else if (h == 61) {
                        edit2.setText("54kg");
                        range.setText("Min :45 - Max :60 kg");
                    } else if (h == 62) {
                        edit2.setText("55kg");
                        range.setText("Min :46 - Max :61 kg");
                    } else if (h == 63) {
                        edit2.setText("57kg");
                        range.setText("Min :48 - Max :64 kg");
                    } else if (h == 64) {
                        edit2.setText("58kg");
                        range.setText("Min :49 - Max :66 kg");
                    } else if (h == 65) {
                        edit2.setText("60kg");
                        range.setText("Min :51 - Max :68 kg");
                    } else if (h == 66) {
                        edit2.setText("61kg");
                        range.setText("Min :52 - Max :70 kg");
                    } else if (h == 67) {
                        edit2.setText("62kg");
                        range.setText("Min :54 - Max :72 kg");
                    } else if (h == 68) {
                        edit2.setText("64kg");
                        range.setText("Min :56 - Max :74 kg");
                    } else if (h == 69) {
                        edit2.setText("65kg");
                        range.setText("Min :57 - Max :76 kg");
                    } else if (h == 70) {
                        edit2.setText("67kg");
                        range.setText("Min :59 - Max :79 kg");
                    } else if (h == 71) {
                        edit2.setText("68kg");
                        range.setText("Min :61 - Max :81 kg");
                    } else if (h == 72) {
                        edit2.setText("69kg");
                        range.setText("Min :62 - Max :84 kg");
                    } else if (h == 73) {
                        edit2.setText("71kg");
                        range.setText("Min :64 - Max :85 kg");
                    } else if (h == 74) {
                        edit2.setText("72kg");
                        range.setText("Min :66 - Max :88 kg");
                    } else {
                        edit2.setText("error");
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(MainActivity.this, databaseError.getCode(), Toast.LENGTH_LONG).show();
                }
            });
        }

    }
          @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       return actionBarDrawerToggle.onOptionsItemSelected(item)|| super.onOptionsItemSelected(item);
  }


}

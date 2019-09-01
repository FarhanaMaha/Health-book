package com.smartalarm.new_maha;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class Exercise_Second extends AppCompatActivity {
    private GifImageView gifiImageviwe2,gifImageview_second1,gifImageview_second2,gifImageview_second3,gifImageview_second4,
            gifImageview_second5,gifImageview_second6,gifImageview_second7,gifImageview_second8,gifImageview_second9,
            gifImageview_second10,
            gifImageview_second11,gifImageview_second12,gifImageview_second13,
            gifImageview_second14,gifImageview_second15,gifImageview_second16,gifImageview_second17,
            gifImageview_second18,gifImageview_second19;

    public TextView one_f, two_f, third_f, four_f, five_f, six_f, seven_f, eight_f, nine_f, ten_f, eleven_f, twelve_f,
            thirteen_f, fourteen_f, fifteen_f, sixteen_f, seventeen_f, eighteen_f, nineteen_f, tweenty_f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise__second);
        gifiImageviwe2 = (GifImageView) findViewById(R.id.gifImageview_second);
        gifImageview_second1 = (GifImageView) findViewById(R.id.gifImageview_second1);
        gifImageview_second2 = (GifImageView) findViewById(R.id.gifImageview_second2);
        gifImageview_second3 = (GifImageView) findViewById(R.id.gifImageview_second3);
        gifImageview_second4 = (GifImageView) findViewById(R.id.gifImageview_second4);
        gifImageview_second5 = (GifImageView) findViewById(R.id.gifImageview_second5);
        gifImageview_second6 = (GifImageView) findViewById(R.id.gifImageview_second6);
        gifImageview_second7 = (GifImageView) findViewById(R.id.gifImageview_second7);
        gifImageview_second8 = (GifImageView) findViewById(R.id.gifImageview_second8);
        gifImageview_second9 = (GifImageView) findViewById(R.id.gifImageview_second9);
        gifImageview_second10 = (GifImageView) findViewById(R.id.gifImageview_second10);
        gifImageview_second11 = (GifImageView) findViewById(R.id.gifImageview_second11);
        gifImageview_second12 = (GifImageView) findViewById(R.id.gifImageview_second12);
        gifImageview_second13 = (GifImageView) findViewById(R.id.gifImageview_second13);
        gifImageview_second14 = (GifImageView) findViewById(R.id.gifImageview_second14);
        gifImageview_second15 = (GifImageView) findViewById(R.id.gifImageview_second15);
        gifImageview_second16 = (GifImageView) findViewById(R.id.gifImageview_second16);
        gifImageview_second17 = (GifImageView) findViewById(R.id.gifImageview_second17);
        gifImageview_second18 = (GifImageView) findViewById(R.id.gifImageview_second18);
        gifImageview_second19 = (GifImageView) findViewById(R.id.gifImageview_second19);

        one_f = (TextView) findViewById(R.id.fe_one);
        two_f = (TextView) findViewById(R.id.fe_two);
        third_f = (TextView) findViewById(R.id.fe_three);
        four_f = (TextView) findViewById(R.id.fe_four);
        five_f = (TextView) findViewById(R.id.fe_five);
        six_f = (TextView) findViewById(R.id.fe_six);
        seven_f = (TextView) findViewById(R.id.fe_seven);
        eight_f = (TextView) findViewById(R.id.fe_eight);
        nine_f = (TextView) findViewById(R.id.fe_nine);
        ten_f = (TextView) findViewById(R.id.fe_ten);
        eleven_f = (TextView) findViewById(R.id.fe_eleven);
        twelve_f = (TextView) findViewById(R.id.fe_twelve);
        thirteen_f = (TextView) findViewById(R.id.fe_thirteen);
        fourteen_f = (TextView) findViewById(R.id.fe_fourteen);
        fifteen_f = (TextView) findViewById(R.id.fe_fifteen);
        sixteen_f = (TextView) findViewById(R.id.fe_sixteen);
        seventeen_f = (TextView) findViewById(R.id.fe_seventeen);
        eighteen_f = (TextView) findViewById(R.id.fe_eighteen);
        nineteen_f = (TextView) findViewById(R.id.fe_nineteen);
        tweenty_f = (TextView) findViewById(R.id.fe_tweenty);


        one_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream inputStream = getAssets().open("fe_one.gif");
                    byte[] bytes = IOUtils.toByteArray(inputStream);
                    gifiImageviwe2.setBytes(bytes);
                    gifiImageviwe2.startAnimation();
                } catch (IOException ex) {

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                  finish();
                    }
                }, 12000);
            }
        });
        two_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream inputStream = getAssets().open("fe_two.gif");
                    byte[] bytes = IOUtils.toByteArray(inputStream);
                    gifImageview_second1.setBytes(bytes);
                    gifImageview_second1.startAnimation();
                } catch (IOException ex) {

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                }, 12000);
            }
        });
        third_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream inputStream = getAssets().open("fe_three.gif");
                    byte[] bytes = IOUtils.toByteArray(inputStream);
                    gifImageview_second2.setBytes(bytes);
                    gifImageview_second2.startAnimation();
                } catch (IOException ex) {
                    finish();
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                }, 12000);
            }
        });
        four_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream inputStream = getAssets().open("fe_four.gif");
                    byte[] bytes = IOUtils.toByteArray(inputStream);
                    gifImageview_second3.setBytes(bytes);
                    gifImageview_second3.startAnimation();
                } catch (IOException ex) {

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                         finish();
                    }
                }, 12000);
            }
        });
        five_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream inputStream = getAssets().open("fe_five.gif");
                    byte[] bytes = IOUtils.toByteArray(inputStream);
                    gifImageview_second4.setBytes(bytes);
                    gifImageview_second4.startAnimation();
                } catch (IOException ex) {

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                          finish();
                    }
                }, 12000);
            }
        });
        six_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream inputStream = getAssets().open("fe_six.gif");
                    byte[] bytes = IOUtils.toByteArray(inputStream);
                    gifImageview_second5.setBytes(bytes);
                    gifImageview_second5.startAnimation();
                } catch (IOException ex) {

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                          finish();
                    }
                }, 12000);
            }
        });
        seven_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream inputStream = getAssets().open("fe_seven.gif");
                    byte[] bytes = IOUtils.toByteArray(inputStream);
                    gifImageview_second6.setBytes(bytes);
                    gifImageview_second6.startAnimation();
                } catch (IOException ex) {

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                         finish();
                    }
                }, 12000);
            }
        });
        eight_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream inputStream = getAssets().open("fe_eight.gif");
                    byte[] bytes = IOUtils.toByteArray(inputStream);
                    gifImageview_second7.setBytes(bytes);
                    gifImageview_second7.startAnimation();
                } catch (IOException ex) {

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                          finish();
                    }
                }, 12000);
            }
        });
        nine_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream inputStream = getAssets().open("fe_nine.gif");
                    byte[] bytes = IOUtils.toByteArray(inputStream);
                    gifImageview_second8.setBytes(bytes);
                    gifImageview_second8.startAnimation();
                } catch (IOException ex) {

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                         finish();
                    }
                }, 12000);
            }
        });
        ten_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream inputStream = getAssets().open("fe_ten.gif");
                    byte[] bytes = IOUtils.toByteArray(inputStream);
                    gifImageview_second9.setBytes(bytes);
                    gifImageview_second9.startAnimation();
                } catch (IOException ex) {

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                }, 12000);
            }
        });
        eleven_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream inputStream = getAssets().open("fe_eleven.gif");
                    byte[] bytes = IOUtils.toByteArray(inputStream);
                    gifImageview_second10.setBytes(bytes);
                    gifImageview_second10.startAnimation();
                } catch (IOException ex) {

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                }, 12000);
            }
        });
        twelve_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream inputStream = getAssets().open("fe_twelve.gif");
                    byte[] bytes = IOUtils.toByteArray(inputStream);
                    gifImageview_second11.setBytes(bytes);
                    gifImageview_second11.startAnimation();
                } catch (IOException ex) {

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                }, 12000);
            }
        });
        thirteen_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream inputStream = getAssets().open("fe_thirteen.gif");
                    byte[] bytes = IOUtils.toByteArray(inputStream);
                    gifImageview_second12.setBytes(bytes);
                    gifImageview_second12.startAnimation();
                } catch (IOException ex) {

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                          finish();
                    }
                }, 12000);
            }
        });
        fourteen_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream inputStream = getAssets().open("fe_fourteen.gif");
                    byte[] bytes = IOUtils.toByteArray(inputStream);
                    gifImageview_second13.setBytes(bytes);
                    gifImageview_second13.startAnimation();
                } catch (IOException ex) {

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                          finish();
                    }
                }, 12000);
            }
        });
        fifteen_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream inputStream = getAssets().open("fe_fifteen.gif");
                    byte[] bytes = IOUtils.toByteArray(inputStream);
                    gifImageview_second14.setBytes(bytes);
                    gifImageview_second14.startAnimation();
                } catch (IOException ex) {

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                          finish();
                    }
                }, 12000);
            }
        });
        sixteen_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream inputStream = getAssets().open("fe_sexteen.gif");
                    byte[] bytes = IOUtils.toByteArray(inputStream);
                    gifImageview_second15.setBytes(bytes);
                    gifImageview_second15.startAnimation();
                } catch (IOException ex) {

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                          finish();
                    }
                }, 12000);
            }
        });


        seventeen_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream inputStream = getAssets().open("fe_seventeen.gif");
                    byte[] bytes = IOUtils.toByteArray(inputStream);
                    gifImageview_second16.setBytes(bytes);
                    gifImageview_second16.startAnimation();
                } catch (IOException ex) {

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                         finish();
                    }
                }, 12000);
            }
        });

        eighteen_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream inputStream = getAssets().open("fe_eighteen.gif");
                    byte[] bytes = IOUtils.toByteArray(inputStream);
                    gifImageview_second17.setBytes(bytes);
                    gifImageview_second17.startAnimation();
                } catch (IOException ex) {

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                         finish();
                    }
                }, 12000);
            }
        });
        nineteen_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream inputStream = getAssets().open("fe_nineteen.gif");
                    byte[] bytes = IOUtils.toByteArray(inputStream);
                    gifImageview_second18.setBytes(bytes);
                    gifImageview_second18.startAnimation();
                } catch (IOException ex) {

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                         finish();
                    }
                }, 12000);
            }
        });
        tweenty_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream inputStream = getAssets().open("fe_tweenty.gif");
                    byte[] bytes = IOUtils.toByteArray(inputStream);
                    gifImageview_second19.setBytes(bytes);
                    gifImageview_second19.startAnimation();
                } catch (IOException ex) {

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                          finish();
                    }
                }, 12000);
            }
        });
    }
}

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

public class Exercise extends AppCompatActivity {
    private GifImageView gifImageView,gifiImagevi1,gifiImagevi2,gifiImagevi3,gifiImagevi4,gifiImagevi5,
            gifiImagevi6,gifiImagevi7,gifiImagevi8,gifiImagevi9,gifiImagevi10,gifiImagevi11,gifiImagevi12,gifiImagevi13,
            gifiImagevi14,gifiImagevi15,gifiImagevi16,gifiImagevi17,gifiImagevi18,gifiImagevi19,gifiImagevi20,gifiImagevi21;


    private TextView one,two,third,four,five,six,seven,eight,nine,ten,eleven,twelve,
            thirteen,fourteen,fifteen,sixteen,seventeen,eighteen,nineteen,tweenty,tweentyone,tweentwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        gifImageView=(GifImageView) findViewById(R.id.gifiImageviwe);
        //   gifiImagevi1=(GifImageView) findViewById(R.id.gifiImagevi1);
        //  gifiImagevi2=(GifImageView) findViewById(R.id.gifiImagevi2);
//        gifiImagevi3=(GifImageView) findViewById(R.id.gifiImagevi3);
//        gifiImagevi4=(GifImageView) findViewById(R.id.gifiImagevi4);
//        gifiImagevi5=(GifImageView) findViewById(R.id.gifiImagevi5);
//        gifiImagevi6=(GifImageView) findViewById(R.id.gifiImagevi6);
//        gifiImagevi7=(GifImageView) findViewById(R.id.gifiImagevi7);
//        gifiImagevi8=(GifImageView) findViewById(R.id.gifiImagevi8);
//        gifiImagevi9=(GifImageView) findViewById(R.id.gifiImagevi9);
//        gifiImagevi10=(GifImageView) findViewById(R.id.gifiImagevi10);
//        gifiImagevi11=(GifImageView) findViewById(R.id.gifiImagevi11);
//        gifiImagevi12=(GifImageView) findViewById(R.id.gifiImagevi12);
//        gifiImagevi13=(GifImageView) findViewById(R.id.gifiImagevi13);
//        gifiImagevi14=(GifImageView) findViewById(R.id.gifiImagevi14);
//        gifiImagevi15=(GifImageView) findViewById(R.id.gifiImagevi15);
//        gifiImagevi16=(GifImageView) findViewById(R.id.gifiImagevi16);
//        gifiImagevi17=(GifImageView) findViewById(R.id.gifiImagevi17);
//        gifiImagevi18=(GifImageView) findViewById(R.id.gifiImagevi18);
//        gifiImagevi19=(GifImageView) findViewById(R.id.gifiImagevi19);
//        gifiImagevi20=(GifImageView) findViewById(R.id.gifiImagevi20);
//        gifiImagevi21=(GifImageView) findViewById(R.id.gifiImagevi21);
//




        one=(TextView) findViewById(R.id.one);
        two=(TextView) findViewById(R.id.two);
        third=(TextView) findViewById(R.id.third);
        four=(TextView) findViewById(R.id.four);
        five=(TextView) findViewById(R.id.five);
        six=(TextView) findViewById(R.id.six);
        seven=(TextView) findViewById(R.id.seven);
        eight=(TextView) findViewById(R.id.eight);
        nine=(TextView) findViewById(R.id.nine);
        ten=(TextView) findViewById(R.id.ten);
        eleven=(TextView) findViewById(R.id.eleven);
        twelve=(TextView) findViewById(R.id.twelve);
        thirteen=(TextView) findViewById(R.id.thirteen);
        fourteen=(TextView) findViewById(R.id.fourteen);
        fifteen=(TextView) findViewById(R.id.fifteen);
        sixteen=(TextView) findViewById(R.id.sixteen);
        seventeen=(TextView) findViewById(R.id.seventeen);
        eighteen=(TextView) findViewById(R.id.eighteen);
        nineteen=(TextView) findViewById(R.id.nineteen);
        tweenty=(TextView) findViewById(R.id.tweenty);
        tweentyone=(TextView) findViewById(R.id.tweentyone);
        tweentwo=(TextView) findViewById(R.id.tweentwo);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    InputStream inputStream=getAssets().open("one.gif");
                    byte[] bytes= IOUtils.toByteArray(inputStream);
                    gifImageView.setBytes(bytes);
                    gifImageView.startAnimation();
                }
                catch (IOException ex){

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                          finish();
                    }
                }, 12000);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    InputStream inputStream=getAssets().open("two.gif");
                    byte[] bytes= IOUtils.toByteArray(inputStream);
//                    gifiImagevi1.setBytes(bytes);
//                    gifiImagevi1.startAnimation();
                    gifImageView.setBytes(bytes);
                    gifImageView.startAnimation();
                }
                catch (IOException ex){

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                          finish();
                    }
                }, 12000);
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    InputStream inputStream=getAssets().open("third.gif");
                    byte[] bytes= IOUtils.toByteArray(inputStream);
//                    gifiImagevi2.setBytes(bytes);
//                    gifiImagevi2.startAnimation();
                    gifImageView.setBytes(bytes);
                    gifImageView.startAnimation();
                }
                catch (IOException ex){

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                         finish();
                    }
                }, 12000);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    InputStream inputStream=getAssets().open("four.gif");
                    byte[] bytes= IOUtils.toByteArray(inputStream);
//                    gifiImagevi3.setBytes(bytes);
//                    gifiImagevi3.startAnimation();
                    gifImageView.setBytes(bytes);
                    gifImageView.startAnimation();
                }
                catch (IOException ex){

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                         finish();
                    }
                }, 12000);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    InputStream inputStream=getAssets().open("five.gif");
                    byte[] bytes= IOUtils.toByteArray(inputStream);
//                    gifiImagevi4.setBytes(bytes);
//                    gifiImagevi4.startAnimation();
                    gifImageView.setBytes(bytes);
                    gifImageView.startAnimation();
                }
                catch (IOException ex){

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                         finish();
                    }
                }, 12000);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    InputStream inputStream=getAssets().open("six.gif");
                    byte[] bytes= IOUtils.toByteArray(inputStream);
//                    gifiImagevi5.setBytes(bytes);
//                    gifiImagevi5.startAnimation();
                    gifImageView.setBytes(bytes);
                    gifImageView.startAnimation();
                }
                catch (IOException ex){

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // finish();
                    }
                }, 12000);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    InputStream inputStream=getAssets().open("seven.gif");
                    byte[] bytes= IOUtils.toByteArray(inputStream);
//                    gifiImagevi6.setBytes(bytes);
//                    gifiImagevi6.startAnimation();
                    gifImageView.setBytes(bytes);
                    gifImageView.startAnimation();
                }
                catch (IOException ex){

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                }, 12000);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    InputStream inputStream=getAssets().open("eight.gif");
                    byte[] bytes= IOUtils.toByteArray(inputStream);
//                    gifiImagevi7.setBytes(bytes);
//                    gifiImagevi7.startAnimation();
                    gifImageView.setBytes(bytes);
                    gifImageView.startAnimation();
                }
                catch (IOException ex){

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                          finish();
                    }
                }, 12000);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    InputStream inputStream=getAssets().open("nine.gif");
                    byte[] bytes= IOUtils.toByteArray(inputStream);
//                    gifiImagevi8.setBytes(bytes);
//                    gifiImagevi8.startAnimation();
                    gifImageView.setBytes(bytes);
                    gifImageView.startAnimation();
                }
                catch (IOException ex){

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                         finish();
                    }
                }, 12000);
            }
        });
        ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    InputStream inputStream=getAssets().open("ten.gif");
                    byte[] bytes= IOUtils.toByteArray(inputStream);
//                    gifiImagevi9.setBytes(bytes);
//                    gifiImagevi9.startAnimation();
                    gifImageView.setBytes(bytes);
                    gifImageView.startAnimation();
                }
                catch (IOException ex){

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                         finish();
                    }
                }, 12000);
            }
        });
        eleven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    InputStream inputStream=getAssets().open("eleven.gif");
                    byte[] bytes= IOUtils.toByteArray(inputStream);
//                    gifiImagevi10.setBytes(bytes);
//                    gifiImagevi10.startAnimation();
                    gifImageView.setBytes(bytes);
                    gifImageView.startAnimation();
                }
                catch (IOException ex){

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                          finish();
                    }
                }, 12000);
            }
        });
        twelve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    InputStream inputStream=getAssets().open("twelve.gif");
                    byte[] bytes= IOUtils.toByteArray(inputStream);
//                    gifiImagevi11.setBytes(bytes);
//                    gifiImagevi11.startAnimation();
                    gifImageView.setBytes(bytes);
                    gifImageView.startAnimation();
                }
                catch (IOException ex){

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                          finish();
                    }
                }, 12000);
            }
        });
        thirteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    InputStream inputStream=getAssets().open("thirdteen.gif");
                    byte[] bytes= IOUtils.toByteArray(inputStream);
//                    gifiImagevi12.setBytes(bytes);
//                    gifiImagevi12.startAnimation();
                    gifImageView.setBytes(bytes);
                    gifImageView.startAnimation();
                }
                catch (IOException ex){

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                          finish();
                    }
                }, 12000);
            }
        });
        fourteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    InputStream inputStream=getAssets().open("fourteen.gif");
                    byte[] bytes= IOUtils.toByteArray(inputStream);
//                    gifiImagevi13.setBytes(bytes);
//                    gifiImagevi13.startAnimation();
                    gifImageView.setBytes(bytes);
                    gifImageView.startAnimation();
                }
                catch (IOException ex){

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                          finish();
                    }
                }, 12000);
            }
        });
        fifteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    InputStream inputStream=getAssets().open("fifteen.gif");
                    byte[] bytes= IOUtils.toByteArray(inputStream);
//                    gifiImagevi14.setBytes(bytes);
//                    gifiImagevi14.startAnimation();
                    gifImageView.setBytes(bytes);
                    gifImageView.startAnimation();
                }
                catch (IOException ex){

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                         finish();
                    }
                }, 12000);
            }
        });
        sixteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    InputStream inputStream=getAssets().open("sixteen.gif");
                    byte[] bytes= IOUtils.toByteArray(inputStream);
//                    gifiImagevi15.setBytes(bytes);
//                    gifiImagevi15.startAnimation();
                    gifImageView.setBytes(bytes);
                    gifImageView.startAnimation();
                }
                catch (IOException ex){

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                         finish();
                    }
                }, 12000);
            }
        });


        seventeen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    InputStream inputStream=getAssets().open("seventeen.gif");
                    byte[] bytes= IOUtils.toByteArray(inputStream);
//                    gifiImagevi16.setBytes(bytes);
//                    gifiImagevi16.startAnimation();
                    gifImageView.setBytes(bytes);
                    gifImageView.startAnimation();
                }
                catch (IOException ex){

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                          finish();
                    }
                }, 12000);
            }
        });

        eighteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    InputStream inputStream=getAssets().open("eighteen.gif");
                    byte[] bytes= IOUtils.toByteArray(inputStream);
//                    gifiImagevi17.setBytes(bytes);
//                    gifiImagevi17.startAnimation();
                    gifImageView.setBytes(bytes);
                    gifImageView.startAnimation();
                }
                catch (IOException ex){

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                         finish();
                    }
                }, 12000);
            }
        });
        nineteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    InputStream inputStream=getAssets().open("nineteen.gif");
                    byte[] bytes= IOUtils.toByteArray(inputStream);
//                    gifiImagevi18.setBytes(bytes);
//                    gifiImagevi18.startAnimation();
                    gifImageView.setBytes(bytes);
                    gifImageView.startAnimation();
                }
                catch (IOException ex){

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                          finish();
                    }
                }, 12000);
            }
        });
        tweenty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    InputStream inputStream=getAssets().open("twnty.gif");
                    byte[] bytes= IOUtils.toByteArray(inputStream);
//                    gifiImagevi19.setBytes(bytes);
//                    gifiImagevi19.startAnimation();
                    gifImageView.setBytes(bytes);
                    gifImageView.startAnimation();
                }
                catch (IOException ex){

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                          finish();
                    }
                }, 12000);
            }
        });
        tweentyone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    InputStream inputStream=getAssets().open("twtyone.gif");
                    byte[] bytes= IOUtils.toByteArray(inputStream);
//                    gifiImagevi20.setBytes(bytes);
//                    gifiImagevi20.startAnimation();
                    gifImageView.setBytes(bytes);
                    gifImageView.startAnimation();
                }
                catch (IOException ex){

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                         finish();
                    }
                }, 12000);
            }
        });
        tweentwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    InputStream inputStream=getAssets().open("twntwo.gif");
                    byte[] bytes= IOUtils.toByteArray(inputStream);
//                    gifiImagevi21.setBytes(bytes);
//                    gifiImagevi21.startAnimation();
                    gifImageView.setBytes(bytes);
                    gifImageView.startAnimation();
                }
                catch (IOException ex){

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
package com.example.calvinseamons.apptts;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Locale;
import android.widget.Toast;
import android.util.Log;
import android.widget.SeekBar;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.widget.TextView;
import android.widget.Toolbar;
import android.os.AsyncTask;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.lang.Thread;

public class MainTTS extends AppCompatActivity {
    Timer t = new Timer();
    TTS lettuce = new TTS();
    STT potato = new STT();
    private TextToSpeech mTTS;
    private Button mButtonSpeak;
    private Button button;
    private TextView txvResult;
    private String[] test = new String[10];
    public static String start = "";
    public static String phrase = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //lettuce.start(mTTS);
        //startFun();
        //potato.start();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tts);
        mButtonSpeak = findViewById(R.id.button_speak);
        button = findViewById(R.id.button);
        txvResult = (TextView) findViewById(R.id.txvResult);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = mTTS.setLanguage(Locale.JAPANESE);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    } else {
                        mButtonSpeak.setEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });

        final EditText editText = (EditText) findViewById(R.id.edit_text);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mButtonSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lettuce.start(mTTS, "Beep Beep Lettuce");
                //potato.start();
                //speak();
            }
        });
    }



    private void speak() {
        test[0] = "BeeP";
        test[1] = "beeeeep";
        test[2] = "Beeeeep";
        test[3] = "lettuce";
        for (int i = 0; i < 4; i++) {
            mTTS.speak(test[i], TextToSpeech.QUEUE_FLUSH, null);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    @Override
    protected void onDestroy() {
        if (mTTS != null) {
            mTTS.stop();
            mTTS.shutdown();
        }

        super.onDestroy();
    }

    //--------------Speech to text---------------//
    public void getSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 10);
        } else {
            Toast.makeText(this, "Your Device Don't Support Speech Input", Toast.LENGTH_SHORT).show();
        }
    }


    public void getTurd(View view) {

        getSpeechInput();

    }

    public void startFun(){
        getSpeechInput();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    txvResult.setText(result.get(0));
                    //System.out.println(result.get(0));
                    start = result.get(0);
                    System.out.println("--------"+start+"--------");

                    if(!start.contains("start")){
                        getSpeechInput();
                        //new SendMessage().execute();

                        //Here we will send to the python to used as a command
                    }
                    else{
                        System.out.println("it worked!!!");
                        new SendMessage().execute();

                        //We will have code here that starts the python shit
                    }

                    }


                    break;
                }
        }

    }





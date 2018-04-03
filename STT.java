package com.example.calvinseamons.apptts;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.Thread;
import java.util.ArrayList;
import java.util.Locale;

import static android.app.Activity.RESULT_OK;

public class STT extends Thread{

    String threadName = "";
    Thread t;
    private TextView txvResult;
    public  STT(){
        threadName = "STT";
        System.out.println("Creating STT Thread!");
    }

    public void run(){

    }



    public void start(){

        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start();
        }

    }


}

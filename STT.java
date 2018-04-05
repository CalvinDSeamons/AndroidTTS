package com.example.calvinseamons.apptts;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.widget.TextView;
import android.widget.Toast;
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
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.lang.Thread;
import junit.framework.Test;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Locale;

import static android.app.Activity.RESULT_OK;

public class STT extends Thread {


    String threadName = "";
    Thread t;
    String start = "";

    public STT() {
        threadName = "STT";
        System.out.println("Creating STT Thread!");

    }

    public void run() {


    }


    public void start() {

        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }

    }

}


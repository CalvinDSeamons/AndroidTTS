package com.example.calvinseamons.apptts;


import android.speech.tts.TextToSpeech;
import java.lang.Thread;
public class TTS extends Thread{

    String threadName = "";
    Thread t;
    private TextToSpeech mTTS;




    public TTS(){
        threadName = "TTS";
        System.out.println("Creating TTS Thread!");
    }

    @Override
    public void run() {
        System.out.println("Hello Thread?");
        String test = "beep beep beep beep beep beep beep beep beep beep beep beep beep beep beep beep beep beep";
            mTTS.speak(test, TextToSpeech.QUEUE_FLUSH, null);

    }


    public void start(TextToSpeech mTTSin){
        mTTS = mTTSin;
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start();
        }

    }



}

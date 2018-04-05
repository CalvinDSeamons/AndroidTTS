package com.example.calvinseamons.apptts;


import android.speech.tts.TextToSpeech;
import java.lang.Thread;
public class TTS extends Thread{

    String threadName = "";
    Thread t;
    private TextToSpeech mTTS;
    String phrase = "";




    public TTS(){
        threadName = "TTS";
        System.out.println("Creating TTS Thread!");
    }

    @Override
    public void run() {

                mTTS.speak(phrase, TextToSpeech.QUEUE_FLUSH, null);
                System.out.println("Greetings");



    }


    public void start(TextToSpeech mTTSin, String phrase_in){
        mTTS = mTTSin;
        phrase = phrase_in;


        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start();
        }
        else{
            t.run();
        }
    }

}

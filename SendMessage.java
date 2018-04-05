package com.example.calvinseamons.apptts;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class SendMessage extends AsyncTask<Void,Void,Void>{
    private Exception exception;

    @Override
    protected  Void doInBackground(Void... params){
        try{
            try{
                System.out.println("Trying Connection");
                    Socket socket = new Socket("10.200.51.245",8897);
                    DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
                    outToServer.writeBytes(MainTTS.start);





                    BufferedReader b = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    System.out.println("------------>"+ b.readLine());

                    String[] array = {};
                    int i =0;
                    while((b.readLine()) != null){
                        array[i] = MainTTS.phrase;
                        i++;
                    }
                    System.out.println("Here is the competed buffer"+MainTTS.phrase);


                    System.out.println("Connection worked");
            } catch (IOException e){
                e.printStackTrace();
            }
        } catch (Exception e){
            this.exception = e;
            return null;
        }
    return null;

    }






}

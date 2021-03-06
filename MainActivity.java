package com.jude.runnable;


import android.content.ActivityNotFoundException;
import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Locale;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.view.View;

import android.widget.TextView;

import java.util.ArrayList;
import android.os.Handler;
import java.time.LocalDateTime;  // Import the LocalDateTime class
import java.time.format.DateTimeFormatter;  // Import the DateTimeFormatter class


    
public class MainActivity extends Activity  implements TextToSpeech.OnInitListener {

    private EditText textToSpeech;
    private TextToSpeech tts;
    private Button btnSpeak;
    private boolean ttsStatus = false;
    
    
    TextView txtSpeechInput;
    private Button btSpeak;
    private final int REQ_CODE_SPEECH_INPUT = 100;
    Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
String speechText;
String text;
 int time=10000;
 int time2=20000;
 int x;
Handler handler;
Handler handler2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tts = new TextToSpeech(this, this);
        textToSpeech = (EditText) findViewById(R.id.textToSpeech);
        btnSpeak = (Button) findViewById(R.id.btnSpeak);
     
        txtSpeechInput = (TextView) findViewById(R.id.textToSpeech);
        btSpeak = (Button) findViewById(R.id.btSpeak);
        
        
        
        
       handler= new Handler();
       handler2= new Handler();
btSpeak.setOnClickListener(new View.OnClickListener() {
    
            @Override
            public void onClick(View v) {
               
                if(textToSpeech.getText()!= null){
       textToSpeech.getText().clear();
    
    }
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say something");
                try {
                    startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
                } catch (ActivityNotFoundException a) {
                    Toast.makeText(getApplicationContext(), "Sorry! Your device doesn\\'t support speech input",
                            Toast.LENGTH_SHORT).show();
                            
                }
            }
        });
        
        
    }

    /**
     * Receiving speech input
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    speechText = txtSpeechInput.getText().toString() + "\n" + result.get(0);
                    txtSpeechInput.setText(speechText);
                    
                }
                break;
            }

        }
    
        
        
        
        
        btnSpeak.setOnClickListener(new View.OnClickListener() {
          
            @Override
            public void onClick(View v) {   
               
                if (ttsStatus) {
                    
                    speakOut();
                    
                    
                    
                } else {
                    Toast.makeText(MainActivity.this, "This Language is not supported", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void speakOut() {
       
       
       String text = textToSpeech.getText().toString();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        
        
        
      
    
    }
    @Override
    public void onInit(int status) {

        if (status == TextToSpeech.SUCCESS) {
            int result = tts.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                ttsStatus = false;
                Toast.makeText(this, "This Language is not supported", Toast.LENGTH_SHORT).show();
            } else {
                ttsStatus = true;
                btnSpeak.setEnabled(true);
                speakOut();
                
            }
        } else {
            Toast.makeText(this,"Initialization Failed... Install Text to Speech from Play Store, If not install", Toast.LENGTH_SHORT).show();
            ttsStatus = false;
        };
    }

 

    @Override
    public void onDestroy() {
        // Don't forget to shutdown tts!
        if ( tts != null) {
            tts.stop();
            
            tts.shutdown();
       
       }
        super.onDestroy();
 
        
        
    }
   
   
   public void animat_left(View view){


}

public void animat_right(View view){
    runnable.run(); 
    
}

public void animat(View view){
    
    
    
 
    
 runnable2.run(); 
 
 

 
}

public void animat_off(View view){
    
    handler.removeCallbacks(runnable);
 handler2.removeCallbacks(runnable2);
}


private Runnable runnable =new Runnable(){
    
public void run(){
    
  
     String text = textToSpeech.getText().toString();     
tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
if(text.contains("how are you")||text.contains("how are you")){
           tts.speak("I am fine", TextToSpeech.QUEUE_FLUSH, null);
        }
        if(text.contains("who are you")){
            
        tts.speak("I am a robbot made by Okafor Jude, a.k.a McJAH" , TextToSpeech.QUEUE_FLUSH, null); 
            
  
              } 
              
           if(text.contains("what")){
                  tts.speak("my name is Computer, what is your name", TextToSpeech.QUEUE_FLUSH, null); 
              
              }
        if(text.contains("my name is")){
                  tts.speak("where are you from", TextToSpeech.QUEUE_FLUSH, null); 
          }    
          
          if(text.contains("i am from")||text.contains("from")){
                  tts.speak("how old are you", TextToSpeech.QUEUE_FLUSH, null); 
              
         } 
         if(text.contains("30")||text.contains("fourthy")){
                  tts.speak("sorry, you are too old to have this job", TextToSpeech.QUEUE_FLUSH, null); 
              
         } 
         if(text.contains("20 years")||text.contains("10")||text.contains("11")){
                  tts.speak("you are young youth, i how you are not corrupt", TextToSpeech.QUEUE_FLUSH, null); 
              
         } 
         
         
              
     
if(text.contains("how old are you")){

  tts.speak("I lost my birth certificate, so i don't kwow my age for now", TextToSpeech.QUEUE_FLUSH, null); 
     tts.speak("why asking", TextToSpeech.QUEUE_FLUSH, null); 
                       
             
    }
   if(text.contains("date")){
       LocalDateTime myDateObj = LocalDateTime.now();  
    
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");  
    
    String formattedDate = myDateObj.format(myFormatObj);  
    

      tts.speak("today's date is"+formattedDate, TextToSpeech.QUEUE_FLUSH, null);
    
    }   
    handler.postDelayed(runnable,time);
}

};
private Runnable runnable2 =new Runnable(){
public void run(){
   
     intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say something");
      
    startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
   
     

if(textToSpeech.getText()!= null){
       textToSpeech.getText().clear();
    tts.speak("talk to me", TextToSpeech.QUEUE_FLUSH, null);
    }
    
    
        
    handler2.postDelayed(runnable2,time2);  
    
}
};
}
    
   
    
    
  
  
  
  

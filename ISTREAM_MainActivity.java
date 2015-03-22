package com.example.istreamy;

import android.support.v7.app.ActionBarActivity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.VideoView;


public class ISTREAM_MainActivity extends ActionBarActivity implements  OnClickListener, OnPreparedListener{
	VideoView Aview;
	EditText mystreamingStat;
	Uri myUri;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_istream__main);
         mystreamingStat = (EditText) findViewById(R.id.streamingStat);
         Aview = (VideoView) findViewById(R.id.videoViewAstream);
        
        try{
  	   
        	 mystreamingStat.append("accessing https://onedrive.live.com/?cid=1a68d446e887efc0&id=1A68D446E887EFC0%212229" );
        	
        	try
        	{ 
        		//myUri= Uri.parse("https://onedrive.live.com/?cid=1a68d446e887efc0&id=1A68D446E887EFC0%212229");
        	myUri= Uri.parse(Environment.getExternalStorageDirectory()+ "/Phone/DCIM/Camera/20150321_151950.mp4");
        		//\Phone\DCIM\Camera\20150321_151950.mp4
        	}
        	catch (Exception e){
        		mystreamingStat.append("URL GIVES PROBLEM");
        		Log.e("Error", e.getMessage());
    			e.printStackTrace();
        		
        	}
        	 Aview.setVideoURI(myUri);
        	Aview.setMediaController(new MediaController(this));
        	mystreamingStat.append("media controller attached");
        	Aview.requestFocus();
       }
       catch (Exception e) {
    	   mystreamingStat.append("setVideoURI error");
    	   mystreamingStat.append("Error");
			Log.e("Error", e.getMessage());
			e.printStackTrace();
		}

       mystreamingStat.append("Focus");
       
    
     
       Button btnstream = (Button) findViewById(R.id.istresm_close) ;
       btnstream.setOnClickListener((OnClickListener) this);
       Aview.setOnPreparedListener((OnPreparedListener) this);
        	      
    } 
    @Override
   	public void onPrepared(MediaPlayer mp) {
		// TODO Auto-generated method stub
    	 mystreamingStat.append("Started Playing Video");
    	   Aview.start();
		
	}
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.istresm_close)
        {
              finish();
              System.exit(0);
              
        }
              }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.istream__main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
	
  

}

package com.example.test;

import io.socket.SocketIO;

import java.net.MalformedURLException;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	/** Variables **/
	SocketIO server;
	
	/** TAGS **/
	String TAG_error="Biixa_Error";
	
	/** Botones **/
	Button btnLogin, btnLogout,btnSalir;
	
	/** TextView **/
	static TextView tvMensaje;
	
	/** IPServer **/
	String IPServer="192.168.1.2";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        try {
			tvMensaje = (TextView)findViewById(R.id.textView1);
			conectar();
			btnLogin();
			btnLogout();
			btnSalir();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e(TAG_error,""+e);
		}
    }

    private void btnSalir() {
		// TODO Auto-generated method stub
    	btnSalir = (Button)findViewById(R.id.button3);
    	btnSalir.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
		    	finish();
			}
		});
	}
    
    public static void tvLabel(String mensaje)
    {
    	tvMensaje.setText(mensaje);
    }

	public void btnLogin()
    {
    	btnLogin = (Button)findViewById(R.id.button1);
    	btnLogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
		    	server.emit("login","Conectando :D");
			}
		});
    }
    public void btnLogout()
    {
    	btnLogout = (Button)findViewById(R.id.button2);
    	btnLogout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
		    	server.emit("logout","Saliendo... :(");
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    private void conectar() throws MalformedURLException
    {
    	runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
		    	try {
					server = new SocketIO("http://"+IPServer+":3000/");
					server.connect(new server());
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    
			}
		});
    }
}
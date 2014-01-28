package com.example.test;

import io.socket.IOAcknowledge;
import io.socket.IOCallback;
import io.socket.SocketIOException;

import org.json.JSONObject;

import android.util.Log;

public class server implements IOCallback {

	/**
	 * TAGS
	 */
	String TAG_SERVER="SocketIO_Server",mensaje="";
	@Override
	public void onDisconnect() {
		// TODO Auto-generated method stub
		putMsg( "Desconectado");
	}

	@Override
	public void onConnect() {
		// TODO Auto-generated method stub
		putMsg("Conectado");
	}

	@Override
	public void onMessage(String data, IOAcknowledge ack) {
		// TODO Auto-generated method stub
		putMsg("Datos: "+data);
	}

	@Override
	public void onMessage(JSONObject json, IOAcknowledge ack) {
		// TODO Auto-generated method stub
		putMsg("JSON: "+json);
	}

	@Override
	public void on(String event, IOAcknowledge ack, Object... args) {
		// TODO Auto-generated method stub
		putMsg("Evento recibido: "+event + " Mensaje: "+args);
	}

	@Override
	public void onError(SocketIOException socketIOException) {
		// TODO Auto-generated method stub
		putMsg(":( ERROR: "+socketIOException);
	}

	private void putMsg(String mensaje)
	{
		try{
			Log.e(TAG_SERVER,mensaje);
		}catch(Exception e){
			Log.e(TAG_SERVER,"ERROR: "+e);
		}
	}
}

package com.example.gastosdiarios;

import java.security.GeneralSecurityException;

import com.example.gastosdiarios.R.id;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btn_nuevo =(Button) findViewById(id.btn_nuevoGasto);
		Button btn_reporte =(Button) findViewById(id.btn_reporte);
		
		//TODO: LEER ARCHIVO CATEGORIAS, FIJARSE SI MI DB COUNT ES 0 SI LO ES INSERT SINO NADA
		
		OnClickListener listener= new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent generalIntent=null;
				if(v.getId()==R.id.btn_nuevoGasto){
					generalIntent=new Intent(getApplicationContext(),NuevoGastoActivity.class);	
				}else{
					//IR REPORTE ACTIVIY
					//generalIntent=new Intent(getApplicationContext(),NuevoGastoActivity.class);
				}	
				startActivity(generalIntent);
			}
		};
		
		btn_nuevo.setOnClickListener(listener);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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

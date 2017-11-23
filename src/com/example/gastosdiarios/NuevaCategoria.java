package com.example.gastosdiarios;

import com.example.gastordiarios.model.CategoriasManejador;
import com.example.gastosdiarios.R.id;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NuevaCategoria extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nueva_categoria);
		
		Button btn_nueva=(Button)findViewById(id.BtnCrearNuevaCategoria);
		Button btn_cancelar=(Button)findViewById(id.BtnCancelarNuevaCategoria);
		final TextView txt_nueva=(TextView) findViewById(id.txtNuevaCategoria);
		
		final CategoriasManejador cm=CategoriasManejador.getInstance(this);
		
		OnClickListener listener= new OnClickListener(){

			@Override
			public void onClick(View v) {
				if(v.getId()==R.id.BtnCrearNuevaCategoria){
					//boton crear
					try {
						cm.InsertCategoria(txt_nueva.getText().toString());
						txt_nueva.setText("");
						Toast.makeText(getApplicationContext(),"La categoria se creo exitosamente",Toast.LENGTH_SHORT).show();
					} catch (Exception e) {
						Toast.makeText(getApplicationContext(),"No se pudo crear la nueva categoria",Toast.LENGTH_SHORT).show();
					}
				}else{
					//boton cancelar
					finish();//cierra la activity actual
				}
				
			}
		};	
		
		btn_nueva.setOnClickListener(listener);
		btn_cancelar.setOnClickListener(listener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.nueva_categoria, menu);
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

package com.example.gastosdiarios;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import com.example.gastordiarios.model.*;

public class NuevoGastoActivity extends Activity {

	private Spinner spinner;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nuevo_gasto);
		
		CategoriasManejador _categoriasManejador=CategoriasManejador.getInstance(this);
		//final ArrayList<Categorias> TodasCategorias=_categoriasManejador.SelectCategorias();
		final Categorias[] TodasCategorias=_categoriasManejador.SelectCategorias();
		spinner=(Spinner) findViewById(R.id.spn_categorias_nuevo_gasto);
		
		ArrayAdapter<Categorias> adapter=new ArrayAdapter<Categorias>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,TodasCategorias);
		spinner.setAdapter(adapter);
		
		
		OnItemSelectedListener listener= new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				//Toast.makeText(getApplicationContext(), deportes[position],Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
			
		};
		
		spinner.setOnItemSelectedListener(listener);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.nuevo_gasto, menu);
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
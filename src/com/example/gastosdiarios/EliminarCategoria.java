package com.example.gastosdiarios;

import com.example.gastordiarios.model.Categorias;
import com.example.gastordiarios.model.CategoriasManejador;

import android.app.Activity;
import android.content.pm.LabeledIntent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class EliminarCategoria extends Activity {

	private Spinner spinnerEli;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_eliminar_categoria);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.eliminar_categoria, menu);
		CategoriasManejador _categoriasManejador=CategoriasManejador.getInstance(this);
		final Categorias[] TodasCategorias=_categoriasManejador.SelectCategorias();
		spinnerEli =(Spinner) findViewById(R.id.sp_CategoriasMod);
		ArrayAdapter<Categorias> adapter=new ArrayAdapter<Categorias>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,TodasCategorias);
		spinnerEli.setAdapter(adapter);
		
	
		
		
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

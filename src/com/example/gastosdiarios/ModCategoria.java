package com.example.gastosdiarios;

import com.example.gastordiarios.model.Categorias;
import com.example.gastordiarios.model.CategoriasManejador;
import com.example.gastordiarios.model.CategoriasManejador;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class ModCategoria extends Activity {

	private Spinner spinnerCat;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mod_categoria);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mod_categoria, menu);
		final TextView texto = (TextView)findViewById(R.id.Txt_aModificar);
		CategoriasManejador _categoriasManejador=CategoriasManejador.getInstance(this);
		final Categorias[] TodasCategorias=_categoriasManejador.SelectCategorias();
		spinnerCat =(Spinner) findViewById(R.id.sp_CategoriasMod);
		ArrayAdapter<Categorias> adapter=new ArrayAdapter<Categorias>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,TodasCategorias);
		spinnerCat.setAdapter(adapter);
		
		OnItemSelectedListener listenerSpinner= new OnItemSelectedListener(){
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			texto.setText(TodasCategorias[position].toString());
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		};
		spinnerCat.setOnItemSelectedListener(listenerSpinner);
		
		
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

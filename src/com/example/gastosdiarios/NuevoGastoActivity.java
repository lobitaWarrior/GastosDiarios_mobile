package com.example.gastosdiarios;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.AdapterView.AdapterContextMenuInfo;

import com.example.gastordiarios.model.*;
import com.example.gastosdiarios.R.id;
import com.example.gastosdiarios.bd.BaseDatos;

public class NuevoGastoActivity extends Activity {

	private Spinner spinner;
	int ID_Categoria=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nuevo_gasto);
		Button btn_administrar =(Button) findViewById(id.btn_admCateg);
		Button btn_aceptar =(Button) findViewById(id.btn_crearGasto);
		Button btn_cancelar =(Button) findViewById(id.btn_cancelarGasto);
		final TextView txt_descripcion=(TextView) findViewById(id.txt_descrip);
		final TextView txt_monto= (TextView) findViewById(id.txt_monto);
		final Date fecha= new Date();
		final GastosManejador gm = GastosManejador.getInstance(this);

		OnClickListener listener= new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent generalIntent=null;

				if(v.getId()==R.id.btn_admCateg){
					generalIntent=new Intent(getApplicationContext(),AbmCategoria.class);
					startActivity(generalIntent);
				}else if(v.getId()==R.id.btn_crearGasto){
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					gm.NuevoGasto(ID_Categoria, txt_descripcion.getText().toString(), Float.parseFloat(txt_monto.getText().toString()), dateFormat.format(fecha));
					//TODO: TOAST DE SALIO TODO OK O SALIO TODO MAL,, HACERLO EN EXCEPTION
				}else {
				
				}
			}
		};
		
		btn_administrar.setOnClickListener(listener);
		btn_aceptar.setOnClickListener(listener);
		btn_cancelar.setOnClickListener(listener);
		
		
		
		CategoriasManejador _categoriasManejador=CategoriasManejador.getInstance(this);
		//final ArrayList<Categorias> TodasCategorias=_categoriasManejador.SelectCategorias();
		final Categorias[] TodasCategorias=_categoriasManejador.SelectCategorias();
		spinner=(Spinner) findViewById(R.id.spn_categorias_nuevo_gasto);
		
		ArrayAdapter<Categorias> adapter=new ArrayAdapter<Categorias>(this,android.R.layout.simple_spinner_dropdown_item,TodasCategorias);
		spinner.setAdapter(adapter);
		
		
		OnItemSelectedListener listenerSpinner= new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				
				ID_Categoria=TodasCategorias[position].id;
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
			
		};
		
		spinner.setOnItemSelectedListener(listenerSpinner);
		
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

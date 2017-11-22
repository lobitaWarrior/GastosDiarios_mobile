package com.example.gastosdiarios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.security.GeneralSecurityException;
import java.util.Scanner;

import com.example.gastordiarios.model.CategoriasManejador;
import com.example.gastosdiarios.R.id;
import com.example.gastosdiarios.bd.BaseDatos;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	private SQLiteDatabase db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btn_nuevo =(Button) findViewById(id.btn_nuevoGasto);
		Button btn_reporte =(Button) findViewById(id.btn_reporte);
				
		CategoriasManejador catManejador=CategoriasManejador.getInstance(this);
		int categoriasExistentes = catManejador.CountCategorias();
		String nombreCategoria;
		int idCategoria;
		if(categoriasExistentes==0){
			try {
				Scanner read = new Scanner (new File(getResources().openRawResource(R.raw.categorias)));
				read.useDelimiter(";");
				
				while(read.hasNext()){
					idCategoria=read.nextInt();
					nombreCategoria=read.next();
					catManejador.InsertCategoria(idCategoria,nombreCategoria);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

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

package com.example.gastordiarios.model;

import java.util.ArrayList;

import com.example.gastosdiarios.bd.BaseDatos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class CategoriasManejador {

	private SQLiteDatabase db;
	private BaseDatos b;
	private static CategoriasManejador instance=null;
	
	private CategoriasManejador(Context context){
		// creamos la base de datos
		b = new BaseDatos(context, "GastosDiarios", null, 1);
		// la abrimos en modo escritura
		db = b.getWritableDatabase();
		
	}
	
	public Categorias[] SelectCategorias(){

		String query = "SELECT * FROM Categorias ORDER BY nombre ASC";
		
		Cursor cursor = db.rawQuery(query, null); 		
		ArrayList<Categorias> c= new ArrayList<Categorias>();
		//ABRO CURSOR
		cursor.moveToFirst();
		while(!cursor.isAfterLast()){
			Categorias object=new Categorias();
			object.id=cursor.getInt(cursor.getColumnIndex("id"));
			object.nombre=cursor.getString(cursor.getColumnIndex("nombre"));
			c.add(object);
			//LEO CURSOR
			cursor.moveToNext();
		}
		//CIERRO CURSOR
		cursor.close();

		return c.toArray(new Categorias[c.size()]);
	}
	
	public static CategoriasManejador getInstance(Context context){
		
		if(instance==null){
			instance=new CategoriasManejador(context);
		}	
		
		return instance;
	}
	
}

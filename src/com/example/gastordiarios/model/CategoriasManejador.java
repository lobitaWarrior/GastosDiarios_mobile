package com.example.gastordiarios.model;

import java.util.ArrayList;

import com.example.gastosdiarios.bd.BaseDatos;

import android.content.Context;
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
	
	public ArrayList<Categorias> SelectCategorias(){

		ArrayList<Categorias> c= new ArrayList<Categorias>();
		Categorias object=new Categorias();
		
		//LLAMAR A METODO BD LLENAR MI NEW GASTOS
		object.id=1;
		object.nombre="pruieba";

		c.add(object);
		
		return c;
	}
	
	public static CategoriasManejador getInstance(Context context){
		
		if(instance==null){
			instance=new CategoriasManejador(context);
		}	
		
		return instance;
	}
	
}

package com.example.gastordiarios.model;

import java.util.ArrayList;

import com.example.gastosdiarios.bd.BaseDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class CategoriasManejador {

	private SQLiteDatabase db;
	private static CategoriasManejador instance=null;
	
	private CategoriasManejador(Context context){
		// creamos la base de datos
		BaseDatos b =BaseDatos.getBD(context, "GastosDiarios", null, 1);//new BaseDatos(context, "GastosDiarios", null, 1);
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
	
	public void InsertCategoria(int id, String nombre){
		ContentValues values = new ContentValues(); 
		
		values.put(CategoriasContract.TableCategoria.COLUMN_NAME__ID, id);
		values.put(CategoriasContract.TableCategoria.COLUMN_NAME_DESCRIPCION,nombre);
		
		db.insert(CategoriasContract.TableCategoria.TABLE_NAME, null, values);
	}
	
	public int CountCategorias(){
		int total=0;
		
		String query = "SELECT COUNT(id) FROM Categorias ORDER BY nombre ASC";
		
		Cursor cursor=db.rawQuery(query, null);
		if(cursor!=null){
			//HAY DATOS
			cursor.moveToFirst();
			total=cursor.getInt(0);
			//CIERRO CURSOR
			cursor.close();
		}
		cursor.close();
		
		return total;
		
	}
	
	public static CategoriasManejador getInstance(Context context){
		
		if(instance==null){
			instance=new CategoriasManejador(context);
		}	
		
		return instance;
	}
	
}

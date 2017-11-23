package com.example.gastordiarios.model;

import java.sql.Date;
import java.util.ArrayList;

import com.example.gastosdiarios.MainActivity;
import com.example.gastosdiarios.bd.BaseDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class GastosManejador {

	private SQLiteDatabase db;
	private static GastosManejador instance=null;
	
	//HACERLO SINGLETON
	private GastosManejador(Context context ){

		// creamos la base de datos
		BaseDatos b = BaseDatos.getBD(context, "GastosDiarios", null, 1); //new BaseDatos(context, "GastosDiarios", null, 1);
		// la abrimos en modo escritura
		db = b.getWritableDatabase();
				
	}
	
	public Gastos[] SelectTodosGastos(){
		
		 String query = "SELECT G.DESCRIPCION,G.MONTO,G.FECHA,G.ID_CATEGORIA, C.NOMBRE FROM GASTOS G LEFT JOIN CATEGORIAS C ON G.ID_CATEGORIA=C.ID ORDER BY G.descripcion ASC";
		 
		 Cursor cursor = db.rawQuery(query, null); 
		 
		 ArrayList<Gastos> g= new ArrayList<Gastos>();
		 //ABRO CURSOR
		 cursor.moveToFirst();
		 while(!cursor.isAfterLast()){
			 Gastos object=new Gastos();
			 object.categoria=cursor.getString(cursor.getColumnIndex("nombre"));
			 object.descripcion=cursor.getString(cursor.getColumnIndex("descripcion"));
			 object.fecha=cursor.getString(cursor.getColumnIndex("fecha"));
			 object.idCategoria=cursor.getInt(cursor.getColumnIndex("id_categoria"));
			 object.monto=cursor.getFloat(cursor.getColumnIndex("monto"));
			 g.add(object);
			 //LEO CURSOR
			 cursor.moveToNext();
		 }
		 //CIERRO CURSOR
		 cursor.close();
		 
		 return g.toArray(new Gastos[g.size()]);

	}
	
	/*HACER QUE DEVUELVA SI SE INSERTO O NO SERIA PIOLA
	 * 0=OK
	 * 1=ERROR
	 * */
	public void NuevoGasto(int idCategoria,String descripcion, float monto, String fecha){
		//Create a new map of values, where column names are the keys
		ContentValues values = new ContentValues(); 

		values.put(GastosContract.TableGastos.COLUMN_NAME_ID_CATEGORIA, idCategoria);
		values.put(GastosContract.TableGastos.COLUMN_NAME_DESCRIPCION,descripcion);
		values.put(GastosContract.TableGastos.COLUMN_NAME_MONTO,monto);
		values.put(GastosContract.TableGastos.COLUMN_NAME_FECHA,fecha);
		
		//Insert the new row, returning the primary key value of the new row
		db.insert(GastosContract.TableGastos.TABLE_NAME,null, values); 

	}
	
	public static GastosManejador getInstance(Context context){
		
		if(instance==null){
			instance=new GastosManejador(context);
		}	
		
		return instance;
	}
}

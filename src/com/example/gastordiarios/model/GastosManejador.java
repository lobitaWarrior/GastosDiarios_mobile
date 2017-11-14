package com.example.gastordiarios.model;

import java.sql.Date;

import com.example.gastosdiarios.MainActivity;
import com.example.gastosdiarios.bd.BaseDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public class GastosManejador {

	private SQLiteDatabase db;
	private BaseDatos b;

	//HACERLO SINGLETON
	public GastosManejador(Context context ){

		// creamos la base de datos
		b = new BaseDatos(context, "GastosDiarios", null, 1);
		// la abrimos en modo escritura
		db = b.getWritableDatabase();
				
	}
	
	public Gastos SelectTodosGastos(){
		
		Gastos g=new Gastos();
		//LLAMAR A METODO BD LLENAR MI NEW GASTOS
		g.categoria="prueba";
		g.descripcion="descripcion";
		g.fecha="07/11/2017";
		g.monto=(float) 15.25;
		g.idCategoria=1;
		
		return g;
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
}

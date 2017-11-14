package com.example.gastosdiarios.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.gastordiarios.model.*;

public class BaseDatos extends SQLiteOpenHelper {

	private String sqlCreateGastos="CREATE TABLE" + GastosContract.TableGastos.TABLE_NAME
			+"("+GastosContract.TableGastos.COLUMN_NAME__ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ GastosContract.TableGastos.COLUMN_NAME_ID_CATEGORIA+" INTEGER, "
			+ GastosContract.TableGastos.COLUMN_NAME_DESCRIPCION+" TEXT, "
			+GastosContract.TableGastos.COLUMN_NAME_MONTO + " REAL, "
			+GastosContract.TableGastos.COLUMN_NAME_FECHA+" TEXT, "
			+"FOREIGN KEY("+GastosContract.TableGastos.COLUMN_NAME_ID_CATEGORIA+") REFERENCES "
			+CategoriasContract.TableCategoria.TABLE_NAME+"("+CategoriasContract.TableCategoria.COLUMN_NAME__ID+"))";
	
	private String sqlCreateCategorias="CREATE TABLE" + GastosContract.TableGastos.TABLE_NAME
			+"("+GastosContract.TableGastos.COLUMN_NAME__ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ GastosContract.TableGastos.COLUMN_NAME_DESCRIPCION+" INTEGER";
	
	public BaseDatos(Context gastosManejador, String name, CursorFactory factory, int version) {
		super(gastosManejador, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(sqlCreateCategorias); 
		db.execSQL(sqlCreateGastos); 
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}

}

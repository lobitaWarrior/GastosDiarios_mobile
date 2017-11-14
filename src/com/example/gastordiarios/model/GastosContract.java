package com.example.gastordiarios.model;

import android.provider.BaseColumns;

public final class GastosContract {

	public GastosContract(){}
	public abstract class TableGastos implements BaseColumns{
		 public static final String TABLE_NAME = "Gastos";
		 public static final String COLUMN_NAME__ID = "id";
		 public static final String COLUMN_NAME_ID_CATEGORIA = "id_categoria";
		 public static final String COLUMN_NAME_MONTO = "monto";
		 public static final String COLUMN_NAME_DESCRIPCION = "descripcion";
		 public static final String COLUMN_NAME_FECHA = "fecha";
	}
}

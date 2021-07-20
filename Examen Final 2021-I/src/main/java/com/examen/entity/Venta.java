package com.examen.entity;

public class Venta {

		private int idventa;
		private String fecha;
		private String tipodoc;
		private int idsucursal;
		private int idcliente;
		
		public Venta() {
		}

		public Venta(String fecha, String tipodoc, int idsucursal, int idcliente) {
			this.fecha = fecha;
			this.tipodoc = tipodoc;
			this.idsucursal = idsucursal;
			this.idcliente = idcliente;
		}

		public int getIdventa() {
			return idventa;
		}

		public void setIdventa(int idventa) {
			this.idventa = idventa;
		}

		public String getFecha() {
			return fecha;
		}

		public void setFecha(String fecha) {
			this.fecha = fecha;
		}

		public String getTipodoc() {
			return tipodoc;
		}

		public void setTipodoc(String tipodoc) {
			this.tipodoc = tipodoc;
		}

		public int getIdsucursal() {
			return idsucursal;
		}

		public void setIdsucursal(int idsucursal) {
			this.idsucursal = idsucursal;
		}

		public int getIdcliente() {
			return idcliente;
		}

		public void setIdcliente(int idcliente) {
			this.idcliente = idcliente;
		}
		
}

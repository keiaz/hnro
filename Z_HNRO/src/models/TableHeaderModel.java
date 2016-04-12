package models;

public class TableHeaderModel {
	private boolean newRow = false;
	private String header = "";
	private String rowSpan = "1";
	private String colSpan = "1";
	private String tbodyRowSpan = "1";
	private String tbodyColSpan = "1";
	
	public TableHeaderModel() {}
	
	public TableHeaderModel(boolean newRow) {
		this.newRow = newRow;
	}
	
	public TableHeaderModel(String header) {
		this.header = header;
	}
	
	public TableHeaderModel(String header, String rowSpan) {
		this.header = header;
		this.rowSpan = rowSpan;
		this.tbodyRowSpan = rowSpan;
	}
	
	public TableHeaderModel(String header, String rowSpan, String tbodyRowSpan) {
		this.header = header;
		this.rowSpan = rowSpan;
		this.tbodyRowSpan = tbodyRowSpan;
	}
	
	public boolean isNewRow() {
		return newRow;
	}
	
	public void setNewRow(boolean newRow) {
		this.newRow = newRow;
	}
	
	public String getHeader() {
		return header;
	}
	
	public void setHeader(String header) {
		this.header = header;
	}
	
	public String getRowSpan() {
		return rowSpan;
	}
	
	public void setRowSpan(String rowSpan) {
		this.rowSpan = rowSpan;
	}
	
	public String getColSpan() {
		return colSpan;
	}
	
	public void setColSpan(String colSpan) {
		this.colSpan = colSpan;
	}
	
	public String getTbodyRowSpan() {
		return tbodyRowSpan;
	}
	
	public void setTbodyRowSpan(String tbodyRowSpan) {
		this.tbodyRowSpan = tbodyRowSpan;
	}
	
	public String getTbodyColSpan() {
		return tbodyColSpan;
	}
	
	public void setTbodyColSpan(String tbodyColSpan) {
		this.tbodyColSpan = tbodyColSpan;
	}
}

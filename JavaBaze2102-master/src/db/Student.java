package db;

import java.util.Date;

public class Student 
{
	private int indeks;
	private int upisan;
	private String ime;
	private String mesto;
	private Date datumRodjenja;
	private int smer;
	
	public Student () {}
	
	public Student(int indeks, int upisan, String ime, String mesto, Date datumRodjenja, int smer) 
	{
		super();
		this.indeks = indeks;
		this.upisan = upisan;
		this.ime = ime;
		this.mesto = mesto;
		this.datumRodjenja = datumRodjenja;
		this.smer = smer;
	}
	
	@Override
	public String toString() 
	{
		return "Student [indeks=" + indeks + ", upisan=" + upisan + ", ime=" + ime + ", mesto=" + mesto
				+ ", datumRodjenja=" + datumRodjenja + ", smer=" + smer + "]";
	}

	public int getIndeks() {return indeks;}
	public void setIndeks(int indeks) {this.indeks = indeks;}
	public int getUpisan() {return upisan;}
	public void setUpisan(int upisan) {this.upisan = upisan;}
	public String getIme() {return ime;}
	public void setIme(String ime) {this.ime = ime;}
	public String getMesto() {return mesto;}
	public void setMesto(String mesto) {this.mesto = mesto;}
	public Date getDatumRodjenja() {return datumRodjenja;}
	public void setDatumRodjenja(Date datumRodjenja) {this.datumRodjenja = datumRodjenja;}
	public int getSmer() {return smer;}
	public void setSmer(int smer) {this.smer = smer;}
	
}

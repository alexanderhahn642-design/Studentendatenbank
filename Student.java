package de.berlin.StudentDatenbank;

public class Student {

	private String vorname;
	private String nachname;
	private int matrikelnummer;
	
	public Student() {
		
	}
	
	public Student(String vorname, String nachname, int matrikelnummer) {
	    this.vorname = vorname;
	    this.nachname = nachname;
	    this.matrikelnummer = matrikelnummer;
	}
	public void setVorname(String vorname) {
		this.vorname=vorname;
	}
	public String getVorname() {
		return vorname;
	}
	public void setNachname(String nachname) {
		this.nachname=nachname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setMatrikelnummer(int matrikelnummer) {
		this.matrikelnummer=matrikelnummer;
	}
	public int getMatrikelnummer() {
		return matrikelnummer;
	}
	@Override
	public String toString() {
		
		return "Student: " + matrikelnummer + "\n" +
				"Vorname: " + vorname + "\n" + 
				"Nachname: " + nachname + "\n" + 
				"--------------------";
	}
}

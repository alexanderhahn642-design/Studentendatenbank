package de.berlin.StudentenDatenbank;

import java.util.ArrayList;

public class Datenbank {

    private ArrayList<Student> datenbank;
    
    // Konstruktor
    public Datenbank() {
        datenbank = new ArrayList<>();
    }
    // Überladener Konstruktor, falls die Main-Methode eine Anzahl Studenten übergibt
    public Datenbank(int anzahlStudenten) {
        datenbank = new ArrayList<>(anzahlStudenten); 
    }

    // Fügt einen neuen Studenten hinzu
    public void addStudent(int matrikelnummer, String vorname, String nachname) {
        Student s = new Student(vorname,nachname,matrikelnummer);
        
        datenbank.add(s);
    }
    // Suchen über Matrikelnummer
    public Student findStudent(int matrikelnummer) {
        for (Student s : datenbank) {
            if (s.getMatrikelnummer() == matrikelnummer) {
                return s;
            }
        }
        return null; // Falls nicht gefunden
    }
    // Löschen über Matrikelnummer 
    public void deleteStudent(int matrikelnummer) {
        
        boolean entfernt = datenbank.removeIf(s -> s.getMatrikelnummer() == matrikelnummer);
        
        if (entfernt) {
            System.out.println("Student mit Nummer " + matrikelnummer + " wurde gelöscht.");
        } else {
            System.out.println("Matrikelnummer nicht gefunden.");
        }
    }
	//  Anzahl Studenten in der Datenbank zurückgeben 
    public int numberOfStudents() {
        return datenbank.size();
    }
    /**
     * Prüft, ob die Datenbank leer ist.
     * @return true, wenn keine Studenten gespeichert sind.
     */
    public boolean isEmpty() {
        return datenbank.isEmpty();
    }
    // Gibt alle Studenten aus
    public void printMe() {
    	if (datenbank.isEmpty()) {
            System.out.println("Die Datenbank ist leer.");
        } else {
            for (Student s : datenbank) {
                System.out.println(s);
            }
        }
    }
}


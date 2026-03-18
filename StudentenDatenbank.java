package de.berlin.StudentenDatenbank;

import java.util.Scanner;
import java.util.Random;
//import java.util.ArrayList;
//import java.util.Collections;

public class StudentenDatenbank {

	public static void main(String[] args) {
//		Student s1 = new Student();
//		s1.setMatrikelnummer(457);
//		s1.setNachname("Berg");
//		s1.setVorname("Martin");
		
		//System.out.println(s1);
		
		Menu();
		
		
		
//		int [] matrikelnummern = {456,854,987,336,876,406,840,236,618,597};
//		String [] vornamen = {"Bernd","Matilde","Julia","Sascha","Nastasia","Gil","Fabian","Andreas","Bennjamin","Alexander"};
//		String [] nachnamen = {"Schmidt","Schulz","Berger","Müller","Spatz","Brieger","Küstner","Baum","Brandtner","Kiesel"};
//		
//		Random random = new Random();
//		for (int i =0; i<10;i++) {
//			Student s = new Student();
//			s.setMatrikelnummer(matrikelnummern[random.nextInt(matrikelnummern.length)]);
//			s.setVorname(vornamen[random.nextInt(vornamen.length)]);
//			s.setNachname(nachnamen[random.nextInt(nachnamen.length)]);
//			
//			printMe(s);			
//			
//		}
	}
	public static void Menu() {
		Datenbank db = new Datenbank();
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		boolean running = true;
		while(running) {
			System.out.println( "----------------------------------\n" +
								"(1) Datenbank erzeugen" + "\n" +
								"(2) Student hinzufügen" + "\n" +
								"(3) Studentendaten ändern" + "\n" +
								"(4) Student löschen" + "\n" +
								"(5) Anzahl Studenten in Datenbank" + "\n" +
								"(6) Datenbank anzeigen" + "\n" +
								"(7) Beenden" + "\n" +
								"----------------------------------");
			
			int eingabe = scanner.nextInt();  
			
			if(eingabe==1) {

				// Listen für zufällige Zusammenstellung
				String [] vornamen = {"Bernd","Matilde","Julia","Sascha","Nastasia","Gil","Fabian","Andreas","Bennjamin","Alexander"};
				String [] nachnamen = {"Schmidt","Schulz","Berger","Müller","Spatz","Brieger","Küstner","Baum","Brandtner","Kiesel"};
				
				System.out.println("Wie viele Studenten sollen in die Datenbank?");
				int anzahlStudenten = scanner.nextInt();
				
				// Datenbank initialisieren
				db = new Datenbank(anzahlStudenten);
				for (int i = 0;i < anzahlStudenten; i++) {
                    // EINDEUTIGE Matrikelnummer generieren (100-999)
                    int id;
                    do {
                        id = random.nextInt(900) + 100; 
                    } while (db.findStudent(id) != null); // Würfeln, bis ID frei ist
                    // Zufällige Auswahl aus den Arrays                    
                    String v = vornamen[random.nextInt(vornamen.length)];
                    String n = nachnamen[random.nextInt(nachnamen.length)];
                    
                    db.addStudent(id, v, n); 
                }
				System.out.println("Datenbank mit " + anzahlStudenten + " Studenten erzeugt.");
			}
			else if (eingabe==2){

		            System.out.print("Matrikelnummer: ");
		            int id = scanner.nextInt();
		            System.out.print("Vorname: ");
		            String v = scanner.next();
		            System.out.print("Nachname: ");
		            String n = scanner.next();
		            db.addStudent(id, v, n);
		            System.out.println("Student hinzugefügt.");
			}
			else if (eingabe==3){
				System.out.print("Matrikelnummer des zu ändernden Studenten: ");
		        int id = scanner.nextInt();
		        Student s = db.findStudent(id);
		        
		        if (s != null) {
		            System.out.print("Neuer Vorname: ");
		            s.setVorname(scanner.next());
		            System.out.print("Neuer Nachname: ");
		            s.setNachname(scanner.next());
		            System.out.println("Daten aktualisiert.");
		        } else {
		            System.out.println("Student mit Nummer " + id + "nicht gefunden.");
		        	}
		    	}
						
			else if (eingabe==4){
				
		            System.out.print("Zu löschende Matrikelnummer: ");
		            db.deleteStudent(scanner.nextInt());
			}
			else if (eingabe == 5) {
			    if (db.isEmpty()) {
			        System.out.println("Die Datenbank enthält momentan keine Studenten.");
			    } else {
			        System.out.println("Aktuelle Anzahl Studenten: " + db.numberOfStudents());
			    }
			}
			else if (eingabe==6){
				db.printMe();
			}
			else  running = false;
			//break;
		}
		scanner.close();
	}
	public static void printMe(Student s) {
		 System.out.println(s);
	}
	
	
	
}

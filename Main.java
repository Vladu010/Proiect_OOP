import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int meniu;
        Spital hospital = new Spital("Spital Judetean", "Cornisa");

        do {
            System.out.println("1. Introducere Pacienti");
            System.out.println("2. Lista Pacienti");
            System.out.println("3. Diagnosticare pacienti");
            System.out.println("0. Iesire");

            System.out.println("Alegeti varianta :");
            meniu = sc.nextInt();
            switch (meniu) {
                case 1: {
                    System.out.println("Introduceti numele pacientului:");
                    String nume = sc.next();
                    System.out.println("Introduceti prenumele pacientului:");
                    String prenume = sc.next();
                    System.out.println("Introduceti adresa pacientului:");
                    String adresa = sc.next();
                    System.out.println("Introduceti CNP-ul pacientului:");
                    double cnp = sc.nextDouble();
                    System.out.println("Introduceti varsta pacientului:");
                    int varsta = sc.nextInt();
                    System.out.println("Introduceti ID-ul pacientului:");
                    int id = sc.nextInt();
                    Pacient newPacient = new Pacient(nume, prenume, adresa, cnp , varsta, id);
                    hospital.addPacient(newPacient);
                    break;
                }
                case 2: {
                    System.out.println("\n\nLista de pacienti al spitalului Judetean Cornisa este:");
                    for (int i = 0; i < hospital.getNumPacients(); i++) {
                        System.out.println(hospital.getPacient(i).toString());
                    }
                    System.out.println("\n\n");
                    break;
                }
                case 3: {
                    System.out.println("Introduceti ID-ul pacientului pentru care doriti sa setati diagnosticul:");
                    int targetId = sc.nextInt();
                    boolean found = false;

                    for (int i = 0; i < hospital.getNumPacients(); i++) {
                        Pacient currentPacient = hospital.getPacient(i);
                        if (currentPacient.getID() == targetId) {
                            int tmp = currentPacient.getParametri();
                            if (tmp < 40 || tmp > 100) {
                                System.out.println("Introduceti Diagnostic pentru pacientul " + currentPacient.getNume() + ": ");
                                currentPacient.setDiagnostic(sc.next());
                                found = true;
                                break;
                            }
                        }
                    }

                    if (!found) {
                        System.out.println("Nu s-a gasit niciun pacient cu ID-ul " + targetId);
                    }
                    break;
                }

                case 0:
                    System.out.println("Iesire din program.");
                    break;
                default:
                    System.out.println("Optiune invalida.");
            }
        } while (meniu != 0);
        sc.close();
    }
}

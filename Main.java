import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int meniu;
        Spitale_Lista spitale = new Spitale_Lista();
        do {
            System.out.println("1. Creati un spital");
            System.out.println("2. Introducere Pacienti");
            System.out.println("3. Lista Pacienti pentru un spital");
            System.out.println("4. Diagnosticare pacienti");
            System.out.println("5. Lista de spitale");
            System.out.println("6. Afisare date spitale");
            System.out.println("0. Iesire");

            System.out.println("Alegeti varianta :");
            meniu = sc.nextInt();
            switch (meniu) {
                case 1: {
                    System.out.println("Introduceti ID-ul spitalului:");
                    int id = sc.nextInt();
                    System.out.println("Introduceti numele spitalului:");
                    String numeSpital = sc.next();
                    System.out.println("Introduceti adresa spitalului:");
                    String adresaSpital = sc.next();
                    Spital newSpital = new Spital(numeSpital, adresaSpital, id);
                    spitale.adaugareSpital(newSpital);
                    break;
                }
                case 2: {
                    System.out.println("Introduceti ID-ul spitalului in care doriti sa adaugati pacientul:");
                    int targetSpitalId = sc.nextInt();
                    Spital targetSpital = null;

                    for (Spital spital : spitale.getSpitalList()) {
                        if (spital.getId() == targetSpitalId) {
                            targetSpital = spital;
                            break;
                        }
                    }

                    if (targetSpital == null) {
                        System.out.println("Nu s-a gasit niciun spital cu ID-ul " + targetSpitalId);
                        break;
                    }

                    System.out.println("Introduceti numele pacientului:");
                    String nume = sc.next();
                    System.out.println("Introduceti prenumele pacientului:");
                    String prenume = sc.next();
                    System.out.println("Introduceti adresa pacientului:");
                    sc.nextLine(); // Consume the newline character left by previous sc.next()
                    String adresa = sc.nextLine();
                    System.out.println("Introduceti CNP-ul pacientului:");
                    double cnp = sc.nextDouble();
                    System.out.println("Introduceti varsta pacientului:");
                    int varsta = sc.nextInt();
                    System.out.println("Introduceti ID-ul pacientului:");
                    int id = sc.nextInt();
                    Pacient newPacient = new Pacient(nume, prenume, adresa, cnp, varsta, id);
                    targetSpital.addPacient(newPacient);
                    break;
                }
                case 3: {
                    System.out.println("Introduceti ID-ul spitalului pentru care doriti sa afisati lista de pacienti:");
                    int targetSpitalId = sc.nextInt();
                    Spital targetSpital = null;

                    for (Spital spital : spitale.getSpitalList()) {
                        if (spital.getId() == targetSpitalId) {
                            targetSpital = spital;
                            break;
                        }
                    }

                    if (targetSpital == null) {
                        System.out.println("Nu s-a gasit niciun spital cu ID-ul " + targetSpitalId);
                        break;
                    }

                    System.out.println("\n\nLista de pacienti al spitalului " + targetSpital.getNumeSpital() + " " + targetSpital.getAdresaSpital() + " este:");
                    for (int i = 0; i < targetSpital.getNumPacients(); i++) {
                        System.out.println(targetSpital.getPacient(i).toString());
                    }
                    System.out.println("\n\n");
                    break;
                }
                case 4: {
                    System.out.println("Introduceti ID-ul spitalului in care se afla pacientul:");
                    int targetSpitalId = sc.nextInt();
                    Spital targetSpital = null;

                    for (Spital spital : spitale.getSpitalList()) {
                        if (spital.getId() == targetSpitalId) {
                            targetSpital = spital;
                            break;
                        }
                    }

                    if (targetSpital == null) {
                        System.out.println("Nu s-a gasit niciun spital cu ID-ul " + targetSpitalId);
                        break;
                    }

                    System.out.println("Introduceti ID-ul pacientului pentru care doriti sa setati diagnosticul:");
                    int targetPatientId = sc.nextInt();
                    boolean found = false;

                    for (int i = 0; i < targetSpital.getNumPacients(); i++) {
                        Pacient currentPacient = targetSpital.getPacient(i);
                        if (currentPacient.getID() == targetPatientId) {
                            int tmp = currentPacient.getParametri();
                            if (tmp < 40 || tmp > 100) {
                                System.out.println("Introduceti Diagnostic pentru pacientul " + currentPacient.getNume() + ": ");
                                currentPacient.setDiagnostic(sc.next());
                                found = true;
                                break; // Stop searching once the patient is found and diagnosed
                            }
                        }
                    }

                    if (!found) {
                        System.out.println("Nu s-a gasit niciun pacient cu ID-ul " + targetPatientId);
                    }
                    break;
                }
                case 5:
                    System.out.println("Lista de spitale este:");
                    for (int i = 0; i < spitale.getNumSpitale(); i++) {
                        System.out.println(spitale.getSpital(i).toString());
                    }
                    break;

                case 6:
                    System.out.println("\n\nLista de spitale este:");
                    for (int i = 0; i < spitale.getNumSpitale(); i++) {
                        System.out.println(spitale.getSpital(i).toString());
                        for (int j = 0; j < spitale.getSpital(i).getNumPacients(); j++) {
                            System.out.println("\t" + spitale.getSpital(i).getPacient(j).toString());
                        }
                    }
                    System.out.println("\n\n");
                    break;



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

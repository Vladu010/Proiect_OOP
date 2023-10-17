import java.util.ArrayList;

public class Spital {
    private String numeSpital;
    private String adresaSpital;
    private ArrayList<Pacient> pacientList;
    private int id;

    public Spital(String numeSpital, String adresaSpital, int id) {
        this.adresaSpital = adresaSpital;
        this.numeSpital = numeSpital;
        this.pacientList = new ArrayList<>();
        this.id = id;
    }

    public void addPacient(Pacient pacient) {
        pacientList.add(pacient);
    }

    public void removePacient(Pacient pacient) {
        pacientList.remove(pacient);
    }

    public void removePacientByIndex(int index) {
        pacientList.remove(index);
    }

    public Pacient getPacient(int index) {
        if (index >= 0 && index < pacientList.size()) {
            return pacientList.get(index);
        } else {
            throw new IndexOutOfBoundsException("Pacientul nu este in baza de date a spitalului");
        }
    }

    public int getNumPacients() {
        return pacientList.size();
    }

    public String getNumeSpital()
    {
        return numeSpital;
    }
    public String getAdresaSpital()
    {
        return adresaSpital;
    }

    public int getId(){
        return id;
    }

    public String toString()
    {
        return "Spitalul " + numeSpital + " " + "cu adresa: " + adresaSpital + " are ID-ul " + id;

    }


}

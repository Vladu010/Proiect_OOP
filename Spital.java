import java.util.LinkedList;

public class Spital {
    private String numeSpital;
    private String adresaSpital;
    private LinkedList<Pacient> pacientList;

    public Spital(String numeSpital, String adresaSpital) {
        this.adresaSpital = adresaSpital;
        this.numeSpital = numeSpital;
        this.pacientList = new LinkedList<>();
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
}

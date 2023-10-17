import java.util.ArrayList;

public class Spitale_Lista {
    private ArrayList<Spital> spitalList = new ArrayList<>();

    public void adaugareSpital(Spital newSpital) {
        spitalList.add(newSpital);
    }

    public ArrayList<Spital> getSpitalList() {
        return spitalList;
    }


    public int getNumSpitale() {
        return spitalList.size();
    }

    public Spital getSpital(int i) {
        if (i >= 0 && i < spitalList.size()) {
            return spitalList.get(i);
        } else {
            throw new IndexOutOfBoundsException("Spitalul nu este in baza de date");
        }
    }
}

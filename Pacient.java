public class Pacient {
    private int id;
    private String nume;
    private String prenume;
    private String adresa;
    private double cnp;
    private int parametri;
    private String diagnostic;


    public Pacient() {
    }

    public Pacient(String nume, String prenume, String adresa, double cnp, int varsta, int id) {
        this.nume = nume;
        this.prenume = prenume;
        this.adresa = adresa;
        this.cnp = cnp;
        this.id = id;
    }

    public void setNume(String nume){
        this.nume=nume;
    }
    public void setPrenume(String prenume){
        this.prenume=prenume;
    }
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setParametri(int parametri){
        this.parametri=parametri;
    }

    public int getParametri(){
        return parametri;
    }

    public void setDiagnostic(String diagnostic){
        this.diagnostic=diagnostic;
    }
    public String getDiagnostic(){
        return diagnostic;
    }

    public void setCNP(double cnp) {
        this.cnp = cnp;
    }

    public String getNume(){
        return nume;
    }

    public String toString(){
        return "Id:" + id +" Pacientul : "+ nume + " " + prenume + " cu CNP-ul: " + cnp +
                " domiciliat in " + adresa + " este diagnosticat cu " + diagnostic;
    }

    public int getID(){
        return id;
    }



}
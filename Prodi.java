
public class Prodi {
    private int kodeProdi;
    private String namaProdi;
    private static int increment = 1;
    private static int resultIncrement;
    public Prodi(String namaProdi) {
        this.namaProdi = namaProdi;
        this.kodeProdi = generateRandomKodeProdi();
    }

    private int generateRandomKodeProdi() {
        this.resultIncrement = this.increment++;
        return this.resultIncrement;
    }

    public String getNamaProdi() {
        return namaProdi;
    }

    public int getKodeProdi() {
        return kodeProdi;
    }

    public String getKodeProdiFormatted() {
        return String.format("%05d", kodeProdi);
    }
}

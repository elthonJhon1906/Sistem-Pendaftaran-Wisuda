import java.util.Scanner;
 
public class Mahasiswa extends User {
    private String NPM;
    private String nama;
    private String email;
    private String noHp;
    private Prodi prodi;
    private String fakultas;
    private int angkatan;
    private BerkasPendaftaran berkas;
    private String kodeIjazah;
    
    public Mahasiswa(
        String username,
        String password,
        Role role,
        String NPM,
        String nama,
        String email,
        String noHp,
        Prodi prodi, 
        String fakultas,
        int angkatan
    ) {
        super(username, password, role);
        this.NPM = NPM;
        this.nama = nama;
        this.email = email;
        this.noHp = noHp;
        this.prodi = prodi;
        this.fakultas = fakultas;
        this.angkatan = angkatan;
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setBerkasMahasiswa(BerkasPendaftaran berkas){
        this.berkas = berkas;
    }
    
    public void displayBerkas(){
        if (berkas != null) {
            berkas.displayBerkasPendaftaran(this.nama);
        } else {
            System.out.println("Berkas belum diisi.");
        }
    }
    
    public void displayDataMahasiswa(Scanner scanner){
        System.out.println("Data Mahasiswa");
        System.out.println("Nama Lengkap : " + nama);
        System.out.println("NPM Mahasiswa : " + NPM);
        System.out.println("Email Mahasiswa : " + email);
        System.out.println("No HP Mahasiswa : " + noHp);
        System.out.println("Program Studi : " + prodi.getNamaProdi());
        System.out.println("Fakultas : " + fakultas);
        System.out.println("Angkatan : " + angkatan + "\n");
        System.out.print("Tampilkan Berkas Pendaftaran (Y/N) : ");
        String nilaiInput = scanner.nextLine();
    
        if(nilaiInput.equalsIgnoreCase("Y")){
            displayBerkas();
        }
    }
    
    public void setStatusPendaftaran(Admin adm, StatusPendaftaran status){
        berkas.updateStatus(adm, status);
        displayStatusPendaftaran();
    }

    public void displayStatusPendaftaran() {
        if (this.berkas == null) {
            System.out.println("Maaf, Berkas anda kosong");
        } else if (this.berkas.getStatus() != StatusPendaftaran.DIPROSES) {
            System.out.println("Status pendaftaran mahasiswa " + this.nama + " telah diubah menjadi: " + this.berkas.getStatus());
            if (this.berkas.getStatus() == StatusPendaftaran.DITERIMA) {
                if (this.kodeIjazah == null) {
                    this.kodeIjazah = KodeIjazah.generateKodeIjazah(this.prodi);
                }
                System.out.println("Kode Ijazah: " + this.kodeIjazah);
            }
        } else {
            // StatusPendaftaran == DIPROSES
            System.out.println("Berkas pendaftaran wisuda sedang diproses");
        }
    }
}

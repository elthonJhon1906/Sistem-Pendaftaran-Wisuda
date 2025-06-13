 import java.util.Scanner;
/**
 * Write a description of class Mahasiswa here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Mahasiswa extends User
{
    private String NPM;
    private String nama;
    private String email;
    private String noHp;
    private Prodi namaProdi;
    private String fakultas;
    private int angkatan;
    private BerkasPendaftaran berkas;
    private StatusPendaftaran status = null;
    
    public Mahasiswa(
        String username,
        String password,
        Role role,
        String NPM,
        String nama,
        String email,
        String noHp,
        Prodi namaProdi, 
        String fakultas,
        int angkatan
    ){
        super(username, password, role);
        this.NPM = NPM;
        this.nama = nama;
        this.email = email;
        this.noHp = noHp;
        this.namaProdi = namaProdi;
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
        System.out.println("Program Studi : " + namaProdi.getNamaProdi());
        System.out.println("Fakultas : " + fakultas);
        System.out.println("Angkatan : " + angkatan + "\n");
         
    
        System.out.print("Tampilkan Berkas Pendaftaran (Y/N) : ");
        String nilaiInput = scanner.nextLine();
    
        if(nilaiInput.equalsIgnoreCase("Y")){
            displayBerkas();
        }
    }
    
    public void setStatusPendaftaran(Admin adm, Mahasiswa mhs, StatusPendaftaran status){
        this.status = status;
        displayStatusPendaftaran(mhs);
    }

    public void displayStatusPendaftaran(Mahasiswa mhs){
        if(this.status == null){
            System.out.println("Maaf, Berkas anda kosong / Admin belum verifikasi berkas Anda");
        } else {
            System.out.println("Status pendaftaran mahasiswa " + mhs.getNama() + " telah diubah menjadi: " + this.status);
            if(this.status == StatusPendaftaran.DITERIMA){
                String kodeIjazah = KodeIjazah.generateKodeIjazah(this.namaProdi);
                System.out.println("Kode Ijazah: " + kodeIjazah);
            }
        }
    }
    
}

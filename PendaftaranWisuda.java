import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.function.Consumer;

public class PendaftaranWisuda {
    Scanner scanner = new Scanner(System.in);
    List<User> daftarUsers = new ArrayList<>();
    List<Mahasiswa> daftarMahasiswa = new ArrayList<>();
    List<Admin> daftarAdmin = new ArrayList<>();
    List<Mahasiswa> daftarMahasiswaWisuda = new ArrayList<>();
    private int opsi;
    
    public void main() {
        initializeMockUsers();
        System.out.println("=======================================");
        System.out.println("||Sistem Pendaftaran Wisuda Mahasiswa||");
        System.out.println("||         Universitas Lampung       ||");
        System.out.println("=======================================\n");
    
        boolean running = true;
    
        while (running) {
            User loggedInUser = loginMenu();
    
            if (loggedInUser != null) {
                System.out.println("Selamat Datang " + loggedInUser.getUsername());
    
                if (loggedInUser instanceof Admin) {
                    System.out.println("Login sebagai Admin.");
                    menuAdmin((Admin) loggedInUser);
                    System.out.println();
                } else if (loggedInUser instanceof Mahasiswa) {
                    System.out.println("Login sebagai Mahasiswa.");
                    menuMahasiswa((Mahasiswa) loggedInUser);
                    System.out.println();
                } else {
                    System.out.println("Role tidak dikenali.");
                }
    
                System.out.print("Apakah Anda ingin keluar dari sistem? (Y/N): ");
                String keluar = scanner.nextLine();
                if (keluar.equalsIgnoreCase("Y")) {
                    running = false;
                }
                System.out.println();
            } else {
                System.out.println("Maaf, Username atau Password Anda salah.");
                System.out.print("Coba lagi? (Y/N): ");
                String cobaLagi = scanner.nextLine();
                if (cobaLagi.equalsIgnoreCase("N")) {
                    running = false;
                }
                System.out.println();
            }
        }
    
        System.out.println("Terima kasih telah menggunakan sistem.");
    }
    
    private User loginMenu() {
        System.out.println("Masuk");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.print("Pilihan anda: ");
        
        if (scanner.hasNextInt()) {
            int pilihan = scanner.nextInt();
            scanner.nextLine();
            switch (pilihan) {
                case 1:
                    System.out.println("\n=== Login ===");
                    System.out.print("Username : ");
                    String username = scanner.nextLine();
                    System.out.print("Password : ");
                    String password = scanner.nextLine();
                    System.out.println();
                    
                    return daftarUsers
                        .stream()
                        .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
                        .findFirst()
                        .orElse(null);
                
                case 2:
                    System.out.println("\n=== Login ===");
                    System.out.print("Username : ");
                    String uname = scanner.nextLine();
                    if (
                        daftarUsers
                            .stream()
                            .filter(u -> u.getUsername().equals(uname))
                            .findFirst()
                            .orElse(null) != null
                    ) {
                        System.out.println("Username telah digunakan");
                        return null;
                    }
                    System.out.print("Password : ");
                    String pass = scanner.nextLine();
                    System.out.print("NPM: ");
                    String npm = scanner.nextLine();
                    System.out.print("Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("No. Hp: ");
                    String noHp = scanner.nextLine();
                    System.out.print("Prodi: ");
                    String prodi = scanner.nextLine();
                    System.out.print("Fakultas: ");
                    String fakultas = scanner.nextLine();
                    System.out.print("Angkatan: ");
                    int angkatan;
                    if (scanner.hasNextInt()) {
                        angkatan = scanner.nextInt();
                        scanner.nextLine();
                    } else {
                        System.out.println("Angkatan harus berupa angka");
                        scanner.next();
                        return null;
                    }
                    Mahasiswa m = new Mahasiswa(
                        uname,
                        pass,
                        npm,
                        nama,
                        email,
                        noHp,
                        new Prodi(prodi),
                        fakultas,
                        angkatan
                    );
                    registerUser(m);
                    System.out.println("Mahasiswa berhasil registrasi");
                    return m;
                default:
                    System.out.println("Pilihan tidak ada");
                    return null;
            }
        } else {
            System.out.println("Input harus berupa integer");
            scanner.next();
            return null;
        }
    }
    
    private void safeIntInput(Consumer<Integer> consumer) {
        if (scanner.hasNextInt()) {
            opsi = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            consumer.accept(opsi);
        } else {
            System.out.println("\nInput harus berupa angka!");
            scanner.next(); 
        }
    }

    private void menuMahasiswa(Mahasiswa mahasiswa) {
        do {
            System.out.println("\nSilahkan Pilih Opsi : ");
            System.out.println("1. Tambahkan Berkas Pendaftaran Wisuda.");
            System.out.println("2. Lihat Status Pendaftaran Wisuda");
            System.out.println("3. Keluar");
            System.out.print("Pilihan Anda: ");
            
            safeIntInput(opsi -> {
               switch (opsi) {
                    case 1 : 
                        tambahBerkasPendaftaran(mahasiswa);
                        System.out.println();
                        break;
                    case 2 :
                        mahasiswa.displayStatusPendaftaran();
                        System.out.println();
                        break;
                    case 3 :
                        System.out.println("Keluar Dari Menu Mahasiswa");
                        break;
                    default :
                        System.out.println("Pilihan tidak tersedia");
                } 
            });
        } while(opsi != 3);
    }
    
    private void tambahBerkasPendaftaran(Mahasiswa mahasiswa){
        System.out.println("Masukan Formulir Pendaftaran Wisuda : ");
        String formulirPendaftaranWisuda = scanner.nextLine();
        System.out.println("Masukan Formulir Biodata Mahasiswa : ");
        String formulirBiodataMahasiswa = scanner.nextLine();
        System.out.println("Masukan Formulir Permohonan Bebas Pustaka : ");
        String formulirPermohonanBebasPustaka = scanner.nextLine();
        System.out.println("Masukan Formulir Permohonan Bebas Laboratorium : ");
        String formulirBebasLaboratorium = scanner.nextLine();
        System.out.println("Masukan Formulir Surat Ikut Serta Wisuda : ");
        String formulirSuratIkutSertaWisuda = scanner.nextLine();
        System.out.println("Masukan Formulir Dokumen Wisuda : ");
        String formulirDokumenWisuda = scanner.nextLine();
        System.out.println("Masukan Formulir Penyerahan Karya Ilmiah : ");
        String formulirPenyerahanKaryaIlmiah = scanner.nextLine();
        BerkasPendaftaran berkas = new BerkasPendaftaran(
            formulirPendaftaranWisuda,
            formulirBiodataMahasiswa,
            formulirPermohonanBebasPustaka,
            formulirBebasLaboratorium,
            formulirSuratIkutSertaWisuda,
            formulirDokumenWisuda,
            formulirPenyerahanKaryaIlmiah
        );
        mahasiswa.setBerkasMahasiswa(berkas);
    }
    
    private void menuAdmin(Admin adminLogin) {
        do {
            System.out.println("\nSilahkan Pilih Opsi : ");
            System.out.println("1. Lihat Daftar Mahasiswa.");
            System.out.println("2. Lihat Daftar Mahasiswa Wisuda.");
            System.out.println("3. Lihat Data Mahasiswa.");
            System.out.println("4. Verifikasi Berkas Pendaftaran.");
            System.out.println("5. Keluar.");
            System.out.print("Pilihan Anda: ");

            safeIntInput(opsi -> {
                switch (opsi) {
                    case 1:
                        displayDaftarMahasiswa();
                        break;

                    case 2:
                        displayDaftarMahasiswaWisuda();
                        break;

                    case 3:
                        System.out.print("Masukan Username Mahasiswa: ");
                        String nama = scanner.nextLine();
                        Mahasiswa mhs = cariMahasiswaByUsername(nama);
                        if (mhs != null) {
                            mhs.displayDataMahasiswa(scanner);
                        } else {
                            System.out.println("Mahasiswa tidak ditemukan.");
                        }
                        break;

                    case 4:
                        System.out.print("Masukan Username Mahasiswa: ");
                        String namaMahasiswa = scanner.nextLine();
                        Mahasiswa mhs1 = cariMahasiswaByUsername(namaMahasiswa);
                        if (mhs1 == null) {
                            System.out.println("Mahasiswa tidak ditemukan.");
                            break;
                        }

                        System.out.print("Masukan Status Pendaftaran (DITERIMA / DITOLAK): ");
                        String statusInput = scanner.nextLine().toUpperCase();
                        try {
                            StatusPendaftaran status = StatusPendaftaran.valueOf(statusInput.toUpperCase());
                            mhs1.setStatusPendaftaran(adminLogin, status);
                            if(status == StatusPendaftaran.DITERIMA){
                                daftarMahasiswaWisuda.add(mhs1);
                                System.out.println("Mahasiswa berhasil ditambahkan ke daftar wisuda.");
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println("Status tidak valid.");
                        }
                        break;

                    case 5:
                        System.out.println("Keluar dari menu admin...");
                        break;

                    default:
                        System.out.println("Pilihan tidak tersedia.");
                } 
            });
        } while (opsi != 5);
    }

    private void displayDaftarMahasiswa() {
        if (daftarMahasiswa.isEmpty()) {
            System.out.println("Data Mahasiswa Tidak Tersedia");
            return;
        }
        
        System.out.println("Daftar Nama Mahasiswa:");
        daftarMahasiswa
            .stream()
            .map(m -> "- " + m.getNama() + " (" + m.getUsername() + ")")
            .forEach(System.out::println);
    }

    private void displayDaftarMahasiswaWisuda() {
        if(!daftarMahasiswaWisuda.isEmpty()){
            System.out.println("Daftar Nama Mahasiswa Wisuda:");
            daftarMahasiswaWisuda
                .stream()
                .map(m -> "- " + m.getNama() + " (" + m.getUsername() + ")")
                .forEach(System.out::println);
        } else {
            System.out.println("Data Mahasiswa Wisuda Tidak Tersedia");
        }
    }

    private Mahasiswa cariMahasiswaByUsername(String username) {
        return daftarMahasiswa
            .stream()
            .filter(m -> m.getUsername().equals(username))
            .findFirst()
            .orElse(null);
    }
    
    private void displayBerkasMahasiswa(Mahasiswa mahasiswa) {
        mahasiswa.displayBerkas();
    }
    
    private void initializeMockUsers() {    
        Prodi pro1 = new Prodi("Teknik Informatika");
        
        Mahasiswa mhs1 = new Mahasiswa(
            "udin",
            "secret",
            "1234567",
            "Udin Amat",
            "udin@email.com", 
            "08123456789", 
            pro1,                           
            "Teknik",
            2020
        );
        registerUser(mhs1);
        
        Admin admin1 = new Admin(
            "admin1",
            "secret",
            "Admin Satu",
            "id-pegawai-1",
            "admin1@gmail.com",
            "0897123456"
        );
        registerUser(admin1);
    }

    private boolean registerUser(User user) {
        if (
            daftarUsers
                .stream()
                .map(u -> u.getUsername())
                .filter(un -> un.equals(user.getUsername()))
                .collect(Collectors.toList())
                .isEmpty()
        ) {
            daftarUsers.add(user);
            if (user instanceof Mahasiswa mahasiswa) {
                daftarMahasiswa.add(mahasiswa);
            } else if (user instanceof Admin admin) {
                daftarAdmin.add(admin);
            }
            
            return true;
        }
        return false;
    }
}
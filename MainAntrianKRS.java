import java.util.Scanner;

public class MainAntrianKRS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianKRS antrian = new AntrianKRS(10);
        int pilihan;

        do {
            tampilkanMenu();
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan NIM: ");
                    String nim = sc.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String nama = sc.nextLine();
                    System.out.print("Masukkan Prodi: ");
                    String prodi = sc.nextLine();
                    System.out.print("Masukkan Kelas: ");
                    String kelas = sc.nextLine();
                    Mahasiswa mhs = new Mahasiswa(nim, nama, prodi, kelas);
                    antrian.tambahAntrian(mhs);
                    break;

                case 2:
                    antrian.panggil2Mahasiswa();
                    break;

                case 3:
                    antrian.lihatSemuaAntrian();
                    break;

                case 4:
                    antrian.lihat2Terdepan();
                    break;

                case 5:
                    antrian.lihatAkhir();
                    break;

                case 6:
                    System.out.println("Jumlah antrian saat ini: " + antrian.getJumlahAntrian());
                    break;

                case 7:
                    System.out.println("Jumlah yang sudah melakukan proses KRS: " + antrian.getJumlahProses());
                    break;

                case 8:
                    System.out.println("Jumlah yang belum melakukan proses KRS: " + antrian.getJumlahBelum());
                    break;

                case 9:
                    antrian.cetakStatistik();
                    break;

                case 10:
                    if (antrian.isEmpty()) {
                        System.out.println("Antrian sudah kosong.");
                    } else {
                        antrian.clear();
                    }
                    break;

                case 11:
                    if (antrian.isEmpty()) {
                        System.out.println("Antrian kosong.");
                    } else {
                        System.out.println("Antrian TIDAK kosong, masih ada " + antrian.getJumlahAntrian() + " mahasiswa.");
                    }
                    break;

                case 12:
                    if (antrian.isFull()) {
                        System.out.println("Antrian PENUH.");
                    } else {
                        System.out.println("Antrian TIDAK penuh, masih bisa menampung " + (10 - antrian.getJumlahAntrian()) + " mahasiswa.");
                    }
                    break;

                case 0:
                    System.out.println("Terima kasih. Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 0);

        sc.close();
    }

    public static void tampilkanMenu() {
        System.out.println("\n========================================");
        System.out.println("  ANTRIAN PERSETUJUAN KRS - DPA");
        System.out.println("========================================");
        System.out.println("1.  Tambah Mahasiswa ke Antrian");
        System.out.println("2.  Panggil 2 Mahasiswa untuk Proses KRS");
        System.out.println("3.  Tampilkan Semua Antrian");
        System.out.println("4.  Tampilkan 2 Antrian Terdepan");
        System.out.println("5.  Tampilkan Antrian Paling Akhir");
        System.out.println("6.  Cetak Jumlah Antrian Saat Ini");
        System.out.println("7.  Cetak Jumlah yang Sudah Diproses KRS");
        System.out.println("8.  Cetak Jumlah Belum Diproses KRS");
        System.out.println("9.  Cetak Statistik Lengkap");
        System.out.println("10. Kosongkan Antrian");
        System.out.println("11. Cek Antrian Kosong");
        System.out.println("12. Cek Antrian Penuh");
        System.out.println("0.  Keluar");
        System.out.println("========================================");
    }
}

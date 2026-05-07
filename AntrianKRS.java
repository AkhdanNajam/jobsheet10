public class AntrianKRS {
    private Mahasiswa[] data;
    private int front;
    private int rear;
    private int size;
    private int max;
    private int jumlahProses;
    private final int MAX_PROSES = 30;

    public AntrianKRS(int max) {
        this.max = max;
        this.data = new Mahasiswa[max];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
        this.jumlahProses = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void clear() {
        front = 0;
        rear = -1;
        size = 0;
        jumlahProses = 0;
        System.out.println("Antrian berhasil dikosongkan.");
    }

    public void tambahAntrian(Mahasiswa mhs) {
        if (isFull()) {
            System.out.println("Antrian penuh, tidak dapat menambah mahasiswa.");
            System.exit(0);
        }
        rear = (rear + 1) % max;
        data[rear] = mhs;
        size++;
        System.out.println(mhs.getNama() + " berhasil masuk ke antrian.");
    }

    public void panggil2Mahasiswa() {
        if (isEmpty()) {
            System.out.println("Antrian kosong, tidak ada mahasiswa yang dapat dipanggil.");
            System.exit(0);
        }
        
        if (jumlahProses >= MAX_PROSES) {
            System.out.println("Jumlah mahasiswa yang sudah diproses sudah mencapai " + MAX_PROSES);
            return;
        }

        System.out.println("\n--- Memanggil 2 Mahasiswa untuk Proses KRS ---");
        
        // Panggil mahasiswa pertama
        if (!isEmpty()) {
            Mahasiswa mhs1 = data[front];
            System.out.println("Mahasiswa 1:");
            mhs1.tampilkanData();
            System.out.println("Proses KRS: DISETUJUI");
            front = (front + 1) % max;
            size--;
            jumlahProses++;
        }

        // Panggil mahasiswa kedua
        if (!isEmpty()) {
            Mahasiswa mhs2 = data[front];
            System.out.println("Mahasiswa 2:");
            mhs2.tampilkanData();
            System.out.println("Proses KRS: DISETUJUI");
            front = (front + 1) % max;
            size--;
            jumlahProses++;
        }
    }

    public void lihatSemuaAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("\n--- Daftar Semua Mahasiswa dalam Antrian ---");
            System.out.println("NIM - NAMA - PRODI - KELAS");
            for (int i = 0; i < size; i++) {
                int index = (front + i) % max;
                System.out.print((i + 1) + ". ");
                data[index].tampilkanData();
            }
        }
    }

    public void lihat2Terdepan() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("\n--- 2 Antrian Terdepan ---");
            System.out.println("NIM - NAMA - PRODI - KELAS");
            int count = 0;
            for (int i = 0; i < size && count < 2; i++) {
                int index = (front + i) % max;
                System.out.print((i + 1) + ". ");
                data[index].tampilkanData();
                count++;
            }
        }
    }

    public void lihatAkhir() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("\n--- Antrian Paling Akhir ---");
            System.out.println("NIM - NAMA - PRODI - KELAS");
            data[rear].tampilkanData();
        }
    }

    public int getJumlahAntrian() {
        return size;
    }

    public int getJumlahProses() {
        return jumlahProses;
    }

    public int getJumlahBelum() {
        return size;
    }

    public void cetakStatistik() {
        System.out.println("\n--- Statistik Antrian KRS ---");
        System.out.println("Jumlah antrian saat ini: " + getJumlahAntrian());
        System.out.println("Jumlah yang sudah diproses: " + getJumlahProses() + "/" + MAX_PROSES);
        System.out.println("Jumlah belum diproses: " + getJumlahBelum());
    }
}

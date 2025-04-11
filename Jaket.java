package prktm;

import java.util.Scanner;

public class Jaket {
    // KONSTANTA FINAL
    // Harga dasar jaket (tidak bisa diubah)
    public static final int HARGA_A = 100000;      // final: nilai tetap untuk jaket A
    public static final int HARGA_B = 125000;      // final: nilai tetap untuk jaket B
    public static final int HARGA_C = 175000;      // final: nilai tetap untuk jaket C
    
    // Harga diskon (tidak bisa diubah)
    public static final int DISKON_A = 95000;      // final: diskon tetap untuk jaket A
    public static final int DISKON_B = 120000;     // final: diskon tetap untuk jaket B
    public static final int DISKON_C = 160000;     // final: diskon tetap untuk jaket C
    
    // Batas minimal diskon (tidak bisa diubah)
    public static final int BATAS_DISKON = 100;    // final: batas tetap untuk dapat diskon

    // METHOD PENGHITUNGAN 
    public static int hitungHargaA(int jumlah) {
        return jumlah > BATAS_DISKON ? jumlah * DISKON_A : jumlah * HARGA_A;
    }

    public static int hitungHargaB(int jumlah) {
        return jumlah > BATAS_DISKON ? jumlah * DISKON_B : jumlah * HARGA_B;
    }

    public static int hitungHargaC(int jumlah) {
        return jumlah > BATAS_DISKON ? jumlah * DISKON_C : jumlah * HARGA_C;
    }

    //MAIN METHOD 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean lanjut = true;
        
        System.out.println("=== PROGRAM PENJUALAN JAKET ===");
        
        while(lanjut) {
            // Tampilan menu
            System.out.println("\nPilihan Jaket:");
            System.out.println("1. Jaket A - Rp" + HARGA_A + " (Diskon Rp" + DISKON_A + " jika >" + BATAS_DISKON + ")");
            System.out.println("2. Jaket B - Rp" + HARGA_B + " (Diskon Rp" + DISKON_B + " jika >" + BATAS_DISKON + ")");
            System.out.println("3. Jaket C - Rp" + HARGA_C + " (Diskon Rp" + DISKON_C + " jika >" + BATAS_DISKON + ")");
            System.out.println("4. Hitung semua tipe");
            System.out.println("0. Keluar");
            
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            
            switch(pilihan) {
                case 1 -> { // Hitung jaket A
                    System.out.print("Masukkan jumlah: ");
                    int jumlahA = scanner.nextInt();
                    System.out.println("Total harga: Rp" + hitungHargaA(jumlahA));
                }
                case 2 -> { // Hitung jaket B
                    System.out.print("Masukkan jumlah: ");
                    int jumlahB = scanner.nextInt();
                    System.out.println("Total harga: Rp" + hitungHargaB(jumlahB));
                }
                case 3 -> { // Hitung jaket C
                    System.out.print("Masukkan jumlah: ");
                    int jumlahC = scanner.nextInt();
                    System.out.println("Total harga: Rp" + hitungHargaC(jumlahC));
                }
                case 4 -> { // Hitung semua jaket
                    System.out.print("Jumlah Jaket A: ");
                    int jA = scanner.nextInt();
                    System.out.print("Jumlah Jaket B: ");
                    int jB = scanner.nextInt();
                    System.out.print("Jumlah Jaket C: ");
                    int jC = scanner.nextInt();
                    
                    int total = hitungHargaA(jA) + hitungHargaB(jB) + hitungHargaC(jC);
                    System.out.println("Total semua: Rp" + total);
                }
                case 0 -> { // Keluar program
                    lanjut = false;
                    System.out.println("Terima kasih!");
                }
                default -> System.out.println("Pilihan tidak valid!");
            }
        }
        scanner.close();
    }
}
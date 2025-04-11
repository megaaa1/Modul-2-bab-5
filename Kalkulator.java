package prktm;

import java.util.Scanner; // Import Scanner untuk membaca input dari user

public class Kalkulator {
    // Static method untuk penjumlahan
    // Menggunakan static karena tidak memerlukan instance object
    public static double tambah(double a, double b) {
        return a + b; // Mengembalikan hasil penjumlahan a dan b
    }
    
    // Static method untuk pengurangan
    public static double kurang(double a, double b) {
        return a - b; // Mengembalikan hasil pengurangan a dan b
    }
    
    // Non-static method untuk perkalian
    // Menggunakan non-static untuk menunjukkan perbedaan cara pemanggilan
    public double kali(double a, double b) {
        return a * b; // Mengembalikan hasil perkalian a dan b
    }
    
    // Non-static method untuk pembagian
    public double bagi(double a, double b) {
        // Validasi pembagi tidak boleh nol
        if (b == 0) {
            throw new IllegalArgumentException("Pembagi tidak boleh nol");
        }
        return a / b; // Mengembalikan hasil pembagian a dan b
    }
    
    // Method untuk menyederhanakan pecahan
    public String sederhana(int pembilang, int penyebut) {
        // Validasi penyebut tidak boleh nol
        if (penyebut == 0) {
            throw new IllegalArgumentException("Penyebut tidak boleh nol");
        }
        
        // Menghitung FPB untuk penyederhanaan
        int fpb = hitungFPB(pembilang, penyebut);
        int sederhanaPembilang = pembilang / fpb;
        int sederhanaPenyebut = penyebut / fpb;
        
        // Jika penyebut 1, cukup tampilkan pembilang saja
        if (sederhanaPenyebut == 1) {
            return Integer.toString(sederhanaPembilang);
        } 
        // Jika penyebut negatif, pindahkan tanda ke pembilang
        else if (sederhanaPenyebut < 0) {
            sederhanaPembilang *= -1;
            sederhanaPenyebut *= -1;
        }
        
        // Kembalikan dalam format pecahan
        return sederhanaPembilang + "/" + sederhanaPenyebut;
    }
    
    // Method private untuk menghitung FPB (Faktor Persekutuan Terbesar)
    // Menggunakan algoritma Euclidean
    private int hitungFPB(int a, int b) {
        // Menggunakan nilai absolut untuk menghindari masalah dengan bilangan negatif
        a = Math.abs(a);
        b = Math.abs(b);
        
        // Algoritma Euclidean untuk mencari FPB
        while (b != 0) {
            int temp = b;
            b = a % b; // Modulo untuk mendapatkan sisa pembagian
            a = temp;
        }
        return a; // a sekarang berisi FPB
    }
    
    public static void main(String[] args) {
        // Membuat objek Scanner untuk membaca input
        Scanner scanner = new Scanner(System.in);
        // Membuat instance kalkulator untuk memanggil method non-static
        Kalkulator kalkulator = new Kalkulator();
        
        // Menampilkan menu operasi
        System.out.println("=== KALKULATOR MEGA ===");
        System.out.println("Pilih operasi:");
        System.out.println("1. Penjumlahan");
        System.out.println("2. Pengurangan");
        System.out.println("3. Perkalian");
        System.out.println("4. Pembagian");
        System.out.println("5. Penyederhanaan Pecahan");
        System.out.print("Masukkan pilihan (1-5): ");
        
        // Membaca pilihan user
        int pilihan = scanner.nextInt();
        
        // Switch case untuk menangani berbagai operasi
        switch(pilihan) {
            case 1: // Penjumlahan
                System.out.print("Masukkan bilangan pertama: ");
                double a1 = scanner.nextDouble();
                System.out.print("Masukkan bilangan kedua: ");
                double b1 = scanner.nextDouble();
                // Memanggil static method tambah
                System.out.println("Hasil: " + a1 + " + " + b1 + " = " + tambah(a1, b1));
                break;
                
            case 2: // Pengurangan
                System.out.print("Masukkan bilangan pertama: ");
                double a2 = scanner.nextDouble();
                System.out.print("Masukkan bilangan kedua: ");
                double b2 = scanner.nextDouble();
                // Memanggil static method kurang
                System.out.println("Hasil: " + a2 + " - " + b2 + " = " + kurang(a2, b2));
                break;
                
            case 3: // Perkalian
                System.out.print("Masukkan bilangan pertama: ");
                double a3 = scanner.nextDouble();
                System.out.print("Masukkan bilangan kedua: ");
                double b3 = scanner.nextDouble();
                // Memanggil non-static method kali
                System.out.println("Hasil: " + a3 + " * " + b3 + " = " + kalkulator.kali(a3, b3));
                break;
                
            case 4: // Pembagian
                System.out.print("Masukkan bilangan pertama: ");
                double a4 = scanner.nextDouble();
                System.out.print("Masukkan bilangan kedua: ");
                double b4 = scanner.nextDouble();
                try {
                    // Memanggil non-static method bagi dengan try-catch untuk error handling
                    System.out.println("Hasil: " + a4 + " / " + b4 + " = " + kalkulator.bagi(a4, b4));
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
                
            case 5: // Penyederhanaan Pecahan
                System.out.print("Masukkan pembilang: ");
                int pembilang = scanner.nextInt();
                System.out.print("Masukkan penyebut: ");
                int penyebut = scanner.nextInt();
                try {
                    // Memanggil method sederhana dengan try-catch untuk error handling
                    System.out.println("Hasil penyederhanaan: " + kalkulator.sederhana(pembilang, penyebut));
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
                
            default: // Pilihan tidak valid
                System.out.println("Pilihan tidak valid!");
        }
        
        // Menutup scanner untuk menghindari resource leak
        scanner.close();
    }
}
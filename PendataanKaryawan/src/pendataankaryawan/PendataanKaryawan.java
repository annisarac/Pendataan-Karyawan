/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendataankaryawan;

import java.util.Scanner;

/**
 *
 * @author Annisa Rachmawati
 */
public abstract class PendataanKaryawan {
    abstract public void tambahData (DataKaryawan dataKaryawan);
    abstract public void hapusData (String kode);
    abstract public void cariData (String kode);
    abstract public void lihatData();

    public static void main(String[] args) {
        // TODO code application logic here
        boolean menu = true;
        DataMenu dm = new DataMenu();
        
        while(menu){
            System.out.println("======================================================================================================================");
            System.out.println(                                                     "Menu Utama");
            System.out.println("----------------------------------------------------------------------------------------------------------------------");
            System.out.println("1. Tambah data");
            System.out.println("2. Hapus Data");
            System.out.println("3. Cari Data");
            System.out.println("4. Lihat Data");
            System.out.println("5. Exit");
            System.out.println("----------------------------------------------------------------------------------------------------------------------");
            
            Scanner input = new Scanner( System.in );
            System.out.print("Menu pilihan: ");
            
            int pilihMenu = input.nextInt();
            boolean TambahData = true, HapusData = true, CariData = true, LihatData = true;
            switch (pilihMenu){
                case 1 : 
                    while(TambahData){
                        System.out.println("");
                        System.out.println("======================================================================================================================");
                        System.out.println("                                        Menu Tambah Data");
                        System.out.println("----------------------------------------------------------------------------------------------------------------------");
                        String tdata = input.nextLine();
                        
                        //input data
                        System.out.print("Masukan Kode Karyawan             : ");
                        String kode = input.nextLine();
                        System.out.print("Masukan Nama Karyawan             : ");
                        String nama = input.nextLine();
                        System.out.print("Masukan Alamat                    : ");
                        String alamat = input.nextLine();
                        System.out.print("Masukan Tanggal Lahir (YYYY-MM-DD): ");
                        String tglLahir = input.nextLine();
                        System.out.print("Masukan Golongan (A/B/C)          : ");
                        String golongan = input.nextLine();
                        System.out.println("");
                        
                        System.out.println("Masukan Status Menikah");
                        System.out.println("0. Belum");
                        System.out.println("1. Menikah");
                        System.out.print("Status Karyawan                   : ");
                        int status = input.nextInt();
                        int jmlahAnak;
                        if( status == 1 ){
                            System.out.print("Jumlah Anak                       : ");
                            jmlahAnak = input.nextInt();
                        } else {
                            status = 0;
                            jmlahAnak = 0;
                        }
                        
                        DataKaryawan DKar = new DataKaryawan(kode, nama, alamat, tglLahir, golongan, status, jmlahAnak);  
                        dm.tambahData(DKar);
                        
                        //Sub menu
                        System.out.println("");
                        System.out.println("----------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Pilih Submenu : ");
                        System.out.println("1. Kembali ke menu utama");
                        System.out.println("2. Tambah Data Kembali");
                        System.out.println("");
                        System.out.print("Menu Pilihan : ");
                        
                        int pilih = input.nextInt();
                        if(pilih == 1){
                            TambahData = false;
                        }
                    }
                    break;
                
                case 2 : 
                    
                    while(HapusData) {
                        System.out.println("");
                        System.out.println("======================================================================================================================");
                        System.out.println("                                        Menu Hapus Data");
                        System.out.println("----------------------------------------------------------------------------------------------------------------------");
                        String tdata = input.nextLine();
                        
                        System.out.print("Masukan kode karyawan yang mau dihapus : ");
                        String kode = input.nextLine(); 
                        dm.hapusData(kode);
                        

                        //Sub menu
                        System.out.println("");
                        System.out.println("----------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Pilih Submenu : ");
                        System.out.println("1. Kembali ke menu utama");
                        System.out.println("");
                        System.out.print("Menu Pilihan : ");
                        
                        int pilih = input.nextInt();
                        if(pilih == 1){
                            HapusData = false;
                        }
                    }
                    break;
                    
                case 3 :                     
                    
                    while(CariData){
                        System.out.println("");
                        System.out.println("======================================================================================================================");
                        System.out.println("                                        Menu Cari Data");
                        System.out.println("----------------------------------------------------------------------------------------------------------------------");
                        String tdata = input.nextLine();
                        
                        System.out.print("Masukan Kode Karyawan : ");
                        String kodeKar = input.nextLine();
                        dm.cariData(kodeKar);

                        //Sub menu
                        System.out.println("");
                        System.out.println("----------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Pilih Submenu : ");
                        System.out.println("1. Kembali ke menu utama");
                        System.out.println("");
                        System.out.print("Menu Pilihan : ");
                        
                        int pilih = input.nextInt();
                        if(pilih == 1 ){
                            CariData = false;
                        }
                    }
                    break;
                    
                case 4 : 
                    
                    while(LihatData){
                        dm.lihatData();
                        
                        //Sub menu
                        System.out.println("\n ----------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Pilih Submenu : ");
                        System.out.println("1. Kembali ke menu utama");
                        System.out.println("");
                        System.out.print("Menu Pilihan : ");
                        
                        int pilih = input.nextInt();
                        if(pilih == 1){
                            LihatData = false;
                        }
                    }
                    break;

                case 5 : 
                    System.exit(0);
            }
        }
    }
    
}

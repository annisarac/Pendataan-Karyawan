/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendataankaryawan;

import java.util.ArrayList;
/**
 *
 * @author Annisa Rachmawati
 */
public class DataMenu extends PendataanKaryawan{
    ArrayList<DataKaryawan> dk = new ArrayList<DataKaryawan>();
    boolean hapus = false, cari = false;
    int nilai = 0;
    
    public void tambahData(DataKaryawan dataKaryawan){
        dk.add(dataKaryawan);
    }
    
    public void hapusData(String kodeKaryawan){
        for(int i = 0; i < dk.size(); i++){
            if(dk.get(i).kode.equals(kodeKaryawan)){
                dk.remove(i);
                this.hapus = true;
            }
        }
    }
    
    public void cariData(String kodeKaryawan){
        for(int i = 0; i < dk.size(); i++){
            if(dk.get(i).kode.equals(kodeKaryawan)){
                nilai = i;
                this.cari = true;
            }
        }
        
        if(cari){
            dk.get(nilai).lihatData();
        }
    }
    
    public void lihatData(){
        String jarak = "| %-10s | %-30s | %-5s | %-5s | %-15s | %-11s %n";
        
        System.out.println("======================================================================================================================");
        System.out.println("                                                    DATA KARYAWAN");
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        System.out.printf(jarak, "KODE", "NAMA", "GOL", "USIA", "STATUS NIKAH", "JUMLAH ANAK");
        System.out.println("----------------------------------------------------------------------------------------------------------------------");

        for(int i=0; i <dk.size(); i++){
            String KodeKaryawan = dk.get(i).kode;
            String NamaKaryawan = dk.get(i).nama;
            String Golongan = dk.get(i).golongan;
            int Umur = dk.get(i).usia;
            String Status = "Belum Menikah";
            int Anak = 0;
            if( dk.get(i).status == 1){
                Status = "Sudah Menikah";
                Anak = dk.get(i).jmlahAnak;
            }else if( dk.get(i).status == 0){
                Status = "Belum Menikah";
                Anak = 0;
            }
            
            
            System.out.printf(jarak, KodeKaryawan , NamaKaryawan , Golongan, Umur,  Status, Anak );
        }
        
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        System.out.println("Jumlah Data : " + dk.size());
    }
}

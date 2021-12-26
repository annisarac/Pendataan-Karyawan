/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendataankaryawan;

import java.time.Period;
import java.time.LocalDate;

/**
 *
 * @author Annisa Rachmawati
 */
public class DataKaryawan {
    //tanggal
    private int dd, mm, yy;
    //karyawan
    public String kode, nama, alamat, tglLahir, golongan;
    //status
    public int gajiPokok, jmlahAnak, usia, tunjanganSuamiIstri, tunjanganPegawai, tunjanganAnak, gajiKotor, potongan, gajiBersih, status;
    
    boolean statusSuamiIstri = false, statusPegawai = false, statusAnak = false;
    
    //constructor
    public DataKaryawan(String kode, String nama, String alamat, String tglLahir, String golongan, int status, int anak){
        this.kode = kode;
        this.nama = nama;
        this.alamat = alamat;
        this.tglLahir = tglLahir;
        this.golongan = golongan;
        this.status = status;
        this.jmlahAnak = anak;
        
        //umur
        String dateBorn = this.tglLahir;
        String[] born = dateBorn.split("-");
        dd = Integer.parseInt(born[0]);
        mm = Integer.parseInt(born[1]);
        yy = Integer.parseInt(born[2]);
        
        LocalDate form = LocalDate.of(dd, mm , yy);
        LocalDate today = LocalDate.now();
        
        int umurKaryawan = Period.between(form, today).getYears();
        this.usia = umurKaryawan;
        
        //gaji pokok
        switch (golongan){
            case "A" :
                gajiPokok = 5000000;
                break;
            case "B" :
                gajiPokok = 6000000;
                break;
            case "C" :
                gajiPokok = 7000000;
                break;
        }
        
        //tunjangan menikah
        switch (status){
            case 1 :
                this.tunjanganSuamiIstri = gajiPokok / 10;
                this.statusSuamiIstri = true;
                break;
        }
        
        //tunjangan anak
        switch (status){
            case 1 :
                if(jmlahAnak > 0){
                    this.tunjanganAnak = (jmlahAnak * gajiPokok * 5) / 100;
                    this.statusAnak = true;
                }
                break;
        }
        
        //tunjangan pegawai
        switch (status){
            case 1 :
                if (usia > 30){
                    this.tunjanganPegawai = (gajiPokok * 15) / 100;
                }
                break;
        }
        
        //gaji kotor
        this.gajiKotor = gajiPokok + tunjanganPegawai + tunjanganSuamiIstri + tunjanganAnak;
        
        //potongan
        this.potongan = (gajiKotor * 25) / 1000;
        
        //gaji Bersih
        this.gajiBersih = gajiKotor - potongan;
    }
    
    public void lihatData(){
        System.out.println("==================================================================================================");
        System.out.println("                                    DATA KARYAWAN");
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println("Kode Karyawan : " + this.kode);
        System.out.println("Nama Karyawan : " + this.nama);
        System.out.println("Golongan : " + this.golongan);
        System.out.println("usia : " + this.usia);
        
        if (status == 0){
            System.out.println("Status : Belum Menikah");
            System.out.println("----------------------------------------------------------------------------------------------");
        } else if (status == 1){
            System.out.println("Status : Menikah" );
            System.out.println("Jumlah Anak    : " + this.jmlahAnak );
            System.out.println("----------------------------------------------------------------------------------------------");
        }
        
        System.out.println("Gaji Pokok : RP. " + this.gajiPokok);
        
        if(statusSuamiIstri){
            System.out.println("Tunjangan Suami / Istri : Rp. " + this.tunjanganSuamiIstri);
        }
        if(statusPegawai){
            System.out.println("Tunjangan Pegawai : Rp. " + this.tunjanganPegawai);
        }
        if(statusAnak){
            System.out.println("Tunjangan Anak : Rp. " + this.tunjanganAnak);
        }
        
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("Gaji Kotor : Rp. " + gajiKotor);
        System.out.println("Potongan : Rp. " + potongan);
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("Gaji Bersih : Rp. " + gajiBersih);
    }
}

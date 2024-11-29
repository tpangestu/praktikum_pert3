/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.pangestu.mahasiswa.controller;


import me.pangestu.mahasiswa.model.MahasiswaDAO;
import me.pangestu.mahasiswa.model.ModelMahasiswa;
import java.util.List;
/**
 *
 * @author tri pangestu
 */
public class MahsiswaController {
    private MahasiswaDAO mahasiswaDAO;
    
    public MahsiswaController(MahasiswaDAO mahasiswaDAO) {
        this.mahasiswaDAO = mahasiswaDAO;
    }
    
    public void displayMahasiswaList(List<ModelMahasiswa> mahasiswaList) {
        if(mahasiswaList.isEmpty()) {
            System.out.println("Tidak ada data");
        } else {
            System.out.println("\n======================");
            for(ModelMahasiswa m : mahasiswaList) {
                System.out.println("ID       : " + m.getId());
                System.out.println("NPM      : " + m.getNpm());
                System.out.println("NAMA     : " + m.getNama());
                System.out.println("Semester : " + m.getSemester());
                System.out.println("IPK      : " + m.getIpk());
                System.out.println("======================");
            }
        }
    }
    
    public void displayMessage(String message) {
        System.out.println(message);
    }
    
    public void checkDatabaseConnection() {
        boolean isConnected = mahasiswaDAO.checkConnection();
        if(isConnected) {
            displayMessage("Koneksi ke db berhasil");
        } else {
            displayMessage("Koneksi ke db gagal");
        }
    }
    
    public void displayAllMahasiswa() {
        List<ModelMahasiswa> mahasiswaList = mahasiswaDAO.getAllMahasiswa();
        displayMahasiswaList(mahasiswaList);
    }

    public void addMahasiswa(String npm, String nama, int semester, float ipk) {
        ModelMahasiswa mahasiswaBaru = new ModelMahasiswa(0, npm, nama, semester, ipk);
        mahasiswaDAO.addMahasiswa(mahasiswaBaru);
        displayMessage("Mahasiswa berhasil ditambahkan");
    }

    public void updateMahasiswa(int id, String npm, String nama, int semester, float ipk) {
        ModelMahasiswa mahasiswaBaru = new ModelMahasiswa(id, npm, nama, semester, ipk);
        mahasiswaDAO.updateMahasiswa(mahasiswaBaru);
        displayMessage("Mahasiswa berhasil diperbarui");
    }
    
    public void deleteMahasiswa(int id){
        mahasiswaDAO.deleteMahasiswa(id);
        displayMessage("Mahasiswa berhasil dihapus");
    }
    
    public void closeConnection(){
        mahasiswaDAO.closeConnection();
    }
}

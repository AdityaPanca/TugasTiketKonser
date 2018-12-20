/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leho.daftar;

import com.leho.admin.Itiket;
import com.leho.login.admin.IAdmin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.leho.model.TiketModel;
/**
 *
 * @author hp
 */
public class MyConnection implements IUser, IAdmin, Itiket{
        
    ResultSet r = null;
	private static Connection koneksi;
	
	public static void buka_koneksi(){
		if (koneksi == null) {
			try {
				String url = "jdbc:mysql://localhost:3306/login";
				String user = "root";
				String password = "";
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				koneksi = (Connection) DriverManager.getConnection(url,user,password);
			} catch (SQLException e) {
				System.out.println("Eror Membuat Koneksi");
			}
			
		}
	}
    private String harga;

        
    @Override
        public void userDaftar(String nama, String username, String password, String alamat, String email) {
		
		buka_koneksi();		
		try {
			Statement s =koneksi.createStatement();
			String sql = "INSERT INTO users (nama, username, password, alamat, email) VALUES ('"+ nama +"','"+username+ "',"+ "'" + password + "','"+alamat+"','"+email+"')";
			s.executeUpdate(sql);
		} catch (SQLException e) {
				Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, e);
				
		}
	}

    @Override
    public ResultSet cekLogin(String username, String password) {
        buka_koneksi();
        try {
            Statement s = koneksi.createStatement();
            String sql = "SELECT * FROM users WHERE username='"+username+"'AND password='"+password+"'";   
            r = s.executeQuery(sql);
        } catch (SQLException e) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        return r;
    }

    @Override
    public ResultSet cekLoginAdmin(String username, String password) {
        buka_koneksi();
        try {
            Statement s = koneksi.createStatement();
            String sql = "SELECT * FROM Admin WHERE username='"+username+"'AND password='"+password+"'";   
            r = s.executeQuery(sql);
        } catch (SQLException e) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        return r;
    }

    public void ekonomi(int stok, int harga) {
        buka_koneksi();
        try {
            Statement s = koneksi.createStatement();
            String kodeSql = "UPDATE ekonomi SET stok='"+stok+"'AND harga='"+harga+"'";   
            PreparedStatement st = koneksi.prepareStatement(kodeSql);
            st.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, e);
        }
 
    }

    public void vip(int stok, int harga) {
        buka_koneksi();
        try {
            Statement s = koneksi.createStatement();
            String kodeSql = "UPDATE vip SET stok='"+stok+"'AND harga='"+harga+"'";   
            PreparedStatement st = koneksi.prepareStatement(kodeSql);
            st.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void vvip(int stok, int harga) {
        buka_koneksi();
        try {
            Statement s = koneksi.createStatement();
            String kodeSql = "UPDATE vvip SET stok='"+stok+"'AND harga='"+harga+"'";    
            PreparedStatement st = koneksi.prepareStatement(kodeSql);
            st.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, e);
        }
    }

//    @Override
//    public void ekonomi(String stok, String harga) {
//        buka_koneksi();
//        try {
//            Statement s = koneksi.createStatement();
//            String kodeSql = "UPDATE ekonomi SET stok='"+stok+"'AND harga='"+harga+"'";   
//            PreparedStatement st = koneksi.prepareStatement(kodeSql);
//            st.executeUpdate();
//        } catch (SQLException e) {
//            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, e);
//        }
// 
//    }

    @Override
    public void vip(String stok, String harga) {
        try {
            Statement s = koneksi.createStatement();
            String kodeSql = "UPDATE vip SET stok='"+stok+"'AND harga='"+harga+"'";   
            PreparedStatement st = koneksi.prepareStatement(kodeSql);
            st.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void vvip(String stok, String harga) {
        buka_koneksi();
        try {
            Statement s = koneksi.createStatement();
            String kodeSql = "UPDATE vvip SET stok='"+stok+"'AND harga='"+harga+"'";    
            PreparedStatement st = koneksi.prepareStatement(kodeSql);
            st.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public ResultSet ekonomi(String stok) {
        buka_koneksi();
        try {
            Statement s = koneksi.createStatement();
            String kdsql = "UPDATE ekonomi SET stok='"+stok+"'AND harga='"+harga+"'";   
            r = s.executeQuery(kdsql);
        } catch (SQLException e) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        return r;
    }

    @Override
    public ResultSet vip(String stok) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet vvip(String stok) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

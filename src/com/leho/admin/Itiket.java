/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leho.admin;

import java.sql.ResultSet;

/**
 *
 * @author hp
 */
public interface Itiket {
    public void ekonomi(String stok, String harga);
    public void vip (String stok, String harga);
    public void vvip(String stok, String harga);

    public ResultSet ekonomi(String stok);
    public ResultSet vip (String stok);
    public ResultSet vvip(String stok);
    
}

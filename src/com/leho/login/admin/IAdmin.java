/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leho.login.admin;

import java.sql.ResultSet;

/**
 *
 * @author hp
 */
public interface IAdmin {
    public ResultSet cekLoginAdmin(String username, String password);
}

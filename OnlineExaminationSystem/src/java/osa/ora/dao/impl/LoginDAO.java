/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osa.ora.dao.impl;

import osa.ora.beans.Login;
import osa.ora.dao.impl.helper.ConnectionManager;
import osa.ora.log.Logger;

/**
 *
 * @author keyur
 */
public class LoginDAO {
    private static LoginDAO loginDAO = new LoginDAO();
    private static Logger logger = Logger.getLogger("LoginDAO");
    private static ConnectionManager connectionManager=ConnectionManager.getConnectionManager();
    /**
     * Singleton class method
     * @return instance of this DAO.
     */
    public static LoginDAO getLoginDAOInstance() {
        return loginDAO;
    }

    public  boolean loginProcess(Login login) {
        return true;
    }

    private LoginDAO() {
    }
}

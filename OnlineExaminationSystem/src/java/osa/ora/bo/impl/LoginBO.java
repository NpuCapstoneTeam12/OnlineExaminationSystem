/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osa.ora.bo.impl;

import osa.ora.beans.Login;
import osa.ora.beans.UserProfile;
import osa.ora.dao.DAOFactory;
import osa.ora.dao.impl.LoginDAO;
import osa.ora.exception.ApplicationException;
import osa.ora.spi.IAccount;
import osa.ora.spi.ILogin;

/**
 *
 * @author keyur
 */
public class LoginBO {
    private static LoginBO loginBO = new LoginBO();
    LoginDAO loginDAO=LoginDAO.getLoginDAOInstance();
    public static LoginBO getLoginBOInstance() {
        return loginBO;
    }
    private LoginBO(){        
    }

    public  boolean loginProcess(Login login) {
        return loginDAO.loginProcess(login);
    }
    
}


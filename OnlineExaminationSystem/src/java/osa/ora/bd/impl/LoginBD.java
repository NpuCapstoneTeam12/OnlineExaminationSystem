/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osa.ora.bd.impl;

import java.util.Hashtable;
import osa.ora.beans.ExamBean;
import osa.ora.beans.Login;
import osa.ora.beans.UserProfile;
import osa.ora.bo.BOFactory;
import osa.ora.bo.impl.LoginBO;
import osa.ora.exception.ApplicationException;
import osa.ora.spi.IExam;
import osa.ora.spi.ILogin;

/**
 *
 * @author keyur
 */
public class LoginBD {

    private static LoginBD loginBD = new LoginBD();
    LoginBO loginBO = LoginBO.getLoginBOInstance();

    public static LoginBD getExamBDInstance() {
        return loginBD;
    }

    private LoginBD() {
    }

    public boolean loginProcess(Login login) {
        return loginBO.loginProcess(login);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osa.ora.spi;

import osa.ora.beans.Login;
import osa.ora.exception.ApplicationException;

/**
 *
 * @author keyur
 */
public interface ILogin {
    public Login login (Login login) throws ApplicationException;
}

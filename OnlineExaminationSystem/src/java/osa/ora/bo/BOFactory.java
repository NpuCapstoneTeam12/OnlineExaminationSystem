package osa.ora.bo;

import osa.ora.bo.impl.AccountBO;
import osa.ora.bo.impl.CommonBO;
import osa.ora.bo.impl.ExamBO;
import osa.ora.bo.impl.LoginBO;
import osa.ora.exception.ApplicationException;
import osa.ora.spi.IAccount;
import osa.ora.spi.ICommon;
import osa.ora.spi.IExam;
/*
 * @author Osama Oransa
 */
public class BOFactory{

    public static ICommon getCommonBO() {
        return CommonBO.getCommonBOInstance();
    }
    public static IAccount getAccountBO(){
        return AccountBO.getAccountBOInstance();
    }
    public static IExam getExamBO(){
        return ExamBO.getExamBOInstance();
    }
    
}
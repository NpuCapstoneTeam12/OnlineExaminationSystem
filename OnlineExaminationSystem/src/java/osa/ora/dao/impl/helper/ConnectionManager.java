/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package osa.ora.dao.impl.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import osa.ora.exception.TechnicalException;
import osa.ora.log.Logger;
import osa.ora.spi.IConstant;

/**
 * @author Osama Oransa
 */
public class ConnectionManager {

    private static ConnectionManager connectionManager = new ConnectionManager();
    private DataSource dataSource = null;
    private Context context = null;
    private Logger logger;
    private int numberOfOpenConnections = 0;

    /**
     * get connection manager singleton instance object
     *
     * @return ConnectionManager
     */
    public static ConnectionManager getConnectionManager() {
        return connectionManager;
    }

    private ConnectionManager() {
        logger = Logger.getLogger("ConnectionManager");
        try {
            context = new InitialContext();
//            dataSource = (DataSource) context.lookup(IConstant.DATA_SOURCE_NAME);
//            dataSource = (DataSource) context.lookup("java::jdbc/exam");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Get valid DB connection
     *
     * @return
     * @throws TechnicalException
     */
    public static Connection getConnection()
            throws SQLException, ClassNotFoundException {

        String dbURL = "jdbc:mysql://localhost:3306/exam";
        String user = "root";
        String password = "root";
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(dbURL, user, password);
    }

//    public Connection getConnection() throws TechnicalException {
//        Connection connection = null;
//        try {
//            connection = dataSource.getConnection();
//            numberOfOpenConnections++;
//            if (Logger.isAllowDebugging()) {
//                logger.debug("Number of Open Connections, after Open new connection:" + numberOfOpenConnections);
//            }
//            return connection;
//        } catch (SQLException ex) {
//            throw new TechnicalException("couldn't Open the connection");
//        }
//    }
    /**
     * Release a DB connection
     *
     * @param connection
     * @throws TechnicalException
     */
    public void releaseConnection(Connection connection) throws TechnicalException {
        try {
            connection.close();
            numberOfOpenConnections--;
            if (Logger.isAllowDebugging()) {
                logger.debug("Number of Open Connections, after close old connection:" + numberOfOpenConnections);
            }
        } catch (SQLException ex) {
            throw new TechnicalException("couldn't close the connection");
        }
    }

    public static void main(String args[]) {
        try {
            Connection conn = null;

            conn = getConnection();

            conn.close();
        } catch (Exception ex) {
            System.out.println("ex::" + ex);
            ex.printStackTrace();
        }
    }
}

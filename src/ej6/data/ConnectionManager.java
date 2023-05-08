package ej6.data;

import java.sql.*;

public class ConnectionManager {

  private static ConnectionManager instancia;

  private String driver="com.mysql.cj.jdbc.Driver";
  private String host="localhost";
  private String port="3306";
  private String user="root";
  private String password="1234";
  private String db="javamarket";
  private int conectados=0;
  private Connection conn=null;

  private ConnectionManager() {
    try {
      Class.forName(driver);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static ConnectionManager getInstancia() {
    if (instancia == null) {
      instancia = new ConnectionManager();
    }
    return instancia;
  }

  public Connection getConn() {
    try {
      if(conn==null || conn.isClosed()) {
        conn=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db, user, password);
        conectados=0;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    conectados++;
    return conn;
  }

  public void releaseConn() {
    conectados--;
    try {
      if (conectados<=0) {
        conn.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  public boolean testConnection() {
    try {
      Connection conn = getConn();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    } finally {
      releaseConn();
    }
  }


}

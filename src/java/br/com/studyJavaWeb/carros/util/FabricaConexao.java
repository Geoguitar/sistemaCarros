package br.com.studyJavaWeb.carros.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author geoguitar
 */
public class FabricaConexao {
    
    private static Connection conexao;
    private static final String URL_CONEXAO = "jdbc:mysql://localhost:3306/sistema-carros";
    private static final String USUARIO = "root";
    private static final String SENHA = "macapple";

    public static Connection getConexao() {
        
        if(conexao == null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexao = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
            } catch (SQLException ex) {
                Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        return conexao;
        
    }
    
    public static void fecharConexao(){
        
        if(conexao != null){
            try {
                conexao.close();
                conexao = null;
            } catch (SQLException ex) {
                Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, ex);
            }

            
        }
    }
    
}

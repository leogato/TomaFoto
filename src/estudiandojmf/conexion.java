/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package estudiandojmf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Cmop
 */
public class conexion {

    public static Connection iniciaConexion()
    {
        Connection conexion=null;
        try
        {
            Class.forName("org.gjt.mm.mysql.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/sistema_entrada","root","");
        }
        catch (Exception e){mensajero.mensajeError(null, "Fallo al Conectar a SGBD");}
        return conexion;
    }
    public static void cerrarConexion(Connection con)
    {
        try {
            con.close();
        } catch (SQLException ex) {}
    }
}

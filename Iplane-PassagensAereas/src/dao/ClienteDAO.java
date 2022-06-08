package dao;

import java.sql.*;
import utilitario.ConnectionFactory;
import classes.Cliente;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClienteDAO {

    private Connection con = null;

    public ClienteDAO() {
        con = ConnectionFactory.getConexao();
    }

    public boolean create(Cliente cliente) {
        PreparedStatement stmt = null;
        String sql = "INSERT INTO crud.clientes (nome, cpf, cep, nasc) VALUES (?, ?, ?, ?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getCep());
            stmt.setString(4, cliente.getNasc());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
}
    
    
    
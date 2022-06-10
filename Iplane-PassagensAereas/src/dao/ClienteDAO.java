package dao;

import java.sql.*;
import utilitario.ConnectionFactory;
import classes.Cliente;
import static java.lang.String.valueOf;
import java.util.ArrayList;
import java.util.List;
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
        ResultSet rs = null;
        String sql = "INSERT INTO crud.clientes (nome, cpf, cep, nasc) VALUES (?, ?, ?, ?)";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
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
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

    }
   

    public List<Cliente> read() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM crud.clientes";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();

                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setCep(rs.getString("cep"));
                cliente.setNasc(rs.getString("nasc"));
                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return clientes;
    }

    
 public boolean update(Cliente cliente) {
        PreparedStatement stmt = null;
        String sql = "UPDATE crud.clientes SETE nome = ?, cpf = ?, cep = ?, nasc = ? WHERE id =? )";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getCep());
            stmt.setString(4, cliente.getNasc());
            stmt.setInt(5, cliente.getId());
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
    public boolean delete(Cliente cliente) {
        PreparedStatement stmt = null;
        String sql = "DELETE From crud.clientes WHERE id =? )";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, cliente.getId());
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


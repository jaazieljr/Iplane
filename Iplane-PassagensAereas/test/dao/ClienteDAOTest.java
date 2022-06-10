
package dao;
/**
import classes.Cliente;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;




 *
 * @author jaazi

public class ClienteDAOTest {
    
 public ClienteDAOTest() {
    
  }
 @Test
  public void listar(){
     ClienteDAO dao = new ClienteDAO();
     for (Cliente c:dao.findAll()){
          System.out.println("os dados são "+ c.getId() + c.getNome() + c.getCpf());
           }
        }
   @Test
  public void inserir() {
        
     Cliente cliente = new Cliente(30, "nome", "cpf", "cep","nasc");
     ClienteDAO dao = new ClienteDAO();
   if (dao.create(cliente)){
          System.out.println("Salvo com sucesso");   
      } else 
          fail("Erro ao salvar");
       
    
    }

 */
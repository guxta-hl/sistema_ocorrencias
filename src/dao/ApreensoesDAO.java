package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Apreensoes;

public class ApreensoesDAO {
	
	  public void inserir(Apreensoes a, int idOcorrencia) {

	        String sql = "INSERT INTO apreensao (descricao, tipo, ocorrencia_id) VALUES (?, ?, ?)";

	        try (Connection conn = ConnectDAO.connectDB();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {

	            stmt.setString(1, a.getDescricao());
	            stmt.setString(2, a.getTipo());
	            stmt.setInt(3, idOcorrencia);
	            
	            stmt.executeUpdate();

	            System.out.println("Apreensão salva!");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	  
}

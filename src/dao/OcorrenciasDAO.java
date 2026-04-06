package dao;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Apreensoes;
import model.Ocorrencias;

public class OcorrenciasDAO {
	

	public static int inserir(Ocorrencias o) {
	    int idGerado = 0;

	    String sql = "INSERT INTO ocorrencia (numeroOc, ano) VALUES (?, ?)";

	    try (Connection conn = ConnectDAO.connectDB();
	         PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

	        stmt.setInt(1, o.getNumeroOc());
	        stmt.setInt(2, o.getAno());

	        stmt.executeUpdate();

	        ResultSet rs = stmt.getGeneratedKeys();
	        if (rs.next()) {
	            idGerado = rs.getInt(1);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return idGerado;
	}

	public static List<Ocorrencias> listar() {
	    List<Ocorrencias> lista = new ArrayList<>();

	    String sql = "SELECT o.id, o.numeroOc, o.ano, a.descricao AS desc_apreensao, a.tipo AS tipo_apreensao " +
	             "FROM ocorrencia o " +
	             "INNER JOIN apreensao a ON o.id = a.ocorrencia_id";

	    try (Connection conn = ConnectDAO.connectDB();
	         PreparedStatement stmt = conn.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery()) {

	    	while (rs.next()) {
	    	    Ocorrencias o = new Ocorrencias();

	    	    o.setId(rs.getInt("id"));
	    	    o.setNumeroOc(rs.getInt("numeroOc"));
	    	    o.setAno(rs.getInt("ano"));

	    	    Apreensoes a = new Apreensoes();
	    	    a.setDescricao(rs.getString("desc_apreensao"));
	    	    a.setTipo(rs.getString("tipo_apreensao"));

	    	    
	    	    o.setApreensoes(a);

	    	    lista.add(o);
	    	}

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return lista;
	}
	
}

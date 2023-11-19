package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Aluno;
import model.Aquisicao;
import model.Evento;

public class AquisicaoDAO {
	
	//CREATE
	public void creat (Aquisicao aquisicao) {
		String sql = "insert into Aquisicao (data_Aquisicao, nome, id_Evento, id_Aluno) values (?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, aquisicao.getdata_Aquisicao());
			pstm.setString(2, aquisicao.getNome());
					
			pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			 try {
				
				 if (pstm !=null) {
					 pstm.close();
				
				 }
				 if (conn !=null) {
					 conn.close();
				 }
				 
				 }catch (Exception e) {
					 e.printStackTrace();
				 }
	}
		
	}

	//READ
		public List <Aquisicao> read(){
			List<Aquisicao> aquisicaos = new ArrayList<Aquisicao>();
			String sql = "select * from aquisicao";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Aquisicao aquisicao = new Aquisicao();
				Aluno aluno = new Aluno ();
				Evento evento = new Evento();
				aquisicao.setdata_Aquisicao (rset.getString("data_Aquisicao"));
				aquisicao.setNome(rset.getString("nome"));
				aluno.setCPF(rset.getString("CPF"));
				aluno.setEmail(rset.getString("email"));
				aluno.setSenha(rset.getString("senha"));
				aluno.setNome(rset.getString("nome"));
		        aquisicao.setAluno(aluno);
		        
		        evento.setId_Evento(rset.getInt("id_Evento"));
				evento.setdata_Evento(rset.getString("data_Evento"));
				evento.setnome(rset.getString("nome"));
	
				
	            aquisicao.setEvento(evento);

				
				 aquisicaos.add(aquisicao);
			}
		
	} catch (Exception e) {
		e.printStackTrace();
		
	}finally {
		 try {
			
			 if (pstm !=null) {
				 pstm.close();
			
			 }
			 if (conn !=null) {
				 conn.close();
			 }
			 
			 }catch (Exception e) {
				 e.printStackTrace();
			 }
}
		
		return aquisicaos;
	}
	
	//UPDATE
	public void update (Aquisicao aquisicao) {
		String sql = "UPDATE aquisicao SET data_Aquisicao = ?,  nome = ?, id_Evento = ?, id_Aluno = ? WHERE id_Aquisicao = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, aquisicao.getdata_Aquisicao());
			pstm.setString(2, aquisicao.getNome());
			
			pstm.setInt(5, aquisicao.getId_Aquisicao());
			
			pstm.execute();
		
	} catch (Exception e) {
		e.printStackTrace();
		
	}finally {
		 try {
			
			 if (pstm !=null) {
				 pstm.close();
			
			 }
			 if (conn !=null) {
				 conn.close();
			 }
			 
			 }catch (Exception e) {
				 e.printStackTrace();
			 }
}
	} 
	
	//DELETE
	public static void delete (int id_Aquisicao) {
	String sql = "DELETE FROM aquisicao WHERE id_Aquisicao = ?";
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	try {
		conn = ConnectionMySQL.createConnectionMySQL();
		
		pstm = conn.prepareStatement(sql);
		
		pstm.setInt(1, id_Aquisicao);
		
		pstm.execute();
	
	} catch (Exception e) {
		e.printStackTrace();
		
	}finally {
		 try {
			
			 if (pstm !=null) {
				 pstm.close();
			
			 }
			 if (conn !=null) {
				 conn.close();
			 }
			 
			 }catch (Exception e) {
				 e.printStackTrace();
			 
}
	}
	}
	//readById
	public Aquisicao readById (int id_Aquisicao) {
		Aquisicao aquisicao = new Aquisicao();
		String sql = "select * from aquisicao WHERE id_Aquisicao= ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id_Aquisicao);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			
			Aluno aluno = new Aluno ();
			Evento evento = new Evento();
			aquisicao.setdata_Aquisicao (rset.getString("data_Aquisicao"));
			aquisicao.setNome (rset.getString("nome"));
			aluno.setCPF(rset.getString("CPF"));
			aluno.setEmail(rset.getString("email"));
			aluno.setSenha(rset.getString("senha"));
			aluno.setNome(rset.getString("nome"));
	        
			aquisicao.setAluno(aluno);
	        
	        evento.setId_Evento(rset.getInt("id_Evento"));
			evento.setdata_Evento(rset.getString("data_Evento"));
			evento.setnome(rset.getString("nome"));

			
            aquisicao.setEvento(evento);

		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			
			try {
				 if (pstm !=null) {
					 pstm.close();
				
				 }
				 if (conn !=null) {
					 conn.close();
				 }
				 
				 }catch (Exception e) {
					 e.printStackTrace();
				 }
	    }
		return aquisicao;
		}
	}


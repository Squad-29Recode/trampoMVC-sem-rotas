package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Aluno;
import model.Inscricao;
import model.Vaga;

public class InscricaoDAO {

	

	// create
	public void create(Inscricao inscricao) {

		String sql = "insert into Inscricao (data_Inscricao, nome, id_Aluno, id_Vaga) values (?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1,inscricao.getData_Inscricao());
			pstm.setString(2, inscricao.getNome());
			pstm.setInt(3, inscricao.getAluno().getId());
			pstm.setInt(4, inscricao.getvaga().getId_Vaga());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// read
	public List<Inscricao> read() {
		List<Inscricao> inscricaos = new ArrayList<Inscricao>();
		String sql = "select * from Inscricao";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Inscricao inscricao = new Inscricao();

				inscricao.setId_Inscricao(rset.getInt("id_Inscricao"));
				inscricao.setData_Inscricao(rset.getString("data_Inscricao"));
				inscricao.setNome(rset.getString("nome"));
				int id_Aluno = rset.getInt("id_Aluno");
				int id_Vaga = rset.getInt("id_Vaga");
				AlunoDAO alunodao = new AlunoDAO();
				Aluno aluno = alunodao.readById(id_Aluno);
				VagaDAO vagadao = new VagaDAO();
				Vaga vaga = vagadao.readById(id_Vaga);
				
				inscricao.setAluno(aluno);
				inscricao.setVaga(vaga);
				
				 inscricaos.add (inscricao); 
			}}
			catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return inscricaos;
	}

	// update
	public void update(Inscricao inscricao) {
		String sql = "UPDATE Inscricao SET data_Inscricao = ?, nome = ?, id_Aluno = ?, id_Vaga= ? WHERE id_Inscricao = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, inscricao.getData_Inscricao());
			pstm.setString(2, inscricao.getNome());
			pstm.setInt(3, inscricao.getAluno().getId());
			pstm.setInt(4, inscricao.getvaga().getId_Vaga());
            pstm.setInt(5, inscricao.getId_Inscricao());
			pstm.execute();
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// delete
	public void delete(int id) {
		String sql = "DELETE FROM Inscricao WHERE id_Inscricao = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// readById
	public Inscricao readById(int id_Inscricao) {
		Inscricao inscricao = new Inscricao();
		String sql = "select * from Inscricao WHERE id_Inscricao = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id_Inscricao);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			inscricao.setId_Inscricao(rset.getInt("id_Inscricao"));
			inscricao.setData_Inscricao(rset.getString("data_Inscricao"));
			inscricao.setNome(rset.getString("nome"));
			
			int id_Aluno = rset.getInt("id_Aluno");
		int id_Vaga = rset.getInt("id_Vaga");
			AlunoDAO alunodao = new AlunoDAO();
			Aluno aluno = alunodao.readById(id_Aluno);
			VagaDAO vagadao = new VagaDAO();
			Vaga vaga = vagadao.readById(id_Vaga);
			
		inscricao.setAluno(aluno);
		inscricao.setVaga(vaga);
					

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return inscricao;
	}

}
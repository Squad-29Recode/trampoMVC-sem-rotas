package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Vaga;

public class VagaDAO {

	// create
	public void create(Vaga vaga) {

		String sql = "insert into Vaga (data_Vaga, nome) values (?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, vaga.getdata_Vaga());
			pstm.setString(2, vaga.getNome());
			
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
	public List<Vaga> read() {
		List<Vaga> vagas = new ArrayList<Vaga>();
		String sql = "select * from vaga";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Vaga vaga = new Vaga();

				vaga.setId_Vaga(rset.getInt("id_Vaga"));
				vaga.setdata_Vaga(rset.getString("data_Vaga"));
				vaga.setNome(rset.getString("nome"));
				
				vagas.add(vaga);
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

		return vagas;
	}

	// update
	public void update(Vaga vaga) {
		String sql = "UPDATE Vaga SET data_Vaga = ?, nome= ? WHERE id_Vaga = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1,vaga.getdata_Vaga());
			pstm.setString(2, vaga.getNome());
			pstm.setInt(3, vaga.getId_Vaga());

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
		String sql = "DELETE FROM Vagas WHERE id_Vaga = ?";

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
	public Vaga readById(int id_Vaga) {
		Vaga vaga = new Vaga();
		String sql = "select * from Vaga WHERE id_Vaga = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id_Vaga);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			vaga.setId_Vaga(rset.getInt("id_Vaga"));
			vaga.setdata_Vaga(rset.getString("data_Vaga"));
			vaga.setNome(rset.getString("nome"));

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
		return vaga;
	}

}
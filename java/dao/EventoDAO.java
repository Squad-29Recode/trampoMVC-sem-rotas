package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Evento;

public class EventoDAO {

	// create
	public void create(Evento evento) {

		String sql = "insert into Evento (data_Evento, nome) values (?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, evento.getdata_Evento());
			pstm.setString(2, evento.getnome());
			
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
	public List<Evento> read() {
		List<Evento> eventos = new ArrayList<Evento>();
		String sql = "select * from evento";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Evento evento = new Evento();

				evento.setId_Evento(rset.getInt("id_Evento"));
				evento.setdata_Evento(rset.getString("data_Evento"));
				evento.setnome(rset.getString("nome"));
				
				 eventos.add (evento);
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

		return eventos;
	}

	// update
	public void update(Evento evento) {
		String sql = "UPDATE Evento SET data_Evento = ?, nome= ? WHERE id_Evento = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1,evento.getdata_Evento());
			pstm.setString(2, evento.getnome());
			pstm.setInt(3, evento.getId_Evento());

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
		String sql = "DELETE FROM Evento WHERE id_Evento = ?";

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
	public Evento readById(int id_Evento) {
		Evento evento = new Evento();
		String sql = "select * from Evento WHERE id_Evento= ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id_Evento);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			evento.setId_Evento(rset.getInt("id_Evento"));
			evento.setdata_Evento(rset.getString("data_Evento"));
			evento.setnome(rset.getString("nome"));

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
		return evento;
	}

}
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import to.AlunoTO;
import factory.ConnectionFactory;

/*
 * Descrição: Classe do tipo DAO (Data Transfer Object) para o caso de uso Manter Aluno.
 * 
 * 
 * */
public class AlunoDAO {

	// Método para inserir um novo registro na tabela
	public boolean alunoInsert(AlunoTO aluno) {

		boolean bRetorno = false;
		String sInsert = "";

		sInsert = "Insert Into Aluno(ALnome, ALendereco, ALtelefone, ALemail, ALrg, ALcpf, ALusuario ,ALD_E_L_E_T_) values (?,?,?,?,?,?,?,?)";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sInsert);) {

			stm.setString(1, aluno.getSnome());
			stm.setString(2, aluno.getsEnd());
			stm.setString(3, aluno.getsTel());
			stm.setString(4, aluno.getsMail());
			stm.setString(5, aluno.getsRg());
			stm.setString(6, aluno.getsCpf());
			stm.setString(7, aluno.getsUsuario());
			stm.setInt(8, aluno.getIdelete());

			stm.executeUpdate();

			bRetorno = true;

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return bRetorno;
	}

	// Método que altera um aluno
	public boolean alunoUpdate(AlunoTO aluno) {

		boolean bRetorno = false;
		String sUpdate = "";

		sUpdate = "Update Aluno set ALnome = ?, ALendereco = ?, ALtelefone = ?, ALemail = ?, ALrg = ? ";
		sUpdate += "Where Alcpf = ? ";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sUpdate);) {

			st.setString(1, aluno.getSnome());
			st.setString(2, aluno.getsEnd());
			st.setString(3, aluno.getsTel());
			st.setString(4, aluno.getsMail());
			st.setString(5, aluno.getsRg());
			st.setString(6, aluno.getsCpf());

			st.executeUpdate();

			bRetorno = true;
			st.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return bRetorno;

	}

	// Método que "inativa" um aluno
	public boolean alunoDelete(AlunoTO aluno) {

		boolean bRetorno = false;
		String sDelete = "";

		sDelete = "Update Aluno set ALd_e_l_e_t_ = 2 ";
		sDelete += "Where Alcpf = ? ";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sDelete);) {

			st.setString(1, aluno.getsCpf());
			st.executeUpdate();

			bRetorno = true;
			st.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return bRetorno;

	}

	// Método que retorna se há ou não cpf cadastrado no banco
	public String consultaCpf(AlunoTO aluno) {

		String sCpf = "";

		String sql = "Select ALcpf From Aluno ";
		sql += "Where ALD_e_l_e_t_ <> 2 ";
		sql += "And ALcpf = ?";

		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement st = conn.prepareStatement(sql);) {

			st.setString(1, aluno.getsCpf());

			ResultSet resultSet = st.executeQuery();

			if (resultSet.next()) {

				sCpf = resultSet.getString("ALcpf");

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return sCpf;

	}

	public AlunoTO consultar(AlunoTO aluno) {

		AlunoTO toRet = new AlunoTO();

		String sql = "Select * From Aluno ";
		sql += "Where ALD_e_l_e_t_ <> 2 ";
		sql += "And ALcpf = ?";

		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement st = conn.prepareStatement(sql);) {

			st.setString(1, aluno.getsCpf());

			ResultSet resultSet = st.executeQuery();

			// Se encontrou o aluno ...
			if (resultSet.next()) {

				toRet.setScpf(resultSet.getString("ALcpf"));
				toRet.setSnome(resultSet.getString("ALnome"));
				toRet.setsEnd(resultSet.getString("ALendereco"));
				toRet.setsTel(resultSet.getString("ALtelefone"));
				toRet.setsMail(resultSet.getString("ALemail"));
				toRet.setsRg(resultSet.getString("ALrg"));
				toRet.setsUsuario(resultSet.getString("ALusuario"));

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return toRet;

	}

	/*
	 * Método que retorna um ArrayList com todos os alunos ativos.
	 * 
	 */

	public ArrayList<AlunoTO> consultarTodos() {

		ArrayList<AlunoTO> retorno = new ArrayList<AlunoTO>();
		String sQuery = "";

		sQuery = "Select * From Aluno ";
		sQuery += "Where ALD_e_l_e_t_ <> 2 ";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sQuery);) {

			try (ResultSet resultSet = st.executeQuery();) {

				while (resultSet.next()) {
					
					AlunoTO aluno = new AlunoTO();

					aluno.setScpf(resultSet.getString("ALcpf"));
					aluno.setSnome(resultSet.getString("ALnome"));
					aluno.setsEnd(resultSet.getString("ALendereco"));
					aluno.setsTel(resultSet.getString("ALtelefone"));
					aluno.setsMail(resultSet.getString("ALemail"));
					aluno.setsRg(resultSet.getString("ALrg"));
					aluno.setsUsuario(resultSet.getString("ALusuario"));

					// Insere o objeto de memória no ArrayList
					retorno.add(aluno);

				}

			} catch (SQLException e1) {

				e1.printStackTrace();

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return retorno;

	}

}

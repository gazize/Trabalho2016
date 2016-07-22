package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import to.CursoTO;
import factory.ConnectionFactory;


/*
 * Descrição: Classe do tipo DAO (Data Transfer Object) para o caso de uso Manter Curso.
 * 
 * */
public class CursoDAO{
  
   //Método para inserir um novo registro na tabela
   public boolean cursoInsert(CursoTO curso){
      boolean bRetorno = false;
      String sInsert = "";
      
      sInsert  = "Insert Into Curso( " ;
      sInsert  += "CUCodigo, CUDescricao, CUDataInicio, CUDataFim, CUHorario, ";
      sInsert  += "CUNumVagas, CUArea ,CUValor, CUD_e_l_e_t_ ";
      sInsert  += ") " ;
      sInsert  += "values (?,?,?,?,?,?,?,?,?)" ;
      
      try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sInsert);) {
         
         st.setString(1, curso.getsCodigo()        );
         st.setString(2, curso.getsDescricao()     );
         st.setString(3, curso.getsDataInicio()    );
         st.setString(4, curso.getsDataFim()       );
         st.setString(5, curso.getsHorario()       );
         st.setInt   (6, curso.getiNumVagas()      );
         st.setString(7, curso.getsArea()          );
         st.setDouble(8, curso.getdValor()         );
         st.setInt   (9, curso.getIdelete()        );
         
         st.executeUpdate();
         
         bRetorno = true;
         
         st.close();
      
      }catch(SQLException e){
      
    	  e.printStackTrace();
      
      }
      
      return bRetorno;
   }
   
   //Método que altera um curso
   public boolean cursoUpdate(CursoTO curso){
      
      boolean bRetorno = false;
      String sUpdate = "";
      
      sUpdate  =  "Update Curso set CUDescricao = ?, CUDataInicio = ?, CUDataFim = ?, ";
      sUpdate  += " CUHorario = ?, CUNumVagas = ?, CUArea = ?, CUValor = ? ";
      sUpdate  += " Where CUCodigo = ? ";
      sUpdate  += " And CUD_e_l_e_t_ <> 2 ";
      
      
      try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sUpdate);) {
          
         st.setString (1, curso.getsDescricao()      );
         st.setString (2, curso.getsDataInicio()     );
         st.setString (3, curso.getsDataFim()        );
         st.setString (4, curso.getsHorario()        );
         st.setInt    (5, curso.getiNumVagas()       );
         st.setString (6, curso.getsArea()           );
         st.setDouble (7, curso.getdValor()          );
         st.setString (8, curso.getsCodigo()         );
         
         st.executeUpdate();
         
         bRetorno = true;
         st.close();
         
      }catch(SQLException e){
         
    	  e.printStackTrace();
      
      }
      
      return bRetorno;
      
   }
   
   //Método que "inativa" um curso
   public boolean cursoDelete(CursoTO curso){
      
      boolean bRetorno = false;
      String sDelete = "";
      
      sDelete   = "Update Curso set CUD_e_l_e_t_ = 2 ";
      sDelete  += "Where CUCodigo = ? ";
      
      try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sDelete);) {
        
    	 st.setString(1, curso.getsCodigo() );
         st.executeUpdate();
         
         bRetorno = true;
         st.close();
         
      }
      catch(SQLException e){
         
    	  e.printStackTrace();
      
      }
      
      return bRetorno;
      
   }

   //Método que retorna se há ou não curso cadastrado no banco
   public String consultaCurso(CursoTO curso){
   
	  String sRet = "";
      String sql  = "Select CUCodigo From Curso ";
      sql         += "Where CUD_e_l_e_t_ <> 2 ";
      sql         += "And CUCodigo = ?";
         
      
      try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sql);) {
          
         st.setString(1, curso.getsCodigo() );
         ResultSet resultSet = st.executeQuery();
         
         if(resultSet.next()){
            
        	 sRet = resultSet.getString("CUCodigo");
         
         }
         
      }
      catch(SQLException e){
    	  
         e.printStackTrace();
      
      }
      
      return sRet;
   
   }
   
   
   public boolean consultaExtraCurso(String sTipoCurso, CursoTO curso){
      
      boolean bTemCursoExtra = false;
      String sql  = "Select ";
      
      if(sTipoCurso == "1")  sql +=   "CUAMaterial  From CursoArtes       Where CUAD_e_l_e_t_ <> 2 And CUACodigoCurso = ? " ;
      else                   sql +=   "CUIRegistros From CursoInformatica Where CUID_e_l_e_t_ <> 2 And CUICodigoCurso = ? " ; 
      
      try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sql);) {
         
         st.setString(1, curso.getsCodigo() );
         ResultSet resultSet = st.executeQuery();
         
         if(resultSet.next()){
            bTemCursoExtra = true;
         }
         
         st.close(); 
      
      }
      catch(SQLException e){
         
    	  e.printStackTrace();
      
      }      
   
      return bTemCursoExtra;
   
   }
   
   public CursoTO consultar( CursoTO curso ){
	   
	   CursoTO toRet = new CursoTO();
	   
	   String sql  = "Select * From Curso ";
	      sql         += "Where CUD_e_l_e_t_ <> 2 ";
	      sql         += "And CUCodigo = ?";
	         
	      
	      try(Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement st = conn.prepareStatement(sql);) {
	          
	         st.setString(1, curso.getsCodigo() );
	         ResultSet resultSet = st.executeQuery();
	         
	         //Se tiver curso
	         if(resultSet.next()){
	 
	        	 toRet.setdValor( resultSet.getDouble("CUValor") );
	        	 toRet.setsCodigo( resultSet.getString("CUCodigo") );
	        	 toRet.setsDescricao( resultSet.getString("CUDescricao") ); 
	        	 toRet.setsDataInicio( resultSet.getString("CUDataInicio") );
	        	 toRet.setsDataFim( resultSet.getString("CUDataFim") );
	        	 toRet.setiNumVagas( resultSet.getInt("CUNumVagas") );
	        	 toRet.setsArea( resultSet.getString("CUArea") );
	        	 toRet.setsHorario( resultSet.getString("CUHorario") );
	         
	         }
	         
	      }
	      catch(SQLException e){
	    	  
	         e.printStackTrace();
	      
	      }

	   return toRet;
	   
   }
   
   
   public ArrayList<CursoTO> consultarTodos() {

		ArrayList<CursoTO> retorno = new ArrayList<CursoTO>();
		String sQuery = "";

		sQuery = "Select * From Curso ";
		sQuery += "Where CUD_e_l_e_t_ <> 2 ";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sQuery);) {

			ResultSet resultSet = st.executeQuery();

			while (resultSet.next()) {
				
				CursoTO curso = new CursoTO();

				curso.setdValor(resultSet.getDouble("CUValor"));
				curso.setsArea(resultSet.getString("CUArea"));
				curso.setiNumVagas(resultSet.getInt("CUNumVagas"));
				curso.setsHorario(resultSet.getString("CUHorario"));
				curso.setsDataInicio(resultSet.getString("CUDataInicio"));
				curso.setsDataFim(resultSet.getString("CUDataFim"));
				curso.setsDescricao(resultSet.getString("CUDescricao"));
				curso.setsCodigo(resultSet.getString("CUCodigo"));
				
				//Joga o objeto em memória no arraylist
				retorno.add(curso);
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return retorno;
	}
   
}

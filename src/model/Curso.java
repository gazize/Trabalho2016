package model;

import java.util.ArrayList;

import dao.CursoDAO;
import to.CursoTO;

/*
 * Classe com as regras de negócio para o caso de uso manter Curso
 * 
 * 
 * */
public class Curso {

	private String sCheat, sDesc, sDtIni, sDtFim, sHora, sNumberVagas, sValue, sArea;

	public Curso(String sCheat, String sDesc, String sDtIni, String sDtFim, String sHora, String sNumberVagas, String sValue, String sArea) {

		setsCheat(sCheat);
		setsDesc(sDesc);
		setsDtIni(sDtIni);
		setsDtFim(sDtFim);
		setsHora(sHora);
		setsNumberVagas(sNumberVagas);
		setsValue(sValue);
		setsArea(sArea);

	}

	public String getsArea() {
		return sArea;
	}

	public void setsArea(String sArea) {
		this.sArea = sArea;
	}

	public String getsCheat() {
		return sCheat;
	}

	public void setsCheat(String sCheat) {
		this.sCheat = sCheat;
	}

	public String getsDesc() {
		return sDesc;
	}

	public void setsDesc(String sDesc) {
		this.sDesc = sDesc;
	}

	public String getsDtIni() {
		return sDtIni;
	}

	public void setsDtIni(String sDtIni) {
		this.sDtIni = sDtIni;
	}

	public String getsDtFim() {
		return sDtFim;
	}

	public void setsDtFim(String sDtFim) {
		this.sDtFim = sDtFim;
	}

	public String getsHora() {
		return sHora;
	}

	public void setsHora(String sHora) {
		this.sHora = sHora;
	}

	public String getsNumberVagas() {
		return sNumberVagas;
	}

	public void setsNumberVagas(String sNumberVagas) {
		this.sNumberVagas = sNumberVagas;
	}

	public String getsValue() {
		return sValue;
	}

	public void setsValue(String sValue) {
		this.sValue = sValue;
	}

	public boolean incluir() {

		boolean bRet = false;
		CursoDAO cursoDAO = new CursoDAO();
		CursoTO cursoTO = new CursoTO();

		cursoTO.setsCodigo(getsCheat());
		cursoTO.setsDescricao(getsDesc());
		cursoTO.setsDataInicio(getsDtIni());
		cursoTO.setsDataFim(getsDtFim());
		cursoTO.setsHorario(getsHora());
		cursoTO.setsArea(getsArea());
		cursoTO.setIdelete(1);
		cursoTO.setiNumVagas(Integer.parseInt(getsNumberVagas()));
		cursoTO.setdValor(Double.parseDouble(getsValue()));

		if (cursoDAO.consultaCurso(cursoTO).equals("")) {
			
			cursoDAO.cursoInsert(cursoTO);
			bRet = true;
		
		}

		return bRet;
	}

	public boolean alterar() {

		boolean bRet = false;
		CursoDAO cursoDAO = new CursoDAO();
		CursoTO cursoTO = new CursoTO();

		cursoTO.setsDescricao(getsDesc());
		cursoTO.setsDataInicio(getsDtIni());
		cursoTO.setsDataFim(getsDtFim());
		cursoTO.setsHorario(getsHora());
		cursoTO.setiNumVagas(Integer.parseInt(getsNumberVagas()));
		cursoTO.setdValor(Double.parseDouble(getsValue()));
		cursoTO.setsArea(getsArea());
		cursoTO.setsCodigo(getsCheat());

		if (!cursoDAO.consultaCurso(cursoTO).equals("")) {

			cursoDAO.cursoUpdate(cursoTO);
			bRet = true;
		}

		return bRet;
	}

	public boolean excluir() {

		boolean bRet = false;
		CursoDAO cursoDAO = new CursoDAO();
		CursoTO cursoTO = new CursoTO();

		cursoTO.setsCodigo(getsCheat());

		if (!cursoDAO.consultaCurso(cursoTO).equals("")) {

			cursoDAO.cursoDelete(cursoTO);
			bRet = true;

		}

		return bRet;
	}

	public CursoTO consultar() {

		CursoDAO cursoDAO = new CursoDAO();
		CursoTO  toRet    = new CursoTO();
		CursoTO  cursoTO  = new CursoTO();
		
		cursoTO.setsCodigo( getsCheat() );

		toRet = cursoDAO.consultar(cursoTO);
		
		return toRet;
	
	}
	
	public ArrayList<CursoTO> consultarTodos(){
		
		ArrayList<CursoTO> retorno = new ArrayList<CursoTO>();
		CursoDAO dao	= new CursoDAO();
		
		retorno = dao.consultarTodos();
		
		return retorno;
	}
}

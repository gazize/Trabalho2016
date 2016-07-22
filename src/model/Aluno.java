package model;

import java.util.ArrayList;

import dao.AlunoDAO;
import to.AlunoTO;

/*
 * Classe com as regras de negócio para o caso de uso manter Aluno
 * 
 * 
 * */
public class Aluno {

	private String sNome, sEnd, sTel, sMail, sRg, sCpf, sLogin;

	public Aluno(String sNome, String sEnd, String sTel, String sMail, String sRg, String sCpf, String sLogin) {

		setsNome(sNome);
		setsEnd(sEnd);
		setsTel(sTel);
		setsMail(sMail);
		setsRg(sRg);
		setsCpf(sCpf);
		setsLogin(sLogin);

	}

	public String getsNome() {
		return sNome;
	}

	public void setsNome(String sNome) {
		this.sNome = sNome;
	}

	public String getsEnd() {
		return sEnd;
	}

	public void setsEnd(String sEnd) {
		this.sEnd = sEnd;
	}

	public String getsTel() {
		return sTel;
	}

	public void setsTel(String sTel) {
		this.sTel = sTel;
	}

	public String getsMail() {
		return sMail;
	}

	public void setsMail(String sMail) {
		this.sMail = sMail;
	}

	public String getsRg() {
		return sRg;
	}

	public void setsRg(String sRg) {
		this.sRg = sRg;
	}

	public String getsCpf() {
		return sCpf;
	}

	public void setsCpf(String sCpf) {
		this.sCpf = sCpf;
	}

	public String getsLogin() {
		return sLogin;
	}

	public void setsLogin(String sLogin) {
		this.sLogin = sLogin;
	}

	public boolean incluir() {

		// Declaração das variáveis.
		boolean bOk = false;
		AlunoDAO alunoDAO = new AlunoDAO();
		AlunoTO alunoTO = new AlunoTO();

		if (!existeCpfNoBanco(getsCpf())) {

			alunoTO.setsUsuario(getsLogin());
			alunoTO.setSnome(getsNome());
			alunoTO.setsEnd(getsEnd());
			alunoTO.setsTel(getsTel());
			alunoTO.setsMail(getsMail());
			alunoTO.setsRg(getsRg());
			alunoTO.setScpf(getsCpf());
			alunoTO.setsUsuario(getsLogin());
			alunoTO.setIdelete(1);

			// Efetua a inclusão no banco de dados
			alunoDAO.alunoInsert(alunoTO);

			bOk = true;

		}

		return bOk;
	}

	public boolean atualizar() {

		// Declaração das variáveis.
		boolean bRet = false;
		AlunoDAO alunoDAO = new AlunoDAO();
		AlunoTO alunoTO = new AlunoTO();

		if (existeCpfNoBanco(getsCpf())) {

			alunoTO.setSnome(getsNome());
			alunoTO.setsEnd(getsEnd());
			alunoTO.setsTel(getsTel());
			alunoTO.setsMail(getsMail());
			alunoTO.setsRg(getsRg());
			alunoTO.setsUsuario(getsLogin());
			alunoTO.setScpf(getsCpf());

			// Efetua a inclusão no banco de dados
			alunoDAO.alunoUpdate(alunoTO);

			bRet = true;

		}

		return bRet;

	}

	public boolean excluir() {

		boolean bRet = false;
		AlunoDAO alunoDAO = new AlunoDAO();
		AlunoTO alunoTO = new AlunoTO();

		if (existeCpfNoBanco(getsCpf())) {

			alunoTO.setScpf(getsCpf());
			alunoTO.setIdelete(2);
			alunoDAO.alunoDelete(alunoTO);
			
			bRet = true;
		
		}

		return bRet;

	}

	private boolean existeCpfNoBanco(String sCpf) {

		// Declaração das variáveis.
		boolean bExisteCpf = false;
		AlunoDAO alunoDAO = new AlunoDAO();
		AlunoTO alunoTO = new AlunoTO();
		String sCpfNoBanco = "";

		alunoTO.setScpf(sCpf);

		sCpfNoBanco = alunoDAO.consultaCpf(alunoTO);

		if (!sCpfNoBanco.equals(""))

			bExisteCpf = true;

		return bExisteCpf;

	}

	public AlunoTO consultar(){
		
		AlunoDAO alunoDAO = new AlunoDAO();
		AlunoTO alunoTO = new AlunoTO();
		
		alunoTO.setScpf(getsCpf());
		
		alunoTO = alunoDAO.consultar(alunoTO);
		
		return alunoTO;

	}
	
	public ArrayList<AlunoTO> consultarTodos(){
		
		AlunoDAO alunoDao = new AlunoDAO();
		ArrayList<AlunoTO> retorno = new ArrayList<AlunoTO>(); 
		
		retorno = alunoDao.consultarTodos();
		
		return retorno;
		
	}
}

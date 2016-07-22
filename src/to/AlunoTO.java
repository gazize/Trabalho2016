package to;

/*
 * Descrição: Classe do tipo TO (Transfer Object) para o caso de uso Manter Aluno.
 * 
 * 
 * */
public class AlunoTO {

	private String sNome, sEnd, sTel, sMail, sRg, sCpf, sUsuario;
	private int iDelete;

	// Método sets ...
	public void setSnome(String sNome) {
		this.sNome = sNome;
	}

	public void setsEnd(String sEnd) {
		this.sEnd = sEnd;
	}

	public void setsTel(String sTel) {
		this.sTel = sTel;
	}

	public void setsMail(String sMail) {
		this.sMail = sMail;
	}

	public void setsRg(String sRg) {
		this.sRg = sRg;
	}

	public void setScpf(String sCpf) {
		this.sCpf = sCpf;
	}

	public void setsUsuario(String sUsuario) {
		this.sUsuario = sUsuario;
	}

	public void setIdelete(int iDelete) {
		this.iDelete = iDelete;
	}

	// Método gets ...
	public String getSnome() {
		return this.sNome;
	}

	public String getsEnd() {
		return this.sEnd;
	}

	public String getsTel() {
		return this.sTel;
	}

	public String getsMail() {
		return this.sMail;
	}

	public String getsRg() {
		return this.sRg;
	}

	public String getsCpf() {
		return this.sCpf;
	}

	public String getsUsuario() {
		return this.sUsuario;
	}

	public int getIdelete() {
		return this.iDelete;
	}

}

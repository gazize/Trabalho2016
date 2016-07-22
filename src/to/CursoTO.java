package to;

public class CursoTO {

	private String sCodigo, sDescricao, sDataInicio, sDataFim, sHorario, sArea;
	private int iDelete, iNumVagas;
	private double dValor;

	// Método sets ...
	public void setsCodigo(String sCodigo) {
		this.sCodigo = sCodigo;
	}

	public void setsDescricao(String sDescricao) {
		this.sDescricao = sDescricao;
	}

	public void setsDataInicio(String sDataInicio) {
		this.sDataInicio = sDataInicio;
	}

	public void setsDataFim(String sDataFim) {
		this.sDataFim = sDataFim;
	}

	public void setsHorario(String sHorario) {
		this.sHorario = sHorario;
	}

	public void setsArea(String sArea) {
		this.sArea = sArea;
	}

	public void setIdelete(int iDelete) {
		this.iDelete = iDelete;
	}

	public void setiNumVagas(int iNumVagas) {
		this.iNumVagas = iNumVagas;
	}

	public void setdValor(double dValor) {
		this.dValor = dValor;
	}

	// Método gets ...
	public String getsCodigo() {
		return this.sCodigo;
	}

	public String getsDescricao() {
		return this.sDescricao;
	}

	public String getsDataInicio() {
		return this.sDataInicio;
	}

	public String getsDataFim() {
		return this.sDataFim;
	}

	public String getsHorario() {
		return this.sHorario;
	}

	public String getsArea() {
		return this.sArea;
	}

	public int getIdelete() {
		return this.iDelete;
	}

	public int getiNumVagas() {
		return this.iNumVagas;
	}

	public double getdValor() {
		return this.dValor;
	}

}

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Curso;
import to.CursoTO;

/**
 * Servlet implementation class ManterCursoController
 */
@WebServlet("/manter_curso.do")
public class ManterCursoController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Invoca o doPost
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sCodigo = request.getParameter("codigo");
		String sDesc = request.getParameter("desc");
		String sDtIni = request.getParameter("dtIni");
		String sDtFim = request.getParameter("dtFim");
		String sHora = request.getParameter("hora");
		String sNumVagas = request.getParameter("numVagas");
		String sValor = request.getParameter("valor");
		String sArea = (request.getParameter("area").equals("Informatica") ? "1" : "2");
		String bAcao = request.getParameter("acao");
		ArrayList<CursoTO> lista = new ArrayList<CursoTO>(); 
		Curso curso = new Curso(sCodigo, sDesc, sDtIni, sDtFim, sHora, sNumVagas, sValor, sArea);

		CursoTO to = new CursoTO();

		if (!bAcao.equals("Consultar Todos")) {

			if (bAcao.equals("Inserir")) {
				curso.incluir();
			} else if (bAcao.equals("Excluir")) {
				curso.excluir();
			} else if (bAcao.equals("Alterar")) {
				curso.alterar();
			}

			to = curso.consultar();

			// Faz o retorno...
			request.setAttribute("curso", to);

			RequestDispatcher view = request.getRequestDispatcher("Curso.jsp");
			view.forward(request, response);

		} else {
			
			lista = curso.consultarTodos();
			
			request.setAttribute("cursoFull", lista);
			
			RequestDispatcher view = request.getRequestDispatcher("CursoGrid.jsp");
			view.forward(request, response);

		}
	}

}

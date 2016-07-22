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

import model.Aluno;
import model.Curso;
import to.AlunoTO;

/**
 * Servlet implementation class ManterAlunoController
 */
@WebServlet("/manter_aluno.do")
public class ManterAlunoController extends HttpServlet {
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

		String sNome = request.getParameter("nome");
		String sEnd = request.getParameter("end");
		String sTel = request.getParameter("tel");
		String sMail = request.getParameter("mail");
		String sRg = request.getParameter("rg");
		String sCpf = request.getParameter("cpf");
		String sLogin = request.getParameter("login");
		String bAcao = request.getParameter("acao");
		AlunoTO to = new AlunoTO();
		ArrayList<AlunoTO> retorno = new ArrayList<AlunoTO>();

		Aluno aluno = new Aluno(sNome, sEnd, sTel, sMail, sRg, sCpf, sLogin);

		if (!bAcao.equals("Consultar Todos")) {

			if (bAcao.equals("Inserir")) {
				aluno.incluir();
				to = aluno.consultar();
			}

			if (bAcao.equals("Excluir")) {
				aluno.excluir();
				to = aluno.consultar();
			}

			if (bAcao.equals("Alterar")) {
				aluno.atualizar();
				to = aluno.consultar();
			}

			if (bAcao.equals("Carregar")) {
				to = aluno.consultar();
			}

			// Faz o retorno...
			request.setAttribute("aluno", to);

			RequestDispatcher view = request.getRequestDispatcher("Aluno.jsp");
			view.forward(request, response);

		} else {

			retorno = aluno.consultarTodos();
			
			request.setAttribute("alunoFull", retorno);
			
			RequestDispatcher view = request.getRequestDispatcher("AlunoGrid.jsp");
			view.forward(request, response);

		}
	}
}

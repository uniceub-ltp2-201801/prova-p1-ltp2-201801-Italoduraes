package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletIncluirDisciplina
 */
@WebServlet("/incluirDisciplina")
public class ServletIncluirDisciplina extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletIncluirDisciplina() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Listar disciplina</title></head><body>");

		String nome = request.getParameter("nome");
		String curso = request.getParameter("curso");
		String cargahoraria= request.getParameter("cargahoraria");
		String idProfessor= request.getParameter("idProfessor");
		
		String query= "INSERT INTO disciplina ( nome, curso, cargahoraria, idProfessor) VALUES (' " + nome + "','" + curso + "','" + cargahoraria + "','" + idProfessor +"')"; 
		
		
		//conectar no banco de dados
		
		try {
			//referenciar o driver JDBC
			Class.forName("com.mysql.jdbc.Driver");
			
			//Criar strings de conexão
			String url= "jdbc:mysql://localhost/faculdade";
			String username ="root";
			String password = "root";
			
			// Realizar conexao com o BD
			Connection conexao = DriverManager.getConnection(url, username , password);
			
			
			// Preparar o SQL para envio ao BD
			PreparedStatement st= conexao.prepareStatement(query);
			
			st.executeUpdate(query);
			
			out.print("A disciplina foi add com sucesso<br/><a href=\"professores\" >voltar</a>");
			
		} catch (Exception e) {
			// Mostra o erro
			e.printStackTrace();
		}
		

		
		//fechar o hmtl
		out.println("</body></html>");
		}
	
}

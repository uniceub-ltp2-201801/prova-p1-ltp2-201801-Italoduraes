package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/professores")
public class ServletProfessores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProfessores() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// obter objeto de resposta 
		PrintWriter out = response.getWriter();
		
		// começar objeto HTML
		out.println("<html><head><title>listagem dos professores</title></head>");
		out.println("<body>");
		
		ArrayList<String> professores = new ArrayList<String>();
		
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
			
			//Criando o SQL - jeito melhor 
			String sql= "SELECT * FROM faculdade.professor; ";
			
			// Preparar o SQL para envio ao BD
			PreparedStatement ps= conexao.prepareStatement(sql);
			
			// Executando o SQL
			ResultSet rs= ps.executeQuery();
			
			//verificar se usuario e senha estao corretos
			
			while(rs.next()) {
				String nome = rs.getString("nome");
				int idProfessor = rs.getInt("idProfessor");
				
				out.print(idProfessor + ". " + "<a href=\"DetalhesProfessor?id="+ idProfessor+ "\">"  + nome + "</a> " + "<br/><br/>"); 
			}
			out.print("<a href=\"incluirDisciplina.html\">ADD disciplina</a><br/><br/>");
			out.println("<a href=\"excluirDisciplina.html?id=" + "\"> Excluir</a><br/>");
			
			// fechar o ResultSet
			rs.close();
			//fechar o PrepareStatemnt
			ps.close();
			//fehcar o connection
			conexao.close();
		} catch (ClassNotFoundException | SQLException e) {
			// Mostra o erro
			e.printStackTrace();
		}
		
		//fechar o hmtl
		out.println("</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

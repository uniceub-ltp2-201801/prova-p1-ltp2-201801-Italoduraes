package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDetalheProf
 */
@WebServlet("/DetalhesProfessor")
public class ServletDetalheProf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDetalheProf() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperar parametros
				String id = request.getParameter("id");
				String idd = request.getParameter("idd");
				//obter objeto de resposta
				PrintWriter out = response.getWriter();
				
				//conectar ao banco de dados
				
				//começar a montar HTML
						out.println("<html><head><title>Professor</title></head>");
						out.println("<body>");
				
						try {
							//referenciar o driver JDBC
							Class.forName("com.mysql.jdbc.Driver");
							
							//Criar String de conexao
							String url = "jdbc:mysql://localhost/faculdade";
							String username = "root";
							String password = "root";
							
							//Realizar conexao com o BD
							Connection conexao = DriverManager.getConnection(url, username, password);
							
							
							//Criando SQL - Jeito MELHOR
						
							String sql = "select * from professor where idProfessor=" + id;
							String sq = "select * from disciplina where idProfessor=" + idd;
							
							//preparar o SQL para envio ao DB
							PreparedStatement ps = conexao.prepareStatement(sql);
							PreparedStatement pss = conexao.prepareStatement(sq);
							
							//Executando SQL
							ResultSet rs = ps.executeQuery();
							ResultSet rss = pss.executeQuery();
							
							//verificar se usuario e senha estao corretos
							while (rs.next()) {
								
								int idProfessor = rs.getInt("idProfessor");
								String nome = rs.getString("nome");
								String datanasc = rs.getString("datanasc");
								String nomemae = rs.getString("nomemae");
								int titulacao = rs.getInt("titulacao");
								
								
								out.print( "nome do professor: " + nome + "<br/>" + "nome da mãe: " + nomemae + "<br/>" + 
								"data de nascimento: " + datanasc + "<br/>" + "Titulação: " + titulacao + "<br/>" + "<br/>");
	
								}
						while(rss.next()) {
							int idProfessor = rs.getInt("idProfessor");
							int idProfessores = rss.getInt("idProfessor");
							String nome = rss.getString("nome");
							String curso = rss.getString("curso");
							String cargahoraria = rss.getString("cargahoraria");
				
							if(idProfessor==idProfessores){
								out.println("nome da disciplina: " + nome + "<br/>" + "curso: " + curso + "<br/>" + 
										"carga horaria: " + cargahoraria + "<br/>" );
							}
						}
														
							//fechar ResultSet
							rs.close();
							rss.close();
							//fechar o PrepareStatment
							ps.close();
							pss.close();
							//fechar o Connection
							conexao.close();
							
						} catch (ClassNotFoundException | SQLException e) {
							//mostrar o erro
							e.printStackTrace();
						}
						
						//fechar o HTML
						out.println("</body></html>");
	}

}

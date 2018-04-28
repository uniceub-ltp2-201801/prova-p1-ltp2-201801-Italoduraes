package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletExcluirDisciplina
 */
@WebServlet("/excluirDisciplina")
public class ServletExcluirDisciplina extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletExcluirDisciplina() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		PrintWriter out = response.getWriter();
		out.println("<html><head><title>excluir disciplina</title></head><body>");

		String nome = request.getParameter("nome");
		String iddisciplina = request.getParameter("iddisciplina");
		
		
		String sql= "DELETE INTO disciplina ( nome, id) VALUES (' " + nome + "','" + iddisciplina + "')"; 
		
		
		/*//recuperar parametros
				String id = request.getParameter("id");
			String nome = request.getParameter("nome");*/

			
				
				//conectar ao banco de dados
				
				//começar a montar HTML
						out.println("<html><head><title>Disciplina escluida</title></head>");
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
					//String sql = "select * from produto";
					String sqls = "delete from disciplina where iddisciplina=" + iddisciplina;
					
					//preparar o SQL para envio ao DB
					PreparedStatement ps = conexao.prepareStatement(sql);
					
					
					
					//Executando SQL
					 ps.executeUpdate(sql);
					
					 out.print("Disciplina " + nome +  " Excluido com sucesso " );
				
					
					
					//fechar o PrepareStatment
					ps.close();
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

	

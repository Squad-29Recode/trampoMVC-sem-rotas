package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlunoDAO;
import dao.CursoDAO;
import dao.EscolhaDAO;
import model.Aluno;
import model.Curso;
import model.Escolha;

@WebServlet(urlPatterns = {"/escolha", "/escolha-save", "/escolha-delete", "/escolha-edit"})
public class EscolhaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    Aluno aluno = new Aluno();
    AlunoDAO adao = new AlunoDAO();
    EscolhaDAO esdao = new EscolhaDAO();
    CursoDAO cdao = new CursoDAO();
    Curso curso = new Curso();

    public EscolhaServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
List<Curso> curso = cdao.read();
request.setAttribute("listaCurso", curso);
List <Aluno> aluno = adao.read();
request.setAttribute("listaAluno", aluno);      

String route = request.getServletPath();
        switch (route) {
               
        case "/aquisicao":
            read(request,response);
            break;
        case "/aquisicao-save":
            save(request,response);
            break;
        case "/aquisicao-delete":
            delete(request,response);
            break;
        case "/aquisicao-edit":
			edit(request, response);
			break;
		             
            default:        	    	
  response.sendRedirect("/index.html");
            break;
        }
    }
    protected void aquisicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher rd=request.getRequestDispatcher("./escolha.jsp");
        rd.forward(request, response);
    
    }
        protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        	Escolha escolha = new Escolha();
            int idaluno = Integer.parseInt(request.getParameter("aluno")); 
            int idCurso = Integer.parseInt(request.getParameter("curso"));
            escolha.setAluno(adao.readById(idaluno));  
            escolha.setCurso(cdao.readById(idCurso));              
           
            
            escolha.setData_Escolha(request.getParameter("data_Escolha"));
            escolha.setNome(request.getParameter("nome"));
            
            if(request.getParameter("id")!=null){
            	escolha.setId(Integer.parseInt(request.getParameter("id")));
                esdao.update(escolha);

            }else {
                esdao.create(escolha);
            }
            response.sendRedirect("escolha");

        }

        protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            List<Escolha>escolha = esdao.read();
            request.setAttribute("escolha", escolha);
            RequestDispatcher rd=request.getRequestDispatcher("./escolha.jsp");
            rd.forward(request, response);
            }

        protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            int id = Integer.parseInt(request.getParameter("id"));
            esdao.delete(id);// mudou de aqdao para...
            response.sendRedirect("./escolha");
            
    }
        protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		int id = Integer.parseInt(request.getParameter("id"));
    		
    		Escolha escolha = esdao.readById(id);
    		
    		request.setAttribute("escolha", escolha);

    		RequestDispatcher rd = request.getRequestDispatcher("./editescolha.jsp");
    		rd.forward(request, response);
    	
    	    	
    	}
    	
    	}

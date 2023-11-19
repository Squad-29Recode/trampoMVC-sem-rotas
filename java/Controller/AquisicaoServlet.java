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
import dao.AquisicaoDAO;
import dao.EventoDAO;
import model.Aluno;
import model.Aquisicao;
import model.Evento;

@WebServlet(urlPatterns = {"/aquisicao", "/aquisicao-save", "/aquisicao-delete", "/aquisicao-edit"})
public class AquisicaoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    Aluno aluno = new Aluno();
    AlunoDAO adao = new AlunoDAO();
    AquisicaoDAO aqdao = new AquisicaoDAO();
    EventoDAO edao = new EventoDAO();
    Evento evento = new Evento();

    public AquisicaoServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
List <Evento> evento = edao.read();
request.setAttribute("listaEvento", evento);
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
  response.sendRedirect("/.html");
            break;
        }
    }
    protected void aquisicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher rd=request.getRequestDispatcher("./aquisicao.jsp");
        rd.forward(request, response);
    
    }
        protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        	Aquisicao aquisicao = new Aquisicao();
        	int idaluno = Integer.parseInt(request.getParameter("aluno")); 
            int idevento = Integer.parseInt(request.getParameter("evento"));
            aquisicao.setAluno(adao.readById(idaluno));  
            aquisicao.setEvento(edao.readById(idevento));              
           
            
            aquisicao.setdata_Aquisicao(request.getParameter("data_aquisicao"));
            aquisicao.setNome(request.getParameter("nome"));
            
            if(request.getParameter("id")!=null){
            	aquisicao.setId_Aquisicao(Integer.parseInt(request.getParameter("id_Aquisicao")));
                aqdao.update(aquisicao);

            }else {
                aqdao.creat(aquisicao);
            }
            response.sendRedirect("aquisicao");

        }

        protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            List<Aquisicao>aquisicao = aqdao.read();
            request.setAttribute("aquisicao", aquisicao);
            RequestDispatcher rd=request.getRequestDispatcher("./aquisicao.jsp");
            rd.forward(request, response);
            }

        protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            int id = Integer.parseInt(request.getParameter("id"));
            AquisicaoDAO.delete(id);
            response.sendRedirect("./aquisicao");
            
    }
        protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		int id = Integer.parseInt(request.getParameter("id"));
    		
    		Aquisicao aquisicao = aqdao.readById(id);
    		
    		request.setAttribute("aquisicao", aquisicao);

    		RequestDispatcher rd = request.getRequestDispatcher("./editAquisicao.jsp");
    		rd.forward(request, response);
    	
    	    	
    	}
    	
    	}

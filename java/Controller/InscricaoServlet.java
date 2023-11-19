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
import dao.InscricaoDAO;
import dao.VagaDAO;
import model.Aluno;
import model.Inscricao;
import model.Vaga;

@WebServlet(urlPatterns = {"/inscricao", "/inscricao-save", "/inscricao-delete", "/inscricao-edit"})
public class InscricaoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    Aluno aluno = new Aluno();
    AlunoDAO adao = new AlunoDAO();
    InscricaoDAO idao = new InscricaoDAO();
    VagaDAO vdao = new VagaDAO();
    Vaga vaga = new Vaga();

    public InscricaoServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
List<Vaga> vaga = vdao.read();
request.setAttribute("listaVaga", vaga);
List <Aluno> aluno = adao.read();
request.setAttribute("listaAluno", aluno);      

String route = request.getServletPath();
        switch (route) {
               
        case "/inscricao":
            read(request,response);
            break;
        case "/inscricao-save":
            save(request,response);
            break;
        case "/inscricao-delete":
            delete(request,response);
            break;
        case "/inscricao-edit":
			edit(request, response);
			break;
		             
            default:        	    	
  response.sendRedirect("/index.html");
            break;
        }
    }
    protected void aquisicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher rd=request.getRequestDispatcher("./inscricao.jsp");
        rd.forward(request, response);
    
    }
        protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        	Inscricao inscricao = new Inscricao();
            int idaluno = Integer.parseInt(request.getParameter("aluno")); 
            int idvaga = Integer.parseInt(request.getParameter("vaga"));
            inscricao.setAluno(adao.readById(idaluno));  
            inscricao.setVaga(vdao.readById(idvaga));              
           
            
            inscricao.setData_Inscricao(request.getParameter("data_Inscricao"));
            inscricao.setNome(request.getParameter("nome"));
            
            if(request.getParameter("id")!=null){
            	inscricao.setId_Inscricao(Integer.parseInt(request.getParameter("id")));
                idao.update(inscricao);

            }else {
                idao.create(inscricao);
            }
            response.sendRedirect("inscricao");

        }

        protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            List<Inscricao>inscricao = idao.read();
            request.setAttribute("inscricao", inscricao);
            RequestDispatcher rd=request.getRequestDispatcher("./inscricao.jsp");
            rd.forward(request, response);
            }

        protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            int id = Integer.parseInt(request.getParameter("id"));
            idao.delete(id);// mudou de aqdao para...
            response.sendRedirect("./inscricao");
            
    }
        protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		int id = Integer.parseInt(request.getParameter("id"));
    		
    		Inscricao inscricao = idao.readById(id);
    		
    		request.setAttribute("inscricao", inscricao);

    		RequestDispatcher rd = request.getRequestDispatcher("./editinscricao.jsp");
    		rd.forward(request, response);
    	
    	    	
    	}
    	
    	}

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
import model.Aluno;

@WebServlet(urlPatterns = {"/aluno", "/aluno-save", "/aluno-delete", "/aluno-edit", "/aluno-update"})
public class AlunoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	AlunoDAO adao = new AlunoDAO();


	private Aluno aluno;

    public AlunoServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String route = request.getServletPath();
        switch (route) {
        case "/aluno":
            read(request,response);
            break;
        case "/aluno-save":
            save(request,response);
            break;
        case "/aluno-delete":
            delete(request,response);
            break;
       case "/aluno-edit":
			edit(request, response);
			break;
		case "/aluno-update":
			update(request, response);
			break;
        default:

            break;
        }

    }
 
    protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Aluno aluno = new Aluno();
        aluno.setCPF(request.getParameter("CPF"));
        aluno.setEmail(request.getParameter("email"));
        aluno.setNome(request.getParameter("nome"));
        aluno.setSenha(request.getParameter("senha"));
        
        if(request.getParameter("id")!=null){
        	aluno.setId(Integer.parseInt(request.getParameter("id")));
            adao.update(aluno);

        }else {
            adao.create(aluno);
        }
        response.sendRedirect("aluno");
    }
    protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Aluno>aluno = adao.read();
        request.setAttribute("aluno", aluno);
        RequestDispatcher rd=request.getRequestDispatcher("/views/aluno/aluno.jsp");
        rd.forward(request, response);
        }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        adao.delete(id);
        response.sendRedirect("aluno");
    }


	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Aluno aluno = adao.readById(id);
		
		request.setAttribute("aluno", aluno);

		RequestDispatcher rd = request.getRequestDispatcher("/views/aluno/editAluno.jsp");
		rd.forward(request, response);
	
	}
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		aluno = null;
		aluno.setId(Integer.parseInt(request.getParameter("id_Aluno"))); // estava só ID
		aluno.setCPF(request.getParameter("CPF"));
		aluno.setNome(request.getParameter("nome"));
		aluno.setEmail(request.getParameter("email"));
		aluno.setSenha(request.getParameter("senha"));
		
		adao.update(aluno);
		response.sendRedirect("aluno");
	}
	
	}

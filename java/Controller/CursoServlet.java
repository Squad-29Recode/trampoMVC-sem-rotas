package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CursoDAO;
import model.Curso;

@WebServlet(urlPatterns = {"/curso", "/curso-save", "/curso-delete", "/curso-edit", "/curso-update"})
public class CursoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	CursoDAO cdao = new CursoDAO();


	private Curso curso;

    public CursoServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String route = request.getServletPath();
        switch (route) {
        case "/curso":
            read(request,response);
            break;
        case "/curso-save":
            save(request,response);
            break;
        case "/curso-delete":
            delete(request,response);
            break;
       case "/curso-edit":
			edit(request, response);
			break;
		case "/curso-update":
			update(request, response);
			break;
        default:

            break;
        }

    }
 
    protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	Curso curso = new Curso();
    	curso.setCurso(request.getParameter("curso"));
    	curso.setData_Curso(request.getParameter("data"));
    	
        
        if(request.getParameter("id")!=null){
        	curso.setId(Integer.parseInt(request.getParameter("id")));
            cdao.update(curso);

        }else {
            cdao.create(curso);
        }
        response.sendRedirect("aluno");
    }
    protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Curso>curso = cdao.read();
        request.setAttribute("curso", curso);
        RequestDispatcher rd=request.getRequestDispatcher("./curso.jsp");
        rd.forward(request, response);
        }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        cdao.delete(id);
        response.sendRedirect("curso");
    }


	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Curso curso = cdao.readById(id);
		
		request.setAttribute("curso", curso);

		RequestDispatcher rd = request.getRequestDispatcher("./editCurso.jsp");
		rd.forward(request, response);
	
	}
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		curso = null;
		curso.setId(Integer.parseInt(request.getParameter("id")));
		curso.setCurso(request.getParameter("curso"));
		curso.setData_Curso(request.getParameter("data"));
		
		cdao.update(curso);
		response.sendRedirect("curso");
	}
	
	}

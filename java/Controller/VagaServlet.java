package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VagaDAO;
import model.Vaga;

@WebServlet(urlPatterns = {"/vaga", "/vaga-save", "/vaga-delete", "/vaga-edit", "/vaga-update"})
public class VagaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	VagaDAO vdao = new VagaDAO();


	private Vaga vaga;

    public VagaServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String route = request.getServletPath();
        switch (route) {
        case "/vaga":
            read(request,response);
            break;
        case "/vaga-save":
            save(request,response);
            break;
        case "/vaga-delete":
            delete(request,response);
            break;
       case "/vaga-edit":
			edit(request, response);
			break;
		case "/vaga-update":
			update(request, response);
			break;
        default:

            break;
        }

    }
 
    protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	Vaga vaga = new Vaga();
        vaga.setdata_Vaga(request.getParameter("data_Vaga"));
        vaga.setNome(request.getParameter("nome"));
        
        if(request.getParameter("id")!=null){
        	vaga.setId_Vaga(Integer.parseInt(request.getParameter("id")));
            vdao.update(vaga);

        }else {
            vdao.create(vaga);
        }
        response.sendRedirect("vaga");
    }
    protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Vaga>vaga = vdao.read();
        request.setAttribute("vaga", vaga);
        RequestDispatcher rd=request.getRequestDispatcher("./vaga.jsp");
        rd.forward(request, response);
        }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        vdao.delete(id);
        response.sendRedirect("vaga");
    }


	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Vaga vaga = vdao.readById(id);
		
		request.setAttribute("vaga", vaga);

		RequestDispatcher rd = request.getRequestDispatcher("./editVaga.jsp");
		rd.forward(request, response);
	
	}
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		vaga = null;
		vaga.setId_Vaga(Integer.parseInt(request.getParameter("id")));
		vaga.setdata_Vaga(request.getParameter("data"));
		vaga.setNome(request.getParameter("nome"));
		
		vdao.update(vaga);
		response.sendRedirect("vaga");
	}
	
	}

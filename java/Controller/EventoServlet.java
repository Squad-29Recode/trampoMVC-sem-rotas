package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EventoDAO;
import model.Evento;

@WebServlet(urlPatterns = {"/evento", "/evento-save", "/evento-delete", "/evento-edit", "/evento-update"})
public class EventoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	EventoDAO edao = new EventoDAO();


	private Evento evento;

    public EventoServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String route = request.getServletPath();
        switch (route) {
        case "/evento":
            read(request,response);
            break;
        case "/evento-save":
            save(request,response);
            break;
        case "/evento-delete":
            delete(request,response);
            break;
       case "/evento-edit":
			edit(request, response);
			break;
		case "/evento-update":
			update(request, response);
			break;
        default:

            break;
        }

    }
 
    protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	Evento evento = new Evento ();
    	evento.setdata_Evento(request.getParameter("data_Evento"));
    	evento.setnome(request.getParameter("nome"));
        
        if(request.getParameter("id")!=null){
        	evento.setId_Evento(Integer.parseInt(request.getParameter("id")));
            edao.update(evento);

        }else {
            edao.create(evento);
        }
        response.sendRedirect("evento");
    }
    protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Evento>evento = edao.read();
        request.setAttribute("evento", evento);
        RequestDispatcher rd=request.getRequestDispatcher("./evento.jsp");
        rd.forward(request, response);
        }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        edao.delete(id);
        response.sendRedirect("evento");
    }


	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Evento evento = edao.readById(id);
		
		request.setAttribute("evento", evento);

		RequestDispatcher rd = request.getRequestDispatcher("./editEvento.jsp");
		rd.forward(request, response);
	
	}
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		evento = null;
		evento.setId_Evento(Integer.parseInt(request.getParameter("id")));
		evento.setdata_Evento(request.getParameter("data"));
		evento.setnome(request.getParameter("nome"));
		
		edao.update(evento);
		response.sendRedirect("evento");
	}
	
	}

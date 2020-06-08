package ups.edu.ec.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ups.edu.ec.modelo.Pedido;

/**
 * Servlet implementation class CreacionLista
 */
@WebServlet("/CreacionLista")
public class CreacionLista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreacionLista() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcion = request.getParameter("op");
		System.out.print(opcion);
		String criterio = request.getParameter("caja");
		System.out.print(criterio);
		PedidoDAO pedidoDAO = DAOFactory.getFactory().getPedidoDAO();
		ComidaDAO comidaDAO = DAOFactory.getFactory().getComidaDAO();
		
		
		List<Pedido> pedidos =null;
		
		if (opcion.equals("porNombreComida")) {
		    pedidos = pedidoDAO.findByComida(criterio);
			System.out.print("df");
			request.setAttribute("pedidos", pedidos);
			request.getRequestDispatcher("/JSPs/listar.jsp").forward(request,  response);
			
		} else if (opcion.equals("porNumeroTarjeta")) {
			pedidos = pedidoDAO.findByNumTar(criterio);
			request.setAttribute("pedidos", pedidos);	
			System.out.print(pedidos);
			request.getRequestDispatcher("/JSPs/listar.jsp").forward(request,  response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

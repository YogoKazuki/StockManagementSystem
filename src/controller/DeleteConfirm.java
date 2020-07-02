package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeleteConfirm
 */
@WebServlet("/DeleteConfirm")
public class DeleteConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteConfirm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		try {
			HttpSession session = request.getSession();

			DTO dto = new DTO();
			dto = DAO.getInstance().IDsearch(request.getParameter("itemID"));
			session.setAttribute("deleteitem", dto);
			request.getRequestDispatcher("/deleteconfirm.jsp").forward(request, response);
		}catch(NullPointerException ne) {
			request.setAttribute("error",ne.getMessage() );
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}catch(SQLException se) {
			request.setAttribute("error",se.getMessage() );
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}catch(NumberFormatException ne) {
			request.setAttribute("error",ne.getMessage() );
			request.getRequestDispatcher("/error.jsp").forward(request, response);
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

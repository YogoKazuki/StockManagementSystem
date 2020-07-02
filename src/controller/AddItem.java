package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Additem
 */
@WebServlet("/AddItem")
public class AddItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItem() {
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

			DTO dto = new DTO();
			if(request.getParameter("name").equals("")) {
				throw new Exception("名前を入力してください");
			}else {
				dto.setName(request.getParameter("name"));
			}
			if(request.getParameter("number").equals("")) {
				dto.setNumber(0);
			}else {
				dto.setNumber(Integer.parseInt(request.getParameter("number")));
			}
			DAO.getInstance().itemInsert(dto);
			request.getRequestDispatcher("Rogincheck").forward(request, response);
		}catch(NullPointerException ne) {
			request.setAttribute("error",ne.getMessage() );
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}catch(SQLException se) {
			request.setAttribute("error",se.getMessage() );
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}catch(NumberFormatException ne) {

			request.setAttribute("error","個数の欄には数字を入力してください" );
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}catch(Exception e) {
			request.setAttribute("error",e.getMessage() );
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

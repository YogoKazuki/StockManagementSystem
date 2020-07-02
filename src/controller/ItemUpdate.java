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
 * Servlet implementation class ItemUpdate
 */
@WebServlet("/ItemUpdate")
public class ItemUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		try{
			HttpSession session = request.getSession();
			DTO dto = new DTO();

//			製品一覧ページから飛んできたIDを更新から
//			戻ってきたときに簡単に取り出せるようにsessionに格納しておく
			session.setAttribute("itemID",request.getParameter("itemID"));
			String itemID = session.getAttribute("itemID").toString();
			dto = DAO.getInstance().IDsearch(itemID);
			request.setAttribute("oneitem", dto);
			request.getRequestDispatcher("/itemupdate.jsp").forward(request, response);
		}catch(NullPointerException ne) {
			request.setAttribute("error",ne.getMessage() );
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}catch(SQLException se) {
			request.setAttribute("error",se.getMessage() );
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

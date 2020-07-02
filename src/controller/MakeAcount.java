package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class MakeAcount
 */
@WebServlet("/MakeAcount")
public class MakeAcount extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeAcount() {
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
//			半角大文字、小文字の英数字とハイフンのみでしか
//			IDとパスワードを作れないようにしました
			boolean b = Pattern.matches("^[a-zA-Z0-9\\-]{6,12}$", request.getParameter("userID"));
			boolean p = Pattern.matches("^[a-zA-Z0-9\\-]{6,12}$", request.getParameter("password"));
			if(b==true&&p==true) {
				dto.setName(request.getParameter("name"));
				dto.setUserID(request.getParameter("userID"));
				dto.setPassword(request.getParameter("password"));
				DAO.getInstance().makeAcount(dto);
				System.out.print("アカウントを作成しました");
				request.setAttribute("name", dto.getName());
				request.getRequestDispatcher("/makeacountresult.jsp").forward(request, response);
			}else{
				request.setAttribute("name", request.getParameter("name"));
				request.setAttribute("userID",request.getParameter("userID"));
				request.setAttribute("false", "IDとパスワードは半角の英数字6～12文字で入力してください");
				request.getRequestDispatcher("/makeacount.jsp").forward(request, response);
		}
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

package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Rogincheck
 */
@WebServlet("/Rogincheck")
public class Rogincheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rogincheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		try {
//		ログインチェック用のセッション"check"がnoだった
//		場合はログインしていないのでログインチェックをする
		if(session.getAttribute("check")=="no") {
			DTO dto = new DTO();
			dto.setUserID(request.getParameter("userID"));
			dto.setPassword(request.getParameter("password"));

				if(DAO.getInstance().roginCheck(dto)==true) {
					System.out.print("ログインに成功しました");
					session.setAttribute("check", "ok");
				}else {
					System.out.print("ログインに失敗しました");
					request.setAttribute("roginfalse", "false");
					request.getRequestDispatcher("/toppage.jsp").forward(request, response);
				}
			}else if(session.getAttribute("check")=="null") {
				throw new Exception("不正なアクセスです");
			}

//		ログインに成功した時やAdditemなどから戻ってきたとき
//		はcheckがokなのでitemListを更新して在庫一覧画面へフォワード
			if (session.getAttribute("check")=="ok") {
			ArrayList<DTO> itemList = new ArrayList<DTO>(DAO.getInstance().allItems());
			session.setAttribute("itemlist",itemList);
			request.getRequestDispatcher("/itemlist.jsp").forward(request, response);
		}

		}catch(NullPointerException ne) {
			request.setAttribute("error",ne.getMessage() );
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}catch(SQLException se) {
			request.setAttribute("error",se.getMessage() );
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

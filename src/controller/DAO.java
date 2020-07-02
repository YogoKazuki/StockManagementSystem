package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import DBManager.DBManager;
public class DAO {

	public static DAO getInstance() {
		return new DAO();
	}

//	アカウント作成
	public void makeAcount(DTO dto) throws SQLException{
	Connection	con = null;
	PreparedStatement ps = null;
	try {
		con = DBManager.getConnection();
		ps = con.prepareStatement("INSERT INTO useracount (userID,password,name,newDate)values(?,?,?,?);");
		ps.setString(1,dto.getUserID());
		ps.setString(2, dto.getPassword());
		ps.setString(3,dto.getName());
		ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
		ps.executeUpdate();
        System.out.println("insert completed");
	}catch(SQLException e) {
		System.out.print(e.getMessage());
		throw new SQLException();
	}finally {
		if(con!=null) {
			con.close();
		}
	}

	}

//	製品管理用DBにデータを追加
	public void itemInsert(DTO dto) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement("INSERT INTO items (name,number,newDate) values(?,?,?);");
			ps.setString(1, dto.getName());
			ps.setInt(2, dto.getNumber());
			ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			ps.executeUpdate();
			System.out.print("insert completed");
		}catch(SQLException e) {
			System.out.print(e.getMessage());
			throw new SQLException();
		}finally {
			if(con!=null) {
				con.close();
			}
			}
		}

//	製品管理用DBの全てのカラムを検索しArrayListに入れる
	public ArrayList<DTO> allItems() throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<DTO> items = new ArrayList<DTO>();
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement("SELECT * FROM items;");
			rs =ps.executeQuery();
			while(rs.next()) {
				DTO dto = new DTO();
				dto.setID(rs.getInt("ID"));
				dto.setName(rs.getString("name"));
				dto.setNumber(rs.getInt("number"));
				dto.setUpdateTime(rs.getTimestamp("newDate"));
				items.add(dto);
			}
			return items;
		}catch(SQLException e) {
		System.out.print(e.getMessage());
		throw new SQLException();
		}finally {
			if(con!=null) {
			con.close();
			}
		}
	}

//	ログイン画面で入力されたIDとパスワードをユーザーアカウントデータベースと照合
//	合致すればtrue,しなければfalseを返す
	public boolean roginCheck(DTO dto) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement("SELECT * FROM useracount where userID=? AND password=?;");
			ps.setString(1, dto.getUserID());
			ps.setString(2,dto.getPassword());
			rs = ps.executeQuery();
			while(rs.next()) {
				if(dto.getUserID().equals(rs.getString("userID"))&&dto.getPassword().equals(rs.getString("password"))) {
				return true;
				}
			}
			return false;
		}catch(SQLException e) {
			System.out.print(e.getMessage());
			return false;
		}catch(NullPointerException ne) {
			System.out.print(ne.getMessage());
			return false;
		}finally {
			if(con!=null) {
				con.close();
			}

	}

}
//	在庫一覧から更新画面に飛ぶためにIDで検索をかけて一つのカラムのデータを呼び出す
	public DTO IDsearch(String itemID) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		DTO dto = new DTO();
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement("SELECT * FROM items WHERE ID =?;");
			ps.setInt(1, Integer.parseInt(itemID));
			rs = ps.executeQuery();
			rs.next();
			dto.setID(rs.getInt("ID"));
			dto.setName(rs.getString("name"));
			dto.setNumber(rs.getInt("number"));
			dto.setUpdateTime(rs.getTimestamp("newDate"));
			return dto;

			}catch(SQLException e) {
			System.out.print(e.getMessage());

			}catch(NullPointerException ne) {
			System.out.print(ne.getMessage());
			}finally {
				if(con!=null) {
					con.close();
				}
			}
		return dto;


	}
//	itemsデータベースの更新用メソッド
	public void updateItem(DTO dto) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement("UPDATE items SET name=?,number=?,newDate=? WHERE ID=?;");
			ps.setString(1, dto.getName());
			ps.setInt(2, dto.getNumber());
			ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			ps.setInt(4, dto.getID());
			ps.executeUpdate();
			System.out.print("更新完了");
		}catch(NullPointerException ne) {
			System.out.print(ne.getMessage());
			throw new NullPointerException();
		}catch(SQLException e) {
			System.out.print(e.getMessage());

		}finally {
			if(con!=null) {
				con.close();
			}
		}
	}

//	itemsデータベースの削除メソッド
	public void delete(int itemID)throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement("DELETE from items Where ID=?;");
			ps.setInt(1,itemID);
			ps.executeUpdate();
			System.out.print("削除が完了いたしました");
		}catch(NullPointerException ne) {
			System.out.print(ne.getMessage());
		}catch(SQLException e) {
			System.out.print(e.getMessage());

		}finally {
			if(con!=null) {
				con.close();
			}
		}
	}
}

package controller;
import java.sql.Timestamp;

public class DTO {
private int ID;
private String userID;
private String name;
private String password;
private int number;
private Timestamp updateTime;


	public void setID(int ID) {this.ID = ID;}
	public int getID() {return this.ID;}

	public void setUserID(String userID) {this.userID = userID;}
	public String getUserID() {return this.userID;}

	public void setName(String name) {this.name=name;}
	public String getName() {return this.name;}

	public void setPassword(String password) {this.password=password;}
	public String getPassword() {return this.password;}

	public void setNumber(int number) {this.number=number;}
	public int getNumber() {return this.number;}

	public void setUpdateTime(Timestamp updateTime) {this.updateTime=updateTime;}
	public Timestamp getUpdateTime() {return this.updateTime;}



}

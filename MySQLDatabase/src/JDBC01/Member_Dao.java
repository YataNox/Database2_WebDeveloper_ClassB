package JDBC01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Member_Dao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private Member_Dao() {}
	private Member_Dao itc = new Member_Dao();
	public Member_Dao getInstance() {return itc;}
}


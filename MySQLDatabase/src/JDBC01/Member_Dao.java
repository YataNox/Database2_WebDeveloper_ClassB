package JDBC01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Member_Dao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	DBManager dbm = new DBManager();
	
	private Member_Dao() {}
	private static Member_Dao itc = new Member_Dao();
	public static Member_Dao getInstance() {return itc;}
	
	public ArrayList<Member_Dto> selectAll() {
		ArrayList<Member_Dto> list = new ArrayList<Member_Dto>();
		con = dbm.getConnection();
		
		try {	
			String sql = "Select membernum, name, phone, date_format(birth, '%Y-%m-%d') as birth, "
					+ "date_format(joindate, '%Y-%m-%d') as joindate, bpoint, gender, age "
					+ "from scott.Memberlist";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				// 전송 객체에 값을 저장 후 
				Member_Dto ddto = new Member_Dto();
				ddto.setMembernum(rs.getInt("Membernum"));
				ddto.setName(rs.getString("name"));
				ddto.setPhone(rs.getString("phone"));
				ddto.setBirth(rs.getString("birth"));
				ddto.setJoindate(rs.getString("joindate"));
				ddto.setBpoint(rs.getInt("bpoint"));
				ddto.setGender(rs.getString("gender"));
				ddto.setAge(rs.getInt("age"));
				
				// 리턴 리스트에 추가
				list.add(ddto);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		dbm.close(con, pstmt, rs);
		return list;
	}

	public int insert(Member_Dto mdto) {
		int result = 0;
		con = dbm.getConnection();
		
		String sql = "insert into scott.memberlist(name, phone, birth, gender, age)"
				+ " value(?, ?, str_to_date(concat('', ?, ''), '%Y%m%d'), ?, ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdto.getName());
			pstmt.setString(2, mdto.getPhone());
			pstmt.setString(3, mdto.getBirth());
			pstmt.setString(4, mdto.getGender());
			pstmt.setInt(5, mdto.getAge());
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		dbm.close(con, pstmt, rs);
		return result;
	}

	public int delete(String num) {
		int result = 0;
		con = dbm.getConnection();
		
		String sql = "delete from scott.memberlist where membernum = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));
			result = pstmt.executeUpdate();
			
			sql = "select max(membernum) as membernum from scott.memberlist";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				sql = "alter table scott.memberlist auto_increment = " + (rs.getInt("membernum")+1);
				pstmt = con.prepareStatement(sql);
				pstmt.execute();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		dbm.close(con, pstmt, rs);
		return result;
	}

	public Member_Dto getDto(String num) {
		Member_Dto mdto = null;
		con = dbm.getConnection();
		
		String sql = "select membernum, name, phone, date_format(birth, '%Y-%m-%d') as birth,"
				+ " date_format(joindate, '%Y-%m-%d') as joindate, gender, age, bpoint "
				+ " from scott.memberlist where membernum = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				mdto = new Member_Dto();
				mdto.setMembernum(rs.getInt("membernum"));
				mdto.setName(rs.getString("name"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setBirth(rs.getString("birth"));
				mdto.setJoindate(rs.getString("joindate"));
				mdto.setGender(rs.getString("gender"));
				mdto.setAge(rs.getInt("age"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		dbm.close(con, pstmt, rs);
		return mdto;
	}

	public int update(Member_Dto newDto) {
		int result = 0;
		con = dbm.getConnection();
		String sql = "update scott.memberlist set name=?, phone=?,"
				+ " birth=str_to_date(concat('', ?, ''), '%Y%m%d'),"
				+ " joindate=str_to_date(concat('', ?, ''), '%Y-%m-%d'),"
				+ " bpoint=?, gender=?, age=? where membernum=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newDto.getName());
			pstmt.setString(2, newDto.getPhone());
			pstmt.setString(3, newDto.getBirth());
			pstmt.setString(4, newDto.getJoindate());
			pstmt.setInt(5, newDto.getBpoint());
			pstmt.setString(6, newDto.getGender());
			pstmt.setInt(7, newDto.getAge());
			pstmt.setInt(8, newDto.getMembernum());
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		dbm.close(con, pstmt, rs);
		return result;
	}
}


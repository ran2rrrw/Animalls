package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.MemberDto;
import util.DbcpBean;

public class MemberDao {
	
	// CRUD
	// 추가
	public boolean insert(MemberDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			conn = new DbcpBean().getConn();
			// 실행할 sql 문
			String sql = "INSERT INTO MEMBER" + 
					" ( member_id, delivery_id, password, nickname,role, phone_number, rank, profile_image, email_verified)" + 
					" VALUES ( ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			// ? 에 바인딩 할 내용이 있으면 바인딩
			pstmt.setString(1, dto.getMemberId());
			pstmt.setInt(2, dto.getDeliveryId());
			pstmt.setString(3, dto.getPassword());
			pstmt.setString(4, dto.getNickname());
			pstmt.setString(5, dto.getRole());
			pstmt.setString(6, dto.getPhoneNumber());
			pstmt.setString(7, dto.getRank());
			pstmt.setString(8, dto.getProfileImage());
			pstmt.setBoolean(9, dto.isEmailVerified());

			rowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResource(conn, pstmt);
		}
		return rowCount > 0;
	}
	
	// 수정
	public boolean update(MemberDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			conn = new DbcpBean().getConn();
			// 실행할 sql 문
			String sql = "UPDATE MEMBER" + 
					" SET delivery_id=?, password=?, nickname=?, role=?, phone_number=?, rank=?, profile_image=?, email_verified=?" + 
					" WHERE member_id=?";
			pstmt = conn.prepareStatement(sql);
			// ? 에 바인딩 할 내용이 있으면 바인딩
			pstmt.setInt(1, dto.getDeliveryId());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getNickname());
			pstmt.setString(4, dto.getRole());
			pstmt.setString(5, dto.getPhoneNumber());
			pstmt.setString(6, dto.getRank());
			pstmt.setString(7, dto.getProfileImage());
			pstmt.setBoolean(8, dto.isEmailVerified());
			pstmt.setString(9, dto.getMemberId());

			rowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResource(conn, pstmt);
		}
		return rowCount > 0;
	}
	
	// 삭제
	public boolean delete(String memberId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			conn = new DbcpBean().getConn();
			// 실행할 sql 문
			String sql = "DELETE FROM MEMBER" + 
					" WHERE member_id=?";
			pstmt = conn.prepareStatement(sql);
			// ? 에 바인딩 할 내용이 있으면 바인딩
			pstmt.setString(1, memberId);

			rowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResource(conn, pstmt);
		}
		return rowCount > 0;
	}
	
	// 조회
	public MemberDto getData(String memberId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		MemberDto dto = null;
		try {
			conn = new DbcpBean().getConn();
			// 실행할 sql 문
			String sql = "SELECT delivery_id, password, nickname,role, phone_number, rank, profile_image, email_verified" + 
					" FROM MEMBER" + 
					" WHERE member_id=?";
			pstmt = conn.prepareStatement(sql);
			// ? 에 바인딩할 내용이 있으면 여기서 한다.
			pstmt.setString(1, memberId);

			// query 문 수행하고 결과(ResultSet) 얻어내기
			rs = pstmt.executeQuery();
			// 반복문 돌면서
			if (rs.next()) {
				dto = new MemberDto();
				dto.setMemberId(memberId);
				dto.setDeliveryId(rs.getInt("delivery_id"));
	            dto.setPassword(rs.getString("password"));
	            dto.setNickname(rs.getString("nickname"));
	            dto.setRole(rs.getString("role"));
	            dto.setPhoneNumber( rs.getString("phone_number"));
	            dto.setRank(rs.getString("rank"));
	            dto.setProfileImage(rs.getString("profile_image"));
	            dto.setEmailVerified(rs.getBoolean("email_verified"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResource(conn, pstmt, rs);
		}
		return dto;
	}
	
	// 목록 조회
	public List<MemberDto> getList() {
		List<MemberDto> list = new ArrayList<>();
		MemberDto dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// DbcpBean() 객체를 이용해서 Connection 객체 하나 얻어내기(Connection pool에서 하나 꺼내오기)
			conn = new DbcpBean().getConn();
			String sql = "SELECT member_id, delivery_id, password, nickname,role, phone_number, rank, profile_image, email_verified" +
					" FROM MEMBER" +
					" ORDER BY num DESC";
			pstmt = conn.prepareStatement(sql);
			// query문 수행하고 결과(ResultSet) 얻어내기
			rs = pstmt.executeQuery();
			
			// 반복문 돌면서
			while (rs.next()) {
				// MemberDto 객체에 각 회원의 정보를 담아
	            dto = new MemberDto();
	            dto.setMemberId(rs.getString("member_id"));
	            dto.setDeliveryId(rs.getInt("delivery_id"));
	            dto.setPassword(rs.getString("password"));
	            dto.setNickname(rs.getString("nickname"));
	            dto.setRole(rs.getString("role"));
	            dto.setPhoneNumber( rs.getString("phone_number"));
	            dto.setRank(rs.getString("rank"));
	            dto.setProfileImage(rs.getString("profile_image"));
	            dto.setEmailVerified(rs.getBoolean("email_verified"));
	            
	            // ArrayList 객체에 누적
	            list.add(dto);
			}
		} catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	    	closeResource(conn, pstmt, rs);
	    }
		
		return list;
	}
	
	private void closeResource(Connection conn, PreparedStatement pstmt) {
		try {
			if (conn != null)
				conn.close();
			if (pstmt != null)
				pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void closeResource(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (conn != null)
				conn.close();
			if (pstmt != null)
				pstmt.close();
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

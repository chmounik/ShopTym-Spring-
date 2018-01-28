package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.st.utils.ConnectionHelper;

public class RemoveProductDAO {
	public boolean removeProduct(String sellerId,String productId){
		System.out.println("Inside AddProductDAO");
		boolean isChanged = false ;
		ConnectionHelper helper = new ConnectionHelper() ;
		
		Connection conn = helper.getDBConnection() ;
		//String query1 = "SELECT EMAIL FROM USER WHERE EMAIL = 'a@b.com' AND PASSWORD='password'" ;
		/*String query1 = "INSERT INTO USER (EMAIL, USERTYPE, PASSWORD, FIRSTNAME, "
				+ "LASTNAME, CONTACTNO, GENDER) VALUES ( " ;
		query1 += "'" + user.getEmail() + "', " ;
		query1 += "'" + user.getUserType() + "', " ;
		query1 += "'" + user.getPassword() + "', " ;
		query1 += "'" + user.getFirstName() + "', " ;
		query1 += "'" + user.getLastName() + "', " ;
		query1 += "'" + user.getContactNo() + "', " ;
		query1 += "'" + user.getGender() + "' ) ; " ;*/
		
		String query1 = "DELETE FROM product WHERE sellerid=? and productid=?";
		PreparedStatement pstmt ;
		try {
			pstmt = conn.prepareStatement(query1) ;
			pstmt.setString(1, sellerId ) ;
			pstmt.setString(2,  productId) ;
//			pstmt.setString(3,  productName) ;
//			pstmt.setString(4,  productDescription) ;
//			pstmt.setString(5,  productCategory) ;
//			pstmt.setString(6,  productQuantity) ;
//			pstmt.setString(7,  productPrice) ;
			System.out.println(pstmt) ;
			
			int rowsChanged = pstmt.executeUpdate() ;
			System.out.println(rowsChanged);
			if(rowsChanged > 0)
				isChanged = true ;
			pstmt.close() ;
			conn.close();
			/*rs.close();
			pstmt.close() ;
			conn.close();*/
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isChanged ;
	}

}

package com.st.dao.DAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.st.beans.ReviewReply;

public class MyrowMapperReviewReply implements RowMapper<ReviewReply> {
@Override
	public ReviewReply mapRow(ResultSet rs, int rownumber) throws SQLException {
		System.out.println("mapRow()====:"+rownumber);
		if(!rs.isBeforeFirst())
			return null;
		ReviewReply rr=new ReviewReply();
		rr.setReviewId(rs.getInt("reviewid"));
		rr.setReviewReplyId(rs.getInt("reviewReplyid"));
		rr.setSellerId(rs.getString("sellerid"));
		rr.setReviewReplyString(rs.getString("reviewreplystring"));
		return rr;
		}
}
package com.st.dao.DAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.st.beans.Review;
import com.st.beans.ReviewReply;

public class MyrowMapperReview implements RowMapper<Review> {
@Override
	public Review mapRow(ResultSet rs, int rownumber) throws SQLException {
		Review r=new Review();
		ReviewReply rr=new ReviewReply();
		r.setCostumerId(rs.getString("customerid"));
		r.setProductId(rs.getInt("productid"));
		r.setReview(rs.getString("reviewstring"));
		r.setReviewId(rs.getInt("reviewid"));
		rr.setReviewId(rs.getInt("reviewid"));
		rr.setReviewReplyId(rs.getInt("reviewreplyid"));
		rr.setReviewReplyString(rs.getString("reviewreplystring"));
		rr.setSellerId(rs.getString("sellerid"));
		r.setReviewReply(rr);
		System.out.println(r.getReviewReply());
		return r;
		}
}
package com.st.dao.DAOImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.st.beans.Review;
import com.st.dao.ReviewDAO;
@Component
public class ReviewDAOImpl implements ReviewDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<Review> getReviewsList(int productId) {
		//String query="select * from review r,reviewreply rr where productid='"+productId+"' and r.reviewid=rr.reviewid";
		String query2="select * from review  LEFT OUTER JOIN reviewreply on review.reviewid = reviewreply.reviewid where review.productid='"+productId+"'";
		return jdbcTemplate.query(query2, new MyrowMapperReview());
	}

	@Override
	public int writeReview(int productId, String review,String costumerId) {
		String query="insert into review(productid,customerid,reviewstring) values('"+productId+"','"+costumerId+"','"+review+"')";
		return jdbcTemplate.update(query);
	}
	
	

}

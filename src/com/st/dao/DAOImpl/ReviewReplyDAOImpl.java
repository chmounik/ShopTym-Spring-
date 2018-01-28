package com.st.dao.DAOImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.st.beans.ReviewReply;
import com.st.dao.ReviewReplyDAO;
@Component
public class ReviewReplyDAOImpl implements ReviewReplyDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public ReviewReply getReviewReply(int reviewId) {
		String query="select * from reviewreply where reviewid='"+reviewId+"'";
		System.out.println(query);
		try {
			return jdbcTemplate.queryForObject(query,new MyrowMapperReviewReply());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("in Catch");
			return null;
		}
	}

	@Override
	public int SaveReviewReply(int reviewId,String userEmail,String replyString) {
		// TODO Auto-generated method stub
		String query=" insert into REVIEWREPLY (REVIEWID , SELLERID , reviewreplystring ) "
				+ "		values ('"+reviewId+"' , '"+userEmail+"' , '"+replyString+"' ) " ;
		return jdbcTemplate.update(query);
	}

}

package com.st.dao;

import com.st.beans.ReviewReply;

public interface ReviewReplyDAO {
	
	public ReviewReply getReviewReply(int reviewId);
	public int SaveReviewReply(int productId,String replyString,String userEmail);
}

package com.st.dao;

import java.util.List;

import com.st.beans.Review;


public interface ReviewDAO {

	public List<Review> getReviewsList(int productId);
	public int writeReview(int productId,String review,String costumerId);
}

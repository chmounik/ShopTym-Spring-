package com.beans;

public class Review {

	private int reviewId;
	private int productId;
	private String costumerId;
	private String review;
	private ReviewReply reviewReply;

	public ReviewReply getReviewReply() {
		return reviewReply;
	}

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setReviewReply(ReviewReply reviewReply) {
		this.reviewReply = reviewReply;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getCostumerId() {
		return costumerId;
	}

	public void setCostumerId(String costumerId) {
		this.costumerId = costumerId;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Review(int reviewId, int productId, String costumerId, String review) {
		super();
		this.reviewId = reviewId;
		this.productId = productId;
		this.costumerId = costumerId;
		this.review = review;
	}

}

package com.beans;

public class ReviewReply {

	private int reviewReplyId;
	private int reviewId;
	private String sellerId;
	private String reviewReplyString;

	public int getReviewReplyId() {
		return reviewReplyId;
	}

	public ReviewReply() {}

	public void setReviewReplyId(int reviewReplyId) {
		this.reviewReplyId = reviewReplyId;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getReviewReplyString() {
		return reviewReplyString;
	}

	public void setReviewReplyString(String reviewReplyString) {
		this.reviewReplyString = reviewReplyString;
	}

	public ReviewReply(int reviewReplyId, int reviewId, String sellerId, String reviewReplyString) {
		super();
		this.reviewReplyId = reviewReplyId;
		this.reviewId = reviewId;
		this.sellerId = sellerId;
		this.reviewReplyString = reviewReplyString;
	}

}

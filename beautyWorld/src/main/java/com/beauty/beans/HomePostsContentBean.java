/**
 * 
 */
package main.java.com.beauty.beans;

import java.util.Date;

/**
 * @author vinay
 * 
 */
public class HomePostsContentBean {
	private Long postId;
	private String postTitle;
	private String postType;
	private Date postPublishedDate;
	private String postDescription;
	private String postPictureUrl;
	private String postPictureDescription;
	private String postVidUrl;
	private String postVideoDesc;
	private int imageWidth;
	private int imageHeight;
	private int pageNumber;

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostType() {
		return postType;
	}

	public void setPostType(String postType) {
		this.postType = postType;
	}

	public String getPostDescription() {
		return postDescription;
	}

	public void setPostDescription(String postDescription) {
		this.postDescription = postDescription;
	}

	public String getPostPictureUrl() {
		return postPictureUrl;
	}

	public void setPostPictureUrl(String postPictureUrl) {
		this.postPictureUrl = postPictureUrl;
	}

	public String getPostVidUrl() {
		return postVidUrl;
	}

	public void setPostVidUrl(String postVidUrl) {
		this.postVidUrl = postVidUrl;
	}

	public String getPostVideoDesc() {
		return postVideoDesc;
	}

	public void setPostVideoDesc(String postVideoDesc) {
		this.postVideoDesc = postVideoDesc;
	}

	public int getImageWidth() {
		return imageWidth;
	}

	public void setImageWidth(int imageWidth) {
		this.imageWidth = imageWidth;
	}

	public int getImageHeight() {
		return imageHeight;
	}

	public void setImageHeight(int imageHeight) {
		this.imageHeight = imageHeight;
	}

	public Date getPostPublishedDate() {
		return postPublishedDate;
	}

	public void setPostPublishedDate(Date postPublishedDate) {
		this.postPublishedDate = postPublishedDate;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getPostPictureDescription() {
		return postPictureDescription;
	}

	public void setPostPictureDescription(String postPictureDescription) {
		this.postPictureDescription = postPictureDescription;
	}

}

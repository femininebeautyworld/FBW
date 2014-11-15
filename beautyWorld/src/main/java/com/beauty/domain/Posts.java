/**
 * 
 */
package main.java.com.beauty.domain;

import java.util.Date;
import java.util.SortedSet;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * @author vinay
 * 
 */
public class Posts {

	private Long postId;
	private String postTitle;
	private String postType;
	private String postViewType;
	private String postDescription;
	private Date dateCreated;
	private Date datePublished;
	private SortedSet<PostPictureContent> postPictureContents;
	private SortedSet<PostVideoContent> postVideoContents;

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

	public String getPostViewType() {
		return postViewType;
	}

	public void setPostViewType(String postViewType) {
		this.postViewType = postViewType;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDatePublished() {
		return datePublished;
	}

	public void setDatePublished(Date datePublished) {
		this.datePublished = datePublished;
	}

	public SortedSet<PostPictureContent> getPostPictureContents() {
		return postPictureContents;
	}

	public void setPostPictureContents(
			SortedSet<PostPictureContent> postPictureContents) {
		this.postPictureContents = postPictureContents;
	}

	public SortedSet<PostVideoContent> getPostVideoContents() {
		return postVideoContents;
	}

	public void setPostVideoContents(
			SortedSet<PostVideoContent> postVideoContents) {
		this.postVideoContents = postVideoContents;
	}

	public String getPostDescription() {
		return StringEscapeUtils.unescapeHtml(postDescription);
	}

	public void setPostDescription(String postDescription) {
		this.postDescription = postDescription;
	}
}

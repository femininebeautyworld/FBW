/**
 * 
 */

package main.java.com.beauty.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import main.java.com.beauty.beans.PictureContentBean;
import main.java.com.beauty.domain.PostPictureContent;
import main.java.com.beauty.domain.PostVideoContent;
import main.java.com.beauty.domain.Posts;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 * @author vinay
 * 
 */
public class PostActivityForm extends ActionForm {

	/**
   * 
   */
	private static final long serialVersionUID = -598795880647031789L;

	private Long postId;
	private String postTitle;
	private String postType;
	private String postViewType;
	private String postDescription;
	private String dateCreated;
	private String datePublished;
	private String method;
	private List<PictureContentBean> pictureContents;
	private List<PostVideoContent> videoContents;
	private int pictureContentsListSize = 0;
	private int pictureContentsListCount = 0;
	private int videoContentsListSize = 0;
	private int videoContentsListCount = 0;

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

	public String getPostDescription() {
		return postDescription;
	}

	public void setPostDescription(String postDescription) {
		this.postDescription = postDescription;
	}

	public List<PictureContentBean> getPictureContents() {
		/*
		 * if (pictureContents == null) { pictureContents = new
		 * ArrayList<PictureContentBean>(); PictureContentBean
		 * pictureContentBean = new PictureContentBean();
		 * this.pictureContents.add(pictureContentBean); }
		 */
		return pictureContents;
	}

	public List<PostVideoContent> getVideoContents() {
		/*
		 * if (videoContents == null) { this.videoContents = new
		 * ArrayList<PostVideoContent>(); PostVideoContent postVideoContent =
		 * new PostVideoContent(); this.videoContents.add(postVideoContent); }
		 */
		return videoContents;
	}

	public void setPictureContents(List<PictureContentBean> pictureContents) {
		this.pictureContents = pictureContents;
	}

	public void setVideoContents(List<PostVideoContent> videoContents) {
		this.videoContents = videoContents;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		if (mapping.getPath().equals("/createPostActivity")) {
			if (request.getSession().getAttribute("pictureContentsListSize") != null) {
				Integer pictureContentsCount = (Integer) request.getSession()
						.getAttribute("pictureContentsListSize");
				pictureContents = getEmptyPictureContents(pictureContentsCount);
			} else {
				pictureContents = getEmptyPictureContents(1);
			}

			if (request.getSession().getAttribute("videoContentsListSize") != null) {
				Integer videoContentsCount = (Integer) request.getSession()
						.getAttribute("videoContentsListSize");
				videoContents = getEmptyVideoContents(videoContentsCount);
			} else {
				videoContents = getEmptyVideoContents(1);
			}
		}
	}

	private List<PictureContentBean> getEmptyPictureContents(
			int pictureContentsCount) {
		List<PictureContentBean> postPictureContentList = new ArrayList<PictureContentBean>();

		/*
		 * // add a default empty row if (pictureContentsCount == 1) {
		 * PictureContentBean postPictureContent = new PictureContentBean();
		 * postPictureContentList.add(postPictureContent); }
		 */

		for (int index = 0; index < pictureContentsCount; index++) {
			PictureContentBean postPictureContent = new PictureContentBean();
			postPictureContentList.add(postPictureContent);
		}
		return postPictureContentList;
	}

	public List<PostVideoContent> getEmptyVideoContents(int videoContentsCount) {
		List<PostVideoContent> videoContentsList = new ArrayList<PostVideoContent>();

		/*
		 * if (videoContentsCount == 1) { PostVideoContent postVideoContent =
		 * new PostVideoContent(); videoContentsList.add(postVideoContent); }
		 */

		for (int i = 0; i < videoContentsCount; i++) {
			PostVideoContent postVideoContent = new PostVideoContent();
			videoContentsList.add(postVideoContent);
		}
		return videoContentsList;
	}

	public void addEmptyPictureContents() {
		PictureContentBean postPictureContent = new PictureContentBean();
		this.pictureContents.add(postPictureContent);
	}

	public void addEmptyVideoContents() {
		PostVideoContent postVideoContent = new PostVideoContent();
		this.videoContents.add(postVideoContent);
	}

	public void removePictureContents() {
		this.pictureContents.remove(this.pictureContents.size() - 1);
	}

	public void removeVideoContents() {
		this.videoContents.remove(this.videoContents.size() - 1);
	}

	public Posts toDomainObject(Posts post) throws ParseException {

		Date date = new Date();
		post.setPostTitle(this.postTitle);
		post.setPostType(this.postType);
		post.setPostViewType(this.postViewType);
		post.setPostDescription(this.postDescription);
		post.setDateCreated(date);
		post.setDatePublished(new SimpleDateFormat("MM/dd/yyyy").parse(this.datePublished));
		if (post.getPostId() == null) {
			post.setPostPictureContents(toPictureContentDomainObject(post));
			post.setPostVideoContents(toVideoContentDomainObject(post));
		}

		return post;
	}

	private TreeSet<PostPictureContent> toPictureContentDomainObject(Posts post) {

		TreeSet<PostPictureContent> pictureContentsSet = new TreeSet<PostPictureContent>();
		for (PictureContentBean picContent : this.pictureContents) {
			PostPictureContent postPictureContent = new PostPictureContent();
			postPictureContent.setPostPicture(picContent.getImageDirPath());
			if (picContent.getPostPictureDescription() != null
					|| !picContent.getPostPictureDescription().isEmpty()) {
				postPictureContent.setPostPictureDescription(picContent
						.getPostPictureDescription().replaceAll("\\<.*?>", ""));
			}
			postPictureContent.setPostPicVideoUrl(picContent.getPostPicVideoUrl());
			postPictureContent.setPostPicVideoDesc(picContent.getPostPicVideoDesc());
			postPictureContent.setPosts(post);
			pictureContentsSet.add(postPictureContent);
		}

		return pictureContentsSet;
	}

	private TreeSet<PostVideoContent> toVideoContentDomainObject(Posts post) {
		TreeSet<PostVideoContent> videoContentsSet = new TreeSet<PostVideoContent>();
		if ((this.videoContents != null || !this.videoContents.isEmpty())) {
			for (PostVideoContent vidContent : this.videoContents) {
				PostVideoContent postVideoContent = new PostVideoContent();
				postVideoContent.setPostVideoUrl(vidContent.getPostVideoUrl());
				if (vidContent.getPostVideoDescription() != null) {
					postVideoContent.setPostVideoDescription(vidContent
							.getPostVideoDescription()
							.replaceAll("\\<.*?>", ""));
				}
				postVideoContent.setPosts(post);
				videoContentsSet.add(postVideoContent);
			}
		}
		return videoContentsSet;
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		if (verifyAction(mapping)) {
			if (this.postTitle == null || this.postTitle.length() < 1) {
				errors.add("postTitle", new ActionMessage(
						"error.PostTitle.required"));
			}
			if (this.postType == null || this.postType.length() < 1) {
				errors.add("postType", new ActionMessage(
						"error.PostType.required"));
			}
			if (this.postViewType == null || this.postViewType.length() < 1) {
				errors.add("postViewType", new ActionMessage(
						"error.PostViewType.required"));
			}
		}

		return errors;
	}

	private boolean verifyAction(ActionMapping actionMapping) {
		if ((actionMapping.getPath().equals("/createPostActivity"))
				&& (method != null && method.equals("createPost"))) {
			return true;

		}
		return false;
	}

	public void populateDomainObject(Posts post) {
		this.postId = post.getPostId();
		this.postTitle = post.getPostTitle();
		this.postType = post.getPostType();
		this.postViewType = post.getPostViewType();
		this.datePublished = new SimpleDateFormat("MM/dd/yyyy", Locale.US)
				.format(post.getDatePublished());
		this.postDescription = post.getPostDescription();
	}

	public int getPictureContentsListSize() {
		if (this.pictureContents != null) {
			return this.pictureContents.size();
		}

		return pictureContentsListSize;
	}

	public void setPictureContentsListSize(int pictureContentsListSize) {
		this.pictureContentsListSize = pictureContentsListSize;
	}

	public int getPictureContentsListCount() {
		if (this.pictureContents != null) {
			return this.pictureContents.size();
		}

		return pictureContentsListCount;
	}

	public void setPictureContentsListCount(int pictureContentsListCount) {
		this.pictureContentsListCount = pictureContentsListCount;
	}

	public int getVideoContentsListCount() {
		return videoContentsListCount;
	}

	public void setVideoContentsListCount(int videoContentsListCount) {
		this.videoContentsListCount = videoContentsListCount;
	}

	public int getVideoContentsListSize() {
		if (this.videoContents != null) {
			return this.videoContents.size();
		}

		return videoContentsListSize;
	}

	public void setVideoContentsListSize(int videoContentsListSize) {
		this.videoContentsListSize = videoContentsListSize;
	}

	public String getDatePublished() {
		return datePublished;
	}

	public void setDatePublished(String datePublished) {
		this.datePublished = datePublished;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

}

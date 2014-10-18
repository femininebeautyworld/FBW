/**
 * 
 */

package main.java.com.beauty.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import main.java.com.beauty.beans.PictureContentBean;
import main.java.com.beauty.domain.PostPictureContent;
import main.java.com.beauty.domain.PostVideoContent;
import main.java.com.beauty.domain.Posts;
import main.java.com.beauty.util.RequestUtils;

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

	private String postTitle;
	private String postType;
	private String postViewType;
	private String postDescription;
	private String dateCreated;
	private String method;
	private List<PictureContentBean> pictureContents;
	private List<PostVideoContent> videoContents;
	private int pictureContentsListSize = 1;
	private int pictureContentsListCount = 1;

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
		if (pictureContents == null) {
			pictureContents = new ArrayList<PictureContentBean>();
			PictureContentBean pictureContentBean = new PictureContentBean();
			this.pictureContents.add(pictureContentBean);
		}
		return pictureContents;
	}

	public List<PostVideoContent> getVideoContents() {
		if (videoContents == null) {
			this.videoContents = new ArrayList<PostVideoContent>();
			PostVideoContent postVideoContent = new PostVideoContent();
			this.videoContents.add(postVideoContent);
		}
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
		}
	}

	private List<PictureContentBean> getEmptyPictureContents(
			int pictureContentsCount) {
		List<PictureContentBean> postPictureContentList = new ArrayList<PictureContentBean>();

		// add a default empty row
		if (pictureContentsCount == 0) {
			PictureContentBean postPictureContent = new PictureContentBean();
			postPictureContentList.add(postPictureContent);
		}

		for (int index1 = 0; index1 < pictureContentsCount; index1++) {
			PictureContentBean postPictureContent = new PictureContentBean();
			postPictureContentList.add(postPictureContent);
		}
		return postPictureContentList;
	}

	public List<PostVideoContent> getVideoContents(int index) {
		List<PostVideoContent> videoContentsList = new ArrayList<PostVideoContent>();

		if (index == 0) {
			PostVideoContent postVideoContent = new PostVideoContent();
			videoContentsList.add(postVideoContent);
		}

		for (int i = 0; i < index; i++) {
			PostVideoContent postVideoContent = new PostVideoContent();
			videoContentsList.add(postVideoContent);
		}
		return videoContentsList;
	}

	public void addEmptyPictureContents() {
		PictureContentBean postPictureContent = new PictureContentBean();
		this.pictureContents.add(postPictureContent);
	}

	public void removePictureContents() {
		this.pictureContents.remove(this.pictureContents.size() - 1);
	}

	public void removeVideoContents() {
		this.videoContents.remove(this.videoContents.size() - 1);
	}

	public int getVideoContentsListSize() {
		if (this.videoContents != null) {
			return this.videoContents.size();
		}

		return 0;
	}

	public Posts toDomainObject(Posts post) {

		Date date = new Date();
		post.setPostTitle(this.postTitle);
		post.setPostType(this.postType);
		post.setPostViewType(this.postViewType);
		post.setPostDescription(this.postDescription);
		post.setDateCreated(date);
		if (post != null && post.getPostId() != null) {
			post.setDatePublished(date);
		}
		post.setPostPictureContents(toPictureContentDomainObject(post));
		post.setPostVideoContents(toVideoContentDomainObject(post));

		return post;
	}

	private Set<PostPictureContent> toPictureContentDomainObject(Posts post) {

		Set<PostPictureContent> pictureContentsSet = new HashSet<PostPictureContent>();
		for (PictureContentBean picContent : this.pictureContents) {
			PostPictureContent postPictureContent = new PostPictureContent();
			postPictureContent.setPostPicture(picContent.getImageDirPath());
			postPictureContent.setPostPictureDescription(picContent
					.getPostPictureDescription());
			postPictureContent.setPosts(post);
			pictureContentsSet.add(postPictureContent);
		}

		return pictureContentsSet;
	}

	private Set<PostVideoContent> toVideoContentDomainObject(Posts post) {
		Set<PostVideoContent> videoContentsSet = new HashSet<PostVideoContent>();
		for (PostVideoContent vidContent : this.videoContents) {
			PostVideoContent postVideoContent = new PostVideoContent();
			postVideoContent.setPostVideoUrl(vidContent.getPostVideoUrl());
			postVideoContent.setPostVideoDescription(vidContent
					.getPostVideoDescription());
			postVideoContent.setPosts(post);
			videoContentsSet.add(postVideoContent);
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
		List<PictureContentBean> picContentsList = new ArrayList<PictureContentBean>();
		List<PostPictureContent> picContents = new ArrayList<PostPictureContent>(
				post.getPostPictureContents());
		List<PostVideoContent> vidContents = new ArrayList<PostVideoContent>(
				post.getPostVideoContents());
		this.postTitle = post.getPostTitle();
		this.postType = post.getPostType();
		this.postViewType = post.getPostViewType();
		this.postDescription = post.getPostDescription();
		for( PostPictureContent postPictureContent : picContents )
		{
			PictureContentBean pictureContentBean = new PictureContentBean();
			pictureContentBean.set
		}
		this.pictureContents = pictureContents;
		this.videoContents = vidContents;
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

}

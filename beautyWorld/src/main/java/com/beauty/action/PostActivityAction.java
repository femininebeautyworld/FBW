/**
 * 
 */
package main.java.com.beauty.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.com.beauty.beans.PictureContentBean;
import main.java.com.beauty.domain.Posts;
import main.java.com.beauty.form.PostActivityForm;
import main.java.com.beauty.service.PostActivityService;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

/**
 * @author vinay
 */
public class PostActivityAction extends DispatchAction {
	private final String SUCCESS_DISPLAY = "success_display";
	private final String SUCCESS = "success";
	private final String FAILURE = "failure";

	private PostActivityService postActivityService;

	public void setPostActivityService(PostActivityService postActivityService) {
		this.postActivityService = postActivityService;
	}

	public ActionForward display(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		PostActivityForm postActivityForm = new PostActivityForm();

		request.setAttribute("postActivityForm", postActivityForm);
		request.getSession().setAttribute("pictureContentsListSize", postActivityForm.getPictureContentsListSize() );

		return mapping.findForward(SUCCESS_DISPLAY);
	}

	public ActionForward createPost(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		PostActivityForm postActivityForm = (PostActivityForm) form;
		Posts post = new Posts();

		// Process the FormFile
		List<PictureContentBean> pictureContentList = postActivityForm
				.getPictureContents();

		// Get the servers upload directory real path name
		String imageFilePath = request.getServletContext()
				.getRealPath("img");

		for (PictureContentBean pictureContentBean : pictureContentList) {
			String imageDirPath = "img" + "/" + pictureContentBean.getPostPicture().getFileName();
			pictureContentBean.setImageDirPath(imageDirPath);

			// Process the FormFile
			FormFile imageFile = pictureContentBean.getPostPicture();

			String contentType = imageFile.getContentType();

			// Get the file name
			String fileName = imageFile.getFileName();

			if (!fileName.equals("")) {
				System.out.println("Server path:" + imageFilePath);

				// Create file
				File fileToCreate = new File(imageFilePath, fileName);

				// If file does not exists create file
				if (!fileToCreate.exists()) {
					FileOutputStream fileOutStream = new FileOutputStream(
							fileToCreate);
					fileOutStream.write(imageFile.getFileData());
					fileOutStream.flush();
					fileOutStream.close();
				}
			}
		}

		postActivityForm.setPictureContents(pictureContentList);

		post = postActivityForm.toDomainObject(post);

		try {
			postActivityService.save(post);
		} catch (Exception e) {
			return mapping.findForward(FAILURE);
		}
		System.out.println("Object saved successfully.....!!");

		return mapping.findForward(SUCCESS);
	}

	public ActionForward editPost(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Long postId = Long.parseLong(request.getParameter("postId"));
		PostActivityForm postActivityForm = new PostActivityForm();
		Posts post = postActivityService.getPostById(postId);

		postActivityForm.populateDomainObject(post);

		request.setAttribute("postActivityForm", postActivityForm);
		return mapping.findForward(SUCCESS);

	}

	public ActionForward addAnotherPictureFields(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		ActionForward forward = mapping.findForward(SUCCESS_DISPLAY);
		ActionMessages errors = new ActionMessages();
		PostActivityForm postActivityForm = (PostActivityForm) request
				.getAttribute("postActivityForm");

		postActivityForm.addEmptyPictureContents();

		request.getSession().setAttribute("pictureContentsListSize", postActivityForm.getPictureContentsListSize() );
		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward(FAILURE);
		}

		return forward;
	}

	public ActionForward removePictureField(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		ActionForward forward = mapping.findForward(SUCCESS_DISPLAY);
		ActionMessages errors = new ActionMessages();
		PostActivityForm postActivityForm = (PostActivityForm) request
				.getAttribute("postActivityForm");

		postActivityForm.removePictureContents();

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward(FAILURE);
		}

		return forward;
	}

	public ActionForward removeVideoField(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		ActionForward forward = mapping.findForward(SUCCESS_DISPLAY);
		ActionMessages errors = new ActionMessages();
		PostActivityForm postActivityForm = (PostActivityForm) request
				.getAttribute("postActivityForm");

		postActivityForm.removeVideoContents();

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward(FAILURE);
		}

		return forward;
	}

}

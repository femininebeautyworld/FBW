/**
 * 
 */
package main.java.com.beauty.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.com.beauty.domain.Posts;
import main.java.com.beauty.service.PostActivityService;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 * @author vinay
 * 
 */
public class PaxPostDetailViewAction extends DispatchAction {

	private final String SUCCESS_POST = "success_post";
	private final String FAILURE = "failure";

	private PostActivityService postActivityService;

	public void setPostActivityService(PostActivityService postActivityService) {
		this.postActivityService = postActivityService;
	}

	public ActionForward displayPost(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Long postId = Long.parseLong(request.getParameter("postId"));
		Posts post = new Posts();
		try {
			post = postActivityService.getPostById(postId);
		} catch (Exception e) {
			return mapping.findForward(FAILURE);
		}

		request.setAttribute("post", post);

		return mapping.findForward(SUCCESS_POST);
	}

}

package com.yang.contrller;

import com.github.pagehelper.PageInfo;
import com.yang.entity.Remark;
import com.yang.service.RemarkService;
import com.yang.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;


/**
 * @author Yyang
 * @create 2017/12/1.
 */
@RestController
public class RemarkContrller {
	private static int MAX_CONTENT = 200;
	@Autowired
	RemarkService remarkService;

	/**
	 * 添加一个评论
	 * @param remark
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/remark/add", method = RequestMethod.POST)
	public Map addRemark(Remark remark, HttpSession session) {

		if (remark.getRemarkContent() == null) {
			return Message.message(false);
		}
		String content =remark.getRemarkContent() ;
		if (content.length() >= MAX_CONTENT || content.isEmpty()) {
			return Message.message(false);
		}
		int userid = (int) session.getAttribute("id");
		int movieId = (int) session.getAttribute("movieId");

		if (remarkService.insertRemark(content, userid, movieId)) {
			return Message.message(true);
		}
		return Message.message(false);
	}

	/**
	 * 获取所有评论
	 * @return
	 */
	@RequestMapping(value = "/remark/all", method = RequestMethod.POST)
	public PageInfo<Remark> getAllRemark(@PathParam("pageIndex") int pageIndex,
										 @PathParam("pageSize") int pageSize) {
		PageInfo<Remark> remarkPageInfo = remarkService.getAllRemark(pageIndex,pageSize);
		return remarkPageInfo;
	}

	/**
	 * 获取电影评论
	 * @param movieId
	 * @return
	 */
	@RequestMapping(value = "/remark/movie_{id}", method = RequestMethod.GET)
	public List<Remark> getMovieRemark(@PathVariable("id") int movieId) {
		List<Remark> remarks = remarkService.getMovieRemark(movieId);
		return remarks;
	}

	/**
	 * 管理员删除一条评论
	 * @param remarkId
	 * @return
	 */
	@RequestMapping(value = "/remark/delete_{id}", method = RequestMethod.DELETE)
	public Map deleteRemark(@PathVariable("id") int remarkId) {
		if (remarkService.deleteRemark(remarkId)) {
			return Message.message(true);
		}
		return Message.message(false);
	}
}

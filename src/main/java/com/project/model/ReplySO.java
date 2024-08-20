package com.project.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.exception.UnExpectedAccessException;

public class ReplySO {

	@Autowired
	private ReplyDao replyDao;
	
	public List<ReplyDO> getRepliesByPostId(long postId) {
		return replyDao.selectRepliesByPost(postId);
	}

	public void likeReply(int replyId, String userId) {
		replyDao.likeReply(replyId, userId);
	}
	
	public void deleteReplyService(int reply_id, String user_id) {
		ReplyDO reply = replyDao.getReplyById(reply_id);
		if(user_id != null && user_id.equals(reply.getUser_id())) {
			replyDao.deleteReply(reply_id);
		}
		else {
			throw new UnExpectedAccessException();
		}
	}
	
}

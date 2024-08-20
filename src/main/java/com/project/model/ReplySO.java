package com.project.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class ReplySO {

	@Autowired
	private ReplyDao replyDao;
	
	public List<ReplyDO> getRepliesByPostId(long postId) {
		return replyDao.selectRepliesByPost(postId);
	}

	public void likeReply(int replyId, String userId) {
		replyDao.likeReply(replyId, userId);
	}
	
}

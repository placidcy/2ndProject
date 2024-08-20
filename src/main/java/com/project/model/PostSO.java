package com.project.model;

import com.project.model.response.PostMainResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostSO {
	
	@Autowired
	private final PostDao postDao;
	
	public PostSO(PostDao postDao) {
		this.postDao = postDao;
	}

	public PostMainResponse getAllPost() {
		return new PostMainResponse(postDao.selectAllPost());

	}
	
//	public PostDO getPostById(long post_id) {
//		return postDao.selectPostById(post_id);
//	}

	
	/* 
	검사할게 있다면 넣고 아니면 그냥 PostDao 사용
	public int getPostCount(UserDO userInfo) {
		return postDao.countPost(userInfo);
	}
	 */
}

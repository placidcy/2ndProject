package com.project.model;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostSO {
	private final PostDao postDao;
	
	public PostSO(PostDao postDao) {
		this.postDao = postDao;
	}

	public List<PostDO> getAllPost() {
		return postDao.selectAllPost();
	}
	
	/* 
	검사할게 있다면 넣고 아니면 그냥 PostDao 사용
	public int getPostCount(UserDO userInfo) {
		return postDao.countPost(userInfo);
	}
	 */
}

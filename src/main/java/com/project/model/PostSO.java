package com.project.model;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostSO {
	private final PostDao postDao;
	@Autowired
	public PostSO(PostDao postDao) {
		this.postDao = postDao;
	}

	public List<PostDO> getAllPost() {
		return postDao.selectAll();
	}
}

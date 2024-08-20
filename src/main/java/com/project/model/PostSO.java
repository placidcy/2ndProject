package com.project.model;

import com.project.model.response.PostMainResponse;

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

	public PostMainResponse getAllPost() {
		return new PostMainResponse(postDao.selectAllPost());

	}
	
	public PostDO getPostById(long post_id) {
		return postDao.selectPostById(post_id);
	}

	public PostMainResponse search(String keyword) {

		List<PostDO> search = postDao.search(keyword);
		return new PostMainResponse(search);
	}

	
	/* 
	검사할게 있다면 넣고 아니면 그냥 PostDao 사용
	public int getPostCount(UserDO userInfo) {
		return postDao.countPost(userInfo);
	}
	 */
}

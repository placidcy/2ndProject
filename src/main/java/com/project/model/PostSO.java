package com.project.model;

import com.project.exception.*;
import com.project.model.response.PostMainResponse;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PostSO {

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

	public PostMainResponse search(String keyword) {

		List<PostDO> search = postDao.search(keyword);
		return new PostMainResponse(search);
	}

	public PostMainResponse searchPosition(String position) {
		List<PostDO> search = postDao.searchPosition(position);
		return new PostMainResponse(search);
	}

	public void deletePostService(long post_id, String user_id) {
		PostDO post = postDao.getPostById(post_id);
		if(user_id != null && user_id.equals(post.getUser_id())) {
			postDao.deletePost(post_id);
		}
		else {
			throw new UnExpectedAccessException();
		}
	}
	/* 
	검사할게 있다면 넣고 아니면 그냥 PostDao 사용
	public int getPostCount(UserDO userInfo) {
		return postDao.countPost(userInfo);
	}
	 */
}

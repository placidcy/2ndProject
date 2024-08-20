package com.project.model;

import com.project.model.response.PageResponse;
import com.project.model.response.Post;
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

	public PageResponse<Post> getPaginatedPost(int page) {
		PageResponse<PostDO> postPage = postDao.selectPaginatedPost(page);

		List<Post> postList = postPage.getContent().stream().map(Post::new).toList();

		return new PageResponse<>(
				postList,
				postPage.getCurrentPage(),
				postPage.getSize(),
				postPage.getTotalElements()
		);
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

	public PostMainResponse updateViewCount(long postId) {
		List<PostDO> postList = postDao.updateViewCount(postId);

		return new PostMainResponse(postList);
	}
	
	/* 
	검사할게 있다면 넣고 아니면 그냥 PostDao 사용
	public int getPostCount(UserDO userInfo) {
		return postDao.countPost(userInfo);
	}
	 */
}

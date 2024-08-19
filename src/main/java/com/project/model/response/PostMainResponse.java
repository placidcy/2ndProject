package com.project.model.response;

import com.project.model.PostDO;
import java.util.ArrayList;
import java.util.List;

public class PostMainResponse {
    List<Post> postList;

    public PostMainResponse(List<PostDO> postList) {
        this.postList = new ArrayList<>();
        for (PostDO postDO : postList) {
            this.postList.add(new Post(postDO));
        }
    }

    public List<Post> getPostList() {
        return postList;
    }

    public class Post {
        private long post_id;
        private String title;
        private String content;
        private String position;
        private int view_count;

        // 추천 ?
        // 댓글 수
        private int reply_count;
        private String created_date;

        public Post(PostDO postDO) {
            this.post_id = postDO.getPost_id();
            this.title = postDO.getTitle();
            this.content = postDO.getContent();
            this.position = postDO.getPosition();
            this.view_count = postDO.getView_count();
            this.created_date = postDO.getCreated_date();
        }

        public long getPost_id() {
            return post_id;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public String getPosition() {
            return position;
        }

        public int getView_count() {
            return view_count;
        }

        public String getCreated_date() {
            return created_date;
        }
    }
}

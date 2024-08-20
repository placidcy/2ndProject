package com.project.model.response;

import com.project.model.PostDO;
import java.util.*;

public class PostMainResponse {
    private List<Post> postList;

    public PostMainResponse(List<PostDO> postList) {
        this.postList = new ArrayList<>();
        for (PostDO postDO : postList) {
            this.postList.add(new Post(postDO));
        }
    }

    public List<Post> getPostList() {
        return postList;
    }
}

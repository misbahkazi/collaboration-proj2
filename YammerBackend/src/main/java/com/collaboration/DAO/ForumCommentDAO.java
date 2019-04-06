package com.collaboration.DAO;

import java.util.List;


import com.collaboration.model.ForumComment;

public interface ForumCommentDAO {
	
	public boolean addForumComment(ForumComment comment);
	public boolean deleteForumComment(ForumComment comment);
	public List<ForumComment> listForumComment(int forumId);
	public ForumComment getForumComment(int forumId);
}

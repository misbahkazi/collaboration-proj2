package com.collaboration.DAO;

import com.collaboration.model.UserDetail;

public interface UserDAO {
	
	public boolean registerUser(UserDetail user);
	public boolean updateUserDetail(UserDetail user);
	public UserDetail getUser(String username);
	public boolean makeOffLine(UserDetail user);
	public boolean makeOnLine(UserDetail user);
	public boolean rejectUser(UserDetail user);
	public boolean approveUser(UserDetail user);

}

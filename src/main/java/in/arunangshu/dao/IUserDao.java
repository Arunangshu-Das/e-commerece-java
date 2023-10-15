package in.arunangshu.dao;

import in.arunangshu.model.User;

public interface IUserDao {
	public User userLogin(String email, String password);
	public User userSignUp( String name, String email, String password);
}

package com.iris.webservice.model.persistance;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImplementation implements UserDao {

	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public UserDaoImplementation() {
	}

	@Autowired
	public UserDaoImplementation(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		List<User> users = getSession().createQuery("From User").list();
		return users;
	}

	@Override
	public User getUserById(Integer userId) {
		return (User) getSession().get(User.class, userId);
	}

	@Override
	public User add(User user) {
		getSession().save(user);
		return user;
	}

	@Override
	public User update(User user) {
		getSession().merge(user);
		return user;
	}

	@Override
	public User remove(Integer userId) {
		User user = getUserById(userId);
		if (user != null) {
			getSession().delete(user);
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUserByUserEmailId(String userEmailId, String userPassword) {
		User user = null;
		String hql = "from User u where u.userEmailId = ? and u.userPassword = ?";
		List<User> users = getSession().createQuery(hql)
				.setString(0, userEmailId).setString(1, userPassword).list();

		if (users.isEmpty()) {
			user = users.get(0);
		}
		return user;
	}

}
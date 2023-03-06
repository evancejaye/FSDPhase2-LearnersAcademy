package com.academy.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.academy.model.Classs;
import com.academy.model.Student;
import com.academy.model.Subject;
import com.academy.model.Teacher;
import com.academy.util.DBConnectionUtil;

public class AdminService {

	private static Connection connection;
	private static PreparedStatement preparedStatement;

	public boolean addSubject(Subject subject) {
		boolean result = false;

		try {

			connection = DBConnectionUtil.getDbConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement("INSERT INTO subjects (name , shortcut) values(? , ? )");
			preparedStatement.setString(1, subject.getName());
			preparedStatement.setString(2, subject.getShortcut());

			preparedStatement.execute();
			connection.commit();
			result = true;

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public boolean addTeacher(Teacher teacher) {
		boolean result = false;

		try {

			connection = DBConnectionUtil.getDbConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection
					.prepareStatement("INSERT INTO teachers (fname, lname , age) values(? , ? , ? )");
			preparedStatement.setString(1, teacher.getFname());
			preparedStatement.setString(2, teacher.getLname());
			preparedStatement.setString(3, teacher.getAge());

			preparedStatement.execute();
			connection.commit();
			result = true;

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public boolean addClass(Classs newClass) {
		boolean result = false;

		try {

			connection = DBConnectionUtil.getDbConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection
					.prepareStatement("INSERT INTO classes (section, teacher, subject , time) values(? , ? , ? , ? )");
			preparedStatement.setInt(1, newClass.getSection());
			preparedStatement.setInt(2, newClass.getTeacher());
			preparedStatement.setInt(3, newClass.getSubject());
			preparedStatement.setString(4, newClass.getTime());

			preparedStatement.execute();
			connection.commit();
			result = true;

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public boolean addStudent(Student student) {
		boolean result = false;

		try {

			connection = DBConnectionUtil.getDbConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection
					.prepareStatement("INSERT INTO students (fname, lname, age , class) values(? , ? , ? , ? )");
			preparedStatement.setString(1, student.getFname());
			preparedStatement.setString(2, student.getLname());
			preparedStatement.setInt(3, student.getAge());
			preparedStatement.setInt(4, student.getAclass());

			preparedStatement.execute();
			connection.commit();
			result = true;

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
}

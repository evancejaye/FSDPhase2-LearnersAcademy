package com.academy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.academy.model.Subject;
import com.academy.model.Teacher;
import com.academy.model.Classs;
import com.academy.model.Student;
import com.academy.service.AdminService;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void adminLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	
    	HttpSession session = request.getSession();
    	
    	
    	if (username.toLowerCase().equals("admin") && password.toLowerCase().equals("admin")) {
    		session.setAttribute("isAdminLoggedIn", true);
    		RequestDispatcher dispatcher = request.getRequestDispatcher("admin-home.jsp");
			dispatcher.forward(request, response);

		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
    	
    }
    
    protected void addSubject(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	String subName = request.getParameter("subject");
    	String shortName =  request.getParameter("short_name");
    	
    	Subject subject = new Subject(subName , shortName);
    	
    	AdminService adminService = new AdminService();
    	
    	boolean res = adminService.addSubject(subject);
    	
    	response.sendRedirect("subjects.jsp");
    	
    }
    
    protected void addTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	String fname = request.getParameter("fname");
    	String lname =  request.getParameter("lname");
    	String age =  request.getParameter("age");
    	
    	Teacher teacher = new Teacher(fname , lname , age);
    	
    	AdminService adminService = new AdminService();
    	
    	boolean res = adminService.addTeacher(teacher);
    	response.sendRedirect("teachers.jsp");
    }
    
    protected void addClass(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	int section = Integer.parseInt(request.getParameter("section"));
    	int teacher =  Integer.parseInt(request.getParameter("teacher"));
    	int subject =  Integer.parseInt(request.getParameter("subject"));
    	String time = request.getParameter("time");
    	

    	
    	Classs newClass = new Classs(section , teacher , subject , time );
    	
    	AdminService adminService = new AdminService();
    	
    	boolean res = adminService.addClass(newClass);
    	response.sendRedirect("classes.jsp");
    }

    protected void addStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	String fname = request.getParameter("fname");
    	String lname =  request.getParameter("lname");
    	int age =  Integer.parseInt(request.getParameter("age"));
    	int class_id = Integer.parseInt(request.getParameter("class"));
    	

    	
    	Student student = new Student(fname , lname, age, class_id );
    	
    	AdminService adminService = new AdminService();
    	
    	boolean res = adminService.addStudent(student);
    	response.sendRedirect("students.jsp");
    }
    
    protected void logOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	HttpSession session = request.getSession();
    	session.invalidate();
    	response.sendRedirect("index.jsp");
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("Login")) {
			this.adminLogin(request, response);
		}else if(action.equalsIgnoreCase("Add Subject")) {
			this.addSubject(request, response);
		}else if(action.equalsIgnoreCase("Add Teacher")) {
			this.addTeacher(request, response);
		}else if(action.equalsIgnoreCase("Add Class")) {
			this.addClass(request, response);
		}else if(action.equalsIgnoreCase("Add Student")){
			this.addStudent(request, response);
		}else if(action.equalsIgnoreCase("Logout")){
			this.logOut(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

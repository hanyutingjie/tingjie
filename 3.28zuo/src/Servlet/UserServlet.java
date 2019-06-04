package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;

import com.pojo.User;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO userDAO =new UserDAO();
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String flag = request.getParameter("flag");
		switch (flag) {
		case "denglu":
			denglu(request,response);
			break;
		case "zhuce":
			zhuce(request,response);
			break;
		case "findAll":
			findAll(request,response);
			break;
		case "delete":
			delete(request,response);
			break;
		case "zengjia":
			zengjia(request,response);
			break;
		case "yupdate":
			yupdate(request,response);
			break;
		case "update":
			update(request,response);
			break;
		case "findByName":
			findByName(request,response);
			break;
		default:
			break;
		}
	}


	



	private void findByName(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		List<User> users=userDAO.findByName(username);
		request.setAttribute("users", users);
		try {
			request.getRequestDispatcher("user_show.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		String username=request.getParameter("username");
		String password=request.getParameter("password");	
		
		User user=new User(Integer.parseInt(id),username,password);
		userDAO.update(user);
		findAll(request,response);
	}


	private void zengjia(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");	
		
		User user=new User(username,password);
		userDAO.add(user);
		findAll(request,response);
	}


	private void yupdate(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		User u=userDAO.findById(Integer.parseInt(id));
		request.setAttribute("updateUser", u);
		try {
			request.getRequestDispatcher("user_update.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	private void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		userDAO.delete(Integer.parseInt(id));
	     findAll(request,response);
	}


	private void findAll(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<User> list=userDAO.findAll();
		request.setAttribute("users", list);
		
		try {
			request.getRequestDispatcher("user_show.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void zhuce(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");	
		User user=new User(username,password);//封装
		userDAO.add(user);
		try {
   
			request.getRequestDispatcher("denglu.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void denglu(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		try{
			User loginUser=new User(username,password);
			loginUser=userDAO.login(loginUser);
			
		if(loginUser!=null){
			request.getSession().setAttribute("loginUser",loginUser);//前面是名  后面是值
			request.getRequestDispatcher("guanli.jsp").forward(request, response);			
		}else{
			
			request.getRequestDispatcher("denglu.jsp").forward(request, response);
		}
	}catch (ServletException | IOException e) {
		
		e.printStackTrace();
	}
	}

}

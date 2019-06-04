package Servlet;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.dao.CarDAO;
import com.pojo.car;

@MultipartConfig
@WebServlet("/CarServlet")
public class CarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   CarDAO carDAO=new CarDAO();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String flag = request.getParameter("flag");
		switch (flag) {
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
		case "findByCondition":
			findByCondition(request,response);
			break;
		default:
			break;
		}
		
	}
	private void findByCondition(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String color=request.getParameter("color");
		String price1=request.getParameter("price1");
		String price2=request.getParameter("price2");
	
		car c = new car(name,color,Double.parseDouble(price1),Double.parseDouble(price2));
		List<car> cars =carDAO.findByCondition(c);
		request.setAttribute("cars", cars);
		try {
			request.getRequestDispatcher("car_show.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String name=request.getParameter("name");
		String color=request.getParameter("color");
		String price=request.getParameter("price");
		String newname =upload(request);
		
		car c = new car(name,color,newname,Double.parseDouble(price));
		c.setId(Integer.parseInt(id));
		carDAO.update(c);
		findAll(request, response);
	}
	private void yupdate(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		System.out.println(id+"----");
		car car =carDAO.findById(Integer.parseInt(id));
	
		request.setAttribute("car", car);
		try {
			request.getRequestDispatcher("car_update.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void findAll(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<car> list=carDAO.findAll();
		request.setAttribute("cars", list);
		try {
			request.getRequestDispatcher("carguanli.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void zengjia(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String color=request.getParameter("color");
		String price=request.getParameter("price");
		String newname =upload(request);
		
		car c = new car(name,color,newname,Double.parseDouble(price));
		carDAO.add(c);
		findAll(request, response);
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		carDAO.delete(Integer.parseInt(request.getParameter("id")));
		findAll(request, response);
	}

	public String upload(HttpServletRequest request) {
		String newname="";
		String suffix="";
		try {
			Part part = request.getPart("upfile");//获得用户选择的图片的路径
			String path =  part.getHeader("content-disposition");//获得头部信息
			System.out.println(path);
			if(!path.endsWith("filename=\"\"")) {
			  suffix =path.substring(path.lastIndexOf("."),path.length()-1);//截取得到文件后缀
			
			File f = new File("d://cars");//判断文件是否存在  不存在就创建一个
			if(!f.exists())
				f.mkdirs();
			 newname = System.currentTimeMillis()+suffix;//随机生成文件名+后缀
			part.write("d://cars//"+newname);//上传：使用流的方式上传到磁盘
			}
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newname;
	}

}

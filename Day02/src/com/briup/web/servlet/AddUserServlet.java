package com.briup.web.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.web.Util.entity.Gender;
import com.briup.web.entity.User;
import com.briup.web.service.impl.ServiceImpl;

/**
 * 添加用户的类
 * @author wangfali
 *@version 1.0
 *@date 2016年11月30日
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 并流
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 解决乱码问题
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		//自由生成编号
		String idString = UUID.randomUUID().toString().replace("-", "");
		//接收参数
		String nameString = request.getParameter("name");
		String phoneString = request.getParameter("phone");
		String emailString = request.getParameter("email");
		String sex = request.getParameter("sex");
		String qqString = request.getParameter("qq");
		//封装对象
		Gender sex1=null;
		//判断对象的性别
		if("man".equals(sex)){
			sex1=Gender.man;
		}else if("woman".equals(sex)){
			sex1=Gender.woman;
		}
		try {
			//将对象进行保存
			User user = new User(nameString, phoneString, sex1, qqString, emailString, idString);
			new ServiceImpl().addUser(user);
		} catch (Exception e) {
			// 页面发生跳转 将报错信息返回
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/addUser.jsp").forward(request, response);
			//终止执行
			return;
		}
		response.sendRedirect(request.getContextPath()+"/ListUserServlet");
	}

}

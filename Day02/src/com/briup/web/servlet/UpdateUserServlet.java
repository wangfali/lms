package com.briup.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.web.Util.entity.Gender;
import com.briup.web.entity.User;
import com.briup.web.service.impl.ServiceImpl;

/**
 * 更新联系人信息
 * @author wangfali
 *@version 1.0
 *@date 2016年11月30日
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//并流
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 解决乱码问题
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		//获取对象参数
		String idString = request.getParameter("id");
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
		//调用方法进行对象更新
		new ServiceImpl().updateUser(new User(nameString, phoneString, sex1, qqString, emailString, idString));
		//页面的转发
		response.sendRedirect(request.getContextPath()+"/ListUserServlet");
	}

}

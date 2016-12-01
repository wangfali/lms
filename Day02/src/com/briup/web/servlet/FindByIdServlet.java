package com.briup.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.web.entity.User;
import com.briup.web.service.impl.ServiceImpl;

/**
 * 通过id查找对象
 * @author wangfali
 *@version 1.0
 *@date 2016年11月30日
 */
@WebServlet("/FindByIdServlet")
public class FindByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindByIdServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取id参数
		String idString = request.getParameter("id");
		//调用方法
		User user = new ServiceImpl().findById(idString);
		//将对象返回
		request.setAttribute("user", user);
		//页面转发
		request.getRequestDispatcher("/UpdateUser.jsp").forward(request, response);
	}

}

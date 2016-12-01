在这项目中的总结：
	1.关于路径的问题<form action="UpdateUserServlet" method="post">
		request.getContextPath()+"/ListUserServlet"
	2.关于测试数据操作的问题
		a.第一步
			UserDao operate=null;//创建接口对象
			@Before
			public void init(){//在这个方法中给对象赋值
				operate=new UserDaoImpl();
			}
		b.第二步
			@Test
			public void testAddUser(){
			User user = new User();
			user.setIdString("123");
			user.setEmailString("wdsxc");
			user.setNameString("dsd");
			user.setPhoneString("weds");
			user.setQqString("ewdsz");
			user.setSex(Gender.man);
			operate.addUser(user);
			}
	3.map集合的遍历问题
		先将集合转换为set集合 生成entity对象  然后就可以遍历出来
	4.web.xml文件的配置问题
		1.当使用工具的注释@WebServlet("/AddUserServlet")时不需要配置文件
		2.文件配置类的路径问题 直接复制文件的路径然后将后缀名去掉
	5.项目心得：
		对xml文件的操作还是不太熟练，这次出错的地方就在于xml文件的操作上。
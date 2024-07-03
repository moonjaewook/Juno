package com.good.juno.command.admin;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.good.juno.dao.AdminDao;

public class BranchRegister implements BCommand {

	private SqlSession sqlSession;

	@Autowired
	public BranchRegister(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void execute(Model model) {

		AdminDao dao = sqlSession.getMapper(AdminDao.class);
		
		Map<String, Object> map = model.asMap();

		System.out.println(111);
		MultipartHttpServletRequest request = (MultipartHttpServletRequest) map.get("request");

		MultipartFile branch_img = request.getFile("branch_img");

		System.out.println(request.getParameter("branchName"));

		
		String realFolder = "";
		String saveFolder = "resources/productupload";

		realFolder = request.getSession().getServletContext().getRealPath(saveFolder);
		System.out.println(222);

		
		java.io.File uploadDir = new java.io.File(realFolder);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		System.out.println(333);

		int result = 0;

		try {
			request.setCharacterEncoding("UTF-8");

			String filename1 = null;

			if (branch_img != null && !branch_img.isEmpty()) {
				filename1 = branch_img.getOriginalFilename();
				branch_img.transferTo(new java.io.File(realFolder + "/" + filename1));
			}

			result = dao.branch_register(request.getParameter("branchName"), request.getParameter("address"),
					request.getParameter("openingTime"), request.getParameter("parking"),
					request.getParameter("contact"), filename1);

			System.out.println("지점 추가 결과:" + result);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

package com.good.juno.command.admin;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.good.juno.dao.AdminDao;

public class DesignerRegister implements BCommand {

	private SqlSession sqlSession;

	@Autowired
	public DesignerRegister(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void execute(Model model) {

		AdminDao dao = sqlSession.getMapper(AdminDao.class);

		Map<String, Object> map = model.asMap();

		System.out.println(111);
		MultipartHttpServletRequest request = (MultipartHttpServletRequest) map.get("request");

		MultipartFile profile = request.getFile("profile");

		System.out.println(request.getParameter("id"));

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

			if (profile != null && !profile.isEmpty()) {
				filename1 = profile.getOriginalFilename();
				profile.transferTo(new java.io.File(realFolder + "/" + filename1));
			}

			result += dao.memberInsert(request.getParameter("id"), request.getParameter("pw"),
					request.getParameter("email"), request.getParameter("name"),
					request.getParameter("year") + request.getParameter("month") + request.getParameter("day"),
					request.getParameter("intro"), "디자이너");

			result += dao.designer_register(request.getParameter("id"), request.getParameter("name"),
					request.getParameter("intro"), filename1, dao.branchid(request.getParameter("branchName")));

			System.out.println("디자이너 insert(기대값=2):" + result);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

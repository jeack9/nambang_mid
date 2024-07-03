package co.nambang.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.nambang.common.Control;
import co.nambang.member.vo.MemberVO;

public class Woon16 implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String savePath = "C:\\Users\\admin\\git\\nambang_mid\\CheckNambang\\src\\main\\webapp\\image";
		int maxSize = 1024*1024*5;
		String encoding = "utf-8";
		MultipartRequest mr =	new MultipartRequest(req, savePath, maxSize, encoding, new DefaultFileRenamePolicy());
		
		HttpSession session = req.getSession();
		MemberVO login = (MemberVO)session.getAttribute("login");
		
		String userId = login.getUserId();
		
		String hugiContent = req.getParameter("hugiContent");
		String productCode = req.getParameter("productCode");
		String opNo = req.getParameter("opNo");
		String img = mr.getFilesystemName("img");
		
		System.out.println(userId);
		System.out.println(hugiContent);
		System.out.println(productCode);
		System.out.println(opNo);
		System.out.println(img);
	}

}

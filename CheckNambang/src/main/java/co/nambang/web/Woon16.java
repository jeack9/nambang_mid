package co.nambang.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.nambang.common.Control;
import co.nambang.hugi.service.HugiService;
import co.nambang.hugi.service.HugiServiceImpl;
import co.nambang.hugi.vo.HugiVO;
import co.nambang.member.vo.MemberVO;

public class Woon16 implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String savePath = "C:\\Users\\admin\\git\\nambang_mid\\CheckNambang\\src\\main\\webapp\\image";
		int maxSize = 1024*1024*5;
		String encoding = "utf-8";
		MultipartRequest mr =	new MultipartRequest(req, savePath, maxSize, encoding, new DefaultFileRenamePolicy());
		System.out.println("3");

		HttpSession session = req.getSession();
		MemberVO login = (MemberVO)session.getAttribute("login");
		String userId = login.getUserId();
		
		String hugiContent = mr.getParameter("hugiContent");
		String productCode = mr.getParameter("productCode");
		String opNo = mr.getParameter("opNo");
		String img = mr.getFilesystemName("hugiImage");
				
		HugiVO hvo = new HugiVO();
		
		hvo.setUserId(userId);
		hvo.setHugiContent(hugiContent);
		hvo.setProductCode(productCode);
		hvo.setOpNo(opNo);
		hvo.setHugiImage(img);
		
		System.out.println("4");
		HugiService svc = new HugiServiceImpl();
		
		if(svc.hugiAdd(hvo)) {
			System.out.println("yes");
			resp.getWriter().print("{\"retCode\" : \"Good\", \"retMsg\": \"Win\"}");
		}else {
			System.out.println("no");
			resp.getWriter().print("{\"retCode\" : \"Bad\", \"retMsg\": \"Lose\"}");			
		}
		
	}

}

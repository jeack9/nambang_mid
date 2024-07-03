package co.nambang.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.nambang.common.Control;

public class Woon16 implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String savePath = "C:\\Users\\admin\\git\\nambang_mid\\CheckNambang\\src\\main\\webapp\\image";
		int maxSize = 1024*1024*5;
		String encoding = "utf-8";
		MultipartRequest mr =	new MultipartRequest(req, savePath, maxSize, encoding, new DefaultFileRenamePolicy());
		
		
		
		
	}

}

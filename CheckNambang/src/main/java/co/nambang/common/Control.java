package co.nambang.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;

public interface Control {
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}

package kr.co.rland.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class HomeController {

	@PostMapping("upload")
	@ResponseBody
	public String upload(MultipartFile[] imgs, HttpServletRequest request) throws IllegalStateException, IOException {

		for (int i = 0; i < imgs.length; i++) 
		{
			MultipartFile img = imgs[i];
			
			if(img.isEmpty())
				continue;
			
			String urlPath = "/image/menu/" + img.getOriginalFilename();
			String realPath = request.getServletContext().getRealPath(urlPath);// this.getClass().getResource("");
		
			//		realPath = this.getClass().getResource("/").getPath();

			System.out.println(realPath);

			//		InputStream fis = img.getInputStream();		
			//		OutputStream fos = new FileOutputStream(realPath);		
			//		// 1024 저장공간
			//		byte[] buf = new byte[1024];
			//		int size = 1024;
			//		// buf가 다 채워지지 않더라도 채운만큼만 저장될 수 있도록
			//		while((size = fis.read(buf))!=-1)
			//			fos.write(buf, 0, size);
			//		
			//		fis.close();
			//		fos.close();

			img.transferTo(new File(realPath));
		}

//		System.out.println(img.getOriginalFilename());
		return "ok";
	}

	@RequestMapping("index")
	public String index(Model model, HttpServletResponse response) throws UnsupportedEncodingException {

		String data = URLEncoder.encode("cookie래요~", "utf-8");

		System.out.println(data);

		Cookie cookie = new Cookie("my", data);
		response.addCookie(cookie);

		model.addAttribute("data", data);

		return "index";
	}

}

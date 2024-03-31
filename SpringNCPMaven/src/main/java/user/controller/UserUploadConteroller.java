package user.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import user.bean.UserImageDTO;
import user.service.ObjectStorageService;
import user.service.UserUploadService;

@Controller
@RequestMapping(value = "user")
public class UserUploadConteroller {

	@Autowired
	private UserUploadService userUploadService;
	@Autowired
	private ObjectStorageService objectStorageService;
	private String bucketName = "bitcamp-6th-bucket-106";

	@GetMapping(value = "uploadForm")
	public String uploadForm() {
		return "user/uploadForm";
	}

	// ----- name="img" 1개일 경우 -------
	/*
	 * @PostMapping(value="upload")
	 * 
	 * @ResponseBody public String upload(@ModelAttribute UserImageDTO userImageDTO,
	 * 
	 * @RequestParam MultipartFile img, HttpSession session) {
	 * 
	 * //가상폴더 String filePath_lier =
	 * "D:/Spring/workspace/Chapter06_Web/src/main/webapp/WEB-INF/storage";
	 * 
	 * //실제폴더
	 * //D:/Spring/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/
	 * wtpwebapps/Chapter06_Web/WEB-INF/storage String filePath =
	 * session.getServletContext().getRealPath("WEB-INF/storage");
	 * System.out.println("실제폴더 = " + filePath);
	 * 
	 * //이미지 이름 String fileName = img.getOriginalFilename();
	 * 
	 * //파일 복사 //File file = new File(filePath_lier, fileName); File file = new
	 * File(filePath, fileName);
	 * 
	 * try { img.transferTo(file);
	 * 
	 * } catch (IllegalStateException e) { e.printStackTrace(); } catch (IOException
	 * e) { e.printStackTrace(); }
	 * 
	 * userImageDTO.setImage1(fileName);
	 * 
	 * return "<img src='/Chapter06_Web/storage/" + fileName + "'/>"; }
	 */

	// ----- name="img" 2개 이상일 경우 -------
	/*
	 * @PostMapping(value="upload")
	 * 
	 * @ResponseBody public String upload(@ModelAttribute UserImageDTO userImageDTO,
	 * 
	 * @RequestParam MultipartFile[] img, HttpSession session) {
	 * 
	 * //실제폴더
	 * //D:/Spring/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/
	 * wtpwebapps/Chapter06_Web/WEB-INF/storage String filePath =
	 * session.getServletContext().getRealPath("WEB-INF/storage");
	 * System.out.println("실제폴더 = " + filePath);
	 * 
	 * String fileName; File file; String result = "";
	 * 
	 * if(img[0] != null) { fileName = img[0].getOriginalFilename(); file = new
	 * File(filePath, fileName);
	 * 
	 * try { img[0].transferTo(file);
	 * 
	 * } catch (IllegalStateException e) { e.printStackTrace(); } catch (IOException
	 * e) { e.printStackTrace(); }
	 * 
	 * result += "<span><img src='/Chapter06_Web/storage/" + fileName +
	 * "'/></span>"; }//if
	 * 
	 * if(img[1] != null) { fileName = img[1].getOriginalFilename(); file = new
	 * File(filePath, fileName);
	 * 
	 * try { img[1].transferTo(file);
	 * 
	 * } catch (IllegalStateException e) { e.printStackTrace(); } catch (IOException
	 * e) { e.printStackTrace(); }
	 * 
	 * result += "<span><img src='/Chapter06_Web/storage/" + fileName +
	 * "'/></span>"; }//if
	 * 
	 * return result; }
	 */

	// ----- 한번에 1개 선택 또는 여러 개 선택 -------
	@PostMapping(value = "upload")
	@ResponseBody
	public String upload(@ModelAttribute UserImageDTO userImageDTO, @RequestParam("img[]") List<MultipartFile> list,
			HttpSession session) {

		// 실제폴더
		// D:/Spring/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Chapter06_Web/WEB-INF/storage
		String filePath = session.getServletContext().getRealPath("WEB-INF/storage");
		System.out.println("실제폴더 = " + filePath);

		String imageFileName = "";
		String imageOriginalFileName = "";
		File file;
		String result = "";

		// 파일명만 모아서 DB로 보내기
		List<UserImageDTO> userImageList = new ArrayList<>();

		for (MultipartFile img : list) {
			imageOriginalFileName = img.getOriginalFilename();

			imageFileName = objectStorageService.uploadFile(bucketName, "storage/", img);

			file = new File(filePath, imageOriginalFileName);

			try {
				img.transferTo(file);

			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				result += "<span><img src='/mini/storage/" + URLEncoder.encode(imageOriginalFileName, "UTF-8")
						+ "'width='200' height='200'/></span> <input type='button' value='리스트' onclick=\"location.href='/mini/user/uploadList'\">";
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			UserImageDTO userImageDTO2 = new UserImageDTO();
			userImageDTO2.setImageName(userImageDTO.getImageName());
			userImageDTO2.setImageContent(userImageDTO.getImageContent());
			userImageDTO2.setImageFileName(imageFileName);// UUID
			userImageDTO2.setImageOriginalName(imageOriginalFileName);

			userImageList.add(userImageDTO2);

		} // for

		// DB
		userUploadService.upload(userImageList);

		return result;
	}
	
	
	@GetMapping(value = "uploadList")
	public String uploadList() {
		return "user/uploadList";
	}

	@PostMapping(value = "getUploadList")
	@ResponseBody
	public List<UserImageDTO> getUploadList() {
		return userUploadService.getUploadList();
	}

		
	
	@PostMapping(value = "getUploadUser")
	@ResponseBody
	public UserImageDTO uploadUpdate(@RequestParam(value = "seq") String seq) {

		return userUploadService.getUploadUser(seq);
	}
	
	
	@GetMapping(value="uploadView")
	public String uploadView(@RequestParam(value = "seq") String seq,Model model) {
		
		model.addAttribute("seq",seq);
		
		return "user/uploadView";
	}
	
	@GetMapping(value = "uploadUpdateForm")
	public String uploadUpdateForm(@RequestParam(value = "seq") String seq, Model model) {
		
		model.addAttribute("seq", seq);
		
		return "user/uploadUpdateForm";
	}
	
	
	@PostMapping(value = "uploadUpdate",produces="text/html; charset=UTF-8")
	@ResponseBody
	public String uploadUpdate(@ModelAttribute UserImageDTO userImageDTO, @RequestParam("img") MultipartFile img,
			@RequestParam(value="beforeFileName")String beforeFileName, HttpSession session) {

		// 가상폴더 String filePath_lier =
		// "D:/Spring/workspace/Chapter06_Web/src/main/webapp/WEB-INF/storage";

		// 실제폴더
		// D:/Spring/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Chapter06_Web/WEB-INF/storage
		String filePath = session.getServletContext().getRealPath("WEB-INF/storage");
		System.out.println("실제폴더 = " + filePath);

		String imageFileName = "";
		String imageOriginalFileName = "";
		imageOriginalFileName = img.getOriginalFilename();
		
		objectStorageService.deleteFile(bucketName, beforeFileName);
		imageFileName = objectStorageService.uploadFile(bucketName, "storage/", img);
		
		// 파일 복사 //File file = new File(filePath_lier, fileName); 
		File file = new File(filePath, imageOriginalFileName);

		try {
			img.transferTo(file);

		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(userImageDTO.getSeq());
		System.out.println(userImageDTO.getImageName());
		System.out.println(userImageDTO.getImageContent());
		System.out.println(imageOriginalFileName);
		
		UserImageDTO userImageDTO2 = new UserImageDTO();
		userImageDTO2.setImageName(userImageDTO.getImageName());
		userImageDTO2.setImageContent(userImageDTO.getImageContent());
		userImageDTO2.setImageFileName(imageFileName);// UUID
		userImageDTO2.setImageOriginalName(imageOriginalFileName);
		userImageDTO2.setSeq(userImageDTO.getSeq());
		userUploadService.uploadUpdate(userImageDTO2);
		try {
			return "<span><img src='/mini/storage/" + URLEncoder.encode(imageOriginalFileName, "UTF-8")
			+ "'width='200' height='200'/></span> <input type='button' value='목록' onclick=\"location.href='/mini/user/uploadList'\">";
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		//모든 처리는 service로 Controller는 요청과 응답만 받고 service의 interface로 메소드만 요청
	}
	
	/*
	 * public String uploadUpdateSUB(@ModelAttribute UserImageDTO
	 * userImageDTO, @RequestParam("img") MultipartFile img) {
	 * 
	 * 
	 * userUploadService.uploadUpdateSUB(userImageDTO, img);
	 * 
	 * 
	 * return ""; }
	 */
			
	
	@PostMapping(value="uploadDelete")
	@ResponseBody
	public void uploadDelete(@RequestParam(value="seq") String seq) {
		
		String beforeFileName = userUploadService.getDeleteFileName(seq); 
		objectStorageService.deleteFile(bucketName, beforeFileName);
		userUploadService.uploadDelete(seq);
		
	}
	@PostMapping(value="uploadDeleteAll")
	@ResponseBody
	public void uploadDeleteAll(@RequestParam String[] check) {
		
		userUploadService.uploadDeleteAll(check);
	}
	
}

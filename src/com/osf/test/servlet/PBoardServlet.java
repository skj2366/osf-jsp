package com.osf.test.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class PBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static String savePath = "D:\\study\\workspace\\osf-jsp\\WebContent\\upload";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		uri = uri.replace("/pboard/", "");
		
		if("insert".equals(uri)) {
			DiskFileItemFactory dfiFactory = new DiskFileItemFactory();//Factory를 쓴다면 왠만해서줄이지 않고 Factory를 변수명에 전부 넣어서 사용.
			//DiskFileItemFactory => common
			//dfiFactory.setRepository(new File(System.getProperty("java.io.tmpdir")));// File => java.io
			String tmpPath = System.getProperty("java.io.tmpdir"); //가상경로를 tmpPath에 집어넣고
			File tmpFile = new File(tmpPath); //new File이라는 생성자를 통해서 tmpFile을 (폴더) 생성
			dfiFactory.setRepository(tmpFile);  //야 니가 여기 임시파일 디렉토리로 써!
			//여기까지가 tmp 디렉토리를 만드는 과정
			//여기부터 몇메가나 기억할지!
			dfiFactory.setSizeThreshold(10*1024*1024);//임마는 바이트 단위.default 1MB;  지금은 10MB(10*1024*1024)로 설정.
			
			/*ServletFileUpload sfu;//파싱하기 위한 객체 . tmp 디렉토리를 만들어야해 ! // ServletFileUpload => common
			*/
			ServletFileUpload sfu = new ServletFileUpload(dfiFactory);//tmp디렉토리를 가지고 임마를 쓴다.
			//sfu.setHeaderEncoding("utf-8");//헤더인코딩을 utf-8로 쓰겠다! 지만 ... 밑에서 getString()으로 설정 가능해서 ... 지워주자 ^^ 상큼하게
			sfu.setSizeMax(20*1024*1024);//전체의 Maxsize을 얼마나 할꺼냐?
			sfu.setFileSizeMax(20*1024*1024);//파일 하나의 Maxsize을 얼마나 할꺼냐?
			//고로 위의 세팅은 파일 하나만 올리겠다는 의미 bcuz 사이즈맥스와 파일사이즈맥스를 같게 뒀기에 ..
			try {
				List<FileItem> fileList = sfu.parseRequest(request);//FileItem => common , List => 기존에 쓰던거 ^^
				//.parseRequest() 메서드 자체가 Exception을 강제하는 메서드이다.
				
				for(int i = 0;i<fileList.size();i++) {
					FileItem fi = fileList.get(i);
					if(fi.isFormField()) {//type = file이 아닌애들이 true
						
					}else {//여기가 file save!
						String fileName = fi.getName();
						//File saveFile = new File(savePath + "\\" + fileName);
						File saveFile = new File(savePath + File.separator + fileName);//원래는 OS가 다를수있으므로 파일세퍼레이터를 써주는게 맞다.
						fi.write(saveFile);
					}
//					System.out.println("name : " + fileList.get(i).getFieldName());
//					System.out.println("value : " + fileList.get(i).getString("utf-8"));
//					System.out.println(fileList.get(i).isFormField());//폼필드냐 아니냐 ? 폼필드면 true, 아니면 false File은 폼필드가 아니라서 File일 경우 false!
//					//인풋태그 타입들중 File을 제외한 나머지는 폼필드로 인정되어서 true
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("update".equals(uri)) {
			
		}else if("delete".equals(uri)) {
			
		}else {
			
		}
	}
	
	public static void main(String[] args) {
		System.out.println("임시경로 : " + System.getProperty("java.io.tmpdir"));//가상경로
	}

}

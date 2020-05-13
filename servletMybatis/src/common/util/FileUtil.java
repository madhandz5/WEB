/**
 * @PackageName: common.util
 * @FileName : File.java
 * @Date : 2020. 4. 22.
 * @프로그램 설명 : 
 * @author 
 */
package common.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.frontcontroller.ModelAndView;

/**
 * @PackageName: common.util
 * @FileName : File.java
 * @Date : 2020. 4. 22.
 * @프로그램 설명 : 
 * @author 
 */
public class FileUtil {
	
	public UploadFile fileUpload(String uploadFolder, HttpServletRequest request) {
		
		UploadFile uploadFile = new UploadFile();
		
		// 업로드할 파일의 용량 제한 : 10Mbyte로 제한한다면
		int maxSize = 1024 * 1024 * 10;
		String originFileName = "";
		String renameFileName = "";
		
		// 해당 컨테이너의 구동중인 웹 애플리케이션의 루트 경로 알아냄
		String root = request.getSession().getServletContext().getRealPath("/");
		String savePath = root + uploadFolder;
		
		try {
			// request 를 MultipartRequest 객체로 변환함
			// MultipartRequest의 객체가 생성됨과 동시에 파일 업로드가 이루어 진다.
			MultipartRequest mrequest = 
					new MultipartRequest(request,savePath, maxSize, "UTF-8",
					new DefaultFileRenamePolicy());
		
			originFileName = mrequest.getFilesystemName("file");
			
			if (originFileName != null) {
				//업로도된 파일명을 "년월일시분초.확장자" 로 변경함
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				renameFileName = sdf.format(new java.sql.Date(System.currentTimeMillis())) + "."
				+ originFileName.substring(originFileName.lastIndexOf(".") + 1);
				
				// 파일명 바꾸기하려면 File 객체의 renameTo() 사용함
				File originFile = new File(savePath + "\\" + originFileName);
				File renameFile = new File(savePath + "\\" + renameFileName);
				originFile.renameTo(renameFile);
			}
		
			uploadFile.setIsSuccess(true);
			uploadFile.setOriginalFilename(originFileName);
			uploadFile.setRenameFileName(renameFileName);
			uploadFile.setSavePath(savePath);
			uploadFile.setMrequest(mrequest);;
		
		} catch (IOException e) {
			
			uploadFile.setIsSuccess(false);
			uploadFile.setOriginalFilename(originFileName);
			
		}
		
		return uploadFile;
	}
	
	public boolean fileDownload(ModelAndView mav, HttpServletResponse response) {
		
		boolean res = false;
		
		//file객체 생성
		File downFile = new File((String) mav.getData().get("path"));
		String ofname = (String) mav.getData().get("ofname");
		
		//헤더 설정 + 파일 이름 인코딩
		try {
			response.setHeader("Content-Disposition", "attachment; filename=" + 
					URLEncoder.encode(ofname,"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setContentLength((int)downFile.length());
		
		//클라이언트로 내보낼 출력 스트림 생성
		ServletOutputStream downOut;
		
		try {
			
			downOut = response.getOutputStream();
			BufferedInputStream bin = new BufferedInputStream(
					new FileInputStream(downFile));
			
			int read = 0;
			while((read = bin.read()) != -1){
				downOut.write(read);
				downOut.flush();
			}
			
			downOut.close();
			bin.close();
			res = true;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
}

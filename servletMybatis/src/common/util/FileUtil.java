/**
 * @PackageName: common.util
 * @FileName : File.java
 * @Date : 2020. 4. 22.
 * @���α׷� ���� : 
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
 * @���α׷� ���� : 
 * @author 
 */
public class FileUtil {
	
	public UploadFile fileUpload(String uploadFolder, HttpServletRequest request) {
		
		UploadFile uploadFile = new UploadFile();
		
		// ���ε��� ������ �뷮 ���� : 10Mbyte�� �����Ѵٸ�
		int maxSize = 1024 * 1024 * 10;
		String originFileName = "";
		String renameFileName = "";
		
		// �ش� �����̳��� �������� �� ���ø����̼��� ��Ʈ ��� �˾Ƴ�
		String root = request.getSession().getServletContext().getRealPath("/");
		String savePath = root + uploadFolder;
		
		try {
			// request �� MultipartRequest ��ü�� ��ȯ��
			// MultipartRequest�� ��ü�� �����ʰ� ���ÿ� ���� ���ε尡 �̷�� ����.
			MultipartRequest mrequest = 
					new MultipartRequest(request,savePath, maxSize, "UTF-8",
					new DefaultFileRenamePolicy());
		
			originFileName = mrequest.getFilesystemName("file");
			
			if (originFileName != null) {
				//���ε��� ���ϸ��� "����Ͻú���.Ȯ����" �� ������
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				renameFileName = sdf.format(new java.sql.Date(System.currentTimeMillis())) + "."
				+ originFileName.substring(originFileName.lastIndexOf(".") + 1);
				
				// ���ϸ� �ٲٱ��Ϸ��� File ��ü�� renameTo() �����
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
		
		//file��ü ����
		File downFile = new File((String) mav.getData().get("path"));
		String ofname = (String) mav.getData().get("ofname");
		
		//��� ���� + ���� �̸� ���ڵ�
		try {
			response.setHeader("Content-Disposition", "attachment; filename=" + 
					URLEncoder.encode(ofname,"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setContentLength((int)downFile.length());
		
		//Ŭ���̾�Ʈ�� ������ ��� ��Ʈ�� ����
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

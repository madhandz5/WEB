/**
 * @PackageName: common.util
 * @FileName : UploadFile.java
 * @Date : 2020. 4. 22.
 * @프로그램 설명 : 
 * @author 
 */
package common.util;

import com.oreilly.servlet.MultipartRequest;

/**
 * @PackageName: common.util
 * @FileName : UploadFile.java
 * @Date : 2020. 4. 22.
 * @프로그램 설명 : 
 * @author 
 */
public class UploadFile {
	
	private boolean isSuccess = false;	
	private String originalFilename;
	private String renameFileName;
	private String savePath;
	private MultipartRequest mrequest;
	
	public boolean isSuccess() {
		return isSuccess;
	}
	
	public void setIsSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	public String getOriginalFilename() {
		return originalFilename;
	}
	
	public void setOriginalFilename(String originalFilename) {
		this.originalFilename = originalFilename;
	}
	
	public String getRenameFileName() {
		return renameFileName;
	}
	
	public void setRenameFileName(String renameFileName) {
		this.renameFileName = renameFileName;
	}
	
	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public MultipartRequest getMrequest() {
		return mrequest;
	}

	public void setMrequest(MultipartRequest mrequest) {
		this.mrequest = mrequest;
	}

	

}

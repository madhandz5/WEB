/**
 * @PackageName: common.util
 * @FileName : TableStatusCode.java
 * @Date : 2020. 5. 4.
 * @���α׷� ���� : 
 * @author 
 */
package common.util;

/**
 * @PackageName: common.util
 * @FileName : TableStatusCode.java
 * @Date : 2020. 5. 4.
 * @���α׷� ���� : 
 * @author 
 */
public enum TableStatusCode {
	
	BASICMEMBER("�Ϲ�ȸ��",1001,1),
	SINCERITYMEMBER("����ȸ��",1002,2),
	SUPERMEMBER("���ȸ��",1003,3),
	VIPMEMBER("VIP",1004,4);
	
	private String gradeTitle;
	private int code;
	private int extentCnt;
	
	TableStatusCode(String gradeTitle, int code, int extentCnt){
		this.gradeTitle = gradeTitle;
		this.code = code;
		this.extentCnt = extentCnt;
	}
	
	public String getGradeTitle() {
		return gradeTitle;
	}

	public int getCode() {
		return code;
	}

	public int getExtentCnt() {
		return extentCnt;
	}
	
	
}

/**
 * @PackageName: common.exception
 * @FileName : Status404.java
 * @Date : 2020. 4. 13.
 * @프로그램 설명 : 
 * @author 
 */
package common.exception;

import javax.servlet.ServletException;

/**
 * @PackageName: common.exception
 * @FileName : Status404.java
 * @Date : 2020. 4. 13.
 * @프로그램 설명 : 
 * @author 
 */
public class Status404 extends ServletException{

	private static final long serialVersionUID = -4191760156152350510L;

	public Status404(String errMsg) {
		super(errMsg);
	}
	
}

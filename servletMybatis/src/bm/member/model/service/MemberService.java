package bm.member.model.service;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.text.html.parser.DTD;

import bm.member.model.dao.MemberDao;
import bm.member.model.vo.Member;
import common.JDBCTemplate;

public class MemberService {

	MemberDao mdao = new MemberDao();
	JDBCTemplate jdt = JDBCTemplate.getInstance();

	public String idCheck(String id) {

		String res = "";
		Connection conn = jdt.getConnection();

		try {
			res = mdao.idCheck(conn, id);
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			jdt.close(conn);
		}
		return res;
	}

	public void joinEmailCheck(Member m) {

		//구글에 smtp서버를 사용하기 위한 인증정보
		PasswordAuthentication pa = new PasswordAuthentication("madhandz5", "Vlylatte114!@#");

		//사용할 smtp서버 설정
		//smtp : send mail transfer protocol
		//설정하지않으면 우리가 smtp서버여야 한다.
		Properties prop = System.getProperties();
		//tls(ssl)암호화 사용여부
		prop.put("mail.smtp.starttls.enable", "true");
		//구글 smtp서버사용
		prop.put("mail.smtp.host", "smtp.gmail.com");
		//smtp서버에 접근할 때 사용자 인증
		prop.put("mail.smtp.auth", "true");
		//smtp서버의 포트번호
		prop.put("mail.smtp.port", "587");

		Session session = Session.getDefaultInstance(prop, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return pa;
			}
		});

		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("admin@uclass.co.kr", "UCLASS관리자"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(m.getM_email(), m.getM_id()));
			msg.setSubject(m.getM_id() + "님 우리 사이트 가입을 환영합니다.");
			//msg.setText("This is a test");

			String htmlBody = "<form action='http://localhost:8787/servletBM/member/joinimple.do'"
					+ "method='post'><h3>회원가입완료를 원하시면 버튼을 클립하세요</h3>" + "<input type='hidden' value='" + m.getM_id()
					+ "' name ='userId'>" + "<input type='hidden' value= '" + m.getM_password() + "' name ='userPwd'>"
					+ "<input type='hidden' value= '" + m.getM_email() + "' name ='m_email'>"
					+ "<input type='hidden' value= '" + m.getM_tell() + "' name ='m_tell'>"
					+ "<button type='submit'>회원가입하기</button></form>";
			/*byte[] attachmentData = null;*/
			Multipart mp = new MimeMultipart();

			MimeBodyPart htmlPart = new MimeBodyPart();
			htmlPart.setContent(htmlBody, "text/html; charset=utf-8");
			mp.addBodyPart(htmlPart);

			/*MimeBodyPart attachment = new MimeBodyPart();
			InputStream attachmentDataStream = new ByteArrayInputStream(attachmentData);
			attachment.setFileName("manual.pdf");
			attachment.setContent(attachmentDataStream, "application/pdf");
			mp.addBodyPart(attachment);
			*/
			msg.setContent(mp);
			Transport.send(msg);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public int insertMember(Member m) {

		int res = 0;

		Connection conn = jdt.getConnection();

		try {
			res = mdao.insertMember(conn, m);
			jdt.commit(conn);

		} catch (SQLException e) {
			jdt.rollback(conn);
			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}

		return res;
	}

	public Member logInImple(String id, String pw) {
		Connection conn = jdt.getConnection();
		Member member = null;

		try {
			member = mdao.logInImple(conn, id, pw);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}

		return member;
	}

	public int modifyPw(String id, String newPwd) {
		int res = 0;

		Connection conn = jdt.getConnection();

		try {
			res = mdao.modifyPw(conn, id, newPwd);
			
			if(res >= 1) {
				jdt.commit(conn);
			}else {
				jdt.rollback(conn);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}

		return res;

	}

}

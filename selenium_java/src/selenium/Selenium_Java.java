package selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class Selenium_Java implements Job {

	WebDriver driver = new ChromeDriver();

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		selenium();
	}

	public void selenium() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		try {
			driver.get("http://www.letskorail.com/ebizprd/EbizPrdTicketpr21100W_pr21110.do");

			// 기차 종류 고르기
			js("document.querySelector(\"#selGoTrainRa00\")", "document.querySelector(\"#selGoTrainRa00\").click()");
			// 도착역 고르기
			js("document.querySelector(\"#get\")", "document.querySelector(\"#get\").value='창원'");
			// 출발일 고르기
			js("document.querySelector(\"#s_day > option:nth-child(30)\")",
					"document.querySelector(\"#s_day > option:nth-child(30)\").selected=true");
			// 출발시간 고르기
			js("document.querySelector(\"#s_hour > option:nth-child(14)\")",
					"document.querySelector(\"#s_hour > option:nth-child(14)\").selected=true");
			// 전송
			js("document.querySelector(\"#center > form > div > p > a\")",
					"document.querySelector(\"#center > form > div > p > a\").click()");
			// 좌석선택하기
			js("document.querySelector(\"#tableResult > tbody > tr:nth-child(1) > td:nth-child(6) > a:nth-child(3)\")",
					"document.querySelector(\"#tableResult > tbody > tr:nth-child(1) > td:nth-child(6) > a:nth-child(3)\").click()");

			// 현재 드라이버 위치 저장
			String windowHandle = driver.getWindowHandle();
			// driver를 iframe으로
			driver.switchTo().frame("embeded-modal-traininfo");
			Thread.sleep(500);

			// 첫번째 안내창
			js("document.querySelector(\"body > div > div.cont > p.btn_c > a\")",
					"document.querySelector(\"body > div > div.cont > p.btn_c > a\").click()");
			// 돌아오기

			driver.switchTo().window(windowHandle);
			Thread.sleep(500);

			driver.switchTo().frame(1);
			Thread.sleep(500);
			// 좌석 선택하기
			js("document.querySelector(\"#SSeat\")",
					"Seat_OnClick(document.querySelector(\"#SSeat\"), '41', '#a193e2', '11A','','',encodeURI(''));");
			// 선택좌석예약하기
			js("document.querySelector(\"#Confirm > a\")", "document.querySelector(\"#Confirm > a\").click()");

			// driver 윈도우로 바인드하기
			Thread.sleep(500);
			driver.switchTo().window(windowHandle);

			js("document.querySelector(\"#contents > div.content > div.cont_info > div.cont_login > div.box_rig > ul > li:nth-child(1) > a\")",
					"document.querySelector(\"#contents > div.content > div.cont_info > div.cont_login > div.box_rig > ul > li:nth-child(1) > a\").click()");

			Thread.sleep(500);
			driver.switchTo().frame(0);

			js("document.querySelector(\"body > div > div.cont > p.btn_c > a.btn_blue_ang\")",
					"document.querySelector(\"body > div > div.cont > p.btn_c > a.btn_blue_ang\").click()");

			driver.switchTo().window(windowHandle);
			Thread.sleep(500);

			js("document.querySelector(\"#name\")", "document.querySelector(\"#name\").value='하명도'");

			js("document.querySelector(\"#contents > div.content > form > div > table > tbody > tr:nth-child(2) > td > input:nth-child(2)\")",
					"document.querySelector(\"#contents > div.content > form > div > table > tbody > tr:nth-child(2) > td > input:nth-child(2)\").value='9234'");

			js("document.querySelector(\"#contents > div.content > form > div > table > tbody > tr:nth-child(2) > td > input:nth-child(3)\")",
					"document.querySelector(\"#contents > div.content > form > div > table > tbody > tr:nth-child(2) > td > input:nth-child(3)\").value='8248'");
			js("document.querySelector(\"#pw\")", "document.querySelector(\"#pw\").value='86245'");
			js("document.querySelector(\"#pw_s\")", "document.querySelector(\"#pw_s\").value='86245'");

			js("document.querySelector(\"#contents > div.content > form > div > table > tbody > tr:nth-child(6) > td > label\")",
					"document.querySelector(\"#contents > div.content > form > div > table > tbody > tr:nth-child(6) > td > label\").click()");

			js("document.querySelector(\"#contents > div.content > form > div > div > div:nth-child(3) > input[type=checkbox]\")",
					"document.querySelector(\"#contents > div.content > form > div > div > div:nth-child(3) > input[type=checkbox]\").click()");
			Thread.sleep(500);
			js("document.querySelector(\"#contents > div.content > form > div > p:nth-child(7) > a\")",
					"document.querySelector(\"#contents > div.content > form > div > p:nth-child(7) > a\").click()");
			js("document.querySelector(\"#pw_s\")", "open_win.close();");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 드라이버를 종료(자원해제)
			driver.quit();
		}
	}

	public void js(String obj, String code) {

		JavascriptExecutor jsExe = (JavascriptExecutor) driver;
		System.out.println(obj);
		System.out.println(code);
		String temp = "console.dir(" + obj + ");" + " while(true){if(" + obj + "){" + code + "; break;}}";
		jsExe.executeScript(temp);

		if (ExpectedConditions.alertIsPresent().apply(driver) == null) {

		} else {
			driver.switchTo().alert().accept();
		}

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
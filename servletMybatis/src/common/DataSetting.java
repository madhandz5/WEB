package common;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class DataSetting extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DataSetting() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//클라이언트가 요청 보낸 URI를 저장
		String uri = request.getRequestURI();
		//컨텍스트패스를 저장
        String conPath = request.getContextPath();
        //컨택스트패스 뒷부분만 잘라냄
        String command = uri.substring(conPath.length());
        
        if(command.equals("/data/json")) {
        	addJsonData(request,response);
        }else if(command.equals("/data/webCrawling")){
        	webCrawling();
        }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	private void addJsonData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String isbn = "";
		
		JDBCTemplate jdt = JDBCTemplate.getInstance();
		Connection conn = jdt.getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = "insert into tb_book values(S_B_BNO.nextval,1101,?,?,sysdate,'N',?,?)";
		try {
			pstm = conn.prepareStatement(sql);
			String prefix = getServletContext().getRealPath("/");
			JsonObject jobj = new Gson().fromJson(new FileReader(new File(prefix + "/resources/Book_top100.json")), JsonObject.class);
			JsonArray datas = jobj.getAsJsonArray("DATA");
		
			Iterator itr = (Iterator)datas.iterator();
			
			while(itr.hasNext()) {
				JsonObject bookInfo = (JsonObject) itr.next();
				pstm.setString(1, bookInfo.get("title").getAsString());
				pstm.setString(2, bookInfo.get("author").getAsString());
				pstm.setInt(3, bookInfo.get("cnt").getAsInt());
				isbn = bookInfo.get("isbn").getAsString();
				pstm.setString(4, isbn);
				res = pstm.executeUpdate();
				
				addImage(isbn);
			}
			
			jdt.commit(conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdt.close(pstm);
			jdt.close(conn);
		}
	}
	
	private void addImage(String ISBN) {
		URL url = null;
		
		//HttpURLConnection conn = null;
		HttpsURLConnection conn = null;
	    String jsonData = "";
	    BufferedReader br = null;
	    String query;
	    
	    InputStream is = null;
	    FileOutputStream fos = null;
	    
	    String prefix = getServletContext().getRealPath("/");
		try {
			//query = URLEncoder.encode("비행운", "UTF-8");
			
			url = new URL("https://dapi.kakao.com/v3/search/book?query=" + ISBN +"&target=isbn");
			conn =(HttpsURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Authorization", "KakaoAK 942abf8d21a6b49bd8edc4cd72010ce0");
			conn.connect();
			
			br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			
			String line = "";
			while((line = br.readLine())!= null) {
				jsonData += line;
			}
			
			JsonObject jobj = new Gson().fromJson(jsonData, JsonObject.class);
			JsonArray jarr = jobj.getAsJsonArray("documents");
			JsonObject data = jarr.get(0).getAsJsonObject();
			String src = data.get("thumbnail").getAsString();
			
			BufferedInputStream bis = new BufferedInputStream(new URL(src).openStream());
			fos = new FileOutputStream(prefix + "/resources/img/" + ISBN + ".jpg");
			
			int check = 0;
			while((check = bis.read()) != -1) {
				fos.write(check);
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void webCrawling() throws IOException {
		
		Document doc;
		WebDriver driver = new ChromeDriver();
		
		try {
		System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
		WebDriverWait wait = new WebDriverWait(driver, 1000);
		
		driver.get("https://www.weather.go.kr/w/index.do");
		//System.out.println(driver.getPageSource());
		
		doc = Jsoup.parse(driver.getPageSource());
		//doc = Jsoup.connect("https://www.weather.go.kr/w/index.do").get();
		//System.out.println(doc);
		
		Elements body = doc.select("body");
		//System.out.println(body);
		
		Elements table = body.select("#map-index-vshort small");
		System.out.println(table);
		
		//Elements tbody = table.select("tbody");
		
		//System.out.println(tbody);
		
		for (Element headline : table) {
		  System.out.println(headline.text());
		  //System.out.println(headline.absUrl("href"));
		}
		
		}finally {
			//드라이버를 종료(자원해제)
			driver.quit();
		}
	}
}

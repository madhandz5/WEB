package common;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class DataSetting
 */
// @WebServlet("/DataSetting")
public class DataSetting extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DataSetting() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String isbn = "";
		JDBCTemplate jdt = JDBCTemplate.getInstance();
		Connection conn = jdt.getConnection();
		PreparedStatement pstm = null;

		int res = 0;

		String sql = "insert into tb_book values(S_B_BNO.nextval, 1101, ?, ?, sysdate,'N',?,?)";

		try {
			pstm = conn.prepareStatement(sql);
			String prefix = getServletContext().getRealPath("/");
			System.out.println(prefix);
			JsonObject jobj = new Gson().fromJson(new FileReader(new File(prefix + "resources/Book_top100.json")),
					JsonObject.class);

			JsonArray datas = jobj.getAsJsonArray("DATA");

			for (JsonElement j : datas) {
				JsonObject bookInfo = j.getAsJsonObject();
				System.out.println(bookInfo.get("title").getAsString());
				pstm.setString(1, bookInfo.get("title").getAsString());
				pstm.setString(2, bookInfo.get("author").getAsString());
				pstm.setString(3, bookInfo.get("cnt").getAsString());
				isbn = bookInfo.get("isbn").getAsString();
				pstm.setString(4, isbn);
				pstm.executeUpdate();
				addImage(isbn);
			}
			jdt.commit(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdt.close(pstm);
			jdt.close(conn);
		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void addImage(String isbn) {
		URL url = null;
		HttpsURLConnection conn = null;
		String jsonData = "";
		BufferedReader br = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;

		String prefix = getServletContext().getRealPath("/");
		try {

			url = new URL("https://dapi.kakao.com/v3/search/book?query=" + isbn + "&target=isbn");
			conn = (HttpsURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Authorization", "KakaoAK b882c6b99f515162fe5325904859d724");
			conn.connect();

			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			while ((line = br.readLine()) != null) {
				jsonData += line;
			}

			JsonObject jobj = new Gson().fromJson(jsonData, JsonObject.class);
			JsonArray jarr = jobj.getAsJsonArray("documents");

			JsonObject data = jarr.get(0).getAsJsonObject();
			String src = data.get("thumbnail").getAsString();
			System.out.println(prefix + "/resources/img/" + isbn + ".jpg");
			bis = new BufferedInputStream(new URL(src).openStream());
			fos = new FileOutputStream(prefix + "/resources/img/" + isbn + ".jpg");

			int check = 0;
			while ((check = bis.read()) != -1) {
				fos.write(check);
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				bis.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

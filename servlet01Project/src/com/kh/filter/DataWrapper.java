package com.kh.filter;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class DataWrapper extends HttpServletRequestWrapper {

	HttpServletRequest request;

	public DataWrapper(HttpServletRequest request) {
		super(request);
		this.request = request;

	}

	public RequestDispatcher getRequestDispatcher(String fileName) {

		String finalPath = "/WEB-INF/Image/" + fileName + ".jpg";
		RequestDispatcher rd = request.getRequestDispatcher(finalPath);

		return rd;
	}

	public Map<String, Object> getCommandMap() {

		Map<String, Object> commandMap = new HashMap<>();
		Map<String, String[]> origin = request.getParameterMap();

		for (String s : origin.keySet()) {
			String[] sa = origin.get(s);
			if (sa.length == 1) {
				commandMap.put(s, sa[0]);
			} else {
				commandMap.put(s, sa);
			}
		}
		return commandMap;
	}

}

package com.antbean.framework.common.filter;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

public class XssRequestWrapper extends HttpServletRequestWrapper {

	public XssRequestWrapper(HttpServletRequest servletRequest) {
		super(servletRequest);
	}

	@Override
	public String[] getParameterValues(String parameter) {
		String[] values = super.getParameterValues(parameter);

		if (values == null) {
			return null;
		}

		int count = values.length;
		String[] encodedValues = new String[count];
		for (int i = 0; i < count; i++) {
			if (StringUtils.isBlank(values[i])) {
				continue;
			}

			encodedValues[i] = stripXss(values[i]);
			encodedValues[i] = urlDecode(values[i]);
		}

		return encodedValues;
	}

	@Override
	public String getParameter(String parameter) {
		String value = super.getParameter(parameter);
		if (StringUtils.isBlank(value)) {
			return value;
		}

		value = urlDecode(value);
		return stripXss(value);
	}

	@Override
	public String getHeader(String name) {
		String value = super.getHeader(name);
		return stripXss(value);
	}

	private String stripXss(String value) {
		value = StringEscapeUtils.escapeHtml3(value);
		value = StringEscapeUtils.escapeHtml4(value);
		value = StringEscapeUtils.escapeJava(value);
		return value;
	}

	private String urlDecode(String str) {
		try {
			return URLDecoder.decode(str, this.getCharacterEncoding());
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static void main(String[] args) {
		System.out.println(StringEscapeUtils.escapeJava("哈哈航啊"));
	}

}

package com.antbean.domain.request;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

public class PersonCreate {
	@NotBlank(message = "姓名不能为空")
	@Length(max = 18, message = "姓名不能超过18个字符")
	private String name;
	@NotBlank(message = "地址不能为空")
	@Length(max = 50, message = "地址不能超过50个字符")
	private String address;
	// @NotBlank(message = "身份证号不能为空")
	// @Length(min = 18, max = 18, message = "身份证号只能为18个字符")
	private String idcard;
	// @Range(min = 18, max = 60, message = "年龄只能在18到60之间")
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}

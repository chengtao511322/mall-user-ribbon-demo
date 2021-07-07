package com.tuling.common.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 */
@Repository
public class Tank {

	@Value("tank1")
	private String name;
	@Value("666")
	private String age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Tank{" +
				"name='" + name + '\'' +
				", age='" + age + '\'' +
				'}';
	}
}

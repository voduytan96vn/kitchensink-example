package org.jboss.as.quickstarts.kitchensink.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
//@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	//@NotNull
	// @Size(min = 1, max = 25)
	//@Pattern(regexp = "[A-Za-z ]*", message = "Chỉ chứa các chữ cái và khoảng trắng")
	private String name;

	private String birthdate;

	//@NotNull
	//@NotEmpty
	//@Email
	private String email;

	// @NotNull
	// @Size(min = 10, max = 12)
	// @Digits(fraction = 0, integer = 12)
	@Column(name = "phone_number")
	private Long phoneNumber;

	private String address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
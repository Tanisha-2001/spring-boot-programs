package com.cdac.training.Model;

import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.Base64;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "dealers")
public class Dealer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "Dealer_seq")
	@SequenceGenerator(name = "Dealer_seq", initialValue = 1000, allocationSize = 1)
	long id;

	@Column(unique = true, nullable = false)
	String email;

	@Column(nullable = false)
	String fName;

	@Column(nullable = false)
	String lName;

	@NotBlank(message = "PASSWORD CANNOT BE BLANK")
	@Size(min = 8, max = 225, message = "password must be between 8 and 225")
	@Column(nullable = false)
	String password;

	@JsonFormat(pattern = "yyyy-MM-dd")
	Date dob;

	@Column(nullable = false)
	String phoneNo;

	@OneToOne(mappedBy = "Dealer", cascade = CascadeType.ALL)
	Address address;

	public Dealer() {
	}

	public Dealer(long id, String email, String fName, String lName,
			@NotBlank(message = "PASSWORD CANNOT BE BLANK") @Size(min = 8, max = 225, message = "password must be between 8 and 225") String password,
			Date dob, String phoneNo, Address address) {
		this.id = id;
		this.email = email;
		this.fName = fName;
		this.lName = lName;
		this.password = password;
		this.dob = dob;
		this.phoneNo = phoneNo;
		this.address = address;
	}

	public Dealer(long id, String email, String fName, String lName,
			@NotBlank(message = "PASSWORD CANNOT BE BLANK") @Size(min = 8, max = 225, message = "password must be between 8 and 225") String password,
			Date dob, String phoneNo) {
		this.id = id;
		this.email = email;
		this.fName = fName;
		this.lName = lName;
		this.password = password;
		this.dob = dob;
		this.phoneNo = phoneNo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		Base64.Encoder encoder = Base64.getEncoder();
		String normalString = password;
		String encodedString = encoder.encodeToString(normalString.getBytes(StandardCharsets.UTF_8));

		this.password = encodedString;

	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}

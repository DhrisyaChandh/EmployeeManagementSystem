package com.spring.ems.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Dhrisya Chandran
 * @since 08.10.2021
 *
 */

@Entity
@Table(name="contact")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employee_ID_Number;

	private String c_First_Name;
	private String c_Middle_Name;
	private String c_Last_Name;
	private String c_Cellular_Phone;
	private String c_Home_Phone;
	private String c_City;
	private String c_Address;


	public int getEmployee_ID_Number() {
		return employee_ID_Number;
	}
	
	public void setEmployee_ID_Number(int employee_ID_Number) {
		this.employee_ID_Number = employee_ID_Number;
	}
	
	public String getC_First_Name() {
		return c_First_Name;
	}
	
	public void setC_First_Name(String c_First_Name) {
		this.c_First_Name = c_First_Name;
	}
	
	public String getC_Middle_Name() {
		return c_Middle_Name;
	}
	
	public void setC_Middle_Name(String c_Middle_Name) {
		this.c_Middle_Name = c_Middle_Name;
	}
	
	public String getC_Last_Name() {
		return c_Last_Name;
	}
	
	public void setC_Last_Name(String c_Last_Name) {
		this.c_Last_Name = c_Last_Name;
	}
	
	public String getC_Cellular_Phone() {
		return c_Cellular_Phone;
	}
	
	public void setC_Cellular_Phone(String c_Cellular_Phone) {
		this.c_Cellular_Phone = c_Cellular_Phone;
	}
	
	public String getC_Home_Phone() {
		return c_Home_Phone;
	}
	
	public void setC_Home_Phone(String c_Home_Phone) {
		this.c_Home_Phone = c_Home_Phone;
	}
	
	public String getC_City() {
		return c_City;
	}
	
	public void setC_City(String c_City) {
		this.c_City = c_City;
	}
	
	public String getC_Address() {
		return c_Address;
	}
	
	public void setC_Address(String c_Address) {
		this.c_Address = c_Address;
	}




}

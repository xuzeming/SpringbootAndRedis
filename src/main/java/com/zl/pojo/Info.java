package com.zl.pojo;
 
import java.io.Serializable;

 
import lombok.AllArgsConstructor;
import lombok.Data;
 
/**
 * <p></p>
 * Created by zhezhiyong@163.com on 2017/9/22.
 */
@Data
@AllArgsConstructor
public class Info implements  Serializable{
    /**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */  
	private static final long serialVersionUID = 5457507957150215600L;
	public Info(String string, String string2) {
	}
	
	public Info() {
		super();
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private String phone;
    private String address;
 
}

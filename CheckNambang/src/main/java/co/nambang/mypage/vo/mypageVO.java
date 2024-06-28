package co.nambang.mypage.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class mypageVO {
	private String userId;
	private String userPw;
	private String userName;
	private String email;
	private String phone;
	private String gender;
	private Date birth;
	private int point;	
	private int addrNo;	
}

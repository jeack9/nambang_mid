package co.nambang.member.vo;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	private String userId;
	private String userPw;
	private String userName;
	private String email;
	private String phone;
	private int gender;
	private Date birth;
	private int point;
	private int addrNo;
}

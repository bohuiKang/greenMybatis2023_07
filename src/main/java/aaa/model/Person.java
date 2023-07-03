package aaa.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor //기본생성자
@AllArgsConstructor //모든 멤버변수가 들어간 생성자
public class Person {
	String pname = "백아무개";
	boolean marriage = true;
	String gender = "it인", email2="gmail.com";
	
	String [] genders = {"남성","여성","it인"};
	String [] emails = {"naver.com","gmail.com","daum.net"};
	String [] characters = {"피카추","라이추","파이리","꼬부기"};
	
	public Map<String, String> getHobby(){
		Map<String, String> res = new LinkedHashMap<>();
		res.put("coding","코딩하기");
		res.put("programming","프로그램만들기");
		res.put("debuging","디버깅");
		res.put("project","프로젝트");
		
		return res;
	}
	
	// 선택할 캐릭터 가지고 있을 리스트
	public ArrayList<String> getChars(){
		ArrayList<String> res = new ArrayList<>();
		res.add("피카추");
		res.add("파이리");
		return res;
	} 
}

package aaa.db;

import java.util.Date;
import org.apache.ibatis.type.Alias;
import lombok.Data;

@Alias("bDTO") //별칭
@Data
public class BoardDTO {
	//table의 column 명 동일하게 작성
	Integer id, cnt, seq, level, gid, pno; //pno 추가
	String title, pname, pw, content, upfile, sch; //sch 추가
	Date reg_date;
	
	//추가
	public BoardDTO(String title, String pname, String pw, String content) {
		super();
		this.title = title;
		this.pname = pname;
		this.pw = pw;
		this.content = content;
	}
	public BoardDTO() { }//에러나지 말라고 추가
	//추가추가
	public BoardDTO(Integer id, String title, String pname) {
		super();
		this.id = id;
		this.title = title;
		this.pname = pname;
	}
	
	
	
}

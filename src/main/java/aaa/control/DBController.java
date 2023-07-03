package aaa.control;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.db.BoardDTO;
import aaa.db.BoardMapper;
import jakarta.annotation.Resource;

@Controller
public class DBController {

	@Resource
	BoardMapper bm;
	
//리스트
	@RequestMapping("/db/list")
	String dbListttt(Model mm) {
		List<BoardDTO> mainData = bm.list();
		System.out.println("dbListttt() 진입");
		//System.out.println("mainData :"+mainData); => 모든데이터를 끌고옴
		mm.addAttribute("mainData", mainData);
		return "db/list";
	}
//게시물
	@RequestMapping("/db/detail/{id}")
	String dbDetail(Model mm, BoardDTO dto) {
		System.out.println("dbDetail() 진입");
		mm.addAttribute("mainData", bm.detail(dto));
		return "db/detail";
	}
//작성
	@GetMapping("/db/insert")
	String dbInsertForm(BoardDTO dto) {
		System.out.println("dbInsertForm() 진입");
		return "db/insertForm";
	}
	
//작성완료
	@PostMapping("/db/insert")
	String  dbInsertComplete(Model mm, BoardDTO dto) {
		System.out.println("dbInsertComplete() 진입");
		bm.inserttt(dto);
		mm.addAttribute("msg", "입력되었습니다.");
		mm.addAttribute("goUrl", "list");
		return "db/alert";
	}
	
//삭제시 비밀번호 확인
	@GetMapping("/db/delete/{id}")
	String dbDeleteForm(BoardDTO dto) {
		System.out.println("dbDeleteForm() 진입");
		return "db/deleteForm";
	}
	
//삭제완료
	@PostMapping("/db/delete/{id}")
	String dbDeleteComplete(Model mm, BoardDTO dto) {
		int cnt = bm.deleteee(dto);
		System.out.println("dbDeleteComplete() 진입");

		String msg = "비밀번호가 맞지 않습니다";
		String goUrl = "/db/delete/"+dto.getId();
		if(cnt==1) {
			msg = "삭제되었습니다.";
			goUrl = "/db/list";
		}
		System.out.println("삭제갯수:"+cnt);
		mm.addAttribute("msg", msg);
		mm.addAttribute("goUrl", goUrl);
		return "db/alert";
	}
	
//수정
	@GetMapping("/db/modify/{id}")
	String dbModifyForm(Model mm, BoardDTO dto) {
		System.out.println("dbModifyForm() 진입");
		mm.addAttribute("mainData", bm.detail(dto));
		return "db/modifyForm";
	}
	
//수정완료
	@PostMapping("/db/modify/{id}")
	String dbModifyComplete(Model mm, BoardDTO dto) {
		int cnt = bm.modifyyy(dto);
		System.out.println("dbModifyComplete() 진입");

		String msg = "비밀번호가 맞지 않습니다";
		String goUrl = "/db/modify/"+dto.getId();
		if(cnt==1) {
			msg = "수정되었습니다.";
			goUrl = "/db/detail/"+dto.getId();
		}
		System.out.println("수정갯수:"+cnt);
		mm.addAttribute("msg", msg);
		mm.addAttribute("goUrl", goUrl);
		return "db/alert";
	}
}

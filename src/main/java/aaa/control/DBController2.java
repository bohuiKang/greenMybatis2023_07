package aaa.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.db.BoardDTO;
import aaa.db.BoardMapper2;
import jakarta.annotation.Resource;

@Controller
public class DBController2 {
	
	@Resource
	BoardMapper2 bm;
	
//리스트
	@RequestMapping("/db/list2")
	String dbListttt2(Model mm, BoardDTO dto) {
		List<BoardDTO> mainData2 = bm.list2(dto);
		System.out.println("dbListttt2() 진입");
		System.out.println("list:"+dto.getSch()+", "+dto.getCnt());
		mm.addAttribute("mainData2", mainData2);
		return "db/list2";
	}
	
//리스트 검색기능
	@RequestMapping("/db/listPname/{pno}")
	String dbListPname(Model mm, BoardDTO dto) {
		List<BoardDTO> mainData2 = bm.listPname(dto);
		System.out.println("dbListPname() 진입");
		mm.addAttribute("mainData2", mainData2);
		return "db/list2";
	}
	
//게시물
	@RequestMapping("/db/detail2/{id}")
	String dbDetail2(Model mm, BoardDTO dto) {
		System.out.println("dbDetail2() 진입");
		mm.addAttribute("mainData2", bm.detail2(dto));
		return "db/detail2";
	}
//작성
	@GetMapping("/db/insert2")
	String dbInsertForm2(BoardDTO dto) {
		System.out.println("dbInsertForm2() 진입");
		return "db/insertForm2";
	}
	
//다중 글쓰기(추가)
	@GetMapping("/db/insertList")
	String  dbInsertList(Model mm) {
		ArrayList<BoardDTO> arr = new ArrayList<>();
		arr.add(new BoardDTO("내일점심","뭐먹1","1111","마라탕,떡볶이,자장면,치킨"));
		arr.add(new BoardDTO("내일저녁","뭐먹2","1111","삼겹살"));
		arr.add(new BoardDTO("어제아침","뭐먹3","1111","동생 알바 카페 빵"));
		
		bm.insertList(arr);
		mm.addAttribute("msg", "입력되었습니다.");
		mm.addAttribute("goUrl", "list2");
		System.out.println("InsertList:");
		return "db/alert2";
	}
	
//작성완료
	@PostMapping("/db/insert2")
	String  dbInsertComplete2(Model mm, BoardDTO dto) {
		System.out.println("dbInsertComplete2() 진입");
		bm.inserttt2(dto);
		mm.addAttribute("msg", "입력되었습니다.");
		mm.addAttribute("goUrl", "detail2/"+dto.getId());
		System.out.println("InsertComplete2:"+dto);
		return "db/alert2";
	}
	
//삭제시 비밀번호 확인
	@GetMapping("/db/delete2/{id}")
	String dbDeleteForm2(BoardDTO dto) {
		System.out.println("dbDeleteForm2() 진입");
		return "db/deleteForm2";
	}
	
//삭제완료
	@PostMapping("/db/delete2/{id}")
	String dbDeleteComplete2(Model mm, BoardDTO dto) {
		int cnt = bm.deleteee2(dto);
		System.out.println("dbDeleteComplete2() 진입");

		String msg = "비밀번호가 맞지 않습니다";
		String goUrl = "/db/delete2/"+dto.getId();
		if(cnt==1) {
			msg = "삭제되었습니다.";
			goUrl = "/db/list2";
		}
		System.out.println("삭제갯수:"+cnt);
		mm.addAttribute("msg", msg);
		mm.addAttribute("goUrl", goUrl);
		return "db/alert2";
	}
	
//수정
	@GetMapping("/db/modify2/{id}")
	String dbModifyForm2(Model mm, BoardDTO dto) {
		System.out.println("dbModifyForm2() 진입");
		mm.addAttribute("mainData2", bm.detail2(dto));
		return "db/modifyForm2";
	}
	
//수정완료
	@PostMapping("/db/modify2/{id}")
	String dbModifyComplete2(Model mm, BoardDTO dto) {
		int cnt = bm.modifyyy2(dto);
		System.out.println("dbModifyComplete2() 진입");

		String msg = "비밀번호가 맞지 않습니다";
		String goUrl = "/db/modify2/"+dto.getId();
		if(cnt==1) {
			msg = "수정되었습니다.";
			goUrl = "/db/detail2/"+dto.getId();
		}
		System.out.println("수정갯수:"+cnt);
		mm.addAttribute("msg", msg);
		mm.addAttribute("goUrl", goUrl);
		return "db/alert2";
	}
}

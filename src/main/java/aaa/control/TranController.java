package aaa.control;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.db.BoardDTO;
import aaa.db.TranMapper;
import aaa.db.TranService;
import jakarta.annotation.Resource;

@Controller
public class TranController {
	@Resource
	TranMapper tm;
	
	@Resource
	TranService service;
	
	//spring 에서 기본으로 제공하는 인터페이스
	@Resource
	PlatformTransactionManager manager;
	
	@RequestMapping("/tran/list")
	String list(Model mm) {
		mm.addAttribute("mainData",tm.list());
		return "tran/list";
	}
	
	ArrayList<BoardDTO> arrs(int ...arr){
		ArrayList<BoardDTO> res = new ArrayList<>();
		for (int i : arr) {
			res.add(new BoardDTO(i, "제목"+i, "유"+i));
		}
		return res;
	}
	
//에러 발생시 rollback 필요없음
	@RequestMapping("/tran/insert1")
	String insert1() {
		tm.insert1(arrs(70,74,71));
		return "redirect:list";
	}
	
//에러 발생시 rollback 하지 않음 => Transaction 필요
	@RequestMapping("/tran/insert2")
	String insert2() {
		try {
			tm.insert2(arrs(84,81,83));
		} catch (Exception e) {	
			System.out.println("insert2 에러발생");
		}
		return "redirect:list";
	}
//에러 발생시 rollback 하지 않음 => Transaction 실행 1
	@RequestMapping("/tran/insert3")
	String insert3() {
		TransactionStatus status = manager.getTransaction(new DefaultTransactionDefinition());
		try {
			tm.insert2(arrs(89,87,88));
			manager.commit(status); //성공하면 commit
		} catch (Exception e) {	
			System.out.println("insert3 에러발생");
			manager.rollback(status); //실패(에러)하면 rollback
		}
		return "redirect:list";
	}
	
//에러 발생시 rollback 하지 않음 => Transaction 실행 2
	@RequestMapping("/tran/insert4")
	String insert4() {
		try {
			service.tranGo();
		} catch (Exception e) {
			System.out.println("insert4 에러발생");
		}
		
		return "redirect:list";
	}

}

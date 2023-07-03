package aaa.db;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.annotation.Resource;

@Service
public class TranService {
	
	@Resource
	TranMapper tm;
	
	ArrayList<BoardDTO> arrs(int ...arr){
		ArrayList<BoardDTO> res = new ArrayList<>();
		for (int i : arr) {
			res.add(new BoardDTO(i, "제목"+i, "유"+i));
		}
		return res;
	}
	
	@Transactional
	public void tranGo() {
		//try~catch 존재시 @Transactional 실행 안함
		tm.insert2(arrs(104,101,102));
	}
}

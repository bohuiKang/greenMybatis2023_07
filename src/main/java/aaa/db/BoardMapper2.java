package aaa.db;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper2 {

	List<BoardDTO> list2(BoardDTO second);
	
	List<BoardDTO> listPname(BoardDTO whatIsThis);
	
	BoardDTO detail2(BoardDTO bdedsde);
	
	void inserttt2(BoardDTO nameIsNotImportant);
	
	void insertList(ArrayList<BoardDTO> arr); //추가
	
	int deleteee2(BoardDTO anythingYouCanWrite);
	
	int modifyyy2(BoardDTO IfYouWant);
}

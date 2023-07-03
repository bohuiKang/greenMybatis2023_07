package aaa.db;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {

	List<BoardDTO> list();
	
	BoardDTO detail(BoardDTO bdedsde);
	
	void inserttt(BoardDTO nameIsNotImportant);
	
	int deleteee(BoardDTO anythingYouCanWrite);
	
	int modifyyy(BoardDTO IfYouWant);
}

package com.osf.test.dao;

import java.util.List;
import java.util.Map;

public interface PBoardDAO {

	public int insertPBoard(Map<String,String> pBoard);
	public List<Map<String,String>> selectPBoardList();
	public Map<String,String> selectBoard(int pbNum);
	public int deletePBoard(Map<String,String> pBoard);
	public int updatePBoard(Map<String,String> pBoard);
	
}

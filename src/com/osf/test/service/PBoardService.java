package com.osf.test.service;

import java.util.List;
import java.util.Map;

public interface PBoardService {

	public int insertPBoard(Map<String,String> pBoard);
	public List<Map<String,String>> selectPBoardList();
	public Map<String,String> selectBoard(int pbNum);
	public int updatePBoard(Map<String,String> pBoard);
	public int deletePBoard(Map<String,String> pBoard);
}

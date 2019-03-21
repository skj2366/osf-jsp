package com.osf.test.service.impl;

import java.util.List;
import java.util.Map;

import com.osf.test.dao.PBoardDAO;
import com.osf.test.dao.impl.PBoardDAOImpl;
import com.osf.test.service.PBoardService;

public class PBoardServiceImpl implements PBoardService {

	private PBoardDAO pbdao = new PBoardDAOImpl();//service는 dao에 대하여 의존성을 가지고있다.
	
	@Override
	public int insertPBoard(Map<String, String> pBoard) {
		return pbdao.insertPBoard(pBoard);
	}
	
	@Override
	public List<Map<String, String>> selectPBoardList() {
		return pbdao.selectPBoardList();
	}

	@Override
	public int updatePBoard(Map<String, String> pBoard) {
		return 0;
	}

	@Override
	public int deletePBoard(Map<String, String> pBoard) {
		return 0;
	}

	@Override
	public Map<String, String> selectBoard(int pbNum) {
		return pbdao.selectBoard(pbNum);
	}

	

}

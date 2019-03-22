package com.osf.test.service.impl;

import java.util.List;

import com.osf.test.dao.PBoardDAO2;
import com.osf.test.dao.impl.PBoardDAOImpl2;
import com.osf.test.service.PBoardService2;
import com.osf.test.vo.PhotoBoardVO;

public class PBoardServiceImpl2 implements PBoardService2 {

	private PBoardDAO2 pbvo = new PBoardDAOImpl2();
	
	@Override
	public int insertPBoard(PhotoBoardVO pBoard) {
		return pbvo.insertPBoard(pBoard);
	}

	@Override
	public List<PhotoBoardVO> selectPBoardList() {
		return pbvo.selectPBoardList();
	}

	@Override
	public PhotoBoardVO selectBoard(int pbNum) {
		return pbvo.selectBoard(pbNum);
	}

	@Override
	public int updatePBoard(PhotoBoardVO pBoard) {
		return 0;
	}

	@Override
	public int deletePBoard(PhotoBoardVO pBoard) {
		return 0;
	}

}

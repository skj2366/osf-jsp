package com.osf.test.dao;

import java.util.List;
import java.util.Map;

import com.osf.test.vo.PhotoBoardVO;

public interface PBoardDAO2 {

	public int insertPBoard(PhotoBoardVO pBoard);
	public List<PhotoBoardVO> selectPBoardList();
	public PhotoBoardVO selectBoard(int pbNum);
	public int deletePBoard(PhotoBoardVO pBoard);
	public int updatePBoard(PhotoBoardVO pBoard);
}

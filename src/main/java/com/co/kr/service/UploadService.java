package com.co.kr.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.co.kr.domain.BoardFileDomain;
import com.co.kr.domain.BoardListDomain;
import com.co.kr.vo.fileListVO;

public interface UploadService {
	
	public int fileProcess(fileListVO fileListVO, MultipartHttpServletRequest request, HttpServletRequest httpReq);
	
	public List<BoardListDomain> boardList();

	public void bdContentRemove(HashMap<String, Object> map);

	public void bdFileRemove(BoardFileDomain boardFileDomain);
	
	public BoardListDomain boardSelectOne(HashMap<String, Object> map);
	
	public List<BoardFileDomain> boardSelectOneFile(HashMap<String, Object> map);		
}

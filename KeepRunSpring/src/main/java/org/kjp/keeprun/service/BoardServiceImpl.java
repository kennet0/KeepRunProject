package org.kjp.keeprun.service;

import java.util.List;

import javax.inject.Inject;

import org.kjp.keeprun.domain.WorkProcessVO;
import org.kjp.keeprun.persistence.BoardDAO;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	BoardDAO boardDAO;
	
	@Override
	public WorkProcessVO todayWork(int deviceId) {
		
		return boardDAO.todayWork(deviceId);
	}
	
		
	@Override
	public List<WorkProcessVO> wList(int deviceId) {
		
		return boardDAO.wList(deviceId);
	}

	
}

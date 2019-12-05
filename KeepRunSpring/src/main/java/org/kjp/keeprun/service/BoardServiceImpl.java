package org.kjp.keeprun.service;

import java.sql.Date;
import java.util.ArrayList;
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


	@Override
	public List<Integer> weekKcal(Date workDate) {
		// TODO Auto-generated method stub
		return boardDAO.weekKcal(workDate);
	}

	
}

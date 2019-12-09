package org.kjp.keeprun.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.kjp.keeprun.domain.DeviceDataVO;
import org.kjp.keeprun.domain.MemberVO;
import org.kjp.keeprun.domain.WorkProcessVO;
import org.kjp.keeprun.persistence.BoardDAO;
import org.kjp.keeprun.persistence.DataDAO;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {

	@Inject
	DataDAO dataDAO;

	@Override
	public void insertA_data(DeviceDataVO deviceDataVO) {
	
		dataDAO.insertA_data(deviceDataVO);
	}

}

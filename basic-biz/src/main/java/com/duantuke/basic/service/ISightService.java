package com.duantuke.basic.service;

import java.util.List;

import com.duantuke.basic.esbean.input.SightInputBean;
import com.duantuke.basic.face.service.SightService;

public interface ISightService extends SightService {
	public List<SightInputBean> queryEsInputSights(Long sightId);
}

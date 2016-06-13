package com.duantuke.basic.service;

import java.util.List;

import com.duantuke.basic.esbean.input.JourneyInputBean;
import com.duantuke.basic.face.service.JourneyService;

public interface IJourneyService extends JourneyService {
	public List<JourneyInputBean> queryEsInputJourneys(Long journeyId);
}

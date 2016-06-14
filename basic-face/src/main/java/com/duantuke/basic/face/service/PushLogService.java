package com.duantuke.basic.face.service;

import java.util.List;

import com.duantuke.basic.po.LPushLog;


public interface PushLogService {
	/**
	 * 根据mid查询消息列表
	 * @param mid
	 * @return
	 */
	public List<LPushLog> queryPushLogByMid(Long mid);
}

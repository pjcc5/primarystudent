package cn.pjc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pjc.mapper.AnswerMapper;
import cn.pjc.service.AnswerService;
@Service
public class AnswerServiceImpl implements AnswerService{
	@Autowired
	private AnswerMapper am =null;

}

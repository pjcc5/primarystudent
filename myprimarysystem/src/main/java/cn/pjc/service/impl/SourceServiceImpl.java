package cn.pjc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pjc.mapper.SourceMapper;
import cn.pjc.pojo.Source;
import cn.pjc.service.SourceService;
@Service
public class SourceServiceImpl implements SourceService{
	@Autowired
	private SourceMapper sm = null;
	@Override
	public boolean saveSource(Source s) {
		return this.sm.insertSource(s);
	}

	@Override
	public boolean removeSourceBySid(String sid) {
		return this.sm.deleteSourceBySid(sid);
	}

	@Override
	public List<Source> querySourceBySpublisher(String spublisher) {
		return this.sm.selectSourceBySpublisher(spublisher);
	}

	@Override
	public Source querySourceBySidAndSpublisher(Map<String, Object> map) {
		return this.sm.selectSourceBySidAndSpublisher(map);
	}

	@Override
	public Source querySourceBySid(String sid) {
		return this.sm.selectSourceBySid(sid);
	}

	@Override
	public boolean modifySource(Source Source) {
		int result = this.sm.updateSource(Source);
		if(result > 0)
		{
			return true;
		}
		
		return false;
	}

}

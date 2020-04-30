package cn.pjc.service;

import java.util.List;
import java.util.Map;

import cn.pjc.pojo.Source;



public interface SourceService {
	public boolean saveSource(Source s);
	public boolean removeSourceBySid(String sid);
	public List<Source> querySourceBySpublisher(String spublisher);
	public Source querySourceBySidAndSpublisher(Map<String, Object> map);
	public Source querySourceBySid(String sid);
	public boolean modifySource(Source Source); 
}

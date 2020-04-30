package cn.pjc.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.pjc.pojo.Source;

@Repository
public interface SourceMapper {
	public boolean insertSource(Source s);
	public List<Source> selectAllSource();
	public List<Source> selectSourceBySpublisher(String spublisher);
	public Source selectSourceBySid(String sid);
	public Source selectSourceBySidAndSpublisher(Map<String, Object> map);
	public boolean deleteSourceBySid(String sid);
	public int updateSource(Source Source); 
	
	
}

package com.cl.dao;

import com.cl.entity.JiaoxueshipinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiaoxueshipinView;


/**
 * 教学视频
 * 
 * @author 
 * @email 
 * @date 2024-03-05 16:26:36
 */
public interface JiaoxueshipinDao extends BaseMapper<JiaoxueshipinEntity> {
	
	List<JiaoxueshipinView> selectListView(@Param("ew") Wrapper<JiaoxueshipinEntity> wrapper);

	List<JiaoxueshipinView> selectListView(Pagination page,@Param("ew") Wrapper<JiaoxueshipinEntity> wrapper);
	
	JiaoxueshipinView selectView(@Param("ew") Wrapper<JiaoxueshipinEntity> wrapper);
	

}

package com.cl.dao;

import com.cl.entity.BushujiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BushujiluView;


/**
 * 步数记录
 * 
 * @author 
 * @email 
 * @date 2024-03-05 16:26:36
 */
public interface BushujiluDao extends BaseMapper<BushujiluEntity> {
	
	List<BushujiluView> selectListView(@Param("ew") Wrapper<BushujiluEntity> wrapper);

	List<BushujiluView> selectListView(Pagination page,@Param("ew") Wrapper<BushujiluEntity> wrapper);
	
	BushujiluView selectView(@Param("ew") Wrapper<BushujiluEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<BushujiluEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<BushujiluEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<BushujiluEntity> wrapper);



}

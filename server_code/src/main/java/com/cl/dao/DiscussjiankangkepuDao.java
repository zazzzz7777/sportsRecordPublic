package com.cl.dao;

import com.cl.entity.DiscussjiankangkepuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussjiankangkepuView;


/**
 * 健康科普评论表
 * 
 * @author 
 * @email 
 * @date 2024-03-05 16:26:36
 */
public interface DiscussjiankangkepuDao extends BaseMapper<DiscussjiankangkepuEntity> {
	
	List<DiscussjiankangkepuView> selectListView(@Param("ew") Wrapper<DiscussjiankangkepuEntity> wrapper);

	List<DiscussjiankangkepuView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussjiankangkepuEntity> wrapper);
	
	DiscussjiankangkepuView selectView(@Param("ew") Wrapper<DiscussjiankangkepuEntity> wrapper);
	

}

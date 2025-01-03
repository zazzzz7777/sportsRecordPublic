package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussjiankangkepuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussjiankangkepuView;


/**
 * 健康科普评论表
 *
 * @author 
 * @email 
 * @date 2024-03-05 16:26:36
 */
public interface DiscussjiankangkepuService extends IService<DiscussjiankangkepuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussjiankangkepuView> selectListView(Wrapper<DiscussjiankangkepuEntity> wrapper);
   	
   	DiscussjiankangkepuView selectView(@Param("ew") Wrapper<DiscussjiankangkepuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussjiankangkepuEntity> wrapper);
   	

}


package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiankangkepuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiankangkepuView;


/**
 * 健康科普
 *
 * @author 
 * @email 
 * @date 2024-03-05 16:26:36
 */
public interface JiankangkepuService extends IService<JiankangkepuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiankangkepuView> selectListView(Wrapper<JiankangkepuEntity> wrapper);
   	
   	JiankangkepuView selectView(@Param("ew") Wrapper<JiankangkepuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiankangkepuEntity> wrapper);
   	

}


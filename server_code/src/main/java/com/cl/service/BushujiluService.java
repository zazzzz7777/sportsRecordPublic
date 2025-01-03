package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.BushujiluEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BushujiluView;


/**
 * 步数记录
 *
 * @author 
 * @email 
 * @date 2024-03-05 16:26:36
 */
public interface BushujiluService extends IService<BushujiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BushujiluView> selectListView(Wrapper<BushujiluEntity> wrapper);
   	
   	BushujiluView selectView(@Param("ew") Wrapper<BushujiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BushujiluEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<BushujiluEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<BushujiluEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<BushujiluEntity> wrapper);



}


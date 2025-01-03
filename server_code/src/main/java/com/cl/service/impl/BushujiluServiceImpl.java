package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.BushujiluDao;
import com.cl.entity.BushujiluEntity;
import com.cl.service.BushujiluService;
import com.cl.entity.view.BushujiluView;

@Service("bushujiluService")
public class BushujiluServiceImpl extends ServiceImpl<BushujiluDao, BushujiluEntity> implements BushujiluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BushujiluEntity> page = this.selectPage(
                new Query<BushujiluEntity>(params).getPage(),
                new EntityWrapper<BushujiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BushujiluEntity> wrapper) {
		  Page<BushujiluView> page =new Query<BushujiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<BushujiluView> selectListView(Wrapper<BushujiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BushujiluView selectView(Wrapper<BushujiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<BushujiluEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<BushujiluEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<BushujiluEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}

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


import com.cl.dao.JiankangkepuDao;
import com.cl.entity.JiankangkepuEntity;
import com.cl.service.JiankangkepuService;
import com.cl.entity.view.JiankangkepuView;

@Service("jiankangkepuService")
public class JiankangkepuServiceImpl extends ServiceImpl<JiankangkepuDao, JiankangkepuEntity> implements JiankangkepuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiankangkepuEntity> page = this.selectPage(
                new Query<JiankangkepuEntity>(params).getPage(),
                new EntityWrapper<JiankangkepuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiankangkepuEntity> wrapper) {
		  Page<JiankangkepuView> page =new Query<JiankangkepuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JiankangkepuView> selectListView(Wrapper<JiankangkepuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiankangkepuView selectView(Wrapper<JiankangkepuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

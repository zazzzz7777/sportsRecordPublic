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


import com.cl.dao.DiscussjiankangkepuDao;
import com.cl.entity.DiscussjiankangkepuEntity;
import com.cl.service.DiscussjiankangkepuService;
import com.cl.entity.view.DiscussjiankangkepuView;

@Service("discussjiankangkepuService")
public class DiscussjiankangkepuServiceImpl extends ServiceImpl<DiscussjiankangkepuDao, DiscussjiankangkepuEntity> implements DiscussjiankangkepuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussjiankangkepuEntity> page = this.selectPage(
                new Query<DiscussjiankangkepuEntity>(params).getPage(),
                new EntityWrapper<DiscussjiankangkepuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussjiankangkepuEntity> wrapper) {
		  Page<DiscussjiankangkepuView> page =new Query<DiscussjiankangkepuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussjiankangkepuView> selectListView(Wrapper<DiscussjiankangkepuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussjiankangkepuView selectView(Wrapper<DiscussjiankangkepuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

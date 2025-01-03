	import {
		createRouter,
		createWebHashHistory
	} from 'vue-router'
	import forum from '@/views/forum/list'
	import news from '@/views/news/list'
	import discussjiaoxueshipin from '@/views/discussjiaoxueshipin/list'
	import jiaoxueshipin from '@/views/jiaoxueshipin/list'
	import yonghu from '@/views/yonghu/list'
	import bushujilu from '@/views/bushujilu/list'
	import shipinleixing from '@/views/shipinleixing/list'
	import storeup from '@/views/storeup/list'
	import config from '@/views/config/list'
	import discussjiankangkepu from '@/views/discussjiankangkepu/list'
	import jiankangkepu from '@/views/jiankangkepu/list'
	import yonghuCenter from '@/views/yonghu/center'

export const routes = [{
		path: '/login',
		name: 'login',
		component: () => import('../views/login.vue')
	},{
		path: '/',
		name: '首页',
		component: () => import('../views/index'),
		children: [{
			path: '/',
			name: '首页',
			component: () => import('../views/HomeView.vue'),
			meta: {
				affix: true
			}
		}, {
			path: '/updatepassword',
			name: '修改密码',
			component: () => import('../views/updatepassword.vue')
		}
		
		,{
			path: '/yonghuCenter',
			name: '用户个人中心',
			component: yonghuCenter
		}
		,{
			path: '/forum',
			name: '我的发布',
			component: forum
		}
		,{
			path: '/news',
			name: '公告信息',
			component: news
		}
		,{
			path: '/discussjiaoxueshipin',
			name: '教学视频评论',
			component: discussjiaoxueshipin
		}
		,{
			path: '/jiaoxueshipin',
			name: '教学视频',
			component: jiaoxueshipin
		}
		,{
			path: '/yonghu',
			name: '用户',
			component: yonghu
		}
		,{
			path: '/bushujilu',
			name: '步数记录',
			component: bushujilu
		}
		,{
			path: '/shipinleixing',
			name: '视频类型',
			component: shipinleixing
		}
		,{
			path: '/storeup',
			name: '我的收藏',
			component: storeup
		}
		,{
			path: '/config',
			name: '轮播图',
			component: config
		}
		,{
			path: '/discussjiankangkepu',
			name: '健康科普评论',
			component: discussjiankangkepu
		}
		,{
			path: '/jiankangkepu',
			name: '健康科普',
			component: jiankangkepu
		}
		]
	},
]

const router = createRouter({
	history: createWebHashHistory(process.env.BASE_URL),
	routes
})

export default router

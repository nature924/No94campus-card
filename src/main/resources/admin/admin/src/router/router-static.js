import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import tiyuqicai from '@/views/modules/tiyuqicai/list'
    import xuesheng from '@/views/modules/xuesheng/list'
    import qicaiguihai from '@/views/modules/qicaiguihai/list'
    import shangpinxinxi from '@/views/modules/shangpinxinxi/list'
    import tushuleixing from '@/views/modules/tushuleixing/list'
    import shangjijilu from '@/views/modules/shangjijilu/list'
    import discusstiyuqicai from '@/views/modules/discusstiyuqicai/list'
    import jiaofeixinxi from '@/views/modules/jiaofeixinxi/list'
    import shitangjiucan from '@/views/modules/shitangjiucan/list'
    import tushujieyue from '@/views/modules/tushujieyue/list'
    import yikatong from '@/views/modules/yikatong/list'
    import tushuguihai from '@/views/modules/tushuguihai/list'
    import news from '@/views/modules/news/list'
    import dingdanxinxi from '@/views/modules/dingdanxinxi/list'
    import discussmeishixinxi from '@/views/modules/discussmeishixinxi/list'
    import koufeixinxi from '@/views/modules/koufeixinxi/list'
    import guashishenqing from '@/views/modules/guashishenqing/list'
    import forum from '@/views/modules/forum/list'
    import qicaijieyong from '@/views/modules/qicaijieyong/list'
    import tongzhixinxi from '@/views/modules/tongzhixinxi/list'
    import meishixinxi from '@/views/modules/meishixinxi/list'
    import huiyiqiandao from '@/views/modules/huiyiqiandao/list'
    import shangpinleixing from '@/views/modules/shangpinleixing/list'
    import config from '@/views/modules/config/list'
    import chongzhixinxi from '@/views/modules/chongzhixinxi/list'
    import tushuxinxi from '@/views/modules/tushuxinxi/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/tiyuqicai',
        name: '体育器材',
        component: tiyuqicai
      }
      ,{
	path: '/xuesheng',
        name: '学生',
        component: xuesheng
      }
      ,{
	path: '/qicaiguihai',
        name: '器材归还',
        component: qicaiguihai
      }
      ,{
	path: '/shangpinxinxi',
        name: '商品信息',
        component: shangpinxinxi
      }
      ,{
	path: '/tushuleixing',
        name: '图书类型',
        component: tushuleixing
      }
      ,{
	path: '/shangjijilu',
        name: '上机记录',
        component: shangjijilu
      }
      ,{
	path: '/discusstiyuqicai',
        name: '体育器材评论',
        component: discusstiyuqicai
      }
      ,{
	path: '/jiaofeixinxi',
        name: '缴费信息',
        component: jiaofeixinxi
      }
      ,{
	path: '/shitangjiucan',
        name: '食堂就餐',
        component: shitangjiucan
      }
      ,{
	path: '/tushujieyue',
        name: '图书借阅',
        component: tushujieyue
      }
      ,{
	path: '/yikatong',
        name: '一卡通',
        component: yikatong
      }
      ,{
	path: '/tushuguihai',
        name: '图书归还',
        component: tushuguihai
      }
      ,{
	path: '/news',
        name: '校园资讯',
        component: news
      }
      ,{
	path: '/dingdanxinxi',
        name: '订单信息',
        component: dingdanxinxi
      }
      ,{
	path: '/discussmeishixinxi',
        name: '美食信息评论',
        component: discussmeishixinxi
      }
      ,{
	path: '/koufeixinxi',
        name: '扣费信息',
        component: koufeixinxi
      }
      ,{
	path: '/guashishenqing',
        name: '挂失申请',
        component: guashishenqing
      }
      ,{
	path: '/forum',
        name: '论坛管理',
        component: forum
      }
      ,{
	path: '/qicaijieyong',
        name: '器材借用',
        component: qicaijieyong
      }
      ,{
	path: '/tongzhixinxi',
        name: '通知信息',
        component: tongzhixinxi
      }
      ,{
	path: '/meishixinxi',
        name: '美食信息',
        component: meishixinxi
      }
      ,{
	path: '/huiyiqiandao',
        name: '会议签到',
        component: huiyiqiandao
      }
      ,{
	path: '/shangpinleixing',
        name: '商品类型',
        component: shangpinleixing
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/chongzhixinxi',
        name: '充值信息',
        component: chongzhixinxi
      }
      ,{
	path: '/tushuxinxi',
        name: '图书信息',
        component: tushuxinxi
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '系统首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;

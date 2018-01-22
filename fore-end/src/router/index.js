import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/components/pages/Index'
import MyAttendance from '@/components/pages/stu/MyAttendance'
import MyCredits from '@/components/pages/stu/MyCredits'
import MyDormitoryCost from '@/components/pages/stu/MyDormitoryCost'
import MyPayment from '@/components/pages/stu/MyPayment'
import MyScore from '@/components/pages/stu/MyScore'
import ClassExpenses from '@/components/pages/cls/ClassExpenses'
import ClassBulletin from '@/components/pages/cls/ClassBulletin'
import BaseInfo from '@/components/pages/user/BaseInfo'
import MyMessage from '@/components/pages/user/MyMessage'
import SecuritySetting from '@/components/pages/user/SecuritySetting'

Vue.use(Router)

export default new Router({
	mode: 'history',
	routes: [{
			path: '/',
			redirect:{name:'Index'}
		},
		{
			path:'/user/exit',
			redirect:{name:'Index'}
		},
		{
			path: '/Index',
			name: 'Index',
			component: Index
		},
		{
			path: '/stu/MyAttendance',
			component: MyAttendance
		},
		{
			path: '/stu/MyCredits',
			component: MyCredits
		},
		{
			path: '/stu/MyDormitoryCost',
			component: MyDormitoryCost
		},
		{
			path: '/stu/MyPayment',
			component: MyPayment
		},
		{
			path: '/cls/ClassExpenses',
			component: ClassExpenses
		},
		{
			path: '/cls/ClassBulletin',
			component: ClassBulletin
		},
		{
			path: '/stu/MyScore',
			component: MyScore
		},
		{
			path: '/user/BaseInfo',
			component: BaseInfo
		},
		{
			path: '/user/MyMessage',
			component: MyMessage
		},
		{
			path: '/user/SecuritySetting',
			component: SecuritySetting
		}
	]
})
/*
	
	
 */
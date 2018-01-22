<template>
	<el-menu router :default-active="$route.path" :default-openeds="defaultOpeneds" class="el-menu-vertical-demo" background-color="#D3DCE6" text-color="#333" active-text-color="#409EFF" :unique-opened='uniqueOpened'>
		<el-menu-item index="/Index">
			<i class="el-icon-menu"></i>
			<span slot="title">首页</span>
		</el-menu-item>
		<el-submenu index="2">
			<template slot="title">
				<i class="el-icon-location"></i>
				<span slot="title">我的日常</span>
			</template>
			<el-menu-item index="/stu/MyAttendance">我的出勤</el-menu-item>
			<el-menu-item index="/stu/MyCredits">我的学分</el-menu-item>
			<el-menu-item index="/stu/MyScore">我的期末成绩</el-menu-item>
			<el-menu-item index="/stu/MyPayment">我的缴费</el-menu-item>
			<el-menu-item index="/stu/MyDormitoryCost">我的宿舍费用支出</el-menu-item>
		</el-submenu>
		<el-submenu index="3">
			<template slot="title">
				<i class="el-icon-location"></i>
				<span slot="title">班级日常</span>
			</template>
			<el-menu-item index="/cls/ClassBulletin">班级公告</el-menu-item>
			<el-menu-item index="/cls/ClassExpenses">班费明细</el-menu-item>
		</el-submenu>
	</el-menu>
</template>

<script>
	export default {
		name: 'myaside',
		data() {
			return {
				'uniqueOpened': true,
				'defaultOpeneds':new Array("2")
			}
		}
	}
</script>

<style>

</style>
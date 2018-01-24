<template>
	<el-row>
		<el-col :xs="4" :sm="4" :md="4" :lg="4">
			<div class="grid-content bg-purple mylogo">
				学 生 的 个 人 空 间
			</div>
		</el-col>
		<el-col :xs="3" :sm="3" :md="3" :lg="3" :offset="17">
			<div class="grid-content bg-purple">
				<el-menu class="el-menu-demo" router :default-active="$route.path" mode="horizontal" background-color="#B3C0D1" text-color="#333" active-text-color="#409EFF" @select="headerSelect">
					<el-submenu index="1">
						<template slot="title">
							<i class="el-icon-location"></i>
							<span slot="title">{{stu.sname}}</span>
						</template>
						<el-menu-item index="/user/BaseInfo">
							<i class="el-icon-edit"></i>
							<span>基本资料</span>
						</el-menu-item>
						<el-menu-item index="/user/MyMessage">
							<i class="el-icon-message"></i>
							<span>我的消息</span>
						</el-menu-item>
						<el-menu-item index="/user/SecuritySetting">
							<i class="el-icon-setting"></i>
							<span>安全设置</span>
						</el-menu-item>
						<el-menu-item index="/user/exit">
							<i class="el-icon-back"></i>
							<span>退出登录</span>
						</el-menu-item>
					</el-submenu>
				</el-menu>
			</div>
		</el-col>
	</el-row>
</template>

<script>
	export default {
		data(){
			return {
				stu:{}
			}
		},
		created(){
			this.stu = JSON.parse(window.sessionStorage.stu);
		},
		methods: {
			headerSelect(key, keyPath){
				if(key === '/user/exit'){
					window.sessionStorage.sessionId = undefined;
					this.$emit('listenerLogin', false);
				}
			}
		}
	}
</script>

<style scoped="scoped">
	.el-row,
	.el-col {
		height: 100%;
	}
	
	.bg-purple {
		text-align: center;
	}
	.mylogo{
		text-align: center;
		font-family: "微软雅黑";
		font-size: 1.8rem;
		line-height: 63px;
		color: #0088FB;
	}
	.el-menu--horizontal,.el-submenu{
		height: 100%;
	}
	.grid-content {
		height: 100%;
	}
	.el-submenu,.el-menu-item{
		height: 100%;
		min-width:100px
	}
	a{
		text-decoration: none;
	}
</style>
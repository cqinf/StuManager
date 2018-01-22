<template>
	<div id="app" v-loading.fullscreen.lock="loading" element-loading-text="正在验证登录" element-loading-background="rgba(255, 255, 255, 0.8)">
		<Login @listenerLogin="listenerLogin" @listenerLoding="listenerLoding" v-if="!isLogin" />
		<el-container v-if="isLogin">
			<el-header style="height: 10%;">
				<MyHeader @listenerLogin="listenerLogin" />
			</el-header>
			<el-container>
				<el-aside width="200px">
					<MyAside />
				</el-aside>
				<el-container>
					<el-main>
						<MyMain @listenerLogin="listenerLogin" />
					</el-main>
					<el-footer>
						<MyFooter />
					</el-footer>
				</el-container>
			</el-container>
		</el-container>
	</div>
</template>

<script>
	import MyHeader from '@/components/MyHeader';
	import MyFooter from '@/components/MyFooter';
	import MyMain from '@/components/MyMain';
	import MyAside from '@/components/MyAside';
	import Login from '@/components/Login';

	export default {
		name: 'app',
		components: {
			MyHeader,
			MyFooter,
			MyMain,
			MyAside,
			Login
		},
		data() {
			return {
				isLogin: true,
				loading: true,
			}
		},
		created() {
			const _this = this;
			let sessionid = "sessionid=" + window.sessionStorage.sessionId;
			this.$http.post('/api/StuManager/userController/isLogin', sessionid).then(
				result => {
					_this.listenerLogin(result.data.isLogin);
					_this.listenerLoding(false);
				}
			);
		},
		methods: {
			listenerLogin(word) {
				this.isLogin = word;
			},
			listenerLoding(word) {
				this.loading = word;
			}
		}
	}
</script>

<style>
	html,
	body,
	#app,
	#app>.el-container {
		padding: 0;
		margin: 0;
		width: 100%;
		height: 100%;
		font-size: 62.5%;
	}
	
	.el-header,
	.el-footer {
		background-color: #B3C0D1;
		color: #333;
		width: 100%;
	}
	
	.el-aside {
		background-color: #D3DCE6;
		color: #333;
	}
	
	.el-main {
		background-color: #E9EEF3;
		color: #333;
		height: 80%;
		overflow: auto;
	}
</style>
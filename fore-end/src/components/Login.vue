<template>
	<div class="login">
		<el-card class="box-card">
			<el-row>
				<el-col :span="24">
					<div class="grid-content">
						<div style="width: 400px;height: 200px; ;margin: 0 auto;" v-loading="imageLoading">
							<img src="../../static/images/logo.png" width="400px" height="200px" @load="imageLoad" />
						</div>
					</div>
				</el-col>
			</el-row>
			<el-row>
				<el-col :span="24">
					<div class="grid-content">
						<el-form ref="form" status-icon :rules="rules" :model="form" label-width="80px">
							<el-form-item label="用户名" prop="uname">
								<el-input v-model="form.uname" placeholder="请输入用户名"></el-input>
							</el-form-item>
							<el-form-item label="密码" prop="upwd">
								<el-input type="password" v-model="form.upwd" placeholder="请输入密码"></el-input>
							</el-form-item>
							<el-form-item style="text-align: right;">
								<el-button type="primary" @click="onSubmit('form')">登录</el-button>
								<el-button @click="onReset('form')">清空</el-button>
							</el-form-item>
						</el-form>
					</div>
				</el-col>
			</el-row>
		</el-card>
	</div>
</template>

<script>
	export default {
		name: 'Login',
		data() {
			return {
				imageLoading: true,
				form: {
					uname: 'wangwu',
					upwd: 'wangwu'
				},
				rules: {
					uname: [{
							required: true,
							message: '请输入用户名',
							trigger: 'change'
						},
						{
							min: 2,
							max: 10,
							message: '长度在 2 到 10 个字符',
							trigger: 'change'
						}
					],
					upwd: [{
							required: true,
							message: '请输入密码',
							trigger: 'change'
						},
						{
							min: 6,
							max: 12,
							message: '长度在6 到 12 个字符',
							trigger: 'change'
						}
					]
				}
			}
		},
		methods: {
			imageLoad() {
				this.imageLoading = false;
			},
			onSubmit(formName) {
				//保存this值
				const _this = this;

				//验证输入
				this.$refs[formName].validate((valid) => {
					//如果验证成功
					if(valid) {

						//修改app.vue的加载监听
						_this.$emit('listenerLoding', true);

						//拼接参数
						let param = "uname=" + _this.form.uname + "&upwd=" + _this.form.upwd;

						//异步登录
						_this.$http.post(
							'/api/StuManager/userController/userLogin',
							param).then(
							result => {
								console.log(result);
								//如果返回的是object，则验证成功
								if(typeof result.data === "object") {
									//修改app.vue的登录监听
									_this.$emit('listenerLogin', true);

									//获取登录会话id
									window.sessionStorage.sessionId = result.data.session;
									console.log(result.data.stu);
									window.sessionStorage.stu = JSON.stringify(result.data.stu);

									//修改app.vue的加载监听
									_this.$emit('listenerLoding', false);

									_this.$notify({
										title: '登录提示',
										message: '欢迎您的登录：' + result.data.stu.sname,
										position: 'bottom-right',
										duration:2500
									});
								} else {
									_this.$message({
										showClose: true,
										message: '用户名或密码错误',
										type: 'error'
									});

									//修改app.vue的登录监听
									_this.$emit('listenerLogin', false);

									//修改app.vue的加载监听
									_this.$emit('listenerLoding', false);
								}
							}
						);
					} else {
						return false;
					}
				});
			},
			onReset(formName) {
				this.$refs[formName].resetFields();
			}
		}
	}
</script>

<style scoped="scoped">
	.el-row {
		margin: 30px;
	}
	
	.el-form {
		width: 400px;
		margin: 0 auto;
	}
	
	.login {
		width: 800px;
		height: 500px;
		margin: 0 auto;
		padding-top: 40px;
	}
	
	.box-card {
		width: 100%;
		height: 100%;
		text-align: center;
		padding: 15px;
	}
</style>
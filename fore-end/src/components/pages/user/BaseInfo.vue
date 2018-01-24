<template>
	<div v-loading.fullscreen.lock="saveStu" element-loading-text="正在保存..." element-loading-background="rgba(255, 255, 255, 0.8)">
		<el-row style="width: 100%;height: 100%;">
			<el-col :span="12" style="margin: 30px auto;float: inherit;">
				<el-form ref="stu" :model="stu" label-width="80px">
					<el-row>
						<el-col :span="8">
							<img :src="imageUrl" class="avatar">
							<!--<el-upload :auto-upload="false" :on-change="selectImage" class="avatar-uploader" action="/api/StuManager/stuController/updateStu" :show-file-list="false">
								<img v-if="imageUrl" :src="imageUrl" class="avatar">
								<i v-else class="el-icon-plus avatar-uploader-icon"></i>
							</el-upload>-->
						</el-col>
						<el-col :span="16">
							<el-form-item label="姓名">
								<el-input disabled v-model="stu.sname"></el-input>
							</el-form-item>
							<el-form-item label="电话">
								<el-input v-model="stu.stel"></el-input>
							</el-form-item>
							<el-form-item label="出生日期">
								<el-date-picker type="date" @change="selectDate" :default-value="defaultDate" placeholder="选择日期" v-model="stu.sbirthday" style="width: 100%;" />
							</el-form-item>
						</el-col>
					</el-row>
					<el-row>
						<el-col :span="10">
							<el-form-item label="职位">
								<el-radio-group v-model="stu.sidentity">
									<el-radio disabled :label="1">当官的</el-radio>
									<el-radio disabled :label="0">平民</el-radio>
								</el-radio-group>
							</el-form-item>
						</el-col>
						<el-col :span="14">
							<el-row>
								<el-col :span="14">
									<el-form-item label="性别">
										<el-radio-group v-model="stu.ssex">
											<el-radio disabled :label="1">男</el-radio>
											<el-radio disabled :label="0">女</el-radio>
										</el-radio-group>
									</el-form-item>
								</el-col>
								<el-col :span="10">
									<el-form-item label="年龄">
										<el-input disabled v-model="stu.sage"></el-input>
									</el-form-item>
								</el-col>
							</el-row>
						</el-col>
					</el-row>
					<el-row>
						<el-col :span="8">
							<el-form-item label="班级">
								<el-input disabled v-model="stu.cls.cname"></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="16">
							<el-form-item disabled label="地址">
								<el-input v-model="stu.saddress"></el-input>
							</el-form-item>
						</el-col>
					</el-row>
					<el-row>
						<el-col style="text-align: right;">
							<el-form-item>
								<el-button :disabled="!isUpdate" type="primary" @click="onSubmit">保存</el-button>
							</el-form-item>
						</el-col>
					</el-row>
				</el-form>
			</el-col>
		</el-row>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				saveStu: false,
				isUpdate: false,
				imageUrl: '',
				imageFile: null,
				sessionid: window.sessionStorage.sessionId,
				defaultDate: new Date('1990-1-1'),
				stu: {}
			}
		},
		created() {
			this.stu = JSON.parse(window.sessionStorage.stu);
			this.imageUrl = "/api/StuManager/" + this.stu.simage;
				window.mythis = this;
		},
		updated(){
			let stu = JSON.parse(window.sessionStorage.stu);
			for(let p in stu){
				if(typeof stu[p] === "object"){
					for(let np in stu[p]){
						if(stu[p][np] != this.stu[p][np]){
							this.isUpdate = true;
							console.log(2, stu[p][np], this.stu[p][np]);
							return;
						}
					}
				}else{
					if(stu[p] != this.stu[p]){
							this.isUpdate = true;
							console.log(1, stu[p], this.stu[p]);
							return;
					}	
				}
			}
			this.isUpdate = false;
		},
		methods: {
			uploadError() {
				console.log("error");
			},
			selectImage(file) {
				this.imageUrl = URL.createObjectURL(file.raw);
				this.imageFile = file;
			},
			handleAvatarSuccess(res, file) {
				this.imageUrl = URL.createObjectURL(file.raw);
			},
			beforeAvatarUpload(file) {
				const isJPG = file.type === 'image/jpeg' || 'image/png';
				const isLt2M = file.size / 1024 / 1024 < 2;

				if(!isJPG) {
					this.$message.error('上传头像图片只能是 JPG/PNG 格式!');
				}
				if(!isLt2M) {
					this.$message.error('上传头像图片大小不能超过 2MB!');
				}
				return isJPG && isLt2M;
			},
			selectDate(time) {
				let now = new Date(),
					nY = now.getFullYear(),
					nM = now.getMonth() + 1,
					nD = now.getDate();

				let selectDate = new Date(time),
					sY = selectDate.getFullYear(),
					sM = selectDate.getMonth() + 1,
					sD = selectDate.getDate();

				let age = nY - sY;
				

				if(nM < sM) {
					age -= 1;
				} else if(nM == sM) {
					if(nD < sD) {
						age -= 1;
					}
				}

				if(age < 17) {
					this.$message.error('年龄小于不能17岁!');
					this.stu.sbirthday = JSON.parse(window.sessionStorage.stu).sbirthday;
					return;
				}
				this.stu.sbirthday = sY+"-" + sM + "-" + sD;
				
					console.log("???")
				if(parseInt(sM) < 10){
					this.stu.sbirthday = sY+"-0" + sM + "-" + sD
				}
				
				this.stu.sage = age;
			},
			onSubmit() {
				let param = "";
				const _this = this;
				_this.isUpdate = false;
				for(let p in this.stu){
					if(p == "user"){
						param += p + ".uno=" + this.stu[p].uno + "&";
						continue;
					}
					if(p == "cls"){
						param += p + ".cno=" + this.stu[p].cno + "&";
						continue;
					}
					param += p + "=" + this.stu[p] + "&"; 
				}
				param += "sessionid=" + window.sessionStorage.sessionId;
				_this.$http.post(
					"/api/StuManager/stuController/updateStu",
					param).then(res => {
					window.sessionStorage.stu = JSON.stringify(res.data.stu);
					_this.stu = res.data.stu;
					_this.$message({message: '信息保存成功！', type: 'success', duration:2000, showClose:true});
				});
			},
			resetForm(stu) {
				this.$refs[stu].resetFields();
			}
		}
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}
	
	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}
	
	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}
	
	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}
</style>
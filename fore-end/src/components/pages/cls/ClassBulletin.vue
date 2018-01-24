<template>
	<EasyScrollbar>

		<div class="ClassBulletin">
			<el-card>
				
			</el-card>
		</div>
	</EasyScrollbar>
</template>

<script>
	export default {
		data() {
			return {
				currentDate: new Date()
			};
		}
	}
</script>

<style scoped="scoped">
	.ClassBulletin {
		width: 100%;
		height: 100%;
	}
	
	.time {
		font-size: 13px;
		color: #999;
	}
	
	.bottom {
		margin-top: 13px;
		line-height: 12px;
	}
	
	.button {
		padding: 0;
		float: right;
	}
	
	.el-card {
		width: 300px;
		height: 100%;
	}
	
	.image {
		width: 100%;
		display: block;
	}
	
	.clearfix:before,
	.clearfix:after {
		display: table;
		content: "";
	}
	
	.clearfix:after {
		clear: both
	}
</style>
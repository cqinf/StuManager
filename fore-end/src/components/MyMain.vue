<template>
	<router-view/>
</template>
<script>
	/*export default {
		created() {
			this.listenerLogin();
		},
		methods: {
			listenerLogin() {
				const _this = this;
				this.$http.post('/api/StuManager/userController/isLogin').then(
					result => {
						console.log(result.data.isLogin);
						_this.$emit('listenerLogin', result.data.isLogin);
					}
				);
			}
		}
	}*/
</script>

<style>

</style>
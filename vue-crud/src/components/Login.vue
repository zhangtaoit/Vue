<template>
    <div id="loginDiv">
        <el-form style="margin-top:20px" ref="form" :model="account" label-width="80px">
            <el-form-item label="账号">
                <el-input v-model="account.userName"></el-input>
            </el-form-item>
            <el-form-item label="密码">
                <el-input type="password" v-model="account.password"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit">登录</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
export default {
  name: 'Login',
  data(){
    return {
        account:{}
    }
  },
  methods: {
      onSubmit:function(){
          this.$http.post("/loginIn",this.account).then(response =>{
              if(response.data.status == 'success'){
                  //将返回的token存放在浏览器中
                  window.localStorage.setItem("jwtToken",response.data.result);
                  this.$message.success("登入成功");
                  //跳转到首页
                  this.$router.push("/home");
              }else {
                  this.$message.success(response.data.message);
              }
          }).catch(error=>{
              this.$message.error(error.message);
          });
      }
  }
}
</script>
<style lang="less" scoped>
    #loginDiv{
        width: 400px;
        margin: 0px auto;
    }
</style>
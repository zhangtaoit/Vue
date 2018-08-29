<template>
    <div id="editMovie" style="width: 40%;margin-left: 25%;">
         <el-form ref="form" :model="movie" style="margin-top:20px" label-width="80px">
            <el-form-item label="电影名称">
                <el-input v-model="movie.title"></el-input>
            </el-form-item>
            <el-form-item label="上映时间">
                <el-date-picker
                    v-model="movie.sendTime"
                    type="date"
                    placeholder="上映时间">
                </el-date-picker>
            </el-form-item>
            <el-form-item label="导演">
                <el-input v-model="movie.director"></el-input>
            </el-form-item>
            <el-form-item label="评分">
                <el-input v-model="movie.rate"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="editMovieBtn">修改</el-button>
                <el-button @click="backList">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
import api from "../const/url"
export default {
    name : "editMovie",
    data() {
       return {
           movie : {}
       }
    },
    methods : {
        backList : function(){
            this.$router.push("/home");
        },
        editMovieBtn : function(){
            this.$http.put(api.editMovie,this.movie).then(response=>{
                if(response.data.status == "success"){
                    this.$message.success("修改成功");
                    this.$router.push("/home");
                }
            }).catch(error=>{
                this.$message.error("系统提示:" + error.message);
            });
        }
    },
    mounted:function(){
      var id = this.$route.params.id;
      this.$http.get("/movie/editMovie/"+id).then(response=>{
          this.movie = response.data.result;
      }).catch(error=>{
          this.$message.error("系统提示:" + error.message);
      });
    }
}
</script>
<style scoped>

</style>


<template>
    <div id="newMovie" style="width: 40%;margin-left: 25%;">
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
                <el-button type="primary" @click="addMovieBtn">保存</el-button>
                <el-button @click="backList">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
import api from "../const/url"
export default {
    name: 'newMovie',
    data(){
        return {
            movie : {}
        }
    },
    methods : {
        addMovieBtn : function(){
            this.$http.post(api.addMovie,this.movie).then(response=>{
                if(response.data.status == 'success'){
                    this.$router.push("/home");
                }else {
                    this.$message.success(response.data.message);
                }
            }).catch(error=>{
                this.$message.error(error.message);
            });
        },
        backList : function(){
            this.$router.push("/home");
        }
    }
}
</script>


<template> 
  <div id="home">
    <el-button type="primary" @click="addMovie">新增</el-button>
    <el-button @click="backList">退出</el-button>
    <el-table :data="movies" stripe height="450" style="width: 100%">
        <el-table-column prop="title" label="电影名称" width="180"></el-table-column>
        <el-table-column prop="sendTime" label="上映时间" width="180"></el-table-column>
        <el-table-column prop="director" label="导演" width="180"></el-table-column>
        <el-table-column prop="rate" label="评分" width="180"></el-table-column>
        <el-table-column
            fixed="right"
            label="操作"
            width="100">
            <template slot-scope="scope">
                <el-button @click="handleEdit(scope.$index,scope.row)" type="text" size="small">编辑</el-button>
                <el-button type="text" size="small" @click="handleDelete(scope.$index,scope.row)">删除</el-button>
            </template>
        </el-table-column>
    </el-table>
  </div>
</template>

<script>
import api from "../const/url"
export default {
  name: 'home',
  data(){
    return {
        movies:[]
    }
  },
  methods: {
      loadData : function(){
          this.$http.get(api.movieHome).then(response => {
            this.movies = response.data.result;
           
          }).catch(error => {
            this.$message.error("系统提示:" + error.message);
          });
      },
      addMovie : function(){
          //跳转新增页面
           this.$router.push("/new");
      },
      backList : function(){
          //跳转首页
          this.$router.push("/");
      },
      handleEdit : function(index,row){
          //修改
          var id = row.title;
          this.$router.push("/edit/"+id);
      },
      handleDelete : function(index,row){
        //删除
        var id = row.title;
        this.$http.post("/movie/delete/"+id).then(response=>{
            this.$message.success("删除成功");
        }).catch(errpr=>{
             this.$message.error("系统提示:" + error.message);
        });
      }
  },
  mounted:function(){
      this.loadData();
  }
}
</script>
<style lang="less" scoped>
    #home{
        width: 63.3%;
        margin-left : 20%
    }
</style>


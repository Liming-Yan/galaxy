<template>
  <div>
    <!-- 面包屑导航栏 -->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>用户管理</el-breadcrumb-item>
      <el-breadcrumb-item>用户信息</el-breadcrumb-item>
    </el-breadcrumb>

    <el-card class="box-card">
      <!-- 搜索框和添加用户 -->
      <el-row class="searchRow" :gutter="20">
        <el-col :span="6">
          <el-input placeholder="请输入内容">
            <el-button slot="append" icon="el-icon-search"></el-button>
          </el-input>
        </el-col>
        <el-col :span="6">
          <el-button type="primary">添加用户</el-button>
        </el-col>
      </el-row>
      <!-- 数据卡片区域 -->
      <el-row>
        <el-col
          :span="6"
          v-for="(o) in 8"
          :key="o"
        >
          <el-card :body-style="{ padding: '0px', margin: '5px' }">
            <img
              src="../assets/zheng.jpg"
              class="image"
            />
            <div class="starNameDiv">
              <span class="starNameSpan">{{ o }}</span>
            </div>
          </el-card>
        </el-col>
      </el-row>
      <el-row>
        <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage4"
      :page-sizes="[100, 200, 300, 400]"
      :page-size="100"
      layout="total, sizes, prev, pager, next, jumper"
      :total="400">
    </el-pagination>
      </el-row>
    </el-card>
  </div>
</template>

<style lang="less" scoped>
.image{
  width: 50%;
}
.starNameSpan{
  // width: 50%;
  margin: 5px;
}
.starNameDiv{
width: 50%;
text-align: center;
}
.searchRow{
  margin-bottom: 15px;
}
</style>

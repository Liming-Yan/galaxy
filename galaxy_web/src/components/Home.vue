<template>
  <el-container>
    <!-- 头部区域 -->
    <el-header>
      <div>
        <img class="logo" src="../assets/zheng.jpg" alt="" />
        <span>Galaxy</span>
      </div>
      <el-button type="info" @click="logout">退出</el-button>
    </el-header>
    <!-- 主体区域 -->
    <el-container>
      <!-- 侧边栏 -->
      <el-aside :width="isCollapse ? '64px' : '200px'">
        <div class="toggle_button" @click="toggleCollapse">
            {{ isCollapse ? '&gt;' : '&lt;' }}
        </div>
        <!--
            unique-opened 只有一个菜单展开
            router 开启路由模式，点击实现跳转
         -->
        <el-menu
          background-color="#606266"
          text-color="#fff"
          active-text-color="#ffd04b"
          :unique-opened="true"
          :collapse = "isCollapse"
          :collapse-transition = "false"
          :router="true"
          :default-active="activePatn"
        >
          <!-- 一级菜单 -->
          <el-submenu
            :index="item.id + ''"
            v-for="item in menuList"
            :key="item.id"
          >
            <template slot="title">
              <!-- 图标 -->
              <i class="el-icon-d-caret"></i>
              <!-- 文本 -->
              <span>{{ item.authName }}</span>
            </template>
            <!-- 二级菜单 -->
            <el-menu-item
              :index="subItem.path + ''"
              v-for="subItem in item.children"
              :key="subItem.id"
              @click="saveActivePath(subItem.path + '')"
            >
              <template slot="title">
                <!-- 图标 -->
                <i class="el-icon-caret-right"></i>
                <!-- 文本 -->
                <span>{{ subItem.authName }}</span>
              </template>
            </el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>
      <!-- 主体区域 -->
      <el-main>
        <!-- 路由占位符 -->
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  created() {
    this.getMenuList()
    this.activePatn = window.sessionStorage.getItem('activePath')
  },
  data() {
    return {
      //   左侧菜单数据
      menuList: [],
      tmpMenuList: [
        {
          id: 1,
          authName: '用户管理',
          children: [
            { id: 11, authName: '用户信息', path: '/userInfo' },
            { id: 12, authName: '二级菜单2', path: '/1222' },
            { id: 13, authName: '二级菜单3', path: '/1333' }
          ]
        },
        {
          id: 2,
          authName: '一级菜单2',
          children: [
            { id: 21, authName: '二级菜单1', path: '/2111' },
            { id: 22, authName: '二级菜单2', path: '/2222' },
            { id: 23, authName: '二级菜单3', path: '/2333' }
          ]
        },
        {
          id: 3,
          authName: '一级菜单3'
        //   children: []
        }
      ],
      // 控制左侧菜单的折叠
      isCollapse: false,
      activePatn: ''
    }
  },
  methods: {
    logout() {
      window.sessionStorage.removeItem('token')
      window.sessionStorage.removeItem('activePath')
      this.$router.push('/login')
    },
    // 发送请求获取左侧菜单栏数据
    async getMenuList() {
      //   const { data: res } = await this.$http.get('menus')
      //   if (res.status !== 200) {
      //     return this.$message.error(res.message)
      //   }
      //   this.menuList = res.data
      this.menuList = this.tmpMenuList
    },
    toggleCollapse() {
      this.isCollapse = !this.isCollapse
    },
    saveActivePath(activePath) {
      window.sessionStorage.setItem('activePath', activePath)
      this.activePatn = activePath
    }
  }
}
</script>

<style lang="less" scoped>
.el-header {
  background-color: #303133;
  display: flex;
  justify-content: space-between;
  padding: 0 10px;
  align-items: center;
  color: #fff;
  > div {
    display: flex;
    align-items: center;
    > img {
      width: 54px;
      border-radius: 50%;
    }
    > span {
      margin-left: 10px;
    }
  }
}
.el-aside {
  background-color: #606266;
  .toggle_button{
      background-color: rgb(26, 25, 25);
      font-size: 14px;
      line-height: 24px;
      color: #fff;
      text-align: center;
      // 字体间距
      letter-spacing: 0.2em;
      // 鼠标放上去变小手
      cursor: pointer;
  }
  .el-menu{
    border-right: 0px;
}
}
.el-main {
  background-color: #eee;
}
.el-container {
  height: 100%;
}
</style>

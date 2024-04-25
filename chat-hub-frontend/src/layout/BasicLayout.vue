<template>
  <!--  顶部导航栏-->
  <van-nav-bar
      title="标题"
      right-text="按钮"
      left-arrow
      @click-left="onClickLeft"
      @click-right="onClickRight"
  >
    <!--  导航栏插槽-->
    <template #right>
      <van-icon name="search" size="18" />
    </template>
  </van-nav-bar>

<!--  内容-->
  <div id="content">
    <router-view />
  </div>

<!--  底部菜单栏-->
  <van-tabbar route>
    <van-tabbar-item to="/" icon="home-o" name="index">主页</van-tabbar-item>
    <van-tabbar-item to="/team" icon="search" name="team">队伍</van-tabbar-item>
    <van-tabbar-item to="/chat" icon="friends-o" name="chat">聊天</van-tabbar-item>
    <van-tabbar-item to="/user" icon="setting-o" name="user">自己</van-tabbar-item>
  </van-tabbar>
</template>


<script setup>
// import
import {useRouter} from "vue-router";

const router = useRouter();
//导航栏
const onClickLeft = () => history.back();
const onClickRight = () => {
  router.push('/search')
}
</script>



<style scoped>

</style>
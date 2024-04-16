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
  <div id="content">
    <template v-if="active === 'index'">
      <Index />
    </template>
    <template v-if="active === 'team'">
      <Team />
    </template>
  </div>

<!--  底部菜单栏-->
  <van-tabbar v-model="active" @change="onChange">
    <van-tabbar-item icon="home-o" name="index">主页</van-tabbar-item>
    <van-tabbar-item icon="search" name="team">队伍</van-tabbar-item>
    <van-tabbar-item icon="friends-o" name="chat">聊天</van-tabbar-item>
    <van-tabbar-item icon="setting-o" name="user">自己</van-tabbar-item>
  </van-tabbar>
</template>

<script setup>
// import
import { ref } from 'vue';
import { Toast } from 'vant';
import Index from "../pages/Index.vue";
import Team from "../pages/Team.vue";
//导航栏
const onClickLeft = () => history.back();
//菜单栏
const active = ref("index");
const onChange = (index) => Toast(`标签 ${index}`);
</script>



<style scoped>

</style>
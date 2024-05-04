<template>
  <template v-if="user">
    <van-cell title="头像" is-link to="/user/edit" @click="toEdit('avatarUrl','头像 ', user.avatarUrl)">
      <img :src="user.avatarUrl" style="height: 50px"/>
    </van-cell>
    <van-cell title="用户名" is-link to="/user/edit" :value="user.username"
              @click="toEdit('username','用户名', user.username)"/>
    <van-cell title="标签" is-link to="/user/edit" :value="user.tags"
              @click="toEdit('tags','标签', user.tags)"/>
    <van-cell title="性别" is-link to="/user/edit" :value="user.gender"
              @click="toEdit('gender','性别', user.gender)"/>
    <van-cell title="手机号" is-link to="/user/edit" :value="user.phone"
              @click="toEdit('phone','手机号', user.phone)"/>
    <van-cell title="邮箱" is-link to="/user/edit" :value="user.email"
              @click="toEdit('email','邮箱', user.email)"/>
    <van-cell title="账号" :value="user.userAccount" @click="toEdit('userAccount','账号', user.userAccount)"/>
    <van-cell title="注册时间" :value="user.createTime"
              @click="toEdit('createTime','注册时间', user.createTime)"/>
  </template>
</template>

<script setup lang="ts">
import {useRouter} from "vue-router";
import {onMounted, ref} from "vue";
import myAxios from "../plugins/myAxios.ts";
import {showFailToast} from "vant";

const user = ref();
const router = useRouter();

onMounted(async () => {
  const res = await myAxios.get('/user/current')
  if (res.data.code === 0) {
    user.value = res.data.data;
  } else {
    showFailToast('用户信息获取失败');
  }
})

const toEdit = (editKey: string, editName: string, currentValue: string) => {
  router.push({
    path: '/user/edit',
    query: {
      editKey,
      editName,
      currentValue,
    }
  })
}


</script>

<style scoped>

</style>
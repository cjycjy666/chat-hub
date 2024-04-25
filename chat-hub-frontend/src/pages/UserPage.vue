<template>
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
  <van-cell title="注册时间" :value="user.createTime.toDateString()"
            @click="toEdit('createTime','注册时间', user.createTime)"/>
</template>

<script setup lang="ts">
import {useRouter} from "vue-router";

const user = {
  id: 1,
  username: '123',
  userAccount: '123',
  avatarUrl: 'http://blog.cjy.world/wp-content/uploads/2024/04/3.jpg',
  gender: 1,
  phone: '123',
  email: '123',
  tags: '123',
  createTime: new Date()
}

const router = useRouter();
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
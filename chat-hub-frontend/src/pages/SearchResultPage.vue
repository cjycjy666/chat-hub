<template>
  <van-card
      v-for="user in userList"
      :desc="user.profile"
      :title="user.username"
      :thumb="user.avatarUrl"
  >
    <template #tags>
      <van-tag plain type="primary" v-for="tag in user.tags" style="margin-right: 8px; margin-top: 20px">
        {{ tag }}
      </van-tag>
    </template>
    <template #footer>
      <van-button size="small" @click="follow">关注</van-button>
      <van-button size="small" @click="toChat">私聊</van-button>
    </template>
  </van-card>
  <van-empty v-if="!userList || userList.length < 1" description="未找到用户"/>
</template>

<script setup lang="ts">
import {onMounted, ref} from "vue";
import {useRoute} from "vue-router";
import myAxios from "../plugins/myAxios.ts"
import qs from 'qs';
import {Usertype} from "../models/user";

const route = useRoute();

const userList = ref([]);
const {tags} = route.query;
onMounted(async () => {
  // 为给定 ID 的 user 创建请求
  const userListData: Usertype[] = await myAxios.get('/user/search/tags', {
    params: {
      tagNameList: tags
    },
    paramsSerializer: params => {
      return qs.stringify(params, {indices: false})
    }
  })
      .then(function (response) {
        console.log('/user/search/tags', response);
        return response.data?.data;
      })
      .catch(function (error) {
        console.error('/user/search/tags', error);
      });
  if (userListData) {
    userListData.forEach(user => {
      if (user.tags) {
        user.tags = JSON.parse(user.tags);
      }
    })
    userList.value = userListData;
  }
})
const follow = () => {
  // todo 关注功能开发
}
const toChat = () => {
  // todo 聊天功能开发
}
</script>

<style scoped>

</style>
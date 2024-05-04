<template>
  <!--  搜索框-->
  <form action="/">
    <van-search
        v-model="searchText"
        show-action
        shape="round"
        placeholder="请输入搜索标签"
        @search="onSearch"
        @cancel="onCancel"
    />
  </form>
  <!--  标签-->
  <van-divider content-position="left">已选标签</van-divider>
  <div v-if="activeIds.length === 0" style="padding: 10px">请选择标签</div>
  <van-row justify="space-around" :gutter="[10, 10]" style="padding: 10px">
    <van-col>
      <van-tag v-for="tag in activeIds" closeable size="medium" round type="primary" @close="doClose(tag)" style="margin-right: 5px">
        {{ tag }}
      </van-tag>
    </van-col>
  </van-row>

  <van-divider content-position="left">选择标签</van-divider>
  <van-tree-select
      v-model:active-id="activeIds"
      v-model:main-active-index="activeIndex"
      :items="tagList"
  />
  <div style="padding: 20px">
    <van-button block type="primary" @click="doSearchResult">搜索</van-button>
  </div>
</template>

<script setup lang="ts">
import {ref} from 'vue';
import {useRouter} from "vue-router";

const router = useRouter();
const searchText = ref('');
const originTagList = [
  {
    text: '浙江',
    children: [
      {text: '杭州', id: '杭州'},
      {text: '温州', id: '温州'},
      {text: '宁波', id: '宁波', disabled: true},
    ],
  },
  {
    text: '江苏',
    children: [
      {text: '南京', id: '南京'},
      {text: '无锡', id: '无锡'},
      {text: '徐州', id: '徐州'},
    ],
  },
  {text: '福建', disabled: true},
];
let tagList = ref(originTagList);
//搜索标签
const onSearch = () => {
  tagList.value = originTagList.map(parentTag => {
    // 创建 parentTag 的副本
    const tempParentTag = { ...parentTag };
    // 确保 parentTag.children 是一个数组
    if (Array.isArray(tempParentTag.children)) {
      // 复制 parentTag.children 数组
      const tempChildren = [...tempParentTag.children];
      // 过滤子项并更新 parentTag 的 children 属性
      tempParentTag.children = tempChildren.filter(item => item.text.includes(searchText.value));
    } else {
      // 如果 parentTag.children 不是一个数组，则将其置为空数组或其他适当的值
      tempParentTag.children = [];
    }
    return tempParentTag;
  });
}

//取消
const onCancel = () => {
  searchText.value = '';
  tagList.value = originTagList;
}

//已选择的标签
const activeIds = ref([]);
const activeIndex = ref(0);
//移除标签
const doClose = (tag) => {
  activeIds.value = activeIds.value.filter(item => {
    return item !== tag;
  })
};

const doSearchResult = () => {
  router.push({
    path: '/user/list',
    query: {
      tags: activeIds.value
    }
  })
}

</script>

<style scoped>

</style>
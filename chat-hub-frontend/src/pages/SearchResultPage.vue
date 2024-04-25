<template>

</template>

<script setup lang="ts">
import {ref} from "vue";
import {useRoute} from "vue-router";

const route = useRoute();
const searchText = ref('');
const { tags } = route.query;
</script>

<style scoped>

</style>
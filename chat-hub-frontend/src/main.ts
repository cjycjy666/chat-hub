import { createApp } from 'vue'
import Vant from 'vant'
import 'vant/lib/index.css'
import * as VueRouter from 'vue-router';
import App from './App.vue'
import routes from "./config/route.ts";



const app = createApp(App);
// 创建路由实例并传递 `routes` 配置
const router = VueRouter.createRouter({
    // 使用 hash 模式。
    history: VueRouter.createWebHashHistory(),
    routes, // `routes: routes` 的缩写
})

app.use(router);
app.use(Vant);
app.mount('#app')
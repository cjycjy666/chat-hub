import Index from "../pages/Index.vue";
import Team from "../pages/Team.vue";
import Chat from "../pages/Chat.vue";
import UserPage from "../pages/UserPage.vue";
import Search from "../pages/Search.vue";
import UserEditPage from "../pages/UserEditPage.vue";
import SearchResultPage from "../pages/SearchResultPage.vue";
import UserLoginPage from "../pages/UserLoginPage.vue";



// 定义一些路由
// 每个路由都需要映射到一个组件。
const routes = [
    {path: '/', component: Index},
    {path: '/team', component: Team},
    {path: '/chat', component: Chat},
    {path: '/user', component: UserPage},
    {path: '/search', component: Search},
    {path: '/user/list', component: SearchResultPage},
    {path: '/user/edit', component: UserEditPage},
    {path: '/user/login', component: UserLoginPage},
]

export default routes;
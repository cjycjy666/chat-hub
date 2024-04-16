import { createApp } from 'vue'
import { Button, NavBar, Icon, Tabbar, TabbarItem} from 'vant'
import App from './App.vue'


const app = createApp(App);
app.use(Button);
app.use(NavBar);
app.use(Icon);
app.use(Tabbar);
app.use(TabbarItem);
app.mount('#app')
import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import registration from '@/components/registration'
import profile from '@/components/profile'
import page404 from '@/components/page404'


Vue.use(Router)

export default new Router({
  mode: 'history', //Убираем решетку из URLa
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    }, {
      path: '/home',
      name: 'Home',
      component: Home
    }, {
      path: '/registration',
      name: 'registration',
      component: registration
    }, {
      path: '/profile',
      name: 'profile',
      component: profile
    },
    //Любой левый URL кидает на Home
    { path: "*", component: page404}
  ]
})

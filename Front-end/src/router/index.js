import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import registration from '@/components/registration/registration'
import pr from '@/components/pr'
import profile_page from '@/components/profile_page/mainpage'
import page404 from '@/components/page404/page404'
import teststore from '@/components/teststore'
import teststore2 from '@/components/teststore2'
Vue.use(Router)

export default new Router({
  // mode: 'history', //Убираем решетку из URLa
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    /* {
       path: '/home',
       name: 'Home',
       component: Home
     }, */
     {
      path: '/registration',
      name: 'registration',
      component: registration
    },{
      path: '/pr',
      name: 'pr',
      component: pr
    }, {
      path: '/profile',
      name: 'profile',
      component: profile_page
    }, {
      path: '/store',
      name: 'store',
      component: teststore
    },
    {
      path: '/store2',
      name: 'store2',
      component: teststore2
    },
    //Любой левый URL кидает на Home
    { path: "*", component: page404}
  ]
})

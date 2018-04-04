import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import registration from '@/components/registration'
import reg from '@/components/reg'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    }, {
      path: '/registration',
      name: 'registration',
      component: registration
    }, {
      path: '/reg',
      name: 'reg',
      component: reg
    }
  ]
})

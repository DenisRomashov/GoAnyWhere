import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import registration from '@/components/registration/registration'

import profile_page from '@/components/profile_page/mainpage'
import profile from '@/components/profile_page/components/profile'
import myMeetings from '@/components/profile_page/components/myMeetings'
import allMeetings from '@/components/profile_page/components/allMeetings'
import createMeeting from '@/components/profile_page/components/createMeeting'

import page404 from '@/components/page404/page404'

//Эксперементальное, удалить при готовности
import pr from '@/components/pr'
import teststore from '@/components/teststore'
import teststore2 from '@/components/teststore2'
import pagewithmeetings from '@/components/for_construction/pagewithmeetings'

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
      redirect: '/profile/info',
      component: profile_page,
      children: [
        { path: 'info', component: profile},
        { path: 'my_meetings', component: myMeetings},
        { path: 'all_meetings', component: allMeetings},
        { path: 'new_meeting', component: createMeeting}
      ]
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
    {
      path: '/page',
      name: 'pagewithmeetings',
      component: pagewithmeetings
    },
    //Любой левый URL кидает на Home
    { path: "*", component: page404}
  ]
})

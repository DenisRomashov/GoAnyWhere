// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import Vuesax from 'vuesax'
import Vuex from 'vuex'

//import store Vuex
import store from './store'


//Если использовать компоненты BootstrapVue включить!
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
//import 'vuesax/dist/vuesax.css' //vuesax styles
import axios from 'axios'
import VueAxios from 'vue-axios'


//Если использовать компоненты BootstrapVue включить!
Vue.use(BootstrapVue);
//Vue.use(Vuesax);
Vue.use(VueAxios, axios);
//Vuex
//Vue.use(Vuex)

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  store, // inject store to all children
  router,
  components: { App },
  template: '<App/>'
})

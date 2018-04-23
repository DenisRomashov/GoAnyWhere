import Vue from 'vue'
import Vuex from 'vuex'
import plugins from './plugins'
import { state, getters, actions, mutations } from './mutations'

Vue.use(Vuex)

export default new Vuex.Store({
  plugins,
  state,
  getters,
  actions,
  mutations
})

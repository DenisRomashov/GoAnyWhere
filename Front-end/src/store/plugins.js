import {STORAGE_USER_INFO,  STORAGE_KEY } from './mutations'
import createLogger from 'vuex/dist/logger'

export const localStoragePlugin = store => {
  store.subscribe((mutation, { userInfo }) => {
      window.localStorage.setItem(STORAGE_USER_INFO, JSON.stringify(userInfo))
    })



   // window.localStorage.setItem(STORAGE_USER_ID, JSON.stringify("name: Denis"))

/*    store.subscribe((mutation, { count }) => {
    window.localStorage.setItem(STORAGE_KEY, JSON.stringify(count))
  })
*/
}

export default process.env.NODE_ENV !== 'production'
  ? [createLogger(), localStoragePlugin]
  : [localStoragePlugin]

export const STORAGE_KEY = 'GoAnyWhere-storage'
export const STORAGE_USER_INFO = 'GoAnyWhere_user_info'



// initial state
export const state = {
  // userID: 0,
  //count: JSON.parse(window.localStorage.getItem(STORAGE_KEY) || '[]')
  count: 0,
  // userInfo: JSON.parse(window.localStorage.getItem(STORAGE_USER_INFO) || '[]')
}

// getters
export const getters = {

  getUserId: state => {
    return state
  },

  countState: state => {
    return state
  },

  getCount: state => {
    return state
  }
}

// actions
export const actions = {

}

// mutations
export const mutations = {

  // initUserInfo (state, userID) {
  //
  // },

  setUserInfo(state, userID) {
    userID.id = 15;
  },

  increment (state) {
    state.count++

  }

}

<template lang="html">
<div class="profilepage">
  <b-container fluid class="gridFullPage">
      <b-row>
        <b-col>
          <b-navbar toggleable="md" type="dark" variant="dark" fixed="top">

            <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>


            <b-navbar-brand href="/">GoAnyWhere</b-navbar-brand>

            <!-- Кнопка HOME с роутер линк на главную страницу -->
            <b-collapse is-nav id="nav_collapse">
            <b-navbar-nav>
              <router-link :to="{ path: '/' }"><b-button size="" variant="outline-danger" class="mb-2 mr-sm-2 mb-sm-0" type="submit">Home</b-button></router-link>
            </b-navbar-nav>

            <b-form-input size="" class="mb-2 mr-sm-2 mb-sm-0" type="text" placeholder="Поиск" />
            <b-button size="" class="mb-2 mr-sm-2 mb-sm-0" type="submit" variant="warning"> Поиск </b-button>

          </b-collapse>

            <!-- Right aligned nav items -->
            <b-navbar-nav class="ml-auto">

              <b-nav-form>
                <!-- Поиск -->
                <!-- <b-form-input size="" class="mr-sm-2" type="text" placeholder="Поиск" />
                <b-button size="" class="my-2 my-sm-0" type="submit" variant="warning"> Поиск </b-button> -->
              </b-nav-form>
            </b-navbar-nav>
          </b-navbar>
        </b-col>
      </b-row>
      </b-container>
      <b-container fluid class="ProfileNavigation">
      <div class="BlockAfterNavbar">
        <b-row id="FirstRow">
          <!-- left column -->
          <b-col>

          </b-col>
          <b-col cols="10">
            <div id="ButtonRow">
              <b-button-group size="lg" variant="warning">

                <!-- Кнопки навигации -->
                <b-button v-on:click="showCreation=false, showAll=false, showMyMeetings=false, showProfile=true" variant="dark">Профиль</b-button>
                <b-button v-on:click="showCreation=false, showAll=false, showProfile=false, showMyMeetings=true" variant="dark">Мои события</b-button>
                <b-button v-on:click="showCreation=false, showAll=true, showProfile=false, showMyMeetings=false" variant="dark">Все события</b-button>
                <b-button v-on:click="showCreation=true, showAll=false, showProfile=false, showMyMeetings=false" variant="dark">Создать событие</b-button>

                <!-- Кнопка выхода -->
                <b-button @click="showModal" variant="danger">Выйти</b-button>
              </b-button-group>
            </div>
          </b-col>
          <b-col>
          </b-col>
        </b-row>
      </div>
    </b-container>


      <b-container class="Profile">
            <b-row>
                <b-col></b-col>

                <b-col cols="10">
                    <allMeetings v-if="showAll"/>
                    <createMeeting v-if="showCreation"/>
                    <profile v-if="showProfile"/>
                    <myMeetings v-if="showMyMeetings"/>
                </b-col>

                <b-col></b-col>
            </b-row>
      </b-container>

<!-- Вставка футера -->
  <footerone/>

<!-- Всплывающее окно выхода -->
  <div>
    <b-modal ref="Exit" hide-footer title="Уже уходите!? :(">
      <div class="d-block text-center">
      </div>
      <b-btn class="mt-3" variant="primary" block @click="hideModal">Остаться!</b-btn>
      <b-btn class="mt-3" variant="danger" block @click="exit">Выйти</b-btn>
    </b-modal>
  </div>


</div>
</template>


<!-- Script  -->
<script>
import router from '../../router'
import footerone from '../footerone'
import allMeetings from './components/allMeetings'
import createMeeting from './components/createMeeting'
import myMeetings from './components/myMeetings'
import profile from './components/profile'
export default {
  data () {
    return {
      form: {
        name: ''
      },
        showCreation: false,
        showAll: false,
        showMyMeetings: false,
        showProfile: true
    }
  },
  methods: {
    exit() {
      window.localStorage.removeItem('STORAGE_USER_INFO');
      router.push({ path: '/' });
    },

    showModal () {
      this.$refs.Exit.show()
    },

    hideModal () {
     this.$refs.Exit.hide()
   }
  },
  components: {
    footerone,
    allMeetings,
    createMeeting,
    myMeetings,
    profile
  },
  router
}
</script>

<!-- Style -->
<style lang="css">
#FirstRow {
    background-color: #343a40;
    color: white;
    margin-top: -4px;
}

#creationMeeting {
  /* height: 10em; */
  display: flex;
  align-items: center;
  justify-content: center
}


.profilepage {
  margin-top: -4px;
  /* background-color: #DCDCDC; */
  background-image: url("../../assets/background_profile.jpg");
  background-size: cover;
}

</style>

<template lang="html">
<div class="mainpage">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
  <b-container fluid class="gridFullPage">
      <b-row>
        <b-col>
          <b-navbar toggleable="md" type="dark" variant="dark" fixed="top">

            <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>

            <b-navbar-brand href="/">GoAnyWhere</b-navbar-brand>

            <!-- Кнопка HOME с роутер линк на главную страницу -->
            <b-collapse is-nav id="nav_collapse">
            <b-navbar-nav>
              <router-link :to="{ path: '/' }"><b-button size="" variant="outline-danger" class="mb-2 mr-sm-2 mb-sm-0" type="submit">Home <i class="fas fa-home"></i></b-button></router-link>
            </b-navbar-nav>

              <div id="ButtonRow">
                  <!-- Кнопки навигации -->
                  <b-button v-on:click="goToProfile()" variant="dark" size="lg">Профиль</b-button>
                  <b-button v-on:click="goToMyMeetings()" variant="dark" size="lg">Мои события</b-button>
                  <b-button v-on:click="goToAllMeetings()" variant="dark" size="lg">Все события</b-button>
                  <b-button v-on:click="goToCreationMeeting()" variant="dark" size="lg">Создать событие</b-button>
              </div>
              <!-- Кнопка выхода -->
              <b-navbar-nav class="ml-auto">
                  <b-button @click="showModal" size="lg" variant="dark">Выйти <i class="fas fa-sign-out-alt"></i></b-button>
              </b-navbar-nav class="ml-auto">
                <!-- </b-button-group> -->
              <!-- </div> -->
            <!-- </b-navbar-nav> -->
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


      <!-- Навигация по компонентам -->

    <transition :name="transitionName">
      <router-view></router-view>
      </transition>
      <!-- Вставка футера -->
      <footerone/>

  <!-- ExitModalForm -->
  <div class="ExitModalForm">
    <b-modal ref="Exit"
             :title="titleExitModal"
             header-bg-variant="white"
             header-text-variant="dark"
             body-bg-variant="light"
             body-text-variant="dark"
             footer-bg-variant="dark"
             footer-text-variant="light">
       <b-container fluid>
         <div class="d-block text-center">
         </div>
         <b-btn size="" class="mt-3" variant="outline-dark" block @click="hideModal">Остаться!</b-btn>
         <b-btn size=""class="mt-3" variant="outline-danger" block @click="exit">Выйти</b-btn>
       </b-container>

       <div slot="modal-footer" class="w-100">
         <p class="float-left">© GoAnyWhere Project 2018</p>
       </div>
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
        titleExitModal: '',
        transitionName: 'slide-left'
    }
  },
  methods: {
    exit() {
      window.localStorage.removeItem('STORAGE_USER_INFO');
      router.push({ path: '/' });
    },

    showModal () {
      this.titleExitModal = JSON.parse(window.localStorage.getItem('STORAGE_USER_INFO')).userName + ', уже уходите!? :(';
      this.$refs.Exit.show()
    },

    hideModal () {
     this.$refs.Exit.hide()
   },
   goToProfile () {
     router.push({ path: '/profile/info' });
   },
   goToMyMeetings() {
     router.push({ path: '/profile/my_meetings' });
   },
   goToAllMeetings() {
     router.push({ path: '/profile/all_meetings' });
   },
   goToCreationMeeting() {
     router.push({ path: '/profile/new_meeting' });
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

#ButtonRow {
  margin-left: 12%;
  margin-right: auto;
}

.mainpage {
    margin-top: -4px;
}

.ProfileNavigation {
  position: fixed;
  z-index: 1000;
}

.profilepage {

  /* position: fixed; */
  /* background-color: #DCDCDC; */
  background-image: url("../../assets/background_profile.jpg");
  background-size: cover;
  background-attachment: fixed;
  background-repeat: no-repeat;
  background-position: top;
}

.myMeetings {
    /* margin-top: 50px; */
    margin-top: 7px;
    margin-bottom: -10px;
    background-image: url("../../assets/background_profile.jpg");
    background-size: cover;
    background-attachment: fixed;
    background-repeat: no-repeat;
    background-position: top;
}

.allMeetings {
  margin-bottom: -10px;
  background-image: url("../../assets/background_profile.jpg");
  background-size: cover;
  background-attachment: fixed;
  background-repeat: no-repeat;
  background-position: top;

}

.creationMeeting {
  margin-top: px;
  margin-bottom: px;
  background-image: url("../../assets/background_profile.jpg");
  background-size: cover;
  background-attachment: fixed;
  background-repeat: no-repeat;
  background-position: top;
}
</style>

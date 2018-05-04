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
          <b-col></b-col>
          <!-- central culumn -->
          <b-col cols="10">
            <div id="ButtonRow">
                <b-button-group size="lg">
                <!-- Кнопки навигации -->
                <!-- <b-row>
                  <b-col><b-button v-on:click="showCreation=false, showAll=false, showMyMeetings=false, showProfile=true" size="lg" variant="dark">Профиль</b-button></b-col>
                  <b-col><b-button v-on:click="showCreation=false, showAll=false, showProfile=false, showMyMeetings=true" size="lg" variant="dark">Мои события</b-button></b-col>
                  <b-col><b-button v-on:click="showCreation=false, showAll=true, showProfile=false, showMyMeetings=false" size="lg" variant="dark">Все события</b-button></b-col>
                  <b-col><b-button v-on:click="showCreation=true, showAll=false, showProfile=false, showMyMeetings=false" size="lg" variant="dark">Создать событие</b-button></b-col> -->

                <b-button v-on:click="showCreation=false, showAll=false, showMyMeetings=false, showProfile=true" variant="dark">Профиль</b-button>
                <b-button v-on:click="showCreation=false, showAll=false, showProfile=false, showMyMeetings=true" variant="dark">Мои события</b-button>
                <b-button v-on:click="showCreation=false, showAll=true, showProfile=false, showMyMeetings=false" variant="dark">Все события</b-button>
                <b-button v-on:click="showCreation=true, showAll=false, showProfile=false, showMyMeetings=false" variant="dark">Создать событие</b-button>

                <!-- Кнопка выхода -->
                <b-button @click="showModal" size="lg" variant="dark">Выйти <i class="fas fa-sign-out-alt"></i></b-button>
                <!-- <b-col><b-button @click="showModal" size="lg" variant="dark">Выйти</b-button></b-col> -->
                <!-- </b-row> -->
              </b-button-group>
            </div>
          </b-col>
          <!-- righ culumn -->
            <b-col></b-col>
          </b-row>
        </div>

      </b-container>

      <!-- <b-container class="Profile">
        <br>
        <br>
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
      </b-container> -->


      <div class="profilepage" v-if="showProfile">
        <b-container >
              <b-row>
                  <b-col></b-col>
                  <b-col cols="10">
                  <!-- Страница профайла -->
                  <br>
                      <profile/>
                  <br>
                  <!-- ___________________________    -->
                  </b-col>
                  <b-col></b-col>
                </b-row>
              </b-container>
        </div>

      <div class="myMeetings" v-if="showMyMeetings">
        <b-container fluid>
                  <!-- Мои события -->
                      <myMeetings/>
        </b-container>
      </div>

      <div class="allMeetings" v-if="showAll">
        <b-container fluid>
                  <!-- Все события -->
                    <allMeetings/>
        </b-container>
      </div>

      <div class="creationMeeting" v-if="showCreation">
        <b-container fluid>
                  <!-- Страница создания события -->
                  <br>
                    <createMeeting/>
                  <br>
        </b-container>
      </div>


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
        showCreation: false,
        showAll: false,
        showMyMeetings: false,
        showProfile: true,
        titleExitModal: ''
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

.mainpage {
    margin-top: -4px;
}

.ProfileNavigation {
  position: fixed;
  z-index: 1000;
}

.profilepage {
  margin-top: 25px;
  margin-bottom: -10px;
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
    margin-top: 40px;
    margin-bottom: -10px;
    background-image: url("../../assets/background_profile.jpg");
    background-size: cover;
    background-attachment: fixed;
    background-repeat: no-repeat;
    background-position: top;
}

.allMeetings {
  margin-top: 44px;
    background-image: url("../../assets/1.jpg");
    height: 500px;
    background-size: cover;
}

.creationMeeting {
  margin-top: 25px;
  margin-bottom: -25px;
  background-image: url("../../assets/background_profile.jpg");
  background-size: cover;
  background-attachment: fixed;
  background-repeat: no-repeat;
  background-position: top;
}

</style>

<template lang="html">
<div class="profilepage">
  <b-container fluid class="gridFullPage">
      <b-row>
        <b-col>
          <b-navbar toggleable="md" type="dark" variant="dark" fixed="top">

            <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>


            <b-navbar-brand href="/">GoAnyWhere</b-navbar-brand>

            <!-- Кнопка HOME с роутер линк на главную страницу -->
            <b-navbar-nav>
              <router-link :to="{ path: '/' }"><b-button size="" variant="outline-danger" class="mb-2 mr-sm-2 mb-sm-0" type="submit">Home</b-button></router-link>
            </b-navbar-nav>

            <b-form-input size="" class="mb-2 mr-sm-2 mb-sm-0" type="text" placeholder="Поиск" />
            <b-button size="" class="mb-2 mr-sm-2 mb-sm-0" type="submit" variant="warning"> Поиск </b-button>

            <b-collapse is-nav id="nav_collapse"></b-collapse>

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
                <b-button v-on:click="exit()" variant="danger">Выйти</b-button>
              </b-button-group>
            </div>
          </b-col>
          <b-col>

          </b-col>
        </b-row>
        <b-row>
          <b-col> </b-col>

              <b-col cols="10">
                <allMeetings v-if="showAll"/>
                <createMeeting v-if="showCreation"/>
                <profile v-if="showProfile"/>
                <myMeetings v-if="showMyMeetings"/>
               </b-col>

          <b-col> </b-col>
        </b-row>
      </div>



    </b-container>

  <footerone/>

</div>
</template>


<!-- Script  -->
<script>
import footerone from '../footerone'
import allMeetings from './allMeetings'
import createMeeting from './createMeeting'
import myMeetings from './myMeetings'
import profile from './profile'
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
    }
  },
  components: {
    footerone,
    allMeetings,
    createMeeting,
    myMeetings,
    profile
  }
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
  background-color: #DCDCDC;
}

</style>

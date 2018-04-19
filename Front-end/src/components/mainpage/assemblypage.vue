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
                <b-button v-on:click="showCreation=true, showAll=false, showProfile=false" variant="dark">Создать событие</b-button>
                <b-button v-on:click="showCreation=false, showAll=true, showProfile=false" variant="dark">Все события</b-button>
                <b-button v-on:click="showCreation=false, showAll=false, showProfile=true" variant="dark">Профиль</b-button>
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
               </b-col>

            <!--Создание события  -->
            <!-- <b-container id="creationMeeting" v-if="showCreation">

              <b-col cols="10">
                <b-form>
                    <h1>Создание события</h1>
                </b-form>
              </b-col>
            </b-container> -->
            <!--Все события  -->
            <!-- <b-container id="creationMeeting"  v-if="showAll">

              <b-col cols="10">
                <b-form>
                    <h1>Все события</h1>
                </b-form>
              </b-col>
            </b-container> -->

            <!-- Профиль  -->
            <!-- <b-container id="creationMeeting"  v-if="showProfile">

              <b-col cols="10">
                <b-form>
                    <h1>Профиль</h1>
                </b-form>
              </b-col>
            </b-container> -->


          <b-col> </b-col>
        </b-row>
      </div>


      <!--Создание события  -->
    </b-container>
    <!-- <allMeetings v-if="showAll"/>
    <createMeeting v-if="showCreation"/>
    <profile v-if="showProfile"/> -->
  <footerone/>

</div>
</template>


<!-- Script  -->
<script>
import footerone from '../footerone'
import allMeetings from './allMeetings'
import createMeeting from './createMeeting'
import profile from './profile'
export default {
  data () {
    return {
      form: {
        name: ''
      },
        showCreation: true,
        showAll: false,
        showProfile: false
    }
  },
  methods: {

  },
  components: {
    footerone,
    allMeetings,
    createMeeting,
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

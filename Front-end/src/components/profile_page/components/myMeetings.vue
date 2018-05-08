<template lang="html">
  <div class="myMeetings">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">



  <h1>myMeetings.vue</h1>
  <br>
  <h5>{{ meetings }}</h5>
  <br>

  <b-container class="createdMeetings">
    <b-card-header header-bg-variant="light" header-text-variant="dark" header-tag="header">
        Созданные события
        <i class="fab fa-angellist"></i>
    </b-card-header>

    <createdMeetingTemplate
    v-for="(meeting, index) in meetings"
    v-bind:key="meeting.id"
    v-bind:meeting="meeting"
    v-bind:index="index"
      v-on:meetingchange="change"
    ></createdMeetingTemplate>

  </b-container>
<!--
<b-container fluid class="participateMeetings">
  события в которых пользователь принимает участие
</b-container> -->
<br>
  </div>
</template>

<script>
import axios from 'axios'
import createdMeetingTemplate from './createdMeetingTemplate'
export default {
  data () {
    return {
      meetings: [
        {
          "id": 1,
          "categoryId": 1,
          "meetingAddress": {
              "id": 4,
              "locality": "Санкт-Петербург",
              "street": "Невский проспект",
              "house": "32",
              "latitude": 59.93983170000001,
              "longitude": 30.314559700000018
          },
          "name": "Встреча на Невском",
          "startTime": "25.05.2018",
          "endTime": 200000,
          "description": "Клаасно провести время в большой компании",
          "maxParticipants": 25,
          "minAge": 12,
          "attachment": null
      },
      {
          "id": 2,
          "categoryId": 2,
          "meetingAddress": {
              "id": 5,
              "locality": "Москва",
              "street": "Льва Толстого",
              "house": "125",
              "latitude": 59.93816109999999,
              "longitude": 30.31553489999999
          },
          "name": "Майские",
          "startTime": 100000,
          "endTime": 200000,
          "description": "Будем делать Шашлык!",
          "maxParticipants": 10,
          "minAge": 14,
          "attachment": null
      }
    ],
    meeting: {}
    }
  },
  methods: {
    // Переименовать и изменить
    change: function(index){
          this.meeting = this.meetings[index];
          this.meetings[index].name = "BOOOOOOOOOOOOOOOOOOOM!"
          this.meetings[index].meetingAddress.locality = "Санкт-Петербург"
      }

  },
    created: function () {
      axios.get("/meeting/user?id=2")
      .then(response => {

        if (response.status === 200) {
          this.meetings = response.data;
          console.log(response);
        }

      }).catch(function (error) {
        alert("Error...");
        console.log(error);
      });
    },

    components:{
      createdMeetingTemplate
    }
}
</script>

<style lang="css">
</style>

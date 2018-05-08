<template lang="html">
  <div class="">

<h1>page with meetings</h1>
<br>

<b-button  variant="primary" href="">
    Добавить
</b-button>

<meeting
v-for="(meeting, index) in meetings"
v-bind:key="meeting.id"
v-bind:meeting="meeting"
v-bind:index="index"
v-on:meetingchange="change"






></meeting>

<!-- <todo v-for="(todo, index) in filteredTodos" :key="index" :todo="todo"></todo> -->



<br>
{{ meetings }}
<br>
<h1>{{ meeting }}</h1>

</div>
</template>

<script>
import meeting from './meeting'
export default {
  data () {
    return {
      meetings: [
        {
          "id": 1,
          "categoryId": 1,
          "meetingAddress": {
              "id": 4,
              "locality": "",
              "street": "",
              "house": "",
              "latitude": 59.93983170000001,
              "longitude": 30.314559700000018
          },
          "name": "привет 2",
          "startTime": 100000,
          "endTime": 200000,
          "description": "ымдмыдвлмтдыы ымывьмлывьдм ымвмьдывльм Вот так",
          "maxParticipants": null,
          "minAge": 12,
          "attachment": null
      },
      {
          "id": 2,
          "categoryId": 1,
          "meetingAddress": {
              "id": 5,
              "locality": "",
              "street": "",
              "house": "",
              "latitude": 59.93816109999999,
              "longitude": 30.31553489999999
          },
          "name": "Майские",
          "startTime": 100000,
          "endTime": 200000,
          "description": "Шашлык!",
          "maxParticipants": 10,
          "minAge": 14,
          "attachment": null
      }
      // {
      //     "id": 3,
      //     "categoryId": 1,
      //     "meetingAddress": {
      //         "id": 6,
      //         "locality": "",
      //         "street": "",
      //         "house": "",
      //         "latitude": 59.944539,
      //         "longitude": 30.359720100000004
      //     },
      //     "name": "Тест3",
      //     "startTime": 100000,
      //     "endTime": 200000,
      //     "description": "Это тест!",
      //     "maxParticipants": 25,
      //     "minAge": 12,
      //     "attachment": null
      // },
      // {
      //     "id": 4,
      //     "categoryId": 1,
      //     "meetingAddress": {
      //         "id": 7,
      //         "locality": "",
      //         "street": "",
      //         "house": "",
      //         "latitude": 55.755826,
      //         "longitude": 37.617299900000035
      //     },
      //     "name": "Абравдьым",
      //     "startTime": 100000,
      //     "endTime": 200000,
      //     "description": "БУБУБУБУБУБУБУБУ",
      //     "maxParticipants": 12,
      //     "minAge": 10,
      //     "attachment": null
      // }
    ],

    meeting: {}

    }
  },

  mounted() {


  },
    methods: {
      change: function(index){
            this.meeting = this.meetings[index];
            this.meetings[index].name = "BOOOOOOOOOOOOOOOOOOOM!"
            this.meetings[index].meetingAddress.locality = "Санкт-Петербург"
        }
    },


  components: {
    meeting
  }
}
</script>

<style lang="css">
</style>

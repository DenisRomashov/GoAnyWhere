<template lang="html">
  <div class="allMeetings">

    <b-container fluid class="allMeetingsSearch">
      <div class="BlockAfterNavbar">
        <b-row id="FirstRow">
          <b-col>
            Выбирете город:
          </b-col>
          <b-col>
           <b-form-select  class="mb-3" />
          </b-col>
          <b-col>
            <h5>Выбирете категорию:</h5>
          </b-col>
          <b-col>
           <b-form-select :options="category" class="mb-3" />
          </b-col>
          <b-col>
          <b-button size="" class="mb-2 mr-sm-2 mb-sm-0" variant="warning"> Поиск </b-button>
          </b-col>
        </b-row>
      </div>
    </b-container>

<br>
<br>
    <b-container  class="Meetings">

      <b-card-header header-bg-variant="dark" header-text-variant="white" header-tag="header">
          Найденные события <b-pagination-nav base-url="#" :number-of-pages="10" v-model="currentPage" variant="dark"/>
          <input type="text" v-model="searchKey">


          <i class="fas fa-search"></i>
          <b-badge variant="secondary">
            Показано: {{ limitMeeting }} из {{ meetings.length }}
          </b-badge>
      </b-card-header>

      <allMeetingsTemplate
      v-for="(meeting, index) in limitedMeetings"
      v-bind:key="meeting.id"
      v-bind:meeting="meeting"
      v-bind:index="index"
      v-on:editmeeting="editMeeting"
      v-on:deleteorunsubscribe="deleteOrUnsubscribe"

      ></allMeetingsTemplate>

      <b-card-footer footer-bg-variant="white" footer-border-variant="dark">

            <b-btn block class="showMoreMeetings"
                   @click="limitMeeting += 2"
                   :disabled="disabledShowMoreMeetings"
                    variant="outline-secondary"> {{ countMeetingItems }}
            </b-btn>

      </b-card-footer>
    </b-container>

<br>

    <br>
  </div>
</template>

<script>
import axios from 'axios'
import router from '../../../router'
import allMeetingsTemplate from './templates/allMeetingsTemplate'
export default {
  data() {
    return {
      searchKey: '',
      currentPage: 0,
      itemsPerPage: 1,
      resultCount: 0,


      limitMeeting: 2,
      disabledShowMoreMeetings: false,
      meeting: {name:""},
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
          "startTime": "1995-03-09",
          "endTime": 200000,
          "description": "Клаасно провести время в большой компании",
          "maxParticipants": 25,
          "numberOfParticipants": 5,
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
          "numberOfParticipants": 3,
          "minAge": 14,
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
          "numberOfParticipants": 3,
          "minAge": 14,
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
          "numberOfParticipants": 3,
          "minAge": 14,
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
          "numberOfParticipants": 3,
          "minAge": 14,
          "attachment": null
      }
    ],
    category: [
      { value: '1', text: 'Активный отдых и приключения' },
      { value: '2', text: 'Еда и напитки' },
      { value: '3', text: 'Здоровье' },
      { value: '4', text: 'Карьера и бизнес'},
      { value: '5', text: 'Мода и красота'},
      { value: '6', text: 'Хобби'},
      { value: '7', text: 'Технологии'},
      { value: '8', text: 'Язык и культура'},
      { value: '9', text: 'Спорт'},
      { value: '10', text: 'Музыка'},
      { value: '11', text: 'Домашние животные'},
      { value: '12', text: 'Искусство'},
      { value: '13', text: 'Семья'},
      { value: '14', text: 'Музыка'},
      { value: '15', text: 'Кино'},
      { value: '16', text: 'Фотография'},
      { value: '17', text: 'Танцы'},
      { value: '18', text: 'Книги'},
      { value: '19', text: 'Другое'},
    ]
    }
  },
  computed: {
    countMeetingItems() {
      if (this.meetings.length - this.limitMeeting > 0 ) {
          return "Показать еще! Осталось "+(this.meetings.length - this.limitMeeting)+" из "+this.meetings.length
      } else {
        if (this.limitMeeting > this.meetings.length) {
          this.limitMeeting = this.meetings.length;
        }
        this.disabledShowMoreMeetings = true;
        return "Показаны все созданные события!"
      }
    },

    limitedMeetings() {
      return this.meetings.slice(0, this.limitMeeting)
    },

    totalPages: function() {
         return Math.ceil(this.resultCount / this.itemsPerPage)
       }
  },

  methods: {
      setPage: function(pageNumber) {
        this.currentPage = pageNumber
      }
  },

  filters: {
    paginate: function(list) {
          this.resultCount = list.length
          if (this.currentPage >= this.totalPages) {
            this.currentPage = this.totalPages - 1
          }
          var index = this.currentPage * this.itemsPerPage
          return list.slice(index, index + this.itemsPerPage)
      }
  },

  components: {
    allMeetingsTemplate
  },
  router
}
</script>

<style lang="css">
#FirstRow {
background-color: #343a40;
color: white;
/* margin-top: -17px; */
}

.Meetings {
    margin-top: 35px;
}

.allMeetingsSearch {
margin-top: 11px;
  position: fixed;
  z-index: 1000;
}


</style>

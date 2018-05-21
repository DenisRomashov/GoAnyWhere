<template lang="html">
  <div class="allMeetings">

    <b-container fluid class="allMeetingsSearch">
      <div class="BlockAfterNavbar">
        <b-row id="FirstRow">
          <b-col sm="2">
            <p class="searchTitle">
            <h5>Выберите город: </h5>
          </p>
          </b-col>
          <b-col sm="3">
           <b-form-select v-model="form.locality" :options="cities" class="mb-3" />
          </b-col>
          <b-col sm="2">
            <p class="searchTitle">
              <h5>Выберите категорию:</h5>
            </p>
          </b-col>
          <b-col sm="3">
           <b-form-select v-model="form.categoryId" :options="category" class="mb-3" />
          </b-col>
          <b-col>
          <b-button v-on:click="searchMeeting()" block size="" class="mb-2 mr-sm-2 mb-sm-0" variant="outline-warning"> Поиск </b-button>
          </b-col>
        </b-row>
      </div>
    </b-container>

<br>
<br>
    <b-container  class="Meetings">
      <b-card-header header-bg-variant="secondary" header-text-variant="white" header-tag="header">
         Найденные события
          <i class="fas fa-search"></i>
          <b-badge variant="warning">
            Показано: {{ limitMeeting }} из {{ meetings.length }}
          </b-badge>
      </b-card-header>

      <allMeetingsTemplate
      v-for="(meeting, index) in limitedMeetings"
      v-bind:key="meeting.id"
      v-bind:meeting="meeting"
      v-bind:index="index"
      v-on:subscribe="subscribeMeeting"


      ></allMeetingsTemplate>

      <b-card-footer footer-bg-variant="white" footer-border-variant="dark">
        <b-row>
          <b-btn block class="showMoreMeetings" disabled
                  variant="outline-secondary"
                  v-show="showEndShowMore">
                  {{ countMeetingItems }}
          </b-btn>
          <b-col>
            <b-btn block class="showMoreMeetings"
                   @click="limitMeeting += 2"
                   :disabled="disabledShowMoreMeetings"
                    variant="outline-secondary"
                    v-show="showMoreButtons">
                    {{ countMeetingItems }}
            </b-btn>
          </b-col>
          <b-col>
            <b-btn block class="showMoreMeetings"
                   @click="limitMeeting += meetings.length"
                   :disabled="disabledShowMoreMeetings"
                    variant="outline-secondary"
                    v-show="showMoreButtons"> Показать все!
            </b-btn>
          </b-col>
        </b-row>
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
import  { timeConverter }  from './timeconverter'
export default {
  data() {
    return {
      form: {
        searcherId: 1,
        categoryId: null,
        locality: null,
        actuality: false
      },
      subscribeForm: {
        userId: null,
        meetingId: null,
        privilege: "participant"
      },
      limitMeeting: 3,
      disabledShowMoreMeetings: false,
      showMoreButtons: true,
      showEndShowMore: false,
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
          "id": 3,
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
          "id": 4,
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
          "id": 5,
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
      { value: null, text: 'Все категории'},
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
    ],
    cities: [
      {value: null, text: 'Все города'},
      { value: 'Москва', text: 'Москва'},
      { value: 'Санкт-Петербург', text: 'Санкт-Петербург'},
      { value: 'Новосибирск', text: 'Новосибирск'},
      { value: 'Казань', text: 'Казань'}
    ]
    }
  },
  computed: {
    countMeetingItems() {
      if (this.meetings.length - this.limitMeeting > 0 ) {
          this.disabledShowMoreMeetings = false;
          return "Показать еще! Осталось "+(this.meetings.length - this.limitMeeting)+" из "+this.meetings.length
      } else {
        if (this.limitMeeting > this.meetings.length) {
          this.limitMeeting = this.meetings.length;
        }
        this.disabledShowMoreMeetings = true;
        this.showMoreButtons = false;
        this.showEndShowMore = true;
        return "Показаны все найденные события!"
      }
    },

    limitedMeetings() {
      return this.meetings.slice(0, this.limitMeeting)
    }
  },

  methods: {
    searchMeeting() {
      // alert("Поиск Начат");
      this.form.searcherId = JSON.parse(window.localStorage.getItem('STORAGE_USER_INFO')).userId;
      this.limitMeeting = 3;
      this.disabledShowMoreMeetings = false;

      axios.post("/meeting/search", this.form)
      .then(response => {

        if (response.status === 200) {
          for (var i = 0; i < response.data.length; i++) {
             response.data[i].startTime = timeConverter(response.data[i].startTime);
             response.data[i].endTime = timeConverter(response.data[i].endTime);
           }
          this.meetings = response.data;
          console.log(response);
        }

      }).catch(function (error) {
        alert("Error searchMeeting");
        console.log(error);
      });
    },

    subscribeMeeting: function(index) {
      this.subscribeForm.userId = JSON.parse(window.localStorage.getItem('STORAGE_USER_INFO')).userId;
      this.subscribeForm.meetingId = this.meetings[index].id;
      axios.post("/meeting/apply", this.subscribeForm)
      .then(response => {
        if (response.status === 200) {
          console.log(response);
        }
      }).catch(function (error) {
        alert("subscribe meeting error");
        console.log(error);
      });
    }

  },

// Получаем вообще все события
  created: function () {
    this.form.searcherId = JSON.parse(window.localStorage.getItem('STORAGE_USER_INFO')).userId;
    this.limitMeeting = 3;
    this.disabledShowMoreMeetings = false;

    axios.post("/meeting/search", this.form)
    .then(response => {
      if (response.status === 200) {
        for (var i = 0; i < response.data.length; i++) {
           response.data[i].startTime = timeConverter(response.data[i].startTime);
           response.data[i].endTime = timeConverter(response.data[i].endTime);
         }
        this.meetings = response.data;
        console.log(response);
      }
    }).catch(function (error) {
      alert("Error ALLsearchMeeting");
      console.log(error);
    });
  },
  components: {
    allMeetingsTemplate
  },
  router
}
</script>

<style lang="css">
.allMeetingsSearch {
background-color: #343a40;
color: white;
/* margin-top: -17px; */
}

.BlockAfterNavbar {
  margin-top: 10px;
}

.Meetings {
    margin-top: 50px;
}

.allMeetingsSearch {
margin-top: 6px;
  position: fixed;
  z-index: 1000;
}

.searchHeader {
  position: fixed;
  z-index: 1000;
}

.searchTitle {
  margin-top:  -10px;
}
</style>

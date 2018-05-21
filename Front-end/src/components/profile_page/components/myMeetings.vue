<template lang="html">
  <div class="myMeetings">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
<br>
  <b-container class="createdMeetings">
    <b-card-header header-bg-variant="dark" header-text-variant="white" header-tag="header">
        Созданные события
        <i class="fab fa-angellist"></i>
        <b-badge variant="secondary">
          Показано: {{ limitCreatedMeeting }} из {{ meetings.length }}
        </b-badge>
    </b-card-header>

    <createdMeetingTemplate
    v-for="(meeting, index) in limitedMeetings"
    v-bind:key="meeting.id"
    v-bind:meeting="meeting"
    v-bind:index="index"
    v-on:editmeeting="editMeeting"
    v-on:deleteorunsubscribe="deleteOrUnsubscribe"

    ></createdMeetingTemplate>

    <b-card-footer footer-bg-variant="white" footer-border-variant="white">

          <b-btn block class="showMoreCreatedMeetings"
                 @click="limitCreatedMeeting += 2"
                 :disabled="disabledShowMoreCreatedMeetings"
                  variant="outline-dark"> {{ countCreatedMeetingItems }}
          </b-btn>
    </b-card-footer>
  </b-container>
  <br>
  <br>

  <b-container  class="participateMeetings">
    <b-card-header header-bg-variant="dark" header-text-variant="white" header-tag="header">
        События, в которых вы принимаете участие
        <i class="far fa-handshake"></i>
        <b-badge variant="secondary">
          Показано: {{ limitParticipatedMeeting }} из {{ myMeetings.length }}
        </b-badge>
    </b-card-header>

    <participatedMeetingTemplate
    v-for="(meeting, index) in limitedMyMeetings"
    v-bind:key="meeting.id"
    v-bind:meeting="meeting"
    v-bind:index="index"
    v-on:unSubscribe="unSubscribe"


    ></participatedMeetingTemplate>

    <b-card-footer footer-bg-variant="white" footer-border-variant="dark">

          <b-btn block class="showMoreCreatedMeetings"
                 @click="limitParticipatedMeeting += 2"
                 :disabled="disabledShowMoreParticipatedMeetings"
                  variant="outline-dark"> {{ countParticipatedMeetingItems }}
          </b-btn>

    </b-card-footer>
  </b-container>
<br>
<br>





    <!-- Всплывающая модель редактирования -->
    <div class="MeetingEditModalForm">
    <!-- <b-modal v-model="showEditingMeeting" centered size="lg" title="Редактирование события"> -->
      <b-modal centered v-model="showEditingMeeting"
               size="lg" :title="titleEditingModal + meeting.name"
               header-bg-variant="white"
               header-text-variant="dark"
               body-bg-variant="light"
               body-text-variant="dark"
               footer-bg-variant="dark"
               footer-text-variant="light">

        <b-container fluid class="editingData">
          <b-row>
            <b-col>
              <div class="nameMeeting">
                <b-input-group size="">
                    <b-input-group-prepend>
                        <b-btn  variant="dark">Название события: </b-btn>
                    </b-input-group-prepend>
                    <b-form-input  v-model.trim="meeting.name"
                    type="text">
                  </b-form-input>
                </b-input-group>
              </div>
            </b-col>
          </b-row>
          <br>
          <b-row>
            <b-col cols="2">
              <br>
              Описание:
            </b-col>
            <b-col cols="10">
              <b-form-textarea
                   v-model="meeting.description"
                   :rows="3"></b-form-textarea>
            </b-col>
          </b-row>
          <br>
          <b-row>
            <b-col>
            </b-col>
            <b-col sm="8">
              <b-card
              bg-variant="white"
                text-variant="white"
                header-text-variant="dark"
                header="Категория вашего события:"
                class="text-center">
                  <b-form-select size="" v-model="meeting.categoryId" :options="options" class="mb-3" :select-size="4" style="text-align: center;" />
            </b-card>
            </b-col>
            <b-col>
            </b-col>
          </b-row>
          <br>



          <b-row>
            <b-col class="startTimeMeeting">
              <b-input-group size="sm" >
                  <b-input-group-prepend>
                    <b-btn  variant="success">Время начала: </b-btn>
                  </b-input-group-prepend>

                  <b-form-input disabled type="datetime-local" v-model="meeting.startTime">
                  </b-form-input>

              </b-input-group>
            </b-col>
            <b-col class="EndTimeMeeting">
              <b-input-group size="sm" >
                  <b-input-group-prepend>
                    <b-btn  variant="danger">Время окончания: </b-btn>
                  </b-input-group-prepend>

                  <b-form-input type="datetime-local" v-model="meeting.endTime">
                  </b-form-input>

              </b-input-group>
            </b-col>
          </b-row>

          <br>


          <b-row>
            <b-col>
            </b-col>
            <b-col class="maxParticipants" cols="8">
              <b-input-group size="sm" >
                  <b-input-group-prepend>
                    <b-btn  variant="dark">Максимальное количество человек: </b-btn>
                  </b-input-group-prepend>

                  <b-form-input disabled v-model.trim="meeting.maxParticipants"
                    type="number">
                  </b-form-input>

              </b-input-group>
            </b-col>
            <b-col>
            </b-col>
          </b-row>
          <br>
          <b-row>
            <b-col>
            </b-col>
            <b-col class="minAge" cols="8">
              <b-input-group size="sm" >
                  <b-input-group-prepend>
                    <b-btn  variant="dark">Минимальный возвраст: </b-btn>
                  </b-input-group-prepend>

                  <b-form-input disabled v-model.trim="meeting.minAge"
                    type="number">
                  </b-form-input>

              </b-input-group>
            </b-col>
            <b-col>
            </b-col>
          </b-row>



        </b-container>

      <div slot="modal-footer" class="w-100">
        <b-alert :show="dismissCountDown"
          dismissible
          variant=""
          @dismissed="dismissCountDown=0"
          @dismiss-count-down="countDownChanged">
          <h5>Событие обновлено! Поздравляем :) {{dismissCountDown}} секунд...</h5>
            <b-progress variant="danger"
                :max="dismissSecs"
                :value="dismissCountDown"
                height="10px">
            </b-progress>
            <br>
        </b-alert>
        <b-btn  block size="lg"
                variant="outline-danger"
                @click="upDateMeeting()"
                :disabled="submitButtonEditMeeting"
                > Подтвердить изменения!
        </b-btn>
      </div>
    </b-modal>





    <!-- Delete or Unsubscribe Modal Form -->
    <div class="DeleteOrUnsubscribe">
      <b-modal centered v-model="showDeleteOrUnsubscribe"
               :title="titleDeleteOrUnsubscribeModal + meeting.name"
               header-bg-variant="white"
               header-text-variant="dark"
               body-bg-variant="white"
               body-text-variant="dark"
               footer-bg-variant="white"
               footer-text-variant="dark">
         <b-container fluid>
           <div class="d-block text-center">
           </div>
           <b-btn size="" class="mt-3" variant="outline-dark" block @click="unSubscribeMeeting()">Отказаться от участия</b-btn>
           <b-btn size=""class="mt-3" variant="outline-danger" block @click="deleteMeeting()" >Удалить!</b-btn>
         </b-container>

         <div slot="modal-footer" class="w-100">
           <p class="float-left">© GoAnyWhere Project 2018</p>
         </div>
      </b-modal>
    </div>


    <!-- Unsubscribe Modal Form -->
    <div class="Unsubscribe">
      <b-modal centered v-model="showUnsubscribe"
               :title="titleUnsubscribeModal + meeting.name"
               header-bg-variant="white"
               header-text-variant="dark"
               body-bg-variant="white"
               body-text-variant="dark"
               footer-bg-variant="white"
               footer-text-variant="dark">
         <b-container fluid>
           <div class="d-block text-center">
           </div>
           <b-btn size="" class="mt-3" variant="outline-dark" block @click="showUnsubscribe=false">Передумать и пойти!</b-btn>
           <b-btn size=""class="mt-3" variant="outline-danger" block @click="unSubscribeMeeting()" >Отказаться от участия</b-btn>
         </b-container>

         <div slot="modal-footer" class="w-100">
           <p class="float-left">© GoAnyWhere Project 2018</p>
         </div>
      </b-modal>
    </div>


  </div>



  </div>
</template>

<script>
import axios from 'axios'
import router from '../../../router'
import  { timeConverter }  from './timeconverter'
import  { timeConverter2 }  from './timeconverter_edit'
import createdMeetingTemplate from './templates/createdMeetingTemplate'
import participatedMeetingTemplate from './templates/participatedMeetingTemplate'
export default {
  data () {
    return {
      center: { lat: 59.9342802, lng: 30.335098600000038  },
      marker: {},
      place: {},
      currentPlace: null,

      limitCreatedMeeting: 2,
      disabledShowMoreCreatedMeetings: false,
      limitParticipatedMeeting: 2,
      disabledShowMoreParticipatedMeetings: false,

      dismissSecs: 3,
      dismissCountDown: 0,
      submitButtonEditMeeting: false,


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
          "startTime": 1525512900000,
          "endTime": 1526547600000,
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

    myMeetings: [
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
        "name": "1",
        "startTime": "1995-03-09",
        "endTime": 200000,
        "description": "Клаасно провести время в большой компании",
        "maxParticipants": 25,
        "numberOfParticipants": 5,
        "minAge": 12,
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
        "name": "2",
        "startTime": 100000,
        "endTime": 200000,
        "description": "Будем делать Шашлык!",
        "maxParticipants": 10,
        "numberOfParticipants": 3,
        "minAge": 14,
        "attachment": null
    },
    {
        "id": 6,
        "categoryId": 2,
        "meetingAddress": {
            "id": 5,
            "locality": "Москва",
            "street": "Льва Толстого",
            "house": "125",
            "latitude": 59.93816109999999,
            "longitude": 30.31553489999999
        },
        "name": "3",
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
        "name": "4",
        "startTime": 100000,
        "endTime": 200000,
        "description": "Будем делать Шашлык!",
        "maxParticipants": 10,
        "numberOfParticipants": 3,
        "minAge": 14,
        "attachment": null
    },
    {
        "id": 7,
        "categoryId": 2,
        "meetingAddress": {
            "id": 5,
            "locality": "Москва",
            "street": "Льва Толстого",
            "house": "125",
            "latitude": 59.93816109999999,
            "longitude": 30.31553489999999
        },
        "name": "5",
        "startTime": 100000,
        "endTime": 200000,
        "description": "Будем делать Шашлык!",
        "maxParticipants": 10,
        "numberOfParticipants": 3,
        "minAge": 14,
        "attachment": null
    }
  ],

    meeting: {name:""},
    titleEditingModal: "Редактирование события: ",
    titleDeleteOrUnsubscribeModal: "Событие: ",
    showEditingMeeting: false,
    showDeleteOrUnsubscribe: false,
    titleUnsubscribeModal: "Вы действилельно хотите отказаться от участия в ",
    showUnsubscribe: false,

    options: [
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
    countCreatedMeetingItems() {
      if (this.meetings.length - this.limitCreatedMeeting > 0 ) {
          return "Показать еще! Осталось "+(this.meetings.length - this.limitCreatedMeeting)+" из "+this.meetings.length
      } else {
        if (this.limitCreatedMeeting > this.meetings.length) {
          this.limitCreatedMeeting = this.meetings.length;
        }
        this.disabledShowMoreCreatedMeetings = true;
        return "Показаны все созданные события!"
      }
    },

    countParticipatedMeetingItems() {
      if (this.myMeetings.length - this.limitParticipatedMeeting > 0 ) {
          return "Показать еще! Осталось "+(this.myMeetings.length - this.limitParticipatedMeeting)+" из "+this.myMeetings.length
      } else {
        if (this.limitParticipatedMeeting > this.myMeetings.length) {
          this.limitParticipatedMeeting = this.myMeetings.length;
        }
        this.disabledShowMoreParticipatedMeetings= true;
        return "Показаны все события, где вы принимаете участие!"
      }
    },

    limitedMeetings() {
      return this.meetings.slice(0,this.limitCreatedMeeting)
    },

    limitedMyMeetings() {
      return this.myMeetings.slice(0,this.limitParticipatedMeeting)
    }

  },

  methods: {
     close_editing_window() {
      this.showEditingMeeting = false
    },

    countDownChanged (dismissCountDown) {
      this.dismissCountDown = dismissCountDown
    },
    showAlert () {
      this.dismissCountDown = this.dismissSecs
    },

    setPlace(place) {
      this.currentPlace = place;
    },


    editMeeting: function(index) {
      this.meeting = this.meetings[index];
      this.showEditingMeeting = true;
      this.submitButtonEditMeeting = false;
    },

    deleteOrUnsubscribe: function(index) {
      this.meeting = this.meetings[index];
      this.showDeleteOrUnsubscribe = true;
    },

    unSubscribe: function(index) {
      this.meeting = this.myMeetings[index];
      this.showUnsubscribe = true;
    },

    deleteMeeting: function() {
      axios.delete("/meeting", {
        data: { userId: JSON.parse(window.localStorage.getItem('STORAGE_USER_INFO')).userId, meetingId: this.meeting.id }})
      .then(response => {

        if (response.status === 200) {
          // Принудительная перезагрузка
          location.reload();
          console.log(response);
        }

      }).catch(function (error) {
        alert("Error: DEETE MEETING");
        console.log(error);
      });
    },

    unSubscribeMeeting: function() {
      axios.delete("/meeting/exit", {
        data: { userId: JSON.parse(window.localStorage.getItem('STORAGE_USER_INFO')).userId, meetingId: this.meeting.id }})
      .then(response => {

        if (response.status === 200) {
          // Принудительная перезагрузка
          location.reload();
          console.log(response);
        }

      }).catch(function (error) {
        alert("Error: Unsubscribe");
        console.log(error);
      });
    },

    upDateMeeting: function() {
      this.meeting.creatorId = JSON.parse(window.localStorage.getItem('STORAGE_USER_INFO')).userId;
      this.meeting.addressId = this.meeting.meetingAddress.id;

        axios.post("/meeting", this.meeting)
        .then(response => {
          if (response.status === 200) {
            setTimeout(this.close_editing_window, 3000)
            this.showAlert ();
            // alert("Событие Обновлено! Поздравляем!");
            // Принудительная перезагрузка страницы
            // location.reload();
            // this.showEditingMeeting = false;
            console.log(response);
          }
        }).catch(function (error) {
          alert("Ошибка. Обновление события! upDateMeeting method");
          console.log(error);
        });

    },

  },

    created: function () {
      if (localStorage.getItem('STORAGE_USER_INFO') !== null && JSON.parse(window.localStorage.getItem('STORAGE_USER_INFO')).userId != 0) { //проверяем есть ли такой ключ, если нет отправляем на главную
           var storageInfo = JSON.parse(window.localStorage.getItem('STORAGE_USER_INFO'));

               axios.get("/meeting/creator?id="+storageInfo.userId)
               .then(response => {
                 if (response.status === 200) {
                   for (var i = 0; i < response.data.length; i++) {
                      response.data[i].startTime = timeConverter2(response.data[i].startTime);
                      response.data[i].endTime = timeConverter2(response.data[i].endTime);
                    }
                    this.meetings = response.data;

                     console.log(response);
                    }
               }).catch(function (error) {
                 alert("OOPSSS!! createdMeetings получение митингов не сработало!")
                 console.log(error);
               });

               axios.get("/meeting/user?id="+storageInfo.userId)
               .then(response => {
                 if (response.status === 200) {
                   for (var i = 0; i < response.data.length; i++) {
                      response.data[i].startTime = timeConverter(response.data[i].startTime);
                      response.data[i].endTime = timeConverter(response.data[i].endTime);
                    }

                    var meetingPart = [];
                    var counter = 0;
                    for (var i = 0; i < response.data.length; i++) {
                    var onlyPart = true;
                      for(var j = 0; j < this.meetings.length; j++) {
                        if (response.data[i].id === this.meetings[j].id) {
                          onlyPart = false;
                          break;
                        }
                      }
                    if (onlyPart) meetingPart[counter++] = response.data[i];
                    }

                    this.myMeetings = meetingPart;
                     console.log(response);
                    }
               }).catch(function (error) {
                 alert("OOPSSS!! participateMeetings получение митингов не сработало!")
                 console.log(error);
               });

      }
    },

    components:{
      createdMeetingTemplate,
      participatedMeetingTemplate
    },
    router
}
</script>

<style lang="css">
</style>

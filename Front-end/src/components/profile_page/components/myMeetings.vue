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
    v-on:editmeeting="editMeeting"
    ></createdMeetingTemplate>

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
              <b-card
              bg-variant="dark"
                text-variant="white"
                header="Категория вашего события:"
                class="text-center">
                  <b-form-select size="" v-model="meeting.categoryId" :options="options" class="mb-3" :select-size="3" />
            </b-card>
            </b-col>
          </b-row>
          <br>



          <b-row>
            <b-col class="startTimeMeeting">
              <b-input-group size="sm" >
                  <b-input-group-prepend>
                    <b-btn  variant="success">Время начала: </b-btn>
                  </b-input-group-prepend>

                  <b-form-input  v-model="meeting.startTime"
                    type="date">
                  </b-form-input>

              </b-input-group>
            </b-col>
            <b-col class="EndTimeMeeting">
              <b-input-group size="sm" >
                  <b-input-group-prepend>
                    <b-btn  variant="danger">Время окончания: </b-btn>
                  </b-input-group-prepend>

                  <b-form-input  v-model="meeting.endTime"
                    type="datetime-local">
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

                  <b-form-input  v-model.trim="meeting.maxParticipants"
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

                  <b-form-input  v-model.trim="meeting.minAge"
                    type="number">
                  </b-form-input>

              </b-input-group>
            </b-col>
            <b-col>
            </b-col>
          </b-row>
        </b-container>

      <div slot="modal-footer" class="w-100">
        <p class="float-left">© GoAnyWhere Project 2018</p>
      </div>
            {{ meeting }}
    </b-modal>
  </div>
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
      }
    ],
    meeting: {name:""},
    titleEditingModal: "Редактирование события: ",
    showEditingMeeting: false,

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
  methods: {
    editMeeting: function(index){
      this.meeting = this.meetings[index];
      this.showEditingMeeting = true;
    },

  },
    created: function () {
      if (localStorage.getItem('STORAGE_USER_INFO') !== null && JSON.parse(window.localStorage.getItem('STORAGE_USER_INFO')).userId != 0) { //проверяем есть ли такой ключ, если нет отправляем на главную
           var storageInfo = JSON.parse(window.localStorage.getItem('STORAGE_USER_INFO'));

               axios.get("/meeting/user?id="+storageInfo.userId)
               .then(response => {

                 if (response.status === 200) {
                     this.meetings = response.data;
                     console.log(response);
                    }

               }).catch(function (error) {
                 alert("OOPSSS!! myMeetings получение митингов не сработало!")
                 console.log(error);
               });

      }
    },

    components:{
      createdMeetingTemplate
    }
}
</script>

<style lang="css">
</style>

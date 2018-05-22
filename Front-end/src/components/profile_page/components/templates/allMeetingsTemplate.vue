<template lang="html">
  <div class="meeting">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">

    <b-card  bg-variant="white" text-variant="dark" v-show="true">
        <b-row>
          <b-col sm="8">
            <div class="" align="left">

              <h5>{{ meeting.name}}
                <b-badge variant="secondary">
                  Участников: {{meeting.numberOfParticipants}}/{{ meeting.maxParticipants }}
                </b-badge>
                <b-badge variant="info"> Возраст: {{ meeting.minAge }}+ </b-badge>
              </h5>
              <p>
                <b-badge variant="danger">
                  Категория: {{ category[meeting.categoryId - 1].text }}
                </b-badge>
                <b-badge variant="warning">
                  Дата: {{ meeting.startTime }}
                </b-badge>
              </p>
          </div>
        </b-col>

        <b-col sm="4">
          <div>
            <b-button-group vertical size="">
              <b-button :variant="buttonSubscribeVariant" v-on:click="subscribe(index)" :disabled="addedButtonDisable" v-if="countMeetingParticipants">
                <i class="fas fa-plus" v-show="plus"></i>
                <i class="fas fa-check-circle" v-show="added" ></i> {{ butttonTitleSubscribe }}
              </b-button>

              <b-button variant="dark"  disabled v-else>
                <i class="fas fa-ban"></i></i> Больше нет мест :(
              </b-button>


              </b-button-group>
            </div>
          </b-col>
        </b-row>

        <b-row>
          <b-col>
              <b-btn block @click="showCollapseMethod()"
                  variant="outline-secondary"
                  :class="showCollapse ? 'collapsed' : null"
                  aria-controls="collapse4"
                  :aria-expanded="showCollapse ? 'true' : 'false'">
                  <i class="fas fa-align-justify"></i>
                  Детали события
              </b-btn>

    <!-- Все что в б кард можно забрать будет в другие темплейты -->
              <b-collapse class="mt-2" v-model="showCollapse" id="collapse4">
                <b-card>

                    <b-row>
                      <b-col>
                        <b-card-group deck
                            class="mb-3">

                            <b-card
                              border-variant="dark"
                              header-bg-variant=""
                              header-text-variant=""
                              bg-variant="light"
                              text-variant="dark"
                              header="Описание:"
                              class="text-center">
                                <p class="card-text">{{ meeting.description }}</p>


                                <b-button block disabled variant="success"><i class="fas fa-clock"></i> Начало: {{ meeting.startTime }} </b-button>
                                <b-button block disabled variant="danger"><i class="fas fa-clock"></i> Окончание: {{ meeting.endTime}} </b-button>

                              </b-card>

                        </b-card-group>
                      </b-col>

                      <b-col>
                        <b-card-header
                          border-variant="dark"
                          header-bg-variant="secondary"
                          header-text-variant="white">
                          <i class="fas fa-location-arrow"></i>  {{ meeting.meetingAddress.locality}}, {{meeting.meetingAddress.street}}, {{meeting.meetingAddress.house}}
                        </b-card-header>
                        <b-card
                          border-variant="white"
                          bg-variant="light"
                          text-variant="dark"
                          class="text-center">
                          <!--Вставка карты  -->
                          <gmap-map
                            :center="center"
                            :zoom="14"
                            style="width:100%;  height: 200px"
                            >

                            <gmap-marker
                              :position="marker"
                              @click="center=marker">
                            </gmap-marker>
                          </gmap-map>
                        </b-card>
                      </b-col>
                    </b-row>

                <!-- Таблица с участниками -->
                <div class="participantsInfo">
                    <b-btn block @click="showCollapseParticipantsMethod()"
                        variant="secondary"
                        :class="showCollapse ? 'collapsed' : null"
                        aria-controls="collapse5"
                        :aria-expanded="showCollapse ? 'true' : 'false'">
                        <i class="fas fa-users"></i>
                          Участники события
                    </b-btn>
                </div>
                <b-collapse class="mt-2" v-model="showCollapseParticipants" id="collapse5">
                    <b-table striped hover :items="items" :fields="fields"></b-table>
                    <strong>*</strong>Подробные данные участников вы сможете увидеть, если присоеденитесь к этому событию
                </b-collapse>
                <br>
                <b-button block :variant="buttonSubscribeVariant" v-on:click="subscribe(index)" :disabled="addedButtonDisable" v-if="countMeetingParticipants">
                  <i class="fas fa-plus" v-show="plus"></i>
                  <i class="fas fa-check-circle" v-show="added" ></i> {{ butttonTitleSubscribe }}
                </b-button>
                <b-button block variant="dark"  disabled v-else>
                  <i class="fas fa-ban"></i></i> Больше нет мест :(
                </b-button>
              </b-card>
            </b-collapse>
          </b-col>
        </b-row>
      </b-card>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  props: ['meeting', 'index'],
  data() {
    return {
      fields: [
        {
          key: 'username',
          label: 'Имя пользователя',
          sortable: true
        },
        {
          key: 'userAddress.locality',
          label: 'Город',
          sortable: true
        }
      ],

      items: [
        {
          "id": 101,
          "username": "mglmdltdxl",
          "firstName": "бЧХоДЫЯЩ",
          "lastName": "биабйЙСы",
          "sex": "m",
          "birthday": "1983-08-22",
          "userAddress": {
              "id": 101,
              "locality": "Санкт-Петербург",
              "street": "Маяковская",
              "house": "47",
              "latitude": 33,
              "longitude": 21
        },
        "userContact": {
            "id": 101,
            "email": "llfuroowik@gmail.com",
            "phoneNumber": "38855205",
            "vkReference": "uagjezta",
            "facebookReference": "vgyvihjaz",
            "twitterReference": "vmjjfuujvw",
            "preferred": "e"
        }
    },
    {
        "id": 105,
        "username": "zcleusdess",
        "firstName": "бзФЛУюьЗ",
        "lastName": "бфусетжЯ",
        "sex": "m",
        "birthday": "1999-06-12",
        "userAddress": {
            "id": 120,
            "locality": "Казань",
            "street": "Ленина",
            "house": "4",
            "latitude": 29,
            "longitude": 13
        },
        "userContact": {
            "id": 105,
            "email": "wntinowcqx@mail.ru",
            "phoneNumber": "32699223",
            "vkReference": "fasxayce",
            "facebookReference": "hgmjehrgg",
            "twitterReference": "goxvdwencj",
            "preferred": "f"
        }
    },
    {
        "id": 111,
        "username": "yfkyflftqf",
        "firstName": "вцвЙювшс",
        "lastName": "вИньвРкФ",
        "sex": "m",
        "birthday": "1975-12-21",
        "userAddress": {
            "id": 186,
            "locality": "Москва",
            "street": "Гагарина",
            "house": "71",
            "latitude": 37,
            "longitude": 20
        },
        "userContact": {
            "id": 111,
            "email": "mpkpfpfovr@yandex.ru",
            "phoneNumber": "29621232",
            "vkReference": "ybmeyzuh",
            "facebookReference": "zieocfhhx",
            "twitterReference": "znrcbvuqtc",
            "preferred": "v"
        }
    }
],


      center: {lat: 0, lng: 0},
      marker: {lat: 0, lng: 0},
      showCollapse: false,
      showCollapseParticipants: false,
      buttonSubscribeVariant: "warning",
      butttonTitleSubscribe: "Присоединиться к событию!",
      plus: true,
      added: false,
      addedButtonDisable: false,
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
    countMeetingParticipants() {
      if (this.meeting.numberOfParticipants === this.meeting.maxParticipants) {
        return false
      }else {
        return true
      }
    }

  },

  methods: {
    subscribe: function(index){
      this.meeting.numberOfParticipants ++;
      this.buttonSubscribeVariant = "success";
      this.plus = !this.plus;
      this.added = !this.added;
      this.butttonTitleSubscribe = "Вы присоединились к событию!"
      this.addedButtonDisable = true;
      this.$emit('subscribe', index);
    },
    showCollapseMethod() {
      this.showCollapse = !this.showCollapse;
      this.center.lat = this.meeting.meetingAddress.latitude;
      this.center.lng = this.meeting.meetingAddress.longitude;
      this.marker.lat = this.meeting.meetingAddress.latitude;
      this.marker.lng = this.meeting.meetingAddress.longitude;
    },

    showCollapseParticipantsMethod() {
      this.showCollapseParticipants = !this.showCollapseParticipants;
      if (this.showCollapseParticipants) {
        axios.get("/meeting/participants?id="+this.meeting.id)
        .then(response => {
          if (response.status === 200) {

            this.items= response.data;
            console.log(response);
          }
        }).catch(function (error) {
          alert("Error /meeting/participants?Id");
          console.log(error);
        });
      }
    }
  },

}
</script>

<style lang="css">
.participantsInfo {
  margin-top: 20px;
}
</style>

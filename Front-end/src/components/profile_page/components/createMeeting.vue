<template lang="html">
<div class="createMeeting">

  <div class="startCreate" v-if="showStartCreate">
        <b-card overlay
            :img-src="require('../../../assets/13.jpg')"
            img-alt="Card Image"
            text-variant="white">

            <div class="cardTitle">
              <h1>Организовать новое Событие</h1>
              <h2>Мы поможем вам найти подходящих людей :)</h2>
              <br>
               <b-button @click="showStartCreate=false, showNewMeeting=true" size="lg"  variant="danger" href="">
                  <span style='padding-left:50px;'></span>
                    Создать событие
                   <span style='padding-left:50px;'></span>
               </b-button>

            </div>
          </b-card>
  </div>

  <div class="newMeeting" v-if="showNewMeeting">

      <b-container fluid class="meetingInfo">
        <div class="profileInfodiv">
          <br>
            <b-card-header header-bg-variant="danger" header-text-variant="white" header-tag="header">
              <h5>Создание события <i class="fas fa-plus"></i></h5>
            </b-card-header>
          </div>
          <br>
          <b-row>
            <b-col class="firstLeftColumn" cols="8">

              <b-card-header header-bg-variant="dark" header-text-variant="white" header-tag="header">
                <b-input-group size="" >
                    <b-input-group-prepend>
                      <b-btn  variant="dark">Название: </b-btn>
                    </b-input-group-prepend>

                    <b-form-input  v-model.trim="form.name"
                      type="text"
                      placeholder="Введите название события">
                    </b-form-input>
                </b-input-group>
              </b-card-header>

              <b-card bg-variant="white" >
                <b-row>

                  <!-- Аватарка митинга -->
                  <b-col cols="4">
                    <!-- <b-img rounded="circle" :src="require('../../../assets/1.jpg')"  blank width="150" height="150"  alt="img" class="m-1" /> -->
                    <!-- <b-img rounded blank :src="require('../../../assets/1.jpg')" alt="Thumbnail" /> -->
                    <b-img rounded="circle" :src="srcImage" width="200" height="200" alt="img" class="m-1" />
                   </b-col>


                   <b-col cols="7">
                          Краткое описание, вашего события:
                            <b-form-textarea
                              v-model="form.description"
                              placeholder="Напишите о чем ваша встреча"
                              :rows="6"
                              :max-rows="8">
                            </b-form-textarea>

                  </b-col>



                </b-row>

              </b-card>

              <b-card-footer footer-bg-variant="dark" footer-border-variant="dark" footer-text-variant="white">
                <b-row>
                  <b-col class="startTimeMeeting">
                    <b-input-group size="" >
                        <b-input-group-prepend>
                          <b-btn  variant="dark">Время начала: </b-btn>
                        </b-input-group-prepend>

                        <b-form-input  v-model="form.startTime"
                          type="datetime-local">
                        </b-form-input>

                    </b-input-group>
                  </b-col>
                  <b-col class="EndTimeMeeting">
                    <b-input-group size="" >
                        <b-input-group-prepend>
                          <b-btn  variant="dark">Время окончания: </b-btn>
                        </b-input-group-prepend>

                        <b-form-input  v-model="form.endTime"
                          type="datetime-local">
                        </b-form-input>

                    </b-input-group>
                  </b-col>
                </b-row>
              </b-card-footer>


              <b-card-footer footer-bg-variant="dark" footer-border-variant="dark" footer-text-variant="white">
                <b-row>
                  <b-col class="maxParticipants">
                    <b-input-group size="" >
                        <b-input-group-prepend>
                          <b-btn  variant="dark">Максимальное количество человек: </b-btn>
                        </b-input-group-prepend>

                        <b-form-input  v-model.trim="form.maxParticipants"
                          type="number">
                        </b-form-input>

                    </b-input-group>
                  </b-col>
                  <b-col class="minAge">
                    <b-input-group size="" >
                        <b-input-group-prepend>
                          <b-btn  variant="dark">Минимальный возвраст: </b-btn>
                        </b-input-group-prepend>

                        <b-form-input  v-model.trim="form.minAge"
                          type="number">
                        </b-form-input>

                    </b-input-group>
                  </b-col>
                </b-row>
              </b-card-footer>
            </b-col>





            <b-col cols="4">


                <b-card bg-variant="dark"
                  text-variant="white"
                  header="Выберите категорию:"
                  class="text-center">
                  <p class="card-text"> <h6> Категория вашего события: {{ options[form.categoryId - 1].text }}</h6></p>
                    <b-form-select v-model="form.categoryId" :options="options" class="mb-3" :select-size="12" />

              </b-card>

            </b-col>
          </b-row>
      </b-container>

            <br>
            <br>

      <b-container fluid class="map">
      <b-row>
        <b-col>
          <b-card-header header-bg-variant="secondary" header-text-variant="white" header-tag="header">
            <p>Где будет проходит ваше событие?</p>
            <gmap-autocomplete
              @place_changed="setPlace">

            </gmap-autocomplete>

            <b-button  variant="primary"  @click="addMarker">
                Добавить на карту
            </b-button>

          </b-card-header>
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <b-card bg-variant="white" >
            <gmap-map
              :center="center"
              :zoom="14"
              style="width:100%;  height: 400px;"
            >


              <gmap-marker
                :position="marker"
                @click="center=marker"
              ></gmap-marker>

            </gmap-map>
            <br>
            <h1>{{ this.form }}</h1>
            <h5> Форм адрес долгота: {{ formAddress.latitude }}</h5>
            <h5> Форм адрес широта: {{ formAddress.longitude }}</h5>
            <h2>{{ center.lat }}</h2>
            <h2>{{ center.lng }}</h2>
            <br>
            <h2>marker: {{ marker }}</h2>
            <h2>place: {{ place.address_components }}</h2>
          </b-card>
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <b-card-footer footer-bg-variant="dark" footer-border-variant="dark">

                <b-btn size="lg"
                        variant="outline-danger"
                        @click="createMeeting"> Создать событие!
                </b-btn>
                <b-popover ref="popoverOne" target="editinfobutton"
                 placement="left"
                 title="Нажми!"
                 triggers="hover focus"
                 content="И мы создадим событие :)">
               </b-popover>

          </b-card-footer>
        </b-col>
      </b-row>
    </b-container>

    <br>

  </div>

</div>
</template>

<script>
import axios from 'axios'
export default {
  data () {
    return {
      center: { lat: 59.9342802, lng: 30.335098600000038  },
      marker: {},
      place: {},
      currentPlace: null,

      form: {
        creatorId: 0,
        categoryId: 1,
        addressId: null,
        name: '',
        startTime: 100000,
        endTime: 200000,
        description: '',
        maxParticipants: '',
        minAge: ''
      },

      pageform: {
        category: 'пусто',
        file: null
      },

      formAddress: {
        locality: '',
        street: '',
        house: '',
        latitude: 1,
        longitude: 1

      },

      showStartCreate: true,
      showNewMeeting: false,
      srcImage: require('../../../assets/square.jpg'),

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


  mounted() {
    this.geolocate();

      if (window.localStorage.getItem('STORAGE_USER_INFO') !== null) {
      this.form.creatorId = JSON.parse(window.localStorage.getItem('STORAGE_USER_INFO')).userId;
    }

  },


  methods: {
    // Работа с картой
    // receives a place object via the autocomplete component
    setPlace(place) {
      this.currentPlace = place;
    },
    addMarker() {
      if (this.currentPlace) {
        const marker = {
          lat: this.currentPlace.geometry.location.lat(),
          lng: this.currentPlace.geometry.location.lng()
        };
        this.marker = marker;
        this.place = this.currentPlace;
        this.center = marker;
        this.currentPlace = null;

        //Добавление в formAddress широты и долготы
         this.formAddress.latitude = marker.lat;
         this.formAddress.longitude = marker.lng;

         //Добавление в formAddress города, улицы и номера
         var json = this.place.address_components;

         for (var i = 0; i < json.length; i++) {
            var current_type = json[i].types[0];
            switch(current_type) {
              case ("street_number"):
                  this.formAddress.house = json[i].long_name;
                  break;
             case ("route"):
                  this.formAddress.street = json[i].long_name;
                  break;
            case ("locality"):
                this.formAddress.locality = json[i].long_name;
                break;
              }
            }

       //Отправляем выбранный адресс и получаем addressId из базы
        axios.post("/address", this.formAddress)
        .then(response => {

          if (response.status === 200) {
            this.form.addressId = response.data.id;
            console.log(response);
          }

        }).catch(function (error) {
          alert("Error...");
          console.log(error);
        });

      }
    },
    geolocate: function() {
      navigator.geolocation.getCurrentPosition(position => {
        this.center = {
          lat: position.coords.latitude,
          lng: position.coords.longitude
        };
      });
    },

    createMeeting() {
      axios.post("/meeting", this.form)
      .then(response => {

        if (response.status === 200) {
          alert("Событие создано!");
          console.log(response);
        }

      }).catch(function (error) {
        alert("Error...");
        console.log(error);
      });
    }
  }
}
</script>

<style lang="css">
.startCreate {
  margin-top: -7px;
  margin-right: -17px;
  margin-left: -17px;

  /* min-width: 360px;
  min-height: 360px; */
}

.cardTitle {
  position: relative;
  margin-top: 15%;
}




</style>

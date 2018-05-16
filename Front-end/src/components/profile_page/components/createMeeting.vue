<template lang="html">
<div class="creationMeeting">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">

<b-container fluid v-if="showStartCreate">
  <div class="startCreate">
        <b-card overlay
            :img-src="require('../../../assets/13.jpg')"
            img-alt="Card Image"
            text-variant="white">

            <div class="cardTitle">
              <h1>Организовать новое Событие</h1>
              <h2>Мы поможем вам найти подходящих людей :)</h2>
              <br>
               <b-button @click="showStartCreate=false, showStep1=true" size="lg"  variant="danger" href="">
                  <span style='padding-left:50px;'></span>
                    Создать событие
                   <span style='padding-left:50px;'></span>
               </b-button>

            </div>
        </b-card>
      </div>
  </b-container>



  <b-container v-if="showStep1">
    <b-row>
      <b-col>
        <br>
        <br>
          <b-card-header header-bg-variant="dark" header-border-variant="white" header-text-variant="white" header-tag="header" class="creationHeader">
            <h5>Создание события </h5>
          </b-card-header>
        <br>
          <h4>Шаг 1. Напишите название и описание вашего событие!</h4>
      </b-col>
    </b-row>
    <br>
    <b-row>
      <b-col>
        <b-card-header header-bg-variant="dark" header-text-variant="white" header-tag="header">
          <b-input-group size="" >
              <b-input-group-prepend>
                <b-btn  variant="dark">Название: </b-btn>
              </b-input-group-prepend>

              <b-form-input :disabled="step1Input" v-model.trim="form.name"
                type="text"
                placeholder="Введите название события">
              </b-form-input>
          </b-input-group>
        </b-card-header>
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <b-card bg-variant="white" >
          <b-row>
            <!-- Аватарка митинга -->
            <b-col cols="4">
              <b-img rounded="circle" :src="srcImage" width="200" height="200" alt="img" class="m-1" />
             </b-col>
             <b-col cols="7">
                    Краткое описание, вашего события:
                      <b-form-textarea
                        :disabled="step1Input"
                        v-model="form.description"
                        placeholder="Напишите о чем ваша встреча"
                        :rows="6"
                        :max-rows="8">
                      </b-form-textarea>
            </b-col>
          </b-row>
        </b-card>
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <br>
        <b-button block @click="showStep2=true, step1()" :variant="variantContinueButton1" size="lg">
            {{ button1Title }} <i class="fas fa-arrow-circle-right" v-show="!showStep2"></i>
            <i class="fas fa-check-circle" v-show="showStep2" ></i>
        </b-button>
      </b-col>
    </b-row>
    <br>
    <br>
  </b-container>



  <b-container class="step2" v-if="showStep2">
      <h4>Шаг 2. Введите параметры вашего события :)</h4>
        <b-card bg-variant="white" border-variant="dark" text-variant="white">
          <b-row>
            <b-col class="startTimeMeeting">
              <b-input-group size="" >
                  <b-input-group-prepend>
                    <b-btn  variant="dark">Время начала: </b-btn>
                  </b-input-group-prepend>

                  <b-form-input :disabled="step2Input" v-model="form.startTime"
                    type="datetime-local">
                  </b-form-input>
              </b-input-group>
            </b-col>
            <b-col class="EndTimeMeeting">
              <b-input-group size="" >
                  <b-input-group-prepend>
                    <b-btn  variant="dark">Время окончания: </b-btn>
                  </b-input-group-prepend>

                  <b-form-input :disabled="step2Input" v-model="form.endTime"
                    type="datetime-local">
                  </b-form-input>

              </b-input-group>
            </b-col>
          </b-row>
          <br>
          <b-row>
            <b-col class="maxParticipants">
              <b-input-group size="" >
                  <b-input-group-prepend>
                    <b-btn  variant="dark">Максимальное количество человек: </b-btn>
                  </b-input-group-prepend>

                  <b-form-input :disabled="step2Input" v-model.trim="form.maxParticipants"
                    type="number">
                  </b-form-input>

              </b-input-group>
            </b-col>
            <b-col class="minAge">
              <b-input-group size="" >
                  <b-input-group-prepend>
                    <b-btn  variant="dark">Минимальный возвраст: </b-btn>
                  </b-input-group-prepend>

                  <b-form-input :disabled="step2Input" v-model.trim="form.minAge"
                    type="number">
                  </b-form-input>

              </b-input-group>
            </b-col>
          </b-row>
        </b-card>
        <b-row>
          <b-col>
            <br>
            <b-button block @click="showStep3=true, step2()"  :variant="variantContinueButton2" size="lg" href="">
                {{ button2Title }} <i class="fas fa-arrow-circle-right" v-show="!showStep3" ></i>
                <i class="fas fa-check-circle" v-show="showStep3" ></i>
            </b-button>
          </b-col>
        </b-row>
        <br>
        <br>
  </b-container>


  <b-container class="step3" v-if="showStep3">
      <h4>Шаг 3. Чему будет посвящено ваше Событие?</h4>
      <b-row>
        <b-col>
          <b-card-header header-bg-variant="dark" header-text-variant="white" header-tag="header">
              <p class="card-text"> <h6> Категория вашего события: {{ options[form.categoryId - 1].text }}</h6></p>
          </b-card-header>
        </b-col>
      </b-row>
        <b-row>
          <b-col>
            <b-card bg-variant="white"
              border-variant="dark"
              text-variant="white"
              class="text-center">
              <b-form-select :disabled="step3Input" v-model="form.categoryId" :options="options" size="lg" class="mb-3" :select-size="10" style="text-align: center;" />

            </b-card>
          </b-col>
        </b-row>
        <b-row>
          <b-col>
            <br>
            <b-button block @click="showStep4=true, step3()"  :variant="variantContinueButton3" size="lg" href="">
                {{ button3Title }} <i class="fas fa-arrow-circle-right" v-show="!showStep4"></i>
                <i class="fas fa-check-circle" v-show="showStep4" ></i>
            </b-button>
          </b-col>
        </b-row>
        <br>
        <br>
  </b-container>

  <b-container class="step4" v-if="showStep4">
      <h4>Шаг 4. Где будет проходить ваше Событие?</h4>
      <b-row>
        <b-col>
          <b-card-header header-bg-variant="dark" header-text-variant="white" header-tag="header">
            <gmap-autocomplete class="searchMapInput"
              @place_changed="setPlace">

            </gmap-autocomplete>
            <b-button size="lg" variant="success"  @click="addMarker(), step4Input=true" id="searchMapButton">
                Добавить событие на карту <i class="fas fa-map-marker-alt"></i>
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

          </b-card>
        </b-col>
      </b-row>
      <br>
      <b-btn id="createMeetingButton" block size="lg"
              variant="danger"
              @click="createMeeting"> Создать событие!
      </b-btn>
      <br>
      <br>
  </b-container>



  <b-container fluid v-if="showEndCreate">
    <div class="startCreate">
          <b-card overlay
              :img-src="require('../../../assets/backcreated.jpg')"
              img-alt="Card Image"
              text-variant="white">

              <div class="cardTitle">
                <h1>Поздравляем!</h1>
                <h2>Ваше событие создано :)</h2>
                <br>
                 <b-button @click="goToMyMeetings()" size="lg"  variant="warning" href="">
                    <span style='padding-left:50px;'></span>
                      Мои события
                     <span style='padding-left:50px;'></span>
                 </b-button>

                 <b-button @click="createOneMore(), showStep1=true" size="lg"  variant="danger" href="">
                    <span style='padding-left:50px;'></span>
                      Создать еще!
                     <span style='padding-left:50px;'></span>
                 </b-button>

              </div>
          </b-card>
        </div>
    </b-container>
</div>
</template>

<script>
import axios from 'axios'
import router from '../../../router'
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
        startTime: "2018-05-11T00:00",
        endTime: "2018-05-11T00:00",
        description: '',
        maxParticipants: 10,
        minAge: 16
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
      datetimetest: 'null',
      showStartCreate: true,
      showEndCreate: false,
      showStep1: false,
      showStep2: false,
      showStep3: false,
      showStep4: false,
      step1Input: false,
      button1Title: "Далее",
      variantContinueButton1: "warning",
      step2Input: false,
      button2Title: "Далее",
      variantContinueButton2: "warning",
      step3Input: false,
      button3Title: "Далее",
      variantContinueButton3: "warning",
      step4Input: false,
      srcImage: require('../../../assets/meeticon2.png'),

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


    //Подставляем текущую дату в старт и энд тайм митинга
    var d = new Date();
    var curr_date = d.getDate();
    if ((Math.floor(curr_date / 10)) === 0) {
      var buf = curr_date;
      curr_date="";
      curr_date = "0"+buf;
      }
      var curr_month = d.getMonth() + 1;
      if ((Math.floor(curr_month / 10)) === 0) {
        var buf = curr_month;
        curr_month="";
        curr_month = "0"+buf;
      }
      var curr_year = d.getFullYear();

      var formatedDate = curr_year + "-" + curr_month + "-" + curr_date + "T" + new Date().toLocaleTimeString('en-US', { hour12: false,
                                                                         hour: "numeric",
                                                                         minute: "numeric"});
      this.form.startTime = formatedDate;
      this.form.endTime = formatedDate;

      if (window.localStorage.getItem('STORAGE_USER_INFO') !== null) {
      this.form.creatorId = JSON.parse(window.localStorage.getItem('STORAGE_USER_INFO')).userId;
    }

  },


  methods: {
    step1(){
      if (!this.step1Input) {
        this.step1Input = true;
        this.variantContinueButton1 = "success";
        this.button1Title = "Готово"
      }
    },
    step2(){
      if (!this.step2Input) {
        this.step2Input = true;
        this.variantContinueButton2 = "success";
        this.button2Title = "Готово"
      }
    },
    step3(){
      if (!this.step3Input) {
        this.step3Input = true;
        this.variantContinueButton3 = "success";
        this.button3Title = "Готово"
      }
    },

    goToMyMeetings() {
      router.push({ path: '/profile/my_meetings' })
    },

    createOneMore() {
      this.showEndCreate = false;
      this.showStep2 = false;
      this.showStep3 = false;
      this.showStep4 = false;
      this.step1Input = false;
      this.button1Title = "Далее";
      this.variantContinueButton1 = "warning";
      this.step2Input = false;
      this.button2Title = "Далее";
      this.variantContinueButton2 = "warning";
      this.step3Input = false;
      this.button3Title = "Далее";
      this.variantContinueButton3 = "warning";
      this.step4Input = false;
      this.form.creatorId = JSON.parse(window.localStorage.getItem('STORAGE_USER_INFO')).userId;
      this.form.categoryId =  1;
      this.form.addressId = null;
      this.form.name = '';
      this.form.startTime = '';
      this.form.endTime = '';
      this.form.description = '';
      this.form.maxParticipants = 10;
      this.form.minAge = 16;
      this.marker = {};
      this.geolocate();
    },


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
          this.showStep1 = false;
          this.showStep2 = false;
          this.showStep3 = false;
          this.showStep4 = false;
          this.showEndCreate = true;
          console.log(response);
        }

      }).catch(function (error) {
        alert("Упсссс..... Что-то пошло не так! Попробуйте заново!");
        location.reload();
        console.log(error);
      });
    }
  },
  router
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

.searchMapInput {
    width: 70%;
    padding: 10px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 50px;
    box-sizing: border-box;
 }

.creationHeader{
      border: 5px solid #dc3645;
          border-radius: 50px;
}

 #searchMapButton {
   border-radius: 50px;
  }

#createMeetingButton {
  border-radius: 50px;
  border: 5px solid  #FFFFFF;
}

</style>

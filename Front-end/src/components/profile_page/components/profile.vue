<template lang="html">

  <div class="profilepage">
    <b-container>
      <b-row>
        <b-col></b-col>
        <b-col cols="10">
    <!-- Страница профайла -->

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
    <br>
    <b-container fluid class="profileInfo">
      <div class="profileInfodiv">
      <b-card-header header-bg-variant="light" header-text-variant="dark" header-tag="header">
          Информация профиля
          <i class="fas fa-info-circle"></i>
      </b-card-header>

      <b-card>
      <b-row>
        <b-col>
          <div class="usernameinput">
            <b-input-group >
                <b-input-group-prepend>
                    <b-btn  :variant="editInfoButton.variant_prepend">Username <i class="fas fa-user"></i></b-btn>
                </b-input-group-prepend>

                <b-form-input  v-model.trim="form.username"
                type="text"
                disabled></b-form-input>

            </b-input-group>
          </div>
        </b-col>
      </b-row>
      <br>
      <b-row>
        <b-col>
          <div class="userfirstName">
            <b-input-group >
                <b-input-group-prepend>
                    <b-btn :variant="editInfoButton.variant_prepend"> Имя </b-btn>
                </b-input-group-prepend>

                <b-form-input v-model.trim="form.firstName"
                type="text"
                :disabled="editform"></b-form-input>

            </b-input-group>
          </div>
        </b-col>
        <b-col>
          <div class="userlastName">
            <b-input-group >
                <b-input-group-prepend>
                    <b-btn :variant="editInfoButton.variant_prepend"> Фамилия </b-btn>
                </b-input-group-prepend>

                <b-form-input v-model.trim="form.lastName"
                type="text"
                :disabled="editform"></b-form-input>

            </b-input-group>
          </div>
        </b-col>
      </b-row>
      <br>
      <b-row>
        <b-col>
          <div class="sex">
            <b-input-group >
                <b-input-group-prepend>
                    <b-btn :variant="editInfoButton.variant_prepend"> Пол <i class="fas fa-male"></i> <i class="fas fa-female"></i></b-btn>
                </b-input-group-prepend>
                <b-input-group-append>
                  <b-btn @click="setMale()" v-show="showSexButtons" :variant="sexButtonMaleVariant">Мужской</b-btn>
                  <b-btn @click="setFemale()" v-show="showSexButtons" :variant="sexButtonFemaleVariant">Женский</b-btn>
                  <b-btn v-show="showSex" :pressed="true" variant="dark">{{ sexShow }}</b-btn>
                </b-input-group-append>
            </b-input-group>
          </div>
        </b-col>
        <b-col>
          <div class="bithday">
            <b-input-group >
                <b-input-group-prepend>
                    <b-btn :variant="editInfoButton.variant_prepend"> Дата рождения <i class="fas fa-calendar-alt"></i></b-btn>
                </b-input-group-prepend>

                <b-form-input
                  v-model.trim="form.birthday"
                  :disabled="editform"
                  type="date">
                </b-form-input>

            </b-input-group>
          </div>
        </b-col>
      </b-row>
        </b-card>
        <b-card-footer footer-bg-variant="dark" footer-border-variant="dark">
            <b-button-group size="">
              <b-btn id="editinfobutton" class="editinfobutton"
                      @click="editinfo"
                      :variant="editInfoButton.variant"> {{ editInfoButton.title }}
              </b-btn>
              <b-popover ref="popoverOne" target="editinfobutton"
               placement="left"
               title="Нажми!"
               triggers="hover focus"
               content="И ты сможешь отредактировать информацию :)">
             </b-popover>
            </b-button-group>
        </b-card-footer>
    </div>
  </b-container>
  <!-- Делаем отступ -->
  <br>
  <br>


  <b-container fluid class="profileContactInfo">
    <div class="ContactInfo">
        <b-card-header header-bg-variant="light" header-text-variant="dark">
          Контактные данные <i class="fas fa-address-book"></i>
      </b-card-header>
    <b-card>
    <b-row>
      <b-col>
        <div class="email">
          <b-input-group >
              <b-input-group-prepend>
                  <b-btn :variant="editContactButton.variant_prepend"> e-mail <i class="fas fa-envelope"></i></b-btn>
              </b-input-group-prepend>
              <b-form-input
              v-model.trim="form.email"
              type="email"
              :disabled="editContactInfo"></b-form-input>

              <b-input-group-append>
                  <b-btn @click="selectPreferred('e')" v-if="showEmail" :variant="prEmailVariant">*<i class="fas fa-bell"></i></b-btn>
              </b-input-group-append>

          </b-input-group>
        </div>
      </b-col>
      <b-col>
        <div class="phoneNumber">
          <b-input-group >
              <b-input-group-prepend>
                  <b-btn :variant="editContactButton.variant_prepend"> Телефон <i class="fas fa-phone"></i></b-btn>
              </b-input-group-prepend>
              <b-form-input
              v-model.trim="form.phoneNumber"
              :disabled="editContactInfo"></b-form-input>

              <b-input-group-append>
                  <b-btn @click="selectPreferred('p')" v-if="showPhone" :variant="prPhoneVariant">*<i class="fas fa-bell"></i></b-btn>
              </b-input-group-append>

          </b-input-group>
        </div>
      </b-col>
    </b-row>
          <br>
    <b-row>
      <b-col>
      </b-col>
      <b-col cols="8">
        <div class="userAddress">
          <b-input-group >
              <b-input-group-prepend>
                  <b-btn :variant="editContactButton.variant_prepend"> Адрес <i class="fas fa-map-marker"></i></b-btn>
              </b-input-group-prepend>
              <b-form-input
              v-model.trim="address"
              disabled></b-form-input>
          </b-input-group>
        </div>
      </b-col>
      <b-col>
      </b-col>
    </b-row>
    <br>
    <b-row v-if="showAutoComplete">
      <b-col>
        <p>
        <gmap-autocomplete class="MapInput" placeholder="Введите ваш адрес"
          @place_changed="setPlace">

        </gmap-autocomplete>
        <b-button size="" variant="outline-dark"  @click="addAddress()" id="searchButton">
            Добавить новый адрес <i class="fas fa-map-marker-alt"></i>
        </b-button>
      </p>
      </b-col>
      <br>
    </b-row>


    <b-row>
      <b-col sm="">
        <b-card bg-variant="white" >
          <gmap-map
            :center="center"
            :zoom="14"
            style="width:100%;  height: 250px;"
          >
            <gmap-marker
              :position="marker"
              @click="center=marker"
            ></gmap-marker>
          </gmap-map>

        </b-card>
      </b-col>
    </b-row>
    <!-- Отсуп после карты -->
    <br>
    <b-row>
      <b-col></b-col>
      <b-col cols="8">
        <div class="vkReference">
          <b-input-group >
              <b-input-group-prepend>
                  <b-btn id="vk" :variant="editContactButton.variant_prepend" :href="form.vkReference" target="_blank">  <i class="fab fa-vk"></i></b-btn>
                  <b-popover target="vk"
                   placement="topleft"
                   title="Нажми!"
                   triggers="hover focus"
                   content="И мы откроем VK для тебя :)">
                 </b-popover>
              </b-input-group-prepend>
              <b-form-input
              v-model.trim="form.vkReference"
              :disabled="editContactInfo"></b-form-input>

              <b-input-group-append>
                  <b-btn @click="selectPreferred('v')" v-if="showVk" :variant="prVkVariant">*<i class="fas fa-bell"></i></b-btn>
              </b-input-group-append>


          </b-input-group>
        </div>
      </b-col>
      <b-col></b-col>
    </b-row>
    <br>
    <b-row>
      <b-col></b-col>
      <b-col cols="8">
        <div class="facebookReference">
          <b-input-group >
              <b-input-group-prepend>
                  <b-btn id="fb" :variant="editContactButton.variant_prepend" :href="form.facebookReference" target="_blank">  <i class="fab fa-facebook"></i></b-btn>
                  <b-popover target="fb"
                   placement="left"
                   title="Нажми!"
                   triggers="hover focus"
                   content="И мы откроем Facebook для тебя :)">
                 </b-popover>
              </b-input-group-prepend>
              <b-form-input
              v-model.trim="form.facebookReference"
              :disabled="editContactInfo"></b-form-input>

              <b-input-group-append>
                  <b-btn @click="selectPreferred('f')" v-if="showFb" :variant="prFbVariant">*<i class="fas fa-bell"></i></b-btn>
              </b-input-group-append>


          </b-input-group>
        </div>
      </b-col>
      <b-col></b-col>
    </b-row>
    <br>
    <b-row>
      <b-col></b-col>
      <b-col cols="8">
        <div class="twitterReference">
          <b-input-group >
              <b-input-group-prepend>
                  <b-btn id="twitter" :variant="editContactButton.variant_prepend" :href="form.twitterReference" target="_blank">  <i class="fab fa-twitter"></i></b-btn>
                  <b-popover target="twitter"
                   placement="bottomleft"
                   title="Нажми!"
                   triggers="hover focus"
                   content="И мы откроем twitter для тебя :)">
                 </b-popover>
              </b-input-group-prepend>
              <b-form-input
              v-model.trim="form.twitterReference"
              :disabled="editContactInfo"></b-form-input>

              <b-input-group-append>
                  <b-btn @click="selectPreferred('t')" v-if="showTw" :variant="prTwVariant">*<i class="fas fa-bell"></i></b-btn>
              </b-input-group-append>


          </b-input-group>
        </div>
      </b-col>
      <b-col></b-col>
    </b-row>
    <br>
    <b-row>
          <b-col>
              <h5><strong>*</strong><i class="fas fa-bell"></i> - Предпочтительный способ связи</h5>
          </b-col>
    </b-row>
    </b-card>
    <b-card-footer footer-bg-variant="dark" footer-border-variant="dark">
        <b-button-group size="">
          <b-btn id="editcontactbutton" class="editcontactbutton"
                  @click="editContactData"
                  :variant="editContactButton.variant"> {{ editContactButton.title }}
          </b-btn>
          <b-popover ref="popoverOne" target="editcontactbutton"
           placement="bottom"
           title="Нажми!"
           triggers="hover focus"
           content="И ты сможешь отредактировать информацию :)">
         </b-popover>
        </b-button-group>
    </b-card-footer>
    </div>
  </b-container>
      <br>
      </b-col>
      <b-col></b-col>
    </b-row>
  </b-container>
</div>
</template>

<script>
import axios from 'axios'
import router from '../../../router'
export default {
  data () {
    return {
      center: { lat: 0, lng: 0 },
      marker: { lat: 0, lng: 0 },
      place: { lat: 0, lng: 0 },
      currentPlace: null,
      showAutoComplete: false,
      showAddressField: true,

      prEmailVariant: "outline-dark",
      prPhoneVariant: "outline-dark",
      prVkVariant: "outline-dark",
      prFbVariant: "outline-dark",
      prTwVariant: "outline-dark",
      showEmail: true,
      showPhone: true,
      showVk: true,
      showFb: true,
      showTw: true,


      form: {
          id: '',
          username: '',
          firstName: '',
          lastName: '',
          sex: '',
          preferred: "e",
          birthday: '',
          email: '',
          phoneNumber: 'Телефон не указан',
          vkReference: 'https://vk.com',
          facebookReference: 'https://www.facebook.com',
          twitterReference: 'https://twitter.com',
          addressId: '',
          userAddress: {
                    id: 25,
                    locality: "Санкт-Петербург",
                    street: "Думская улица",
                    house: "7",
                    latitude: 59.933221,
                    longitude: 30.327857999999992
                  }
      },

      address: "Адрес не указан",

      editInfoButton: {
        button_state: false,
        variant: 'dark',
        title: 'Редактировать данные',
        variant_prepend: 'dark'
      },

      editContactButton: {
        button_state: false,
        variant: 'dark',
        title: 'Редактировать данные',
        variant_prepend: 'dark'
      },

      create: ' [ Empty.. ]',
      editform: true,
      editContactInfo: true,
      showSexButtons: false,
      showSex: true,
      sexButtonMaleVariant: "",
      sexButtonFemaleVariant: ""
    }


  },

    computed: {
      sexShow() {
        if (this.form.sex === 'm') {
          this.sexButtonMaleVariant ="dark";
          this.sexButtonFemaleVariant ="outline-dark";
          return "Мужской"
        } else {
          this.sexButtonMaleVariant ="outline-dark";
          this.sexButtonFemaleVariant ="dark";
          return "Женский"
        }
      },
    },

  methods: {
    selectPreferred(typeOfContact) {
      switch(typeOfContact) {
        case ("e"):
          this.form.preferred = "e";
          this.prVkVariant = "outline-dark";
          this.prFbVariant = "outline-dark";
          this.prTwVariant = "outline-dark";
          this.prPhoneVariant = "outline-dark";
          this.prEmailVariant = "dark";
          break;
        case ("p"):
          this.form.preferred = "p";
          this.prVkVariant = "outline-dark";
          this.prFbVariant = "outline-dark";
          this.prTwVariant = "outline-dark";
          this.prPhoneVariant = "dark";
          this.prEmailVariant = "outline-dark";
          break;
        case ("v"):
          this.form.preferred = "v";
          this.prVkVariant = "dark";
          this.prFbVariant = "outline-dark";
          this.prTwVariant = "outline-dark";
          this.prPhoneVariant = "outline-dark";
          this.prEmailVariant = "outline-dark";
          break;
        case ("f"):
          this.form.preferred = "f";
          this.prVkVariant = "outline-dark";
          this.prFbVariant = "dark";
          this.prTwVariant = "outline-dark";
          this.prPhoneVariant = "outline-dark";
          this.prEmailVariant = "outline-dark";
          break;
        case ("t"):
          this.form.preferred = "t";
          this.prVkVariant = "outline-dark";
          this.prFbVariant = "outline-dark";
          this.prTwVariant = "dark";
          this.prPhoneVariant = "outline-dark";
          this.prEmailVariant = "outline-dark";
          break;
          }
    },

    showPreferred(typeOfContact){
      this.showEmail = true;
      this.showPhone = true;
      this.showVk = true;
      this.showFb = true;
      this.showTw = true;
    },

    hidePreferred(typeOfContact){
      switch(typeOfContact) {
        case ("e"):
        this.showPhone = false;
        this.showVk = false;
        this.showFb = false;
        this.showTw = false;
          break;
        case ("p"):
        this.showEmail = false;
        this.showVk = false;
        this.showFb = false;
        this.showTw = false;

          break;
        case ("v"):
        this.showEmail = false;
        this.showPhone = false;
        this.showFb = false;
        this.showTw = false;
          break;
        case ("f"):
        this.showEmail = false;
        this.showPhone = false;
        this.showVk = false;
        this.showTw = false;
          break;
        case ("t"):
        this.showEmail = false;
        this.showPhone = false;
        this.showVk = false;
        this.showFb = false;
          break;
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

    setPlace(place) {
      this.currentPlace = place;
      const marker = {
        lat: this.currentPlace.geometry.location.lat(),
        lng: this.currentPlace.geometry.location.lng()
      };
      this.marker = marker;
      this.place = this.currentPlace;
      this.center = marker;
      this.currentPlace = null;

    },
    addAddress() {
        //Обнуляем форму адреса
        this.form.userAddress = {
          id: null,
          locality: "",
          street: "",
          house: "",
          latitude: "",
          longitude: ""
        };

        //Добавление в formAddress широты и долготы
         this.form.userAddress.latitude = this.marker.lat;
         this.form.userAddress.longitude = this.marker.lng;

         //Добавление в formAddress города, улицы и номера
         var json = this.place.address_components;

         for (var i = 0; i < json.length; i++) {
            var current_type = json[i].types[0];
            switch(current_type) {
              case ("street_number"):
                   this.form.userAddress.house = json[i].long_name;
                  break;
             case ("route"):
                   this.form.userAddress.street = json[i].long_name;
                  break;
            case ("locality"):
                 this.form.userAddress.locality = json[i].long_name;
                break;
              }
            }

            // Отображение адреса в строке АДРЕС
            this.address = this.form.userAddress.locality + ", " + this.form.userAddress.street + ", " + this.form.userAddress.house;

       //Отправляем выбранный адресс и получаем addressId из базы
        axios.post("/address", this.form.userAddress)
        .then(response => {
          if (response.status === 200) {
            this.form.addressId = response.data.id;
          }

        }).catch(function (error) {
          alert("Ошибка добавления адреса!");
          console.log(error);
        });
    },


    setMale() {
      this.form.sex = 'm';
      this.sexButtonMaleVariant = "dark";
      this.sexButtonFemaleVariant = "outline-dark";
    },

    setFemale() {
      this.form.sex = 'f';
      this.sexButtonMaleVariant = "outline-dark";
      this.sexButtonFemaleVariant = "dark";
    },


    sendInfo() {
      axios.post("/user", this.form)
      .then(response => {

        if (response.status === 200) {

          console.log(response);
        }

      }).catch(function (error) {
        alert("Error...");
        console.log(error);
      });
    },

    editinfo() {
      if (this.editInfoButton.button_state) {
        this.editInfoButton.variant_prepend = 'dark';
        this.editform = !this.editform;
        this.editInfoButton.variant = 'dark';
        this.editInfoButton.title = 'Редактировать данные';
        this.showSex = !this.showSex;
        this.showSexButtons = !this.showSexButtons;
        this.editInfoButton.button_state = !this.editInfoButton.button_state;

        this.sendInfo();

      }else {
        this.editInfoButton.variant_prepend = 'outline-dark'
        this.editform = !this.editform;
        this.editInfoButton.variant = 'white';
        this.editInfoButton.title = 'Применить изменения';
        this.showSex = !this.showSex;
        this.showSexButtons = !this.showSexButtons;
        this.editInfoButton.button_state = !this.editInfoButton.button_state;
      }
    },

    editContactData() {
      if (this.editContactButton.button_state) {
        this.showAddressField = true;
        this.showAutoComplete = false;

        this.editContactButton.variant_prepend = 'dark';
        this.editContactInfo = !this.editContactInfo;
        this.editContactButton.variant = 'dark';
        this.editContactButton.title = 'Редактировать данные';
        this.editContactButton.button_state = !this.editContactButton.button_state;

        // Востанавливаем метку на карте, если адрес не был обновлен
        this.center.lat = this.form.userAddress.latitude;
        this.center.lng = this.form.userAddress.longitude;
        this.marker.lat = this.form.userAddress.latitude;
        this.marker.lng = this.form.userAddress.longitude;

        this.sendInfo();
        this.hidePreferred(this.form.preferred);

      }else {
        this.showAddressField = false;
        this.showAutoComplete = true;

        this.editContactButton.variant_prepend = 'outline-dark'
        this.editContactInfo = !this.editContactInfo;
        this.editContactButton.variant = 'white';
        this.editContactButton.title = 'Применить изменения';
        this.editContactButton.button_state = !this.editContactButton.button_state;

        this.showPreferred();
      }
    }

  },

  created: function () {
   if (localStorage.getItem('STORAGE_USER_INFO') !== null && JSON.parse(window.localStorage.getItem('STORAGE_USER_INFO')).userId != 0) { //проверяем есть ли такой ключ, если нет отправляем на главную
        var storageInfo = JSON.parse(window.localStorage.getItem('STORAGE_USER_INFO'));

            axios.get("/user?id="+storageInfo.userId)
            .then(response => {

              //отображаем карту по геолокации
               // this.geolocate();
            //Oбновляем сторедж
            var storage = {
              userId: response.data.id,
              userName: response.data.username
            }
            window.localStorage.setItem('STORAGE_USER_INFO', JSON.stringify(storage));

            // Заполнение форм по респонсу
            this.form.id = response.data.id;
            this.form.username = response.data.username;
            this.form.firstName = response.data.firstName;
            this.form.lastName = response.data.lastName;
            this.form.sex = response.data.sex;
            this.form.birthday = response.data.birthday;
            this.form.email = response.data.userContact.email;
            this.form.phoneNumber = response.data.userContact.phoneNumber;
            this.form.vkReference = response.data.userContact.vkReference;
            this.form.facebookReference = response.data.userContact.facebookReference;
            this.form.twitterReference = response.data.userContact.twitterReference;

            if (response.data.userContact.preferred === null) {
              this.form.preferred = "e";
              this.sendInfo();
              this.selectPreferred(this.form.preferred);
              this.hidePreferred(this.form.preferred);
            } else {
              this.form.preferred = response.data.userContact.preferred;
              this.selectPreferred(this.form.preferred);
              this.hidePreferred(this.form.preferred);
            }


            if (response.data.userAddress === null) {
              this.address = "Адрес не указан :(";
            } else {

              this.form.userAddress.id = response.data.userAddress.id;
              this.form.userAddress.latitude = response.data.userAddress.latitude;
              this.form.userAddress.longitude = response.data.userAddress.longitude;
              this.form.userAddress.locality = response.data.userAddress.locality;
              this.form.userAddress.street = response.data.userAddress.street;
              this.form.userAddress.house = response.data.userAddress.house;

              this.center.lat = this.form.userAddress.latitude;
              this.center.lng = this.form.userAddress.longitude;
              this.marker.lat = this.form.userAddress.latitude;
              this.marker.lng = this.form.userAddress.longitude;

              // Отображение адреса в строке АДРЕС
              this.address = this.form.userAddress.locality + ", " + this.form.userAddress.street + ", " + this.form.userAddress.house;
            }

            }).catch(function (error) {
              alert("OOPSSS!! Мы набАааагали!") //выключить в продакшене
              //router.push({ path: '/' }) //включить в продакшен
              console.log(error);
            });
        } else {
          router.push({ path: '/' })
          alert("Вы не совершили вход!");
        }
  },
  router,
  components: {

  }

}

</script>

<style lang="css">
.MapInput {
    width: 70%;
    padding: 6px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
 }

 #searchButton {
   border-radius: 5px;
  }
</style>

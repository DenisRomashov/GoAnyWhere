<template lang="html">
  <div class="profile">
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

                <b-form-input
                v-model.trim="form.sex"
                :disabled="editform"></b-form-input>



            </b-input-group>
          </div>
        </b-col>
        <b-col>
          <div class="bithday">
            <b-input-group >
                <b-input-group-prepend>
                    <b-btn :variant="editInfoButton.variant_prepend"> Дата рождения <i class="fas fa-calendar-alt"></i></b-btn>
                </b-input-group-prepend>

                <b-form-input  :disabled="editform"></b-form-input>

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
              v-model.trim="form.userAddress"
              :disabled="editContactInfo"></b-form-input>
          </b-input-group>
        </div>
      </b-col>
      <b-col>
      </b-col>
    </b-row>
    <br>
    <b-row>
      <b-col>Поиск по карте</b-col>
    </b-row>
    <br>
    <b-row>
      <b-col>Форма для широты</b-col>
      <b-col>Форма для долготы</b-col>
    </b-row>

    <b-row>
      <b-col>
        <!-- <yandex-map
          :coords="[59.9386300, 30.3141300]"
          zoom="10"
          style="width: auto; height: 300px;"
          :cluster-options="{1: {clusterDisableClickZoom: true}}"
          :behaviors="['ruler']"
          :placemarks="placemarks"
          map-type="map"
          >
        </yandex-map> -->
        <h1> <strong>КАРТА</strong> </h1>
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
          </b-input-group>
        </div>
      </b-col>
      <b-col></b-col>
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
    <br>
    </div>
  </b-container>







    <!-- test variable -->
    <!-- <h1>{{ create }}</h1> -->
  </div>
</template>

<script>
import axios from 'axios'
import router from '../../../router'
export default {
  data () {
    return {
   //    placemarks: [
   //   {
   //     coords: [54.8, 39.8],
   //     properties: {}, // define properties here
   //     options: {}, // define options here
   //     clusterName: "1",
   //     balloonTemplate: '<div>"Your custom template"</div>',
   //     callbacks: { click: function() {} }
   //   }
   // ],

      form: {
          id: '',
          username: '',
          firstName: '',
          lastName: '',
          sex: '',
          bithday: '',
          email: '',
          phoneNumber: '',
          vkReference: 'https://vk.com',
          facebookReference: 'https://www.facebook.com',
          twitterReference: 'https://twitter.com',
          // userAddress: ''
      },

      adress: {
        userAddress: ''
      },

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
      editContactInfo: true
    }


  },
  methods: {
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
        this.editInfoButton.button_state = !this.editInfoButton.button_state;

        this.sendInfo();

      }else {
        this.editInfoButton.variant_prepend = 'outline-dark'
        this.editform = !this.editform;
        this.editInfoButton.variant = 'white';
        this.editInfoButton.title = 'Применить изменения';
        this.editInfoButton.button_state = !this.editInfoButton.button_state;
      }
    },

    editContactData() {
      if (this.editContactButton.button_state) {
        this.editContactButton.variant_prepend = 'dark';
        this.editContactInfo = !this.editContactInfo;
        this.editContactButton.variant = 'dark';
        this.editContactButton.title = 'Редактировать данные';
        this.editContactButton.button_state = !this.editContactButton.button_state;

        this.sendInfo();

      }else {
        this.editContactButton.variant_prepend = 'outline-dark'
        this.editContactInfo = !this.editContactInfo;
        this.editContactButton.variant = 'white';
        this.editContactButton.title = 'Применить изменения';
        this.editContactButton.button_state = !this.editContactButton.button_state;
      }
    }

  },

  created: function () {
   if (localStorage.getItem('STORAGE_USER_INFO') !== null && JSON.parse(window.localStorage.getItem('STORAGE_USER_INFO')).userId != 0) { //проверяем есть ли такой ключ, если нет отправляем на главную
        var storageInfo = JSON.parse(window.localStorage.getItem('STORAGE_USER_INFO'));
        //this.create = storageInfo;
        if (storageInfo.userId != 0) {
            axios.get("/user?id="+storageInfo.userId)
            .then(response => {
            //Oбновляем сторедж
            var storage = {
              userId: response.data.id,
              userName: response.data.username
            }
            window.localStorage.setItem('STORAGE_USER_INFO', JSON.stringify(storage));

            //this.create = response.data.userContact.email;
            //this.create = response.data.userContact.facebookReference;

            // Заполнение форм по респонсу
            this.form.id = response.data.id;
            this.form.username = response.data.username;
            this.form.firstName = response.data.firstName;
            this.form.lastName = response.data.lastName;
            this.form.sex = response.data.sex;
            this.form.bithday = response.data.bithday;
            this.form.email = response.data.userContact.email;
            this.form.phoneNumber = response.data.userContact.phoneNumber;
            this.form.vkReference = response.data.userContact.vkReference;
            this.form.facebookReference = response.data.userContact.facebookReference;
            this.form.twitterReference = response.data.userContact.twitterReference;


            }).catch(function (error) {
              alert("OOPSSS!! Мы набАааагали!") //выключить в продакшене
              //router.push({ path: '/' }) //включить в продакшен
              console.log(error);
            });
          } else {
            router.push({ path: '/' })
            alert("Вы не совершили вход!");
          }
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

</style>

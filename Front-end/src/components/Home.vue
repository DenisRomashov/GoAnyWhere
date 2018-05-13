<template>
  <div class="homepage">
      <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">

      <b-navbar toggleable="md" type="dark" variant="dark" fixed="top">
          <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>
          <b-navbar-brand href="/">GoAnyWhere</b-navbar-brand>
          <b-collapse is-nav id="nav_collapse">

              <b-button-group >
                  <b-button size="" variant="dark" href="#about">О нас <i class="fab fa-angellist"></i></b-button>
              </b-button-group>
              <!-- Войти и регистрация  -->
              <b-navbar-nav class="ml-auto">
                  <div>
                    <b-form inline v-if="showSingIn">
                      <b-button-group >
                          <b-button   @click="showSingInForm=true" variant="dark">Войти <i class="fas fa-sign-in-alt"></i></b-button>
                          <router-link :to="{ path: 'registration' }">
                              <b-button  size="" variant="dark">Регистрация <i class="fas fa-user-plus"></i></b-button>
                          </router-link>
                      </b-button-group>
                    </b-form>
                    <!-- Показ информации при логине в навабаре кнопки Профайла и Выхода -->
                    <b-nav-form v-if="showProfile">
                        <b-button-group>
                          <router-link :to="{ path: 'profile' }">
                            <b-button variant="dark"><i class="fas fa-user"></i> {{ userProfileName }}</b-button>
                          </router-link>
                        <b-button @click="showModal" variant="dark">Выйти <i class="fas fa-sign-out-alt"></i></b-button>
                      </b-button-group>
                    </b-nav-form>
                  </div>
              </b-navbar-nav>
        </b-collapse>
      </b-navbar>
      <!--Добавление карусели с помощью компонента carousel-->
      <carousel id="Carousel"/>

      <a name="about"> </a>
      <!-- Первый джамбатрон, красный -->
      <b-jumbotron bg-variant="danger" text-variant="white" border-variant="dark">
          <template slot="header">
              Наша цель!
          </template>
          <template slot="lead">
              Предоставить людям простые и понятные инструменты для организации неформальных встреч на самые различные темы:
              политика, книги, игры, кино, здоровье, домашние любимцы, карьера, технологии и т.д.
          </template>
          <hr class="my-4">
          <p>
              А вы знали? <br> <br>Идея митапов возникла задолго до того, как появился Интернет.
              Однако само слово в известном нам значении стало употребляться с 2001 года!
          </p>
      </b-jumbotron>

      <!-- Второй джамбатрон  -->
      <b-jumbotron bg-variant="outline-danger" header="Делай что-нибудь!" id="jumbotron2">
          <p>Это значит, что нельзя сидеть на месте и ждать, пока другой реализует интересную идею,
            родившуюся у тебя в голове. <br> Какой бы сумасбродной ни была мысль – делись ею, ищи единомышленников,
            думайте как реализовать ее, встречайтесь, организовывайте.
            <br>Самое главное – это понять, что ты не одинок и в любом случае найдутся люди, готовые тебя поддержать.</p>

            <router-link :to="{ path: 'registration' }">
              <b-btn variant="danger" v-if="showSingIn" size="lg">Регистрируйся прямо сейчас!</b-btn>
            </router-link>
      </b-jumbotron>
      <footerone/>


      <!-- singInForm -->
      <div class="singInForm">
        <b-modal v-model="showSingInForm"
                 title="Вход"
                 header-bg-variant="white"
                 header-text-variant="dark"
                 body-bg-variant="light"
                 body-text-variant="dark"
                 footer-bg-variant="dark"
                 footer-text-variant="light">
           <b-container fluid>
             <b-row>
               <b-col cols="1"></b-col>
               <b-col cols="9">
                 <div class="usernameinput">
                   <b-input-group >
                       <b-input-group-prepend>
                           <b-btn  variant="secondary">Username <i class="fas fa-user"></i></b-btn>
                       </b-input-group-prepend>
                       <b-form-input
                          v-model.trim = "form.username"
                          type="text">
                     </b-form-input>
                   </b-input-group>
                 </div>
               </b-col>
               <b-col cols="3"></b-col>
             </b-row>
             <br>
             <b-row>
               <b-col cols="1"></b-col>
               <b-col cols="9">
                 <div class="passwordinput">
                   <b-input-group >
                       <b-input-group-prepend>
                           <b-btn  variant="secondary"> Password <i class="fas fa-unlock-alt"></i></b-btn>
                       </b-input-group-prepend>
                       <b-form-input
                         type="password"
                         v-model="form.password">
                     </b-form-input>
                   </b-input-group>
                 </div>
               </b-col>
               <b-col cols="3"></b-col>
             </b-row>
           </b-container>

           <div slot="modal-footer" class="w-100">
             <p class="float-left">© GoAnyWhere Project 2018</p>
             <b-btn @click="onSubmit" size="" class="float-right" variant="dark">Войти</b-btn>
           </div>
        </b-modal>
      </div>

      <!-- ExitModalForm -->
      <div class="ExitModalForm">
          <!-- <b-btn @click="show=true" variant="primary">Show Modal</b-btn> -->
        <b-modal ref="Exit"
                 :title="titleExitModal"
                 header-bg-variant="white"
                 header-text-variant="dark"
                 body-bg-variant="light"
                 body-text-variant="dark"
                 footer-bg-variant="dark"
                 footer-text-variant="light">
           <b-container fluid>
             <div class="d-block text-center">
             </div>
             <b-btn size="" class="mt-3" variant="outline-dark" block @click="hideModal">Остаться!</b-btn>
             <b-btn size=""class="mt-3" variant="outline-danger" block @click="exit()">Выйти</b-btn>
           </b-container>

           <div slot="modal-footer" class="w-100">
             <p class="float-left">© GoAnyWhere Project 2018</p>
           </div>
        </b-modal>
      </div>


    </div>
</template>

<script>
import router from '../router'
import axios from 'axios'
import VueAxios from 'vue-axios'
import Carousel from './Carousel'
import footerone from './footerone'
export default {
  data() {
    return {
      form: {
        username: '',
        password: ''
      },

      userInfo : {
        userId: 0,
        userName: ''
      },
      showSingIn: true,
      showProfile: false,
      showSingInForm: false,
      userProfileName: '',
      titleExitModal: '',
      test: ''
    }
  },
  methods: {
    onSubmit () {
      // evt.preventDefault();
      this.showSingInForm = false;
      window.localStorage.setItem('STORAGE_USER_INFO', JSON.stringify(this.userInfo));

      //Запрос
      axios.post("/auth", this.form)
      .then(response => {
        console.log(response);
        if (response.data.id > 0) {
        //  this.test = response;
          this.userInfo.userId = response.data.id;
          //Добавление данных в локал сторедж и переход
          window.localStorage.setItem('STORAGE_USER_INFO', JSON.stringify(this.userInfo))
          router.push({ path: 'profile' })
        } else {
          alert("Неверный пароль или вы еще не зарегистрированы!")
          this.form.username = '';
          this.form.password = '';
        }
      }).catch(function (error) {
        alert("Сервер недоступен! Мы сожалеем :(");
        console.log(error);
      });
      //this.show = false; //скрыть после отправки данных
    },

    exit() {
      window.localStorage.removeItem('STORAGE_USER_INFO');
      this.$refs.Exit.hide();
      window.location.reload();
    },

    showModal () {
      this.titleExitModal = this.userProfileName + ', уже уходите!? :(';
      this.$refs.Exit.show()
    },

    hideModal () {
     this.$refs.Exit.hide()
   }
  },

  created: function() {
    if (window.localStorage.getItem('STORAGE_USER_INFO') !== null && JSON.parse(window.localStorage.getItem('STORAGE_USER_INFO')).userId != 0)  {
      this.userProfileName = JSON.parse(window.localStorage.getItem('STORAGE_USER_INFO')).userName;
      this.showSingIn = false;
      this.showProfile = true;
    }
  },

  router,
  components: {
    Carousel,
    footerone
  }
}
</script>

<style lang="css">
#Carousel {
    margin-top: -5px;
}

#jumbotron2 {
  margin-top: -35px;
  margin-bottom: auto;
  font-size: 20px;
}


</style>

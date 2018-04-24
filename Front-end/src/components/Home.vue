<template>
  <div class="homepage">

      <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">

      <b-navbar toggleable="md" type="dark" variant="dark" fixed="top">
        <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>


        <b-navbar-brand href="/">GoAnyWhere</b-navbar-brand>
        <b-collapse is-nav id="nav_collapse">
          <!-- <b-nav-item > -->
            <b-button-group >
                <b-button size="" variant="dark" href="#about">О нас <i class="fab fa-angellist"></i></b-button>
          </b-button-group>
            <!-- <b-button size="" variant="outline-danger" href="#about">О нас <i class="fab fa-angellist"></i></b-button> -->
          <!-- </b-nav-item> -->
            <!-- Right aligned nav items -->
              <b-navbar-nav class="ml-auto">

                  <div>
                    <b-form inline @submit="onSubmit" v-if="showSingIn">
                    <!-- <label class="sr-only" for="inlineInputUsername">Username</label>
                    <b-input class="xs-2 mr-sm-2 mb-sm-0"
                      id="inlineInputUsername"
                      type="text"
                      v-model.trim = "form.username"
                      placeholder="Username"/>
                    <label class="sr-only" for="inlineInputPassword">Password</label>
                    <b-input-group left="@" class="mb-2 mr-sm-2 mb-sm-0">
                      <b-input id="inlineInputPassword"
                          type="password"
                          v-model="form.password"
                          placeholder="Password" />
                    </b-input-group> -->

                      <b-button-group >
                        <b-button  size="" type="submit" variant="dark">Войти <i class="fas fa-sign-in-alt"></i></b-button>
                        <router-link :to="{ path: 'registration' }">
                          <b-button  size="" variant="dark">Регистрация <i class="fas fa-user-plus"></i></b-button>
                        </router-link>
                    </b-button-group>

                    <!-- <b-button class="mb-2 mr-sm-2 mb-sm-0" size="" type="submit" variant="outline-primary">Войти</b-button>
                    <router-link :to="{ path: 'registration' }">
                      <b-button class="mb-2 mr-sm-2 mb-sm-0" size="" variant="outline-danger">Регистрация</b-button>
                    </router-link> -->
                    </b-form>


                    <!-- <b-nav-item-dropdown right>

                          <template slot="button-content">
                            User
                          </template>

                    <b-dropdown-header>This is a heading</b-dropdown-header>
                    <b-dropdown-item-button>I don't look like a button, but I am!</b-dropdown-item-button>
                    <b-dropdown-item href="#">Profile</b-dropdown-item>
                    <b-dropdown-item href="#">Signout</b-dropdown-item>
                    </b-nav-item-dropdown> -->

                    <b-nav-form v-if="showProfile">
                        <b-button-group >
                        <b-button variant="dark">Search <i class="fas fa-user"></i></b-button>
                        <b-button variant="dark">Выйти <i class="fas fa-sign-out-alt"></i></b-button>
                      </b-button-group>

                    </b-nav-form>
                  </div>

              </b-navbar-nav>
        </b-collapse>
    </b-navbar>
    <!--Добавление карусели с помощью компонента carousel-->
    <carousel id="Carousel"/>
    <!-- /////////////////////////////////////////////// -->

    <!-- для теста респонса -->

    <!-- <h1>{{ test }}</h1> -->

    <!-- --------------------------------  -->



    <a name="about"> </a>
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
        <b-btn @click="showSingInForm=true" variant="primary">Show Modal</b-btn>

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
                           <b-btn  variant="dark">Username <i class="fas fa-user"></i></b-btn>
                       </b-input-group-prepend>
                       <b-form-input   type="text">
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
                           <b-btn  variant="dark"> Password <i class="fas fa-unlock-alt"></i></b-btn>
                       </b-input-group-prepend>
                       <b-form-input   type="password">
                     </b-form-input>
                   </b-input-group>
                 </div>
               </b-col>
               <b-col cols="3"></b-col>
             </b-row>
           </b-container>

           <div slot="modal-footer" class="w-100">
             <p class="float-left">© GoAnyWhere Project 2018</p>
             <b-btn size="" class="float-right" variant="dark" @click="show=false">Войти</b-btn>
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
      test: ''
    }
  },
  methods: {
    onSubmit () {
      evt.preventDefault();

      window.localStorage.setItem('STORAGE_USER_INFO', JSON.stringify(this.userInfo))

      //Запрос
      axios.post("/auth", this.form)
      .then(response => {
        console.log(response);
        if (response.data.id > 0) {
          this.test = response;
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
    }
  },

  // created: function() {
  //   if (window.localStorage.getItem('STORAGE_USER_INFO') !== null && JSON.parse(window.localStorage.getItem('STORAGE_USER_INFO')).userId != 0)  {
  //     this.showSingIn = false;
  //   }
  // },

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

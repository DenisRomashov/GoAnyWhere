<template>
  <div>
    <b-navbar toggleable="md" type="dark" variant="dark" fixed="top">
      <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>


        <b-navbar-brand href="/">GoAnyWhere</b-navbar-brand>

      <b-button size="" variant="outline-danger" href="#about">О нас</b-button>

      <!-- Right aligned nav items -->
      <b-navbar-nav class="ml-auto">

            <div>
              <b-form inline @submit="onSubmit" v-if="show">
                <label class="sr-only" for="inlineInputUsername">Username</label>
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
                  </b-input-group>


                    <b-button class="mb-2 mr-sm-2 mb-sm-0" size="" type="submit" variant="outline-primary">Войти</b-button>
                    <router-link :to="{ path: 'registration' }">
                      <b-button class="mb-2 mr-sm-2 mb-sm-0" size="" variant="outline-danger">Регистрация</b-button>
                    </router-link>

                  </b-form>
                </div>


        </b-navbar-nav>
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
              <b-btn variant="danger" size="lg">Регистрируйся прямо сейчас!</b-btn>
            </router-link>
      </b-jumbotron>

      <footerone/>
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
      show: true,
      test: ''
    }
  },
  methods: {
    onSubmit (evt) {
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
        alert("Error...");
        console.log(error);
      });
      //this.show = false; //скрыть после отправки данных
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

<template>
  <div >
      <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
    <b-container fluid class="gridFullPage">
      <b-container class="Page">
      <b-row>
        <b-col>
          <b-navbar toggleable="md" type="dark" variant="dark" fixed="top">

            <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>


            <b-navbar-brand href="/">GoAnyWhere</b-navbar-brand>

            <b-navbar-nav>
              <router-link :to="{ path: '/' }"><b-button size="" variant="dark" class="my-2 my-sm-0" type="submit">Home <i class="fas fa-home"></i></b-button></router-link>
            </b-navbar-nav>

            <b-collapse is-nav id="nav_collapse"></b-collapse>
          </b-navbar>
        </b-col>
    </b-row>

    <b-row>
        <b-col>
          <div class="fullRegistrationForm">
            <p></p>
            <!-- Форма регистрации  -->
            <b-form @submit="onSubmit" @reset="onReset" v-if="show">
              <b-card-header header-bg-variant="secondary" header-text-variant="white" header-tag="header">
                  Регистрация
                  <i class="fas fa-user-plus"></i>
              </b-card-header>
            <p></p>

              <!-- Имя пользователя -->
              <b-form-group id="inputUserNameGroup"

                    label-for="inputUserName"
                    description="Имя пользователя должно содержать, как минимум 3 буквы">
                    <b-form-input id="inputUserName"
                        type="text"
                        v-model.trim="form.username"
                        required
                        placeholder="Введите имя пользователя">
                    </b-form-input>
              </b-form-group>

              <!-- Пароль -->
              <b-form-group id="inputPasswordGroup"
                    label="Придумайте пароль:"
                    label-for="inputPassword"
                    description="Пароль должен состоять из ...">
                    <b-form-input id="inputPassword"
                      type="password"
                      v-model.trim="form.password"
                      required
                      placeholder="Введите пароль">
                    </b-form-input>
                    <b-form-input id="inputRePassword"
                      type="password"
                      v-model.trim="form.repassword"
                      required
                      placeholder="Повторите пароль">
                    </b-form-input>
              </b-form-group>

              <!-- e-mail -->
              <b-form-group id="inputEmailGroup"
                    label="Введите e-mail:"
                    label-for="inputEmail">
                    <b-form-input id="inputEmail"
                      type="email"
                      v-model="form.email"
                      required
                      placeholder="Введите e-mail">
                    </b-form-input>
              </b-form-group>

              <!-- Фамилия и имя -->
              <b-form-group id="inputFirstLastNameGroup"
                    label="Введите вашу Фамилию и Имя"
                    label-for="inputFirstLastName"
                    description="Поля Фамилия и Имя можно оставить пустыми">
                    <b-form-input id="inpurtFirstName"
                      type="text"
                      v-model.trim="form.firstName"
                      placeholder="Введите имя">
                    </b-form-input>
                    <b-form-input id="inputLastName"
                      type="text"
                      v-model.trim="form.lastName"
                      placeholder="Введите фамилию">
                    </b-form-input>
              </b-form-group>


              <b-form-group id="inputSexGroup"
                    label="Ваш пол:"
                    label-for="inputSex">
                    <b-form-select id="exampleInput3"
                        :options="sex"
                        v-model="form.sex">
                    </b-form-select>
              </b-form-group>

            <!-- </b-form> -->
            <b-card-footer footer-bg-variant="secondary" footer-border-variant="dark">
            </b-form-group>
               <b-button-group >
                 <b-button type="reset" variant="secondary">
                   <span style='padding-left:30px;'></span>
                      Сбросить введенные данные <i class="fas fa-redo-alt"></i>
                    <span style='padding-left:30px;'></span></b-button>
                 <b-button type="submit" variant="secondary">
                    <span style='padding-left:30px;'></span>
                      Подтвердить <i class="fas fa-check"></i>
                    <span style='padding-left:30px;'></span>
                  </b-button>
                  </b-button-group>
              </b-card-footer>
              </b-form>
            </div>
          </b-col>
          <b-col>
            <b-row>
              <b-container fluid class="p-4">
                <b-row>
                  <b-col cols="2"></b-col>
                  <b-col cols="9">
                    <h1>
                      <b-img thumbnail fluid :src="require('../../assets/1.jpg')" width="500" height="300" alt="Thumbnail" />
                    </h1>
                  </b-col>
                  <b-col cols="1"></b-col>
                </b-row>
                <b-row>
                  <b-col cols="2"></b-col>
                  <b-col cols="9">
                    <h1>
                      <b-img thumbnail fluid :src="require('../../assets/2.jpg')" width="500" height="300" alt="Thumbnail" />
                    </h1>
                  </b-col>
                  <b-col cols="1"></b-col>
                </b-row>
                <b-row>
                  <b-col cols="2"></b-col>
                  <b-col cols="9">
                    <h1>
                      <b-img thumbnail fluid :src="require('../../assets/3.jpg')" width="500" height="300" alt="Thumbnail" />
                    </h1>
                  </b-col>
                  <b-col cols="1"></b-col>
                </b-row>
              </b-container>
            </b-row>
          </b-col>
        </b-row>
      </b-container>
      <br>
      </b-container>
      <!-- ADD FOOTER -->
      <footerone/>
  </div>
</template>

<script>
import router from '../../router'
import axios from 'axios'
import VueAxios from 'vue-axios'
import footerone from '../footerone'
export default {
  data () {
    return {
      form: {
        username: '',
        password: '',
        repassword: '',
        email: '',
        firstName: '',
        lastName: ''
      },
      sex: [
        { text: 'Выбирите пол'},
        'm', 'f'],
      show: true,

      userInfo : {
        userId: 0,
        userName: ''
      }
    }
  },
  methods: {
    onSubmit (evt) {
      evt.preventDefault();
      window.localStorage.setItem('STORAGE_USER_INFO', JSON.stringify(this.userInfo));
      axios.post("/register", this.form)
      .then(response => {

        if (response.status === 200) {
          this.userInfo.userId = response.data.id;
          window.localStorage.setItem('STORAGE_USER_INFO', JSON.stringify(this.userInfo));
          router.push({ path: 'profile' });
          console.log(response);
        }

      }).catch(function (error) {
        alert("Error...");
        console.log(error);
      });
      //this.show = false; //скрыть после отправки данных
    },
    onReset (evt) {
      evt.preventDefault();
      /* Reset our form values */
      this.form.username = '';
      this.form.password = '';
      this.form.repassword = '';
      this.form.email = '';
      this.form.firstName = '';
      this.form.lastName= '';
      this.form.sex = this.sex.text;
      /* Trick to reset/clear native browser form validation state */
      this.show = false;
      this.$nextTick(() => { this.show = true });
    }
  },

  components: {
    footerone
  },
  router
}
</script>

<style lang="css">
.background {
  background-image: url("../../assets/6.jpg");
  background-size: cover;

}

.gridFullPage {
  margin-top: -4px;
  /* position: fixed; */
  /* background-color: #DCDCDC; */
  background-image: url("../../assets/background_profile.jpg");
  background-size: cover;
  background-attachment: fixed;
  background-repeat: no-repeat;
  background-position: top;
}

.pic1 {
  background-image: url("../../assets/1.jpg");
  background-size: cover;

}
.pic2 {
  background-image: url("../../assets/2.jpg");
  /* background-size: cover; */

}
.pic3 {
  background-image: url("../../assets/3.jpg");
  /* background-size: cover; */

}
</style>

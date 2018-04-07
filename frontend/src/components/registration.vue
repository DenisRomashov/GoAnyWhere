<template>
  <div class="registration">

    <b-container class="gridFullPage">
      <b-row>
        <b-col>
          <b-navbar toggleable="md" type="dark" variant="dark" fixed="top">

            <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>


            <b-navbar-brand href="#">GoAnyWhere</b-navbar-brand>

            <b-navbar-nav>
              <router-link :to="{ path: '/' }"><b-button size="" variant="outline-danger" class="my-2 my-sm-0" type="submit">Home</b-button></router-link>
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
              <!-- Имя польщователя -->
              <b-form-group id="inputUserNameGroup"
                    label="Имя пользователя:"
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
                    label="Введите пароль:"
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
                      v-model.trim="form.firstname"
                      placeholder="Введите имя">
                    </b-form-input>
                    <b-form-input id="inputLastName"
                      type="text"
                      v-model.trim="form.lastname"
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

              <b-button type="submit" variant="primary">Подтвердить</b-button>
              <b-button type="reset" variant="danger">Сбросить введенные данные</b-button>
    </b-form>
  </div>
</b-col>
        <b-col>
          <p></p>
          <h1>Здесь что-то будет</h1>
          <p>|</p>
          <p>|</p>
          <p>|</p>
          <p>|</p>
          <p>|</p>
          <p>|</p>
          <p>|</p>
          <p>|</p>
          <p>|</p>
          <p>|</p>
          <p>|</p>
          <p>|</p>
          <p>|</p>
          <p>|</p>
        </b-col>

    </b-row>
  </b-container>
  </div>
</template>

<script>
export default {
  data () {
    return {
      form: {
        username: '',
        password: '',
        repassword: '',
        email: '',
        firstname: '',
        lastname: ''
      },
      sex: [
        { text: 'Выбирите пол'},
        'male', 'female'],
      show: true
    }
  },
  methods: {
    onSubmit (evt) {
      evt.preventDefault();
      alert(JSON.stringify(this.form));
      console.log(JSON.stringify(this.form));
      //this.show = false; //скрыть после отправки данных
    },
    onReset (evt) {
      evt.preventDefault();
      /* Reset our form values */
      this.form.username = '';
      this.form.password = '';
      this.form.repassword = '';
      this.form.email = '';
      this.form.firstname = '';
      this.form.lastname= '';
      this.form.sex = null;
      /* Trick to reset/clear native browser form validation state */
      this.show = false;
      this.$nextTick(() => { this.show = true });
    }
  }
}
</script>

<style lang="css">
</style>

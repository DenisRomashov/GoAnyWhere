<template lang="html">
  <div class="profile">
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
    <br>
    <b-container fluid class="formpage">
      <b-card header="Иформация профиля"
              header-text-variant="white"
              header-tag="header"
              header-bg-variant="dark"
      >

      <b-row>
        <b-col>
          <div class="usernameinput">
            <b-input-group >
                <b-input-group-prepend>
                    <b-btn  variant="danger">Username <i class="fa fa-user"></i></b-btn>
                </b-input-group-prepend>

                <b-form-input  :disabled="editform"></b-form-input>

            </b-input-group>
          </div>
        </b-col>
      </b-row>
      <br>
      <b-row>
        <b-col>
          <div class="userfirstname">
            <b-input-group >
                <b-input-group-prepend>
                    <b-btn variant="dark"> Имя </b-btn>
                </b-input-group-prepend>

                <b-form-input  :disabled="editform"></b-form-input>

            </b-input-group>
          </div>
        </b-col>
        <b-col>
          <div class="userlastname">
            <b-input-group >
                <b-input-group-prepend>
                    <b-btn variant="dark"> Фамилия </b-btn>
                </b-input-group-prepend>

                <b-form-input  :disabled="editform"></b-form-input>

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
                    <b-btn variant="dark"> ПОЛ </b-btn>
                </b-input-group-prepend>

                <b-form-input  :disabled="editform"></b-form-input>

            </b-input-group>
          </div>
        </b-col>
        <b-col>
          <div class="bithdate">
            <b-input-group >
                <b-input-group-prepend>
                    <b-btn variant="dark"> Дата рождения </b-btn>
                </b-input-group-prepend>

                <b-form-input  :disabled="editform"></b-form-input>

            </b-input-group>
          </div>
        </b-col>
      </b-row>
        </b-card>
        <b-card-footer footer-bg-variant="dark" footer-border-variant="dark">
       <b-btn @click="editform=!editform" variant="outline-danger"> Редактировать данные </b-btn>
     </b-card-footer>
    </b-container>


    <br>

    <div>
  <b-card header="Контактные данные"
          header-text-variant="white"
          header-tag="header"
          header-bg-variant="dark"
          footer="Card Footer"
          footer-tag="footer"
          footer-bg-variant="warning"
          footer-border-variant="dark"
          title="Контактные данные"
          style="max-width: 100rem;"
  >

  <div class="bithdate">
    <b-input-group >
        <b-input-group-prepend>
            <b-btn variant="dark"> Дата рождения </b-btn>
        </b-input-group-prepend>

        <b-form-input  :disabled="editform"></b-form-input>

    </b-input-group>
  </div>

  </b-card>
</div>


    <b-button v-on:click="editform=!editform" variant="dark">Edit</b-button>





    <!-- test variable -->
    <h1>{{ create }}</h1>
  </div>
</template>

<script>
import axios from 'axios'
import router from '../../../router'
export default {
  data () {
    return {
      form: {

      },

      create: ' [ Empty.. ]',
      editform: true
    }
  },
  methods: {

  },

  created: function () {
    var storageInfo = JSON.parse(window.localStorage.getItem('STORAGE_USER_INFO'));
    if (storageInfo.userId != 0) {
      axios.get("/user?id="+storageInfo.userId)
      .then(response => {
         //this.create = response.data.userContact.email;
         this.create = response.data;
      }).catch(function (error) {
        alert("Error...");
        console.log(error);
      });
    } else {
      alert("Вы не вошли!");
      router.push({ path: '/' })
    }
  },
  router

}
</script>

<style lang="css">


</style>

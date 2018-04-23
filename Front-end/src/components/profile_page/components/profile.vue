<template lang="html">
  <div class="profile">
    <h1>Profile.vue</h1>

    <div>
  <b-input-group prepend="Username">
    <b-form-input :disabled="editform"></b-form-input>
    <b-dropdown text="Dropdown" variant="success" slot="append">
      <b-dropdown-item>Action A</b-dropdown-item>
      <b-dropdown-item>Action B</b-dropdown-item>
    </b-dropdown>
  </b-input-group>
    <br>
    <b-button v-on:click="editform=!editform" variant="dark">Edit</b-button>

</div>



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
      create: ' [ Empty.. ]',
      editform: true
    }
  },
  methods: {

  },
/*
  created: function () {
    var storageInfo = JSON.parse(window.localStorage.getItem('STORAGE_USER_INFO'));
    if (storageInfo.userId != 0) {
      axios.get("/user?id="+storageInfo.userId)
      .then(response => {
         //this.create = response.data.userContact.email;
         this.create = response;
      }).catch(function (error) {
        alert("Error...");
        console.log(error);
      });
    } else {
      router.push({ path: '/' })
    }
  },*/
  router

}
</script>

<style lang="css">
</style>

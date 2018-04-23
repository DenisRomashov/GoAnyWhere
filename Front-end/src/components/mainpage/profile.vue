<template lang="html">
  <div class="profile">
    <h1>Profile.vue</h1>





    <!-- test variable -->
    <h1>{{ create }}</h1>
  </div>
</template>

<script>
import axios from 'axios'
import router from '../../router'
export default {
  data () {
    return {
      create: ' [ Empty.. ]'
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
         this.create = response;
      }).catch(function (error) {
        alert("Error...");
        console.log(error);
      });
    } else {
      router.push({ path: '/' })
    }
  },
  router

}
</script>

<style lang="css">
</style>

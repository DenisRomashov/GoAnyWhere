<template lang="html">
  <div class="">
    <h1>Profile.vue</h1>
      <b-button v-on:click="testGet()" variant="dark">TEST</b-button>
    <h1>{{ create }}</h1>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  data () {
    return {
      create: ' [ Empty.. ]'
    }
  },
  methods: {

    // Тест Get запроса, возврат данных по id
    testGet() {
      axios.get("/user?id=17")
      .then(response => {
         this.create = response;
      }).catch(function (error) {
        alert("Error...");
        console.log(error);
      });
    }
  }
}
</script>

<style lang="css">
</style>

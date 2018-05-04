<template lang="html">
  <div class="myMeetings">



  <h1>myMeetings.vue</h1>
  <br>
  <h5>{{ meetings }}</h5>
  <br>

  </div>
</template>

<script>
import axios from 'axios'
export default {
  data () {
    return {
      meetings: []
    }
  },
  methods: {

  },
    created: function () {
      axios.get("/meeting/user?id=2")
      .then(response => {

        if (response.status === 200) {
          this.meetings = response.data;
          console.log(response);
        }

      }).catch(function (error) {
        alert("Error...");
        console.log(error);
      });
    }
}
</script>

<style lang="css">
</style>

<template lang="html">
  <div class="">

  <h1>-------------meeting template-----------</h1>
  <!-- <b-button  variant="danger" href="" >
      Редактировать пост
  </b-button> -->
  <button  v-on:click="meetingChange(index)">Change</button>
  <h2>{{ meeting.name}} -- index is {{ index }}</h2>
  <h3>{{ meeting.description }}</h3>

  <b-form-input  v-model="meeting.name"
  type="text"
></b-form-input>



  </div>
</template>

<script>
export default {
    props: ['meeting', 'index'],
    data() {
      return{

      }
    },

     computed: {},
     
    methods: {
      meetingChange: function(index){
            this.$emit('meetingchange', index);
        }
    }
}
</script>

<style lang="css">
</style>

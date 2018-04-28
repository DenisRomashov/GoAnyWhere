<template lang="html">
<div class="createMeeting">
  <div class="startCreate">

    <div>
  <b-card overlay
          :img-src="require('../../../assets/creation_meeting_background.jpg')"
          img-alt="Card Image"
          text-variant="white"
          title="Организовать новый Meetup"
          sub-title="Subtitle">
    <p class="card-text">
      Some quick example text to build on the card and make
      up the bulk of the card's content.
    </p>

    <h1>Мы поможем вам найти подходящих людей.</h1>
    <br>
    <br>
      <b-button-group size="lg">
      <b-button>Left</b-button>
      <b-button>Middle</b-button>
      <b-button>Right</b-button>
    </b-button-group>
  </b-card>
</div>


  </div>

</div>
</template>

<script>
import axios from 'axios'
export default {
  data () {
    return {
    }
  },
  methods: {
  }
}
</script>

<style lang="css">
.startCreate {

}
</style>

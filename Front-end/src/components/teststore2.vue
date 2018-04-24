<template lang="html">
  <div class="test">
    <h1>STORE 2</h1>
    <h1>{{ qwe }}</h1>
    <h2>{{ fromStore }}</h2>
    <!-- <b-button v-on:click="test()" variant="dark">ADD to STORE</b-button> -->
    <b-button v-on:click="show()" variant="dark">Show FromStore</b-button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      qwe: 0,
      fromStore: 'EMPTY'
    }
  },

  // computed: {
  //   count() {
  //     return this.$store.state.count
  //   }
  // },

  methods: {


    show () {
      this.fromStore = this.$store.getters.getCount.count
    }
  },

  // created: function () {
  //   this.count = this.$store.getters.countState
  // }
}
</script>

<style lang="css">
</style>

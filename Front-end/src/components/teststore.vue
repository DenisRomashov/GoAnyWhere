<template lang="html">
  <div class="test">
    <h1>STORE 1</h1>
    <h1>{{ test }}</h1>
    <!-- <h2>{{ fromStore }}</h2> -->
    <b-button v-on:click="addstore()" variant="dark">ADD to STORE</b-button>
    <!-- <b-button v-on:click="show()" variant="dark">Show FromStore</b-button> -->
  </div>
</template>

<script>
export default {
  data() {
    return {
      test: 0
    }
  },

  // computed: {
  //   count() {
  //     return this.$store.state.count
  //   }
  // },

  methods: {
    addstore() {
      this.$store.commit('increment');
      this.test = this.$store.getters.getCount.count;
    }
  },

  // created: function () {
  //   this.count = this.$store.getters.countState
  // }
}
</script>

<style lang="css">
</style>

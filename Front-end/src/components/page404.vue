<template lang="html">
  <div class="">
    <h1>404!</h1>

    <h1>OOOPPPSSS!!!!</h1>

    <h2>У нас нет такой страницы :( </h2>
    <div>
      <router-link :to="{ path: '/' }"><b-button size="lg" variant="warning">Пошли на главную!</b-button></router-link>
    </div>
  </div>
</template>

<script>
export default {
}
</script>

<style lang="css">
</style>

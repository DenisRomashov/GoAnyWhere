<template lang="html">
  <div class="notfound">
    <div class="block">
    <h1>404!</h1>

    <h1>OOOPPPSSS!!!!</h1>

    <h2>У нас нет такой страницы :( </h2>
    <div>
      <router-link :to="{ path: '/' }"><b-button size="lg" variant="warning">Пошли на главную!</b-button></router-link>
    </div>
    </div>
  </div>
</template>

<script>
export default {
}
</script>

<style lang="css">
.notfound {
  margin: -60px;
  height: 850px;
  background-image: url("../../assets/404_background.jpg");
  background-size: cover;
}

.block {
    width: 250px;
    height: 250px;
    position: absolute;
    top: 50%;
    left: 50%;
    margin: -125px 0 0 -125px;
}
</style>

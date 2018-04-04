<template>
  <div>
    <b-navbar toggleable="md" type="dark" variant="dark" fixed="top">
      <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>


        <b-navbar-brand href="#">GoAnyWhere</b-navbar-brand>

      <b-button size="" variant="outline-danger">О нас</b-button>

      <!-- Right aligned nav items -->
      <b-navbar-nav class="ml-auto">


        <div>
          <b-form inline>
            <label class="sr-only" for="inlineInputUsername">Username</label>
              <b-input class="xs-2 mr-sm-2 mb-sm-0" id="inlineInputUsername" placeholder="Username" />
            <label class="sr-only" for="inlineInputPassword">Password</label>
              <b-input-group left="@" class="mb-2 mr-sm-2 mb-sm-0">
                  <b-input id="inlineInputPassword" placeholder="Password" />
              </b-input-group>
                <b-button size="" variant="outline-primary">Войти</b-button>
                <router-link :to="{ path: 'registration' }">
                  <b-button size="" variant="outline-danger">Регистрация</b-button>
                </router-link>

              </b-form>
            </div>
        </b-navbar-nav>
    </b-navbar>
    <!--Добавление карусели с помощью компонента carousel-->
    <carousel/>
    <!-- /////////////////////////////////////////////// -->

  </div>
</template>

<script>
import Carousel from './Carousel'
export default {
  components: {
    Carousel
  }
}
</script>

<style lang="css">

</style>

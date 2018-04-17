<template lang="html">
  <div class="personalPage">
    <b-container class="gridFullPage">
      <b-row>
        <b-col>
          <b-navbar toggleable="md" type="dark" variant="dark" fixed="top">

            <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>


            <b-navbar-brand href="/">GoAnyWhere</b-navbar-brand>

            <!-- Кнопка HOME с роутер линк на главную страницу -->
            <b-navbar-nav>
              <router-link :to="{ path: '/' }"><b-button size="" variant="outline-danger" class="my-2 my-sm-0" type="submit">Home</b-button></router-link>
            </b-navbar-nav>

            <b-collapse is-nav id="nav_collapse"></b-collapse>

            <!-- Right aligned nav items -->
            <b-navbar-nav class="ml-auto">

              <b-nav-form>
                <b-form-input size="sm" class="mr-sm-2" type="text" placeholder="Поиск" />
                <b-button size="sm" class="my-2 my-sm-0" type="submit" variant="warning"> Поиск </b-button>
              </b-nav-form>

              <!-- <div>
                <b-dropdown id="ddown-split" split text="Профиль" class="s-2" size="sm" variant="outline-danger">
                  <b-dropdown-item href="#"> Создать событие </b-dropdown-item>
                  <b-dropdown-item href="#"> Посмотреть </b-dropdown-item>
                  <b-dropdown-item href="#"> Выйти </b-dropdown-item>
                </b-dropdown>
              </div> -->

            </b-navbar-nav>

            <!-- сюда дропдаун  -->

            <div>
              <b-dropdown id="ddown-split" split text="Профиль" class="s-2" size="sm" variant="outline-danger">
                <b-dropdown-item href="#"> Создать событие </b-dropdown-item>
                <b-dropdown-item href="#"> Ваши События </b-dropdown-item>
                <b-dropdown-item href="#"> Созданные события </b-dropdown-item>
                <b-dropdown-item href="#"> Выйти </b-dropdown-item>
              </b-dropdown>
            </div>
          </b-navbar>




        </b-col>
    </b-row>
  </b-container>
  </div>
</template>

<script>
export default {

}
</script>

<style lang="css">
</style>

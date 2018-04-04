<template>
  <div class="registration">
    <b-container class="bv-example-row">
      <b-row>
        <b-col>
          <b-navbar toggleable="md" type="dark" variant="danger" fixed="top">

            <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>


            <b-navbar-brand href="#">GoAnyWhere</b-navbar-brand>

            <b-navbar-nav>
              <router-link :to="{ path: '/' }"><b-button size="sm" class="my-2 my-sm-0" type="submit">Search</b-button></router-link>
              <b-nav-item href="#" disabled>Disabled</b-nav-item>
            </b-navbar-nav>

            <b-collapse is-nav id="nav_collapse"></b-collapse>
          </b-navbar>
        </b-col>
    </b-row>
    <b-row>
        <b-col>1 of 3</b-col>
        <b-col>2 of 3</b-col>
        <b-col>3 of 3</b-col>
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

<template lang="html">
  <div class="personalPage">
    <b-container class="gridFullPage">
      <b-row>
        <b-col>
          <b-navbar toggleable="md" type="dark" variant="dark" fixed="top">

            <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>


            <b-navbar-brand href="/">GoAnyWhere</b-navbar-brand>

            <b-navbar-nav>
              <router-link :to="{ path: '/' }"><b-button size="" variant="outline-danger" class="my-2 my-sm-0" type="submit">Home</b-button></router-link>
            </b-navbar-nav>

            <b-collapse is-nav id="nav_collapse"></b-collapse>

            <!-- Right aligned nav items -->
            <b-navbar-nav class="ml-auto">

              <b-nav-form>
                <b-form-input size="sm" class="mr-sm-2" type="text" placeholder="Search"/>
                <b-button size="sm" class="my-2 my-sm-0" type="submit">Search</b-button>
              </b-nav-form>
            </b-navbar-nav>

            <b-nav-item-dropdown right>
        <!-- Using button-content slot -->
            <template slot="button-content">
              <em>{{  }}</em>
            </template>
            <b-dropdown-item href="#">Profile</b-dropdown-item>
            <b-dropdown-item href="#">Signout</b-dropdown-item>
            </b-nav-item-dropdown>


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

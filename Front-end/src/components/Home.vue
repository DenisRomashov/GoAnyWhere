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



<div>
   <b-carousel id="carousel1"
               style="text-shadow: 1px 1px 2px #333;"
               controls
               indicators
               background="#ababab"
               :interval="4000"
               img-width="1024"
               img-height="480"
               v-model="slide"
               @sliding-start="onSlideStart"
               @sliding-end="onSlideEnd"
   >

     <!-- Text slides with image -->
     <b-carousel-slide caption="First slide"
                       text="Nulla vitae elit libero, a pharetra augue mollis interdum."
                       img-src="https://lorempixel.com/1024/480/technics/2/"
     ></b-carousel-slide>

     <!-- Slides with custom text -->
     <b-carousel-slide img-src="https://lorempixel.com/1024/480/technics/4/">
       <h1>Hello world!</h1>
     </b-carousel-slide>

     <!-- Slides with image only -->
     <b-carousel-slide img-src="https://lorempixel.com/1024/480/technics/8/">
     </b-carousel-slide>

     <!-- Slides with img slot -->
     <!-- Note the classes .d-block and .img-fluid to prevent browser default image alignment -->
     <b-carousel-slide>
       <img slot="img" class="d-block img-fluid w-100" width="1024" height="480"
            src="../assets/pic.jpg" alt="image slot">
     </b-carousel-slide>

     <!-- Slide with blank fluid image to maintain slide aspect ratio -->
     <b-carousel-slide caption="Blank Image" img-blank img-alt="Blank image">
       <p>
         Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse
         eros felis, tincidunt a tincidunt eget, convallis vel est. Ut pellentesque
         ut lacus vel interdum.
       </p>
     </b-carousel-slide>

   </b-carousel>

   <p class="mt-4">
     Slide #: {{ slide }}<br>
     Sliding: {{ sliding }}
   </p>

 </div>

  </div>
</template>

<script>
export default {
  data () {
    return {
      slide: 0,
      sliding: null
    }
  },
  methods: {
    onSlideStart (slide) {
      this.sliding = true
    },
    onSlideEnd (slide) {
      this.sliding = false
    }
  }
}
</script>

<style lang="css">

</style>

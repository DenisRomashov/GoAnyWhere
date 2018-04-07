<template>
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
      <b-carousel-slide caption="GoAnyWhere - Click & Meet"
                        text="Найди то, что тебе по душе!"
                        class="slide1"
                        img-blank img-alt="Blank image">
                        <router-link :to="{ path: 'registration' }">
                            <b-button size="" variant="danger">Регистрация</b-button>
                        </router-link>
      </b-carousel-slide>

      <!-- Slides with custom text -->
      <b-carousel-slide img-blank img-alt="Blank image" class="slide2">
        <h1>GoAnyWhere Project 2018 ©</h1>
        <h3>Делай, учись, делись, меняй (do, learn, share, change)</h3>
      </b-carousel-slide>

      <!-- Slides with image only -->
      <b-carousel-slide img-blank img-alt="Blank image" class="slide3" >
      </b-carousel-slide>

      <!-- Slide with blank fluid image to maintain slide aspect ratio -->
      <b-carousel-slide caption="Делай что-нибудь" img-blank img-alt="Blank image" class="slide4" >
        <p>
          Это значит, что нельзя сидеть на месте и ждать, пока другой реализует интересную идею,
          родившуюся у тебя в голове. Какой бы сумасбродной ни была мысль – делись ею, ищи единомышленников,
          думайте как реализовать ее, встречайтесь, организовывайте.
          Самое главное – это понять, что ты не одинок и в любом случае найдутся люди, готовые тебя поддержать.
        </p>
      </b-carousel-slide>

    </b-carousel>

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
.slide1 {
  background-image: url("../assets/1.jpg");
  background-size: cover;

}
.slide2 {
  background-image: url("../assets/2.jpg");
  background-size: cover;

}
.slide3 {
  background-image: url("../assets/3.jpg");
  background-size: cover;

}
.slide4 {
  background-image: url("../assets/4.jpg");
  background-size: cover;

}
</style>

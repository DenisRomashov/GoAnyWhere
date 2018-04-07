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
                        img-src="https://lorempixel.com/1024/480/technics/2/"
      ></b-carousel-slide>

      <!-- Slides with custom text -->
      <b-carousel-slide img-src="https://lorempixel.com/1024/480/technics/4/">
        <h1>GoAnyWhere Project 2018 ©</h1>
        <h3>Делай, учись, делись, меняй (do, learn, share, change)</h3>
      </b-carousel-slide>

      <!-- Slides with image only -->
      <b-carousel-slide img-src="https://lorempixel.com/1024/480/technics/8/">
      </b-carousel-slide>

      <!-- Slides with img slot -->
      <!-- Note the classes .d-block and .img-fluid to prevent browser default image alignment -->
      <b-carousel-slide>
        <img slot="img" class="d-block img-fluid w-100" width="1024" height="480"
             src="https://lorempixel.com/1024/480/technics/5/" alt="image slot">
      </b-carousel-slide>

      <!-- Slide with blank fluid image to maintain slide aspect ratio -->
      <b-carousel-slide caption="Делай что-нибудь" img-blank img-alt="Blank image">
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

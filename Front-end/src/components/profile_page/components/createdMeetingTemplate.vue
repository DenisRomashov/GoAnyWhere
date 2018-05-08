<template lang="html">
  <div class="meeting">


    <b-card  bg-variant="white" text-variant="dark">
        <b-row>
          <b-col cols="" md="auto">
          <h5>{{ meeting.name}}</h5>
          <p>
            <b-badge variant="danger">
              Категория: {{ meeting.categoryId }}
            </b-badge>
            <b-badge variant="warning">
              Дата: {{ meeting.startTime }}
            </b-badge>
          </p>
          </b-col>
          <b-col>
          </b-col>
          <b-col cols="">
            <div>
              <b-button-group vertical size="sm">
                <b-button variant="dark">Редактировать</b-button>
                <b-button variant="dark">Удалить</b-button>
              </b-button-group>
            </div>
          </b-col>
        </b-row>

        <b-row>
          <b-col>


              <b-btn block @click="showCollapse = !showCollapse"
                  :class="showCollapse ? 'collapsed' : null"
                  aria-controls="collapse4"
                  :aria-expanded="showCollapse ? 'true' : 'false'">
                  Детали события
              </b-btn>
              <b-collapse class="mt-2" v-model="showCollapse" id="collapse4">
              <b-card>
                <p>Описание: {{ meeting.description }}</p>
                <p class="card-text">
                  Адрес: {{ meeting.meetingAddress.locality}}, {{meeting.meetingAddress.street}}, {{meeting.meetingAddress.house}}
                </p>
                <p>  Максимальное количество участников: {{ meeting.maxParticipants }}</p>
                <p> Минимальный возвраст: {{ meeting.minAge }}</p>
              </b-card>
              </b-collapse>

          </b-col>
        </b-row>


      </b-card>
  </div>

</template>

<script>
export default {
  props: ['meeting', 'index'],
  data() {
    return {
      showCollapse: false,
      description: "Мы пойдем на шашлыки!",
      counter:2,
      max: 10,
      name: "Шашлыки у дяди Феди",
      text: "Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon"

    }
  },

  methods: {
    meetingChange: function(index){
          this.$emit('meetingchange', index);
      }
  }
}
</script>

<style lang="css">
</style>

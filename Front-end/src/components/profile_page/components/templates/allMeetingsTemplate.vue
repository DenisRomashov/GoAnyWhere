<template lang="html">
  <div class="meeting">


    <b-card  bg-variant="white" text-variant="dark" v-show="true">
        <b-row>
          <b-col sm="8">
            <div class="" align="left">

              <h5>{{ meeting.name}} <b-badge variant="secondary"> Участников: {{meeting.numberOfParticipants}}/{{ meeting.maxParticipants }} </b-badge> </h5>

              <p>
                  <b-badge variant="danger">
                    Категория: {{ category[meeting.categoryId - 1].text }}
                  </b-badge>
                  <b-badge variant="warning">
                    <!-- <b-form-input size="sm" v-model="meeting.startTime"
                            type="date"
                            disabled

                          ></b-form-input> -->
                Дата: {{ meeting.startTime }}
                </b-badge>
            </p>
          </div>
          </b-col>
          <b-col sm="4">
            <div>
              <b-button-group vertical size="">
                <b-button variant="warning" v-on:click="unSubscribe(index)">Присоединиться к событию!</b-button>
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

      <!-- <b-modal v-model="showEditingMeeting" centered size="lg" title="Large Modal">
        Hello Modal!
      </b-modal> -->

  </div>

</template>

<script>
export default {
  props: ['meeting', 'index'],
  data() {
    return {
      showCollapse: false,
      showEditingMeeting: false,
      category: [
        { value: '1', text: 'Активный отдых и приключения' },
        { value: '2', text: 'Еда и напитки' },
        { value: '3', text: 'Здоровье' },
        { value: '4', text: 'Карьера и бизнес'},
        { value: '5', text: 'Мода и красота'},
        { value: '6', text: 'Хобби'},
        { value: '7', text: 'Технологии'},
        { value: '8', text: 'Язык и культура'},
        { value: '9', text: 'Спорт'},
        { value: '10', text: 'Музыка'},
        { value: '11', text: 'Домашние животные'},
        { value: '12', text: 'Искусство'},
        { value: '13', text: 'Семья'},
        { value: '14', text: 'Музыка'},
        { value: '15', text: 'Кино'},
        { value: '16', text: 'Фотография'},
        { value: '17', text: 'Танцы'},
        { value: '18', text: 'Книги'},
        { value: '19', text: 'Другое'},
      ]
    }
  },

  methods: {
    unSubscribe: function(index){
      this.$emit('unSubscribe', index);
    }
  }
}
</script>

<style lang="css">
</style>

<template lang="html">
<div class="createMeeting">

  <div class="startCreate" v-if="showStartCreate">
        <b-card overlay
            :img-src="require('../../../assets/13.jpg')"
            img-alt="Card Image"
            text-variant="white">

            <div class="cardTitle">
              <h1>Организовать новое Событие</h1>
              <h2>Мы поможем вам найти подходящих людей :)</h2>
              <br>
               <b-button @click="showStartCreate=false, showNewMeeting=true" size="lg"  variant="danger" href="">
                  <span style='padding-left:50px;'></span>
                    Создать событие
                   <span style='padding-left:50px;'></span>
               </b-button>

            </div>
          </b-card>
  </div>

  <div class="newMeeting" v-if="showNewMeeting">

      <b-container fluid class="meetingInfo">
        <div class="profileInfodiv">
          <br>
            <b-card-header header-bg-variant="danger" header-text-variant="white" header-tag="header">
              <h5>Создание события <i class="fas fa-plus"></i></h5>
            </b-card-header>
          </div>
          <br>
          <b-row>
            <b-col class="firstLeftColumn" cols="8">
              <b-card>
                <b-row>
                  <b-col cols="4">
                    <!-- <b-img rounded="circle" :src="require('../../../assets/1.jpg')"  blank width="150" height="150"  alt="img" class="m-1" /> -->
                    <!-- <b-img rounded blank :src="require('../../../assets/1.jpg')" alt="Thumbnail" /> -->
                    <b-img rounded="circle" :src="srcImage" width="200" height="200" alt="img" class="m-1" />

                   </b-col>
                  <b-col cols="8">
                      <br>
                      <br>
                      <br>
                      <div class="meetingName">
                        <b-input-group size="lg" >
                            <b-input-group-prepend>
                                <b-btn  variant="danger">Название: </i></b-btn>
                            </b-input-group-prepend>

                            <b-form-input  v-model.trim="form.meetingName"
                            type="text"
                            placeholder="Введите название события"
                            ></b-form-input>
                        </b-input-group>



                      </div>

                  </b-col>
                </b-row>
                <br>
                <b-row>

                  <b-col>
                    <h5>Краткое описание:</h5>
                    <b-form-textarea
                      v-model="form.description"
                      placeholder="Напишите о чем ваша встреча"
                      :rows="3"
                      :max-rows="6">
                   </b-form-textarea>

                   </b-col>
                </b-row>
              </b-card>
            </b-col>

            <b-col cols="4">
              <b-card>
                <h5>Выбирите категорию:</h5>
                <b-button-group vertical>
                  <b-button>Top</b-button>
                  <b-button>Middle</b-button>
                  <b-button>Bottom</b-button>
                </b-button-group>
              </b-card>
            </b-col>
          </b-row>
          <br>
            <b-card-footer footer-bg-variant="dark" footer-border-variant="dark">
                <b-button-group >
                <b-button>Left</b-button>
                <b-button>Middle</b-button>
                <b-button>Right</b-button>
              </b-button-group>
            </b-card-footer>
      </b-container>

<br>

  </div>

</div>
</template>

<script>
import axios from 'axios'
export default {
  data () {
    return {
      form: {
        meetingName: '',
        description: ''
      },
      showStartCreate: true,
      showNewMeeting: false,
      srcImage: require('../../../assets/square.jpg')

    }
  },
  methods: {
  }
}
</script>

<style lang="css">
.startCreate {
  margin-top: -7px;
  margin-right: -17px;
  margin-left: -17px;

  /* min-width: 360px;
  min-height: 360px; */
}

.cardTitle {
  position: relative;
  margin-top: 15%;
}




</style>
